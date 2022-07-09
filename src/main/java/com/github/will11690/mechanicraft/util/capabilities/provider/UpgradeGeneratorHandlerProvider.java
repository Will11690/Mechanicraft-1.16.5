package com.github.will11690.mechanicraft.util.capabilities.provider;

import com.github.will11690.mechanicraft.util.capabilities.interfaces.IUpgradeGeneratorHandler;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class UpgradeGeneratorHandlerProvider implements ICapabilitySerializable<INBT> {

	@CapabilityInject(IUpgradeGeneratorHandler.class)
	public static Capability<IUpgradeGeneratorHandler> capability = null;
	private LazyOptional<IUpgradeGeneratorHandler> instance = LazyOptional.of(capability::getDefaultInstance);

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
    	
		return cap == capability ? instance.cast() : LazyOptional.empty();
        
	}

	@Override
	public INBT serializeNBT() {
    	
		return capability.getStorage().writeNBT(capability, this.instance.orElse(null), null);
        
	}

	@Override
	public void deserializeNBT(INBT nbt) {
    	
		capability.getStorage().readNBT(capability, this.instance.orElse(null), null, nbt);
        
	}
}