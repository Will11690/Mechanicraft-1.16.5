package com.github.will11690.mechanicraft.blocks.machines.tier1.t1crusher;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.init.ModConfigs;
import com.github.will11690.mechanicraft.init.ModRecipes;
import com.github.will11690.mechanicraft.recipes.Crusher.CrusherRecipes;
import com.github.will11690.mechanicraft.util.handlers.NonExtractableStackHandler;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;
import com.google.common.collect.Iterables;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
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

public class TileEntityT1Crusher extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

	//TODO Clean this up and assign ItemStackHandlers via CombinedInvWrapper instead of per slot
	
	private MechaniCraftEnergyStorage energyStorage = createEnergy();
	
	private ItemStackHandler inputSlotHandler = createInput();
	private ItemStackHandler inputSlotWrapperHandler = createInputWrapper(inputSlotHandler);
	private ItemStackHandler outputSlotHandler = createOutput();
	private ItemStackHandler chargeSlotHandler = createCharge();
	
	private final LazyOptional<IItemHandler> inputSlotWrapper  = LazyOptional.of(() -> inputSlotWrapperHandler);
	private final LazyOptional<IItemHandler> outputSlot  = LazyOptional.of(() -> outputSlotHandler);
	private final LazyOptional<IItemHandler> chargeSlot  = LazyOptional.of(() -> chargeSlotHandler);
	
	private final LazyOptional<IItemHandler> allSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotHandler, inputSlotWrapperHandler, outputSlotHandler));
	
	private final LazyOptional<IItemHandler> dropSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotHandler, inputSlotHandler, outputSlotHandler));
	boolean breakBlock = false;

	private final LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);

	private int crushingEnergy = ModConfigs.t1CrusherEnergyPerTickInt/*PER TICK*/;
	private static int WORK_TIME = ModConfigs.t1CrusherWorkTimeInt;
		
	private static int capacity = ModConfigs.t1CrusherCapacityInt;
	private static int receive = ModConfigs.t1CrusherReceiveInt;
		
	private int progress = 0;

	private final IIntArray fields = new IIntArray() {

		@Override
		public int get(int index) {

			switch (index) {

			case 0:
				return progress;
			case 1:
				return WORK_TIME;
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
				WORK_TIME = value;
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

	public TileEntityT1Crusher() {

		super(TileEntityHandler.TILE_ENTITY_T1_CRUSHER.get());

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

				if(isRecipeInput(level, stack)) {

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
				
				if(isRecipeInput(level, stack)) {

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

	@Override
	public void tick() {

		if (this.level == null || this.level.isClientSide) {

			return;
 
		}
		
		this.updateEnergyStorage();

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

		if(!canCrush() && this.level.getBlockState(this.worldPosition).getValue(T1Crusher.LIT) == true) {

			this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(T1Crusher.LIT, Boolean.valueOf(false)));

		}
        
		if(inputSlotHandler.getStackInSlot(0).equals(ItemStack.EMPTY) && progress > 0) {

			progress = 0;

		}

		if(!canCrush() && progress > 0) {

			progress -= 2;

		}

		if(canCrush() && this.level.getBlockState(this.worldPosition).getValue(T1Crusher.LIT) == false) {

			this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(T1Crusher.LIT, Boolean.valueOf(true)));

		}
	}

	private void updateEnergyStorage() {
		
		if(energy.isPresent()) {
				
			energyStorage.updateEnergyStorageNoUpgrades(capacity, receive, 0);
		}
	}

	private boolean canCrush() {
		
		if(allSlots.isPresent()) {
			
			Inventory recipeInventory = new Inventory(this.inputSlotHandler.getStackInSlot(0));
    	
			Optional<CrusherRecipes> rOpt = this.level.getRecipeManager().getRecipeFor(ModRecipes.CRUSHER_RECIPES, recipeInventory, this.level);
			CrusherRecipes recipe = rOpt.orElse(null);

			ItemStack output = outputSlotHandler.getStackInSlot(0);
			ItemStack outputSecondary = outputSlotHandler.getStackInSlot(1);
		
			if(recipe != null) {
				ItemStack result = recipe.assemble(recipeInventory);
				ItemStack secondaryResult = recipe.assembleSecondary(recipeInventory);

				if(energyStorage.getEnergyStored() >= crushingEnergy) {

					if(result.isEmpty() || recipeInventory.isEmpty()) {

						return false;
					}

					if((output.getCount() + result.getCount()) > output.getMaxStackSize()) {

						return false;
					}
					
					if((secondaryResult.getCount() + outputSecondary.getCount()) > outputSecondary.getMaxStackSize()) {

						return false;
					}
				
					if(output.isEmpty() || output.getItem().equals(result.getItem())) {

						if(outputSecondary.isEmpty() || outputSecondary.getItem().equals(secondaryResult.getItem()) || secondaryResult.equals(ItemStack.EMPTY)) {
					
							return true;
						}
					}
				}
				return false;
				
			} else return false;
		}
		return false;
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

			if(progress < WORK_TIME) {

				++progress;
				energyStorage.consumeEnergy(crushingEnergy);
			}

			if (progress >= WORK_TIME) {

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
	
	public static Iterable<CrusherRecipes> getRecipes(World world) {
		
        Collection<CrusherRecipes> unfilteredRecipes = world.getRecipeManager().getAllRecipesFor(ModRecipes.CRUSHER_RECIPES);
        
        return Iterables.filter(unfilteredRecipes, CrusherRecipes.class);
    }
	
	public static boolean isRecipeInput(World world, ItemStack stack) {
		
        for (CrusherRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInput().test(stack)) {
            	
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
		return new ContainerT1Crusher(this, this.fields, id, playerInventory, new CombinedInvWrapper(chargeSlotHandler, inputSlotHandler, outputSlotHandler));

	}
    
    public static int getWorkTime() {
    	
    	return WORK_TIME;
    }

	@Override
	public void load(BlockState state, CompoundNBT tags) {

		super.load(state, tags);
		this.progress = tags.getInt("Progress");
		this.crushingEnergy = tags.getInt("CrushingEnergy");
		this.energyStorage.deserializeNBT(tags.getCompound("energy"));
		this.chargeSlotHandler.deserializeNBT(tags.getCompound("chargeSlot"));
		this.inputSlotHandler.deserializeNBT(tags.getCompound("inputSlot"));
		this.outputSlotHandler.deserializeNBT(tags.getCompound("outputSlots"));

	}

	@Override
	public CompoundNBT save(CompoundNBT tags) {

		super.save(tags);
		tags.putInt("Progress", this.progress);
		tags.put("energy", energyStorage.serializeNBT());
		tags.putInt("CrushingEnergy", crushingEnergy);
		tags.put("chargeSlot", chargeSlotHandler.serializeNBT());
		tags.put("inputSlot", inputSlotHandler.serializeNBT());
		tags.put("outputSlots", outputSlotHandler.serializeNBT());
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
	
	boolean blockBreak() {
		T1Crusher block = (T1Crusher) level.getBlockState(this.worldPosition).getBlock();
		
		return block.breakBlock;
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
		inputSlotWrapper.invalidate();
		outputSlot.invalidate();
		chargeSlot.invalidate();
		allSlots.invalidate();
		dropSlots.invalidate();
		super.setRemoved();

	}

	@Override
	public ITextComponent getDisplayName() {

		return new TranslationTextComponent("container.mechanicraft.t1_crusher");

	}
}