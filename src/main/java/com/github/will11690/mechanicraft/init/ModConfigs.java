package com.github.will11690.mechanicraft.init;

import com.github.will11690.mechanicraft.util.Reference;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;

@EventBusSubscriber(modid = Reference.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModConfigs {
	
	public static final ForgeConfigSpec.Builder MECHANICRAFT_BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec MECHANICRAFT_SPEC;
	
	//Ore Gen
	public static boolean copperGenBool;
	public static boolean leadGenBool;
	public static boolean tinGenBool;
	public static boolean silverGenBool;
	public static boolean rubyGenHillsBool;
	public static boolean sapphireGenHillsBool;
	public static boolean rubyGenAllBool;
	public static boolean sapphireGenAllBool;
	public static boolean enderGenBool;
	
	//Machine Energy Config
	public static int t1CrusherCapacityInt;
	public static int t1CrusherReceiveInt;
	public static int t1EnergyCubeCapacityInt;
	public static int t1EnergyCubeTransferInt;
	public static int t1InfuserCapacityInt;
	public static int t1InfuserReceiveInt;
	public static int t1OreWasherEnergyCapacityInt;
	public static int t1OreWasherReceiveInt;
	public static int t1PoweredSieveCapacityInt;
	public static int t1PoweredSieveReceiveInt;
	public static int t1PressCapacityInt;
	public static int t1PressReceiveInt;
	public static int t1SlurryProcessorEnergyCapacityInt;
	public static int t1SlurryProcessorReceiveInt;
		
	public static int t2CrusherCapacityInt;
	public static int t2CrusherReceiveInt;
	public static int t2EnergyCubeCapacityInt;
	public static int t2EnergyCubeTransferInt;
	public static int t2InfuserCapacityInt;
	public static int t2InfuserReceiveInt;
	public static int t2OreWasherEnergyCapacityInt;
	public static int t2OreWasherReceiveInt;
	public static int t2PoweredSieveCapacityInt;
	public static int t2PoweredSieveReceiveInt;
	public static int t2PressCapacityInt;
	public static int t2PressReceiveInt;
	public static int t2SlurryProcessorEnergyCapacityInt;
	public static int t2SlurryProcessorReceiveInt;
		
	public static int t3CrusherCapacityInt;
	public static int t3CrusherReceiveInt;
	public static int t3EnergyCubeCapacityInt;
	public static int t3EnergyCubeTransferInt;
	public static int t3InfuserCapacityInt;
	public static int t3InfuserReceiveInt;
	public static int t3OreWasherEnergyCapacityInt;
	public static int t3OreWasherReceiveInt;
	public static int t3PoweredSieveCapacityInt;
	public static int t3PoweredSieveReceiveInt;
	public static int t3PressCapacityInt;
	public static int t3PressReceiveInt;
	public static int t3SlurryProcessorEnergyCapacityInt;
	public static int t3SlurryProcessorReceiveInt;
		
	public static int t4CrusherCapacityInt;
	public static int t4CrusherReceiveInt;
	public static int t4EnergyCubeCapacityInt;
	public static int t4EnergyCubeTransferInt;
	public static int t4InfuserCapacityInt;
	public static int t4InfuserReceiveInt;
	public static int t4OreWasherEnergyCapacityInt;
	public static int t4OreWasherReceiveInt;
	public static int t4PoweredSieveCapacityInt;
	public static int t4PoweredSieveReceiveInt;
	public static int t4PressCapacityInt;
	public static int t4PressReceiveInt;
	public static int t4SlurryProcessorEnergyCapacityInt;
	public static int t4SlurryProcessorReceiveInt;
		
	public static int t5CrusherCapacityInt;
	public static int t5CrusherReceiveInt;
	public static int t5EnergyCubeCapacityInt;
	public static int t5EnergyCubeTransferInt;
	public static int t5InfuserCapacityInt;
	public static int t5InfuserReceiveInt;
	public static int t5OreWasherEnergyCapacityInt;
	public static int t5OreWasherReceiveInt;
	public static int t5PoweredSieveCapacityInt;
	public static int t5PoweredSieveReceiveInt;
	public static int t5PressCapacityInt;
	public static int t5PressReceiveInt;
	public static int t5SlurryProcessorEnergyCapacityInt;
	public static int t5SlurryProcessorReceiveInt;
		
	public static int t6CrusherCapacityInt;
	public static int t6CrusherReceiveInt;
	public static int t6EnergyCubeCapacityInt;
	public static int t6EnergyCubeTransferInt;
	public static int t6InfuserCapacityInt;
	public static int t6InfuserReceiveInt;
	public static int t6OreWasherEnergyCapacityInt;
	public static int t6OreWasherReceiveInt;
	public static int t6PoweredSieveCapacityInt;
	public static int t6PoweredSieveReceiveInt;
	public static int t6PressCapacityInt;
	public static int t6PressReceiveInt;
	public static int t6SlurryProcessorEnergyCapacityInt;
	public static int t6SlurryProcessorReceiveInt;
		
	//Fluid Config
	public static int t1OreWasherTankCapacityInt;
	public static int t1SlurryProcessorTankCapacityInt;
	public static int t2OreWasherTankCapacityInt;
	public static int t2SlurryProcessorTankCapacityInt;
	public static int t3OreWasherTankCapacityInt;
	public static int t3SlurryProcessorTankCapacityInt;
	public static int t4OreWasherTankCapacityInt;
	public static int t4SlurryProcessorTankCapacityInt;
	public static int t5OreWasherTankCapacityInt;
	public static int t5SlurryProcessorTankCapacityInt;
	public static int t6OreWasherTankCapacityInt;
	public static int t6SlurryProcessorTankCapacityInt;
		
	public static int basicTankCapacityInt;
	public static int advancedTankCapacityInt;
	public static int eliteTankCapacityInt;
	public static int superiorTankCapacityInt;
	public static int supremeTankCapacityInt;
	public static int ultimateTankCapacityInt;
	
	//Ore Gen
	private static final boolean defaultCopperGen = true;
	private static final boolean defaultLeadGen = true;
	private static final boolean defaultTinGen = true;
	private static final boolean defaultSilverGen = true;
	private static final boolean defaultRubyGenHills = true;
	private static final boolean defaultSapphireGenHills = true;
	private static final boolean defaultRubyGenAll = false;
	private static final boolean defaultSapphireGenAll = false;
	private static final boolean defaultEnderGen = true;
	
	//Machine Energy Config
	private static final int defaultT1CrusherCapacity = 100000;
	private static final int defaultT1CrusherReceive = 1500;
	private static final int defaultT1EnergyCubeCapacity = 150000;
	private static final int defaultT1EnergyCubeTransfer = 1500;
	private static final int defaultT1InfuserCapacity = 100000;
	private static final int defaultT1InfuserReceive = 1500;
	private static final int defaultT1OreWasherEnergyCapacity = 100000;
	private static final int defaultT1OreWasherReceive = 1500;
	private static final int defaultT1PoweredSieveCapacity = 100000;
	private static final int defaultT1PoweredSieveReceive = 1500;
	private static final int defaultT1PressCapacity = 100000;
	private static final int defaultT1PressReceive = 1500;
	private static final int defaultT1SlurryProcessorEnergyCapacity = 100000;
	private static final int defaultT1SlurryProcessorReceive = 1500;
	
	private static final int defaultT2CrusherCapacity = 150000;
	private static final int defaultT2CrusherReceive = 2000;
	private static final int defaultT2EnergyCubeCapacity = 250000;
	private static final int defaultT2EnergyCubeTransfer = 2500;
	private static final int defaultT2InfuserCapacity = 150000;
	private static final int defaultT2InfuserReceive = 2000;
	private static final int defaultT2OreWasherEnergyCapacity = 150000;
	private static final int defaultT2OreWasherReceive = 2000;
	private static final int defaultT2PoweredSieveCapacity = 150000;
	private static final int defaultT2PoweredSieveReceive = 2000;
	private static final int defaultT2PressCapacity = 150000;
	private static final int defaultT2PressReceive = 2000;
	private static final int defaultT2SlurryProcessorEnergyCapacity = 150000;
	private static final int defaultT2SlurryProcessorReceive = 2000;
	
	private static final int defaultT3CrusherCapacity = 200000;
	private static final int defaultT3CrusherReceive = 2500;
	private static final int defaultT3EnergyCubeCapacity = 350000;
	private static final int defaultT3EnergyCubeTransfer = 3500;
	private static final int defaultT3InfuserCapacity = 200000;
	private static final int defaultT3InfuserReceive = 2500;
	private static final int defaultT3OreWasherEnergyCapacity = 200000;
	private static final int defaultT3OreWasherReceive = 2500;
	private static final int defaultT3PoweredSieveCapacity = 200000;
	private static final int defaultT3PoweredSieveReceive = 2500;
	private static final int defaultT3PressCapacity = 200000;
	private static final int defaultT3PressReceive = 2500;
	private static final int defaultT3SlurryProcessorEnergyCapacity = 200000;
	private static final int defaultT3SlurryProcessorReceive = 2500;
	
	private static final int defaultT4CrusherCapacity = 250000;
	private static final int defaultT4CrusherReceive = 3000;
	private static final int defaultT4EnergyCubeCapacity = 450000;
	private static final int defaultT4EnergyCubeTransfer = 4500;
	private static final int defaultT4InfuserCapacity = 250000;
	private static final int defaultT4InfuserReceive = 3000;
	private static final int defaultT4OreWasherEnergyCapacity = 250000;
	private static final int defaultT4OreWasherReceive = 3000;
	private static final int defaultT4PoweredSieveCapacity = 250000;
	private static final int defaultT4PoweredSieveReceive = 3000;
	private static final int defaultT4PressCapacity = 250000;
	private static final int defaultT4PressReceive = 3000;
	private static final int defaultT4SlurryProcessorEnergyCapacity = 250000;
	private static final int defaultT4SlurryProcessorReceive = 3000;
	
	private static final int defaultT5CrusherCapacity = 300000;
	private static final int defaultT5CrusherReceive = 3500;
	private static final int defaultT5EnergyCubeCapacity = 550000;
	private static final int defaultT5EnergyCubeTransfer = 5500;
	private static final int defaultT5InfuserCapacity = 300000;
	private static final int defaultT5InfuserReceive = 3500;
	private static final int defaultT5OreWasherEnergyCapacity = 300000;
	private static final int defaultT5OreWasherReceive = 3500;
	private static final int defaultT5PoweredSieveCapacity = 300000;
	private static final int defaultT5PoweredSieveReceive = 3500;
	private static final int defaultT5PressCapacity = 300000;
	private static final int defaultT5PressReceive = 3500;
	private static final int defaultT5SlurryProcessorEnergyCapacity = 300000;
	private static final int defaultT5SlurryProcessorReceive = 3500;
	
	private static final int defaultT6CrusherCapacity = 350000;
	private static final int defaultT6CrusherReceive = 4000;
	private static final int defaultT6EnergyCubeCapacity = 650000;
	private static final int defaultT6EnergyCubeTransfer = 6500;
	private static final int defaultT6InfuserCapacity = 350000;
	private static final int defaultT6InfuserReceive = 4000;
	private static final int defaultT6OreWasherEnergyCapacity = 350000;
	private static final int defaultT6OreWasherReceive = 4000;
	private static final int defaultT6PoweredSieveCapacity = 350000;
	private static final int defaultT6PoweredSieveReceive = 4000;
	private static final int defaultT6PressCapacity = 350000;
	private static final int defaultT6PressReceive = 4000;
	private static final int defaultT6SlurryProcessorEnergyCapacity = 350000;
	private static final int defaultT6SlurryProcessorReceive = 4000;
	
	//Fluid Config
	private static final int defaultT1OreWasherTankCapacity = 16000;
	private static final int defaultT1SlurryProcessorTankCapacity = 16000;
	private static final int defaultT2OreWasherTankCapacity = 32000;
	private static final int defaultT2SlurryProcessorTankCapacity = 32000;
	private static final int defaultT3OreWasherTankCapacity = 64000;
	private static final int defaultT3SlurryProcessorTankCapacity = 64000;
	private static final int defaultT4OreWasherTankCapacity = 128000;
	private static final int defaultT4SlurryProcessorTankCapacity = 128000;
	private static final int defaultT5OreWasherTankCapacity = 256000;
	private static final int defaultT5SlurryProcessorTankCapacity = 256000;
	private static final int defaultT6OreWasherTankCapacity = 512000;
	private static final int defaultT6SlurryProcessorTankCapacity = 512000;
	
	private static final int defaultBasicTankCapacity = 16000;
	private static final int defaultAdvancedTankCapacity = 32000;
	private static final int defaultEliteTankCapacity = 64000;
	private static final int defaultSuperiorTankCapacity = 128000;
	private static final int defaultSupremeTankCapacity = 256000;
	private static final int defaultUltimateTankCapacity = 512000;

	//Ore Gen
	public static final ForgeConfigSpec.ConfigValue<Boolean> copperGen;
	public static final ForgeConfigSpec.ConfigValue<Boolean> leadGen;
	public static final ForgeConfigSpec.ConfigValue<Boolean> tinGen;
	public static final ForgeConfigSpec.ConfigValue<Boolean> silverGen;
	public static final ForgeConfigSpec.ConfigValue<Boolean> rubyGenHills;
	public static final ForgeConfigSpec.ConfigValue<Boolean> sapphireGenHills;
	public static final ForgeConfigSpec.ConfigValue<Boolean> rubyGenAll;
	public static final ForgeConfigSpec.ConfigValue<Boolean> sapphireGenAll;
	public static final ForgeConfigSpec.ConfigValue<Boolean> enderGen;
	
	//Machine Config Energy
	public static final ForgeConfigSpec.ConfigValue<Integer> t1CrusherCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1CrusherReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1EnergyCubeCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1EnergyCubeTransfer;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1InfuserCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1InfuserReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1OreWasherEnergyCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1OreWasherReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1PoweredSieveCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1PoweredSieveReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1PressCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1PressReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1SlurryProcessorEnergyCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1SlurryProcessorReceive;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> t2CrusherCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2CrusherReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2EnergyCubeCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2EnergyCubeTransfer;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2InfuserCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2InfuserReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2OreWasherEnergyCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2OreWasherReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2PoweredSieveCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2PoweredSieveReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2PressCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2PressReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2SlurryProcessorEnergyCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2SlurryProcessorReceive;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> t3CrusherCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3CrusherReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3EnergyCubeCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3EnergyCubeTransfer;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3InfuserCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3InfuserReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3OreWasherEnergyCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3OreWasherReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3PoweredSieveCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3PoweredSieveReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3PressCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3PressReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3SlurryProcessorEnergyCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3SlurryProcessorReceive;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> t4CrusherCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4CrusherReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4EnergyCubeCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4EnergyCubeTransfer;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4InfuserCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4InfuserReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4OreWasherEnergyCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4OreWasherReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4PoweredSieveCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4PoweredSieveReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4PressCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4PressReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4SlurryProcessorEnergyCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4SlurryProcessorReceive;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> t5CrusherCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5CrusherReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5EnergyCubeCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5EnergyCubeTransfer;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5InfuserCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5InfuserReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5OreWasherEnergyCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5OreWasherReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5PoweredSieveCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5PoweredSieveReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5PressCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5PressReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5SlurryProcessorEnergyCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5SlurryProcessorReceive;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> t6CrusherCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6CrusherReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6EnergyCubeCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6EnergyCubeTransfer;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6InfuserCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6InfuserReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6OreWasherEnergyCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6OreWasherReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6PoweredSieveCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6PoweredSieveReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6PressCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6PressReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6SlurryProcessorEnergyCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6SlurryProcessorReceive;
	
	//Fluid Config
	public static final ForgeConfigSpec.ConfigValue<Integer> t1OreWasherTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1SlurryProcessorTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2OreWasherTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2SlurryProcessorTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3OreWasherTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3SlurryProcessorTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4OreWasherTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4SlurryProcessorTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5OreWasherTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5SlurryProcessorTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6OreWasherTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6SlurryProcessorTankCapacity;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> basicTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> advancedTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> eliteTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> superiorTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> supremeTankCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> ultimateTankCapacity;

	static {
		
		MECHANICRAFT_BUILDER.push("OVERWORLD GENERATION").comment("Overworld Ores");
		//TODO add control over vein size, amounts per chunk, and spawn heights
		
		copperGen = MECHANICRAFT_BUILDER.comment("Copper Ore Generation, true is enabled, false is disabled(DEFAULT: true)")
				.worldRestart().define("Copper Ore Generation enabled: ", defaultCopperGen);
		
		leadGen = MECHANICRAFT_BUILDER.comment("Lead Ore Generation, true is enabled, false is disabled(DEFAULT: true)")
				.worldRestart().define("Lead Ore Generation enabled: ", defaultLeadGen);
		
		tinGen = MECHANICRAFT_BUILDER.comment("Tin Ore Generation, true is enabled, false is disabled(DEFAULT: true)")
				.worldRestart().define("Tin Ore Generation enabled: ", defaultTinGen);
		
		silverGen = MECHANICRAFT_BUILDER.comment("Silver Ore Generation, true is enabled, false is disabled(DEFAULT: true)")
				.worldRestart().define("Silver Ore Generation enabled: ", defaultSilverGen);
		
		rubyGenHills = MECHANICRAFT_BUILDER.comment("Ruby Ore Generation(Hills Biomes), true is enabled, false is disabled(DEFAULT: true)")
									.comment("If all biomes is true All needs to be set to false")
									.worldRestart().define("Ruby Ore Generation enabled: ", defaultRubyGenHills);
		
		sapphireGenHills = MECHANICRAFT_BUILDER.comment("Sapphire Ore Generation(Hills Biomes), true is enabled, false is disabled(DEFAULT: true)")
				 						.comment("If all biomes is true All needs to be set to false")
				 						.worldRestart().define("Sapphire Ore Generation enabled: ", defaultSapphireGenHills);
		
		rubyGenAll = MECHANICRAFT_BUILDER.comment("Ruby Ore Generation(All Biomes), true is enabled, false is disabled(DEFAULT: false)")
								 .comment("If all biomes is true Hills needs to be set to false")
								 .worldRestart().define("Ruby Ore Generation enabled: ", defaultRubyGenAll);
		
		sapphireGenAll = MECHANICRAFT_BUILDER.comment("Sapphire Ore Generation(All Biomes), true is enabled, false is disabled(DEFAULT: false)")
				 					 .comment("If all biomes is true Hills needs to be set to false")
				 					.worldRestart().define("Sapphire Ore Generation enabled: ", defaultSapphireGenAll);
		
		MECHANICRAFT_BUILDER.pop();
		MECHANICRAFT_BUILDER.push("END GENERATION").comment("End Ores");
		
		enderGen = MECHANICRAFT_BUILDER.comment("Ender Ore Generation, true is enabled, false is disabled(DEFAULT: false)")
				.worldRestart().define("Ender Ore Generation enabled: ", defaultEnderGen);
		
		MECHANICRAFT_BUILDER.pop();
		
		//MECHANICRAFT_BUILDER.push("BASIC MACHINE SETTINGS").comment("Basic Tier Machines");
		//TODO
		//MECHANICRAFT_BUILDER.pop();
		
		//MECHANICRAFT_BUILDER.push("ADVACNED MACHINE SETTINGS").comment("Advanced Tier Machines");
		//TODO
		//MECHANICRAFT_BUILDER.pop();
		MECHANICRAFT_BUILDER.push("TIER 1 MACHINE SETTINGS").comment("Machine Energy Settings");
		
		t1CrusherCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Crusher Capacity, minimum is 50000, maximum is 200000(DEFAULT: 100000)")
				.worldRestart().defineInRange("Tier 1 Crusher Capacity: ", defaultT1CrusherCapacity, 50000, 200000);
		
		t1CrusherReceive = MECHANICRAFT_BUILDER.comment("Tier 1 Crusher Energy Receive, minimum is 750, maximum is 3000(DEFAULT: 1500)")
				.worldRestart().defineInRange("Tier 1 Crusher Energy Receive: ", defaultT1CrusherReceive, 750, 3000);
		
		t1EnergyCubeCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Energy Cube Capacity, minimum is 50000, maximum is 300000(DEFAULT: 150000)")
				.worldRestart().defineInRange("Tier 1 Energy Cube Capacity: ", defaultT1EnergyCubeCapacity, 50000, 300000);
		
		t1EnergyCubeTransfer = MECHANICRAFT_BUILDER.comment("Tier 1 Energy Cube Energy Transfer, minimum is 750, maximum is 3000(DEFAULT: 1500)")
				.worldRestart().defineInRange("Tier 1 Energy Cube Transfer: ", defaultT1EnergyCubeTransfer, 750, 3000);
		
		t1InfuserCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Metallic Infuser Capacity, minimum is 50000, maximum is 200000(DEFAULT: 100000)")
				.worldRestart().defineInRange("Tier 1 Metallic Infuser Capacity: ", defaultT1InfuserCapacity, 50000, 200000);
		
		t1InfuserReceive = MECHANICRAFT_BUILDER.comment("Tier 1 Metallic Infuser Energy Receive, minimum is 750, maximum is 3000(DEFAULT: 1500)")
				.worldRestart().defineInRange("Tier 1 Metallic Infuser Energy Receive: ", defaultT1InfuserReceive, 750, 3000);
		
		t1OreWasherEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Ore Washer Energy Capacity, minimum is 50000, maximum is 200000(DEFAULT: 100000)")
				.worldRestart().defineInRange("Tier 1 Ore Washer Energy Capacity: ", defaultT1OreWasherEnergyCapacity, 50000, 200000);
		
		t1OreWasherReceive = MECHANICRAFT_BUILDER.comment("Tier 1 Ore Washer Energy Receive, minimum is 750, maximum is 3000(DEFAULT: 1500)")
				.worldRestart().defineInRange("Tier 1 Ore Washer Energy Receive: ", defaultT1OreWasherReceive, 750, 3000);
		
		t1PoweredSieveCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Powered Sieve Capacity, minimum is 50000, maximum is 200000(DEFAULT: 100000)")
				.worldRestart().defineInRange("Tier 1 Powered Sieve Capacity: ", defaultT1PoweredSieveCapacity, 50000, 200000);
		
		t1PoweredSieveReceive = MECHANICRAFT_BUILDER.comment("Tier 1 Powered Sieve Energy Receive, minimum is 750, maximum is 3000(DEFAULT: 1500)")
				.worldRestart().defineInRange("Tier 1 Powered Sieve Energy Receive: ", defaultT1PoweredSieveReceive, 750, 3000);
		
		t1PressCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Press Capacity, minimum is 50000, maximum is 200000(DEFAULT: 100000)")
				.worldRestart().defineInRange("Tier 1 Press Capacity: ", defaultT1PressCapacity, 50000, 200000);
		
		t1PressReceive = MECHANICRAFT_BUILDER.comment("Tier 1 Press Energy Receive, minimum is 750, maximum is 3000(DEFAULT: 1500)")
				.worldRestart().defineInRange("Tier 1 Press Energy Receive: ", defaultT1PressReceive, 750, 3000);
		
		t1SlurryProcessorEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Slurry Processor Energy Capacity, minimum is 50000, maximum is 200000(DEFAULT: 100000)")
				.worldRestart().defineInRange("Tier 1 Slurry Processor Energy Capacity: ", defaultT1SlurryProcessorEnergyCapacity, 50000, 200000);
		
		t1SlurryProcessorReceive = MECHANICRAFT_BUILDER.comment("Tier 1 Slurry Processor Energy Receive, minimum is 750, maximum is 3000(DEFAULT: 1500)")
				.worldRestart().defineInRange("Tier 1 Slurry Processor Energy Receive: ", defaultT1SlurryProcessorReceive, 750, 3000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 2 MACHINE SETTINGS").comment("Machine Energy Settings");
		
		t2CrusherCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Crusher Capacity, minimum is 75000, maximum is 300000(DEFAULT: 150000)")
				.worldRestart().defineInRange("Tier 2 Crusher Capacity: ", defaultT2CrusherCapacity, 75000, 300000);
		
		t2CrusherReceive = MECHANICRAFT_BUILDER.comment("Tier 2 Crusher Energy Receive, minimum is 1000, maximum is 4000(DEFAULT: 2000)")
				.worldRestart().defineInRange("Tier 2 Crusher Energy Receive: ", defaultT2CrusherReceive, 1000, 4000);
		
		t2EnergyCubeCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Energy Cube Capacity, minimum is 75000, maximum is 500000(DEFAULT: 250000)")
				.worldRestart().defineInRange("Tier 2 Energy Cube Capacity: ", defaultT2EnergyCubeCapacity, 75000, 500000);
		
		t2EnergyCubeTransfer = MECHANICRAFT_BUILDER.comment("Tier 2 Energy Cube Energy Transfer, minimum is 1000, maximum is 5000(DEFAULT: 2500)")
				.worldRestart().defineInRange("Tier 2 Energy Cube Transfer: ", defaultT2EnergyCubeTransfer, 1250, 5000);
		
		t2InfuserCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Metallic Infuser Capacity, minimum is 75000, maximum is 300000(DEFAULT: 150000)")
				.worldRestart().defineInRange("Tier 2 Metallic Infuser Capacity: ", defaultT2InfuserCapacity, 75000, 300000);
		
		t2InfuserReceive = MECHANICRAFT_BUILDER.comment("Tier 2 Metallic Infuser Energy Receive, minimum is 1000, maximum is 4000(DEFAULT: 2000)")
				.worldRestart().defineInRange("Tier 2 Metallic Infuser Energy Receive: ", defaultT2InfuserReceive, 1000, 4000);
		
		t2OreWasherEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Ore Washer Energy Capacity, minimum is 75000, maximum is 300000(DEFAULT: 150000)")
				.worldRestart().defineInRange("Tier 2 Ore Washer Energy Capacity: ", defaultT2OreWasherEnergyCapacity, 75000, 300000);
		
		t2OreWasherReceive = MECHANICRAFT_BUILDER.comment("Tier 2 Ore Washer Energy Receive, minimum is 1000, maximum is 4000(DEFAULT: 2000)")
				.worldRestart().defineInRange("Tier 2 Ore Washer Energy Receive: ", defaultT2OreWasherReceive, 1000, 4000);
		
		t2PoweredSieveCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Powered Sieve Capacity, minimum is 75000, maximum is 300000(DEFAULT: 150000)")
				.worldRestart().defineInRange("Tier 2 Powered Sieve Capacity: ", defaultT2PoweredSieveCapacity, 75000, 300000);
		
		t2PoweredSieveReceive = MECHANICRAFT_BUILDER.comment("Tier 2 Powered Sieve Energy Receive, minimum is 1000, maximum is 4000(DEFAULT: 2000)")
				.worldRestart().defineInRange("Tier 2 Powered Sieve Energy Receive: ", defaultT2PoweredSieveReceive, 1000, 4000);
		
		t2PressCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Press Capacity, minimum is 75000, maximum is 300000(DEFAULT: 150000)")
				.worldRestart().defineInRange("Tier 2 Press Capacity: ", defaultT2PressCapacity, 75000, 300000);
		
		t2PressReceive = MECHANICRAFT_BUILDER.comment("Tier 2 Press Energy Receive, minimum is 1000, maximum is 4000(DEFAULT: 2000)")
				.worldRestart().defineInRange("Tier 2 Press Energy Receive: ", defaultT2PressReceive, 1000, 4000);
		
		t2SlurryProcessorEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Slurry Processor Energy Capacity, minimum is 75000, maximum is 300000(DEFAULT: 150000)")
				.worldRestart().defineInRange("Tier 2 Slurry Processor Energy Capacity: ", defaultT2SlurryProcessorEnergyCapacity, 75000, 300000);
		
		t2SlurryProcessorReceive = MECHANICRAFT_BUILDER.comment("Tier 2 Slurry Processor Energy Receive, minimum is 1000, maximum is 4000(DEFAULT: 2000)")
				.worldRestart().defineInRange("Tier 2 Slurry Processor Energy Receive: ", defaultT2SlurryProcessorReceive, 1000, 4000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 3 MACHINE SETTINGS").comment("Machine Energy Settings");
		
		t3CrusherCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Crusher Capacity, minimum is 100000, maximum is 400000(DEFAULT: 200000)")
				.worldRestart().defineInRange("Tier 3 Crusher Capacity: ", defaultT3CrusherCapacity, 100000, 400000);
		
		t3CrusherReceive = MECHANICRAFT_BUILDER.comment("Tier 3 Crusher Energy Receive, minimum is 1250, maximum is 5000(DEFAULT: 2500)")
				.worldRestart().defineInRange("Tier 3 Crusher Energy Receive: ", defaultT3CrusherReceive, 1250, 5000);
		
		t3EnergyCubeCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Energy Cube Capacity, minimum is 100000, maximum is 700000(DEFAULT: 350000)")
				.worldRestart().defineInRange("Tier 3 Energy Cube Capacity: ", defaultT3EnergyCubeCapacity, 100000, 700000);
		
		t3EnergyCubeTransfer = MECHANICRAFT_BUILDER.comment("Tier 3 Energy Cube Energy Transfer, minimum is 1000, maximum is 6000(DEFAULT: 3500)")
				.worldRestart().defineInRange("Tier 3 Energy Cube Transfer: ", defaultT3EnergyCubeTransfer, 1750, 6000);
		
		t3InfuserCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Metallic Infuser Capacity, minimum is 100000, maximum is 400000(DEFAULT: 200000)")
				.worldRestart().defineInRange("Tier 3 Metallic Infuser Capacity: ", defaultT3InfuserCapacity, 100000, 400000);
		
		t3InfuserReceive = MECHANICRAFT_BUILDER.comment("Tier 3 Metallic Infuser Energy Receive, minimum is 1250, maximum is 5000(DEFAULT: 2500)")
				.worldRestart().defineInRange("Tier 3 Metallic Infuser Energy Receive: ", defaultT3InfuserReceive, 1250, 5000);
		
		t3OreWasherEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Ore Washer Energy Capacity, minimum is 100000, maximum is 400000(DEFAULT: 200000)")
				.worldRestart().defineInRange("Tier 3 Ore Washer Energy Capacity: ", defaultT3OreWasherEnergyCapacity, 100000, 400000);
		
		t3OreWasherReceive = MECHANICRAFT_BUILDER.comment("Tier 3 Ore Washer Energy Receive, minimum is 1250, maximum is 5000(DEFAULT: 2500)")
				.worldRestart().defineInRange("Tier 3 Ore Washer Energy Receive: ", defaultT3OreWasherReceive, 1250, 5000);
		
		t3PoweredSieveCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Powered Sieve Capacity, minimum is 100000, maximum is 400000(DEFAULT: 200000)")
				.worldRestart().defineInRange("Tier 3 Powered Sieve Capacity: ", defaultT3PoweredSieveCapacity, 100000, 400000);
		
		t3PressCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Press Capacity, minimum is 100000, maximum is 400000(DEFAULT: 200000)")
				.worldRestart().defineInRange("Tier 3 Press Capacity: ", defaultT3PressCapacity, 100000, 400000);
		
		t3PressReceive = MECHANICRAFT_BUILDER.comment("Tier 3 Press Energy Receive, minimum is 1250, maximum is 5000(DEFAULT: 2500)")
				.worldRestart().defineInRange("Tier 3 Press Energy Receive: ", defaultT3PressReceive, 1250, 5000);
		
		t3PoweredSieveReceive = MECHANICRAFT_BUILDER.comment("Tier 3 Powered Sieve Energy Receive, minimum is 1250, maximum is 5000(DEFAULT: 2500)")
				.worldRestart().defineInRange("Tier 3 Powered Sieve Energy Receive: ", defaultT3PoweredSieveReceive, 1250, 5000);
		
		t3SlurryProcessorEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Slurry Processor Energy Capacity, minimum is 100000, maximum is 400000(DEFAULT: 200000)")
				.worldRestart().defineInRange("Tier 3 Slurry Processor Energy Capacity: ", defaultT3SlurryProcessorEnergyCapacity, 100000, 400000);
		
		t3SlurryProcessorReceive = MECHANICRAFT_BUILDER.comment("Tier 3 Slurry Processor Energy Receive, minimum is 1250, maximum is 5000(DEFAULT: 2500)")
				.worldRestart().defineInRange("Tier 3 Slurry Processor Energy Receive: ", defaultT3SlurryProcessorReceive, 1250, 5000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 4 MACHINE SETTINGS").comment("Machine Energy Settings");
		
		t4CrusherCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Crusher Capacity, minimum is 125000, maximum is 500000(DEFAULT: 250000)")
				.worldRestart().defineInRange("Tier 4 Crusher Capacity: ", defaultT4CrusherCapacity, 125000, 500000);
		
		t4CrusherReceive = MECHANICRAFT_BUILDER.comment("Tier 4 Crusher Energy Receive, minimum is 1500, maximum is 6000(DEFAULT: 3000)")
				.worldRestart().defineInRange("Tier 4 Crusher Energy Receive: ", defaultT4CrusherReceive, 1500, 6000);
		
		t4EnergyCubeCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Energy Cube Capacity, minimum is 125000, maximum is 900000(DEFAULT: 450000)")
				.worldRestart().defineInRange("Tier 4 Energy Cube Capacity: ", defaultT4EnergyCubeCapacity, 125000, 900000);
		
		t4EnergyCubeTransfer = MECHANICRAFT_BUILDER.comment("Tier 4 Energy Cube Energy Transfer, minimum is 1000, maximum is 9000(DEFAULT: 4500)")
				.worldRestart().defineInRange("Tier 4 Energy Cube Transfer: ", defaultT4EnergyCubeTransfer, 2250, 9000);
		
		t4InfuserCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Metallic Infuser Capacity, minimum is 125000, maximum is 500000(DEFAULT: 250000)")
				.worldRestart().defineInRange("Tier 4 Metallic Infuser Capacity: ", defaultT4InfuserCapacity, 125000, 500000);
		
		t4InfuserReceive = MECHANICRAFT_BUILDER.comment("Tier 4 Metallic Infuser Energy Receive, minimum is 1500, maximum is 6000(DEFAULT: 3000)")
				.worldRestart().defineInRange("Tier 4 Metallic Infuser Energy Receive: ", defaultT4InfuserReceive, 1500, 6000);
		
		t4OreWasherEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Ore Washer Energy Capacity, minimum is 125000, maximum is 500000(DEFAULT: 250000)")
				.worldRestart().defineInRange("Tier 4 Ore Washer Energy Capacity: ", defaultT4OreWasherEnergyCapacity, 125000, 500000);
		
		t4OreWasherReceive = MECHANICRAFT_BUILDER.comment("Tier 4 Ore Washer Energy Receive, minimum is 1500, maximum is 6000(DEFAULT: 3000)")
				.worldRestart().defineInRange("Tier 4 Ore Washer Energy Receive: ", defaultT4OreWasherReceive, 1500, 6000);
		
		t4PoweredSieveCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Powered Sieve Capacity, minimum is 125000, maximum is 500000(DEFAULT: 250000)")
				.worldRestart().defineInRange("Tier 4 Powered Sieve Capacity: ", defaultT4PoweredSieveCapacity, 125000, 500000);
		
		t4PoweredSieveReceive = MECHANICRAFT_BUILDER.comment("Tier 4 Powered Sieve Energy Receive, minimum is 1500, maximum is 6000(DEFAULT: 3000)")
				.worldRestart().defineInRange("Tier 4 Powered Sieve Energy Receive: ", defaultT4PoweredSieveReceive, 1500, 6000);
		
		t4PressCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Press Capacity, minimum is 125000, maximum is 500000(DEFAULT: 250000)")
				.worldRestart().defineInRange("Tier 4 Press Capacity: ", defaultT4PressCapacity, 125000, 500000);
		
		t4PressReceive = MECHANICRAFT_BUILDER.comment("Tier 4 Press Energy Receive, minimum is 1500, maximum is 6000(DEFAULT: 3000)")
				.worldRestart().defineInRange("Tier 4 Press Energy Receive: ", defaultT4PressReceive, 1500, 6000);
		
		t4SlurryProcessorEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Slurry Processor Energy Capacity, minimum is 125000, maximum is 500000(DEFAULT: 250000)")
				.worldRestart().defineInRange("Tier 4 Slurry Processor Energy Capacity: ", defaultT4SlurryProcessorEnergyCapacity, 125000, 500000);
		
		t4SlurryProcessorReceive = MECHANICRAFT_BUILDER.comment("Tier 4 Slurry Processor Energy Receive, minimum is 1500, maximum is 6000(DEFAULT: 3000)")
				.worldRestart().defineInRange("Tier 4 Slurry Processor Energy Receive: ", defaultT4SlurryProcessorReceive, 1500, 6000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 5 MACHINE SETTINGS").comment("Machine Energy Settings");
		
		t5CrusherCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Crusher Capacity, minimum is 150000, maximum is 600000(DEFAULT: 300000)")
				.worldRestart().defineInRange("Tier 5 Crusher Capacity: ", defaultT5CrusherCapacity, 150000, 600000);
		
		t5CrusherReceive = MECHANICRAFT_BUILDER.comment("Tier 5 Crusher Energy Receive, minimum is 1750, maximum is 7000(DEFAULT: 3500)")
				.worldRestart().defineInRange("Tier 5 Crusher Energy Receive: ", defaultT5CrusherReceive, 1750, 7000);
		
		t5EnergyCubeCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Energy Cube Capacity, minimum is 150000, maximum is 1100000(DEFAULT: 550000)")
				.worldRestart().defineInRange("Tier 5 Energy Cube Capacity: ", defaultT5EnergyCubeCapacity, 150000, 1100000);
		
		t5EnergyCubeTransfer = MECHANICRAFT_BUILDER.comment("Tier 5 Energy Cube Energy Transfer, minimum is 1000, maximum is 11000(DEFAULT: 5500)")
				.worldRestart().defineInRange("Tier 5 Energy Cube Transfer: ", defaultT5EnergyCubeTransfer, 2750, 11000);
		
		t5InfuserCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Metallic Infuser Capacity, minimum is 150000, maximum is 600000(DEFAULT: 300000)")
				.worldRestart().defineInRange("Tier 5 Metallic Infuser Capacity: ", defaultT5InfuserCapacity, 150000, 600000);
		
		t5InfuserReceive = MECHANICRAFT_BUILDER.comment("Tier 5 Metallic Infuser Energy Receive, minimum is 1750, maximum is 7000(DEFAULT: 3500)")
				.worldRestart().defineInRange("Tier 5 Metallic Infuser Energy Receive: ", defaultT5InfuserReceive, 1750, 7000);
		
		t5OreWasherEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Ore Washer Energy Capacity, minimum is 150000, maximum is 600000(DEFAULT: 300000)")
				.worldRestart().defineInRange("Tier 5 Ore Washer Energy Capacity: ", defaultT5OreWasherEnergyCapacity, 150000, 600000);
		
		t5OreWasherReceive = MECHANICRAFT_BUILDER.comment("Tier 5 Ore Washer Energy Receive, minimum is 1750, maximum is 7000(DEFAULT: 3500)")
				.worldRestart().defineInRange("Tier 5 Ore Washer Energy Receive: ", defaultT5OreWasherReceive, 1750, 7000);
		
		t5PoweredSieveCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Powered Sieve Capacity, minimum is 150000, maximum is 600000(DEFAULT: 300000)")
				.worldRestart().defineInRange("Tier 5 Powered Sieve Capacity: ", defaultT5PoweredSieveCapacity, 150000, 600000);
		
		t5PoweredSieveReceive = MECHANICRAFT_BUILDER.comment("Tier 5 Powered Sieve Energy Receive, minimum is 1750, maximum is 7000(DEFAULT: 3500)")
				.worldRestart().defineInRange("Tier 5 Powered Sieve Energy Receive: ", defaultT5PoweredSieveReceive, 1750, 7000);
		
		t5PressCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Press Capacity, minimum is 150000, maximum is 600000(DEFAULT: 300000)")
				.worldRestart().defineInRange("Tier 5 Press Capacity: ", defaultT5PressCapacity, 150000, 600000);
		
		t5PressReceive = MECHANICRAFT_BUILDER.comment("Tier 5 Press Energy Receive, minimum is 1750, maximum is 7000(DEFAULT: 3500)")
				.worldRestart().defineInRange("Tier 5 Press Energy Receive: ", defaultT5PressReceive, 1750, 7000);
		
		t5SlurryProcessorEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Slurry Processor Energy Capacity, minimum is 150000, maximum is 600000(DEFAULT: 300000)")
				.worldRestart().defineInRange("Tier 5 Slurry Processor Energy Capacity: ", defaultT5SlurryProcessorEnergyCapacity, 150000, 600000);
		
		t5SlurryProcessorReceive = MECHANICRAFT_BUILDER.comment("Tier 5 Slurry Processor Energy Receive, minimum is 1750, maximum is 7000(DEFAULT: 3500)")
				.worldRestart().defineInRange("Tier 5 Slurry Processor Energy Receive: ", defaultT5SlurryProcessorReceive, 1750, 7000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 6 MACHINE SETTINGS").comment("Machine Energy Settings");
		
		t6CrusherCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Crusher Capacity, minimum is 175000, maximum is 700000(DEFAULT: 350000)")
				.worldRestart().defineInRange("Tier 6 Crusher Capacity: ", defaultT6CrusherCapacity, 175000, 700000);
		
		t6CrusherReceive = MECHANICRAFT_BUILDER.comment("Tier 6 Crusher Energy Receive, minimum is 2000, maximum is 8000(DEFAULT: 4000)")
				.worldRestart().defineInRange("Tier 6 Crusher Energy Receive: ", defaultT6CrusherReceive, 2000, 8000);
		
		t6EnergyCubeCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Energy Cube Capacity, minimum is 175000, maximum is 1300000(DEFAULT: 650000)")
				.worldRestart().defineInRange("Tier 6 Energy Cube Capacity: ", defaultT6EnergyCubeCapacity, 175000, 1300000);
		
		t6EnergyCubeTransfer = MECHANICRAFT_BUILDER.comment("Tier 6 Energy Cube Energy Transfer, minimum is 1000, maximum is 13000(DEFAULT: 6500)")
				.worldRestart().defineInRange("Tier 6 Energy Cube Transfer: ", defaultT6EnergyCubeTransfer, 3250, 13000);
		
		t6InfuserCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Metallic Infuser Capacity, minimum is 175000, maximum is 700000(DEFAULT: 350000)")
				.worldRestart().defineInRange("Tier 6 Metallic Infuser Capacity: ", defaultT6InfuserCapacity, 175000, 700000);
		
		t6InfuserReceive = MECHANICRAFT_BUILDER.comment("Tier 6 Metallic Infuser Energy Receive, minimum is 2000, maximum is 8000(DEFAULT: 4000)")
				.worldRestart().defineInRange("Tier 6 Metallic Infuser Energy Receive: ", defaultT6InfuserReceive, 2000, 8000);
		
		t6OreWasherEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Ore Washer Energy Capacity, minimum is 175000, maximum is 700000(DEFAULT: 350000)")
				.worldRestart().defineInRange("Tier 6 Ore Washer Energy Capacity: ", defaultT6OreWasherEnergyCapacity, 175000, 700000);
		
		t6OreWasherReceive = MECHANICRAFT_BUILDER.comment("Tier 6 Ore Washer Energy Receive, minimum is 2000, maximum is 8000(DEFAULT: 4000)")
				.worldRestart().defineInRange("Tier 6 Ore Washer Energy Receive: ", defaultT6OreWasherReceive, 2000, 8000);
		
		t6PoweredSieveCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Powered Sieve Capacity, minimum is 175000, maximum is 700000(DEFAULT: 350000)")
				.worldRestart().defineInRange("Tier 6 Powered Sieve Capacity: ", defaultT6PoweredSieveCapacity, 175000, 700000);
		
		t6PoweredSieveReceive = MECHANICRAFT_BUILDER.comment("Tier 6 Powered Sieve Energy Receive, minimum is 2000, maximum is 8000(DEFAULT: 4000)")
				.worldRestart().defineInRange("Tier 6 Powered Sieve Energy Receive: ", defaultT6PoweredSieveReceive, 2000, 8000);
		
		t6PressCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Press Capacity, minimum is 175000, maximum is 700000(DEFAULT: 350000)")
				.worldRestart().defineInRange("Tier 6 Press Capacity: ", defaultT6PressCapacity, 175000, 700000);
		
		t6PressReceive = MECHANICRAFT_BUILDER.comment("Tier 6 Press Energy Receive, minimum is 2000, maximum is 8000(DEFAULT: 4000)")
				.worldRestart().defineInRange("Tier 6 Press Energy Receive: ", defaultT6PressReceive, 2000, 8000);
		
		t6SlurryProcessorEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Slurry Processor Energy Capacity, minimum is 175000, maximum is 700000(DEFAULT: 350000)")
				.worldRestart().defineInRange("Tier 6 Slurry Processor Energy Capacity: ", defaultT6SlurryProcessorEnergyCapacity, 175000, 700000);
		
		t6SlurryProcessorReceive = MECHANICRAFT_BUILDER.comment("Tier 6 Slurry Processor Energy Receive, minimum is 2000, maximum is 8000(DEFAULT: 4000)")
				.worldRestart().defineInRange("Tier 6 Slurry Processor Energy Receive: ", defaultT6SlurryProcessorReceive, 2000, 8000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("FLUID SETTINGS").comment("Fluid Settings");
		MECHANICRAFT_BUILDER.pop();
		MECHANICRAFT_BUILDER.push("TIER 1 FLUID SETTINGS START").comment("Tier 1 Fluid Settings");
		
		t1OreWasherTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Ore Washer Tank Capacity, minimum is 8000, maximum is 32000(DEFAULT: 16000)")
				.worldRestart().defineInRange("Tier 1 Ore Washer Tank Capacity: ", defaultT1OreWasherTankCapacity, 8000, 32000);
		
		t1SlurryProcessorTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Slurry Processor Tank Capacity, minimum is 8000, maximum is 32000(DEFAULT: 16000)")
				.worldRestart().defineInRange("Tier 1 Slurry Processor Tank Capacity: ", defaultT1SlurryProcessorTankCapacity, 8000, 32000);
		
		basicTankCapacity = MECHANICRAFT_BUILDER.comment("Basic Tank Capacity, minimum is 8000, maximum is 32000(DEFAULT: 16000)")
				.worldRestart().defineInRange("Basic Tank Capacity: ", defaultBasicTankCapacity, 8000, 32000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 2 FLUID SETTINGS START").comment("Tier 2 Fluid Settings");
		
		t2OreWasherTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Ore Washer Tank Capacity, minimum is 16000, maximum is 64000(DEFAULT: 32000)")
				.worldRestart().defineInRange("Tier 2 Ore Washer Tank Capacity: ", defaultT2OreWasherTankCapacity, 16000, 64000);
		
		t2SlurryProcessorTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Slurry Processor Tank Capacity, minimum is 16000, maximum is 64000(DEFAULT: 32000)")
				.worldRestart().defineInRange("Tier 2 Slurry Processor Tank Capacity: ", defaultT2SlurryProcessorTankCapacity, 16000, 64000);
		
		advancedTankCapacity = MECHANICRAFT_BUILDER.comment("Advanced Tank Capacity, minimum is 16000, maximum is 64000(DEFAULT: 32000)")
				.worldRestart().defineInRange("Advanced Tank Capacity: ", defaultAdvancedTankCapacity, 16000, 64000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 3 FLUID SETTINGS START").comment("Tier 3 Fluid Settings");
		
		t3OreWasherTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Ore Washer Tank Capacity, minimum is 32000, maximum is 128000(DEFAULT: 64000)")
				.worldRestart().defineInRange("Tier 3 Ore Washer Tank Capacity: ", defaultT3OreWasherTankCapacity, 32000, 128000);
		
		t3SlurryProcessorTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Slurry Processor Tank Capacity, minimum is 32000, maximum is 128000(DEFAULT: 64000)")
				.worldRestart().defineInRange("Tier 3 Slurry Processor Tank Capacity: ", defaultT3SlurryProcessorTankCapacity, 32000, 128000);
		
		eliteTankCapacity = MECHANICRAFT_BUILDER.comment("Elite Tank Capacity, minimum is 32000, maximum is 128000(DEFAULT: 64000)")
				.worldRestart().defineInRange("Elite Tank Capacity: ", defaultEliteTankCapacity, 32000, 128000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 4 FLUID SETTINGS START").comment("Tier 4 Fluid Settings");
		
		t4OreWasherTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Ore Washer Tank Capacity, minimum is 64000, maximum is 256000(DEFAULT: 128000)")
				.worldRestart().defineInRange("Tier 4 Ore Washer Tank Capacity: ", defaultT4OreWasherTankCapacity, 64000, 256000);
		
		t4SlurryProcessorTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Slurry Processor Tank Capacity, minimum is 64000, maximum is 256000(DEFAULT: 128000)")
				.worldRestart().defineInRange("Tier 4 Slurry Processor Tank Capacity: ", defaultT4SlurryProcessorTankCapacity, 64000, 256000);
		
		superiorTankCapacity = MECHANICRAFT_BUILDER.comment("Superior Tank Capacity, minimum is 64000, maximum is 256000(DEFAULT: 128000)")
				.worldRestart().defineInRange("Superior Tank Capacity: ", defaultSuperiorTankCapacity, 64000, 256000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 5 FLUID SETTINGS START").comment("Tier 5 Fluid Settings");
		
		t5OreWasherTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Ore Washer Tank Capacity, minimum is 128000, maximum is 512000(DEFAULT: 256000)")
				.worldRestart().defineInRange("Tier 5 Ore Washer Tank Capacity: ", defaultT5OreWasherTankCapacity, 128000, 512000);
		
		t5SlurryProcessorTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Slurry Processor Tank Capacity, minimum is 128000, maximum is 512000(DEFAULT: 256000)")
				.worldRestart().defineInRange("Tier 5 Slurry Processor Tank Capacity: ", defaultT5SlurryProcessorTankCapacity, 128000, 512000);
		
		supremeTankCapacity = MECHANICRAFT_BUILDER.comment("Supreme Tank Capacity, minimum is 128000, maximum is 512000(DEFAULT: 256000)")
				.worldRestart().defineInRange("Supreme Tank Capacity: ", defaultSupremeTankCapacity, 128000, 512000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 6 FLUID SETTINGS START").comment("Tier 6 Fluid Settings");
		
		t6OreWasherTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Ore Washer Tank Capacity, minimum is 256000, maximum is 1024000(DEFAULT: 512000)")
				.worldRestart().defineInRange("Tier 6 Ore Washer Tank Capacity: ", defaultT6OreWasherTankCapacity, 256000, 1024000);
		
		t6SlurryProcessorTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Slurry Processor Tank Capacity, minimum is 256000, maximum is 1024000(DEFAULT: 512000)")
				.worldRestart().defineInRange("Tier 6 Slurry Processor Tank Capacity: ", defaultT6SlurryProcessorTankCapacity, 256000, 1024000);
		
		ultimateTankCapacity = MECHANICRAFT_BUILDER.comment("Ultimate Tank Capacity, minimum is 256000, maximum is 1024000(DEFAULT: 512000)")
				.worldRestart().defineInRange("Ultimate Tank Capacity: ", defaultUltimateTankCapacity, 256000, 1024000);
		
		MECHANICRAFT_BUILDER.pop();
		
		//MECHANICRAFT_BUILDER.push("ARMOR SETTINGS").comment("Armor Settings");
		//TODO
		//MECHANICRAFT_BUILDER.pop();
		
		//MECHANICRAFT_BUILDER.push("TOOL SETTINGS").comment("Tool Settings");
		//TODO
		//MECHANICRAFT_BUILDER.pop();
		
		//MECHANICRAFT_BUILDER.push("MESH SETTINGS").comment("Mesh Settings");
		//TODO
		//MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_SPEC = MECHANICRAFT_BUILDER.build();
	}
	
	
	@SubscribeEvent
	public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
		if (configEvent.getConfig().getSpec() == ModConfigs.MECHANICRAFT_SPEC) {
			bakeConfig();
		}
	}

	public static void bakeConfig() {
		
		//Ore Gen
		copperGenBool = copperGen.get();
		leadGenBool = leadGen.get();
		tinGenBool = tinGen.get();
		silverGenBool = silverGen.get();
		rubyGenHillsBool = !(rubyGenAll.get());
		sapphireGenHillsBool = !(sapphireGenAll.get());
		rubyGenAllBool = !(rubyGenHills.get());
		sapphireGenAllBool = !(sapphireGenHills.get());
		enderGenBool = enderGen.get();
		
		//Machine Energy Config
		t1CrusherCapacityInt = t1CrusherCapacity.get();
		t1CrusherReceiveInt = t1CrusherReceive.get();
		t1EnergyCubeCapacityInt = t1EnergyCubeCapacity.get();
		t1EnergyCubeTransferInt = t1EnergyCubeTransfer.get();
		t1InfuserCapacityInt = t1InfuserCapacity.get();
		t1InfuserReceiveInt = t1InfuserReceive.get();
		t1OreWasherEnergyCapacityInt = t1OreWasherEnergyCapacity.get();
		t1OreWasherReceiveInt = t1OreWasherReceive.get();
		t1PoweredSieveCapacityInt = t1PoweredSieveCapacity.get();
		t1PoweredSieveReceiveInt = t1PoweredSieveReceive.get();
		t1PressCapacityInt = t1PressCapacity.get();
		t1PressReceiveInt = t1PressReceive.get();
		t1SlurryProcessorEnergyCapacityInt = t1SlurryProcessorEnergyCapacity.get();
		t1SlurryProcessorReceiveInt = t1SlurryProcessorReceive.get();
		
		t2CrusherCapacityInt = t2CrusherCapacity.get();
		t2CrusherReceiveInt = t2CrusherReceive.get();
		t2EnergyCubeCapacityInt = t2EnergyCubeCapacity.get();
		t2EnergyCubeTransferInt = t2EnergyCubeTransfer.get();
		t2InfuserCapacityInt = t2InfuserCapacity.get();
		t2InfuserReceiveInt = t2InfuserReceive.get();
		t2OreWasherEnergyCapacityInt = t2OreWasherEnergyCapacity.get();
		t2OreWasherReceiveInt = t2OreWasherReceive.get();
		t2PoweredSieveCapacityInt = t2PoweredSieveCapacity.get();
		t2PoweredSieveReceiveInt = t2PoweredSieveReceive.get();
		t2PressCapacityInt = t2PressCapacity.get();
		t2PressReceiveInt = t2PressReceive.get();
		t2SlurryProcessorEnergyCapacityInt = t2SlurryProcessorEnergyCapacity.get();
		t2SlurryProcessorReceiveInt = t2SlurryProcessorReceive.get();
		
		t3CrusherCapacityInt = t3CrusherCapacity.get();
		t3CrusherReceiveInt = t3CrusherReceive.get();
		t3EnergyCubeCapacityInt = t3EnergyCubeCapacity.get();
		t3EnergyCubeTransferInt = t3EnergyCubeTransfer.get();
		t3InfuserCapacityInt = t3InfuserCapacity.get();
		t3InfuserReceiveInt = t3InfuserReceive.get();
		t3OreWasherEnergyCapacityInt = t3OreWasherEnergyCapacity.get();
		t3OreWasherReceiveInt = t3OreWasherReceive.get();
		t3PoweredSieveCapacityInt = t3PoweredSieveCapacity.get();
		t3PoweredSieveReceiveInt = t3PoweredSieveReceive.get();
		t3PressCapacityInt = t3PressCapacity.get();
		t3PressReceiveInt = t3PressReceive.get();
		t3SlurryProcessorEnergyCapacityInt = t3SlurryProcessorEnergyCapacity.get();
		t3SlurryProcessorReceiveInt = t3SlurryProcessorReceive.get();
		
		t4CrusherCapacityInt = t4CrusherCapacity.get();
		t4CrusherReceiveInt = t4CrusherReceive.get();
		t4EnergyCubeCapacityInt = t4EnergyCubeCapacity.get();
		t4EnergyCubeTransferInt = t4EnergyCubeTransfer.get();
		t4InfuserCapacityInt = t4InfuserCapacity.get();
		t4InfuserReceiveInt = t4InfuserReceive.get();
		t4OreWasherEnergyCapacityInt = t4OreWasherEnergyCapacity.get();
		t4OreWasherReceiveInt = t4OreWasherReceive.get();
		t4PoweredSieveCapacityInt = t4PoweredSieveCapacity.get();
		t4PoweredSieveReceiveInt = t4PoweredSieveReceive.get();
		t4PressCapacityInt = t4PressCapacity.get();
		t4PressReceiveInt = t4PressReceive.get();
		t4SlurryProcessorEnergyCapacityInt = t4SlurryProcessorEnergyCapacity.get();
		t4SlurryProcessorReceiveInt = t4SlurryProcessorReceive.get();
		
		t5CrusherCapacityInt = t5CrusherCapacity.get();
		t5CrusherReceiveInt = t5CrusherReceive.get();
		t5EnergyCubeCapacityInt = t5EnergyCubeCapacity.get();
		t5EnergyCubeTransferInt = t5EnergyCubeTransfer.get();
		t5InfuserCapacityInt = t5InfuserCapacity.get();
		t5InfuserReceiveInt = t5InfuserReceive.get();
		t5OreWasherEnergyCapacityInt = t5OreWasherEnergyCapacity.get();
		t5OreWasherReceiveInt = t5OreWasherReceive.get();
		t5PoweredSieveCapacityInt = t5PoweredSieveCapacity.get();
		t5PoweredSieveReceiveInt = t5PoweredSieveReceive.get();
		t5PressCapacityInt = t5PressCapacity.get();
		t5PressReceiveInt = t5PressReceive.get();
		t5SlurryProcessorEnergyCapacityInt = t5SlurryProcessorEnergyCapacity.get();
		t5SlurryProcessorReceiveInt = t5SlurryProcessorReceive.get();
		
		t6CrusherCapacityInt = t6CrusherCapacity.get();
		t6CrusherReceiveInt = t6CrusherReceive.get();
		t6EnergyCubeCapacityInt = t6EnergyCubeCapacity.get();
		t6EnergyCubeTransferInt = t6EnergyCubeTransfer.get();
		t6InfuserCapacityInt = t6InfuserCapacity.get();
		t6InfuserReceiveInt = t6InfuserReceive.get();
		t6OreWasherEnergyCapacityInt = t6OreWasherEnergyCapacity.get();
		t6OreWasherReceiveInt = t6OreWasherReceive.get();
		t6PoweredSieveCapacityInt = t6PoweredSieveCapacity.get();
		t6PoweredSieveReceiveInt = t6PoweredSieveReceive.get();
		t6PressCapacityInt = t6PressCapacity.get();
		t6PressReceiveInt = t6PressReceive.get();
		t6SlurryProcessorEnergyCapacityInt = t6SlurryProcessorEnergyCapacity.get();
		t6SlurryProcessorReceiveInt = t6SlurryProcessorReceive.get();
		
		//Fluid Config
		t1OreWasherTankCapacityInt = t1OreWasherTankCapacity.get();
		t1SlurryProcessorTankCapacityInt = t1SlurryProcessorTankCapacity.get();
		t2OreWasherTankCapacityInt = t2OreWasherTankCapacity.get();
		t2SlurryProcessorTankCapacityInt = t2SlurryProcessorTankCapacity.get();
		t3OreWasherTankCapacityInt = t3OreWasherTankCapacity.get();
		t3SlurryProcessorTankCapacityInt = t3SlurryProcessorTankCapacity.get();
		t4OreWasherTankCapacityInt = t4OreWasherTankCapacity.get();
		t4SlurryProcessorTankCapacityInt = t4SlurryProcessorTankCapacity.get();
		t5OreWasherTankCapacityInt = t5OreWasherTankCapacity.get();
		t5SlurryProcessorTankCapacityInt = t5SlurryProcessorTankCapacity.get();
		t6OreWasherTankCapacityInt = t6OreWasherTankCapacity.get();
		t6SlurryProcessorTankCapacityInt = t6SlurryProcessorTankCapacity.get();
		
		basicTankCapacityInt = basicTankCapacity.get();
		advancedTankCapacityInt = advancedTankCapacity.get();
		eliteTankCapacityInt = eliteTankCapacity.get();
		superiorTankCapacityInt = superiorTankCapacity.get();
		supremeTankCapacityInt = supremeTankCapacity.get();
		ultimateTankCapacityInt = ultimateTankCapacity.get();
	}
}