package com.github.will11690.mechanicraft.util.handlers;

import com.github.will11690.mechanicraft.util.capabilities.provider.UpgradeGeneratorHandlerProvider;
import com.github.will11690.mechanicraft.util.capabilities.provider.UpgradeMachineHandlerProvider;
import com.github.will11690.mechanicraft.blocks.machines.adv.advcgen.TileEntityAdvancedCoalGenerator;
import com.github.will11690.mechanicraft.blocks.machines.adv.advfurnace.TileEntityAdvancedFurnace;
import com.github.will11690.mechanicraft.util.Reference;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CapabilityHandler {
	
	public static final ResourceLocation UPGRADE_MACHINE_HANDLER = new ResourceLocation(Reference.MOD_ID, "util/capabilities/factory/upgrademachinehandlerfactory.class");
	public static final ResourceLocation UPGRADE_GENERATOR_HANDLER = new ResourceLocation(Reference.MOD_ID, "util/capabilities/factory/upgradegeneratorhandlerfactory.class");

	@SubscribeEvent
	public static void attachCapabilityGenerator(AttachCapabilitiesEvent<TileEntity> event) {
		
		if(event.getObject() instanceof TileEntityAdvancedCoalGenerator) {
		
			event.addCapability(UPGRADE_GENERATOR_HANDLER, new UpgradeGeneratorHandlerProvider());
		}
	}
	
	@SubscribeEvent
	public static void attachCapabilityMachine(AttachCapabilitiesEvent<TileEntity> event) {
	        
		if(event.getObject() instanceof TileEntityAdvancedFurnace) {
			
			event.addCapability(UPGRADE_MACHINE_HANDLER, new UpgradeMachineHandlerProvider());
		}
	}
}
