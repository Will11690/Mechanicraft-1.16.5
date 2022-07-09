package com.github.will11690.mechanicraft.util.handlers;

import com.github.will11690.mechanicraft.blocks.machines.adv.advcgen.ContainerAdvancedCoalGenerator;
import com.github.will11690.mechanicraft.blocks.machines.adv.advcgen.ScreenAdvancedCoalGenerator;
import com.github.will11690.mechanicraft.blocks.machines.adv.advfurnace.ContainerAdvancedFurnace;
import com.github.will11690.mechanicraft.blocks.machines.adv.advfurnace.ScreenAdvancedFurnace;
import com.github.will11690.mechanicraft.blocks.machines.basic.basiccgen.ContainerBasicCoalGenerator;
import com.github.will11690.mechanicraft.blocks.machines.basic.basiccgen.ScreenBasicCoalGenerator;
import com.github.will11690.mechanicraft.blocks.machines.basic.basicfurnace.ContainerBasicFurnace;
import com.github.will11690.mechanicraft.blocks.machines.basic.basicfurnace.ScreenBasicFurnace;
import com.github.will11690.mechanicraft.blocks.machines.basic.basicinfuser.ContainerBasicMetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.basic.basicinfuser.ScreenBasicMetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1crusher.ContainerT1Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1crusher.ScreenT1Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1energycube.ContainerT1EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1energycube.ScreenT1EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1infuser.ContainerT1MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1infuser.ScreenT1MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1orewasher.ContainerT1OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1orewasher.ScreenT1OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1poweredsieve.ContainerT1PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1poweredsieve.ScreenT1PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1press.ContainerT1Press;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1press.ScreenT1Press;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1slurryprocessor.ContainerT1SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1slurryprocessor.ScreenT1SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2crusher.ContainerT2Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2crusher.ScreenT2Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2energycube.ContainerT2EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2energycube.ScreenT2EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2infuser.ContainerT2MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2infuser.ScreenT2MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2orewasher.ContainerT2OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2orewasher.ScreenT2OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2poweredsieve.ContainerT2PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2poweredsieve.ScreenT2PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2press.ContainerT2Press;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2press.ScreenT2Press;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2slurryprocessor.ContainerT2SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2slurryprocessor.ScreenT2SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3crusher.ContainerT3Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3crusher.ScreenT3Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3energycube.ContainerT3EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3energycube.ScreenT3EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3infuser.ContainerT3MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3infuser.ScreenT3MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3orewasher.ContainerT3OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3orewasher.ScreenT3OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3poweredsieve.ContainerT3PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3poweredsieve.ScreenT3PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3press.ContainerT3Press;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3press.ScreenT3Press;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3slurryprocessor.ContainerT3SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3slurryprocessor.ScreenT3SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4crusher.ContainerT4Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4crusher.ScreenT4Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4energycube.ContainerT4EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4energycube.ScreenT4EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4infuser.ContainerT4MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4infuser.ScreenT4MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4orewasher.ContainerT4OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4orewasher.ScreenT4OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4poweredsieve.ContainerT4PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4poweredsieve.ScreenT4PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4press.ContainerT4Press;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4press.ScreenT4Press;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4slurryprocessor.ContainerT4SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4slurryprocessor.ScreenT4SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5crusher.ContainerT5Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5crusher.ScreenT5Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5energycube.ContainerT5EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5energycube.ScreenT5EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5infuser.ContainerT5MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5infuser.ScreenT5MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5orewasher.ContainerT5OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5orewasher.ScreenT5OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5poweredsieve.ContainerT5PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5poweredsieve.ScreenT5PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5press.ContainerT5Press;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5press.ScreenT5Press;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5slurryprocessor.ContainerT5SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5slurryprocessor.ScreenT5SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6crusher.ContainerT6Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6crusher.ScreenT6Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6energycube.ContainerT6EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6energycube.ScreenT6EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6infuser.ContainerT6MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6infuser.ScreenT6MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6orewasher.ContainerT6OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6orewasher.ScreenT6OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6poweredsieve.ContainerT6PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6poweredsieve.ScreenT6PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6press.ContainerT6Press;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6press.ScreenT6Press;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6slurryprocessor.ContainerT6SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6slurryprocessor.ScreenT6SlurryProcessor;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.network.IContainerFactory;

public final class ContainerTypeHandler {
	
	//BASIC
    public static final RegistryObject<ContainerType<ContainerBasicMetallicInfuser>> CONTAINER_BASIC_METALLIC_INFUSER = register("container_basic_metallic_infuser", ContainerBasicMetallicInfuser::new);
    public static final RegistryObject<ContainerType<ContainerBasicCoalGenerator>> CONTAINER_BASIC_COAL_GENERATOR = register("container_basic_coal_generator", ContainerBasicCoalGenerator::new);
    public static final RegistryObject<ContainerType<ContainerBasicFurnace>> CONTAINER_BASIC_FURNACE = register("container_basic_furnace", ContainerBasicFurnace::new);
    
    //ADVANCED
    public static final RegistryObject<ContainerType<ContainerAdvancedCoalGenerator>> CONTAINER_ADVANCED_COAL_GENERATOR = register("container_advanced_coal_generator", ContainerAdvancedCoalGenerator::new);
    public static final RegistryObject<ContainerType<ContainerAdvancedFurnace>> CONTAINER_ADVANCED_FURNACE = register("container_advanced_furnace", ContainerAdvancedFurnace::new);
    
    //T1
    public static final RegistryObject<ContainerType<ContainerT1EnergyCube>> CONTAINER_T1_ENERGY_CUBE = register("container_t1_energy_cube", ContainerT1EnergyCube::new);
    public static final RegistryObject<ContainerType<ContainerT1Crusher>> CONTAINER_T1_CRUSHER = register("container_t1_crusher", ContainerT1Crusher::new);
    public static final RegistryObject<ContainerType<ContainerT1Press>> CONTAINER_T1_PRESS = register("container_t1_press", ContainerT1Press::new);
    public static final RegistryObject<ContainerType<ContainerT1MetallicInfuser>> CONTAINER_T1_METALLIC_INFUSER = register("container_t1_metallic_infuser", ContainerT1MetallicInfuser::new);
    public static final RegistryObject<ContainerType<ContainerT1PoweredSieve>> CONTAINER_T1_POWERED_SIEVE = register("container_t1_powered_sieve", ContainerT1PoweredSieve::new);
    public static final RegistryObject<ContainerType<ContainerT1OreWasher>> CONTAINER_T1_ORE_WASHER = register("container_t1_ore_washer", ContainerT1OreWasher::new);
    public static final RegistryObject<ContainerType<ContainerT1SlurryProcessor>> CONTAINER_T1_SLURRY_PROCESSOR = register("container_t1_slurry_processor", ContainerT1SlurryProcessor::new);
    
    //T2
    public static final RegistryObject<ContainerType<ContainerT2EnergyCube>> CONTAINER_T2_ENERGY_CUBE = register("container_t2_energy_cube", ContainerT2EnergyCube::new);
    public static final RegistryObject<ContainerType<ContainerT2Crusher>> CONTAINER_T2_CRUSHER = register("container_t2_crusher", ContainerT2Crusher::new);
    public static final RegistryObject<ContainerType<ContainerT2Press>> CONTAINER_T2_PRESS = register("container_t2_press", ContainerT2Press::new);
    public static final RegistryObject<ContainerType<ContainerT2MetallicInfuser>> CONTAINER_T2_METALLIC_INFUSER = register("container_t2_metallic_infuser", ContainerT2MetallicInfuser::new);
    public static final RegistryObject<ContainerType<ContainerT2PoweredSieve>> CONTAINER_T2_POWERED_SIEVE = register("container_t2_powered_sieve", ContainerT2PoweredSieve::new);
    public static final RegistryObject<ContainerType<ContainerT2OreWasher>> CONTAINER_T2_ORE_WASHER = register("container_t2_ore_washer", ContainerT2OreWasher::new);
    public static final RegistryObject<ContainerType<ContainerT2SlurryProcessor>> CONTAINER_T2_SLURRY_PROCESSOR = register("container_t2_slurry_processor", ContainerT2SlurryProcessor::new);
    
    //T3
    public static final RegistryObject<ContainerType<ContainerT3EnergyCube>> CONTAINER_T3_ENERGY_CUBE = register("container_t3_energy_cube", ContainerT3EnergyCube::new);
    public static final RegistryObject<ContainerType<ContainerT3Crusher>> CONTAINER_T3_CRUSHER = register("container_t3_crusher", ContainerT3Crusher::new);
    public static final RegistryObject<ContainerType<ContainerT3Press>> CONTAINER_T3_PRESS = register("container_t3_press", ContainerT3Press::new);
    public static final RegistryObject<ContainerType<ContainerT3MetallicInfuser>> CONTAINER_T3_METALLIC_INFUSER = register("container_t3_metallic_infuser", ContainerT3MetallicInfuser::new);
    public static final RegistryObject<ContainerType<ContainerT3PoweredSieve>> CONTAINER_T3_POWERED_SIEVE = register("container_t3_powered_sieve", ContainerT3PoweredSieve::new);
    public static final RegistryObject<ContainerType<ContainerT3OreWasher>> CONTAINER_T3_ORE_WASHER = register("container_t3_ore_washer", ContainerT3OreWasher::new);
    public static final RegistryObject<ContainerType<ContainerT3SlurryProcessor>> CONTAINER_T3_SLURRY_PROCESSOR = register("container_t3_slurry_processor", ContainerT3SlurryProcessor::new);
    
    //T4
    public static final RegistryObject<ContainerType<ContainerT4EnergyCube>> CONTAINER_T4_ENERGY_CUBE = register("container_t4_energy_cube", ContainerT4EnergyCube::new);
    public static final RegistryObject<ContainerType<ContainerT4Crusher>> CONTAINER_T4_CRUSHER = register("container_t4_crusher", ContainerT4Crusher::new);
    public static final RegistryObject<ContainerType<ContainerT4Press>> CONTAINER_T4_PRESS = register("container_t4_press", ContainerT4Press::new);
    public static final RegistryObject<ContainerType<ContainerT4MetallicInfuser>> CONTAINER_T4_METALLIC_INFUSER = register("container_t4_metallic_infuser", ContainerT4MetallicInfuser::new);
    public static final RegistryObject<ContainerType<ContainerT4PoweredSieve>> CONTAINER_T4_POWERED_SIEVE = register("container_t4_powered_sieve", ContainerT4PoweredSieve::new);
    public static final RegistryObject<ContainerType<ContainerT4OreWasher>> CONTAINER_T4_ORE_WASHER = register("container_t4_ore_washer", ContainerT4OreWasher::new);
    public static final RegistryObject<ContainerType<ContainerT4SlurryProcessor>> CONTAINER_T4_SLURRY_PROCESSOR = register("container_t4_slurry_processor", ContainerT4SlurryProcessor::new);
    
    //T5
    public static final RegistryObject<ContainerType<ContainerT5EnergyCube>> CONTAINER_T5_ENERGY_CUBE = register("container_t5_energy_cube", ContainerT5EnergyCube::new);
    public static final RegistryObject<ContainerType<ContainerT5Crusher>> CONTAINER_T5_CRUSHER = register("container_t5_crusher", ContainerT5Crusher::new);
    public static final RegistryObject<ContainerType<ContainerT5Press>> CONTAINER_T5_PRESS = register("container_t5_press", ContainerT5Press::new);
    public static final RegistryObject<ContainerType<ContainerT5MetallicInfuser>> CONTAINER_T5_METALLIC_INFUSER = register("container_t5_metallic_infuser", ContainerT5MetallicInfuser::new);
    public static final RegistryObject<ContainerType<ContainerT5PoweredSieve>> CONTAINER_T5_POWERED_SIEVE = register("container_t5_powered_sieve", ContainerT5PoweredSieve::new);
    public static final RegistryObject<ContainerType<ContainerT5OreWasher>> CONTAINER_T5_ORE_WASHER = register("container_t5_ore_washer", ContainerT5OreWasher::new);
    public static final RegistryObject<ContainerType<ContainerT5SlurryProcessor>> CONTAINER_T5_SLURRY_PROCESSOR = register("container_t5_slurry_processor", ContainerT5SlurryProcessor::new);
    
    //T6
    public static final RegistryObject<ContainerType<ContainerT6EnergyCube>> CONTAINER_T6_ENERGY_CUBE = register("container_t6_energy_cube", ContainerT6EnergyCube::new);
    public static final RegistryObject<ContainerType<ContainerT6Crusher>> CONTAINER_T6_CRUSHER = register("container_t6_crusher", ContainerT6Crusher::new);
    public static final RegistryObject<ContainerType<ContainerT6Press>> CONTAINER_T6_PRESS = register("container_t6_press", ContainerT6Press::new);
    public static final RegistryObject<ContainerType<ContainerT6MetallicInfuser>> CONTAINER_T6_METALLIC_INFUSER = register("container_t6_metallic_infuser", ContainerT6MetallicInfuser::new);
    public static final RegistryObject<ContainerType<ContainerT6PoweredSieve>> CONTAINER_T6_POWERED_SIEVE = register("container_t6_powered_sieve", ContainerT6PoweredSieve::new);
    public static final RegistryObject<ContainerType<ContainerT6OreWasher>> CONTAINER_T6_ORE_WASHER = register("container_t6_ore_washer", ContainerT6OreWasher::new);
    public static final RegistryObject<ContainerType<ContainerT6SlurryProcessor>> CONTAINER_T6_SLURRY_PROCESSOR = register("container_t6_slurry_processor", ContainerT6SlurryProcessor::new);
    
    private ContainerTypeHandler() {}

    static void register() {}

    @OnlyIn(Dist.CLIENT)
    public static void registerScreens(FMLClientSetupEvent event) {
    	
    	//BASIC
        ScreenManager.register(CONTAINER_BASIC_METALLIC_INFUSER.get(), ScreenBasicMetallicInfuser::new);
        ScreenManager.register(CONTAINER_BASIC_COAL_GENERATOR.get(), ScreenBasicCoalGenerator::new);
        ScreenManager.register(CONTAINER_BASIC_FURNACE.get(), ScreenBasicFurnace::new);
        
        //ADVANCED
        ScreenManager.register(CONTAINER_ADVANCED_COAL_GENERATOR.get(), ScreenAdvancedCoalGenerator::new);
        ScreenManager.register(CONTAINER_ADVANCED_FURNACE.get(), ScreenAdvancedFurnace::new);
        
        //T1
        ScreenManager.register(CONTAINER_T1_ENERGY_CUBE.get(), ScreenT1EnergyCube::new);
        ScreenManager.register(CONTAINER_T1_CRUSHER.get(), ScreenT1Crusher::new);
        ScreenManager.register(CONTAINER_T1_PRESS.get(), ScreenT1Press::new);
        ScreenManager.register(CONTAINER_T1_METALLIC_INFUSER.get(), ScreenT1MetallicInfuser::new);
        ScreenManager.register(CONTAINER_T1_POWERED_SIEVE.get(), ScreenT1PoweredSieve::new);
        ScreenManager.register(CONTAINER_T1_ORE_WASHER.get(), ScreenT1OreWasher::new);
        ScreenManager.register(CONTAINER_T1_SLURRY_PROCESSOR.get(), ScreenT1SlurryProcessor::new);
        
        //T2
        ScreenManager.register(CONTAINER_T2_ENERGY_CUBE.get(), ScreenT2EnergyCube::new);
        ScreenManager.register(CONTAINER_T2_CRUSHER.get(), ScreenT2Crusher::new);
        ScreenManager.register(CONTAINER_T2_PRESS.get(), ScreenT2Press::new);
        ScreenManager.register(CONTAINER_T2_METALLIC_INFUSER.get(), ScreenT2MetallicInfuser::new);
        ScreenManager.register(CONTAINER_T2_POWERED_SIEVE.get(), ScreenT2PoweredSieve::new);
        ScreenManager.register(CONTAINER_T2_ORE_WASHER.get(), ScreenT2OreWasher::new);
        ScreenManager.register(CONTAINER_T2_SLURRY_PROCESSOR.get(), ScreenT2SlurryProcessor::new);
        
        //T3
        ScreenManager.register(CONTAINER_T3_ENERGY_CUBE.get(), ScreenT3EnergyCube::new);
        ScreenManager.register(CONTAINER_T3_CRUSHER.get(), ScreenT3Crusher::new);
        ScreenManager.register(CONTAINER_T3_PRESS.get(), ScreenT3Press::new);
        ScreenManager.register(CONTAINER_T3_METALLIC_INFUSER.get(), ScreenT3MetallicInfuser::new);
        ScreenManager.register(CONTAINER_T3_POWERED_SIEVE.get(), ScreenT3PoweredSieve::new);
        ScreenManager.register(CONTAINER_T3_ORE_WASHER.get(), ScreenT3OreWasher::new);
        ScreenManager.register(CONTAINER_T3_SLURRY_PROCESSOR.get(), ScreenT3SlurryProcessor::new);
        
        //T4
        ScreenManager.register(CONTAINER_T4_ENERGY_CUBE.get(), ScreenT4EnergyCube::new);
        ScreenManager.register(CONTAINER_T4_CRUSHER.get(), ScreenT4Crusher::new);
        ScreenManager.register(CONTAINER_T4_PRESS.get(), ScreenT4Press::new);
        ScreenManager.register(CONTAINER_T4_METALLIC_INFUSER.get(), ScreenT4MetallicInfuser::new);
        ScreenManager.register(CONTAINER_T4_POWERED_SIEVE.get(), ScreenT4PoweredSieve::new);
        ScreenManager.register(CONTAINER_T4_ORE_WASHER.get(), ScreenT4OreWasher::new);
        ScreenManager.register(CONTAINER_T4_SLURRY_PROCESSOR.get(), ScreenT4SlurryProcessor::new);
        
        //T5
        ScreenManager.register(CONTAINER_T5_ENERGY_CUBE.get(), ScreenT5EnergyCube::new);
        ScreenManager.register(CONTAINER_T5_CRUSHER.get(), ScreenT5Crusher::new);
        ScreenManager.register(CONTAINER_T5_PRESS.get(), ScreenT5Press::new);
        ScreenManager.register(CONTAINER_T5_METALLIC_INFUSER.get(), ScreenT5MetallicInfuser::new);
        ScreenManager.register(CONTAINER_T5_POWERED_SIEVE.get(), ScreenT5PoweredSieve::new);
        ScreenManager.register(CONTAINER_T5_ORE_WASHER.get(), ScreenT5OreWasher::new);
        ScreenManager.register(CONTAINER_T5_SLURRY_PROCESSOR.get(), ScreenT5SlurryProcessor::new);
        
        //T6
        ScreenManager.register(CONTAINER_T6_ENERGY_CUBE.get(), ScreenT6EnergyCube::new);
        ScreenManager.register(CONTAINER_T6_CRUSHER.get(), ScreenT6Crusher::new);
        ScreenManager.register(CONTAINER_T6_PRESS.get(), ScreenT6Press::new);
        ScreenManager.register(CONTAINER_T6_METALLIC_INFUSER.get(), ScreenT6MetallicInfuser::new);
        ScreenManager.register(CONTAINER_T6_POWERED_SIEVE.get(), ScreenT6PoweredSieve::new);
        ScreenManager.register(CONTAINER_T6_ORE_WASHER.get(), ScreenT6OreWasher::new);
        ScreenManager.register(CONTAINER_T6_SLURRY_PROCESSOR.get(), ScreenT6SlurryProcessor::new);
        
    }

    private static <T extends Container> RegistryObject<ContainerType<T>> register(String name, IContainerFactory<T> factory) {
        return RegistryHandler.CONTAINERS.register(name, () -> IForgeContainerType.create(factory));
    }
}