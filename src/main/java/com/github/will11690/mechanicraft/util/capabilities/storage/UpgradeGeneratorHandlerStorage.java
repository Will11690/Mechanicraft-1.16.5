package com.github.will11690.mechanicraft.util.capabilities.storage;

import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.util.capabilities.interfaces.IUpgradeGeneratorHandler;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class UpgradeGeneratorHandlerStorage implements Capability.IStorage<IUpgradeGeneratorHandler> {

    @Nullable
    @Override
    public INBT writeNBT(Capability<IUpgradeGeneratorHandler> capability, IUpgradeGeneratorHandler instance, Direction side) {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("baseBurnTime", instance.getBaseBurnTime());
        tag.putInt("totalBurnTime", instance.getTotalBurnTime());
        tag.putInt("baseEnergyGen", instance.getBaseEnergyGen());
        tag.putInt("totalEnergyGen", instance.getTotalEnergyGen());
        return tag;
    }

    @Override
    public void readNBT(Capability<IUpgradeGeneratorHandler> capability, IUpgradeGeneratorHandler instance, Direction side, INBT nbt) {
        CompoundNBT tag = (CompoundNBT) nbt;
        instance.setBaseBurnTime(tag.getInt("baseBurnTime"));
        instance.setTotalBurnTime(tag.getInt("totalBurnTime"));
        instance.setBaseEnergyGen(tag.getInt("baseEnergyGen"));
        instance.setTotalEnergyGen(tag.getInt("totalEnergyGen"));
    }
}