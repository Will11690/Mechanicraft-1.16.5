package com.github.will11690.mechanicraft;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.will11690.mechanicraft.init.ModFeatures;
import com.github.will11690.mechanicraft.util.Reference;
import com.github.will11690.mechanicraft.util.capabilities.factory.UpgradeGeneratorHandlerFactory;
import com.github.will11690.mechanicraft.util.capabilities.factory.UpgradeMachineHandlerFactory;
import com.github.will11690.mechanicraft.util.capabilities.interfaces.IUpgradeGeneratorHandler;
import com.github.will11690.mechanicraft.util.capabilities.interfaces.IUpgradeMachineHandler;
import com.github.will11690.mechanicraft.util.capabilities.storage.UpgradeGeneratorHandlerStorage;
import com.github.will11690.mechanicraft.util.capabilities.storage.UpgradeMachineHandlerStorage;
import com.github.will11690.mechanicraft.util.handlers.RegistryHandler;

@Mod(Reference.MOD_ID)
public class MechaniCraftMain {

	//TODO CLEAN ALL FORMATTING(Chutes done)
	
    public static final Logger MECHANICRAFT_LOGGER = LogManager.getLogger();
    
    //TODO Bug discovered where upon replacing machine after breaking with upgrade in it energy is reset(most likely applies to fluids too)
    //only seems to apply when block is placed down next to another block doing updates, very weird
    
  	//TODO FEATURES FOR VERSION 1.1.0
    
    //TODO Side config and auto eject for machines
    //TODO Create Fluid Handler for itemstacks of tanks(Capacities and init capabilities already added to TankItem)
    //TODO Create Energy Handler for itemstacks of energy cubes
    //TODO add power consumption and work times to configs for machines
    //TODO un-hardcode the requirement for all slots in press to be filled for more versatility(most likely add a boolean check with recipes for slots used)
    //TODO localized text for configs
    //TODO Finish all marked todos in ModConfigs
  	//TODO Rework basic infuser front texture
    //TODO Creative Upgrade(implement it, item already in)
  	//TODO Fluid Pipes(Add Functionality)
  	//TODO Item Pipes(Add Functionality)
  	//TODO Energy Pipes(Add Functionality)
    //TODO Make Mob proof blocks(.strength(hardness, resistance) set resistance to Float.MAX_VALUE to make them explosion proof)
    //TODO Wither Killer
    //TODO Wither Builder(7 slots, stack size 1: for easy automation)
    //TODO Void Ore Miner
    //TODO Finish tier basic - 6 machines(new machines, all have empty packages)
  	//TODO Steam Generator and Producer
  	//TODO Biofuel
  	//TODO Oil Fuel and generation
  	//TODO Add heat to liquid slag(and posion, nausea, and hunger when touched)
  	//TODO Add slag reprocessor that turns slag liquid into slag item
  	//TODO create slag(item) recycler
  	//TODO Add matter fabricator type machine
  	//TODO Add UU-Matter type item

  	//POSSIBLE FEATURES

  	//TODO Make machines face away from you when shift key is pressed(if(GuiScreen.isShiftPressed())(player.isSneaking maybe??)
  	//TODO Gas Pipe(Maybe eventually not currently planned)(potential Mekanism Support)
  	//TODO Gaseous fluid tank(Maybe eventually not currently planned)(potential Mekanism Support)

    public MechaniCraftMain() {
    	
    	IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	
    	MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Loading Registry Handler!");
    	RegistryHandler.register();
    	MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Registry Handler Loaded!");
    	
    	MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Adding Listener To Event Bus!");
        modEventBus.addListener(this::setup);
        MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Listener Added!");
        
        MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Registering Event Bus!");
        MinecraftForge.EVENT_BUS.register(this);
        MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Event Bus Registered!");
        
    }
    
    private void setup(final FMLCommonSetupEvent event) {
    	
    	MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Injecting Capabilities!");
    	CapabilityManager.INSTANCE.register(IUpgradeMachineHandler.class, new UpgradeMachineHandlerStorage(), UpgradeMachineHandlerFactory::new);
    	CapabilityManager.INSTANCE.register(IUpgradeGeneratorHandler.class, new UpgradeGeneratorHandlerStorage(), UpgradeGeneratorHandlerFactory::new);
    	MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Capabilities Injected!");
    	
    	MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Regeistering World Gen Features!");
    	ModFeatures.registerEvent(event);
    	MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "World Gen Features Registered!");
    }
}