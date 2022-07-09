package com.github.will11690.mechanicraft.util.network.energy.interfaces;

import net.minecraft.util.Direction;

public interface IEnergyHandler extends IEnergyConnector{
	
	int getEnergyStored(Direction from);
	
	int getMaxEnergyStored(Direction from);
	
	int receiveEnergy(int maxReceive, boolean simulate);
	
	int extractEnergy(int maxExtract, boolean simulate);
	
	int getEnergyStored();
	
	int getMaxEnergyStored();
	
	boolean canExtract();
	
	boolean canReceive();
	
}
