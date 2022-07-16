package com.github.will11690.mechanicraft.blocks.machines.tier5.lineminer.miningchute;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SoundType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import com.github.will11690.mechanicraft.init.ModBlocks;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;

public class TileEntityMiningChute extends TileEntity implements ITickableTileEntity {
	
	private ItemStackHandler items = createItems();
	
	private final LazyOptional<IItemHandler> itemHandler  = LazyOptional.of(() -> items);
	
	boolean breakBlock = false;
	
	public TileEntityMiningChute() {
		
		super(TileEntityHandler.TILE_ENTITY_MINING_CHUTE.get());
	}
	
	private ItemStackHandler createItems() {
		
		return new ItemStackHandler(1) {
			
	        @Override
	        protected void onContentsChanged(int slot) {
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
		
		BlockPos neighborPosDown = worldPosition.below();
		BlockState neighborStateDown = level.getBlockState(neighborPosDown);
				
		this.checkUpValid();
				
		if(!(this.items.getStackInSlot(0).equals(ItemStack.EMPTY))) {
			
    		this.passItemUp();
		}
		
		if(canMine(level, neighborPosDown, neighborStateDown)) {
				
			this.mineBlockAndPlaceChute();
		}
				
		if(!canMine(level, neighborPosDown, neighborStateDown)) {
					
			this.placeChute(level, neighborPosDown, neighborStateDown);
		}
	}
	
	public void checkUpValid() {
		
		boolean checkForChute = false;
		
		BlockPos neighborPosUp = worldPosition.above();
		BlockState neighborStateUp = level.getBlockState(neighborPosUp);
		Block neighborBlockUp = neighborStateUp.getBlock();
		
		if(neighborBlockUp != ModBlocks.LINE_MINER.get()) {
			
			checkForChute = true;
			
		}
		
		if(checkForChute == true) {
			
			if(neighborBlockUp != ModBlocks.MINING_CHUTE.get()) {
				
			level.destroyBlock(worldPosition, false);
			
				if(level.getBlockEntity(worldPosition) != null) {
					
					level.removeBlockEntity(worldPosition);
				}
			}
		}
	}
	
	public void placeChute(World world, BlockPos targetPos, BlockState state) {
		
		if(state.getBlock().isAir(state, world, targetPos) || (state.getBlock() instanceof FlowingFluidBlock)) {
			
			level.setBlockAndUpdate(targetPos, ModBlocks.MINING_CHUTE.get().defaultBlockState());
		}
	}
	
	private boolean canMine(World world, BlockPos targetPos, BlockState state) {
		float hardness = state.getDestroySpeed(world, targetPos);
        
		if(!state.getBlock().isAir(state, world, targetPos) && hardness >= 0 && !(state.getBlock() instanceof FlowingFluidBlock) && state.hasTileEntity() == false) {
			
			return true;
		}
		return false;
	}

	private void mineBlockAndPlaceChute() {
		
		BlockPos neighborPosDown = worldPosition.below();
		BlockState neighborStateDown = level.getBlockState(neighborPosDown);
		List<ItemStack> blockDrops = new LinkedList<>();
			
		blockDrops = Block.getDrops(neighborStateDown, (ServerWorld) level, neighborPosDown, level.getBlockEntity(neighborPosDown));
        
        if(blockDrops.isEmpty()) {
        	
        	ItemStack stack = new ItemStack(neighborStateDown.getBlock(), 1);
        	items.insertItem(0, stack, false);
        	level.setBlockAndUpdate(neighborPosDown, ModBlocks.MINING_CHUTE.get().defaultBlockState());
        	SoundType sound = neighborStateDown.getSoundType();
            level.playSound(null, neighborPosDown, sound.getBreakSound(), SoundCategory.BLOCKS, (sound.getVolume() + 1.0F) / 4F, sound.getPitch() * 0.8F);
        	
        } else {
        	
        	for(int i = 0; blockDrops.size() > i; i++) {
        	
    			items.insertItem(0, blockDrops.get(i), false);
        		level.setBlockAndUpdate(neighborPosDown, ModBlocks.MINING_CHUTE.get().defaultBlockState());
        		blockDrops.remove(i);
        		SoundType sound = neighborStateDown.getSoundType();
            	level.playSound(null, neighborPosDown, sound.getBreakSound(), SoundCategory.BLOCKS, (sound.getVolume() + 1.0F) / 4F, sound.getPitch() * 0.8F);
            	
            	if(blockDrops.size() == 0) {
            	
            		break;
            	}
        	}
        }
    }
	
	public void passItemUp() {
		
		BlockPos neighborPosUp = worldPosition.above();
		BlockState neighborStateUp = level.getBlockState(neighborPosUp);
		Block neighborBlockUp = neighborStateUp.getBlock();
		TileEntity neighborEntityUp = level.getBlockEntity(neighborPosUp);
		
		if(neighborBlockUp.hasTileEntity(neighborStateUp) && neighborEntityUp.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.UP).isPresent()) {
			
			IItemHandler neighborInventory = neighborEntityUp.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.UP).orElse(null);
			
			if(neighborInventory != null && neighborInventory.getSlots() > 1) {
				
				for(int i = 0; neighborInventory.getSlots() > i; i++) {
					
					if(neighborInventory.getStackInSlot(i).equals(ItemStack.EMPTY) || neighborInventory.getStackInSlot(i).getItem().equals(this.items.getStackInSlot(0).getItem())) {
						
						if(neighborInventory.getStackInSlot(i).getCount() < neighborInventory.getStackInSlot(i).getMaxStackSize()) {
							
							ItemStack simulate = neighborInventory.insertItem(i, this.items.getStackInSlot(0), true);
							int availableSpace = this.items.getStackInSlot(0).getCount() - simulate.getCount();
							
							neighborInventory.insertItem(i, this.items.getStackInSlot(0).split(availableSpace), false);
							
							items.extractItem(0, this.items.getStackInSlot(0).split(availableSpace).getCount(), false);
							
							if(items.getStackInSlot(0).getItem().equals(Items.AIR)) {
								
								items.setStackInSlot(0, ItemStack.EMPTY);
							}
						}
					}
					
					if(items.getStackInSlot(0).equals(ItemStack.EMPTY)) {
						
						break;
					}
				}
				
			} else if(neighborInventory != null && (neighborInventory.getStackInSlot(0).equals(ItemStack.EMPTY) || neighborInventory.getStackInSlot(0).getItem().equals(this.items.getStackInSlot(0).getItem()))) {
				
				ItemStack simulate = neighborInventory.insertItem(0, this.items.getStackInSlot(0), true);
				int availableSpace = this.items.getStackInSlot(0).getCount() - simulate.getCount();
				
				neighborInventory.insertItem(0, this.items.getStackInSlot(0).split(availableSpace), false);
				
				items.extractItem(0, this.items.getStackInSlot(0).split(availableSpace).getCount(), false);
				
				if(items.getStackInSlot(0).getItem().equals(Items.AIR)) {
					
					items.setStackInSlot(0, ItemStack.EMPTY);
				}
			}
		}
	}

	boolean blockBeingBroken(boolean onRemoved) {
		
		return breakBlock = onRemoved;
	}

	@Nullable
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {

		if (!this.remove && side != null) {

			if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
				
				return itemHandler.cast();
			}
			
		} else if(breakBlock == true && side == null) {

			if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
				
				return itemHandler.cast();
			}
		}

		return super.getCapability(cap, side);
	}
	
	@Override
	public void load(BlockState state, CompoundNBT tags) {

		super.load(state, tags);
		this.items.deserializeNBT(tags.getCompound("items"));
	}

	@Override
	public CompoundNBT save(CompoundNBT tags) {

		super.save(tags);
		tags.put("items", items.serializeNBT());
		return tags;
	}
	
	@Override
	public void setRemoved() {

		itemHandler.invalidate();
		super.setRemoved();
	}
}