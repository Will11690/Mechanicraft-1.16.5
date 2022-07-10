package com.github.will11690.mechanicraft.blocks.machines.tier5.lineminer.miningchute;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;

public class MiningChute extends Block {
	
	private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);
	
	public MiningChute(Properties properties) {
		
		super(properties);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		
		return true;
		
	}

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    	
        return TileEntityHandler.TILE_ENTITY_MINING_CHUTE.get().create();
        
    }
	
    @Override
	public boolean canHarvestBlock(BlockState state, IBlockReader world, BlockPos pos, PlayerEntity player) {
    	
        return false; 
    }
    
    @Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
    	
        return false;
    }
    
    @Override
    public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
    	
        return ItemStack.EMPTY;
    }
    
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
    	
        return SHAPE;
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
            	 ((TileEntityMiningChute) tileEntity).blockBeingBroken(true);
                 LazyOptional<IItemHandler> cap = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
                 
                 cap.ifPresent(handler -> {
                	 
                	dropItemHandlerContents(world, pos, handler);
                	((TileEntityMiningChute) tileEntity).blockBeingBroken(false);
                     
                 });
             }
             
             super.onRemove(state, world, pos, newState, isMoving);
         }
    }
}