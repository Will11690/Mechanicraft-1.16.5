package com.github.will11690.mechanicraft.blocks.machines.tier1.t1energycube;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;

public class T1EnergyCube extends Block {

    public T1EnergyCube(Properties properties) {
    	
        super(properties);
        
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
    	
        return true;
        
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    	
        return TileEntityHandler.TILE_ENTITY_T1_ENERGY_CUBE.get().create();
        
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTrace) {
    	
        if (world.isClientSide) {
        	
            return ActionResultType.SUCCESS;
            
        }
        
        TileEntity te = world.getBlockEntity(pos);
        if (!(te instanceof TileEntityT1EnergyCube))
            return ActionResultType.FAIL;

        NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) te, pos);
        return ActionResultType.SUCCESS;
        
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
    	
    	 if (newState.getBlock() != this) {
    		 
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