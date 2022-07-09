package com.github.will11690.mechanicraft.util.handlers;

import java.util.function.Supplier;

import com.github.will11690.mechanicraft.blocks.chute.energychute.tier1.TileEntityT1EnergyChute;
import com.github.will11690.mechanicraft.blocks.chute.fluidchute.tier1.TileEntityT1FluidChute;
import com.github.will11690.mechanicraft.blocks.chute.itemchute.tier1.TileEntityT1ItemChute;
import com.github.will11690.mechanicraft.blocks.fluidtank.advfluidtank.TileEntityAdvFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.basicfluidtank.TileEntityBasicFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.elitefluidtank.TileEntityEliteFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.superiorfluidtank.TileEntitySuperiorFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.supremefluidtank.TileEntitySupremeFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.ultimatefluidtank.TileEntityUltimateFluidTank;
import com.github.will11690.mechanicraft.blocks.machines.adv.advcgen.TileEntityAdvancedCoalGenerator;
import com.github.will11690.mechanicraft.blocks.machines.adv.advfurnace.TileEntityAdvancedFurnace;
import com.github.will11690.mechanicraft.blocks.machines.basic.basiccgen.TileEntityBasicCoalGenerator;
import com.github.will11690.mechanicraft.blocks.machines.basic.basicfurnace.TileEntityBasicFurnace;
import com.github.will11690.mechanicraft.blocks.machines.basic.basicinfuser.TileEntityBasicMetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1crusher.TileEntityT1Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1energycube.TileEntityT1EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1infuser.TileEntityT1MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1orewasher.TileEntityT1OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1poweredsieve.TileEntityT1PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1press.TileEntityT1Press;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1slurryprocessor.TileEntityT1SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2crusher.TileEntityT2Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2energycube.TileEntityT2EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2infuser.TileEntityT2MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2orewasher.TileEntityT2OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2poweredsieve.TileEntityT2PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2press.TileEntityT2Press;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2slurryprocessor.TileEntityT2SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3crusher.TileEntityT3Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3energycube.TileEntityT3EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3infuser.TileEntityT3MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3orewasher.TileEntityT3OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3poweredsieve.TileEntityT3PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3press.TileEntityT3Press;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3slurryprocessor.TileEntityT3SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4crusher.TileEntityT4Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4energycube.TileEntityT4EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4infuser.TileEntityT4MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4orewasher.TileEntityT4OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4poweredsieve.TileEntityT4PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4press.TileEntityT4Press;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4slurryprocessor.TileEntityT4SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier5.lineminer.TileEntityLineMiner;
import com.github.will11690.mechanicraft.blocks.machines.tier5.lineminer.miningchute.TileEntityMiningChute;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5crusher.TileEntityT5Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5energycube.TileEntityT5EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5infuser.TileEntityT5MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5orewasher.TileEntityT5OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5poweredsieve.TileEntityT5PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5press.TileEntityT5Press;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5slurryprocessor.TileEntityT5SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6crusher.TileEntityT6Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6energycube.TileEntityT6EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6infuser.TileEntityT6MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6orewasher.TileEntityT6OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6poweredsieve.TileEntityT6PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6press.TileEntityT6Press;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6slurryprocessor.TileEntityT6SlurryProcessor;
import com.github.will11690.mechanicraft.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class TileEntityHandler {
	
	//BASIC
    public static final RegistryObject<TileEntityType<TileEntityBasicMetallicInfuser>> TILE_ENTITY_BASIC_METALLIC_INFUSER = register(
            "tile_entity_basic_metallic_infuser", TileEntityBasicMetallicInfuser::new, ModBlocks.BASIC_METALLIC_INFUSER);
    
    public static final RegistryObject<TileEntityType<TileEntityBasicCoalGenerator>> TILE_ENTITY_BASIC_COAL_GENERATOR = register(
            "tile_entity_basic_coal_generator", TileEntityBasicCoalGenerator::new, ModBlocks.BASIC_COAL_GENERATOR);
    
    public static final RegistryObject<TileEntityType<TileEntityBasicFurnace>> TILE_ENTITY_BASIC_FURNACE = register(
            "tile_entity_basic_furnace", TileEntityBasicFurnace::new, ModBlocks.BASIC_FURNACE);
    
    //ADVANCED
    public static final RegistryObject<TileEntityType<TileEntityAdvancedCoalGenerator>> TILE_ENTITY_ADVANCED_COAL_GENERATOR = register(
            "tile_entity_advanced_coal_generator", TileEntityAdvancedCoalGenerator::new, ModBlocks.ADVANCED_COAL_GENERATOR);
    
    public static final RegistryObject<TileEntityType<TileEntityAdvancedFurnace>> TILE_ENTITY_ADVANCED_FURNACE = register(
            "tile_entity_advanced_furnace", TileEntityAdvancedFurnace::new, ModBlocks.ADVANCED_FURNACE);
    
    //CHUTES
    
    //ENERGY
    public static final RegistryObject<TileEntityType<TileEntityT1EnergyChute>> TILE_ENTITY_T1_ENERGY_CHUTE = register(
            "tile_entity_t1_energy_chute", TileEntityT1EnergyChute::new, ModBlocks.T1_ENERGY_CHUTE);
    
    //ITEM
    public static final RegistryObject<TileEntityType<TileEntityT1ItemChute>> TILE_ENTITY_T1_ITEM_CHUTE = register(
            "tile_entity_t1_item_chute", TileEntityT1ItemChute::new, ModBlocks.T1_ITEM_CHUTE);
    
    //FLUID
    public static final RegistryObject<TileEntityType<TileEntityT1FluidChute>> TILE_ENTITY_T1_FLUID_CHUTE = register(
            "tile_entity_t1_fluid_chute", TileEntityT1FluidChute::new, ModBlocks.T1_FLUID_CHUTE);
    
    //FLUID TANKS
    
    //BASIC
    public static final RegistryObject<TileEntityType<TileEntityBasicFluidTank>> TILE_ENTITY_BASIC_FLUID_TANK = register(
            "tile_entity_basic_fluid_tank", TileEntityBasicFluidTank::new, ModBlocks.BASIC_FLUID_TANK);
    
    //ADVANCED
    public static final RegistryObject<TileEntityType<TileEntityAdvFluidTank>> TILE_ENTITY_ADVANCED_FLUID_TANK = register(
            "tile_entity_advanced_fluid_tank", TileEntityAdvFluidTank::new, ModBlocks.ADVANCED_FLUID_TANK);
    
    //ELITE
    public static final RegistryObject<TileEntityType<TileEntityEliteFluidTank>> TILE_ENTITY_ELITE_FLUID_TANK = register(
            "tile_entity_elite_fluid_tank", TileEntityEliteFluidTank::new, ModBlocks.ELITE_FLUID_TANK);
    
    //SUPERIOR
    public static final RegistryObject<TileEntityType<TileEntitySuperiorFluidTank>> TILE_ENTITY_SUPERIOR_FLUID_TANK = register(
            "tile_entity_superior_fluid_tank", TileEntitySuperiorFluidTank::new, ModBlocks.SUPERIOR_FLUID_TANK);
    
    //SUPREME
    public static final RegistryObject<TileEntityType<TileEntitySupremeFluidTank>> TILE_ENTITY_SUPREME_FLUID_TANK = register(
            "tile_entity_supremec_fluid_tank", TileEntitySupremeFluidTank::new, ModBlocks.SUPREME_FLUID_TANK);
    
    //ULTIMATE
    public static final RegistryObject<TileEntityType<TileEntityUltimateFluidTank>> TILE_ENTITY_ULTIMATE_FLUID_TANK = register(
            "tile_entity_ultimate_fluid_tank", TileEntityUltimateFluidTank::new, ModBlocks.ULTIMATE_FLUID_TANK);
    
    //T1
    public static final RegistryObject<TileEntityType<TileEntityT1EnergyCube>> TILE_ENTITY_T1_ENERGY_CUBE = register(
            "tile_entity_t1_energy_cube", TileEntityT1EnergyCube::new, ModBlocks.T1_ENERGY_CUBE);
    
    public static final RegistryObject<TileEntityType<TileEntityT1Crusher>> TILE_ENTITY_T1_CRUSHER = register(
            "tile_entity_t1_crusher", TileEntityT1Crusher::new, ModBlocks.T1_CRUSHER);
    
    public static final RegistryObject<TileEntityType<TileEntityT1Press>> TILE_ENTITY_T1_PRESS = register(
            "tile_entity_t1_press", TileEntityT1Press::new, ModBlocks.T1_PRESS);
    
    public static final RegistryObject<TileEntityType<TileEntityT1MetallicInfuser>> TILE_ENTITY_T1_METALLIC_INFUSER = register(
            "tile_entity_t1_metallic_infuser", TileEntityT1MetallicInfuser::new, ModBlocks.T1_METALLIC_INFUSER);
    
    public static final RegistryObject<TileEntityType<TileEntityT1PoweredSieve>> TILE_ENTITY_T1_POWERED_SIEVE = register(
            "tile_entity_t1_powered_sieve", TileEntityT1PoweredSieve::new, ModBlocks.T1_POWERED_SIEVE);
    
    public static final RegistryObject<TileEntityType<TileEntityT1OreWasher>> TILE_ENTITY_T1_ORE_WASHER = register(
            "tile_entity_t1_ore_washer", TileEntityT1OreWasher::new, ModBlocks.T1_ORE_WASHER);
    
    public static final RegistryObject<TileEntityType<TileEntityT1SlurryProcessor>> TILE_ENTITY_T1_SLURRY_PROCESSOR = register(
            "tile_entity_t1_slurry_processor", TileEntityT1SlurryProcessor::new, ModBlocks.T1_SLURRY_PROCESSOR);
    
    //T2
    public static final RegistryObject<TileEntityType<TileEntityT2EnergyCube>> TILE_ENTITY_T2_ENERGY_CUBE = register(
            "tile_entity_t2_energy_cube", TileEntityT2EnergyCube::new, ModBlocks.T2_ENERGY_CUBE);
    
    public static final RegistryObject<TileEntityType<TileEntityT2Crusher>> TILE_ENTITY_T2_CRUSHER = register(
            "tile_entity_t2_crusher", TileEntityT2Crusher::new, ModBlocks.T2_CRUSHER);
    
    public static final RegistryObject<TileEntityType<TileEntityT2Press>> TILE_ENTITY_T2_PRESS = register(
            "tile_entity_t2_press", TileEntityT2Press::new, ModBlocks.T2_PRESS);
    
    public static final RegistryObject<TileEntityType<TileEntityT2MetallicInfuser>> TILE_ENTITY_T2_METALLIC_INFUSER = register(
            "tile_entity_t2_metallic_infuser", TileEntityT2MetallicInfuser::new, ModBlocks.T2_METALLIC_INFUSER);
    
    public static final RegistryObject<TileEntityType<TileEntityT2PoweredSieve>> TILE_ENTITY_T2_POWERED_SIEVE = register(
            "tile_entity_t2_powered_sieve", TileEntityT2PoweredSieve::new, ModBlocks.T2_POWERED_SIEVE);
    
    public static final RegistryObject<TileEntityType<TileEntityT2OreWasher>> TILE_ENTITY_T2_ORE_WASHER = register(
            "tile_entity_t2_ore_washer", TileEntityT2OreWasher::new, ModBlocks.T2_ORE_WASHER);
    
    public static final RegistryObject<TileEntityType<TileEntityT2SlurryProcessor>> TILE_ENTITY_T2_SLURRY_PROCESSOR = register(
            "tile_entity_t2_slurry_processor", TileEntityT2SlurryProcessor::new, ModBlocks.T2_SLURRY_PROCESSOR);
    
    //T3
    public static final RegistryObject<TileEntityType<TileEntityT3EnergyCube>> TILE_ENTITY_T3_ENERGY_CUBE = register(
            "tile_entity_t3_energy_cube", TileEntityT3EnergyCube::new, ModBlocks.T3_ENERGY_CUBE);
    
    public static final RegistryObject<TileEntityType<TileEntityT3Crusher>> TILE_ENTITY_T3_CRUSHER = register(
            "tile_entity_t3_crusher", TileEntityT3Crusher::new, ModBlocks.T3_CRUSHER);
    
    public static final RegistryObject<TileEntityType<TileEntityT3Press>> TILE_ENTITY_T3_PRESS = register(
            "tile_entity_t3_press", TileEntityT3Press::new, ModBlocks.T3_PRESS);
    
    public static final RegistryObject<TileEntityType<TileEntityT3MetallicInfuser>> TILE_ENTITY_T3_METALLIC_INFUSER = register(
            "tile_entity_t3_metallic_infuser", TileEntityT3MetallicInfuser::new, ModBlocks.T3_METALLIC_INFUSER);
    
    public static final RegistryObject<TileEntityType<TileEntityT3PoweredSieve>> TILE_ENTITY_T3_POWERED_SIEVE = register(
            "tile_entity_t3_powered_sieve", TileEntityT3PoweredSieve::new, ModBlocks.T3_POWERED_SIEVE);
    
    public static final RegistryObject<TileEntityType<TileEntityT3OreWasher>> TILE_ENTITY_T3_ORE_WASHER = register(
            "tile_entity_t3_ore_washer", TileEntityT3OreWasher::new, ModBlocks.T3_ORE_WASHER);
    
    public static final RegistryObject<TileEntityType<TileEntityT3SlurryProcessor>> TILE_ENTITY_T3_SLURRY_PROCESSOR = register(
            "tile_entity_t3_slurry_processor", TileEntityT3SlurryProcessor::new, ModBlocks.T3_SLURRY_PROCESSOR);
    
    //T4
    public static final RegistryObject<TileEntityType<TileEntityT4EnergyCube>> TILE_ENTITY_T4_ENERGY_CUBE = register(
            "tile_entity_t4_energy_cube", TileEntityT4EnergyCube::new, ModBlocks.T4_ENERGY_CUBE);
    
    public static final RegistryObject<TileEntityType<TileEntityT4Crusher>> TILE_ENTITY_T4_CRUSHER = register(
            "tile_entity_t4_crusher", TileEntityT4Crusher::new, ModBlocks.T4_CRUSHER);
    
    public static final RegistryObject<TileEntityType<TileEntityT4Press>> TILE_ENTITY_T4_PRESS = register(
            "tile_entity_t4_press", TileEntityT4Press::new, ModBlocks.T4_PRESS);
    
    public static final RegistryObject<TileEntityType<TileEntityT4MetallicInfuser>> TILE_ENTITY_T4_METALLIC_INFUSER = register(
            "tile_entity_t4_metallic_infuser", TileEntityT4MetallicInfuser::new, ModBlocks.T4_METALLIC_INFUSER);
    
    public static final RegistryObject<TileEntityType<TileEntityT4PoweredSieve>> TILE_ENTITY_T4_POWERED_SIEVE = register(
            "tile_entity_t4_powered_sieve", TileEntityT4PoweredSieve::new, ModBlocks.T4_POWERED_SIEVE);
    
    public static final RegistryObject<TileEntityType<TileEntityT4OreWasher>> TILE_ENTITY_T4_ORE_WASHER = register(
            "tile_entity_t4_ore_washer", TileEntityT4OreWasher::new, ModBlocks.T4_ORE_WASHER);
    
    public static final RegistryObject<TileEntityType<TileEntityT4SlurryProcessor>> TILE_ENTITY_T4_SLURRY_PROCESSOR = register(
            "tile_entity_t4_slurry_processor", TileEntityT4SlurryProcessor::new, ModBlocks.T4_SLURRY_PROCESSOR);
    
    //T5
    public static final RegistryObject<TileEntityType<TileEntityLineMiner>> TILE_ENTITY_LINE_MINER = register(
            "tile_entity_line_miner", TileEntityLineMiner::new, ModBlocks.LINE_MINER);
    
    public static final RegistryObject<TileEntityType<TileEntityMiningChute>> TILE_ENTITY_MINING_CHUTE = register(
            "tile_entity_mining_chute", TileEntityMiningChute::new, ModBlocks.MINING_CHUTE);
    
    public static final RegistryObject<TileEntityType<TileEntityT5EnergyCube>> TILE_ENTITY_T5_ENERGY_CUBE = register(
            "tile_entity_t5_energy_cube", TileEntityT5EnergyCube::new, ModBlocks.T5_ENERGY_CUBE);
    
    public static final RegistryObject<TileEntityType<TileEntityT5Crusher>> TILE_ENTITY_T5_CRUSHER = register(
            "tile_entity_t5_crusher", TileEntityT5Crusher::new, ModBlocks.T5_CRUSHER);
    
    public static final RegistryObject<TileEntityType<TileEntityT5Press>> TILE_ENTITY_T5_PRESS = register(
            "tile_entity_t5_press", TileEntityT5Press::new, ModBlocks.T5_PRESS);
    
    public static final RegistryObject<TileEntityType<TileEntityT5MetallicInfuser>> TILE_ENTITY_T5_METALLIC_INFUSER = register(
            "tile_entity_t5_metallic_infuser", TileEntityT5MetallicInfuser::new, ModBlocks.T5_METALLIC_INFUSER);
    
    public static final RegistryObject<TileEntityType<TileEntityT5PoweredSieve>> TILE_ENTITY_T5_POWERED_SIEVE = register(
            "tile_entity_t5_powered_sieve", TileEntityT5PoweredSieve::new, ModBlocks.T5_POWERED_SIEVE);
    
    public static final RegistryObject<TileEntityType<TileEntityT5OreWasher>> TILE_ENTITY_T5_ORE_WASHER = register(
            "tile_entity_t5_ore_washer", TileEntityT5OreWasher::new, ModBlocks.T5_ORE_WASHER);
    
    public static final RegistryObject<TileEntityType<TileEntityT5SlurryProcessor>> TILE_ENTITY_T5_SLURRY_PROCESSOR = register(
            "tile_entity_t5_slurry_processor", TileEntityT5SlurryProcessor::new, ModBlocks.T5_SLURRY_PROCESSOR);
    
    //T6
    public static final RegistryObject<TileEntityType<TileEntityT6EnergyCube>> TILE_ENTITY_T6_ENERGY_CUBE = register(
            "tile_entity_t6_energy_cube", TileEntityT6EnergyCube::new, ModBlocks.T6_ENERGY_CUBE);
    
    public static final RegistryObject<TileEntityType<TileEntityT6Crusher>> TILE_ENTITY_T6_CRUSHER = register(
            "tile_entity_t6_crusher", TileEntityT6Crusher::new, ModBlocks.T6_CRUSHER);
    
    public static final RegistryObject<TileEntityType<TileEntityT6Press>> TILE_ENTITY_T6_PRESS = register(
            "tile_entity_t6_press", TileEntityT6Press::new, ModBlocks.T6_PRESS);
    
    public static final RegistryObject<TileEntityType<TileEntityT6MetallicInfuser>> TILE_ENTITY_T6_METALLIC_INFUSER = register(
            "tile_entity_t6_metallic_infuser", TileEntityT6MetallicInfuser::new, ModBlocks.T6_METALLIC_INFUSER);
    
    public static final RegistryObject<TileEntityType<TileEntityT6PoweredSieve>> TILE_ENTITY_T6_POWERED_SIEVE = register(
            "tile_entity_t6_powered_sieve", TileEntityT6PoweredSieve::new, ModBlocks.T6_POWERED_SIEVE);
    
    public static final RegistryObject<TileEntityType<TileEntityT6OreWasher>> TILE_ENTITY_T6_ORE_WASHER = register(
            "tile_entity_t6_ore_washer", TileEntityT6OreWasher::new, ModBlocks.T6_ORE_WASHER);
    
    public static final RegistryObject<TileEntityType<TileEntityT6SlurryProcessor>> TILE_ENTITY_T6_SLURRY_PROCESSOR = register(
            "tile_entity_t6_slurry_processor", TileEntityT6SlurryProcessor::new, ModBlocks.T6_SLURRY_PROCESSOR);
    
    static void register() {}

    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> register(String name, Supplier<T> factory, RegistryObject<? extends Block> block) {
        return RegistryHandler.TILE_ENTITIES.register(name, () -> {
            //noinspection ConstantConditions - null in build
            return TileEntityType.Builder.of(factory, block.get()).build(null);
        });
    }
}

/*import net.minecraftforge.fml.common.registry.GameRegistry;
import com.github.will11690.mechanicraft.blocks.chute.energychute.tier1.TileEntityT1EnergyChute;
import com.github.will11690.mechanicraft.blocks.chute.fluidchute.tier1.TileEntityT1FluidChute;
import com.github.will11690.mechanicraft.blocks.chute.itemchute.tier1.TileEntityT1ItemChute;
import com.github.will11690.mechanicraft.blocks.fluidtank.basicfluidtank.TileEntityBasicFluidTank;
import com.github.will11690.mechanicraft.blocks.machines.adv.advcgen.TileEntityAdvancedCoalGenerator;
import com.github.will11690.mechanicraft.blocks.machines.adv.advfurnace.TileEntityAdvancedFurnace;
import com.github.will11690.mechanicraft.blocks.machines.basic.basiccgen.TileEntityBasicCoalGenerator;
import com.github.will11690.mechanicraft.blocks.machines.basic.basicfurnace.TileEntityBasicFurnace;
import com.github.will11690.mechanicraft.blocks.machines.basic.basicinfuser.TileEntityBasicMetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1crusher.TileEntityT1Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1energycube.TileEntityT1EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1gearpress.TileEntityT1GearPress;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1infuser.TileEntityT1ElectricMetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1orewasher.TileEntityT1OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1poweredsieve.TileEntityT1PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1slurryprocessor.TileEntityT1SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2crusher.TileEntityT2Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2energycube.TileEntityT2EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2gearpress.TileEntityT2GearPress;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2infuser.TileEntityT2ElectricMetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2orewasher.TileEntityT2OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2poweredsieve.TileEntityT2PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2slurryprocessor.TileEntityT2SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3crusher.TileEntityT3Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3energycube.TileEntityT3EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3gearpress.TileEntityT3GearPress;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3infuser.TileEntityT3ElectricMetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3orewasher.TileEntityT3OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3poweredsieve.TileEntityT3PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3slurryprocessor.TileEntityT3SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4crusher.TileEntityT4Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4energycube.TileEntityT4EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4gearpress.TileEntityT4GearPress;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4infuser.TileEntityT4ElectricMetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4orewasher.TileEntityT4OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4poweredsieve.TileEntityT4PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4slurryprocessor.TileEntityT4SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier5.lineminer.TileEntityLineMiner;
import com.github.will11690.mechanicraft.blocks.machines.tier5.lineminer.miningchute.TileEntityMiningChute;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5crusher.TileEntityT5Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5energycube.TileEntityT5EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5gearpress.TileEntityT5GearPress;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5infuser.TileEntityT5ElectricMetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5orewasher.TileEntityT5OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5poweredsieve.TileEntityT5PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5slurryprocessor.TileEntityT5SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6crusher.TileEntityT6Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6energycube.TileEntityT6EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6gearpress.TileEntityT6GearPress;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6infuser.TileEntityT6ElectricMetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6orewasher.TileEntityT6OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6poweredsieve.TileEntityT6PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6slurryprocessor.TileEntityT6SlurryProcessor;
import com.github.will11690.mechanicraft.util.Reference;

public class TileEntityHandler {
	
	public static void registerTileEntities() {
		
		//BASIC
		GameRegistry.registerTileEntity(TileEntityBasicMetallicInfuser.class, (Reference.MOD_ID + ":basic_metallic_infuser"));
		GameRegistry.registerTileEntity(TileEntityBasicCoalGenerator.class, (Reference.MOD_ID + ":basic_coal_generator"));
		GameRegistry.registerTileEntity(TileEntityBasicFurnace.class, (Reference.MOD_ID + ":basic_furnace"));
		
		//ADVANCED
		GameRegistry.registerTileEntity(TileEntityAdvancedCoalGenerator.class, (Reference.MOD_ID + ":adv_coal_generator"));
		GameRegistry.registerTileEntity(TileEntityAdvancedFurnace.class, (Reference.MOD_ID + ":adv_furnace"));
		
		//TIER 1
		GameRegistry.registerTileEntity(TileEntityT1ElectricMetallicInfuser.class, (Reference.MOD_ID + ":t1electric_metallic_infuser"));
		GameRegistry.registerTileEntity(TileEntityT1EnergyCube.class, (Reference.MOD_ID + ":t1energy_cube"));
		GameRegistry.registerTileEntity(TileEntityT1Crusher.class, (Reference.MOD_ID + ":t1crusher"));
		GameRegistry.registerTileEntity(TileEntityT1GearPress.class, (Reference.MOD_ID + ":t1gear_press"));
		GameRegistry.registerTileEntity(TileEntityT1OreWasher.class, (Reference.MOD_ID + ":t1ore_washer"));
		GameRegistry.registerTileEntity(TileEntityT1PoweredSieve.class, (Reference.MOD_ID + ":t1powered_sieve"));
		GameRegistry.registerTileEntity(TileEntityT1SlurryProcessor.class, (Reference.MOD_ID + ":t1slurry_processor"));
		
		GameRegistry.registerTileEntity(TileEntityT1EnergyChute.class, (Reference.MOD_ID + ":t1energy_chute"));
		GameRegistry.registerTileEntity(TileEntityT1FluidChute.class, (Reference.MOD_ID + ":t1fluid_chute"));
		GameRegistry.registerTileEntity(TileEntityT1ItemChute.class, (Reference.MOD_ID + ":t1item_chute"));
		GameRegistry.registerTileEntity(TileEntityBasicFluidTank.class, (Reference.MOD_ID + ":basic_fluid_tank"));
		
		//TIER 2
		GameRegistry.registerTileEntity(TileEntityT2ElectricMetallicInfuser.class, (Reference.MOD_ID + ":t2electric_metallic_infuser"));
		GameRegistry.registerTileEntity(TileEntityT2EnergyCube.class, (Reference.MOD_ID + ":t2energy_cube"));
		GameRegistry.registerTileEntity(TileEntityT2Crusher.class, (Reference.MOD_ID + ":t2crusher"));
		GameRegistry.registerTileEntity(TileEntityT2GearPress.class, (Reference.MOD_ID + ":t2gear_press"));
		GameRegistry.registerTileEntity(TileEntityT2OreWasher.class, (Reference.MOD_ID + ":t2ore_washer"));
		GameRegistry.registerTileEntity(TileEntityT2PoweredSieve.class, (Reference.MOD_ID + ":t2powered_sieve"));
		GameRegistry.registerTileEntity(TileEntityT2SlurryProcessor.class, (Reference.MOD_ID + ":t21slurry_processor"));
		
		//TIER 3
		GameRegistry.registerTileEntity(TileEntityT3ElectricMetallicInfuser.class, (Reference.MOD_ID + ":t3electric_metallic_infuser"));
		GameRegistry.registerTileEntity(TileEntityT3EnergyCube.class, (Reference.MOD_ID + ":t3energy_cube"));
		GameRegistry.registerTileEntity(TileEntityT3Crusher.class, (Reference.MOD_ID + ":t3crusher"));
		GameRegistry.registerTileEntity(TileEntityT3GearPress.class, (Reference.MOD_ID + ":t3gear_press"));
		GameRegistry.registerTileEntity(TileEntityT3OreWasher.class, (Reference.MOD_ID + ":t3ore_washer"));
		GameRegistry.registerTileEntity(TileEntityT3PoweredSieve.class, (Reference.MOD_ID + ":t3powered_sieve"));
		GameRegistry.registerTileEntity(TileEntityT3SlurryProcessor.class, (Reference.MOD_ID + ":t3slurry_processor"));
		
		//TIER 4
		GameRegistry.registerTileEntity(TileEntityT4ElectricMetallicInfuser.class, (Reference.MOD_ID + ":t4electric_metallic_infuser"));
		GameRegistry.registerTileEntity(TileEntityT4EnergyCube.class, (Reference.MOD_ID + ":t4energy_cube"));
		GameRegistry.registerTileEntity(TileEntityT4Crusher.class, (Reference.MOD_ID + ":t4crusher"));
		GameRegistry.registerTileEntity(TileEntityT4GearPress.class, (Reference.MOD_ID + ":t4gear_press"));
		GameRegistry.registerTileEntity(TileEntityT4OreWasher.class, (Reference.MOD_ID + ":t4ore_washer"));
		GameRegistry.registerTileEntity(TileEntityT4PoweredSieve.class, (Reference.MOD_ID + ":t4powered_sieve"));
		GameRegistry.registerTileEntity(TileEntityT4SlurryProcessor.class, (Reference.MOD_ID + ":t4slurry_processor"));
		
		//TIER 5
		GameRegistry.registerTileEntity(TileEntityT5ElectricMetallicInfuser.class, (Reference.MOD_ID + ":t5electric_metallic_infuser"));
		GameRegistry.registerTileEntity(TileEntityT5EnergyCube.class, (Reference.MOD_ID + ":t5energy_cube"));
		GameRegistry.registerTileEntity(TileEntityT5Crusher.class, (Reference.MOD_ID + ":t5crusher"));
		GameRegistry.registerTileEntity(TileEntityT5GearPress.class, (Reference.MOD_ID + ":t5gear_press"));
		GameRegistry.registerTileEntity(TileEntityT5OreWasher.class, (Reference.MOD_ID + ":t5ore_washer"));
		GameRegistry.registerTileEntity(TileEntityT5PoweredSieve.class, (Reference.MOD_ID + ":t5powered_sieve"));
		GameRegistry.registerTileEntity(TileEntityT5SlurryProcessor.class, (Reference.MOD_ID + ":t5slurry_processor"));
		
		//Miner
		GameRegistry.registerTileEntity(TileEntityLineMiner.class, (Reference.MOD_ID + ":line_miner"));
		GameRegistry.registerTileEntity(TileEntityMiningChute.class, (Reference.MOD_ID + ":mining_chute"));
		
		//TIER 6
		GameRegistry.registerTileEntity(TileEntityT6ElectricMetallicInfuser.class, (Reference.MOD_ID + ":t6electric_metallic_infuser"));
		GameRegistry.registerTileEntity(TileEntityT6EnergyCube.class, (Reference.MOD_ID + ":t6energy_cube"));
		GameRegistry.registerTileEntity(TileEntityT6Crusher.class, (Reference.MOD_ID + ":t6crusher"));
		GameRegistry.registerTileEntity(TileEntityT6GearPress.class, (Reference.MOD_ID + ":t6gear_press"));
		GameRegistry.registerTileEntity(TileEntityT6OreWasher.class, (Reference.MOD_ID + ":t6ore_washer"));
		GameRegistry.registerTileEntity(TileEntityT6PoweredSieve.class, (Reference.MOD_ID + ":t6powered_sieve"));
		GameRegistry.registerTileEntity(TileEntityT6SlurryProcessor.class, (Reference.MOD_ID + ":t6slurry_processor"));
		
		//Void Miner
		
		
	}
	
}*/