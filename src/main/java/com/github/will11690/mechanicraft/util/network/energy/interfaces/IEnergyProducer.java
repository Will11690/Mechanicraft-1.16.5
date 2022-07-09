package com.github.will11690.mechanicraft.util.network.energy.interfaces;

import net.minecraft.util.Direction;

public interface IEnergyProducer extends IEnergyHandler{

	int extractEnergy(Direction from, int maxExtract, boolean simulate);
	
}
