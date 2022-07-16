package com.github.will11690.mechanicraft.blocks.machines.tier5.t5slurryprocessor;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.blocks.machines.tier1.t1slurryprocessor.T1SlurryProcessor;
import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.fluid.MechanicraftFluidTank;
import com.github.will11690.mechanicraft.init.ModConfigs;
import com.github.will11690.mechanicraft.init.ModItems;
import com.github.will11690.mechanicraft.init.ModRecipes;
import com.github.will11690.mechanicraft.recipes.SlurryProcessor.SlurryRecipes;
import com.github.will11690.mechanicraft.util.capabilities.factory.UpgradeMachineHandlerFactory;
import com.github.will11690.mechanicraft.util.capabilities.interfaces.IUpgradeMachineHandler;
import com.github.will11690.mechanicraft.util.handlers.NonExtractableStackHandler;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;
import com.google.common.collect.Iterables;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

public class TileEntityT5SlurryProcessor extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

	//TODO Clean this up and assign ItemStackHandlers via CombinedInvWrapper instead of per slot
	
	private MechaniCraftEnergyStorage energyStorage = createEnergy();
	UpgradeMachineHandlerFactory upgradeHandler = createUpgradeHandler();
	
	private MechanicraftFluidTank inputFluidTank1 = createInputFluidTank1();
	private MechanicraftFluidTank inputFluidTank2 = createInputFluidTank2();
	private MechanicraftFluidTank outputFluidTank = createOutputFluidTank();
	
	private ItemStackHandler outputSlotHandler = createOutput();
	
	ItemStackHandler upgradeSlotHandler = createUpgrade();
    private ItemStackHandler upgradeSlotHandlerWrapper = createUpgradeWrapper(upgradeSlotHandler);
    
	private ItemStackHandler chargeSlotHandler = createCharge();
	private final LazyOptional<IItemHandler> outputSlot  = LazyOptional.of(() -> outputSlotHandler);
	private final LazyOptional<IItemHandler> upgradeSlotWrapper  = LazyOptional.of(() -> upgradeSlotHandlerWrapper);
	private final LazyOptional<IItemHandler> chargeSlot  = LazyOptional.of(() -> chargeSlotHandler);
	
	private final LazyOptional<IItemHandler> allSlots  = LazyOptional.of(() -> new CombinedInvWrapper(upgradeSlotHandlerWrapper, chargeSlotHandler, outputSlotHandler));
	
	private final LazyOptional<IItemHandler> dropSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotHandler, outputSlotHandler));
	boolean breakBlock = false;
	
	private final LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
	private final LazyOptional<IUpgradeMachineHandler> upgrade = LazyOptional.of(() -> upgradeHandler);

	private int processingEnergy = ModConfigs.t5SlurryProcessorEnergyPerTickInt/*PER TICK*/;
	private int WORK_TIME = ModConfigs.t5SlurryProcessorWorkTimeInt;
		
	private static int capacity = ModConfigs.t5SlurryProcessorEnergyCapacityInt;
	private static int receive = ModConfigs.t5SlurryProcessorReceiveInt;
	private static int fluid_capacity = ModConfigs.t5SlurryProcessorTankCapacityInt;
		
	private int progress = 0;
	private int upgradableProcessingEnergy = 0;
	private int upgradableWorkTime = 0;

	private final IIntArray fields = new IIntArray() {
    	
        @Override
        public int get(int index) {
        	
            switch (index) {
            
                case 0:
                	return energyStorage.getEnergyStored();
                case 1:
                	return progress;
                case 2:
                	return energyStorage.getCapacity();
    			case 3:
    				return upgradableWorkTime;
    			case 4:
    				return inputFluidTank1.getCapacity();
    			case 5:
    				return inputFluidTank1.getFluidInTank(0).getAmount();
    			case 6:
    				return inputFluidTank2.getCapacity();
    			case 7:
    				return inputFluidTank2.getFluidInTank(0).getAmount();
    			case 8:
    				return outputFluidTank.getCapacity();
    			case 9:
    				return outputFluidTank.getFluidInTank(0).getAmount();
                default:
                    return 0;
                    
            }
        }

        @Override
        public void set(int index, int value) {
        	
            switch (index) {
            
            	case 0:
            		energyStorage.setEnergy(value);
            		break;
            	case 1:
            		progress = value;
            		break;
            	case 2:
            		energyStorage.setCapacity(value);
            		break;
            	case 3:
            		upgradableWorkTime = value;
            		break;
            	default:
            		break;
                    
            }
        }

        @Override
        public int getCount() {
        	
            return 10;
            
        }
    };

    public TileEntityT5SlurryProcessor() {
    	
        super(TileEntityHandler.TILE_ENTITY_T5_SLURRY_PROCESSOR.get());
        
    }

	private MechanicraftFluidTank createInputFluidTank1() {
		
		return new MechanicraftFluidTank(fluid_capacity) {
			
			@Override
            protected void onContentsChanged() {
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
            }
			
			@Override
		    public boolean isFluidValid(FluidStack stack) {

				if(isRecipeInputFluid1(level, stack.getFluid())) {
					
					return true;
					
				}
				
		        return false;
		    }
			
		};
	}
	
	private MechanicraftFluidTank createInputFluidTank2() {
		
		return new MechanicraftFluidTank(fluid_capacity) {
			
			@Override
            protected void onContentsChanged() {
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
            }
			
			@Override
		    public boolean isFluidValid(FluidStack stack) {

				if(isRecipeInputFluid2(level, stack.getFluid())) {
					
					return true;
					
				}
				
		        return false;
		    }
			
		};
	}

	private MechanicraftFluidTank createOutputFluidTank() {
		
		return new MechanicraftFluidTank(fluid_capacity) {
			
			@Override
            protected void onContentsChanged() {
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
            }
			
			@Override
		    public boolean isFluidValid(FluidStack stack) {
				
				if(isRecipeOutputFluid(level, stack.getFluid())) {
					
					return true;
					
				}
				
		        return false;
		    }
			
		};
	}

	private ItemStackHandler createCharge() {
		
		return new ItemStackHandler() {
    		
    		@Override
            protected void onContentsChanged(int slot) {
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
            }

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

				if(stack.getCapability(CapabilityEnergy.ENERGY).isPresent()) {

					return true;

				}

				return false;
				
			}
		};
	}

	private ItemStackHandler createOutput() {
		
		return new ItemStackHandler() {
    		
    		@Override
            protected void onContentsChanged(int slot) {
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
            }

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

				return false;
				
			}
		};
	}

	private ItemStackHandler createUpgrade() {

    	return new ItemStackHandler(3) {
    		
    		@Override
            protected void onContentsChanged(int slot) {
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
            }
    		
    		@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

    			Item item = stack.getItem();
				
				if(item.equals(ModItems.CAPACITY_UPGRADE.get()) || item.equals(ModItems.EFFICIENCY_UPGRADE.get()) || item.equals(ModItems.SPEED_UPGRADE.get()) || item.equals(ModItems.TRANSFER_UPGRADE.get())) {
					
					return true;
					
				}

				return false;
				
			}
    		
    		@Override
    		@Nonnull
    		public ItemStack extractItem(int slot, int amount, boolean simulate) {
    			 
    			if(stacks.get(slot).getItem().equals(ModItems.SPEED_UPGRADE.get()) || stacks.get(slot).getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) {
        			
    				if(upgradeHandler.canExtractFromSlot(progress) != true) {
    				 
    					return ItemStack.EMPTY;
    				}
    			}
    			
    			if(stacks.get(slot).getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    				
    				if(energyStorage.canExtractFromSlot(energyStorage.getEnergyStored()) != true) {
    				
    					return ItemStack.EMPTY;
    				}
    			}
    			 	
    			return super.extractItem(slot, amount, simulate);
    		 }
		};
		
    }
	
	private ItemStackHandler createUpgradeWrapper(ItemStackHandler upgradeSlotHandler) {

    	return new NonExtractableStackHandler(this.upgradeSlotHandler) {
    		
    		@Override
            protected void onContentsChanged(int slot) {
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
            }
    		
    		@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
    			
    			Item item = stack.getItem();
				
				if(item.equals(ModItems.CAPACITY_UPGRADE.get()) || item.equals(ModItems.EFFICIENCY_UPGRADE.get()) || item.equals(ModItems.SPEED_UPGRADE.get()) || item.equals(ModItems.TRANSFER_UPGRADE.get())) {

					return true;
					
				}

				return false;
				
			}
    		
    		@Override
    		@Nonnull
    		public ItemStack extractItem(int slot, int amount, boolean simulate) {
    			 
    			if(stacks.get(slot).getItem().equals(ModItems.SPEED_UPGRADE.get()) || stacks.get(slot).getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) {
        			
    				if(upgradeHandler.canExtractFromSlot(progress) != true) {
    				 
    					return ItemStack.EMPTY;
    				}
    			}
    			
    			if(stacks.get(slot).getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    				
    				if(energyStorage.canExtractFromSlot(energyStorage.getEnergyStored()) != true) {
    				
    					return ItemStack.EMPTY;
    				}
    			}
    			 	
    			return super.extractItem(slot, amount, simulate);
    		 }
		};
    }
	
	private MechaniCraftEnergyStorage createEnergy() {

		return new MechaniCraftEnergyStorage(capacity, receive, 0) {

			@Override
			protected void onEnergyChanged() {
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
			}
		};
	}
    
	private UpgradeMachineHandlerFactory createUpgradeHandler() {
    	
        return new UpgradeMachineHandlerFactory() {
        	
            @Override
			public void onUpgradeChanged() {
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
            }
        };
    }

	@Override
    public void tick() {
    	
        if (this.level == null || this.level.isClientSide) {
        	
            return;
            
        }
		
        this.setUpgradeModifiers();

		if(energyStorage.getMaxEnergyStored() > energyStorage.getEnergyStored()) {

			if(!(chargeSlotHandler.getStackInSlot(0).equals(ItemStack.EMPTY))) {

				receivePowerItem(chargeSlotHandler.getStackInSlot(0));

			}

			else

				receivePower();

		}
		
    	if(canCraft()) {
    			
    		startCrafting();
    	}
    	
    	if(progress > 0 && (inputFluidTank1.getFluidInTank(0).isEmpty() || inputFluidTank2.getFluidInTank(0).isEmpty())) {
    		
    		progress = 0;
    		
    	}
    	
    	if(!canCraft() && progress > 0) {

			progress -= 2;

		}
        
        if(canCraft() && this.level.getBlockState(this.worldPosition).getValue(T5SlurryProcessor.LIT) == false) {
        	
        	this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(T5SlurryProcessor.LIT, Boolean.valueOf(true)));
        	
        }
        
        if(!canCraft() && this.level.getBlockState(this.worldPosition).getValue(T5SlurryProcessor.LIT) == true) {
        	
        	this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(T5SlurryProcessor.LIT, Boolean.valueOf(false)));
        	
        }
    }
    
    private void setUpgradeModifiers() {
    	
    	if(upgrade.isPresent()) {
    	
    		if(progress == 0) {
    		
    			upgradeHandler.setUpgrade1Stack(upgradeSlotHandler.getStackInSlot(0));
        		upgradeHandler.setUpgrade2Stack(upgradeSlotHandler.getStackInSlot(1));
        		upgradeHandler.setUpgrade3Stack(upgradeSlotHandler.getStackInSlot(2));
        		
        		upgradeHandler.threeUpgradeModifier(WORK_TIME, processingEnergy, upgradeSlotHandler.getStackInSlot(0), upgradeSlotHandler.getStackInSlot(1), upgradeSlotHandler.getStackInSlot(2));
        			
        		upgradableWorkTime = upgradeHandler.getTotalProcessingTime();
        		upgradableProcessingEnergy = upgradeHandler.getTotalEnergyUsed();
    		}
    	}
    	
    	if(energy.isPresent()) {
    		
    		energyStorage.setUpgrade1Stack(upgradeSlotHandler.getStackInSlot(0));
    		energyStorage.setUpgrade2Stack(upgradeSlotHandler.getStackInSlot(1));
    		energyStorage.setUpgrade3Stack(upgradeSlotHandler.getStackInSlot(2));
    		energyStorage.threeUpgradeModifier(capacity, receive, upgradeSlotHandler.getStackInSlot(0), upgradeSlotHandler.getStackInSlot(1), upgradeSlotHandler.getStackInSlot(2));
    		
    	}
    }

	public boolean canExtractCapacity() {
		
		if(energy.isPresent()) {
			
			return energyStorage.canExtractFromSlot(energyStorage.getEnergyStored());
			
		} else 
			return false;
	}
    
    private boolean canCraft() {
    	
    	ItemStack bucket1 = ItemStack.EMPTY;
    	ItemStack bucket2 = ItemStack.EMPTY;
    	
    	if(!inputFluidTank1.getFluidInTank(0).isEmpty() && !inputFluidTank2.getFluidInTank(0).isEmpty()) {
    		
    		bucket1 = new ItemStack(inputFluidTank1.getFluidInTank(0).getFluid().getBucket());
    		bucket2 = new ItemStack(inputFluidTank2.getFluidInTank(0).getFluid().getBucket());
    		
    	}
    	
    	Inventory recipeInventory = new Inventory(bucket1, bucket2);
    	
    	Optional<SlurryRecipes> rOpt = this.level.getRecipeManager().getRecipeFor(ModRecipes.SLURRY_RECIPES, recipeInventory, this.level);
    	SlurryRecipes recipe = rOpt.orElse(null);
    	
    	int outputFluidHandlerCount = 0;
    	
    	ItemStack outputStack = ItemStack.EMPTY;
    	FluidStack outputFluid = FluidStack.EMPTY;
    	if(!this.inputFluidTank1.getFluidInTank(0).equals(FluidStack.EMPTY) && !this.inputFluidTank2.getFluidInTank(0).equals(FluidStack.EMPTY)) {
    		
    		if(recipe != null && !bucket1.isEmpty() && !bucket2.isEmpty())
    			
    			outputStack = recipe.assembleStack(inputFluidTank1.getFluidInTank(0), inputFluidTank2.getFluidInTank(0));
    			outputFluid = recipe.assembleFluid(inputFluidTank1.getFluidInTank(0), inputFluidTank2.getFluidInTank(0));
    		}
    	
    	ItemStack outputStackHandler = outputSlotHandler.getStackInSlot(0);
    	FluidStack outputFluidHandler = outputFluidTank.getFluidInTank(0);
    	
    	if(!(outputFluidHandler.equals(FluidStack.EMPTY))) {
    		
    		outputFluidHandlerCount = outputFluidHandler.getAmount();
    	}
    	
    	boolean ouputFluidMatchesBool = outputFluid.getFluid().equals(outputFluidHandler.getFluid());
    	boolean ouputStackMatchesBool = outputStack.getItem().equals(outputStackHandler.getItem());
    	boolean outputFluidEmptyBool = outputFluidHandler.equals(FluidStack.EMPTY);
    	boolean outputStackEmptyBool = outputStackHandler.equals(ItemStack.EMPTY);
    	boolean outputFluidNotFullBool = outputFluid.getAmount() + outputFluidHandlerCount <= outputFluidTank.getCapacity();
    	boolean outputStackNotFullBool = outputStack.getCount() + outputStackHandler.getCount() <= outputSlotHandler.getSlotLimit(0);
    	
    	if(energyStorage.getEnergyStored() >= upgradableProcessingEnergy) {
    	
    		if(recipe != null && !outputStack.isEmpty() && !outputFluid.isEmpty()) {
    	    	
    	    	boolean inputFluid1Empty = inputFluidTank1.getFluid().equals(FluidStack.EMPTY);
    	    	boolean inputFluid2Empty = inputFluidTank2.getFluid().equals(FluidStack.EMPTY);
    	    	boolean inputFluid1AmountSmall = recipe.getInputFluid1().getAmount() <= inputFluidTank1.getFluidInTank(0).getAmount();
    	    	boolean inputFluid2AmountSmall = recipe.getInputFluid2().getAmount() <= inputFluidTank2.getFluidInTank(0).getAmount();
    			
    			if((!inputFluid1Empty && !inputFluid2Empty) && (inputFluid1AmountSmall && inputFluid2AmountSmall)) {
    			
    				if(outputFluidEmptyBool && outputStackEmptyBool) {
    				
    					return true;
    			
    				} else if(outputFluidEmptyBool && ouputStackMatchesBool && outputStackNotFullBool) {
    				
    					return true;
    				
    				} else if(outputStackEmptyBool && ouputFluidMatchesBool && outputFluidNotFullBool) {
    				
    					return true;
    				
    				} else if((ouputFluidMatchesBool && ouputStackMatchesBool) && (outputFluidNotFullBool && outputStackNotFullBool)) {
    				
    					return true;
    				
    				} else {
    			
    					return false;
    				}
    			}
    		}
    	}
    	
    	return false;
    }
    
    private void startCrafting() {
		
    	ItemStack bucket1 = new ItemStack(inputFluidTank1.getFluidInTank(0).getFluid().getBucket());
    	ItemStack bucket2 = new ItemStack(inputFluidTank2.getFluidInTank(0).getFluid().getBucket());
	
    	Inventory recipeInventory = new Inventory(bucket1, bucket2);
    	
    	Optional<SlurryRecipes> rOpt = this.level.getRecipeManager().getRecipeFor(ModRecipes.SLURRY_RECIPES, recipeInventory, this.level);
    	SlurryRecipes recipe = rOpt.orElse(null);
    	
    	ItemStack currentStack = outputSlotHandler.getStackInSlot(0);
    	ItemStack outputStack = recipe.assembleStack(inputFluidTank1.getFluidInTank(0), inputFluidTank2.getFluidInTank(0));
    	
    	FluidStack currentFluid = outputFluidTank.getFluidInTank(0);
    	FluidStack outputFluid = recipe.assembleFluid(inputFluidTank1.getFluidInTank(0), inputFluidTank2.getFluidInTank(0));
    	
    	if(canCraft()) {
    		
    		if (progress < upgradableWorkTime) {
    			
    			++progress;
    			energyStorage.consumeEnergy(upgradableProcessingEnergy);
    			
    		}

    		if (progress >= upgradableWorkTime) {
    			
    			if(currentStack.isEmpty() && currentFluid.isEmpty()) {
    				
    				outputFluidTank.setFluid(outputFluid.copy());
    				outputSlotHandler.setStackInSlot(0, outputStack.copy());
    				progress = 0;
    				inputFluidTank1.drain(recipe.getInputFluid1().getAmount(), FluidAction.EXECUTE);
    				inputFluidTank2.drain(recipe.getInputFluid2().getAmount(), FluidAction.EXECUTE);
    				
    			} else if(currentFluid.isEmpty() && (currentStack.getItem().equals(outputStack.getItem()) && currentStack.getCount() < outputSlotHandler.getSlotLimit(0))) {
    				
    				outputFluidTank.setFluid(outputFluid.copy());
    				currentStack.grow(outputStack.getCount());
    				progress = 0;
    				inputFluidTank1.drain(recipe.getInputFluid1().getAmount(), FluidAction.EXECUTE);
    				inputFluidTank2.drain(recipe.getInputFluid2().getAmount(), FluidAction.EXECUTE);
    				
    			} else if(currentStack.isEmpty() && (currentFluid.getFluid().equals(outputFluid.getFluid()) && currentFluid.getAmount() < outputFluidTank.getCapacity())) {
    				
    				currentFluid.grow(outputFluid.getAmount());
    				outputSlotHandler.setStackInSlot(0, outputStack.copy());
    				progress = 0;
    				inputFluidTank1.drain(recipe.getInputFluid1().getAmount(), FluidAction.EXECUTE);
    				inputFluidTank2.drain(recipe.getInputFluid2().getAmount(), FluidAction.EXECUTE);
    				
    			} else if((currentFluid.getFluid().equals(outputFluid.getFluid()) && currentFluid.getAmount() < outputFluidTank.getCapacity()) &&
    				     (currentStack.getItem().equals(outputStack.getItem()) && currentStack.getCount() < outputSlotHandler.getSlotLimit(0))) {
    					
    				currentStack.grow(outputStack.getCount());
    				currentFluid.grow(outputFluid.getAmount());
    				progress = 0;
    				inputFluidTank1.drain(recipe.getInputFluid1().getAmount(), FluidAction.EXECUTE);
        			inputFluidTank2.drain(recipe.getInputFluid2().getAmount(), FluidAction.EXECUTE);
    					
    				
    			}
    		}
    	}
    }
	
	private void receivePower() {
		
        AtomicInteger energy = new AtomicInteger(energyStorage.getEnergyStored());
        
        if(energy.get() < energyStorage.getCapacity()) {
        	
            for(Direction direction : Direction.values()) {
            	
                TileEntity te = level.getBlockEntity(worldPosition.relative(direction));
                
                if(te != null) {
                	
                    boolean doContinue = te.getCapability(CapabilityEnergy.ENERGY, direction).map(handler -> {
                    	
                        if(handler.canExtract() ) {
                                	
                            int extracted = handler.extractEnergy(Math.min(handler.getEnergyStored(), energyStorage.getMaxReceive()), false);
                            energy.addAndGet(extracted);
                            energyStorage.receiveEnergy(extracted, false);
                            setChanged();
                                    
                            return energy.get() > 0;
                                    
                            } else {
                                	
                                return true;
                                
                            }
                                
                        }).orElse(true);
                    
                    if(!doContinue) {
                    	
                        return;
                    }
                }
            }
        }
    }
	
	private void receivePowerItem(ItemStack stack) {
		
		AtomicInteger energy = new AtomicInteger(energyStorage.getEnergyStored());
        
		if(energy.get() < energyStorage.getCapacity()) {
                
			if(stack.getCapability(CapabilityEnergy.ENERGY).isPresent()) {
                	
				boolean doContinue = stack.getCapability(CapabilityEnergy.ENERGY).map(handler -> {
                    	
					if(handler.canReceive()) {
                                	
						int extracted = handler.extractEnergy(Math.min(handler.getEnergyStored(), energyStorage.getMaxReceive()), false);
                        energy.addAndGet(extracted);
                        energyStorage.receiveEnergy(extracted, false);
                        setChanged();
                                    
						return energy.get() > 0;
                                    
					} else {
                                	
						return true;
					}
					
				}).orElse(true);
                    
				if(!doContinue) {
                    	
					return;
                   
				}
			}
        }
    }
	
	public static Iterable<SlurryRecipes> getRecipes(World world) {
		
        Collection<SlurryRecipes> unfilteredRecipes = world.getRecipeManager().getAllRecipesFor(ModRecipes.SLURRY_RECIPES);
        
        return Iterables.filter(unfilteredRecipes, SlurryRecipes.class);
    }
	
	public static boolean isRecipeInputFluid1(World world, Fluid fluid) {
		
        for (SlurryRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInputFluid1().getFluid().equals(fluid.getFluid())) {
            	
                return true;
                
            }
        }

        return false;
    }
	
	public static boolean isRecipeInputFluid2(World world, Fluid fluid) {
		
        for (SlurryRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInputFluid2().getFluid().equals(fluid.getFluid())) {
            	
                return true;
                
            }
        }

        return false;
    }
	
	public static boolean isRecipeOutputFluid(World world, Fluid fluid) {
		
        for (SlurryRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getResultFluid().getFluid().equals(fluid)) {
            	
                return true;
                
            }
        }

        return false;
    }
	
    public FluidStack getInputFluidStack1() {
		
        return this.inputFluidTank1.getFluidInTank(0);
    }
	
    public FluidStack getInputFluidStack2() {
		
        return this.inputFluidTank2.getFluidInTank(0);
    }
	
    public FluidStack getOutputFluidStack() {
		
        return this.outputFluidTank.getFluidInTank(0);
    }

    @Override
	public ITextComponent getDisplayName() {

		return new TranslationTextComponent("container.mechanicraft.t5_slurry_processor");
		
	}

    @Nullable
    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity playerEntity) {
    	
        assert level != null;
		return new ContainerT5SlurryProcessor(this, this.fields, id, playerInventory, new CombinedInvWrapper(upgradeSlotHandler, chargeSlotHandler, outputSlotHandler));
        
    }

    @Override
    public void load(BlockState state, CompoundNBT tags) {
    	
        super.load(state, tags);
        this.progress = tags.getInt("progress");
		this.upgradableProcessingEnergy = tags.getInt("processingEnergy");
		this.upgradableWorkTime = tags.getInt("processingTime");
		this.energyStorage.deserializeNBT(tags.getCompound("energy"));
		this.upgradeSlotHandler.deserializeNBT(tags.getCompound("upgradeSlot"));
		this.chargeSlotHandler.deserializeNBT(tags.getCompound("chargeSlot"));
        this.outputSlotHandler.deserializeNBT(tags.getCompound("outputSlot"));
		
		if(tags.contains("inputTank1", Constants.NBT.TAG_COMPOUND)) {
			
            CompoundNBT inputFluidTankTag1 = tags.getCompound("inputTank1");
            this.inputFluidTank1.readFromNBT(inputFluidTankTag1);
        }
		
		if(tags.contains("inputTank2", Constants.NBT.TAG_COMPOUND)) {
			
            CompoundNBT inputFluidTankTag2 = tags.getCompound("inputTank2");
            this.inputFluidTank2.readFromNBT(inputFluidTankTag2);
        }
		
		if(tags.contains("outputTank", Constants.NBT.TAG_COMPOUND)) {
			
            CompoundNBT outputFluidTankTag = tags.getCompound("outputTank");
            this.outputFluidTank.readFromNBT(outputFluidTankTag);
        }
        
    }

    @Override
    public CompoundNBT save(CompoundNBT tags) {
    	
        super.save(tags);
        CompoundNBT inputFluidTankTag1 = new CompoundNBT();
        CompoundNBT inputFluidTankTag2 = new CompoundNBT();
		CompoundNBT outputFluidTankTag = new CompoundNBT();
        
		tags.putInt("progress", this.progress);
		tags.put("energy", energyStorage.serializeNBT());
		tags.putInt("processingEnergy", upgradableProcessingEnergy);
		tags.putInt("processingTime", upgradableWorkTime);
		tags.put("chargeSlot", chargeSlotHandler.serializeNBT());
		tags.put("upgradeSlot", upgradeSlotHandler.serializeNBT());
		tags.put("outputSlot", outputSlotHandler.serializeNBT());
		tags.put("outputTank", outputFluidTank.writeToNBT(tags));
		
        this.inputFluidTank1.writeToNBT(inputFluidTankTag1);
        tags.put("inputTank1", inputFluidTankTag1);
		
        this.inputFluidTank2.writeToNBT(inputFluidTankTag2);
        tags.put("inputTank2", inputFluidTankTag2);
        
        this.outputFluidTank.writeToNBT(outputFluidTankTag);
        tags.put("outputTank", outputFluidTankTag);
		
        return tags;
        
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
    	
        CompoundNBT tags = this.getUpdateTag();
        this.save(tags);
        return new SUpdateTileEntityPacket(this.worldPosition, 1, tags);
        
    }
    
    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tags) {
    	
		tags.getInt("progress");
		tags.get("energy");
		tags.get("processingEnergy");
		tags.getInt("processingTime");
		
		this.inputFluidTank1.readFromNBT(tags);
        tags.get("inputTank1");
		
		this.inputFluidTank2.readFromNBT(tags);
        tags.get("inputTank2");
        
        this.outputFluidTank.readFromNBT(tags);
        tags.get("outputTank");
        
        this.load(state, tags);
        
    	super.handleUpdateTag(state, tags);
    	
    }

    @Override
    public CompoundNBT getUpdateTag() {
    	
        CompoundNBT tags = new CompoundNBT();
        CompoundNBT inputFluidTankTag1 = new CompoundNBT();
        CompoundNBT inputFluidTankTag2 = new CompoundNBT();
		CompoundNBT outputFluidTankTag = new CompoundNBT();
		tags.putInt("progress", this.progress);
		tags.put("energy", energyStorage.serializeNBT());
		tags.putInt("processingEnergy", upgradableProcessingEnergy);
		tags.putInt("processingTime", upgradableWorkTime);
		
		this.inputFluidTank1.writeToNBT(inputFluidTankTag1);
        tags.put("inputTank1", inputFluidTankTag1);
		
		this.inputFluidTank2.writeToNBT(inputFluidTankTag2);
        tags.put("inputTank2", inputFluidTankTag2);
        
        this.outputFluidTank.writeToNBT(outputFluidTankTag);
        tags.put("outputTank", outputFluidTankTag);
        
        this.save(tags);
        
        return tags;
        
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
    	
    	inputFluidTank1.readFromNBT(packet.getTag().getCompound("inputTank1"));
    	inputFluidTank2.readFromNBT(packet.getTag().getCompound("inputTank2"));
    	outputFluidTank.readFromNBT(packet.getTag().getCompound("outputTank"));
    	
        this.load(this.getBlockState(), packet.getTag());
        this.level.getBlockTicks().scheduleTick(this.worldPosition, this.getBlockState().getBlock(), 100);
        super.onDataPacket(net, packet);
    }

	boolean blockBeingBroken(boolean onRemoved) {
		
		return breakBlock = onRemoved;
	}

    @Nullable
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
    	
        if (!this.remove && side != null) {
        	
        	if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
        	
        		return allSlots.cast();
			
        	}
			
			if(cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
				
				if(this.level.getBlockState(this.worldPosition).getValue(T5SlurryProcessor.FACING) == Direction.NORTH) {
					
					if(side == Direction.EAST) {
	            		
						return LazyOptional.of(() -> this.inputFluidTank1).cast();
	            		
					}
		            if(side == Direction.WEST) {
            		
		            	return LazyOptional.of(() -> this.inputFluidTank2).cast();
            		
		            } else return LazyOptional.of(() -> this.outputFluidTank).cast();
				}
				
				if(this.level.getBlockState(this.worldPosition).getValue(T5SlurryProcessor.FACING) == Direction.SOUTH) {
					
					if(side == Direction.WEST) {
	            		
						return LazyOptional.of(() -> this.inputFluidTank1).cast();
	            		
					}
		            if(side == Direction.EAST) {
            		
		            	return LazyOptional.of(() -> this.inputFluidTank2).cast();
            		
		            } else return LazyOptional.of(() -> this.outputFluidTank).cast();
				}
				
				if(this.level.getBlockState(this.worldPosition).getValue(T5SlurryProcessor.FACING) == Direction.EAST) {
					
					if(side == Direction.SOUTH) {
	            		
						return LazyOptional.of(() -> this.inputFluidTank1).cast();
	            		
					}
		            if(side == Direction.NORTH) {
            		
		            	return LazyOptional.of(() -> this.inputFluidTank2).cast();
            		
		            } else return LazyOptional.of(() -> this.outputFluidTank).cast();
				}
				
				if(this.level.getBlockState(this.worldPosition).getValue(T5SlurryProcessor.FACING) == Direction.WEST) {
					
					if(side == Direction.NORTH) {
	            		
						return LazyOptional.of(() -> this.inputFluidTank1).cast();
	            		
					}
		            if(side == Direction.SOUTH) {
            		
		            	return LazyOptional.of(() -> this.inputFluidTank2).cast();
            		
		            } else return LazyOptional.of(() -> this.outputFluidTank).cast();
				}
			}
			
			if (cap == CapabilityEnergy.ENERGY) {

				return energy.cast();

			}
            
        } else if(breakBlock == true && side == null) {

			if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
				
				return dropSlots.cast();
			}

		} else if(!this.remove && cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY && side == level.getBlockState(worldPosition).getValue(T1SlurryProcessor.FACING).getOpposite()) {
			
			return LazyOptional.of(() -> this.outputFluidTank).cast();
		}
        
        return super.getCapability(cap, side);
    }

    @Override
    public void setRemoved() {
    	
    	energy.invalidate();
		upgrade.invalidate();
		upgradeSlotWrapper.invalidate();
    	outputSlot.invalidate();
		chargeSlot.invalidate();
		allSlots.invalidate();
		dropSlots.invalidate();
        super.setRemoved();

    }
}