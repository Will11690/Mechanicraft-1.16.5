package com.github.will11690.mechanicraft.blocks.machines.tier4.t4infuser;

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
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class T4MetallicInfuser extends Block {
	
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public T4MetallicInfuser(Properties properties) {
    	
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
    	
        return TileEntityHandler.TILE_ENTITY_T4_METALLIC_INFUSER.get().create();
        
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTrace) {
    	
        if (world.isClientSide) {
        	
            return ActionResultType.SUCCESS;
            
        }
        
        TileEntity te = world.getBlockEntity(pos);
        if (!(te instanceof TileEntityT4MetallicInfuser))
            return ActionResultType.FAIL;

        NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) te, pos);
        return ActionResultType.SUCCESS;
        
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
    	
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
        
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