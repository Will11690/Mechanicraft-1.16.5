package com.github.will11690.mechanicraft.blocks.machines.tier1.t1orewasher;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.fluid.MechanicraftFluidTank;
import com.github.will11690.mechanicraft.init.ModConfigs;
import com.github.will11690.mechanicraft.init.ModRecipes;
import com.github.will11690.mechanicraft.recipes.OreWasher.WasherRecipes;
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

public class TileEntityT1OreWasher extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

	//TODO Clean this up and assign ItemStackHandlers via CombinedInvWrapper instead of per slot
	
	MechaniCraftEnergyStorage energyStorage = createEnergy();
	
	MechanicraftFluidTank inputFluidTank = createInputFluidTank();
	MechanicraftFluidTank outputFluidTank = createOutputFluidTank();
	
	private ItemStackHandler inputSlotHandler = createInput();
	private ItemStackHandler inputSlotWrapperHandler = createInputWrapper(inputSlotHandler);
    
	private ItemStackHandler chargeSlotHandler = createCharge();
	private final LazyOptional<IItemHandler> inputSlotWrapper  = LazyOptional.of(() -> inputSlotWrapperHandler);
	private final LazyOptional<IItemHandler> chargeSlot  = LazyOptional.of(() -> chargeSlotHandler);
	
	private final LazyOptional<IItemHandler> allSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotHandler, inputSlotWrapperHandler));
	
	private final LazyOptional<IItemHandler> dropSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotHandler, inputSlotHandler));
	boolean breakBlock = false;
	
	private final LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
	
	private int washingEnergy = ModConfigs.t1OreWasherEnergyPerTickInt/*PER TICK*/;
	private static int WORK_TIME = ModConfigs.t1OreWasherWorkTimeInt;
		
	private static int capacity = ModConfigs.t1OreWasherEnergyCapacityInt;
	private static int receive = ModConfigs.t1OreWasherReceiveInt;
	private static int fluid_capacity = ModConfigs.t1OreWasherTankCapacityInt;
		
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
    
    public TileEntityT1OreWasher() {
    	
        super(TileEntityHandler.TILE_ENTITY_T1_ORE_WASHER.get());
        
    }
    
	private MechanicraftFluidTank createInputFluidTank() {
		
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

				if(isRecipeInputFluid(level, stack.getFluid())) {
					
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
				
				if(isRecipeOutput(level, stack.getFluid())) {
					
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
		    	
		    	if(isRecipeInputStack(level, stack)) {
		    			
		    		return true;
		    		
				}

				return false;
				
			}
		};
	}

	private ItemStackHandler createInputWrapper(ItemStackHandler inputSlotHandler) {
		
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
		    	
		    	if(isRecipeInputStack(level, stack)) {
		    			
		    		return true;
		    		
				}

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

			} else

				receivePower();
		}
		
    	if(canCraft()) {
    			
    		startCrafting();
    	}
    	
    	if(progress > 0 && (inputSlotHandler.getStackInSlot(0).isEmpty() || inputFluidTank.getFluidInTank(0).isEmpty())) {

			progress = 2;
		}
    	
    	if(!canCraft() && progress > 0) {

			progress -= 2;
		}
        
    	if(canCraft() && this.level.getBlockState(this.worldPosition).getValue(T1OreWasher.LIT) == false) {
        	
        	this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(T1OreWasher.LIT, Boolean.valueOf(true)));
        }
        
        if(!canCraft() && this.level.getBlockState(this.worldPosition).getValue(T1OreWasher.LIT) == true) {
        	
        	this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(T1OreWasher.LIT, Boolean.valueOf(false)));
        }
    }

	private void updateEnergyStorage() {
		
		if(energy.isPresent()) {
				
			energyStorage.updateEnergyStorageNoUpgrades(capacity, receive, 0);
		}
	}
    
    private boolean canCraft() {
    	
    	if(allSlots.isPresent()) {
    		
    		Inventory recipeInventory = new Inventory(this.inputSlotHandler.getStackInSlot(0));
    	
    		Optional<WasherRecipes> rOpt = this.level.getRecipeManager().getRecipeFor(ModRecipes.WASHER_RECIPES, recipeInventory, this.level);
    		WasherRecipes recipe = rOpt.orElse(null);
    	
    		int outputHandlerCount = 0;
    	
    		FluidStack output = FluidStack.EMPTY;
    		if(!this.inputFluidTank.getFluidInTank(0).equals(FluidStack.EMPTY) && !this.inputSlotHandler.getStackInSlot(0).equals(ItemStack.EMPTY)) {
    		
    			if(recipe != null)
    				output = recipe.assembleFluid(inputFluidTank, inputSlotHandler).copy();
    	
    	
    			FluidStack outputHandler = outputFluidTank.getFluidInTank(0);
    	
    			if(!(outputHandler.equals(FluidStack.EMPTY))) {
    		
    				outputHandlerCount = outputHandler.getAmount();
    			}
    	
    			if(energyStorage.getEnergyStored() >= washingEnergy) {
    	
    				if(recipe != null && (output.getFluid().equals(outputHandler.getFluid()) || outputHandler.equals(FluidStack.EMPTY)) && (output.getAmount() + outputHandlerCount <= outputFluidTank.getCapacity())) {
    		
    					return true;
    				}
    			}
    		}
    		return false;
    	}
    	return false;
    }
    
    private void startCrafting() {
    	
    	Inventory recipeInventory = new Inventory(this.inputSlotHandler.getStackInSlot(0));
    	
    	Optional<WasherRecipes> rOpt = this.level.getRecipeManager().getRecipeFor(ModRecipes.WASHER_RECIPES, recipeInventory, this.level);
    	WasherRecipes recipe = rOpt.orElse(null);
    	
    	FluidStack current = outputFluidTank.getFluidInTank(0);
    	FluidStack output = recipe.assembleFluid(inputFluidTank, inputSlotHandler);
    	
    	if(canCraft()) {
    		
    		if (progress < WORK_TIME) {
    			
    			++progress;
    			energyStorage.consumeEnergy(washingEnergy);
    			
    		}

    		if (progress >= WORK_TIME) {
    			
    			if(current.isEmpty()) {
    				
    				outputFluidTank.setFluid(output.copy());
    				progress = 0;
    				inputFluidTank.drain(recipe.getInputFluid().getAmount(), FluidAction.EXECUTE);
    				recipeInventory.removeItem(0, 1);
    				
    			} else {
    				
    				if(current.getFluid().equals(output.getFluid()) && current.getAmount() < outputFluidTank.getCapacity()) {
    					
    					current.grow(output.getAmount());
    					progress = 0;
    					inputFluidTank.drain(recipe.getInputFluid().getAmount(), FluidAction.EXECUTE);
    					recipeInventory.removeItem(0, 1);
    					
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
	
	public static Iterable<WasherRecipes> getRecipes(World world) {
		
        Collection<WasherRecipes> unfilteredRecipes = world.getRecipeManager().getAllRecipesFor(ModRecipes.WASHER_RECIPES);
        
        return Iterables.filter(unfilteredRecipes, WasherRecipes.class);
    }
	
	public static boolean isRecipeInputStack(World world, ItemStack stack) {
		
        for (WasherRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInputStack().test(stack)) {
            	
                return true;
                
            }
        }

        return false;
    }
	
	public static boolean isRecipeInputFluid(World world, Fluid fluid) {
		
        for (WasherRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getInputFluid().getFluid().equals(fluid.getFluid())) {
            	
                return true;
                
            }
        }

        return false;
    }
	
	public static boolean isRecipeOutput(World world, Fluid fluid) {
		
        for (WasherRecipes recipe : getRecipes(world)) {
        	
            if (recipe.getResultFluid().getFluid().equals(fluid)) {
            	
                return true;
                
            }
        }

        return false;
    }

    @Override
	public ITextComponent getDisplayName() {

		return new TranslationTextComponent("container.mechanicraft.t1_ore_washer");
		
	}

    @Nullable
    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity playerEntity) {
    	
        assert level != null;
		return new ContainerT1OreWasher(this, this.fields, id, playerInventory, new CombinedInvWrapper(chargeSlotHandler, inputSlotHandler));
        
    }
    
    public static int getWorkTime() {
    	
    	return WORK_TIME;
    }

    @Override
    public void load(BlockState state, CompoundNBT tags) {
    	
        super.load(state, tags);
        this.progress = tags.getInt("progress");
		this.washingEnergy = tags.getInt("washingEnergy");
		this.energyStorage.deserializeNBT(tags.getCompound("energy"));
		this.chargeSlotHandler.deserializeNBT(tags.getCompound("chargeSlot"));
        this.inputSlotHandler.deserializeNBT(tags.getCompound("inputSlot"));
		
		if(tags.contains("inputTank", Constants.NBT.TAG_COMPOUND)) {
			
            CompoundNBT inputFluidTankTag = tags.getCompound("inputTank");
            this.inputFluidTank.readFromNBT(inputFluidTankTag);
        }
		
		if(tags.contains("outputTank", Constants.NBT.TAG_COMPOUND)) {
			
            CompoundNBT outputFluidTankTag = tags.getCompound("outputTank");
            this.outputFluidTank.readFromNBT(outputFluidTankTag);
        }
        
    }

    @Override
    public CompoundNBT save(CompoundNBT tags) {
    	
        super.save(tags);
        CompoundNBT inputFluidTankTag = new CompoundNBT();
		CompoundNBT outputFluidTankTag = new CompoundNBT();
        
		tags.putInt("progress", this.progress);
		tags.put("energy", energyStorage.serializeNBT());
		tags.putInt("washingEnergy", washingEnergy);
		tags.put("chargeSlot", chargeSlotHandler.serializeNBT());
		tags.put("inputSlot", inputSlotHandler.serializeNBT());
		tags.put("outputTank", outputFluidTank.writeToNBT(tags));
		
        this.inputFluidTank.writeToNBT(inputFluidTankTag);
        tags.put("inputTank", inputFluidTankTag);
        
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
		tags.get("washingEnergy");
		tags.getInt("processingTime");
		
		this.inputFluidTank.readFromNBT(tags);
        tags.get("inputTank");
        
        this.outputFluidTank.readFromNBT(tags);
        tags.get("outputTank");
        
        this.load(state, tags);
        
    	super.handleUpdateTag(state, tags);
    	
    }

    @Override
    public CompoundNBT getUpdateTag() {
    	
        CompoundNBT tags = new CompoundNBT();
        CompoundNBT inputFluidTankTag = new CompoundNBT();
		CompoundNBT outputFluidTankTag = new CompoundNBT();
		tags.putInt("progress", this.progress);
		tags.put("energy", energyStorage.serializeNBT());
		tags.putInt("washingEnergy", washingEnergy);
		tags.putInt("processingTime", WORK_TIME);
		
		this.inputFluidTank.writeToNBT(inputFluidTankTag);
        tags.put("inputTank", inputFluidTankTag);
        
        this.outputFluidTank.writeToNBT(outputFluidTankTag);
        tags.put("outputTank", outputFluidTankTag);
        
        this.save(tags);
        
        return tags;
        
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
    	
    	inputFluidTank.readFromNBT(packet.getTag().getCompound("inputTank"));
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
				
				if(this.level.getBlockState(this.worldPosition).getValue(T1OreWasher.FACING) == Direction.NORTH) {
					
					if(side == Direction.SOUTH) {
	            		
						return LazyOptional.of(() -> this.outputFluidTank).cast();
	            		
	            	} else return LazyOptional.of(() -> this.inputFluidTank).cast();
				}
				
				if(this.level.getBlockState(this.worldPosition).getValue(T1OreWasher.FACING) == Direction.SOUTH) {
						
					if(side == Direction.NORTH) {
		            		
						return LazyOptional.of(() -> this.outputFluidTank).cast();
		            		
		            } else return LazyOptional.of(() -> this.inputFluidTank).cast();
				}
				
				if(this.level.getBlockState(this.worldPosition).getValue(T1OreWasher.FACING) == Direction.EAST) {
						
					if(side == Direction.WEST) {
		            		
						return LazyOptional.of(() -> this.outputFluidTank).cast();
		            		
		            } else return LazyOptional.of(() -> this.inputFluidTank).cast();
				}
				
				if(this.level.getBlockState(this.worldPosition).getValue(T1OreWasher.FACING) == Direction.WEST) {
						
					if(side == Direction.EAST) {
		            		
						return LazyOptional.of(() -> this.outputFluidTank).cast();
		            		
		            } else return LazyOptional.of(() -> this.inputFluidTank).cast();
				}
				
			}
			
			if (cap == CapabilityEnergy.ENERGY) {

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
    	inputSlotWrapper.invalidate();
		chargeSlot.invalidate();
		allSlots.invalidate();
		dropSlots.invalidate();
        super.setRemoved();

    }
}