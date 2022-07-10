package com.github.will11690.mechanicraft.blocks.machines.tier5.lineminer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SoundType;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.InventoryHelper;
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
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.init.ModBlocks;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;

public class TileEntityLineMiner extends TileEntity implements ITickableTileEntity {
	
	private List<BlockState> blocksBelow = new LinkedList<>();
	private List<BlockState> blocksToSkip = new LinkedList<>();
	private List<BlockState> blocksBelowCheck = new LinkedList<>();
	
	private ItemStackHandler items = createItems();
	private MechaniCraftEnergyStorage energyStorage = createEnergy();
	
	private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
	private final LazyOptional<IItemHandler> itemHandler  = LazyOptional.of(() -> items);
	
	boolean breakBlock = false;
	
	private int powerConsume;
	private int powerConsumePerBlock = 100;
	private boolean mining;
	private int capacity;
	int blocksToMine;
	
	public TileEntityLineMiner() {
		
		super(TileEntityHandler.TILE_ENTITY_LINE_MINER.get());
	}
	
	private ItemStackHandler createItems() {
		
		return new ItemStackHandler(1) {
			
	        @Override
	        protected void onContentsChanged(int slot) {
	        	
	        	BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
	            setChanged();
	        }
		};
	}

	private MechaniCraftEnergyStorage createEnergy() {
		
		return new MechaniCraftEnergyStorage(capacity) {

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
		
		//TODO Fix bug where if placed on block like grass(plant) or leaves it wont start mining
		
		BlockPos neighborPosDown = worldPosition.below();
		BlockState neighborStateDown = level.getBlockState(neighborPosDown);
		
		if(!(this.items.getStackInSlot(0).equals(ItemStack.EMPTY))) {
			
    		this.passItemUp();
		}
		
		if(energyStorage.getCapacity() == 0 && energyStorage.getCapacity() != powerToConsume()) {
			
			capacity = powerToConsume();
			energyStorage.setCapacity(powerToConsume());
		}
		
		if(energyStorage.getEnergyStored() < energyStorage.getCapacity() && mining != true) {
			
			this.receivePower();
		}
		
		if(energyStorage.getEnergyStored() >= this.powerToConsume() && energyStorage.getCapacity() > 0) {
			
			if(canMine(level, neighborPosDown, neighborStateDown)) {
						
					this.mineBlockAndPlaceChute();
				}
						
			if(!canMine(level, neighborPosDown, neighborStateDown)) {
							
				this.placeChute(level, neighborPosDown, neighborStateDown);
			}
		}
	}
	
	public int powerToConsume() {
		
		BlockPos miner = this.worldPosition;
		int blocksToAddToList = miner.getY() - 1;
		boolean listDone;
		
		if(blocksBelow.size() + blocksToSkip.size() == blocksToAddToList) {
			
			listDone = true;
			
		} else {
			
			listDone = false;
		}
		
		if(blocksToAddToList > 0 && listDone == false) {
		
			for(int j = 0; blocksToAddToList > j; j++) {
			
				BlockPos toMine = new BlockPos(miner.getX(), j, miner.getZ());
			
				if(!(level.getBlockState(toMine).getBlock().isAir(level.getBlockState(toMine), level, toMine)) && !(level.getBlockState(toMine).getBlock() instanceof FlowingFluidBlock) &&
						!(level.getBlockState(toMine).getBlock().equals(Blocks.BEDROCK)) && !(level.getBlockState(toMine).getBlock().equals(ModBlocks.MINING_CHUTE.get()))) {
				
					blocksBelow.add(level.getBlockState(toMine));
				}
				
				if((level.getBlockState(toMine).getBlock().isAir(level.getBlockState(toMine), level, toMine)) && (level.getBlockState(toMine).getBlock() instanceof FlowingFluidBlock) &&
						level.getBlockState(toMine).getBlock().equals(Blocks.BEDROCK) && level.getBlockState(toMine).getBlock().equals(ModBlocks.MINING_CHUTE.get())) {
				
					blocksToSkip.add(level.getBlockState(toMine));
				}
				
				if(blocksBelow.size() > 0 && blocksToAddToList == blocksBelow.size() + blocksToSkip.size()) {
					
					blocksToMine = blocksToAddToList;
					break;
				}
			}
		
			for(int i = 0; blocksBelow.size() > i; i++) {
			
				BlockPos toMine = new BlockPos(miner.getX(), i, miner.getZ());
			
				float hardness = blocksBelow.get(i).getDestroySpeed(level, toMine);
				int powerToBreakBlock = Math.round(powerConsumePerBlock * hardness);
				powerConsume = powerConsume + powerToBreakBlock;
				blocksBelowCheck.add(blocksBelow.get(i));
				
				if(blocksBelow.size() > 0 && blocksBelow.size() == blocksBelowCheck.size()) {
					
					listDone = true;
					break;
				}
			}
		}
		
		return powerConsume;
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
    	
		if(energyStorage.getEnergyStored() >= powerToConsume()) {
			
			this.energyStorage.consumeEnergy(this.powerToConsume());
			mining = true;
			
			blockDrops = Block.getDrops(neighborStateDown, (ServerWorld) level, neighborPosDown, level.getBlockEntity(neighborPosDown));
	        
	        if(blockDrops.isEmpty()) {
	        	
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
				
			} else if(neighborInventory != null && (neighborInventory.getStackInSlot(0).equals(ItemStack.EMPTY) ||
					neighborInventory.getStackInSlot(0).getItem().equals(this.items.getStackInSlot(0).getItem()))) {
				
				ItemStack simulate = neighborInventory.insertItem(0, this.items.getStackInSlot(0), true);
				int availableSpace = this.items.getStackInSlot(0).getCount() - simulate.getCount();
				
				neighborInventory.insertItem(0, this.items.getStackInSlot(0).split(availableSpace), false);
				items.extractItem(0, this.items.getStackInSlot(0).split(availableSpace).getCount(), false);
				
				if(items.getStackInSlot(0).getItem().equals(Items.AIR)) {
					
					items.setStackInSlot(0, ItemStack.EMPTY);
				}
			}
		} else if((!(items.getStackInSlot(0).equals(ItemStack.EMPTY)) || items.getStackInSlot(0).getCount() > 0)) {
			
			Inventory storedInv = new Inventory(items.getStackInSlot(0));
			
			System.out.println(storedInv);
			InventoryHelper.dropContents(level, worldPosition.above(), storedInv);
			
			if(items.getStackInSlot(0).getItem().equals(Items.AIR)) {
				
				items.setStackInSlot(0, ItemStack.EMPTY);
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
                    	
                        if(handler.canExtract()) {
                                	
                            int extracted = handler.extractEnergy(Math.min(handler.getEnergyStored(), energyStorage.getCapacity()), false);
                            energy.addAndGet(extracted);
                            energyStorage.addEnergy(extracted);
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

			if (cap == CapabilityEnergy.ENERGY) {
				
				return energy.cast();
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
		this.energyStorage.deserializeNBT(tags.getCompound("energy"));
	}

	@Override
	public CompoundNBT save(CompoundNBT tags) {

		super.save(tags);
		tags.put("items", items.serializeNBT());
		tags.put("energy", energyStorage.serializeNBT());
		return tags;
	}
	
	@Override
	public void setRemoved() {

		itemHandler.invalidate();
		energy.invalidate();
		blocksBelow.clear();
		blocksToSkip.clear();
		blocksBelowCheck.clear();
		super.setRemoved();
	}
}