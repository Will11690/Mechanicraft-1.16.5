package com.github.will11690.mechanicraft.blocks.machines.tier5.lineminer;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;

public class LineMiner extends Block {
	
	public LineMiner(Properties properties) {
    	
        super(properties);
		
	}

    @Override
    public boolean hasTileEntity(BlockState state) {
    	
        return true;
        
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    	
        return TileEntityHandler.TILE_ENTITY_LINE_MINER.get().create();
        
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
    	
    	 if( newState.getBlock() != this ) {
    		 
             TileEntity tileEntity = world.getBlockEntity(pos);
             
             if (tileEntity != null) {
            	 
                 LazyOptional<IItemHandler> cap = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
                 
                 cap.ifPresent(handler -> {
                	 
                     for( int i = 0; i < handler.getSlots(); i ++ )
                         InventoryHelper.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), handler.getStackInSlot(i));
                     
                 });
             }
             
             super.onRemove(state, world, pos, newState, isMoving);
         }
    }
}