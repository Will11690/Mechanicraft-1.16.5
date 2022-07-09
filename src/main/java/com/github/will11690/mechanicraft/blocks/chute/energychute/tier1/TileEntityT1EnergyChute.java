package com.github.will11690.mechanicraft.blocks.chute.energychute.tier1;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.init.ModBlocks;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;

public class TileEntityT1EnergyChute extends TileEntity implements ITickableTileEntity {
	
	private MechaniCraftEnergyStorage energyStorage = createEnergy();
	private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
	
	//TODO implement proper power transfer
	//TODO create network to draw connection paths
	
	public TileEntityT1EnergyChute() {
		
		super(TileEntityHandler.TILE_ENTITY_T1_ENERGY_CHUTE.get());
	}
	
	private MechaniCraftEnergyStorage createEnergy() {

		return new MechaniCraftEnergyStorage(5000, 1000) {

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
		
		BlockPos neighborPosUp = worldPosition.above();
		BlockState neighborStateUp = level.getBlockState(neighborPosUp);
		
		BlockPos neighborPosDown = worldPosition.below();
		BlockState neighborStateDown = level.getBlockState(neighborPosDown);
		
		BlockPos neighborPosNorth = worldPosition.north();
		BlockState neighborStateNorth = level.getBlockState(neighborPosNorth);
		
		BlockPos neighborPosSouth = worldPosition.south();
		BlockState neighborStateSouth = level.getBlockState(neighborPosSouth);
		
		BlockPos neighborPosEast = worldPosition.east();
		BlockState neighborStateEast = level.getBlockState(neighborPosEast);
		
		BlockPos neighborPosWest = worldPosition.west();
		BlockState neighborStateWest = level.getBlockState(neighborPosWest);
		
		if(canConnectEnergy()) {
			
			if(!(neighborStateUp.getBlock().equals(Blocks.AIR)) && neighborStateUp.hasTileEntity()) { 
				
				if(level.getBlockEntity(neighborPosUp).getCapability(CapabilityEnergy.ENERGY, Direction.UP).isPresent()) {
			
					IEnergyStorage neighborEnergyUp = level.getBlockEntity(neighborPosUp).getCapability(CapabilityEnergy.ENERGY, Direction.UP).orElse(null);
				
					if(neighborEnergyUp != null && neighborEnergyUp.canExtract() && !(neighborStateUp.getBlock().equals(ModBlocks.T1_ENERGY_CHUTE.get()))) {
					
						receivePower();
					
					} else if(neighborEnergyUp != null && neighborEnergyUp.canReceive()) {
					
						sendPower();
					}
				}
			}
			
			if(!(neighborStateDown.getBlock().equals(Blocks.AIR)) && neighborStateDown.hasTileEntity()) {
				
				if(level.getBlockEntity(neighborPosDown).getCapability(CapabilityEnergy.ENERGY, Direction.DOWN).isPresent()) {
			
					IEnergyStorage neighborEnergyDown = level.getBlockEntity(neighborPosDown).getCapability(CapabilityEnergy.ENERGY, Direction.DOWN).orElse(null);
				
					if(neighborEnergyDown != null && neighborEnergyDown.canExtract() && !(neighborStateDown.getBlock().equals(ModBlocks.T1_ENERGY_CHUTE.get()))) {
					
						receivePower();
					
					} else if(neighborEnergyDown != null && neighborEnergyDown.canReceive()) {
					
						sendPower();
					}
				}
			}
			
			if(!(neighborStateNorth.getBlock().equals(Blocks.AIR)) && neighborStateNorth.hasTileEntity()) {
				
				if(level.getBlockEntity(neighborPosNorth).getCapability(CapabilityEnergy.ENERGY, Direction.NORTH).isPresent()) {
			
					IEnergyStorage neighborEnergyNorth = level.getBlockEntity(neighborPosNorth).getCapability(CapabilityEnergy.ENERGY, Direction.NORTH).orElse(null);
				
					if(neighborEnergyNorth != null && neighborEnergyNorth.canExtract() && !(neighborStateNorth.getBlock().equals(ModBlocks.T1_ENERGY_CHUTE.get()))) {
					
						receivePower();
					
					} else if(neighborEnergyNorth != null && neighborEnergyNorth.canReceive()) {
					
						sendPower();
					}
				}
			}
			
			if(!(neighborStateSouth.getBlock().equals(Blocks.AIR)) && neighborStateSouth.hasTileEntity()) {
				
				if(level.getBlockEntity(neighborPosSouth).getCapability(CapabilityEnergy.ENERGY, Direction.SOUTH).isPresent()) {
			
					IEnergyStorage neighborEnergySouth = level.getBlockEntity(neighborPosSouth).getCapability(CapabilityEnergy.ENERGY, Direction.SOUTH).orElse(null);
				
					if(neighborEnergySouth != null && neighborEnergySouth.canExtract() && !(neighborStateSouth.getBlock().equals(ModBlocks.T1_ENERGY_CHUTE.get()))) {
					
						receivePower();
					
					} else if(neighborEnergySouth != null && neighborEnergySouth.canReceive()) {
					
						sendPower();
					}
				}
			}
			
			if(!(neighborStateEast.getBlock().equals(Blocks.AIR)) && neighborStateEast.hasTileEntity()) {
				
				if(level.getBlockEntity(neighborPosEast).getCapability(CapabilityEnergy.ENERGY, Direction.EAST).isPresent()) {
			
					IEnergyStorage neighborEnergyEast = level.getBlockEntity(neighborPosEast).getCapability(CapabilityEnergy.ENERGY, Direction.EAST).orElse(null);
				
					if(neighborEnergyEast != null && neighborEnergyEast.canExtract() && !(neighborStateEast.getBlock().equals(ModBlocks.T1_ENERGY_CHUTE.get()))) {
					
						receivePower();
					
					} else if(neighborEnergyEast != null && neighborEnergyEast.canReceive()) {
					
						sendPower();
					}
				}
			}
			
			if(!(neighborStateWest.getBlock().equals(Blocks.AIR)) && neighborStateWest.hasTileEntity()) {
				
				if(level.getBlockEntity(neighborPosWest).getCapability(CapabilityEnergy.ENERGY, Direction.WEST).isPresent()) {
			
				
					IEnergyStorage neighborEnergyWest = level.getBlockEntity(neighborPosWest).getCapability(CapabilityEnergy.ENERGY, Direction.WEST).orElse(null);
				
					if(neighborEnergyWest != null && neighborEnergyWest.canExtract() && !(neighborStateWest.getBlock().equals(ModBlocks.T1_ENERGY_CHUTE.get()))) {
					
						receivePower();
					
					} else if(neighborEnergyWest != null && neighborEnergyWest.canReceive()) {
					
						sendPower();
					}
				}
			}
		}
	}

	public boolean canConnectEnergy() {
		
		if(T1EnergyChute.canChuteConnectChute(level, worldPosition, Direction.UP) || T1EnergyChute.canChuteConnectBlock(level, worldPosition, Direction.UP) ||
			T1EnergyChute.canChuteConnectChute(level, worldPosition, Direction.DOWN) || T1EnergyChute.canChuteConnectBlock(level, worldPosition, Direction.DOWN) ||
			T1EnergyChute.canChuteConnectChute(level, worldPosition, Direction.NORTH) || T1EnergyChute.canChuteConnectBlock(level, worldPosition, Direction.NORTH) ||
			T1EnergyChute.canChuteConnectChute(level, worldPosition, Direction.SOUTH) || T1EnergyChute.canChuteConnectBlock(level, worldPosition, Direction.SOUTH) ||
			T1EnergyChute.canChuteConnectChute(level, worldPosition, Direction.EAST) ||T1EnergyChute.canChuteConnectBlock(level, worldPosition, Direction.EAST) ||
			T1EnergyChute.canChuteConnectChute(level, worldPosition, Direction.WEST) || T1EnergyChute.canChuteConnectBlock(level, worldPosition, Direction.WEST)) {
			
			return true;
			
		} else
			
			return false;
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

	private void sendPower() {
		
		AtomicInteger energy = new AtomicInteger(energyStorage.getEnergyStored());

		if(energy.get() > 0) {
	
			for(Direction direction : Direction.values()) {
	
				TileEntity te = level.getBlockEntity(worldPosition.relative(direction));

				if(te != null) {
	
					boolean doContinue = te.getCapability(CapabilityEnergy.ENERGY, direction).map(handler -> {
	
						if(handler.canReceive()) {
	
							int received = handler.receiveEnergy(Math.min(energy.get(), energyStorage.getMaxExtract()), false);
							energy.addAndGet(-received);
							energyStorage.extractEnergy(received, false);
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

	@Override
	public void load(BlockState state, CompoundNBT tags) {
	
		super.load(state, tags);
		this.energyStorage.deserializeNBT(tags.getCompound("energy"));
	}
	
	@Override
	public CompoundNBT save(CompoundNBT tags) {
	
		super.save(tags);
		tags.put("energy", energyStorage.serializeNBT());
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
		return save(new CompoundNBT());
	}

	@Override
	public void handleUpdateTag(BlockState stateIn, CompoundNBT tag) {
		load(stateIn, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		load(this.getBlockState(), pkt.getTag());
	}

	@Nullable
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {

		if (!this.remove) {

			if (cap == CapabilityEnergy.ENERGY) {

				return energy.cast();
			}
		}

		return super.getCapability(cap, side);
	}

	@Override
	public void setRemoved() {

		energy.invalidate();
		super.setRemoved();
	}
}