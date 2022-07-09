package com.github.will11690.mechanicraft.util.handlers;

import com.github.will11690.mechanicraft.MechaniCraftMain;
import com.github.will11690.mechanicraft.effects.FlightEffect;
import com.github.will11690.mechanicraft.init.ModBlocks;
import com.github.will11690.mechanicraft.init.ModConfigs;
import com.github.will11690.mechanicraft.init.ModFluids;

import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.potion.Effect;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import com.github.will11690.mechanicraft.init.ModItems;
import com.github.will11690.mechanicraft.init.ModRecipes;
import com.github.will11690.mechanicraft.util.Reference;

public class RegistryHandler {
	
    public static final DeferredRegister<Block> BLOCKS = create(ForgeRegistries.BLOCKS);
    public static final DeferredRegister<Block> MACHINES = create(ForgeRegistries.BLOCKS);
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = create(ForgeRegistries.CONTAINERS);
    public static final DeferredRegister<Item> ITEMS = create(ForgeRegistries.ITEMS);
    public static final DeferredRegister<Fluid> FLUIDS = create(ForgeRegistries.FLUIDS);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = create(ForgeRegistries.TILE_ENTITIES);
    public static final DeferredRegister<Effect> EFFECTS = create(ForgeRegistries.POTIONS);
    public static final RegistryObject<Effect> FLIGHT_EFFECT = EFFECTS.register("flight_effect", FlightEffect::new);

    public static void register() {
    	
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Adding Non Tile Blocks To Event Bus!");
        BLOCKS.register(modEventBus);
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Added Non Tile Blocks To Event Bus!");
        
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Adding Tile Blocks To Event Bus!");
        MACHINES.register(modEventBus);
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Added Tile Blocks To Event Bus!");
        
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Adding Containers To Event Bus!");
        CONTAINERS.register(modEventBus);
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Added Containers To Event Bus!");
        
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Adding Items To Event Bus!");
        ITEMS.register(modEventBus);
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Added Items To Event Bus!");
        
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Adding Fluids To Event Bus!");
        FLUIDS.register(modEventBus);
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Added Fluids To Event Bus!");
        
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Registering Recipes!");
        modEventBus.addGenericListener(IRecipeSerializer.class, ModRecipes::regiserRecipes);
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Recipes Registered!");
        
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Adding Tile Entities To Event Bus!");
        TILE_ENTITIES.register(modEventBus);
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Added Tile Entities To Event Bus!");
        
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Adding Effects To Event Bus!");
        EFFECTS.register(modEventBus);
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Added Effects To Event Bus!");
        
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Registering Non Tile Blocks!");
        ModBlocks.register();
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Non Tile Blocks Registered!");
        
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Registering Tile Blocks!");
        ModBlocks.registerMachines();
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Tile Blocks Registered!");
        
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Registering Containers!");
        ContainerTypeHandler.register();
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Containers Registered!");
        
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Registering Items!");
        ModItems.register();
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Items Registered!");
        
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Registering Fluids!");
        ModFluids.register();
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Fluids Registered!");
        
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Registering Tile Entities!");
        TileEntityHandler.register();
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Tile Entities Registered!");
        
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Registering Configs!");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.MECHANICRAFT_SPEC, "mechanicraft-common.toml");
        MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Configs Registered!");
        
    }

    private static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
    	
    	MechaniCraftMain.MECHANICRAFT_LOGGER.info(Reference.MOD_ID + "-" + Reference.VERSION + ": " + "Setting up Deferred Registry!");
        return DeferredRegister.create(registry, Reference.MOD_ID);
        
    }
}