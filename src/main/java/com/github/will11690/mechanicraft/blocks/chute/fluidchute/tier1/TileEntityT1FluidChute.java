package com.github.will11690.mechanicraft.blocks.chute.fluidchute.tier1;

import javax.annotation.Nonnull;
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
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;

import com.github.will11690.mechanicraft.init.ModBlocks;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;

public class TileEntityT1FluidChute extends TileEntity implements ITickableTileEntity {
	
	private FluidTank fluidTank = createFluidTank();
	private final LazyOptional<IFluidHandler> fluidHandler= LazyOptional.of(() -> fluidTank);
	
	//TODO implement fluid transfer
	//TODO create network to draw connection paths
	
	public TileEntityT1FluidChute() {
		
		super(TileEntityHandler.TILE_ENTITY_T1_FLUID_CHUTE.get());
	}
	
	private FluidTank createFluidTank() {
		// TODO Auto-generated method stub
		return new FluidTank(1000) {
			
			@Override
			protected void onContentsChanged() {
				
				setChanged();
			}
			
			@Override
			public boolean isFluidValid(int tank, @Nonnull FluidStack stack) {
					
				return true;
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
		
		if(canConnectFluid()) {
			
			if(!(neighborStateUp.getBlock().equals(Blocks.AIR)) && neighborStateUp.hasTileEntity()) { 
				
				if(level.getBlockEntity(neighborPosUp).getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.UP).isPresent()) {
			
					IFluidHandler neighborFluidUp = level.getBlockEntity(neighborPosUp).getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.UP).orElse(null);
				
					if(neighborFluidUp != null && !(neighborStateUp.getBlock().equals(ModBlocks.T1_FLUID_CHUTE.get()))) {
					
						//receiveFluid();
					
					} else if(neighborFluidUp != null) {
					
						//sendFluid();
					}
				}
			}
			
			if(!(neighborStateDown.getBlock().equals(Blocks.AIR)) && neighborStateDown.hasTileEntity()) {
				
				if(level.getBlockEntity(neighborPosDown).getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.DOWN).isPresent()) {
			
					IFluidHandler neighborFluidDown = level.getBlockEntity(neighborPosDown).getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.DOWN).orElse(null);
				
					if(neighborFluidDown != null && !(neighborStateDown.getBlock().equals(ModBlocks.T1_FLUID_CHUTE.get()))) {
					
						//receiveFluid();
					
					} else if(neighborFluidDown != null) {
					
						//sendFluid();
					}
				}
			}
			
			if(!(neighborStateNorth.getBlock().equals(Blocks.AIR)) && neighborStateNorth.hasTileEntity()) {
				
				if(level.getBlockEntity(neighborPosNorth).getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.NORTH).isPresent()) {
			
					IFluidHandler neighborFluidNorth = level.getBlockEntity(neighborPosNorth).getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.NORTH).orElse(null);
				
					if(neighborFluidNorth != null && !(neighborStateNorth.getBlock().equals(ModBlocks.T1_FLUID_CHUTE.get()))) {
					
						//receiveFluid();
					
					} else if(neighborFluidNorth != null) {
					
						//sendFluid();
					}
				}
			}
			
			if(!(neighborStateSouth.getBlock().equals(Blocks.AIR)) && neighborStateSouth.hasTileEntity()) {
				
				if(level.getBlockEntity(neighborPosSouth).getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.SOUTH).isPresent()) {
			
					IFluidHandler neighborFluidSouth = level.getBlockEntity(neighborPosSouth).getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.SOUTH).orElse(null);
				
					if(neighborFluidSouth != null && !(neighborStateSouth.getBlock().equals(ModBlocks.T1_FLUID_CHUTE.get()))) {
					
						//receiveFluid();
					
					} else if(neighborFluidSouth != null) {
					
						//sendFluid();
					}
				}
			}
			
			if(!(neighborStateEast.getBlock().equals(Blocks.AIR)) && neighborStateEast.hasTileEntity()) {
				
				if(level.getBlockEntity(neighborPosEast).getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.EAST).isPresent()) {
			
					IFluidHandler neighborFluidEast = level.getBlockEntity(neighborPosEast).getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.EAST).orElse(null);
				
					if(neighborFluidEast != null && !(neighborStateEast.getBlock().equals(ModBlocks.T1_FLUID_CHUTE.get()))) {
					
						//receiveFluid();
					
					} else if(neighborFluidEast != null) {
					
						//sendFluid();
					}
				}
			}
			
			if(!(neighborStateWest.getBlock().equals(Blocks.AIR)) && neighborStateWest.hasTileEntity()) {
				
				if(level.getBlockEntity(neighborPosWest).getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.WEST).isPresent()) {
			
				
					IFluidHandler neighborFluidWest = level.getBlockEntity(neighborPosWest).getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, Direction.WEST).orElse(null);
				
					if(neighborFluidWest != null && !(neighborStateWest.getBlock().equals(ModBlocks.T1_FLUID_CHUTE.get()))) {
					
						//receiveFluid();
					
					} else if(neighborFluidWest != null) {
					
						//sendFluid();
					}
				}
			}
		}
	}

	public boolean canConnectFluid() {
		
		if(T1FluidChute.canChuteConnectChute(level, worldPosition, Direction.UP) || T1FluidChute.canChuteConnectBlock(level, worldPosition, Direction.UP) ||
			T1FluidChute.canChuteConnectChute(level, worldPosition, Direction.DOWN) || T1FluidChute.canChuteConnectBlock(level, worldPosition, Direction.DOWN) ||
			T1FluidChute.canChuteConnectChute(level, worldPosition, Direction.NORTH) || T1FluidChute.canChuteConnectBlock(level, worldPosition, Direction.NORTH) ||
			T1FluidChute.canChuteConnectChute(level, worldPosition, Direction.SOUTH) || T1FluidChute.canChuteConnectBlock(level, worldPosition, Direction.SOUTH) ||
			T1FluidChute.canChuteConnectChute(level, worldPosition, Direction.EAST) ||T1FluidChute.canChuteConnectBlock(level, worldPosition, Direction.EAST) ||
			T1FluidChute.canChuteConnectChute(level, worldPosition, Direction.WEST) || T1FluidChute.canChuteConnectBlock(level, worldPosition, Direction.WEST)) {
			
			return true;
			
		} else
			
			return false;
	}
	
	private void receiveFluid() {
		
		//TODO Fluid Transport
	}

	private void sendFluid() {
		
		//TODO Fluid Transport
	}

	@Override
	public void load(BlockState state, CompoundNBT tags) {
	
		super.load(state, tags);
		if(tags.contains("fluidTank", Constants.NBT.TAG_COMPOUND)) {
			
			CompoundNBT fluidTankTag = tags.getCompound("fluidTank");
			this.fluidTank.readFromNBT(fluidTankTag);
		}
	}
	
	@Override
	public CompoundNBT save(CompoundNBT tags) {
	
		super.save(tags);
		CompoundNBT fluidTankTag = new CompoundNBT();
		this.fluidTank.writeToNBT(fluidTankTag);
		tags.put("fluidTank", fluidTankTag);
		return tags;
	}

	@Nullable
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
	
		CompoundNBT tags = this.getUpdateTag();
		this.save(tags);
		return new SUpdateTileEntityPacket(this.worldPosition, 1, tags);
	}

	@Override
	public CompoundNBT getUpdateTag() {
	
		CompoundNBT tags = new CompoundNBT();
		CompoundNBT fluidTankTag = new CompoundNBT();
		
		this.fluidTank.writeToNBT(fluidTankTag);
		tags.put("fluidTank", fluidTankTag);

		this.save(tags);

		return tags;
	}

	@Override
	public void handleUpdateTag(BlockState state, CompoundNBT tags) {
		
		this.fluidTank.readFromNBT(tags);
		tags.get("fluidTank");

		this.load(state, tags);

		super.handleUpdateTag(state, tags);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
	
		fluidTank.readFromNBT(packet.getTag().getCompound("fluidTank"));
	
		this.load(this.getBlockState(), packet.getTag());
		this.level.getBlockTicks().scheduleTick(this.worldPosition, this.getBlockState().getBlock(), 100);
		super.onDataPacket(net, packet);
	}

	@Nullable
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {

		if (!this.remove) {

			if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {

				return fluidHandler.cast();
			}
		}

		return super.getCapability(cap, side);
	}

	@Override
	public void setRemoved() {

		fluidHandler.invalidate();
		super.setRemoved();
	}
}