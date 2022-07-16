package com.github.will11690.mechanicraft.items.energycube;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.blocks.fluidtank.advfluidtank.AdvFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.basicfluidtank.BasicFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.elitefluidtank.EliteFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.superiorfluidtank.SuperiorFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.supremefluidtank.SupremeFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.ultimatefluidtank.UltimateFluidTank;
import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.init.ModConfigs;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack;

public class CubeItem extends BlockItem {
	
	private int CAPACITY;
	private int TRANSFER;
	
	public CubeItem(Block block, Properties properties) {
		super(block, properties);
		
		if(block instanceof BasicFluidTank) {
			
			CAPACITY = ModConfigs.t1EnergyCubeCapacityInt;
			TRANSFER = ModConfigs.t1EnergyCubeTransferInt;
		}
		
		if(block instanceof AdvFluidTank) {
			
			CAPACITY = ModConfigs.t2EnergyCubeCapacityInt;
			TRANSFER = ModConfigs.t2EnergyCubeTransferInt;
		}
		
		if(block instanceof EliteFluidTank) {
			
			CAPACITY = ModConfigs.t3EnergyCubeCapacityInt;
			TRANSFER = ModConfigs.t3EnergyCubeTransferInt;
		}
		
		if(block instanceof SuperiorFluidTank) {
			
			CAPACITY = ModConfigs.t4EnergyCubeCapacityInt;
			TRANSFER = ModConfigs.t4EnergyCubeTransferInt;
		}
		
		if(block instanceof SupremeFluidTank) {
			
			CAPACITY = ModConfigs.t5EnergyCubeCapacityInt;
			TRANSFER = ModConfigs.t5EnergyCubeTransferInt;
		}
		
		if(block instanceof UltimateFluidTank) {
			
			CAPACITY = ModConfigs.t6EnergyCubeCapacityInt;
			TRANSFER = ModConfigs.t6EnergyCubeTransferInt;
		}
	}
		
	
	@Override
	public ICapabilityProvider initCapabilities(@Nonnull ItemStack stack, @Nullable CompoundNBT nbt) {
		 //TODO
		return new ICapabilityProvider() {
			MechaniCraftEnergyStorage energy = new MechaniCraftEnergyStorage(CAPACITY, TRANSFER);
			LazyOptional<EnergyStorage> energyHandler = LazyOptional.of(() -> energy);
			
			@Override
			public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
				if(cap == CapabilityEnergy.ENERGY) {
					return energyHandler.cast();
				}
				return null;
			}
		};
	}
}
