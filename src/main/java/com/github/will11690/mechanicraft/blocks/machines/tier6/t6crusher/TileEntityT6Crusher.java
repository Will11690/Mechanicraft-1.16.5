package com.github.will11690.mechanicraft.blocks.machines.tier6.t6crusher;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.init.ModConfigs;
import com.github.will11690.mechanicraft.init.ModItems;
import com.github.will11690.mechanicraft.init.ModRecipes;
import com.github.will11690.mechanicraft.recipes.Crusher.CrusherRecipes;
import com.github.will11690.mechanicraft.util.capabilities.factory.UpgradeMachineHandlerFactory;
import com.github.will11690.mechanicraft.util.capabilities.interfaces.IUpgradeMachineHandler;
import com.github.will11690.mechanicraft.util.handlers.NonExtractableStackHandler;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

public class TileEntityT6Crusher extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

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

	private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
	private LazyOptional<IUpgradeMachineHandler> upgrade = LazyOptional.of(() -> upgradeHandler);

	private int crushingEnergy = ModConfigs.t6CrusherEnergyPerTickInt/*PER TICK*/;
	private int WORK_TIME = ModConfigs.t6CrusherWorkTimeInt;
		
	private static int capacity = ModConfigs.t6CrusherCapacityInt;
	private static int receive = ModConfigs.t6CrusherReceiveInt;
		
	private int progress = 0;
	private int upgradableCrushingEnergy = 0;
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

	public TileEntityT6Crusher() {

		super(TileEntityHandler.TILE_ENTITY_T6_CRUSHER.get());

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

				Optional<CrusherRecipes> recipe = getRecipeForInput(level, stack);

				if(recipe.isPresent() && !(ItemStack.matches(getResultForItem(level, stack), stack))) {

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

				Optional<CrusherRecipes> recipe = getRecipeForInput(level, stack);

				if(recipe.isPresent() && !(ItemStack.matches(getResultForItem(level, stack), stack))) {

					return true;

				}

				return false;
				
			}
		};
	}

	private ItemStackHandler createUpgrade() {

    	return new ItemStackHandler(4) {
    		
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
		
		return new ItemStackHandler(2) {
    		
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

		if(canCrush()) {

			startCrushing();

		}

		if(!canCrush() && this.level.getBlockState(this.worldPosition).getValue(T6Crusher.LIT) == true) {

			this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(T6Crusher.LIT, Boolean.valueOf(false)));

		}
        
		if(inputSlotHandler.getStackInSlot(0).equals(ItemStack.EMPTY) && progress > 0) {

			progress = 0;

		}

		if(!canCrush() && progress > 0) {

			progress -= 2;

		}

		if(canCrush() && this.level.getBlockState(this.worldPosition).getValue(T6Crusher.LIT) == false) {

			this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(T6Crusher.LIT, Boolean.valueOf(true)));

		}
	}
    
    private void setUpgradeModifiers() {
    	
    	if(upgrade.isPresent()) {
    	
    		if(progress == 0) {
    		
    			upgradeHandler.setUpgrade1Stack(upgradeSlotHandler.getStackInSlot(0));
        		upgradeHandler.setUpgrade2Stack(upgradeSlotHandler.getStackInSlot(1));
        		upgradeHandler.setUpgrade3Stack(upgradeSlotHandler.getStackInSlot(2));
        		upgradeHandler.setUpgrade4Stack(upgradeSlotHandler.getStackInSlot(3));
        		
        		upgradeHandler.fourUpgradeModifier(WORK_TIME, crushingEnergy, upgradeSlotHandler.getStackInSlot(0), upgradeSlotHandler.getStackInSlot(1), upgradeSlotHandler.getStackInSlot(2), upgradeSlotHandler.getStackInSlot(3));
        			
        		upgradableWorkTime = upgradeHandler.getTotalProcessingTime();
        		upgradableCrushingEnergy = upgradeHandler.getTotalEnergyUsed();
    		}
    	}
    	
    	if(energy.isPresent()) {
    		
    		energyStorage.setUpgrade1Stack(upgradeSlotHandler.getStackInSlot(0));
    		energyStorage.setUpgrade2Stack(upgradeSlotHandler.getStackInSlot(1));
    		energyStorage.setUpgrade3Stack(upgradeSlotHandler.getStackInSlot(2));
    		energyStorage.setUpgrade4Stack(upgradeSlotHandler.getStackInSlot(3));
    		energyStorage.fourUpgradeModifier(capacity, receive, 0, upgradeSlotHandler.getStackInSlot(0), upgradeSlotHandler.getStackInSlot(1), upgradeSlotHandler.getStackInSlot(2), upgradeSlotHandler.getStackInSlot(3));
    		
    	}
    }

	public boolean canExtractCapacity() {
		
		if(energy.isPresent()) {
			
			return energyStorage.canExtractFromSlot(energyStorage.getEnergyStored());
			
		} else 
			return false;
	}
    
    private boolean canCrush() {

		Inventory recipeInventory = new Inventory(this.inputSlotHandler.getStackInSlot(0));
    	
    	Optional<CrusherRecipes> rOpt = this.level.getRecipeManager().getRecipeFor(ModRecipes.CRUSHER_RECIPES, recipeInventory, this.level);
    	CrusherRecipes recipe = rOpt.orElse(null);

		ItemStack output = outputSlotHandler.getStackInSlot(0);
		ItemStack outputSecondary = outputSlotHandler.getStackInSlot(1);
		
		if(recipe != null) {
			ItemStack result = recipe.assemble(recipeInventory);
			ItemStack secondaryResult = recipe.assembleSecondary(recipeInventory);

			if(energyStorage.getEnergyStored() >= upgradableCrushingEnergy) {

				if (result.isEmpty() || recipeInventory.isEmpty()) {

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

	private void startCrushing() {
		
		Inventory recipeInventory = new Inventory(this.inputSlotHandler.getStackInSlot(0));
    	
    	Optional<CrusherRecipes> rOpt = this.level.getRecipeManager().getRecipeFor(ModRecipes.CRUSHER_RECIPES, recipeInventory, this.level);
    	CrusherRecipes recipe = rOpt.orElse(null);

		ItemStack output = outputSlotHandler.getStackInSlot(0);
		ItemStack outputSecondary = outputSlotHandler.getStackInSlot(1);
		ItemStack result = recipe.assemble(recipeInventory);
		ItemStack secondaryResult = recipe.assembleSecondary(recipeInventory);

		if(canCrush()) {

			if(progress < upgradableWorkTime) {

				++progress;
				energyStorage.consumeEnergy(upgradableCrushingEnergy);
			}

			if (progress >= upgradableWorkTime) {

				if(secondaryResult.equals(ItemStack.EMPTY) && output.isEmpty()) {
					
					outputSlotHandler.setStackInSlot(0, result.copy());
					progress = 0;
					inputSlotHandler.extractItem(0, 1, false);
					
				}
				
				if(secondaryResult.equals(ItemStack.EMPTY) && output.getItem().equals(result.getItem()) && output.getCount() < result.getMaxStackSize()) {
					
					output.grow(result.getCount());
					progress = 0;
					inputSlotHandler.extractItem(0, 1, false);
					
				}
				
				if(!secondaryResult.equals(ItemStack.EMPTY) && output.isEmpty() && outputSecondary.isEmpty()) {
					
					outputSlotHandler.setStackInSlot(0, result.copy());
					outputSlotHandler.setStackInSlot(1, secondaryResult.copy());
					progress = 0;
					inputSlotHandler.extractItem(0, 1, false);
					
				}
				
				if(!secondaryResult.equals(ItemStack.EMPTY) && output.getItem().equals(result.getItem()) && output.getCount() < result.getMaxStackSize() && outputSecondary.isEmpty()) {
					
					output.grow(result.getCount());
					outputSlotHandler.setStackInSlot(1, secondaryResult.copy());
					progress = 0;
					inputSlotHandler.extractItem(0, 1, false);
					
				}
				
				if(!secondaryResult.equals(ItemStack.EMPTY) && output.isEmpty() && outputSecondary.getItem().equals(secondaryResult.getItem()) && outputSecondary.getCount() < secondaryResult.getMaxStackSize()) {
					
					outputSlotHandler.setStackInSlot(0, result.copy());
					outputSecondary.grow(secondaryResult.getCount());
					progress = 0;
					inputSlotHandler.extractItem(0, 1, false);
					
				}
				
				if(!secondaryResult.equals(ItemStack.EMPTY) && output.getItem().equals(result.getItem()) && output.getCount() < result.getMaxStackSize() && 
				    outputSecondary.getItem().equals(secondaryResult.getItem()) && outputSecondary.getCount() < secondaryResult.getMaxStackSize()) {
					
					output.grow(result.getCount());
					outputSecondary.grow(secondaryResult.getCount());
					
					progress = 0;
					inputSlotHandler.extractItem(0, 1, false);
					
				}
			}
		}
	}

	public static Optional<CrusherRecipes> getRecipeForInput(World world, ItemStack itemStack) {

		RecipeManager recipeManager = world.getRecipeManager();
		Inventory singleItemInventory = new Inventory(itemStack);

		Optional<CrusherRecipes> recipe = recipeManager.getRecipeFor(ModRecipes.CRUSHER_RECIPES, singleItemInventory, world);

		return recipe;

	}

	public static ItemStack getResultForItem(World world, ItemStack itemStack) {

		Optional<CrusherRecipes> recipe = getRecipeForInput(world, itemStack);
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
		return new ContainerT6Crusher(this, this.fields, id, playerInventory, new CombinedInvWrapper(chargeSlotHandler, inputSlotHandler, upgradeSlotHandler, outputSlotHandler));

	}

	@Override
	public void load(BlockState state, CompoundNBT tags) {

		super.load(state, tags);
		this.progress = tags.getInt("Progress");
		this.upgradableCrushingEnergy = tags.getInt("CrushingEnergy");
		this.upgradableWorkTime = tags.getInt("ProcessingTime");
		this.energyStorage.deserializeNBT(tags.getCompound("energy"));
		this.upgradeSlotHandler.deserializeNBT(tags.getCompound("upgradeSlot"));
		this.chargeSlotHandler.deserializeNBT(tags.getCompound("chargeSlot"));
		this.inputSlotHandler.deserializeNBT(tags.getCompound("inputSlot"));
		this.outputSlotHandler.deserializeNBT(tags.getCompound("outputSlot"));

	}

	@Override
	public CompoundNBT save(CompoundNBT tags) {

		super.save(tags);
		tags.putInt("Progress", this.progress);
		tags.put("energy", energyStorage.serializeNBT());
		tags.putInt("CrushingEnergy", upgradableCrushingEnergy);
		tags.putInt("ProcessingTime", upgradableWorkTime);
		tags.put("chargeSlot", chargeSlotHandler.serializeNBT());
		tags.put("upgradeSlot", upgradeSlotHandler.serializeNBT());
		tags.put("inputSlot", inputSlotHandler.serializeNBT());
		tags.put("outputSlot", outputSlotHandler.serializeNBT());
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

		return new TranslationTextComponent("container.mechanicraft.t6_crusher");

	}
}