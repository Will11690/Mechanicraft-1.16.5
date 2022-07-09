package com.github.will11690.mechanicraft.blocks.fluidtank.elitefluidtank;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;

public class EliteFluidTank extends Block {
	
	static final BooleanProperty CON_NORTH = BooleanProperty.create("con_north");
	static final BooleanProperty CON_SOUTH = BooleanProperty.create("con_south");
	static final BooleanProperty CON_WEST = BooleanProperty.create("con_west");
	static final BooleanProperty CON_EAST = BooleanProperty.create("con_east");
	
	//BASE SHAPE
	private static final VoxelShape CORE_SHAPE = Stream.of(Block.box(2, 1, 2, 3, 15, 3),
														   Block.box(2, 1, 13, 3, 15, 14),
														   Block.box(13, 1, 13, 14, 15, 14),
														   Block.box(13, 1, 2, 14, 15, 3),
														   Block.box(1, 15, 1, 15, 16, 15),
														   Block.box(1, 0, 1, 15, 1, 15),
														   Block.box(3, 1, 2, 13, 15, 3),
														   Block.box(3, 1, 13, 13, 15, 14),
														   Block.box(13, 1, 3, 14, 15, 13),
														   Block.box(2, 1, 3, 3, 15, 13)).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
			
	//CONNECTION SHAPES
	private static final VoxelShape NORTH_SHAPE_CON = Block.box(4, 4, 0, 12, 12, 2);
	private static final VoxelShape SOUTH_SHAPE_CON = Block.box(4, 4, 14, 12, 12, 16);
	private static final VoxelShape WEST_SHAPE_CON = Block.box(0, 4, 4, 2, 12, 12);
	private static final VoxelShape EAST_SHAPE_CON = Block.box(14, 4, 4, 16, 12, 12);
	
	TileEntityEliteFluidTank tile;
	
	public EliteFluidTank(Properties properties) {
    	
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
        		.setValue(CON_NORTH, Boolean.valueOf(false)).setValue(CON_SOUTH, Boolean.valueOf(false))
        		.setValue(CON_WEST, Boolean.valueOf(false)).setValue(CON_EAST, Boolean.valueOf(false)));
        
    }
	
	@Override
	public void onNeighborChange(BlockState state, IWorldReader world, BlockPos currentPos, BlockPos facingPos) {
		
		state = setConnections(world, currentPos, state);
	}
	
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
	    	  
		return setConnections(world, currentPos, state);
	}
	
	public static boolean canTankConnectHorizontal(IBlockReader world, BlockPos pos, Direction facing) {
		
		BlockPos neighborPos = pos.relative(facing);
		BlockState neighborState = world.getBlockState(neighborPos);
		Block neighborBlock = neighborState.getBlock();
		TileEntity neighborEntity = world.getBlockEntity(neighborPos);
		
		if(neighborBlock.hasTileEntity(neighborState) && neighborEntity.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, facing).isPresent()) {
			
			return true;
			
		}
		
		else return false;
		
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		
		return true;
		
	}

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    	
        return TileEntityHandler.TILE_ENTITY_ELITE_FLUID_TANK.get().create();
        
    }
    
    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
    	
    	if(world.isClientSide) {
    		
    		return ActionResultType.SUCCESS;
    		
    	}
    	if (!world.isClientSide) {
    		
            ItemStack heldItem = player.getItemInHand(hand);
            TileEntity tileEntity = world.getBlockEntity(pos);
            tile = (TileEntityEliteFluidTank) world.getBlockEntity(pos);

            if (tileEntity != null) {
            	
                LazyOptional<IFluidHandler> fluidHandlerCap = tileEntity.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY);
                LazyOptional<IFluidHandler> fluidHandlerCapStack = heldItem.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY);
                BlockPos playerPosition = new BlockPos(player.position().x, player.position().y, player.position().z);
                
                if(player.isShiftKeyDown() && heldItem.isEmpty()) {
                	
                	if(tile.autoOutDown != true) {
                		
                		tile.setAutoOutput(true);
                		player.level.playSound(null, playerPosition, SoundEvents.DISPENSER_FAIL, SoundCategory.PLAYERS, 1.0F, 1.0F);
                	
                	} else {
                		
                		tile.setAutoOutput(false);
                		player.level.playSound(null, playerPosition, SoundEvents.DISPENSER_FAIL, SoundCategory.PLAYERS, 1.0F, 1.0F);
                	}
                	
                } else if (fluidHandlerCap.isPresent()) {
                	
                    IFluidHandler fluidHandler = fluidHandlerCap.orElseThrow(IllegalStateException::new);
                    
                    if(heldItem.getItem() == Items.GLASS_BOTTLE && fluidHandler.getFluidInTank(0).getFluid().equals(Fluids.WATER)) {
                    	
                        if (fluidHandler.drain(500, IFluidHandler.FluidAction.SIMULATE).getAmount() == 500) {
                        	
                            fluidHandler.drain(500, IFluidHandler.FluidAction.EXECUTE);
                            player.level.playSound(null, playerPosition, SoundEvents.BOTTLE_FILL, SoundCategory.PLAYERS, 1.0F, 1.0F);
                            heldItem.shrink(1);
                            ItemStack itemPotion = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);

                            if (!player.addItem(itemPotion)) {
                            	
                            	popResource(world, playerPosition, itemPotion);
                            }

                            return ActionResultType.SUCCESS;
                        }
                        
                    } else if(heldItem.getItem() == Items.POTION && heldItem.getTag() != null) {
                    	
                    	if (heldItem.getTag().getString("Potion").equals("minecraft:water") && fluidHandler.getFluidInTank(0).getFluid().equals(Fluids.WATER)) {
                        	
                    		if (fluidHandler.fill(new FluidStack(Fluids.WATER, 500), IFluidHandler.FluidAction.SIMULATE) == 500) {
                            	
                    			fluidHandler.fill(new FluidStack(Fluids.WATER, 500), IFluidHandler.FluidAction.EXECUTE);
                    			player.level.playSound(null, playerPosition, SoundEvents.BOTTLE_EMPTY, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    			heldItem.shrink(1);
                    			ItemStack itemBottle = new ItemStack(Items.GLASS_BOTTLE);

                    			if (!player.addItem(itemBottle)) {
                                	
                    				popResource(world, playerPosition, itemBottle);
                    			}

                    			return ActionResultType.SUCCESS;
                    		}
                    	}
                        
                    } else if(heldItem.getItem() instanceof BucketItem) {
                    	
                    	return (FluidUtil.interactWithFluidHandler(player, hand, fluidHandler)) ? ActionResultType.SUCCESS : ActionResultType.FAIL;
                    	
                    } else if(fluidHandlerCapStack.isPresent() && !(heldItem.getItem() instanceof BucketItem)) {
                    	
                    	return (FluidUtil.interactWithFluidHandler(player, hand, fluidHandler)) ? ActionResultType.SUCCESS : ActionResultType.FAIL;
                    		
                    } else {
                    		
                    	return ActionResultType.FAIL;
                    		
                    }
                }
                return ActionResultType.FAIL;
            }
            return ActionResultType.FAIL;
    	}
    	return ActionResultType.FAIL;
    }
    
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
    	
    	VoxelShape baseShape = CORE_SHAPE;
		
		if(canTankConnectHorizontal(world, pos, Direction.NORTH)) {
			
			baseShape = VoxelShapes.join(baseShape, NORTH_SHAPE_CON, IBooleanFunction.OR);
		}
		
		if(canTankConnectHorizontal(world, pos, Direction.SOUTH)) {
			
			baseShape = VoxelShapes.join(baseShape, SOUTH_SHAPE_CON, IBooleanFunction.OR);
		}
		
		if(canTankConnectHorizontal(world, pos, Direction.WEST)) {
			
			baseShape = VoxelShapes.join(baseShape, WEST_SHAPE_CON, IBooleanFunction.OR);
		}
		
		if(canTankConnectHorizontal(world, pos, Direction.EAST)) {
			
			baseShape = VoxelShapes.join(baseShape, EAST_SHAPE_CON, IBooleanFunction.OR);
		}
		
        return baseShape;
    }
    
    private BlockState setConnections(IBlockReader world, BlockPos pos, BlockState state) {
    	
        return state.setValue(CON_NORTH, canTankConnectHorizontal(world, pos, Direction.NORTH)).setValue(CON_SOUTH, canTankConnectHorizontal(world, pos, Direction.SOUTH))
                	 .setValue(CON_EAST, canTankConnectHorizontal(world, pos, Direction.EAST)).setValue(CON_WEST, canTankConnectHorizontal(world, pos, Direction.WEST));
      }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
    	
    	World world = context.getLevel();
        BlockPos blockPos = context.getClickedPos();

        BlockState blockState = defaultBlockState();
        blockState = this.setConnections(world, blockPos, blockState);
    	
        return blockState;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
    	
        builder.add(CON_NORTH, CON_SOUTH, CON_EAST, CON_WEST);
        
    }
}