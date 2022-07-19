package com.github.will11690.mechanicraft;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.will11690.mechanicraft.init.ModConfigs;
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

	//TODO CLEAN ALL FORMATTING(Chutes, ModConfigs done)
    //TODO Utility package created for possible ideas, once implementation is decided move to correct packages(IF ADDED AT ALL)
	
    public static final Logger MECHANICRAFT_LOGGER = LogManager.getLogger();
    
    //TODO store player health before applying health bonus from armor and set max health back to that once removed
    //TODO fix bug where Fluid Handler Item with fluid matching output tanks can't remove more(add FluidStack matching to tankToInteractWith)
    
    //TODO May replace gem meshes with obsidium
    //TODO Maybe add Line Miner to configs, currently it is 100FE * Hardness of block to mine
    
  	//TODO FEATURES FOR VERSION 1.1.0
    
    //TODO Make Energy Cubes multiblocks like a mix between ender io capacitors and mekanism induction cell
    
    //TODO Side config and auto eject for machines
    //TODO Create Fluid Handler for itemstacks of tanks(Capacities and init capabilities already added to TankItem)
    //TODO Create Energy Handler for itemstacks of energy cubes
    //TODO un-hardcode the requirement for all slots in press to be filled for more versatility(most likely add a boolean check with recipes for slots used)
    //TODO localized text for configs
    
  	//TODO Fluid Pipes(Add Functionality)
  	//TODO Item Pipes(Add Functionality)
  	//TODO Energy Pipes(Add Functionality)
    
    //TODO Finish tier basic - 6 machines(new machines, all have empty packages)
    
    //TODO Void Ore Miner
    //---- Dimension focus for miner
    //---- Filters for miner
    //----Implementation will be adding all forge/ores to list then generate random number from 1 to max list size and that will be output
    //----Will need to see bedrock to work(maybe add all blocks beneath it to list and if any are not air or bedrock set canRun to false)
    //----Filter will override list to only search for ores in filter
    //----Dimension focus will override list with only ores in that dimension tag(forge/netherores or forge/endores)
    //----Output chance will again be a random number generator with speed upgrades shrinking max number by certain amount
    //----Can find random number generator in Crusher or Sieve recipes
    
    //TODO Quarry
    
  	//TODO Add heat to liquid slag(and posion, nausea, and hunger when touched)
  	//TODO Add slag reprocessor that turns slag liquid into slag item
  	//TODO create slag(item) recycler
  	//TODO Add matter fabricator type machine
  	//TODO Add UU-Matter type item
  	//TODO Rework basic infuser front texture
    //TODO Creative Upgrade(implement it, item already in)

  	//POSSIBLE FEATURES

  	//TODO Make machines face away from you when shift key is pressed(if(GuiScreen.isShiftPressed())(player.isSneaking maybe??)
  	//TODO Gas Pipe(Maybe eventually not currently planned)(potential Mekanism Support)
  	//TODO Gaseous fluid tank(Maybe eventually not currently planned)(potential Mekanism Support)

    public MechaniCraftMain() {
    	
    	IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	
    	MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Registering Configs!");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.MECHANICRAFT_SPEC, "mechanicraft-common.toml");
        MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Configs Registered!");
    	
    	MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Baking Configs!");
        ModConfigs.bakeConfig();
        MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Configs Baked!");
    	
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