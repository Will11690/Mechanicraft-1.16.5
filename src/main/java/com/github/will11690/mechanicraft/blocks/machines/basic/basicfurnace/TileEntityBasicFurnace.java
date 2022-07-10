package com.github.will11690.mechanicraft.blocks.machines.basic.basicfurnace;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;
import com.github.will11690.mechanicraft.util.handlers.NonExtractableStackHandler;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
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

public class TileEntityBasicFurnace extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

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

	private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);

	private int progress = 0;

	static final int WORK_TIME = 15 * 20;
	
	private static final int capacity = 100000;
	private static final int receive = 500;

	//TODO Create config for energy consumed and working times

	private int smeltingEnergy = 20/*PER TICK*/;

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
			default:
				break;

			}
		}

		@Override
		public int getCount() {
        	
			return 3;
            
		}
	};

	public TileEntityBasicFurnace() {

		super(TileEntityHandler.TILE_ENTITY_BASIC_FURNACE.get());

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

	private ItemStackHandler createInput() {
		
		return new ItemStackHandler() {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

				Optional<FurnaceRecipe> recipe = getRecipeForInput(level, stack);

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

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

				Optional<FurnaceRecipe> recipe = getRecipeForInput(level, stack);

				if(recipe.isPresent() && !(ItemStack.matches(getResultForItem(level, stack), stack))) {

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

	@Override
	public void tick() {

		if (this.level == null || this.level.isClientSide) {

			return;
 
		}

		if(energyStorage.getMaxEnergyStored() > energyStorage.getEnergyStored()) {

			if(!(chargeSlotHandler.getStackInSlot(0).equals(ItemStack.EMPTY))) {

				receivePowerItem(chargeSlotHandler.getStackInSlot(0));

			}

			else

				receivePower();

		}

		if(!canSmelt() && this.level.getBlockState(this.worldPosition).getValue(BasicFurnace.LIT) == true) {

			this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(BasicFurnace.LIT, Boolean.valueOf(false)));

		}

		if(canSmelt()) {

			startSmelting();

		}
        
		if(inputSlotHandler.getStackInSlot(0).equals(ItemStack.EMPTY) && progress > 0) {

			progress = 0;

		}

		if(!canSmelt() && progress > 0) {

			progress -= 2;

		}

		if(canSmelt() && this.level.getBlockState(this.worldPosition).getValue(BasicFurnace.LIT) == false) {

			this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(BasicFurnace.LIT, Boolean.valueOf(true)));

		}
	}

	private boolean canSmelt() {

		ItemStack input = inputSlotHandler.getStackInSlot(0);
		ItemStack output = outputSlotHandler.getStackInSlot(0);

		ItemStack result = getResultForItem(level, input);

		if(energyStorage.getEnergyStored() >= smeltingEnergy) {

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

	private void startSmelting() {

		ItemStack input = inputSlotHandler.getStackInSlot(0);
		ItemStack output = outputSlotHandler.getStackInSlot(0);

		ItemStack result = getResultForItem(level, input);

		if(canSmelt()) {

			if(progress < WORK_TIME) {

				++progress;
				energyStorage.consumeEnergy(smeltingEnergy);

			}

			if (progress >= WORK_TIME) {

				if(output.isEmpty()) {

					outputSlotHandler.setStackInSlot(0, result.copy());
					progress = 0;
					inputSlotHandler.extractItem(0, 1, false);

				} else {

					if(output.getItem().equals(result.getItem()) && output.getCount() < result.getMaxStackSize()) {

						output.grow(result.getCount());
						progress = 0;
						inputSlotHandler.extractItem(0, 1, false);

					}
				}
			}
		}
	}

	public static Optional<FurnaceRecipe> getRecipeForInput(World world, ItemStack itemStack) {

		RecipeManager recipeManager = world.getRecipeManager();
		Inventory singleItemInventory = new Inventory(itemStack);

		Optional<FurnaceRecipe> recipe = recipeManager.getRecipeFor(IRecipeType.SMELTING, singleItemInventory, world);

		return recipe;

	}

	public static ItemStack getResultForItem(World world, ItemStack itemStack) {

		Optional<FurnaceRecipe> recipe = getRecipeForInput(world, itemStack);
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
		return new ContainerBasicFurnace(this, this.fields, id, playerInventory, new CombinedInvWrapper(chargeSlotHandler, inputSlotHandler, outputSlotHandler));

	}

	@Override
	public void load(BlockState state, CompoundNBT tags) {

		super.load(state, tags);
		this.progress = tags.getInt("Progress");
		this.energyStorage.deserializeNBT(tags.getCompound("energy"));
		this.inputSlotHandler.deserializeNBT(tags.getCompound("inputSlot"));
		this.outputSlotHandler.deserializeNBT(tags.getCompound("outputSlot"));
		this.chargeSlotHandler.deserializeNBT(tags.getCompound("chargeSlot"));

	}

	@Override
	public CompoundNBT save(CompoundNBT tags) {

		super.save(tags);
		tags.putInt("Progress", this.progress);
		tags.put("energy", energyStorage.serializeNBT());
		tags.put("inputSlot", inputSlotHandler.serializeNBT());
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
		inputSlotWrapper.invalidate();
		outputSlot.invalidate();
		chargeSlot.invalidate();
		allSlots.invalidate();
		dropSlots.invalidate();
		super.setRemoved();

	}

	@Override
	public ITextComponent getDisplayName() {

		return new TranslationTextComponent("container.mechanicraft.basic_furnace");

	}
}