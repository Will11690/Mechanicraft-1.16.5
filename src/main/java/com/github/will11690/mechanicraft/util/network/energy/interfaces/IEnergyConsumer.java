package com.github.will11690.mechanicraft.util.network.energy.interfaces;

import net.minecraft.util.Direction;

public interface IEnergyConsumer extends IEnergyHandler{

	int receiveEnergy(Direction from, int maxReceive, boolean simulate);
	
}
