package com.github.will11690.mechanicraft.blocks.machines.tier3.t3poweredsieve;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.init.ModConfigs;
import com.github.will11690.mechanicraft.init.ModItems;
import com.github.will11690.mechanicraft.init.ModRecipes;
import com.github.will11690.mechanicraft.recipes.Sieve.SieveRecipes;
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
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

public class TileEntityT3PoweredSieve extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

	//TODO Clean this up and assign ItemStackHandlers via CombinedInvWrapper instead of per slot
	
	private MechaniCraftEnergyStorage energyStorage = createEnergy();
	UpgradeMachineHandlerFactory upgradeHandler = createUpgradeHandler();
	
	private ItemStackHandler inputSlotHandler1 = createInput1();
	private ItemStackHandler inputSlotWrapperHandler1 = createInputWrapper1(inputSlotHandler1);
	private ItemStackHandler inputSlotHandler2 = createInput2();
	private ItemStackHandler inputSlotWrapperHandler2 = createInputWrapper2(inputSlotHandler2);
	
	public ItemStackHandler upgradeSlotHandler = createUpgrade();
    private ItemStackHandler upgradeSlotHandlerWrapper = createUpgradeWrapper(upgradeSlotHandler);
    
	private ItemStackHandler chargeSlotHandler = createCharge();
	private ItemStackHandler outputSlotHandler = createOutput();
	
	private final LazyOptional<IItemHandler> inputSlotWrapper1  = LazyOptional.of(() -> inputSlotWrapperHandler1);
	private final LazyOptional<IItemHandler> inputSlotWrapper2  = LazyOptional.of(() -> inputSlotWrapperHandler2);
	private LazyOptional<IItemHandler> upgradeSlotWrapper  = LazyOptional.of(() -> upgradeSlotHandlerWrapper);
	private final LazyOptional<IItemHandler> outputSlot  = LazyOptional.of(() -> outputSlotHandler);
	private final LazyOptional<IItemHandler> chargeSlot  = LazyOptional.of(() -> chargeSlotHandler);
	
	private final LazyOptional<IItemHandler> allSlots  = LazyOptional.of(() -> new CombinedInvWrapper(upgradeSlotHandlerWrapper, chargeSlotHandler, inputSlotWrapperHandler1, inputSlotWrapperHandler2, outputSlotHandler));
	
	private final LazyOptional<IItemHandler> dropSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotHandler, inputSlotHandler1, inputSlotHandler2, outputSlotHandler));
	boolean breakBlock = false;
	
	private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
	private LazyOptional<IUpgradeMachineHandler> upgrade = LazyOptional.of(() -> upgradeHandler);

	private int sievingEnergy = 140/*PER TICK*/;
	private int WORK_TIME = 10 * 16;
		
	private static int capacity = ModConfigs.t3PoweredSieveCapacityInt;
	private static int receive = ModConfigs.t3PoweredSieveReceiveInt;
		
	private int progress = 0;
	private int upgradableSievingEnergy = 0;
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
                	return Math.max(energyStorage.getBaseCapacity(), energyStorage.getUpgradedCapacity());
    			case 3:
    				return upgradableWorkTime;
    			case 4:
    				energyStorage.getBaseCapacity();
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
            	case 4:
            		energyStorage.setBaseCapacity(value);
            		break;
            	default:
            		break;
                    
            }
        }

        @Override
        public int getCount() {
        	
            return 5;
            
        }
    };

    public TileEntityT3PoweredSieve() {
    	
        super(TileEntityHandler.TILE_ENTITY_T3_POWERED_SIEVE.get());
        
    }

	private ItemStackHandler createCharge() {
		
		return new ItemStackHandler() {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
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

	private ItemStackHandler createInput1() {
		
		return new ItemStackHandler() {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		    	
		    	if(isRecipeInput1(level, stack)) {
		    			
		    		return true;
		    		
				}

				return false;
				
			}
		};
	}

	private ItemStackHandler createInputWrapper1(ItemStackHandler inputSlotHandler1) {
		
		return new NonExtractableStackHandler(this.inputSlotHandler1) {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		    	
		    	if(isRecipeInput1(level, stack)) {
		    			
		    		return true;
		    		
				}

				return false;
				
			}
		};
	}

	private ItemStackHandler createInput2() {
		
		return new ItemStackHandler() {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		    	
		    	if(isRecipeInput2(level, stack)) {
		    			
		    		return true;
		    		
				}

				return false;
				
			}
		};
	}

	private ItemStackHandler createInputWrapper2(ItemStackHandler inputSlotHandler2) {
		
		return new NonExtractableStackHandler(this.inputSlotHandler2) {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		    	
		    	if(isRecipeInput2(level, stack)) {
		    			
		    		return true;
		    		
				}

				return false;
				
			}
		};
	}

	private ItemStackHandler createOutput() {
		
		return new ItemStackHandler(2) {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

				return false;
				
			}
		};
	}

	private ItemStackHandler createUpgrade() {

    	return new ItemStackHandler() {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
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
    			 
    			if(!(upgradeHandler.canExtractFromSlot(progress))) {
    				 
    				return ItemStack.EMPTY;
    				 
    			}
    			
    			if(energyStorage.getEnergyStored() > energyStorage.getBaseCapacity()) {
    				
    				return ItemStack.EMPTY;
    				
    			} else
    			 	
    				return super.extractItem(slot, amount, simulate);
    		 }
		};
		
    }
	
	private ItemStackHandler createUpgradeWrapper(ItemStackHandler upgradeSlotHandler) {

    	return new NonExtractableStackHandler(this.upgradeSlotHandler) {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
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
    			 
    			if(!(upgradeHandler.canExtractFromSlot(progress))) {
    				 
    				return ItemStack.EMPTY;
    				 
    			}
    			
    			if(energyStorage.getEnergyStored() > energyStorage.getBaseCapacity()) {
    				
    				return ItemStack.EMPTY;
    				
    			} else
    			 	
    				return super.extractItem(slot, amount, simulate);
    		 }
		};
    }
	
	private MechaniCraftEnergyStorage createEnergy() {

		return new MechaniCraftEnergyStorage(capacity, receive, 0) {

			@Override
			protected void onEnergyChanged() {

				setChanged();

			}
		};
	}
    
	private UpgradeMachineHandlerFactory createUpgradeHandler() {
    	
        return new UpgradeMachineHandlerFactory() {
        	
            @Override
			public void onUpgradeChanged() {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
                
            }
        };
    }

	@Override
    public void tick() {
    	
        if (this.level == null || this.level.isClientSide) {
        	
            return;
            
        }
		
		ItemStack upgradeStack = upgradeSlotHandler.getStackInSlot(0);
    	
        if(hasCapUpgrades() && energyStorage.getCapacity() != energyStorage.getUpgradedCapacity()) {
        	
        	if(upgradeStack.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
        		
        		applyCapUpgrades(upgradeStack);
        		
        	}
        }
        
        if(hasTransUpgrades() && energyStorage.getMaxReceive() != energyStorage.getUpgradedReceive()) {
        	
        	if(upgradeStack.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
        		
        		applyTransUpgrades(upgradeStack);
        		
        	}
        }
        
       if(!hasCapUpgrades() && energyStorage.getCapacity() != energyStorage.getBaseCapacity()) {
        	
        	energyStorage.setCapacity(energyStorage.getBaseCapacity());
        	
        }
        
        if(!hasTransUpgrades() && energyStorage.getMaxReceive() != energyStorage.getBaseReceive()) {
        	
        	energyStorage.setMaxReceive(energyStorage.getBaseReceive());
        	
        }

		if(energyStorage.getMaxEnergyStored() > energyStorage.getEnergyStored()) {

			if(!(chargeSlotHandler.getStackInSlot(0).equals(ItemStack.EMPTY))) {

				receivePowerItem(chargeSlotHandler.getStackInSlot(0));

			}

			else

				receivePower();

		}
		
		if(progress == 0) {
        	
        	this.setUpgradeModifiers();
        	
        }
		
    	if(canCraft()) {
    			
    		startCrafting();
    	}
    	
    	if((inputSlotHandler1.getStackInSlot(0).isEmpty() || inputSlotHandler2.getStackInSlot(0).isEmpty()) && progress > 0) {

			progress = 2;

		}
    	
    	if(!canCraft() && progress > 0) {

			progress -= 2;

		}
        
        if(canCraft() && this.level.getBlockState(this.worldPosition).getValue(T3PoweredSieve.LIT) == false) {
        	
        	this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(T3PoweredSieve.LIT, Boolean.valueOf(true)));
        	
        }
        
        if(!canCraft() && this.level.getBlockState(this.worldPosition).getValue(T3PoweredSieve.LIT) == true) {
        	
        	this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(T3PoweredSieve.LIT, Boolean.valueOf(false)));
        	
        }
    }
    
    private boolean hasTransUpgrades() {
    	
    	if(upgradeSlotHandler.getStackInSlot(0).getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
    		
    		return true;
    		
    	}
    	
    	return false;
    	
    }
    
    public boolean hasCapUpgrades() {
    	
    	if(upgradeSlotHandler.getStackInSlot(0).getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    		
    		return true;
    		
    	}
    	
    	return false;
    	
    }

	private void applyCapUpgrades(ItemStack stack) {
    		
    	if(stack.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    		
    		energyStorage.applyCapacityUpgrades(stack.getCount());
    		
    	}
    }
    
    private void applyTransUpgrades(ItemStack stack) {
    		
    	if(stack.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
    		
    		energyStorage.applyTransferUpgrades(stack.getCount());
    		
    	}
    }
    
    private void setUpgradeModifiers() {
    	
    	if(upgrade.isPresent()) {
    		
    		upgradeHandler.setUpgrade1Stack(upgradeSlotHandler.getStackInSlot(0));
    		
    		upgradeHandler.oneUpgradeModifier(WORK_TIME, sievingEnergy, upgradeSlotHandler.getStackInSlot(0));
    			
    		upgradableWorkTime = upgradeHandler.getTotalProcessingTime();
    		upgradableSievingEnergy = upgradeHandler.getTotalEnergyUsed();
    	}
    }
    
    private boolean canCraft() {
    	
    	Inventory recipeInventory = new Inventory(this.inputSlotHandler1.getStackInSlot(0), this.inputSlotHandler2.getStackInSlot(0));
    	
    	Optional<SieveRecipes> rOpt = this.level.getRecipeManager().getRecipeFor(ModRecipes.SIEVE_RECIPES, recipeInventory, this.level);
    	SieveRecipes recipe = rOpt.orElse(null);
    	
		ItemStack output = outputSlotHandler.getStackInSlot(0);
		ItemStack outputSecondary = outputSlotHandler.getStackInSlot(1);
		
		if(recipe != null) {
			ItemStack result = recipe.assemble(recipeInventory);
			ItemStack secondaryResult = recipe.assembleSecondary(recipeInventory);

			if(energyStorage.getEnergyStored() >= upgradableSievingEnergy) {

				if (result.isEmpty() || recipeInventory.getItem(0).isEmpty() || recipeInventory.getItem(1).isEmpty()) {

					return false;
				}

				if ((output.getCount() + result.getCount()) > output.getMaxStackSize()) {

					return false;
				}
					
				if ((secondaryResult.getCount() + outputSecondary.getCount()) > outputSecondary.getMaxStackSize()) {

					return false;
				}
				
				if (output.isEmpty() || output.getItem().equals(result.getItem())) {

					if(outputSecondary.isEmpty() || outputSecondary.getItem().equals(secondaryResult.getItem()) || secondaryResult.equals(ItemStack.EMPTY)) {
					
						return true;
					}
				}
			}
			
			return false;
		}

		else return false;
    }
    
    private void startCrafting() {
    	
    	Inventory recipeInventory = new Inventory(this.inputSlotHandler1.getStackInSlot(0), this.inputSlotHandler2.getStackInSlot(0));
    	
    	Optional<SieveRecipes> rOpt = this.level.getRecipeManager().getRecipeFor(ModRecipes.SIEVE_RECIPES, recipeInventory, this.level);
    	SieveRecipes recipe = rOpt.orElse(null);
    	
    	ItemStack output = outputSlotHandler.getStackInSlot(0);
		ItemStack outputSecondary = outputSlotHandler.getStackInSlot(1);
		ItemStack result = recipe.assemble(recipeInventory);
		ItemStack secondaryResult = recipe.assembleSecondary(recipeInventory);

		if(canCraft()) {

			if(progress < upgradableWorkTime) {

				++progress;
				energyStorage.consumeEnergy(upgradableSievingEnergy);
			}

			if (progress >= upgradableWorkTime) {

				if(secondaryResult.equals(ItemStack.EMPTY) && output.isEmpty()) {
					
					outputSlotHandler.setStackInSlot(0, result.copy());
					progress = 0;
					inputSlotHandler1.extractItem(0, 1, false);
					
					if(inputSlotHandler2.getStackInSlot(0).getMaxDamage() - inputSlotHandler2.getStackInSlot(0).getDamageValue() > 1) {
						
						inputSlotHandler2.getStackInSlot(0).setDamageValue(inputSlotHandler2.getStackInSlot(0).getDamageValue() + 1);
						
					} else inputSlotHandler2.setStackInSlot(0, ItemStack.EMPTY);
				}
				
				if(secondaryResult.equals(ItemStack.EMPTY) && output.getItem().equals(result.getItem()) && output.getCount() < result.getMaxStackSize()) {
					
					output.grow(result.getCount());
					progress = 0;
					inputSlotHandler1.extractItem(0, 1, false);
					
					if(inputSlotHandler2.getStackInSlot(0).getMaxDamage() - inputSlotHandler2.getStackInSlot(0).getDamageValue() > 1) {
						
						inputSlotHandler2.getStackInSlot(0).setDamageValue(inputSlotHandler2.getStackInSlot(0).getDamageValue() + 1);
						
					} else inputSlotHandler2.setStackInSlot(0, ItemStack.EMPTY);
				}
				
				if(!secondaryResult.equals(ItemStack.EMPTY) && output.isEmpty() && outputSecondary.isEmpty()) {
					
					outputSlotHandler.setStackInSlot(0, result.copy());
					outputSlotHandler.setStackInSlot(1, secondaryResult.copy());
					progress = 0;
					inputSlotHandler1.extractItem(0, 1, false);
					
					if(inputSlotHandler2.getStackInSlot(0).getMaxDamage() - inputSlotHandler2.getStackInSlot(0).getDamageValue() > 1) {
						
						inputSlotHandler2.getStackInSlot(0).setDamageValue(inputSlotHandler2.getStackInSlot(0).getDamageValue() + 1);
						
					} else inputSlotHandler2.setStackInSlot(0, ItemStack.EMPTY);
				}
				
				if(!secondaryResult.equals(ItemStack.EMPTY) && output.getItem().equals(result.getItem()) && output.getCount() < result.getMaxStackSize() && outputSecondary.isEmpty()) {
					
					output.grow(result.getCount());
					outputSlotHandler.setStackInSlot(1, secondaryResult.copy());
					progress = 0;
					inputSlotHandler1.extractItem(0, 1, false);
					
					if(inputSlotHandler2.getStackInSlot(0).getMaxDamage() - inputSlotHandler2.getStackInSlot(0).getDamageValue() > 1) {
						
						inputSlotHandler2.getStackInSlot(0).setDamageValue(inputSlotHandler2.getStackInSlot(0).getDamageValue() + 1);
						
					} else inputSlotHandler2.setStackInSlot(0, ItemStack.EMPTY);
				}
				
				if(!secondaryResult.equals(ItemStack.EMPTY) && output.isEmpty() && outputSecondary.getItem().equals(secondaryResult.getItem()) && outputSecondary.getCount() < secondaryResult.getMaxStackSize()) {
					
					outputSlotHandler.setStackInSlot(0, result.copy());
					outputSecondary.grow(secondaryResult.getCount());
					progress = 0;
					inputSlotHandler1.extractItem(0, 1, false);
					
					if(inputSlotHandler2.getStackInSlot(0).getMaxDamage() - inputSlotHandler2.getStackInSlot(0).getDamageValue() > 1) {
						
						inputSlotHandler2.getStackInSlot(0).setDamageValue(inputSlotHandler2.getStackInSlot(0).getDamageValue() + 1);
						
					} else inputSlotHandler2.setStackInSlot(0, ItemStack.EMPTY);
				}
				
				if(!secondaryResult.equals(ItemStack.EMPTY) && output.getItem().equals(result.getItem()) && output.getCount() < result.getMaxStackSize() && 
				    outputSecondary.getItem().equals(secondaryResult.getItem()) && outputSecondary.getCount() < secondaryResult.getMaxStackSize()) {
					
					output.grow(result.getCount());
					outputSecondary.grow(secondaryResult.getCount());
					
					progress = 0;
					inputSlotHandler1.extractItem(0, 1, false);
					
					if(inputSlotHandler2.getStackInSlot(0).getMaxDamage() - inputSlotHandler2.getStackInSlot(0).getDamageValue() > 1) {
						
						inputSlotHandler2.getStackInSlot(0).setDamageValue(inputSlotHandler2.getStackInSlot(0).getDamageValue() + 1);
						
					} else inputSlotHandler2.setStackInSlot(0, ItemStack.EMPTY);
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
	
	public static Iterable<SieveRecipes> getRecipes(World world) {
		
        Collection<SieveRecipes> unfilteredRecipes = world.getRecipeManager().getAllRecipesFor(ModRecipes.SIEVE_RECIPES);
        
        return Iterables.filter(unfilteredRecipes, SieveRecipes.class);
    }
	
	public static boolean isRecipeInput1(World world, ItemStack stack) {
		
        for (SieveRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInput1().test(stack)) {
            	
                return true;
                
            }
        }

        return false;
    }
	
	public static boolean isRecipeInput2(World world, ItemStack stack) {
		
        for (SieveRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInput2().test(stack)) {
            	
                return true;
                
            }
        }

        return false;
    }

    @Override
	public ITextComponent getDisplayName() {

		return new TranslationTextComponent("container.mechanicraft.t3_powered_sieve");
		
	}

    @Nullable
    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity playerEntity) {
    	
        assert level != null;
		return new ContainerT3PoweredSieve(this, this.fields, id, playerInventory, new CombinedInvWrapper(upgradeSlotHandler, chargeSlotHandler, inputSlotHandler1, inputSlotHandler2, outputSlotHandler));
        
    }



    @Override
    public void load(BlockState state, CompoundNBT tags) {
    	
        super.load(state, tags);
        this.progress = tags.getInt("Progress");
		this.upgradableSievingEnergy = tags.getInt("SievingEnergy");
		this.upgradableWorkTime = tags.getInt("ProcessingTime");
		this.energyStorage.deserializeNBT(tags.getCompound("energy"));
		this.upgradeSlotHandler.deserializeNBT(tags.getCompound("upgradeSlot"));
		this.chargeSlotHandler.deserializeNBT(tags.getCompound("chargeSlot"));
        this.inputSlotHandler1.deserializeNBT(tags.getCompound("inputSlot1"));
        this.inputSlotHandler2.deserializeNBT(tags.getCompound("inputSlot2"));
		this.outputSlotHandler.deserializeNBT(tags.getCompound("outputSlot"));
        
    }

    @Override
    public CompoundNBT save(CompoundNBT tags) {
    	
        super.save(tags);
		tags.putInt("Progress", this.progress);
		tags.put("energy", energyStorage.serializeNBT());
		tags.putInt("SievingEnergy", upgradableSievingEnergy);
		tags.putInt("ProcessingTime", upgradableWorkTime);
		tags.put("chargeSlot", chargeSlotHandler.serializeNBT());
		tags.put("upgradeSlot", upgradeSlotHandler.serializeNBT());
        tags.put("inputSlot1", inputSlotHandler1.serializeNBT());
		tags.put("inputSlot2", inputSlotHandler2.serializeNBT());
		tags.put("outputSlot", outputSlotHandler.serializeNBT());
        tags.putInt("Progress", this.progress);
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
    	
        CompoundNBT tags = super.getUpdateTag();
		tags.putInt("Progress", this.progress);
		tags.put("energy", energyStorage.serializeNBT());
		tags.putInt("SievingEnergy", upgradableSievingEnergy);
		tags.putInt("ProcessingTime", upgradableWorkTime);
        return tags;
        
    }

	boolean blockBeingBroken(boolean onRemoved) {
		
		return breakBlock = onRemoved;
	}

    @Nullable
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
    	
        if (!this.remove && side != null) {
        	
        	if(cap == CapabilityEnergy.ENERGY) {
        		
        		return energy.cast();
        		
        	}
        	
        	if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
        	
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
		upgradeSlotWrapper.invalidate();
    	inputSlotWrapper1.invalidate();
    	inputSlotWrapper2.invalidate();
		outputSlot.invalidate();
		chargeSlot.invalidate();
		allSlots.invalidate();
		dropSlots.invalidate();
        super.setRemoved();

    }
}