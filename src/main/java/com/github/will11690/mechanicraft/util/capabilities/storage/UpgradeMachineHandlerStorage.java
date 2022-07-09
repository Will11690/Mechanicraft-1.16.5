package com.github.will11690.mechanicraft.util.capabilities.storage;

import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.util.capabilities.interfaces.IUpgradeMachineHandler;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class UpgradeMachineHandlerStorage implements Capability.IStorage<IUpgradeMachineHandler> {

    // THIS MAY NEED TO BE IPlayerData, we'll see
    @Nullable
    @Override
    public INBT writeNBT(Capability<IUpgradeMachineHandler> capability, IUpgradeMachineHandler instance, Direction side) {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("baseProcessingTime", instance.getBaseProcessingTime());
        tag.putInt("totalProcessingTime", instance.getTotalProcessingTime());
        tag.putInt("baseEnergyUsed", instance.getBaseEnergyUsed());
        tag.putInt("totalEnergyUsed", instance.getTotalEnergyUsed());
        return tag;
    }

    @Override
    public void readNBT(Capability<IUpgradeMachineHandler> capability, IUpgradeMachineHandler instance, Direction side, INBT nbt) {
        CompoundNBT tag = (CompoundNBT) nbt;
        instance.setBaseProcessingTime(tag.getInt("baseProcessingTime"));
        instance.setTotalProcessingTime(tag.getInt("totalProcessingTime"));
        instance.setBaseEnergyUsed(tag.getInt("baseEnergyUsed"));
        instance.setTotalEnergyUsed(tag.getInt("totalEnergyUsed"));
    }
}