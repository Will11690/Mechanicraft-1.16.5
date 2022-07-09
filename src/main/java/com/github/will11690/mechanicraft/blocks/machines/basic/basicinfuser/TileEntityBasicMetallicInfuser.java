package com.github.will11690.mechanicraft.blocks.machines.basic.basicinfuser;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.util.handlers.NonExtractableStackHandler;
import com.github.will11690.mechanicraft.init.ModRecipes;
import com.github.will11690.mechanicraft.recipes.Infuser.InfuserRecipes;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;
import com.google.common.collect.Iterables;

public class TileEntityBasicMetallicInfuser extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

	//TODO Clean this up and assign ItemStackHandlers via CombinedInvWrapper instead of per slot
	
	private ItemStackHandler inputSlotHandler1 = createInput1();
	private ItemStackHandler inputSlotWrapperHandler1 = createInputWrapper1(inputSlotHandler1);
	private ItemStackHandler inputSlotHandler2 = createInput2();
	private ItemStackHandler inputSlotWrapperHandler2 = createInputWrapper2(inputSlotHandler2);
	private ItemStackHandler fuelSlotHandler = createFuel();
	private ItemStackHandler fuelSlotWrapperHandler = createFuelWrapper(fuelSlotHandler);
	private ItemStackHandler outputSlotHandler = createOutput();
	
	private final LazyOptional<IItemHandler> inputSlotWrapper1  = LazyOptional.of(() -> inputSlotWrapperHandler1);
	private final LazyOptional<IItemHandler> inputSlotWrapper2  = LazyOptional.of(() -> inputSlotWrapperHandler2);
	private final LazyOptional<IItemHandler> outputSlot  = LazyOptional.of(() -> outputSlotHandler);
	private final LazyOptional<IItemHandler> fuelSlotWrapper  = LazyOptional.of(() -> fuelSlotHandler);
	
	private final LazyOptional<IItemHandler> allSlots  = LazyOptional.of(() -> new CombinedInvWrapper(inputSlotWrapperHandler1, inputSlotWrapperHandler2, fuelSlotWrapperHandler, outputSlotHandler));
	
    private int burnTime = 0;
    public int totalBurnTime = 0;
    private int progress = 0;
    
    static final int WORK_TIME = 10 * 20;
    static int BURN_TIME;

    private final IIntArray fields = new IIntArray() {
    	
        @Override
        public int get(int index) {
        	
            switch (index) {
            
                case 0:
                    return burnTime;
                case 1:
                	return totalBurnTime;
                case 2:
                	return progress;
                default:
                    return 0;
                    
            }
        }

        @Override
        public void set(int index, int value) {
        	
            switch (index) {
            
                case 0:
                	burnTime = value;
                    break;
                case 1:
                	totalBurnTime = value;
                    break;
                case 2:
                	progress = value;
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

    public TileEntityBasicMetallicInfuser() {
    	
        super(TileEntityHandler.TILE_ENTITY_BASIC_METALLIC_INFUSER.get());
        
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

    private ItemStackHandler createFuel() {
		
		return new ItemStackHandler() {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }

			@SuppressWarnings("deprecation")
			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

				if(ForgeHooks.getBurnTime(stack) != 0) {
					
					return true;
					
				}

				return false;
				
			}
		};
	}
    
    private ItemStackHandler createFuelWrapper(ItemStackHandler fuelSlotHandler) {
		
		return new NonExtractableStackHandler(this.fuelSlotHandler) {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }
				
			@SuppressWarnings("deprecation")
			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

				if(ForgeHooks.getBurnTime(stack) != 0) {
						
					return true;
						
				}

				return false;
					
			}
		};
	}

	@Override
    public void tick() {
    	
        if (this.level == null || this.level.isClientSide) {
        	
            return;
            
        }
        
    	if(canCraft() && !fuelSlotHandler.getStackInSlot(0).isEmpty() && burnTime == 0) {
    		
    		if(!outputSlotHandler.getStackInSlot(0).isEmpty() && outputSlotHandler.getStackInSlot(0).getCount() < outputSlotHandler.getStackInSlot(0).getMaxStackSize()) {
    			
    			consumeFuel();
    			
    		}
    		
    		if(outputSlotHandler.getStackInSlot(0).isEmpty()) {
    			
    			consumeFuel();
    			
    		}
    	}
    	

    	
    	if((inputSlotHandler1.getStackInSlot(0).isEmpty() || inputSlotHandler2.getStackInSlot(2).isEmpty()) && progress > 0) {
    		
    		progress = 0;
    		
    	}
    	
    	if(!canCraft() && progress > 0) {
    		
    		progress -= 2;
    		
    	}
    	
    	if(burnTime <= 0 && progress > 0) {
    		
    		progress -= 2;
    		
    	}
        
        if(burnTime > 0) {
        	
        	this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(BasicMetallicInfuser.LIT, Boolean.valueOf(true)));
        	
        	if(canCraft()) {
            	
            	startCrafting();
            	
            }
        	
        	--burnTime;
        	
        }
        
        if(burnTime <= 0) {
        	
        	this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(BasicMetallicInfuser.LIT, Boolean.valueOf(false)));
        	
        }
    }
    
    private boolean canCraft() {
    	
    	Inventory recipeInventory = new Inventory(this.inputSlotHandler1.getStackInSlot(0), this.inputSlotHandler2.getStackInSlot(0));
    	
    	Optional<InfuserRecipes> rOpt = this.level.getRecipeManager().getRecipeFor(ModRecipes.INFUSER_RECIPES, recipeInventory, this.level);
    	InfuserRecipes recipe = rOpt.orElse(null);
    	
    	int outputHandlerCount = 0;
    	
    	ItemStack output = ItemStack.EMPTY;
    	if(!this.inputSlotHandler1.getStackInSlot(0).equals(ItemStack.EMPTY) && !this.inputSlotHandler2.getStackInSlot(0).equals(ItemStack.EMPTY)) {
    		
    		output = recipe.assemble(recipeInventory);
    	}
    	
    	ItemStack outputHandler = outputSlotHandler.getStackInSlot(0);
    	
    	if(!(outputHandler.equals(ItemStack.EMPTY))) {
    		
    		outputHandlerCount = outputHandler.getCount();
    	}
    	
    	if(recipe != null && (output.getItem().equals(outputHandler.getItem()) || outputHandler.equals(ItemStack.EMPTY)) && (output.getCount() + outputHandlerCount <= outputHandler.getMaxStackSize())) {
    		
    		return true;
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
    	
    	if(burnTime > 0) {
    		
    		BURN_TIME = burnTime;
    		
    		if (progress < WORK_TIME) {
    			
    			++progress;
    			
    		}

    		if (progress >= WORK_TIME) {
    			
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
    	
    		if(burnTime <= 0) {
    		
    			burnTime = 0;
    			BURN_TIME = burnTime;
    			
    			 if(fuelSlotHandler.getStackInSlot(0).isEmpty() || fuelSlotHandler.getStackInSlot(0).getItem().equals(Items.BUCKET)) {
    		        	
    		        	totalBurnTime = 0;
    		        	
    		        }
    		
    		}
    	}
    }
    
    @SuppressWarnings("deprecation")
	public void consumeFuel() {
    	
    	if(!(fuelSlotHandler.getStackInSlot(0).equals(ItemStack.EMPTY))) {
    		
    		if(ForgeHooks.getBurnTime(fuelSlotHandler.getStackInSlot(0)) != 0 && burnTime == 0) {
    			
    			this.burnTime = ForgeHooks.getBurnTime(fuelSlotHandler.getStackInSlot(0));
    			
    			if(fuelSlotHandler.getStackInSlot(0).getItem().equals(Items.LAVA_BUCKET)) {
    				
    				totalBurnTime = ForgeHooks.getBurnTime(fuelSlotHandler.getStackInSlot(0));
    				fuelSlotHandler.setStackInSlot(0, new ItemStack(Items.BUCKET, 1));
    				
    			} else {
    				
    				totalBurnTime = ForgeHooks.getBurnTime(fuelSlotHandler.getStackInSlot(0));
    				fuelSlotHandler.getStackInSlot(0).shrink(1);
    				
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

		return new TranslationTextComponent("container.mechanicraft.basic_metallic_infuser");
		
	}
    
    public static int getWorkTime() {
    	
    	return WORK_TIME;
    }

    @Nullable
    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity playerEntity) {
    	
        assert level != null;
		return new ContainerBasicMetallicInfuser(this, this.fields, id, playerInventory, new CombinedInvWrapper(inputSlotHandler1, inputSlotHandler2, fuelSlotHandler, outputSlotHandler));
        
    }



    @Override
    public void load(BlockState state, CompoundNBT tags) {
    	
        super.load(state, tags);
        this.inputSlotHandler1.deserializeNBT(tags.getCompound("inputSlot1"));
        this.inputSlotHandler2.deserializeNBT(tags.getCompound("inputSlot2"));
		this.outputSlotHandler.deserializeNBT(tags.getCompound("outputSlot"));
		this.fuelSlotHandler.deserializeNBT(tags.getCompound("fuelSlot"));
        this.burnTime = tags.getInt("BurnTime");
        this.progress = tags.getInt("Progress");
        this.totalBurnTime = tags.getInt("TotalBurnTime");
        
    }

    @Override
    public CompoundNBT save(CompoundNBT tags) {
    	
        super.save(tags);
        tags.put("inputSlot1", inputSlotHandler1.serializeNBT());
        tags.put("inputSlot2", inputSlotHandler2.serializeNBT());
		tags.put("outputSlot", outputSlotHandler.serializeNBT());
		tags.put("fuelSlot", fuelSlotHandler.serializeNBT());
        tags.putInt("Progress", this.progress);
        tags.putInt("BurnTime", this.burnTime);
        tags.putInt("TotalBurnTime", this.totalBurnTime);
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
        tags.putInt("BurnTime", this.burnTime);
        return tags;
        
    }

    @Nullable
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
    	
        if (!this.remove && side != null && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
        	
        	if(this.level.getBlockState(this.worldPosition).getValue(BasicMetallicInfuser.FACING) == Direction.NORTH) {
        	
        		return allSlots.cast();
        	}
        }
        
        return super.getCapability(cap, side);
    }

    @Override
    public void setRemoved() {
    	
    	inputSlotWrapper1.invalidate();
    	inputSlotWrapper2.invalidate();
		outputSlot.invalidate();
		fuelSlotWrapper.invalidate();
		allSlots.invalidate();
        super.setRemoved();

    }
}