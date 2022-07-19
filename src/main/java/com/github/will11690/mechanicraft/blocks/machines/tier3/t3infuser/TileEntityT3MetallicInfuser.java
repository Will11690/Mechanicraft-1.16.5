package com.github.will11690.mechanicraft.blocks.machines.tier3.t3infuser;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.init.ModConfigs;
import com.github.will11690.mechanicraft.init.ModItems;
import com.github.will11690.mechanicraft.init.ModRecipes;
import com.github.will11690.mechanicraft.recipes.Infuser.InfuserRecipes;
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
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

public class TileEntityT3MetallicInfuser extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

	//TODO Clean this up and assign ItemStackHandlers via CombinedInvWrapper instead of per slot
	
	private MechaniCraftEnergyStorage energyStorage = createEnergy();
	UpgradeMachineHandlerFactory upgradeHandler = createUpgradeHandler();
	
	private ItemStackHandler inputSlotHandler1 = createInput1();
	private ItemStackHandler inputSlotWrapperHandler1 = createInputWrapper1(inputSlotHandler1);
	private ItemStackHandler inputSlotHandler2 = createInput2();
	private ItemStackHandler inputSlotWrapperHandler2 = createInputWrapper2(inputSlotHandler2);
	
	ItemStackHandler upgradeSlotHandler = createUpgrade();
    private ItemStackHandler upgradeSlotHandlerWrapper = createUpgradeWrapper(upgradeSlotHandler);
    
	private ItemStackHandler chargeSlotHandler = createCharge();
	private ItemStackHandler outputSlotHandler = createOutput();
	
	private final LazyOptional<IItemHandler> inputSlotWrapper1  = LazyOptional.of(() -> inputSlotWrapperHandler1);
	private final LazyOptional<IItemHandler> inputSlotWrapper2  = LazyOptional.of(() -> inputSlotWrapperHandler2);
	private final LazyOptional<IItemHandler> upgradeSlotWrapper  = LazyOptional.of(() -> upgradeSlotHandlerWrapper);
	private final LazyOptional<IItemHandler> outputSlot  = LazyOptional.of(() -> outputSlotHandler);
	private final LazyOptional<IItemHandler> chargeSlot  = LazyOptional.of(() -> chargeSlotHandler);
	
	private final LazyOptional<IItemHandler> allSlots  = LazyOptional.of(() -> new CombinedInvWrapper(upgradeSlotHandlerWrapper, chargeSlotHandler, inputSlotWrapperHandler1, inputSlotWrapperHandler2, outputSlotHandler));
	
	private final LazyOptional<IItemHandler> dropSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotHandler, inputSlotHandler1, inputSlotHandler2, outputSlotHandler));
	boolean breakBlock = false;
	
	private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
	private LazyOptional<IUpgradeMachineHandler> upgrade = LazyOptional.of(() -> upgradeHandler);

	private int infusingEnergy = ModConfigs.t3InfuserEnergyPerTickInt/*PER TICK*/;
	private int WORK_TIME = ModConfigs.t3InfuserWorkTimeInt;
		
	private static int capacity = ModConfigs.t3InfuserCapacityInt;
	private static int receive = ModConfigs.t3InfuserReceiveInt;
		
	private int progress = 0;
	private int upgradableInfusingEnergy = 0;
	private int upgradableWorkTime = 0;

    private final IIntArray fields = new IIntArray() {
    	
        @Override
        public int get(int index) {
        	
            switch (index) {
            
                case 0:
                	return progress;
    			case 1:
    				return upgradableWorkTime;
                default:
                    return 0;
                    
            }
        }

        @Override
        public void set(int index, int value) {
        	
            switch (index) {
            
            	case 0:
            		progress = value;
            		break;
            	case 1:
            		upgradableWorkTime = value;
            		break;
            	default:
            		break;
                    
            }
        }

        @Override
        public int getCount() {
        	
            return 2;
            
        }
    };

    public TileEntityT3MetallicInfuser() {
    	
        super(TileEntityHandler.TILE_ENTITY_T3_METALLIC_INFUSER.get());
        
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

	private ItemStackHandler createInput1() {
		
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
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
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
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
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
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
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
    	
    	if((inputSlotHandler1.getStackInSlot(0).isEmpty() || inputSlotHandler2.getStackInSlot(0).isEmpty()) && progress > 0) {

			progress = 0;

		}
    	
    	if(!canCraft() && progress > 0) {

			progress -= 2;

		}
        
        if(canCraft() && this.level.getBlockState(this.worldPosition).getValue(T3MetallicInfuser.LIT) == false) {
        	
        	this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(T3MetallicInfuser.LIT, Boolean.valueOf(true)));
        	
        }
        
        if(!canCraft() && this.level.getBlockState(this.worldPosition).getValue(T3MetallicInfuser.LIT) == true) {
        	
        	this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(T3MetallicInfuser.LIT, Boolean.valueOf(false)));
        	
        }
    }
    
    private void setUpgradeModifiers() {
    	
    	if(upgrade.isPresent()) {
    	
    		if(progress == 0) {
    		
    			upgradeHandler.setUpgrade1Stack(upgradeSlotHandler.getStackInSlot(0));
        		
        		upgradeHandler.oneUpgradeModifier(WORK_TIME, infusingEnergy, upgradeSlotHandler.getStackInSlot(0));
        			
        		upgradableWorkTime = upgradeHandler.getTotalProcessingTime();
        		upgradableInfusingEnergy = upgradeHandler.getTotalEnergyUsed();
    		}
    	}
    	
    	if(energy.isPresent()) {
    		
    		energyStorage.setUpgrade1Stack(upgradeSlotHandler.getStackInSlot(0));
    		energyStorage.oneUpgradeModifier(capacity, receive, 0, upgradeSlotHandler.getStackInSlot(0));
    		
    	}
    }

	public boolean canExtractCapacity() {
		
		if(energy.isPresent()) {
			
			return energyStorage.canExtractFromSlot(energyStorage.getEnergyStored());
			
		} else 
			return false;
	}
    
    private boolean canCraft() {
    	
    	if(allSlots.isPresent()) {
    	
    		Inventory recipeInventory = new Inventory(this.inputSlotHandler1.getStackInSlot(0), this.inputSlotHandler2.getStackInSlot(0));
    	
    		Optional<InfuserRecipes> rOpt = this.level.getRecipeManager().getRecipeFor(ModRecipes.INFUSER_RECIPES, recipeInventory, this.level);
    		InfuserRecipes recipe = rOpt.orElse(null);
    	
    		int outputHandlerCount = 0;
    	
    		ItemStack output = ItemStack.EMPTY;
    		if(!this.inputSlotHandler1.getStackInSlot(0).equals(ItemStack.EMPTY) && !this.inputSlotHandler2.getStackInSlot(0).equals(ItemStack.EMPTY)) {
    		
    			if(recipe != null)
    				output = recipe.assemble(recipeInventory).copy();
    		}
    	
    		ItemStack outputHandler = outputSlotHandler.getStackInSlot(0);
    	
    		if(!(outputHandler.equals(ItemStack.EMPTY))) {
    		
    			outputHandlerCount = outputHandler.getCount();
    		}
    	
    		if(energyStorage.getEnergyStored() >= upgradableInfusingEnergy) {
    	
    			if(recipe != null && (output.getItem().equals(outputHandler.getItem()) || outputHandler.equals(ItemStack.EMPTY)) && (output.getCount() + outputHandlerCount <= outputHandler.getMaxStackSize())) {
    		
    				return true;
    			}
    		}
    		return false;
    	}
    	return false;
    }
    
    private void startCrafting() {
    	
    	Inventory recipeInventory = new Inventory(this.inputSlotHandler1.getStackInSlot(0), this.inputSlotHandler2.getStackInSlot(0));
    	Inventory outputInventory = new Inventory(this.outputSlotHandler.getStackInSlot(0));
    	
    	Optional<InfuserRecipes> rOpt = this.level.getRecipeManager().getRecipeFor(ModRecipes.INFUSER_RECIPES, recipeInventory, this.level);
    	InfuserRecipes recipe = rOpt.orElse(null);
    	
    	ItemStack current = outputInventory.getItem(0);
    	ItemStack output = recipe.assemble(recipeInventory);
    	
    	if(canCraft()) {
    		
    		if (progress < upgradableWorkTime) {
    			
    			++progress;
    			energyStorage.consumeEnergy(upgradableInfusingEnergy);
    			
    		}

    		if (progress >= upgradableWorkTime) {
    			
    			if(current.isEmpty()) {
    				
    				outputInventory.setItem(0, output.copy());
    				outputSlotHandler.setStackInSlot(0, outputInventory.getItem(0));
    				progress = 0;
    				recipeInventory.removeItem(0, 1);
    				recipeInventory.removeItem(1, 1);
    				
    			} else {
    				
    				if(current.getItem().equals(output.getItem()) && current.getCount() < output.getMaxStackSize()) {
    					
    					current.grow(output.getCount());
    					outputSlotHandler.setStackInSlot(0, outputInventory.getItem(0));
    					progress = 0;
    					recipeInventory.removeItem(0, 1);
    					recipeInventory.removeItem(1, 1);
    					
    				}
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
	
	public static Iterable<InfuserRecipes> getRecipes(World world) {
		
        Collection<InfuserRecipes> unfilteredRecipes = world.getRecipeManager().getAllRecipesFor(ModRecipes.INFUSER_RECIPES);
        
        return Iterables.filter(unfilteredRecipes, InfuserRecipes.class);
    }
	
	public static boolean isRecipeInput1(World world, ItemStack stack) {
		
        for (InfuserRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInput1().test(stack)) {
            	
                return true;
                
            }
        }

        return false;
    }
	
	public static boolean isRecipeInput2(World world, ItemStack stack) {
		
        for (InfuserRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInput2().test(stack)) {
            	
                return true;
                
            }
        }

        return false;
    }

    @Override
	public ITextComponent getDisplayName() {

		return new TranslationTextComponent("container.mechanicraft.t3_metallic_infuser");
		
	}

    @Nullable
    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity playerEntity) {
    	
        assert level != null;
		return new ContainerT3MetallicInfuser(this, this.fields, id, playerInventory, new CombinedInvWrapper(upgradeSlotHandler, chargeSlotHandler, inputSlotHandler1, inputSlotHandler2, outputSlotHandler));
        
    }

    @Override
    public void load(BlockState state, CompoundNBT tags) {
    	
        super.load(state, tags);
        this.progress = tags.getInt("Progress");
		this.upgradableInfusingEnergy = tags.getInt("InfusingEnergy");
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
		tags.putInt("InfusingEnergy", upgradableInfusingEnergy);
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
		tags.putInt("InfusingEnergy", upgradableInfusingEnergy);
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
        	
        	if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
        	
        	return allSlots.cast();
        	}
        	
        	if(cap == CapabilityEnergy.ENERGY) {
        		
        		return energy.cast();
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