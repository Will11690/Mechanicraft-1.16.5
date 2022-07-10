package com.github.will11690.mechanicraft.blocks.machines.adv.advfurnace;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.init.ModItems;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;
import com.github.will11690.mechanicraft.util.capabilities.factory.UpgradeMachineHandlerFactory;
import com.github.will11690.mechanicraft.util.capabilities.interfaces.IUpgradeMachineHandler;
import com.github.will11690.mechanicraft.util.handlers.NonExtractableStackHandler;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeManager;
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
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

public class TileEntityAdvancedFurnace extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

	//TODO Clean this up and assign ItemStackHandlers via CombinedInvWrapper instead of per slot
	
	MechaniCraftEnergyStorage energyStorage = createEnergy();
	UpgradeMachineHandlerFactory upgradeHandler = createUpgrade();
	
	private ItemStackHandler inputSlotHandler1 = createInput1();
	private ItemStackHandler inputSlotWrapperHandler1 = createInputWrapper1(inputSlotHandler1);
	private ItemStackHandler outputSlotHandler1 = createOutput1();
	
	private ItemStackHandler inputSlotHandler2 = createInput2();
	private ItemStackHandler inputSlotWrapperHandler2 = createInputWrapper2(inputSlotHandler2);
	private ItemStackHandler outputSlotHandler2 = createOutput2();
	
    public ItemStackHandler upgradeSlotHandler = createUpgradeHandler();
    private ItemStackHandler upgradeSlotHandlerWrapper = createUpgradeWrapper(upgradeSlotHandler);
    
	private ItemStackHandler chargeSlotHandler = createCharge();
	
	private LazyOptional<IItemHandler> inputSlotWrapper1  = LazyOptional.of(() -> inputSlotWrapperHandler1);
	private LazyOptional<IItemHandler> outputSlot1  = LazyOptional.of(() -> outputSlotHandler1);
	
	private LazyOptional<IItemHandler> inputSlotWrapper2  = LazyOptional.of(() -> inputSlotWrapperHandler2);
	private LazyOptional<IItemHandler> outputSlot2  = LazyOptional.of(() -> outputSlotHandler2);
	
	private LazyOptional<IItemHandler> upgradeSlotWrapper  = LazyOptional.of(() -> upgradeSlotHandlerWrapper);
	
	private LazyOptional<IItemHandler> chargeSlot  = LazyOptional.of(() -> chargeSlotHandler);
	
	private final LazyOptional<IItemHandler> allSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotHandler, upgradeSlotHandlerWrapper, inputSlotWrapperHandler1, inputSlotWrapperHandler2, outputSlotHandler1, outputSlotHandler2));
	
	private final LazyOptional<IItemHandler> dropSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotHandler, inputSlotHandler1, inputSlotHandler2, outputSlotHandler1, outputSlotHandler2));
	boolean breakBlock = false;

	private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
	private LazyOptional<IUpgradeMachineHandler> upgrade = LazyOptional.of(() -> upgradeHandler);
	
	//TODO Create config for energy consumed and working times

	private int smeltingEnergy = 50/*PER TICK*/;
	private int WORK_TIME = 10 * 20;
	
	private static final int capacity = 500000;
	private static final int receive = 2500;
	
	private int progress1 = 0;
	private int progress2 = 0;
	private int upgradableSmeltingEnergy = 0;
	private int upgradableWorkTime = 0;
	

	private final IIntArray fields = new IIntArray() {

		@Override
		public int get(int index) {

			switch (index) {

			case 0:
				return energyStorage.getEnergyStored();
			case 1:
				return progress1;
			case 2:
				return Math.max(energyStorage.getBaseCapacity(), energyStorage.getUpgradedCapacity());
			case 3:
				return progress2;
			case 4:
				return upgradableWorkTime;
			case 5:
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
				progress1 = value;
				break;
			case 2:
				energyStorage.setCapacity(value);
				break;
			case 3:
				progress2 = value;
				break;
			case 4:
				upgradableWorkTime = value;
				break;
			case 5:
				energyStorage.setBaseCapacity(value);
				break;
			default:
				break;

			}
		}

		@Override
		public int getCount() {
        	
			return 6;
            
		}
	};

	public TileEntityAdvancedFurnace() {

		super(TileEntityHandler.TILE_ENTITY_ADVANCED_FURNACE.get());

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

	private ItemStackHandler createUpgradeHandler() {

    	return new ItemStackHandler(2) {
    		
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
    			 
    			if(!(upgradeHandler.canExtractFromSlot(progress1 +  progress2))) {
    				 
    				return ItemStack.EMPTY;
    				 
    			}
    			
    			if(energyStorage.getEnergyStored() > energyStorage.getBaseCapacity()) {
    				
    				return ItemStack.EMPTY;
    				
    			} else
    			 	
    				return super.extractItem(slot, amount, simulate);
    		 }
		};
		
    }
	
	private ItemStackHandler createUpgradeWrapper(ItemStackHandler upgradeSlot1Handler) {

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
    			 
    			if(!(upgradeHandler.canExtractFromSlot(progress1 +  progress2))) {
    				 
    				return ItemStack.EMPTY;
    				 
    			}
    			
    			if(energyStorage.getEnergyStored() > energyStorage.getBaseCapacity()) {
    				
    				return ItemStack.EMPTY;
    				
    			} else
    			 	
    				return super.extractItem(slot, amount, simulate);
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

				Optional<FurnaceRecipe> recipe = getRecipeForInput1(level, stack);

				if(recipe.isPresent() && !(ItemStack.matches(getResultForItem1(level, stack), stack))) {

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

				Optional<FurnaceRecipe> recipe = getRecipeForInput2(level, stack);

				if(recipe.isPresent() && !(ItemStack.matches(getResultForItem2(level, stack), stack))) {

					return true;

				}

				return false;
				
			}
		};
	}
	
	private ItemStackHandler createInputWrapper1(ItemStackHandler inputSlot) {
		
		return new NonExtractableStackHandler(this.inputSlotHandler1) {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

				Optional<FurnaceRecipe> recipe = getRecipeForInput1(level, stack);

				if(recipe.isPresent() && !(ItemStack.matches(getResultForItem1(level, stack), stack))) {

					return true;

				}

				return false;
				
			}
		};
	}
	
	private ItemStackHandler createInputWrapper2(ItemStackHandler inputSlot) {
		
		return new NonExtractableStackHandler(this.inputSlotHandler2) {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

				Optional<FurnaceRecipe> recipe = getRecipeForInput2(level, stack);

				if(recipe.isPresent() && !(ItemStack.matches(getResultForItem2(level, stack), stack))) {

					return true;

				}

				return false;
				
			}
		};
	}
	
	private ItemStackHandler createOutput1() {
		
		return new ItemStackHandler() {
    		
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
	
	private ItemStackHandler createOutput2() {
		
		return new ItemStackHandler() {
    		
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
	
	private MechaniCraftEnergyStorage createEnergy() {

		return new MechaniCraftEnergyStorage(capacity, receive, 0) {

			@Override
			protected void onEnergyChanged() {

				setChanged();

			}
		};
	}
    
	private UpgradeMachineHandlerFactory createUpgrade() {
    	
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
		
        ItemStack upgradeStack1 = upgradeSlotHandler.getStackInSlot(0);
        ItemStack upgradeStack2 = upgradeSlotHandler.getStackInSlot(1);
    	
        if(hasCapUpgrades() && energyStorage.getCapacity() != energyStorage.getUpgradedCapacity()) {
        	
        	if(upgradeStack1.getItem().equals(ModItems.CAPACITY_UPGRADE.get()) || upgradeStack2.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
        		
        		applyCapUpgrades(upgradeStack1, upgradeStack2);
        		
        	}
        }
        
        if(hasTransUpgrades() && (energyStorage.getMaxExtract() != energyStorage.getUpgradedExtract()) &&
        						 (energyStorage.getMaxReceive() != energyStorage.getUpgradedReceive())) {
        	
        	if(upgradeStack1.getItem().equals(ModItems.TRANSFER_UPGRADE.get()) || upgradeStack2.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
        		
        		applyTransUpgrades(upgradeStack1, upgradeStack2);
        		
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

		if((!canSmelt1() && !canSmelt2()) && this.level.getBlockState(this.worldPosition).getValue(AdvancedFurnace.LIT) == true) {

			this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(AdvancedFurnace.LIT, Boolean.valueOf(false)));

		}
        
        if(progress1 + progress2 == 0) {
        	
        	this.setUpgradeModifiers();
        	
        }

		if(canSmelt1()) {

			startSmelting1();

		}
		
		if(canSmelt2()) {

			startSmelting2();

		}
        
		if(inputSlotHandler1.getStackInSlot(0).equals(ItemStack.EMPTY) && progress1 > 0) {

			progress1 = 0;

		}
		
		if(inputSlotHandler2.getStackInSlot(0).equals(ItemStack.EMPTY) && progress2 > 0) {

			progress2 = 0;

		}

		if(!canSmelt1() && progress1 > 0) {

			progress1 -= 2;

		}if(!canSmelt2() && progress2 > 0) {

			progress2 -= 2;

		}

		if((canSmelt1() || canSmelt2()) && this.level.getBlockState(this.worldPosition).getValue(AdvancedFurnace.LIT) == false) {

			this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(AdvancedFurnace.LIT, Boolean.valueOf(true)));

		}
	}

	private boolean canSmelt1() {

		ItemStack input = inputSlotHandler1.getStackInSlot(0);
		ItemStack output = outputSlotHandler1.getStackInSlot(0);

		ItemStack result = getResultForItem1(level, input);

		if(energyStorage.getEnergyStored() >= upgradableSmeltingEnergy) {

			if (result.isEmpty() || input.isEmpty()) {

				return false;

			}

			if ((output.getCount() + result.getCount()) > output.getMaxStackSize()) {

				return false;

			}

			if (output.isEmpty() || output.getItem().equals(result.getItem())) {

				return true;

			}

			return false;

		}

		else return false;

	}
	
	private boolean canSmelt2() {

		ItemStack input = inputSlotHandler2.getStackInSlot(0);
		ItemStack output = outputSlotHandler2.getStackInSlot(0);

		ItemStack result = getResultForItem2(level, input);

		if(energyStorage.getEnergyStored() >= upgradableSmeltingEnergy) {

			if (result.isEmpty() || input.isEmpty()) {

				return false;

			}

			if ((output.getCount() + result.getCount()) > output.getMaxStackSize()) {

				return false;

			}

			if (output.isEmpty() || output.getItem().equals(result.getItem())) {

				return true;

			}

			return false;

		}

		else return false;

	}

	private void startSmelting1() {

		ItemStack input = inputSlotHandler1.getStackInSlot(0);
		ItemStack output = outputSlotHandler1.getStackInSlot(0);

		ItemStack result = getResultForItem1(level, input);

		if(canSmelt1()) {

			if(progress1 < upgradableWorkTime) {

				++progress1;
				energyStorage.consumeEnergy(upgradableSmeltingEnergy);

			}

			if (progress1 >= upgradableWorkTime) {

				if(output.isEmpty()) {

					outputSlotHandler1.setStackInSlot(0, result.copy());
					progress1 = 0;
					inputSlotHandler1.extractItem(0, 1, false);

				} else {

					if(output.getItem().equals(result.getItem()) && output.getCount() < result.getMaxStackSize()) {

						output.grow(result.getCount());
						progress1 = 0;
						inputSlotHandler1.extractItem(0, 1, false);

					}
				}
			}
		}
	}

	private void startSmelting2() {

		ItemStack input = inputSlotHandler2.getStackInSlot(0);
		ItemStack output = outputSlotHandler2.getStackInSlot(0);

		ItemStack result = getResultForItem2(level, input);

		if(canSmelt2()) {

			if(progress2 < upgradableWorkTime) {

				++progress2;
				energyStorage.consumeEnergy(upgradableSmeltingEnergy);

			}

			if (progress2 >= upgradableWorkTime) {

				if(output.isEmpty()) {

					outputSlotHandler2.setStackInSlot(0, result.copy());
					progress2 = 0;
					inputSlotHandler2.extractItem(0, 1, false);

				} else {

					if(output.getItem().equals(result.getItem()) && output.getCount() < result.getMaxStackSize()) {

						output.grow(result.getCount());
						progress2 = 0;
						inputSlotHandler2.extractItem(0, 1, false);

					}
				}
			}
		}
	}
	
	private boolean hasTransUpgrades() {
    	
    	if(upgradeSlotHandler.getStackInSlot(0).getItem().equals(ModItems.TRANSFER_UPGRADE.get()) || upgradeSlotHandler.getStackInSlot(1).getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
    		
    		return true;
    	}
    	
    	return false;
    }
    
    public boolean hasCapUpgrades() {
    	
    	if(upgradeSlotHandler.getStackInSlot(0).getItem().equals(ModItems.CAPACITY_UPGRADE.get()) || upgradeSlotHandler.getStackInSlot(1).getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    		
    		return true;
    	}
    	
    	return false;
    }

	private void applyCapUpgrades(ItemStack stack1, ItemStack stack2) {
		
    	int capUpgradeCount = 0;
    	int modify1;
    	int modify2;
			
		if(stack1.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
		
			modify1 = stack1.getCount();
			
		} else {
				
			modify1 = 0;
				
		}
			
		if(stack2.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
		
			modify2 = stack2.getCount();
				
		} else {
				
			modify2 = 0;
				
		}
			
		capUpgradeCount = modify1 + modify2;
		
		if(capUpgradeCount > 0) {
				
			energyStorage.applyCapacityUpgrades(capUpgradeCount);
			
		} 
    }
    
    private void applyTransUpgrades(ItemStack stack1, ItemStack stack2) {
		
    	int transUpgradeCount = 0;
    	int modify1;
    	int modify2;
			
		if(stack1.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
		
			modify1 = stack1.getCount();
			
		} else {
			
			modify1 = 0;
		}
			
		if(stack2.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
		
			modify2 = stack2.getCount();
			
		} else {
			
			modify2 = 0;
		}
			
		transUpgradeCount = modify1 + modify2;
		
		if(transUpgradeCount > 0) {
			
			energyStorage.applyTransferUpgrades(transUpgradeCount);
		
		}
    }
    
    private void setUpgradeModifiers() {
    	
    	if(upgrade.isPresent()) {
    		
    		upgradeHandler.setUpgrade1Stack(upgradeSlotHandler.getStackInSlot(0));
    		upgradeHandler.setUpgrade2Stack(upgradeSlotHandler.getStackInSlot(1));
    		
    		upgradeHandler.twoUpgradeModifier(WORK_TIME, smeltingEnergy, upgradeSlotHandler.getStackInSlot(0), upgradeSlotHandler.getStackInSlot(1));
    			
    		upgradableWorkTime = upgradeHandler.getTotalProcessingTime();
    		upgradableSmeltingEnergy = upgradeHandler.getTotalEnergyUsed();
    	}
    }

	public static Optional<FurnaceRecipe> getRecipeForInput1(World world, ItemStack itemStack) {

		RecipeManager recipeManager = world.getRecipeManager();
		Inventory singleItemInventory = new Inventory(itemStack);

		Optional<FurnaceRecipe> recipe = recipeManager.getRecipeFor(IRecipeType.SMELTING, singleItemInventory, world);

		return recipe;

	}

	public static ItemStack getResultForItem1(World world, ItemStack itemStack) {

		Optional<FurnaceRecipe> recipe = getRecipeForInput1(world, itemStack);
		if (!recipe.isPresent()) return ItemStack.EMPTY;

		return recipe.get().getResultItem().copy();

	}
	
	public static Optional<FurnaceRecipe> getRecipeForInput2(World world, ItemStack itemStack) {

		RecipeManager recipeManager = world.getRecipeManager();
		Inventory singleItemInventory = new Inventory(itemStack);

		Optional<FurnaceRecipe> recipe = recipeManager.getRecipeFor(IRecipeType.SMELTING, singleItemInventory, world);

		return recipe;

	}

	public static ItemStack getResultForItem2(World world, ItemStack itemStack) {

		Optional<FurnaceRecipe> recipe = getRecipeForInput2(world, itemStack);
		if (!recipe.isPresent()) return ItemStack.EMPTY;

		return recipe.get().getResultItem().copy();

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
		return new ContainerAdvancedFurnace(this, this.fields, id, playerInventory, new CombinedInvWrapper(chargeSlotHandler, upgradeSlotHandler, inputSlotHandler1, inputSlotHandler2, outputSlotHandler1, outputSlotHandler2));

	}

	@Override
	public void load(BlockState state, CompoundNBT tags) {

		super.load(state, tags);
		this.progress1 = tags.getInt("Progress1");
		this.progress2 = tags.getInt("Progress2");
		this.upgradableSmeltingEnergy = tags.getInt("SmeltingEnergy");
		this.upgradableWorkTime = tags.getInt("ProcessingTime");
		this.energyStorage.deserializeNBT(tags.getCompound("energy"));
		this.inputSlotHandler1.deserializeNBT(tags.getCompound("inputSlot1"));
		this.outputSlotHandler1.deserializeNBT(tags.getCompound("outputSlot1"));
		this.inputSlotHandler2.deserializeNBT(tags.getCompound("inputSlot2"));
		this.outputSlotHandler2.deserializeNBT(tags.getCompound("outputSlot2"));
		this.chargeSlotHandler.deserializeNBT(tags.getCompound("chargeSlot"));
		this.upgradeSlotHandler.deserializeNBT(tags.getCompound("upgradeSlot"));

	}

	@Override
	public CompoundNBT save(CompoundNBT tags) {

		super.save(tags);
		tags.putInt("Progress1", this.progress1);
		tags.putInt("Progress2", this.progress2);
		tags.putInt("SmeltingEnergy", upgradableSmeltingEnergy);
		tags.putInt("ProcessingTime", upgradableWorkTime);
		tags.put("energy", energyStorage.serializeNBT());
		tags.put("inputSlot1", inputSlotHandler1.serializeNBT());
		tags.put("outputSlot1", outputSlotHandler1.serializeNBT());
		tags.put("inputSlot2", inputSlotHandler2.serializeNBT());
		tags.put("outputSlot2", outputSlotHandler2.serializeNBT());
		tags.put("chargeSlot", chargeSlotHandler.serializeNBT());
		tags.put("upgradeSlot", upgradeSlotHandler.serializeNBT());
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
		inputSlotWrapper1.invalidate();
		outputSlot1.invalidate();
		upgradeSlotWrapper.invalidate();
		inputSlotWrapper2.invalidate();
		outputSlot2.invalidate();
		chargeSlot.invalidate();
		allSlots.invalidate();
		dropSlots.invalidate();
		super.setRemoved();

	}

	@Override
	public ITextComponent getDisplayName() {

		return new TranslationTextComponent("container.mechanicraft.advanced_furnace");

	}
}