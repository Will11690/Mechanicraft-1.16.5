package com.github.will11690.mechanicraft.blocks.machines.tier5.t5press;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.init.ModConfigs;
import com.github.will11690.mechanicraft.init.ModItems;
import com.github.will11690.mechanicraft.init.ModRecipes;
import com.github.will11690.mechanicraft.recipes.Press.PressRecipes;
import com.github.will11690.mechanicraft.util.capabilities.factory.UpgradeMachineHandlerFactory;
import com.github.will11690.mechanicraft.util.capabilities.interfaces.IUpgradeMachineHandler;
import com.github.will11690.mechanicraft.util.handlers.NonExtractableStackHandler;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;
import com.google.common.collect.Iterables;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
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
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

public class TileEntityT5Press extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

	//TODO Clean this up and assign ItemStackHandlers via CombinedInvWrapper instead of per slot
	
	private MechaniCraftEnergyStorage energyStorage = createEnergy();
	UpgradeMachineHandlerFactory upgradeHandler = createUpgradeHandler();
	
	private ItemStackHandler inputSlotHandler = createInput();
	private ItemStackHandler inputSlotWrapperHandler = createInputWrapper(inputSlotHandler);
	ItemStackHandler upgradeSlotHandler = createUpgrade();
    private ItemStackHandler upgradeSlotHandlerWrapper = createUpgradeWrapper(upgradeSlotHandler);
	private ItemStackHandler outputSlotHandler = createOutput();
	private ItemStackHandler chargeSlotHandler = createCharge();
	
	private final LazyOptional<IItemHandler> inputSlotWrapper  = LazyOptional.of(() -> inputSlotWrapperHandler);
	private final LazyOptional<IItemHandler> upgradeSlotWrapper  = LazyOptional.of(() -> upgradeSlotHandlerWrapper);
	private final LazyOptional<IItemHandler> outputSlot  = LazyOptional.of(() -> outputSlotHandler);
	private final LazyOptional<IItemHandler> chargeSlot  = LazyOptional.of(() -> chargeSlotHandler);
	
	private final LazyOptional<IItemHandler> allSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotHandler, inputSlotWrapperHandler, upgradeSlotHandlerWrapper, outputSlotHandler));
	
	private final LazyOptional<IItemHandler> dropSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotHandler, inputSlotHandler, outputSlotHandler));
	boolean breakBlock = false;

	private final LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
	private final LazyOptional<IUpgradeMachineHandler> upgrade = LazyOptional.of(() -> upgradeHandler);

	private int pressingEnergy = ModConfigs.t5PressEnergyPerTickInt/*PER TICK*/;
	private int WORK_TIME = ModConfigs.t5PressWorkTimeInt;
		
	private static int capacity = ModConfigs.t5PressCapacityInt;
	private static int receive = ModConfigs.t5PressReceiveInt;
		
	private int progress = 0;
	private int upgradablePressingEnergy = 0;
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
        	
			return 4;
            
		}
	};

	public TileEntityT5Press() {

		super(TileEntityHandler.TILE_ENTITY_T5_PRESS.get());

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

	private ItemStackHandler createInput() {
		
		return new ItemStackHandler(9) {
    		
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

				if(slot == 0 && isRecipeInput1(level, stack)) {

					return true;

				}
				
				if(slot == 1 && isRecipeInput2(level, stack)) {

					return true;

				}
				
				if(slot == 2 && isRecipeInput3(level, stack)) {

					return true;

				}
				
				if(slot == 3 && isRecipeInput4(level, stack)) {

					return true;

				}
				
				if(slot == 4 && isRecipeInput5(level, stack)) {

					return true;

				}
				
				if(slot == 5 && isRecipeInput6(level, stack)) {

					return true;

				}
				
				if(slot == 6 && isRecipeInput7(level, stack)) {

					return true;

				}
				
				if(slot == 7 && isRecipeInput8(level, stack)) {

					return true;

				}
				
				if(slot == 8 && isRecipeInput9(level, stack)) {

					return true;

				}

				return false;
				
			}
		};
	}
	
	private ItemStackHandler createInputWrapper(ItemStackHandler inputSlot) {
		
		return new NonExtractableStackHandler(this.inputSlotHandler) {
    		
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

				if(slot == 0 && isRecipeInput5(level, stack)) {

					return true;

				}
				
				if(slot == 1 && isRecipeInput2(level, stack)) {

					return true;

				}
				
				if(slot == 2 && isRecipeInput3(level, stack)) {

					return true;

				}
				
				if(slot == 3 && isRecipeInput4(level, stack)) {

					return true;

				}
				
				if(slot == 4 && isRecipeInput5(level, stack)) {

					return true;

				}
				
				if(slot == 5 && isRecipeInput6(level, stack)) {

					return true;

				}
				
				if(slot == 6 && isRecipeInput7(level, stack)) {

					return true;

				}
				
				if(slot == 7 && isRecipeInput8(level, stack)) {

					return true;

				}
				
				if(slot == 8 && isRecipeInput9(level, stack)) {

					return true;

				}

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

		if(canPress()) {

			startPressing();

		}
        
		if(!canPress() && (inputSlotHandler.getStackInSlot(0).isEmpty() || inputSlotHandler.getStackInSlot(1).isEmpty() || inputSlotHandler.getStackInSlot(2).isEmpty() ||
				inputSlotHandler.getStackInSlot(3).isEmpty() || inputSlotHandler.getStackInSlot(4).isEmpty() || inputSlotHandler.getStackInSlot(5).isEmpty() ||
				inputSlotHandler.getStackInSlot(6).isEmpty() || inputSlotHandler.getStackInSlot(7).isEmpty() || inputSlotHandler.getStackInSlot(8).isEmpty()) && progress > 0) {

			progress = 0;

		}

		if(!canPress() && progress > 0) {

			progress -= 2;

		}

		if(!canPress() && this.level.getBlockState(this.worldPosition).getValue(T5Press.LIT) == true) {

			this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(T5Press.LIT, Boolean.valueOf(false)));

		}

		if(canPress() && this.level.getBlockState(this.worldPosition).getValue(T5Press.LIT) == false) {

			this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(T5Press.LIT, Boolean.valueOf(true)));

		}
	}
    
    private void setUpgradeModifiers() {
    	
    	if(upgrade.isPresent()) {
    	
    		if(progress == 0) {
    		
    			upgradeHandler.setUpgrade1Stack(upgradeSlotHandler.getStackInSlot(0));
        		upgradeHandler.setUpgrade2Stack(upgradeSlotHandler.getStackInSlot(1));
        		upgradeHandler.setUpgrade3Stack(upgradeSlotHandler.getStackInSlot(2));
        		
        		upgradeHandler.threeUpgradeModifier(WORK_TIME, pressingEnergy, upgradeSlotHandler.getStackInSlot(0), upgradeSlotHandler.getStackInSlot(1), upgradeSlotHandler.getStackInSlot(2));
        			
        		upgradableWorkTime = upgradeHandler.getTotalProcessingTime();
        		upgradablePressingEnergy = upgradeHandler.getTotalEnergyUsed();
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

	private boolean canPress() {

		Inventory recipeInventory = new Inventory(this.inputSlotHandler.getStackInSlot(0), this.inputSlotHandler.getStackInSlot(1), this.inputSlotHandler.getStackInSlot(2),
				this.inputSlotHandler.getStackInSlot(3), this.inputSlotHandler.getStackInSlot(4), this.inputSlotHandler.getStackInSlot(5),
				this.inputSlotHandler.getStackInSlot(6), this.inputSlotHandler.getStackInSlot(7), this.inputSlotHandler.getStackInSlot(8));
    	
    	Optional<PressRecipes> rOpt = this.level.getRecipeManager().getRecipeFor(ModRecipes.PRESS_RECIPES, recipeInventory, this.level);
    	PressRecipes recipe = rOpt.orElse(null);
    	
    	int outputHandlerCount = 0;
    	ItemStack output = ItemStack.EMPTY;
    	if(!this.inputSlotHandler.getStackInSlot(0).equals(ItemStack.EMPTY) && !this.inputSlotHandler.getStackInSlot(1).equals(ItemStack.EMPTY) && !this.inputSlotHandler.getStackInSlot(2).equals(ItemStack.EMPTY) &&
		   !this.inputSlotHandler.getStackInSlot(3).equals(ItemStack.EMPTY) && !this.inputSlotHandler.getStackInSlot(4).equals(ItemStack.EMPTY) && !this.inputSlotHandler.getStackInSlot(5).equals(ItemStack.EMPTY) &&
		   !this.inputSlotHandler.getStackInSlot(6).equals(ItemStack.EMPTY) && !this.inputSlotHandler.getStackInSlot(7).equals(ItemStack.EMPTY) && !this.inputSlotHandler.getStackInSlot(8).equals(ItemStack.EMPTY)) {
    		
    		if(recipe != null)
    			output = recipe.assemble(recipeInventory).copy();
    	}
    	
    	ItemStack outputHandler = outputSlotHandler.getStackInSlot(0);
    	
    	if(!(outputHandler.equals(ItemStack.EMPTY))) {
    		
    		outputHandlerCount = outputHandler.getCount();
    	}

    	if(recipe != null && (output.getItem().equals(outputHandler.getItem()) || outputHandler.equals(ItemStack.EMPTY)) && (output.getCount() + outputHandlerCount <= outputHandler.getMaxStackSize())) {
    	
    		if(energyStorage.getEnergyStored() >= upgradablePressingEnergy) {
	    		
	    		return true;
	    	}
			return false;
		}
		return false;
	}

	private void startPressing() {

		Inventory recipeInventory = new Inventory(this.inputSlotHandler.getStackInSlot(0), this.inputSlotHandler.getStackInSlot(1), this.inputSlotHandler.getStackInSlot(2),
				this.inputSlotHandler.getStackInSlot(3), this.inputSlotHandler.getStackInSlot(4), this.inputSlotHandler.getStackInSlot(5),
				this.inputSlotHandler.getStackInSlot(6), this.inputSlotHandler.getStackInSlot(7), this.inputSlotHandler.getStackInSlot(8));
		
    	Inventory outputInventory = new Inventory(this.outputSlotHandler.getStackInSlot(0));
    	
    	Optional<PressRecipes> rOpt = this.level.getRecipeManager().getRecipeFor(ModRecipes.PRESS_RECIPES, recipeInventory, this.level);
    	PressRecipes recipe = rOpt.orElse(null);
    	
    	ItemStack current = outputInventory.getItem(0);
    	ItemStack output = recipe.assemble(recipeInventory);

		if(canPress()) {

			if(progress < upgradableWorkTime) {

				++progress;
				energyStorage.consumeEnergy(upgradablePressingEnergy);

			}

			if (progress >= upgradableWorkTime) {

				if(current.isEmpty()) {

					outputSlotHandler.setStackInSlot(0, output.copy());
					progress = 0;
					inputSlotHandler.extractItem(0, 1, false);
					inputSlotHandler.extractItem(1, 1, false);
					inputSlotHandler.extractItem(2, 1, false);
					inputSlotHandler.extractItem(3, 1, false);
					inputSlotHandler.extractItem(4, 1, false);
					inputSlotHandler.extractItem(5, 1, false);
					inputSlotHandler.extractItem(6, 1, false);
					inputSlotHandler.extractItem(7, 1, false);

				} else {

					if(output.getItem().equals(current.getItem()) && current.getCount() < current.getMaxStackSize()) {

						current.grow(output.getCount());
						progress = 0;
						inputSlotHandler.extractItem(0, 1, false);
						inputSlotHandler.extractItem(1, 1, false);
						inputSlotHandler.extractItem(2, 1, false);
						inputSlotHandler.extractItem(3, 1, false);
						inputSlotHandler.extractItem(4, 1, false);
						inputSlotHandler.extractItem(5, 1, false);
						inputSlotHandler.extractItem(6, 1, false);
						inputSlotHandler.extractItem(7, 1, false);

					}
				}
			}
		}
	}
	
	public static Iterable<PressRecipes> getRecipes(World world) {
		
        Collection<PressRecipes> unfilteredRecipes = world.getRecipeManager().getAllRecipesFor(ModRecipes.PRESS_RECIPES);
        
        return Iterables.filter(unfilteredRecipes, PressRecipes.class);
    }
	
	public static boolean isRecipeInput1(World world, ItemStack stack) {
		
        for (PressRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInput1().test(stack)) {
            	
                return true;
            }
        }
        return false;
    }
	
	public static boolean isRecipeInput2(World world, ItemStack stack) {
		
        for (PressRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInput2().test(stack)) {
            	
                return true;
            }
        }
        return false;
    }
	
	public static boolean isRecipeInput3(World world, ItemStack stack) {
		
        for (PressRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInput3().test(stack)) {
            	
                return true;
            }
        }
        return false;
    }
	
	public static boolean isRecipeInput4(World world, ItemStack stack) {
		
        for (PressRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInput4().test(stack)) {
            	
                return true;
            }
        }
        return false;
    }
	
	public static boolean isRecipeInput5(World world, ItemStack stack) {
		
        for (PressRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInput5().test(stack)) {
            	
                return true;
            }
        }
        return false;
    }
	
	public static boolean isRecipeInput6(World world, ItemStack stack) {
		
        for (PressRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInput6().test(stack)) {
            	
                return true;
            }
        }
        return false;
    }
	
	public static boolean isRecipeInput7(World world, ItemStack stack) {
		
        for (PressRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInput7().test(stack)) {
            	
                return true;
            }
        }
        return false;
    }
	
	public static boolean isRecipeInput8(World world, ItemStack stack) {
		
        for (PressRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInput8().test(stack)) {
            	
                return true;
            }
        }
        return false;
    }
	
	public static boolean isRecipeInput9(World world, ItemStack stack) {
		
        for (PressRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInput9().test(stack)) {
            	
                return true;
            }
        }
        return false;
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

	@Nullable
	@Override
	public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity playerEntity) {

		assert level != null;
		return new ContainerT5Press(this, this.fields, id, playerInventory, new CombinedInvWrapper(chargeSlotHandler, inputSlotHandler, upgradeSlotHandler, outputSlotHandler));

	}

	@Override
	public void load(BlockState state, CompoundNBT tags) {

		super.load(state, tags);
		this.progress = tags.getInt("Progress");
		this.upgradablePressingEnergy = tags.getInt("PressingEnergy");
		this.upgradableWorkTime = tags.getInt("ProcessingTime");
		this.energyStorage.deserializeNBT(tags.getCompound("energy"));
		this.inputSlotHandler.deserializeNBT(tags.getCompound("inputSlot"));
		this.upgradeSlotHandler.deserializeNBT(tags.getCompound("upgradeSlot"));
		this.outputSlotHandler.deserializeNBT(tags.getCompound("outputSlot"));
		this.chargeSlotHandler.deserializeNBT(tags.getCompound("chargeSlot"));

	}

	@Override
	public CompoundNBT save(CompoundNBT tags) {

		super.save(tags);
		tags.putInt("Progress", this.progress);
		tags.put("energy", energyStorage.serializeNBT());
		tags.putInt("PressingEnergy", upgradablePressingEnergy);
		tags.putInt("ProcessingTime", upgradableWorkTime);
		tags.put("inputSlot", inputSlotHandler.serializeNBT());
		tags.put("upgradeSlot", upgradeSlotHandler.serializeNBT());
		tags.put("outputSlot", outputSlotHandler.serializeNBT());
		tags.put("chargeSlot", chargeSlotHandler.serializeNBT());
		return tags;

}

	@Nullable
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {

		CompoundNBT tags = this.getUpdateTag();
		return new SUpdateTileEntityPacket(this.worldPosition, 1, tags);

	}

	@Override
	public CompoundNBT getUpdateTag() {

		return save(new CompoundNBT());

	}

	@Override
	public void handleUpdateTag(BlockState stateIn, CompoundNBT tag) {

		load(stateIn, tag);

	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {

		load(this.getBlockState(), pkt.getTag());

	}

	boolean blockBeingBroken(boolean onRemoved) {
		
		return breakBlock = onRemoved;
	}

	@Nullable
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {

		if (!this.remove && side != null) {

			if (cap == CapabilityEnergy.ENERGY) {

				return energy.cast();

			}

			if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
				
				return allSlots.cast();

			}
		} else if(breakBlock == true && side == null) {

			if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
				
				return dropSlots.cast();
			}
		}

		return super.getCapability(cap, side);
		
	}

	@Override
	public void setRemoved() {

		energy.invalidate();
		upgrade.invalidate();
		inputSlotWrapper.invalidate();
		upgradeSlotWrapper.invalidate();
		outputSlot.invalidate();
		chargeSlot.invalidate();
		allSlots.invalidate();
		dropSlots.invalidate();
		super.setRemoved();

	}

	@Override
	public ITextComponent getDisplayName() {

		return new TranslationTextComponent("container.mechanicraft.t5_press");

	}
}