package com.github.will11690.mechanicraft.blocks.machines.tier6.t6orewasher;

import java.util.Optional;

import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class T6OreWasher extends Block {
	
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public T6OreWasher(Properties properties) {
    	
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.valueOf(false)));
        
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
    	
        return true;
        
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    	
        return TileEntityHandler.TILE_ENTITY_T6_ORE_WASHER.get().create();
        
    }
    
    @Nullable
    private Direction tankToInteractWith(Direction facing, World world, PlayerEntity player, Hand hand) {
        	
    	ItemStack heldItem = player.getItemInHand(hand);
    	
    	if(heldItem.getItem() instanceof BucketItem || heldItem.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY).isPresent()) {
    	
    		Optional<FluidStack> fluid = FluidUtil.getFluidContained(heldItem);
    		
    		if(fluid.isPresent()) {
    			
    			FluidStack fluidStack = fluid.get();
    		
    			if(facing == Direction.NORTH) {
        		
    				if(TileEntityT6OreWasher.isRecipeInputFluid(world, fluidStack.getFluid())) {
        			
    					return Direction.DOWN;
        			
    				} else if(fluidStack.isEmpty()) {
    					
    					return facing.getOpposite();
    					
    				} else
        				
        			return null;
        		}
        
    			if(facing == Direction.SOUTH) {
        		
    				if(TileEntityT6OreWasher.isRecipeInputFluid(world, fluidStack.getFluid())) {
        			
    					return Direction.DOWN;
        			
    				}else if(fluidStack.isEmpty()) {
    					
    					return facing.getOpposite();
    					
    				} else
        				
    					return null;
        		
    			}
        
    			if(facing == Direction.EAST) {
        		
    				if(TileEntityT6OreWasher.isRecipeInputFluid(world, fluidStack.getFluid())) {
        			
    					return Direction.DOWN;
        			
    				} else if(fluidStack.isEmpty()) {
    					
    					return facing.getOpposite();
    					
    				} else
        				
    					return null;
    			}
        
    			if(facing == Direction.WEST) {
        		
    				if(TileEntityT6OreWasher.isRecipeInputFluid(world, fluidStack.getFluid())) {
        			
    					return Direction.DOWN;
        			
    				} else if(fluidStack.isEmpty()) {
    					
    					return facing.getOpposite();
    					
    				} else
        				
    					return null;
        		}
    			
    		} else if(!fluid.isPresent()) {
    			
    			if(facing == Direction.NORTH) {
    				
    				return facing.getOpposite();
    			}
    			
    			if(facing == Direction.SOUTH) {
    				
    				return facing.getOpposite();
    			}
    			
    			if(facing == Direction.EAST) {
    				
    				return facing.getOpposite();
    			}
    			
    			if(facing == Direction.WEST) {
    				
    				return facing.getOpposite();
    			}
    		}
    	}
		return null;
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTrace) {
    	
        if(world.isClientSide) {
        	
            return ActionResultType.SUCCESS;
        }
        
        ItemStack heldItem = player.getItemInHand(hand);
        TileEntity te = world.getBlockEntity(pos);

        LazyOptional<IFluidHandler> fluidHandlerCapStack = heldItem.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY);
        
        if (!(te instanceof TileEntityT6OreWasher)) {
        	
            return ActionResultType.FAIL;
        }
        
        if((!fluidHandlerCapStack.isPresent() && !(heldItem.getItem() instanceof BucketItem)) || player.isShiftKeyDown()) {
        	
        	NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) te, pos);
        	return ActionResultType.SUCCESS;
        }
        
        LazyOptional<IFluidHandler> fluidHandlerCap = te.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, tankToInteractWith(world.getBlockState(pos).getValue(FACING), world, player, hand));
        
        if(fluidHandlerCap.isPresent() && !player.isShiftKeyDown()) {
        	
        	IFluidHandler fluidHandler = fluidHandlerCap.orElseThrow(IllegalStateException::new);
        
        	if(heldItem.getItem() instanceof BucketItem && tankToInteractWith(world.getBlockState(pos).getValue(FACING), world, player, hand) != world.getBlockState(pos).getValue(FACING).getOpposite()) {
        		
        		return (FluidUtil.interactWithFluidHandler(player, hand, fluidHandler)) ? ActionResultType.SUCCESS : ActionResultType.FAIL;
        	
        	} else if(heldItem.getItem() instanceof BucketItem && tankToInteractWith(world.getBlockState(pos).getValue(FACING), world, player, hand) == world.getBlockState(pos).getValue(FACING).getOpposite()) {
        		    		
        		FluidActionResult canFill = FluidUtil.tryFillContainer(heldItem, fluidHandler, FluidAttributes.BUCKET_VOLUME, player, false);
        		
        		if(canFill.isSuccess()) {
        			
        			FluidUtil.interactWithFluidHandler(player, hand, fluidHandler);
        			return ActionResultType.SUCCESS;
        			
        		} else
        		
        		return ActionResultType.FAIL;
        		
        	} else if(fluidHandlerCapStack.isPresent() && !(heldItem.getItem() instanceof BucketItem) && tankToInteractWith(world.getBlockState(pos).getValue(FACING), world, player, hand) != world.getBlockState(pos).getValue(FACING).getOpposite()) {
        	
        		return (FluidUtil.interactWithFluidHandler(player, hand, fluidHandler)) ? ActionResultType.SUCCESS : ActionResultType.FAIL;
        	
        	} else if(fluidHandlerCapStack.isPresent() && !(heldItem.getItem() instanceof BucketItem) && tankToInteractWith(world.getBlockState(pos).getValue(FACING), world, player, hand) == world.getBlockState(pos).getValue(FACING).getOpposite()) {
        		
        		FluidActionResult canFill = FluidUtil.tryFillContainer(heldItem, fluidHandler, 250, player, false);
        		
        		if(canFill.isSuccess()) {
        			
        			FluidUtil.interactWithFluidHandler(player, hand, fluidHandler);
        			return ActionResultType.SUCCESS;
        			
        		} else
        		
        		return ActionResultType.FAIL;
        		
        	}
        }
		return ActionResultType.FAIL;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
    	
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
        
    }
    
    public static void dropItemHandlerContents(final World world, final BlockPos pos, final IItemHandler itemHandler) {
		for (int slot = 0; slot < itemHandler.getSlots(); slot++) {
			ItemStack stack = itemHandler.extractItem(slot, itemHandler.getStackInSlot(slot).getCount(), false);
			InventoryHelper.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);
		}
	}

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
    	
    	 if(!state.is(newState.getBlock())) {
    		 
             TileEntity tileEntity = world.getBlockEntity(pos);
             
             if (tileEntity != null) {
            	 ((TileEntityT6OreWasher) tileEntity).blockBeingBroken(true);
                 LazyOptional<IItemHandler> cap = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
                 
                 cap.ifPresent(handler -> {
                	 
                	dropItemHandlerContents(world, pos, handler);
                	((TileEntityT6OreWasher) tileEntity).blockBeingBroken(false);
                     
                 });
             }
             
             super.onRemove(state, world, pos, newState, isMoving);
         }
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
    	
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
        
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
    	
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
        
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
    	
        builder.add(LIT, FACING);
        
    }
}