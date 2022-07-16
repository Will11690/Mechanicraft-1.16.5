package com.github.will11690.mechanicraft.init;

import net.minecraftforge.common.ForgeConfigSpec;

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
	
	public static int copperVeinSizeInt;
	public static int copperMinYInt;
	public static int copperMaxYInt;
	public static int copperVeinsPerChunkInt;
	
	public static int leadVeinSizeInt;
	public static int leadMinYInt;
	public static int leadMaxYInt;
	public static int leadVeinsPerChunkInt;
	
	public static int tinVeinSizeInt;
	public static int tinMinYInt;
	public static int tinMaxYInt;
	public static int tinVeinsPerChunkInt;
	
	public static int silverVeinSizeInt;
	public static int silverMinYInt;
	public static int silverMaxYInt;
	public static int silverVeinsPerChunkInt;
	
	public static int rubyVeinSizeInt;
	public static int rubyMinYInt;
	public static int rubyMaxYInt;
	public static int rubyVeinsPerChunkInt;
	
	public static int sapphireVeinSizeInt;
	public static int sapphireMinYInt;
	public static int sapphireMaxYInt;
	public static int sapphireVeinsPerChunkInt;
	
	public static int enderVeinSizeInt;
	public static int enderMinYInt;
	public static int enderMaxYInt;
	public static int enderVeinsPerChunkInt;
	
	//Machine Energy Config
	//(Basic)
	public static int basicFurnaceCapacityInt;
	public static int basicFurnaceReceiveInt;
	public static int basicCoalGeneratorCapacityInt;
	public static int basicCoalGeneratorExtractInt;
	
	public static int basicFurnaceWorkTimeInt;
	public static int basicFurnaceEnergyPerTickInt;
	public static int basicCoalGeneratorPowerGenInt;
	
	//(Advanced)
	public static int advancedFurnaceCapacityInt;
	public static int advancedFurnaceReceiveInt;
	public static int advancedCoalGeneratorCapacityInt;
	public static int advancedCoalGeneratorExtractInt;
	
	public static int advancedFurnaceWorkTimeInt;
	public static int advancedFurnaceEnergyPerTickInt;
	public static int advancedCoalGeneratorPowerGenInt;
	
	//(Tier 1)
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
	
	public static int t1CrusherWorkTimeInt;
	public static int t1CrusherEnergyPerTickInt;
	public static int t1InfuserWorkTimeInt;
	public static int t1InfuserEnergyPerTickInt;
	public static int t1OreWasherWorkTimeInt;
	public static int t1OreWasherEnergyPerTickInt;
	public static int t1PoweredSieveWorkTimeInt;
	public static int t1PoweredSieveEnergyPerTickInt;
	public static int t1PressWorkTimeInt;
	public static int t1PressEnergyPerTickInt;
	public static int t1SlurryProcessorWorkTimeInt;
	public static int t1SlurryProcessorEnergyPerTickInt;
	
	//(Tier 2)
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
	
	public static int t2CrusherWorkTimeInt;
	public static int t2CrusherEnergyPerTickInt;
	public static int t2InfuserWorkTimeInt;
	public static int t2InfuserEnergyPerTickInt;
	public static int t2OreWasherWorkTimeInt;
	public static int t2OreWasherEnergyPerTickInt;
	public static int t2PoweredSieveWorkTimeInt;
	public static int t2PoweredSieveEnergyPerTickInt;
	public static int t2PressWorkTimeInt;
	public static int t2PressEnergyPerTickInt;
	public static int t2SlurryProcessorWorkTimeInt;
	public static int t2SlurryProcessorEnergyPerTickInt;
	
	//(Tier 3)
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
	
	public static int t3CrusherWorkTimeInt;
	public static int t3CrusherEnergyPerTickInt;
	public static int t3InfuserWorkTimeInt;
	public static int t3InfuserEnergyPerTickInt;
	public static int t3OreWasherWorkTimeInt;
	public static int t3OreWasherEnergyPerTickInt;
	public static int t3PoweredSieveWorkTimeInt;
	public static int t3PoweredSieveEnergyPerTickInt;
	public static int t3PressWorkTimeInt;
	public static int t3PressEnergyPerTickInt;
	public static int t3SlurryProcessorWorkTimeInt;
	public static int t3SlurryProcessorEnergyPerTickInt;
	
	//(Tier 4)
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
	
	public static int t4CrusherWorkTimeInt;
	public static int t4CrusherEnergyPerTickInt;
	public static int t4InfuserWorkTimeInt;
	public static int t4InfuserEnergyPerTickInt;
	public static int t4OreWasherWorkTimeInt;
	public static int t4OreWasherEnergyPerTickInt;
	public static int t4PoweredSieveWorkTimeInt;
	public static int t4PoweredSieveEnergyPerTickInt;
	public static int t4PressWorkTimeInt;
	public static int t4PressEnergyPerTickInt;
	public static int t4SlurryProcessorWorkTimeInt;
	public static int t4SlurryProcessorEnergyPerTickInt;
	
	//(Tier 5)
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
	
	public static int t5CrusherWorkTimeInt;
	public static int t5CrusherEnergyPerTickInt;
	public static int t5InfuserWorkTimeInt;
	public static int t5InfuserEnergyPerTickInt;
	public static int t5OreWasherWorkTimeInt;
	public static int t5OreWasherEnergyPerTickInt;
	public static int t5PoweredSieveWorkTimeInt;
	public static int t5PoweredSieveEnergyPerTickInt;
	public static int t5PressWorkTimeInt;
	public static int t5PressEnergyPerTickInt;
	public static int t5SlurryProcessorWorkTimeInt;
	public static int t5SlurryProcessorEnergyPerTickInt;
	
	//(Tier 6)
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
	
	public static int t6CrusherWorkTimeInt;
	public static int t6CrusherEnergyPerTickInt;
	public static int t6InfuserWorkTimeInt;
	public static int t6InfuserEnergyPerTickInt;
	public static int t6OreWasherWorkTimeInt;
	public static int t6OreWasherEnergyPerTickInt;
	public static int t6PoweredSieveWorkTimeInt;
	public static int t6PoweredSieveEnergyPerTickInt;
	public static int t6PressWorkTimeInt;
	public static int t6PressEnergyPerTickInt;
	public static int t6SlurryProcessorWorkTimeInt;
	public static int t6SlurryProcessorEnergyPerTickInt;
		
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
	
	//Item Config
	//(Mesh)
	public static int stringMeshDurabilityInt;
	public static int reinforcedStringMeshDurabilityInt;
	public static int ironMeshDurabilityInt;
	public static int reinforcedIronMeshDurabilityInt;
	public static int steelMeshDurabilityInt;
	public static int reinforcedSteelMeshDurabilityInt;
	public static int diamondMeshDurabilityInt;
	public static int reinforcedDiamondMeshDurabilityInt;
	public static int gemMeshDurabilityInt;
	public static int reinforcedGemMeshDurabilityInt;
	public static int endoniumMeshDurabilityInt;
	public static int reinforcedEndoniumMeshDurabilityInt;
	
	//(Armor)
	public static boolean armorEffectsBool;
	
	//[Emeronium]
	public static int emeroniumArmorDurabilityInt;
	public static int emeroniumArmorEnchantabilityInt;
	public static double emeroniumArmorToughnessFloat;
	public static double emeroniumArmorResistanceFloat;
	
	public static int emeroniumBootsProtectionInt;
	public static int emeroniumLeggingsProtectionInt;
	public static int emeroniumChestplateProtectionInt;
	public static int emeroniumHelmetProtectionInt;
	
	public static boolean emeroniumArmorHeroEffectBool;
	
	//[Endonium]
	public static int endoniumArmorDurabilityInt;
	public static int endoniumArmorEnchantabilityInt;
	public static double endoniumArmorToughnessFloat;
	public static double endoniumArmorResistanceFloat;
	
	public static int endoniumBootsProtectionInt;
	public static int endoniumLeggingsProtectionInt;
	public static int endoniumChestplateProtectionInt;
	public static int endoniumHelmetProtectionInt;
	
	public static boolean endoniumArmorHealthEffectBool;
	public static boolean endoniumArmorSpeedEffectBool;
	public static boolean endoniumArmorHeroEffectBool;
	public static boolean endoniumArmorFireEffectBool;
	public static boolean endoniumArmorWaterEffectBool;
	public static boolean endoniumArmorVisionEffectBool;
	
	//[Endonium Crystal]
	public static int endoniumCrystalArmorDurabilityInt;
	public static int endoniumCrystalArmorEnchantabilityInt;
	public static double endoniumCrystalArmorToughnessFloat;
	public static double endoniumCrystalArmorResistanceFloat;
	
	public static int endoniumCrystalBootsProtectionInt;
	public static int endoniumCrystalLeggingsProtectionInt;
	public static int endoniumCrystalChestplateProtectionInt;
	public static int endoniumCrystalHelmetProtectionInt;

	public static boolean endoniumCrystalArmorHealthEffectBool;
	public static boolean endoniumCrystalArmorFlightEffectBool;
	public static boolean endoniumCrystalArmorSpeedEffectBool;
	public static boolean endoniumCrystalArmorHeroEffectBool;
	public static boolean endoniumCrystalArmorFireEffectBool;
	public static boolean endoniumCrystalArmorWaterEffectBool;
	public static boolean endoniumCrystalArmorVisionEffectBool;
	
	//[Saphonium]
	public static int saphoniumArmorDurabilityInt;
	public static int saphoniumArmorEnchantabilityInt;
	public static double saphoniumArmorToughnessFloat;
	public static double saphoniumArmorResistanceFloat;
	
	public static int saphoniumBootsProtectionInt;
	public static int saphoniumLeggingsProtectionInt;
	public static int saphoniumChestplateProtectionInt;
	public static int saphoniumHelmetProtectionInt;
	
	public static boolean saphoniumArmorWaterEffectBool;
	
	//[Rubonium]
	public static int ruboniumArmorDurabilityInt;
	public static int ruboniumArmorEnchantabilityInt;
	public static double ruboniumArmorToughnessFloat;
	public static double ruboniumArmorResistanceFloat;
	
	public static int ruboniumBootsProtectionInt;
	public static int ruboniumLeggingsProtectionInt;
	public static int ruboniumChestplateProtectionInt;
	public static int ruboniumHelmetProtectionInt;
	
	public static boolean ruboniumArmorHealthEffectBool;
	
	//[Obsidium]
	public static int obsidiumArmorDurabilityInt;
	public static int obsidiumArmorEnchantabilityInt;
	public static double obsidiumArmorToughnessFloat;
	public static double obsidiumArmorResistanceFloat;
	
	public static int obsidiumBootsProtectionInt;
	public static int obsidiumLeggingsProtectionInt;
	public static int obsidiumChestplateProtectionInt;
	public static int obsidiumHelmetProtectionInt;

	public static boolean obsidiumArmorFireEffectBool;
	
	//[Glass]
	public static int glassArmorDurabilityInt;
	public static int glassArmorEnchantabilityInt;
	public static double glassArmorToughnessFloat;
	public static double glassArmorResistanceFloat;
	
	public static int glassBootsProtectionInt;
	public static int glassLeggingsProtectionInt;
	public static int glassChestplateProtectionInt;
	public static int glassHelmetProtectionInt;
	
	public static boolean glassArmorSpeedEffectBool;
	
	//(Tools)
	//[Emeronium]
	public static int emeroniumHarvestLevelInt;
	public static int emeroniumToolsDurabilityInt;
	public static double emeroniumToolsEfficiencyFloat;
	public static double emeroniumToolsDamageFloat;
	public static int emeroniumToolsEnchantabilityInt;
	
	//[Endonium]
	public static int endoniumHarvestLevelInt;
	public static int endoniumToolsDurabilityInt;
	public static double endoniumToolsEfficiencyFloat;
	public static double endoniumToolsDamageFloat;
	public static int endoniumToolsEnchantabilityInt;
	
	//[Endonium Crystal]
	public static int endoniumCrystalHarvestLevelInt;
	public static int endoniumCrystalToolsDurabilityInt;
	public static double endoniumCrystalToolsEfficiencyFloat;
	public static double endoniumCrystalToolsDamageFloat;
	public static int endoniumCrystalToolsEnchantabilityInt;
	
	//[Saphonium]
	public static int saphoniumHarvestLevelInt;
	public static int saphoniumToolsDurabilityInt;
	public static double saphoniumToolsEfficiencyFloat;
	public static double saphoniumToolsDamageFloat;
	public static int saphoniumToolsEnchantabilityInt;
	
	//[Rubonium]
	public static int ruboniumHarvestLevelInt;
	public static int ruboniumToolsDurabilityInt;
	public static double ruboniumToolsEfficiencyFloat;
	public static double ruboniumToolsDamageFloat;
	public static int ruboniumToolsEnchantabilityInt;
	
	//[Obsidium]
	public static int obsidiumHarvestLevelInt;
	public static int obsidiumToolsDurabilityInt;
	public static double obsidiumToolsEfficiencyFloat;
	public static double obsidiumToolsDamageFloat;
	public static int obsidiumToolsEnchantabilityInt;
	
	//[Glass]
	public static int glassHarvestLevelInt;
	public static int glassToolsDurabilityInt;
	public static double glassToolsEfficiencyFloat;
	public static double glassToolsDamageFloat;
	public static int glassToolsEnchantabilityInt;
	
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
	
	private static final int defaultCopperVeinSize = 8;
	private static final int defaultCopperMinY = 1;
	private static final int defaultCopperMaxY = 63;
	private static final int defaultCopperVeinsPerChunk = 12;
	
	private static final int defaultLeadVeinSize = 6;
	private static final int defaultLeadMinY = 1;
	private static final int defaultLeadMaxY = 63;
	private static final int defaultLeadVeinsPerChunk = 10;
	
	private static final int defaultTinVeinSize = 8;
	private static final int defaultTinMinY = 1;
	private static final int defaultTinMaxY = 63;
	private static final int defaultTinVeinsPerChunk = 12;
	
	private static final int defaultSilverVeinSize = 6;
	private static final int defaultSilverMinY = 1;
	private static final int defaultSilverMaxY = 32;
	private static final int defaultSilverVeinsPerChunk = 6;
	
	private static final int defaultRubyVeinSize = 4;
	private static final int defaultRubyMinY = 1;
	private static final int defaultRubyMaxY = 32;
	private static final int defaultRubyVeinsPerChunk = 4;
	
	private static final int defaultSapphireVeinSize = 4;
	private static final int defaultSapphireMinY = 1;
	private static final int defaultSapphireMaxY = 32;
	private static final int defaultSapphireVeinsPerChunk = 4;
	
	private static final int defaultEnderVeinSize = 20;
	private static final int defaultEnderMinY = 0;
	private static final int defaultEnderMaxY = 255;
	private static final int defaultEnderVeinsPerChunk = 18;
	
	//Machine Energy Config
	//(Basic)
	private static final int defaultBasicFurnaceCapacity = 256000;
	private static final int defaultBasicFurnaceReceive = 4096;
	private static final int defaultBasicCoalGeneratorCapacity = 2560000;
	private static final int defaultBasicCoalGeneratorExtract = 256000;

	private static final int defaultBasicFurnaceWorkTime = 200;
	private static final int defaultBasicFurnaceEnergyPerTick = 50;
	private static final int defaultBasicCoalGeneratorPowerGen = 100;
	
	//(Advanced)
	private static final int defaultAdvancedFurnaceCapacity = 512000;
	private static final int defaultAdvancedFurnaceReceive = 8192;
	private static final int defaultAdvancedCoalGeneratorCapacity = 5120000;
	private static final int defaultAdvancedCoalGeneratorExtract = 512000;
	
	private static final int defaultAdvancedFurnaceWorkTime = 150;
	private static final int defaultAdvancedFurnaceEnergyPerTick = 100;
	private static final int defaultAdvancedCoalGeneratorPowerGen = 200;
	
	//(Tier 1)
	private static final int defaultT1CrusherCapacity = 192000;
	private static final int defaultT1CrusherReceive = 4096;
	private static final int defaultT1EnergyCubeCapacity = 1920000;
	private static final int defaultT1EnergyCubeTransfer = 192000;
	private static final int defaultT1InfuserCapacity = 192000;
	private static final int defaultT1InfuserReceive = 4096;
	private static final int defaultT1OreWasherEnergyCapacity = 192000;
	private static final int defaultT1OreWasherReceive = 4096;
	private static final int defaultT1PoweredSieveCapacity = 192000;
	private static final int defaultT1PoweredSieveReceive = 4096;
	private static final int defaultT1PressCapacity = 192000;
	private static final int defaultT1PressReceive = 4096;
	private static final int defaultT1SlurryProcessorEnergyCapacity = 192000;
	private static final int defaultT1SlurryProcessorReceive = 4096;
	
	private static final int defaultT1CrusherWorkTime = 200;
	private static final int defaultT1CrusherEnergyPerTick = 100;
	private static final int defaultT1InfuserWorkTime = 200;
	private static final int defaultT1InfuserEnergyPerTick = 100;
	private static final int defaultT1OreWasherWorkTime = 200;
	private static final int defaultT1OreWasherEnergyPerTick = 100;
	private static final int defaultT1PoweredSieveWorkTime = 200;
	private static final int defaultT1PoweredSieveEnergyPerTick = 100;
	private static final int defaultT1PressWorkTime = 200;
	private static final int defaultT1PressEnergyPerTick = 100;
	private static final int defaultT1SlurryProcessorWorkTime = 200;
	private static final int defaultT1SlurryProcessorEnergyPerTick = 100;
	
	//(Tier 2)
	private static final int defaultT2CrusherCapacity = 256000;
	private static final int defaultT2CrusherReceive = 5120;
	private static final int defaultT2EnergyCubeCapacity = 2560000;
	private static final int defaultT2EnergyCubeTransfer = 256000;
	private static final int defaultT2InfuserCapacity = 256000;
	private static final int defaultT2InfuserReceive = 5120;
	private static final int defaultT2OreWasherEnergyCapacity = 256000;
	private static final int defaultT2OreWasherReceive = 6144;
	private static final int defaultT2PoweredSieveCapacity = 256000;
	private static final int defaultT2PoweredSieveReceive = 5120;
	private static final int defaultT2PressCapacity = 256000;
	private static final int defaultT2PressReceive = 5120;
	private static final int defaultT2SlurryProcessorEnergyCapacity = 256000;
	private static final int defaultT2SlurryProcessorReceive = 5120;
	
	private static final int defaultT2CrusherWorkTime = 180;
	private static final int defaultT2CrusherEnergyPerTick = 120;
	private static final int defaultT2InfuserWorkTime = 180;
	private static final int defaultT2InfuserEnergyPerTick = 120;
	private static final int defaultT2OreWasherWorkTime = 180;
	private static final int defaultT2OreWasherEnergyPerTick = 120;
	private static final int defaultT2PoweredSieveWorkTime = 180;
	private static final int defaultT2PoweredSieveEnergyPerTick = 120;
	private static final int defaultT2PressWorkTime = 180;
	private static final int defaultT2PressEnergyPerTick = 120;
	private static final int defaultT2SlurryProcessorWorkTime = 180;
	private static final int defaultT2SlurryProcessorEnergyPerTick = 120;
	
	//(Tier 3)
	private static final int defaultT3CrusherCapacity = 320000;
	private static final int defaultT3CrusherReceive = 6144;
	private static final int defaultT3EnergyCubeCapacity = 3200000;
	private static final int defaultT3EnergyCubeTransfer = 320000;
	private static final int defaultT3InfuserCapacity = 320000;
	private static final int defaultT3InfuserReceive = 6144;
	private static final int defaultT3OreWasherEnergyCapacity = 320000;
	private static final int defaultT3OreWasherReceive = 6144;
	private static final int defaultT3PoweredSieveCapacity = 320000;
	private static final int defaultT3PoweredSieveReceive = 6144;
	private static final int defaultT3PressCapacity = 320000;
	private static final int defaultT3PressReceive = 6144;
	private static final int defaultT3SlurryProcessorEnergyCapacity = 320000;
	private static final int defaultT3SlurryProcessorReceive = 6144;
	
	private static final int defaultT3CrusherWorkTime = 160;
	private static final int defaultT3CrusherEnergyPerTick = 140;
	private static final int defaultT3InfuserWorkTime = 160;
	private static final int defaultT3InfuserEnergyPerTick = 140;
	private static final int defaultT3OreWasherWorkTime = 160;
	private static final int defaultT3OreWasherEnergyPerTick = 140;
	private static final int defaultT3PoweredSieveWorkTime = 160;
	private static final int defaultT3PoweredSieveEnergyPerTick = 140;
	private static final int defaultT3PressWorkTime = 160;
	private static final int defaultT3PressEnergyPerTick = 140;
	private static final int defaultT3SlurryProcessorWorkTime = 160;
	private static final int defaultT3SlurryProcessorEnergyPerTick = 140;
	
	//(Tier 4)
	private static final int defaultT4CrusherCapacity = 384000;
	private static final int defaultT4CrusherReceive = 7168;
	private static final int defaultT4EnergyCubeCapacity = 3840000;
	private static final int defaultT4EnergyCubeTransfer = 384000;
	private static final int defaultT4InfuserCapacity = 384000;
	private static final int defaultT4InfuserReceive = 7168;
	private static final int defaultT4OreWasherEnergyCapacity = 384000;
	private static final int defaultT4OreWasherReceive = 7168;
	private static final int defaultT4PoweredSieveCapacity = 384000;
	private static final int defaultT4PoweredSieveReceive = 7168;
	private static final int defaultT4PressCapacity = 384000;
	private static final int defaultT4PressReceive = 7168;
	private static final int defaultT4SlurryProcessorEnergyCapacity = 384000;
	private static final int defaultT4SlurryProcessorReceive = 7168;
	
	private static final int defaultT4CrusherWorkTime = 140;
	private static final int defaultT4CrusherEnergyPerTick = 160;
	private static final int defaultT4InfuserWorkTime = 140;
	private static final int defaultT4InfuserEnergyPerTick = 160;
	private static final int defaultT4OreWasherWorkTime = 140;
	private static final int defaultT4OreWasherEnergyPerTick = 160;
	private static final int defaultT4PoweredSieveWorkTime = 140;
	private static final int defaultT4PoweredSieveEnergyPerTick = 160;
	private static final int defaultT4PressWorkTime = 140;
	private static final int defaultT4PressEnergyPerTick = 160;
	private static final int defaultT4SlurryProcessorWorkTime = 140;
	private static final int defaultT4SlurryProcessorEnergyPerTick = 160;
	
	//(Tier 5)
	private static final int defaultT5CrusherCapacity = 448000;
	private static final int defaultT5CrusherReceive = 8192;
	private static final int defaultT5EnergyCubeCapacity = 4480000;
	private static final int defaultT5EnergyCubeTransfer = 448000;
	private static final int defaultT5InfuserCapacity = 448000;
	private static final int defaultT5InfuserReceive = 8192;
	private static final int defaultT5OreWasherEnergyCapacity = 448000;
	private static final int defaultT5OreWasherReceive = 8192;
	private static final int defaultT5PoweredSieveCapacity = 448000;
	private static final int defaultT5PoweredSieveReceive = 8192;
	private static final int defaultT5PressCapacity = 448000;
	private static final int defaultT5PressReceive = 8192;
	private static final int defaultT5SlurryProcessorEnergyCapacity = 448000;
	private static final int defaultT5SlurryProcessorReceive = 8192;
	
	private static final int defaultT5CrusherWorkTime = 120;
	private static final int defaultT5CrusherEnergyPerTick = 180;
	private static final int defaultT5InfuserWorkTime = 120;
	private static final int defaultT5InfuserEnergyPerTick = 180;
	private static final int defaultT5OreWasherWorkTime = 120;
	private static final int defaultT5OreWasherEnergyPerTick = 180;
	private static final int defaultT5PoweredSieveWorkTime = 120;
	private static final int defaultT5PoweredSieveEnergyPerTick = 180;
	private static final int defaultT5PressWorkTime = 120;
	private static final int defaultT5PressEnergyPerTick = 180;
	private static final int defaultT5SlurryProcessorWorkTime = 120;
	private static final int defaultT5SlurryProcessorEnergyPerTick = 180;
	
	//(Tier 6)
	private static final int defaultT6CrusherCapacity = 512000;
	private static final int defaultT6CrusherReceive = 9216;
	private static final int defaultT6EnergyCubeCapacity = 5120000;
	private static final int defaultT6EnergyCubeTransfer = 512000;
	private static final int defaultT6InfuserCapacity = 512000;
	private static final int defaultT6InfuserReceive = 9216;
	private static final int defaultT6OreWasherEnergyCapacity = 512000;
	private static final int defaultT6OreWasherReceive = 9216;
	private static final int defaultT6PoweredSieveCapacity = 512000;
	private static final int defaultT6PoweredSieveReceive = 9216;
	private static final int defaultT6PressCapacity = 512000;
	private static final int defaultT6PressReceive = 9216;
	private static final int defaultT6SlurryProcessorEnergyCapacity = 512000;
	private static final int defaultT6SlurryProcessorReceive = 9216;
	
	private static final int defaultT6CrusherWorkTime = 100;
	private static final int defaultT6CrusherEnergyPerTick = 200;
	private static final int defaultT6InfuserWorkTime = 100;
	private static final int defaultT6InfuserEnergyPerTick = 200;
	private static final int defaultT6OreWasherWorkTime = 100;
	private static final int defaultT6OreWasherEnergyPerTick = 200;
	private static final int defaultT6PoweredSieveWorkTime = 100;
	private static final int defaultT6PoweredSieveEnergyPerTick = 200;
	private static final int defaultT6PressWorkTime = 100;
	private static final int defaultT6PressEnergyPerTick = 200;
	private static final int defaultT6SlurryProcessorWorkTime = 100;
	private static final int defaultT6SlurryProcessorEnergyPerTick = 200;
	
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
	
	//Item Config
	//(Mesh)
	private static final int defaultStringMeshDurability = 64;
	private static final int defaultReinforcedStringMeshDurability = 128;
	private static final int defaultIronMeshDurability = 256;
	private static final int defaultReinforcedIronMeshDurability = 512;
	private static final int defaultSteelMeshDurability = 1024;
	private static final int defaultReinforcedSteelMeshDurability = 2048;
	private static final int defaultDiamondMeshDurability = 4096;
	private static final int defaultReinforcedDiamondMeshDurability = 8192;
	private static final int defaultGemMeshDurability = 16384;
	private static final int defaultReinforcedGemMeshDurability = 32768;
	private static final int defaultEndoniumMeshDurability = 65536;
	private static final int defaultReinforcedEndoniumMeshDurability = 131072;
	
	//(Armor)
	public static final boolean defaultArmorEffects = true;
	
	//[Emeronium]
	public static final int defaultEmeroniumArmorDurability = 30;
	public static final int defaultEmeroniumArmorEnchantability = 12;
	public static final double defaultEmeroniumArmorToughness = 2.00;
	public static final double defaultEmeroniumArmorResistance = 0.05;
		
	public static final int defaultEmeroniumBootsProtection = 3;
	public static final int defaultEmeroniumLeggingsProtection = 5;
	public static final int defaultEmeroniumChestplateProtection = 7;
	public static final int defaultEmeroniumHelmetProtection = 4;
	
	public static final boolean defaultEmeroniumArmorHeroEffect = true;
		
	//[Endonium]
	public static final int defaultEndoniumArmorDurability = 37;
	public static final int defaultEndoniumArmorEnchantability = 14;
	public static final double defaultEndoniumArmorToughness = 3.00;
	public static final double defaultEndoniumArmorResistance = 0.20;
		
	public static final int defaultEndoniumBootsProtection = 4;
	public static final int defaultEndoniumLeggingsProtection = 7;
	public static final int defaultEndoniumChestplateProtection = 9;
	public static final int defaultEndoniumHelmetProtection = 7;
	
	public static final boolean defaultEndoniumArmorHealthEffect = true;
	public static final boolean defaultEndoniumArmorSpeedEffect = true;
	public static final boolean defaultEndoniumArmorHeroEffect = true;
	public static final boolean defaultEndoniumArmorFireEffect = true;
	public static final boolean defaultEndoniumArmorWaterEffect = true;
	public static final boolean defaultEndoniumArmorVisionEffect = true;
		
	//[Endonium Crystal]
	public static final int defaultEndoniumCrystalArmorDurability = 40;
	public static final int defaultEndoniumCrystalArmorEnchantability = 16;
	public static final double defaultEndoniumCrystalArmorToughness = 4.00;
	public static final double defaultEndoniumCrystalArmorResistance = 0.30;
		
	public static final int defaultEndoniumCrystalBootsProtection = 5;
	public static final int defaultEndoniumCrystalLeggingsProtection = 8;
	public static final int defaultEndoniumCrystalChestplateProtection = 10;
	public static final int defaultEndoniumCrystalHelmetProtection = 5;

	public static final boolean defaultEndoniumCrystalArmorHealthEffect = true;
	public static final boolean defaultEndoniumCrystalArmorFlightEffect = true;
	public static final boolean defaultEndoniumCrystalArmorSpeedEffect = true;
	public static final boolean defaultEndoniumCrystalArmorHeroEffect = true;
	public static final boolean defaultEndoniumCrystalArmorFireEffect = true;
	public static final boolean defaultEndoniumCrystalArmorWaterEffect = true;
	public static final boolean defaultEndoniumCrystalArmorVisionEffect = true;
		
	//[Saphonium]
	public static final int defaultSaphoniumArmorDurability = 30;
	public static final int defaultSaphoniumArmorEnchantability = 12;
	public static final double defaultSaphoniumArmorToughness = 2.00;
	public static final double defaultSaphoniumArmorResistance = 0.05;
		
	public static final int defaultSaphoniumBootsProtection = 3;
	public static final int defaultSaphoniumLeggingsProtection = 5;
	public static final int defaultSaphoniumChestplateProtection = 7;
	public static final int defaultSaphoniumHelmetProtection = 4;
	
	public static final boolean defaultSaphoniumArmorWaterEffect = true;
		
	//[Rubonium]
	public static final int defaultRuboniumArmorDurability = 30;
	public static final int defaultRuboniumArmorEnchantability = 12;
	public static final double defaultRuboniumArmorToughness = 2.00;
	public static final double defaultRuboniumArmorResistance = 0.05;
		
	public static final int defaultRuboniumBootsProtection = 3;
	public static final int defaultRuboniumLeggingsProtection = 5;
	public static final int defaultRuboniumChestplateProtection = 7;
	public static final int defaultRuboniumHelmetProtection = 4;
	
	public static final boolean defaultRuboniumArmorHealthEffect = true;
		
	//[Obsidium]
	public static final int defaultObsidiumArmorDurability = 30;
	public static final int defaultObsidiumArmorEnchantability = 12;
	public static final double defaultObsidiumArmorToughness = 2.00;
	public static final double defaultObsidiumArmorResistance = 0.10;
		
	public static final int defaultObsidiumBootsProtection = 3;
	public static final int defaultObsidiumLeggingsProtection = 5;
	public static final int defaultObsidiumChestplateProtection = 7;
	public static final int defaultObsidiumHelmetProtection = 4;

	public static final boolean defaultObsidiumArmorFireEffect = true;
		
	//[Glass]
	public static final int defaultGlassArmorDurability = 2;
	public static final int defaultGlassArmorEnchantability = 20;
	public static final double defaultGlassArmorToughness = 0.00;
	public static final double defaultGlassArmorResistance = 0.00;
		
	public static final int defaultGlassBootsProtection = 1;
	public static final int defaultGlassLeggingsProtection = 3;
	public static final int defaultGlassChestplateProtection = 4;
	public static final int defaultGlassHelmetProtection = 2;
	
	public static final boolean defaultGlassArmorSpeedEffect = true;
		
	//(Tools)
	//[Emeronium]
	public static final int defaultEmeroniumHarvestLevel = 3;
	public static final int defaultEmeroniumToolsDurability = 1400;
	public static final double defaultEmeroniumToolsEfficiency = 8.50;
	public static final double defaultEmeroniumToolsDamage = 3.75;
	public static final int defaultEmeroniumToolsEnchantability = 12;
		
	//[Endonium]
	public static final int defaultEndoniumHarvestLevel = 3;
	public static final int defaultEndoniumToolsDurability = 1800;
	public static final double defaultEndoniumToolsEfficiency = 9.00;
	public static final double defaultEndoniumToolsDamage = 5.00;
	public static final int defaultEndoniumToolsEnchantability = 14;
		
	//[Endonium Crystal]
	public static final int defaultEndoniumCrystalHarvestLevel = 4;
	public static final int defaultEndoniumCrystalToolsDurability = 2200;
	public static final double defaultEndoniumCrystalToolsEfficiency = 10.00;
	public static final double defaultEndoniumCrystalToolsDamage = 6.00;
	public static final int defaultEndoniumCrystalToolsEnchantability = 16;
		
	//[Saphonium]
	public static final int defaultSaphoniumHarvestLevel = 3;
	public static final int defaultSaphoniumToolsDurability = 1400;
	public static final double defaultSaphoniumToolsEfficiency = 8.50;
	public static final double defaultSaphoniumToolsDamage = 3.75;
	public static final int defaultSaphoniumToolsEnchantability = 12;
		
	//[Rubonium]
	public static final int defaultRuboniumHarvestLevel = 3;
	public static final int defaultRuboniumToolsDurability = 1400;
	public static final double defaultRuboniumToolsEfficiency = 8.50;
	public static final double defaultRuboniumToolsDamage = 3.75;
	public static final int defaultRuboniumToolsEnchantability = 12;
		
	//[Obsidium]
	public static final int defaultObsidiumHarvestLevel = 3;
	public static final int defaultObsidiumToolsDurability = 1600;
	public static final double defaultObsidiumToolsEfficiency = 6.00;
	public static final double defaultObsidiumToolsDamage = 4.00;
	public static final int defaultObsidiumToolsEnchantability = 12;
		
	//[Glass]
	public static final int defaultGlassHarvestLevel = 1;
	public static final int defaultGlassToolsDurability = 30;
	public static final double defaultGlassToolsEfficiency = 1.50;
	public static final double defaultGlassToolsDamage = 6.00;
	public static final int defaultGlassToolsEnchantability = 20;

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
	
	public static final ForgeConfigSpec.ConfigValue<Integer> copperVeinSize;
	public static final ForgeConfigSpec.ConfigValue<Integer> copperMinY;
	public static final ForgeConfigSpec.ConfigValue<Integer> copperMaxY;
	public static final ForgeConfigSpec.ConfigValue<Integer> copperVeinsPerChunk;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> leadVeinSize;
	public static final ForgeConfigSpec.ConfigValue<Integer> leadMinY;
	public static final ForgeConfigSpec.ConfigValue<Integer> leadMaxY;
	public static final ForgeConfigSpec.ConfigValue<Integer> leadVeinsPerChunk;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> tinVeinSize;
	public static final ForgeConfigSpec.ConfigValue<Integer> tinMinY;
	public static final ForgeConfigSpec.ConfigValue<Integer> tinMaxY;
	public static final ForgeConfigSpec.ConfigValue<Integer> tinVeinsPerChunk;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> silverVeinSize;
	public static final ForgeConfigSpec.ConfigValue<Integer> silverMinY;
	public static final ForgeConfigSpec.ConfigValue<Integer> silverMaxY;
	public static final ForgeConfigSpec.ConfigValue<Integer> silverVeinsPerChunk;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> rubyVeinSize;
	public static final ForgeConfigSpec.ConfigValue<Integer> rubyMinY;
	public static final ForgeConfigSpec.ConfigValue<Integer> rubyMaxY;
	public static final ForgeConfigSpec.ConfigValue<Integer> rubyVeinsPerChunk;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> sapphireVeinSize;
	public static final ForgeConfigSpec.ConfigValue<Integer> sapphireMinY;
	public static final ForgeConfigSpec.ConfigValue<Integer> sapphireMaxY;
	public static final ForgeConfigSpec.ConfigValue<Integer> sapphireVeinsPerChunk;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> enderVeinSize;
	public static final ForgeConfigSpec.ConfigValue<Integer> enderMinY;
	public static final ForgeConfigSpec.ConfigValue<Integer> enderMaxY;
	public static final ForgeConfigSpec.ConfigValue<Integer> enderVeinsPerChunk;
	
	//Machine Config Energy
	//(Basic)
	public static final ForgeConfigSpec.ConfigValue<Integer> basicFurnaceCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> basicFurnaceReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> basicCoalGeneratorCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> basicCoalGeneratorExtract;

	public static final ForgeConfigSpec.ConfigValue<Integer> basicFurnaceWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> basicFurnaceEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> basicCoalGeneratorPowerGen;

	//(Advanced)
	public static final ForgeConfigSpec.ConfigValue<Integer> advancedFurnaceCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> advancedFurnaceReceive;
	public static final ForgeConfigSpec.ConfigValue<Integer> advancedCoalGeneratorCapacity;
	public static final ForgeConfigSpec.ConfigValue<Integer> advancedCoalGeneratorExtract;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> advancedFurnaceWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> advancedFurnaceEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> advancedCoalGeneratorPowerGen;
	
	//(Tier 1)
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
	
	public static final ForgeConfigSpec.ConfigValue<Integer> t1CrusherWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1CrusherEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1InfuserWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1InfuserEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1OreWasherWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1OreWasherEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1PoweredSieveWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1PoweredSieveEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1PressWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1PressEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1SlurryProcessorWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t1SlurryProcessorEnergyPerTick;
	
	//(Tier 2)
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
	
	public static final ForgeConfigSpec.ConfigValue<Integer> t2CrusherWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2CrusherEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2InfuserWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2InfuserEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2OreWasherWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2OreWasherEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2PoweredSieveWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2PoweredSieveEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2PressWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2PressEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2SlurryProcessorWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t2SlurryProcessorEnergyPerTick;
	
	//(Tier 3)
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
	
	public static final ForgeConfigSpec.ConfigValue<Integer> t3CrusherWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3CrusherEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3InfuserWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3InfuserEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3OreWasherWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3OreWasherEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3PoweredSieveWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3PoweredSieveEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3PressWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3PressEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3SlurryProcessorWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t3SlurryProcessorEnergyPerTick;
	
	//(Tier 4)
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
	
	public static final ForgeConfigSpec.ConfigValue<Integer> t4CrusherWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4CrusherEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4InfuserWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4InfuserEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4OreWasherWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4OreWasherEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4PoweredSieveWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4PoweredSieveEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4PressWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4PressEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4SlurryProcessorWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t4SlurryProcessorEnergyPerTick;
	
	//(Tier 5)
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
	
	public static final ForgeConfigSpec.ConfigValue<Integer> t5CrusherWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5CrusherEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5InfuserWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5InfuserEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5OreWasherWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5OreWasherEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5PoweredSieveWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5PoweredSieveEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5PressWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5PressEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5SlurryProcessorWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t5SlurryProcessorEnergyPerTick;
	
	//(Tier 6)
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
	
	public static final ForgeConfigSpec.ConfigValue<Integer> t6CrusherWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6CrusherEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6InfuserWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6InfuserEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6OreWasherWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6OreWasherEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6PoweredSieveWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6PoweredSieveEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6PressWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6PressEnergyPerTick;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6SlurryProcessorWorkTime;
	public static final ForgeConfigSpec.ConfigValue<Integer> t6SlurryProcessorEnergyPerTick;
	
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
	
	//Item Config
	//(Mesh)
	public static final ForgeConfigSpec.ConfigValue<Integer> stringMeshDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> reinforcedStringMeshDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> ironMeshDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> reinforcedIronMeshDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> steelMeshDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> reinforcedSteelMeshDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> diamondMeshDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> reinforcedDiamondMeshDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> gemMeshDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> reinforcedGemMeshDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumMeshDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> reinforcedEndoniumMeshDurability;
	
	//(Armor)
	public static final ForgeConfigSpec.ConfigValue<Boolean> armorEffects;
	
	//[Emeronium]
	public static final ForgeConfigSpec.ConfigValue<Integer> emeroniumArmorDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> emeroniumArmorEnchantability;
	public static final ForgeConfigSpec.ConfigValue<Double> emeroniumArmorToughness;
	public static final ForgeConfigSpec.ConfigValue<Double> emeroniumArmorResistance;
		
	public static final ForgeConfigSpec.ConfigValue<Integer> emeroniumBootsProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> emeroniumLeggingsProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> emeroniumChestplateProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> emeroniumHelmetProtection;
	
	public static final ForgeConfigSpec.ConfigValue<Boolean> emeroniumArmorHeroEffect;
		
	//[Endonium]
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumArmorDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumArmorEnchantability;
	public static final ForgeConfigSpec.ConfigValue<Double> endoniumArmorToughness;
	public static final ForgeConfigSpec.ConfigValue<Double> endoniumArmorResistance;
		
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumBootsProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumLeggingsProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumChestplateProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumHelmetProtection;
	
	public static final ForgeConfigSpec.ConfigValue<Boolean> endoniumArmorHealthEffect;
	public static final ForgeConfigSpec.ConfigValue<Boolean> endoniumArmorSpeedEffect;
	public static final ForgeConfigSpec.ConfigValue<Boolean> endoniumArmorHeroEffect;
	public static final ForgeConfigSpec.ConfigValue<Boolean> endoniumArmorFireEffect;
	public static final ForgeConfigSpec.ConfigValue<Boolean> endoniumArmorWaterEffect;
	public static final ForgeConfigSpec.ConfigValue<Boolean> endoniumArmorVisionEffect;
		
	//[Endonium Crystal]
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumCrystalArmorDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumCrystalArmorEnchantability;
	public static final ForgeConfigSpec.ConfigValue<Double> endoniumCrystalArmorToughness;
	public static final ForgeConfigSpec.ConfigValue<Double> endoniumCrystalArmorResistance;
		
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumCrystalBootsProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumCrystalLeggingsProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumCrystalChestplateProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumCrystalHelmetProtection;

	public static final ForgeConfigSpec.ConfigValue<Boolean> endoniumCrystalArmorHealthEffect;
	public static final ForgeConfigSpec.ConfigValue<Boolean> endoniumCrystalArmorFlightEffect;
	public static final ForgeConfigSpec.ConfigValue<Boolean> endoniumCrystalArmorSpeedEffect;
	public static final ForgeConfigSpec.ConfigValue<Boolean> endoniumCrystalArmorHeroEffect;
	public static final ForgeConfigSpec.ConfigValue<Boolean> endoniumCrystalArmorFireEffect;
	public static final ForgeConfigSpec.ConfigValue<Boolean> endoniumCrystalArmorWaterEffect;
	public static final ForgeConfigSpec.ConfigValue<Boolean> endoniumCrystalArmorVisionEffect;
		
	//[Saphonium]
	public static final ForgeConfigSpec.ConfigValue<Integer> saphoniumArmorDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> saphoniumArmorEnchantability;
	public static final ForgeConfigSpec.ConfigValue<Double> saphoniumArmorToughness;
	public static final ForgeConfigSpec.ConfigValue<Double> saphoniumArmorResistance;
		
	public static final ForgeConfigSpec.ConfigValue<Integer> saphoniumBootsProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> saphoniumLeggingsProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> saphoniumChestplateProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> saphoniumHelmetProtection;
	
	public static final ForgeConfigSpec.ConfigValue<Boolean> saphoniumArmorWaterEffect;
		
	//[Rubonium]
	public static final ForgeConfigSpec.ConfigValue<Integer> ruboniumArmorDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> ruboniumArmorEnchantability;
	public static final ForgeConfigSpec.ConfigValue<Double> ruboniumArmorToughness;
	public static final ForgeConfigSpec.ConfigValue<Double> ruboniumArmorResistance;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> ruboniumBootsProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> ruboniumLeggingsProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> ruboniumChestplateProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> ruboniumHelmetProtection;
	
	public static final ForgeConfigSpec.ConfigValue<Boolean> ruboniumArmorHealthEffect;
	
	//[Obsidium]
	public static final ForgeConfigSpec.ConfigValue<Integer> obsidiumArmorDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> obsidiumArmorEnchantability;
	public static final ForgeConfigSpec.ConfigValue<Double> obsidiumArmorToughness;
	public static final ForgeConfigSpec.ConfigValue<Double> obsidiumArmorResistance;
		
	public static final ForgeConfigSpec.ConfigValue<Integer> obsidiumBootsProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> obsidiumLeggingsProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> obsidiumChestplateProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> obsidiumHelmetProtection;

	public static final ForgeConfigSpec.ConfigValue<Boolean> obsidiumArmorFireEffect;
		
	//[Glass]
	public static final ForgeConfigSpec.ConfigValue<Integer> glassArmorDurability;
	public static final ForgeConfigSpec.ConfigValue<Integer> glassArmorEnchantability;
	public static final ForgeConfigSpec.ConfigValue<Double> glassArmorToughness;
	public static final ForgeConfigSpec.ConfigValue<Double> glassArmorResistance;
		
	public static final ForgeConfigSpec.ConfigValue<Integer> glassBootsProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> glassLeggingsProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> glassChestplateProtection;
	public static final ForgeConfigSpec.ConfigValue<Integer> glassHelmetProtection;
	
	public static final ForgeConfigSpec.ConfigValue<Boolean> glassArmorSpeedEffect;
		
	//(Tools)
	//[Emeronium]
	public static final ForgeConfigSpec.ConfigValue<Integer> emeroniumHarvestLevel;
	public static final ForgeConfigSpec.ConfigValue<Integer> emeroniumToolsDurability;
	public static final ForgeConfigSpec.ConfigValue<Double> emeroniumToolsEfficiency;
	public static final ForgeConfigSpec.ConfigValue<Double> emeroniumToolsDamage;
	public static final ForgeConfigSpec.ConfigValue<Integer> emeroniumToolsEnchantability;
		
	//[Endonium]
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumHarvestLevel;
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumToolsDurability;
	public static final ForgeConfigSpec.ConfigValue<Double> endoniumToolsEfficiency;
	public static final ForgeConfigSpec.ConfigValue<Double> endoniumToolsDamage;
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumToolsEnchantability;
	
	//[Endonium Crystal]
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumCrystalHarvestLevel;
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumCrystalToolsDurability;
	public static final ForgeConfigSpec.ConfigValue<Double> endoniumCrystalToolsEfficiency;
	public static final ForgeConfigSpec.ConfigValue<Double> endoniumCrystalToolsDamage;
	public static final ForgeConfigSpec.ConfigValue<Integer> endoniumCrystalToolsEnchantability;
	
	//[Saphonium]
	public static final ForgeConfigSpec.ConfigValue<Integer> saphoniumHarvestLevel;
	public static final ForgeConfigSpec.ConfigValue<Integer> saphoniumToolsDurability;
	public static final ForgeConfigSpec.ConfigValue<Double> saphoniumToolsEfficiency;
	public static final ForgeConfigSpec.ConfigValue<Double> saphoniumToolsDamage;
	public static final ForgeConfigSpec.ConfigValue<Integer> saphoniumToolsEnchantability;
	
	//[Rubonium]
	public static final ForgeConfigSpec.ConfigValue<Integer> ruboniumHarvestLevel;
	public static final ForgeConfigSpec.ConfigValue<Integer> ruboniumToolsDurability;
	public static final ForgeConfigSpec.ConfigValue<Double> ruboniumToolsEfficiency;
	public static final ForgeConfigSpec.ConfigValue<Double> ruboniumToolsDamage;
	public static final ForgeConfigSpec.ConfigValue<Integer> ruboniumToolsEnchantability;
	
	//[Obsidium]
	public static final ForgeConfigSpec.ConfigValue<Integer> obsidiumHarvestLevel;
	public static final ForgeConfigSpec.ConfigValue<Integer> obsidiumToolsDurability;
	public static final ForgeConfigSpec.ConfigValue<Double> obsidiumToolsEfficiency;
	public static final ForgeConfigSpec.ConfigValue<Double> obsidiumToolsDamage;
	public static final ForgeConfigSpec.ConfigValue<Integer> obsidiumToolsEnchantability;
	
	//[Glass]
	public static final ForgeConfigSpec.ConfigValue<Integer> glassHarvestLevel;
	public static final ForgeConfigSpec.ConfigValue<Integer> glassToolsDurability;
	public static final ForgeConfigSpec.ConfigValue<Double> glassToolsEfficiency;
	public static final ForgeConfigSpec.ConfigValue<Double> glassToolsDamage;
	public static final ForgeConfigSpec.ConfigValue<Integer> glassToolsEnchantability;

	static {
		
		MECHANICRAFT_BUILDER.push("OVERWORLD GENERATION");
		//World Gen
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
		
		copperVeinSize = MECHANICRAFT_BUILDER.comment("Copper Ore Vein Size Max Size, minimum is 1, maximum is 50(DEFAULT: 8)")
				.worldRestart().defineInRange("Copper Ore Vein Size: ", defaultCopperVeinSize, 1, 50);
		
		copperMinY = MECHANICRAFT_BUILDER.comment("Copper Ore Lowest Y Value, minimum is 1, maximum is 256(DEFAULT: 1)")
				.worldRestart().defineInRange("Copper Ore Min Y: ", defaultCopperMinY, 1, 256);
		
		copperMaxY = MECHANICRAFT_BUILDER.comment("Copper Ore Highest Y Value, minimum is 1, maximum is 256(DEFAULT: 63)")
				.worldRestart().defineInRange("Copper Ore Max Y: ", defaultCopperMaxY, 1, 256);
		
		copperVeinsPerChunk = MECHANICRAFT_BUILDER.comment("Copper Ore Max Veins in Chunk, minimum is 1, maximum is 50(DEFAULT: 12)")
				.worldRestart().defineInRange("Copper Ore Max Veins: ", defaultCopperVeinsPerChunk, 1, 50);
		
		leadVeinSize = MECHANICRAFT_BUILDER.comment("Lead Ore Vein Size Max Size, minimum is 1, maximum is 50(DEFAULT: 6)")
				.worldRestart().defineInRange("Copper Ore Vein Size: ", defaultLeadVeinSize, 1, 50);
		
		leadMinY = MECHANICRAFT_BUILDER.comment("Copper Ore Lowest Y Value, minimum is 1, maximum is 256(DEFAULT: 1)")
				.worldRestart().defineInRange("Copper Ore Min Y: ", defaultLeadMinY, 1, 256);
		
		leadMaxY = MECHANICRAFT_BUILDER.comment("Copper Ore Highest Y Value, minimum is 1, maximum is 256(DEFAULT: 63)")
				.worldRestart().defineInRange("Copper Ore Max Y: ", defaultLeadMaxY, 1, 256);
		
		leadVeinsPerChunk = MECHANICRAFT_BUILDER.comment("Copper Ore Max Veins in Chunk, minimum is 1, maximum is 50(DEFAULT: 10)")
				.worldRestart().defineInRange("Copper Ore Max Veins: ", defaultLeadVeinsPerChunk, 1, 50);
		
		tinVeinSize = MECHANICRAFT_BUILDER.comment("Tin Ore Vein Size Max Size, minimum is 1, maximum is 50(DEFAULT: 8)")
				.worldRestart().defineInRange("Tin Ore Vein Size: ", defaultTinVeinSize, 1, 50);
		
		tinMinY = MECHANICRAFT_BUILDER.comment("Tin Ore Lowest Y Value, minimum is 1, maximum is 256(DEFAULT: 1)")
				.worldRestart().defineInRange("Tin Ore Min Y: ", defaultTinMinY, 1, 256);
		
		tinMaxY = MECHANICRAFT_BUILDER.comment("Tin Ore Highest Y Value, minimum is 1, maximum is 256(DEFAULT: 63)")
				.worldRestart().defineInRange("Tin Ore Max Y: ", defaultTinMaxY, 1, 256);
		
		tinVeinsPerChunk = MECHANICRAFT_BUILDER.comment("Tin Ore Max Veins in Chunk, minimum is 1, maximum is 50(DEFAULT: 12)")
				.worldRestart().defineInRange("Tin Ore Max Veins: ", defaultTinVeinsPerChunk, 1, 50);
		
		silverVeinSize = MECHANICRAFT_BUILDER.comment("Silver Ore Vein Size Max Size, minimum is 1, maximum is 50(DEFAULT: 6)")
				.worldRestart().defineInRange("Silver Ore Vein Size: ", defaultSilverVeinSize, 1, 50);
		
		silverMinY = MECHANICRAFT_BUILDER.comment("Silver Ore Lowest Y Value, minimum is 1, maximum is 256(DEFAULT: 1)")
				.worldRestart().defineInRange("Silver Ore Min Y: ", defaultSilverMinY, 1, 256);
		
		silverMaxY = MECHANICRAFT_BUILDER.comment("Silver Ore Highest Y Value, minimum is 1, maximum is 256(DEFAULT: 32)")
				.worldRestart().defineInRange("Silver Ore Max Y: ", defaultSilverMaxY, 1, 256);
		
		silverVeinsPerChunk = MECHANICRAFT_BUILDER.comment("Silver Ore Max Veins in Chunk, minimum is 1, maximum is 50(DEFAULT: 6)")
				.worldRestart().defineInRange("Silver Ore Max Veins: ", defaultSilverVeinsPerChunk, 1, 50);
		
		rubyVeinSize = MECHANICRAFT_BUILDER.comment("Ruby Ore Vein Size Max Size, minimum is 1, maximum is 50(DEFAULT: 4)")
				.worldRestart().defineInRange("Ruby Ore Vein Size: ", defaultRubyVeinSize, 1, 50);
		
		rubyMinY = MECHANICRAFT_BUILDER.comment("Ruby Ore Lowest Y Value, minimum is 1, maximum is 256(DEFAULT: 1)")
				.worldRestart().defineInRange("Ruby Ore Min Y: ", defaultRubyMinY, 1, 256);
		
		rubyMaxY = MECHANICRAFT_BUILDER.comment("Ruby Ore Highest Y Value, minimum is 1, maximum is 256(DEFAULT: 32)")
				.worldRestart().defineInRange("Ruby Ore Max Y: ", defaultRubyMaxY, 1, 256);
		
		rubyVeinsPerChunk = MECHANICRAFT_BUILDER.comment("Ruby Ore Max Veins in Chunk, minimum is 1, maximum is 50(DEFAULT: 4)")
				.worldRestart().defineInRange("Ruby Ore Max Veins: ", defaultRubyVeinsPerChunk, 1, 50);
		
		sapphireVeinSize = MECHANICRAFT_BUILDER.comment("Sapphire Ore Vein Size Max Size, minimum is 1, maximum is 50(DEFAULT: 4)")
				.worldRestart().defineInRange("Sapphire Ore Vein Size: ", defaultSapphireVeinSize, 1, 50);
		
		sapphireMinY = MECHANICRAFT_BUILDER.comment("Sapphire Ore Lowest Y Value, minimum is 1, maximum is 256(DEFAULT: 1)")
				.worldRestart().defineInRange("Sapphire Ore Min Y: ", defaultSapphireMinY, 1, 256);
		
		sapphireMaxY = MECHANICRAFT_BUILDER.comment("Sapphire Ore Highest Y Value, minimum is 1, maximum is 256(DEFAULT: 32)")
				.worldRestart().defineInRange("Sapphire Ore Max Y: ", defaultSapphireMaxY, 1, 256);
		
		sapphireVeinsPerChunk = MECHANICRAFT_BUILDER.comment("Sapphire Ore Max Veins in Chunk, minimum is 1, maximum is 50(DEFAULT: 4)")
				.worldRestart().defineInRange("Sapphire Ore Max Veins: ", defaultSapphireVeinsPerChunk, 1, 50);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("END GENERATION");
		
		enderGen = MECHANICRAFT_BUILDER.comment("Ender Ore Generation, true is enabled, false is disabled(DEFAULT: true)")
				.worldRestart().define("Ender Ore Generation enabled: ", defaultEnderGen);
		
		enderVeinSize = MECHANICRAFT_BUILDER.comment("Ender Ore Vein Size Max Size, minimum is 1, maximum is 50(DEFAULT: 20)")
				.worldRestart().defineInRange("Ender Ore Vein Size: ", defaultEnderVeinSize, 1, 50);
		
		enderMinY = MECHANICRAFT_BUILDER.comment("Ender Ore Lowest Y Value, minimum is 1, maximum is 256(DEFAULT: 1)")
				.worldRestart().defineInRange("Ender Ore Min Y: ", defaultEnderMinY, 1, 256);
		
		enderMaxY = MECHANICRAFT_BUILDER.comment("Ender Ore Highest Y Value, minimum is 1, maximum is 256(DEFAULT: 256)")
				.worldRestart().defineInRange("Ender Ore Max Y: ", defaultEnderMaxY, 1, 256);
		
		enderVeinsPerChunk = MECHANICRAFT_BUILDER.comment("Ender Ore Max Veins in Chunk, minimum is 1, maximum is 50(DEFAULT: 18)")
				.worldRestart().defineInRange("Ender Ore Max Veins: ", defaultEnderVeinsPerChunk, 1, 50);
		
		MECHANICRAFT_BUILDER.pop();
		//Machine Config
		MECHANICRAFT_BUILDER.push("BASIC MACHINE SETTINGS");
		
		basicFurnaceCapacity = MECHANICRAFT_BUILDER.comment("Basic Furnace Capacity, minimum is 1, maximum is 1024000(DEFAULT: 25600)")
				.worldRestart().defineInRange("Basic Furnace Capacity: ", defaultBasicFurnaceCapacity, 1, 1024000);
		
		basicFurnaceReceive = MECHANICRAFT_BUILDER.comment("Basic Furnace Receive, minimum is 1, maximum is 1024000(DEFAULT: 4096)")
				.worldRestart().defineInRange("Basic Furnace Receive: ", defaultBasicFurnaceReceive, 1, 1024000);
		
		basicCoalGeneratorCapacity = MECHANICRAFT_BUILDER.comment("Basic Coal Generator Capacity, minimum is 1, maximum is 10240000(DEFAULT: 2560000)")
				.worldRestart().defineInRange("Basic Coal Generator Capacity: ", defaultBasicCoalGeneratorCapacity, 1, 10240000);
		
		basicCoalGeneratorExtract = MECHANICRAFT_BUILDER.comment("Basic Coal Generator Extract, minimum is 1, maximum is 1024000(DEFAULT: 256000)")
				.worldRestart().defineInRange("Basic Coal Generator Extract: ", defaultBasicCoalGeneratorExtract, 1, 1024000);
		
		basicFurnaceWorkTime = MECHANICRAFT_BUILDER.comment("Basic Furnace Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 200)")
				.worldRestart().defineInRange("Basic Furnace Work Time: ", defaultBasicFurnaceWorkTime, 1, 1000);
		
		basicFurnaceEnergyPerTick = MECHANICRAFT_BUILDER.comment("Basic Furnace Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 50)")
				.worldRestart().defineInRange("Basic Furnace Energy Consumed: ", defaultBasicFurnaceEnergyPerTick, 1, 8192);
		
		basicCoalGeneratorPowerGen = MECHANICRAFT_BUILDER.comment("Basic Coal Generator Power Gen Per Tick, minimum is 1, maximum is 10240(DEFAULT: 100)")
				.worldRestart().defineInRange("Basic Coal Generator Power Gen: ", defaultBasicCoalGeneratorPowerGen, 1, 10240);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("ADVACNED MACHINE SETTINGS");
		
		advancedFurnaceCapacity = MECHANICRAFT_BUILDER.comment("Advanced Furnace Capacity, minimum is 1, maximum is 1024000(DEFAULT: 512000)")
				.worldRestart().defineInRange("Advanced Furnace Capacity: ", defaultAdvancedFurnaceCapacity, 1, 1024000);
		
		advancedFurnaceReceive = MECHANICRAFT_BUILDER.comment("Advanced Furnace Receive, minimum is 1, maximum is 1024000(DEFAULT: 8192)")
				.worldRestart().defineInRange("Advanced Furnace Receive: ", defaultAdvancedFurnaceReceive, 1, 1024000);
		
		advancedCoalGeneratorCapacity = MECHANICRAFT_BUILDER.comment("Advanced Coal Generator Capacity, minimum is 1, maximum is 10240000(DEFAULT: 5120000)")
				.worldRestart().defineInRange("Advanced Coal Generator Capacity: ", defaultAdvancedCoalGeneratorCapacity, 1, 10240000);
		
		advancedCoalGeneratorExtract = MECHANICRAFT_BUILDER.comment("Advanced Coal Generator Extract, minimum is 1, maximum is 1024000(DEFAULT: 512000)")
				.worldRestart().defineInRange("Advanced Coal Generator Extract: ", defaultAdvancedCoalGeneratorExtract, 1, 1024000);
		
		advancedFurnaceWorkTime = MECHANICRAFT_BUILDER.comment("Advanced Furnace Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 150)")
				.worldRestart().defineInRange("Advanced Furnace Work Time: ", defaultAdvancedFurnaceWorkTime, 1, 1000);
		
		advancedFurnaceEnergyPerTick = MECHANICRAFT_BUILDER.comment("Advanced Furnace Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 100)")
				.worldRestart().defineInRange("Advanced Furnace Energy Consumed: ", defaultAdvancedFurnaceEnergyPerTick, 1, 8192);
		
		advancedCoalGeneratorPowerGen = MECHANICRAFT_BUILDER.comment("Advanced Coal Generator Power Gen Per Tick, minimum is 1, maximum is 8192(DEFAULT: 200)")
				.worldRestart().defineInRange("Advanced Coal Generator Power Gen: ", defaultAdvancedCoalGeneratorPowerGen, 1, 8192);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 1 MACHINE SETTINGS");
		
		t1CrusherCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Crusher Capacity, minimum is 1, maximum is 1024000(DEFAULT: 192000)")
				.worldRestart().defineInRange("Tier 1 Crusher Capacity: ", defaultT1CrusherCapacity, 1, 1024000);
		
		t1CrusherReceive = MECHANICRAFT_BUILDER.comment("Tier 1 Crusher Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 4096)")
				.worldRestart().defineInRange("Tier 1 Crusher Energy Receive: ", defaultT1CrusherReceive, 1, 1024000);
		
		t1CrusherWorkTime = MECHANICRAFT_BUILDER.comment("Tier 1 Crusher Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 200)")
				.worldRestart().defineInRange("Tier 1 Crusher Work Time: ", defaultT1CrusherWorkTime, 1, 1000);
		
		t1CrusherEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 1 Crusher Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 100)")
				.worldRestart().defineInRange("Tier 1 Crusher Energy Consumed: ", defaultT1CrusherEnergyPerTick, 1, 8192);
		
		t1EnergyCubeCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Energy Cube Capacity, minimum is 1, maximum is 10240000(DEFAULT: 1920000)")
				.worldRestart().defineInRange("Tier 1 Energy Cube Capacity: ", defaultT1EnergyCubeCapacity, 1, 10240000);
		
		t1EnergyCubeTransfer = MECHANICRAFT_BUILDER.comment("Tier 1 Energy Cube Energy Transfer, minimum is 1, maximum is 1024000(DEFAULT: 192000)")
				.worldRestart().defineInRange("Tier 1 Energy Cube Transfer: ", defaultT1EnergyCubeTransfer, 1, 1024000);
		
		t1InfuserCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Metallic Infuser Capacity, minimum is 1, maximum is 1024000(DEFAULT: 192000)")
				.worldRestart().defineInRange("Tier 1 Metallic Infuser Capacity: ", defaultT1InfuserCapacity, 1, 1024000);
		
		t1InfuserReceive = MECHANICRAFT_BUILDER.comment("Tier 1 Metallic Infuser Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 4096)")
				.worldRestart().defineInRange("Tier 1 Metallic Infuser Energy Receive: ", defaultT1InfuserReceive, 1, 1024000);
		
		t1InfuserWorkTime = MECHANICRAFT_BUILDER.comment("Tier 1 Metallic Infuser Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 200)")
				.worldRestart().defineInRange("Tier 1 Metallic Infuser Work Time: ", defaultT1InfuserWorkTime, 1, 1000);
		
		t1InfuserEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 1 Metallic Infuser Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 100)")
				.worldRestart().defineInRange("Tier 1 Metallic Infuser Energy Consumed: ", defaultT1InfuserEnergyPerTick, 1, 8192);
		
		t1OreWasherEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Ore Washer Energy Capacity, minimum is 1, maximum is 1024000(DEFAULT: 192000)")
				.worldRestart().defineInRange("Tier 1 Ore Washer Energy Capacity: ", defaultT1OreWasherEnergyCapacity, 1, 1024000);
		
		t1OreWasherReceive = MECHANICRAFT_BUILDER.comment("Tier 1 Ore Washer Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 4096)")
				.worldRestart().defineInRange("Tier 1 Ore Washer Energy Receive: ", defaultT1OreWasherReceive, 1, 1024000);
		
		t1OreWasherWorkTime = MECHANICRAFT_BUILDER.comment("Tier 1 Ore Washer Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 200)")
				.worldRestart().defineInRange("Tier 1 Ore Washer Work Time: ", defaultT1OreWasherWorkTime, 1, 1000);
		
		t1OreWasherEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 1 Ore Washer Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 100)")
				.worldRestart().defineInRange("Tier 1 Ore Washer Energy Consumed: ", defaultT1OreWasherEnergyPerTick, 1, 8192);
		
		t1PoweredSieveCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Powered Sieve Capacity, minimum is 1, maximum is 1024000(DEFAULT: 192000)")
				.worldRestart().defineInRange("Tier 1 Powered Sieve Capacity: ", defaultT1PoweredSieveCapacity, 1, 1024000);
		
		t1PoweredSieveReceive = MECHANICRAFT_BUILDER.comment("Tier 1 Powered Sieve Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 4096)")
				.worldRestart().defineInRange("Tier 1 Powered Sieve Energy Receive: ", defaultT1PoweredSieveReceive, 1, 1024000);

		t1PoweredSieveWorkTime = MECHANICRAFT_BUILDER.comment("Tier 1 Powered Sieve Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 200)")
				.worldRestart().defineInRange("Tier 1 Powered Sieve Work Time: ", defaultT1PoweredSieveWorkTime, 1, 1000);
		
		t1PoweredSieveEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 1 Powered Sieve Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 100)")
				.worldRestart().defineInRange("Tier 1 Powered Sieve Energy Consumed: ", defaultT1PoweredSieveEnergyPerTick, 1, 8192);
		
		t1PressCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Press Capacity, minimum is 1, maximum is 1024000(DEFAULT: 192000)")
				.worldRestart().defineInRange("Tier 1 Press Capacity: ", defaultT1PressCapacity, 1, 1024000);
		
		t1PressReceive = MECHANICRAFT_BUILDER.comment("Tier 1 Press Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 4096)")
				.worldRestart().defineInRange("Tier 1 Press Energy Receive: ", defaultT1PressReceive, 1, 1024000);

		t1PressWorkTime = MECHANICRAFT_BUILDER.comment("Tier 1 Press Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 200)")
				.worldRestart().defineInRange("Tier 1 Press Work Time: ", defaultT1PressWorkTime, 1, 1000);
		
		t1PressEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 1 Press Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 100)")
				.worldRestart().defineInRange("Tier 1 Press Energy Consumed: ", defaultT1PressEnergyPerTick, 1, 8192);
		
		t1SlurryProcessorEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Slurry Processor Energy Capacity, minimum is 1, maximum is 1024000(DEFAULT: 192000)")
				.worldRestart().defineInRange("Tier 1 Slurry Processor Energy Capacity: ", defaultT1SlurryProcessorEnergyCapacity, 1, 1024000);
		
		t1SlurryProcessorReceive = MECHANICRAFT_BUILDER.comment("Tier 1 Slurry Processor Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 4096)")
				.worldRestart().defineInRange("Tier 1 Slurry Processor Energy Receive: ", defaultT1SlurryProcessorReceive, 1, 1024000);

		t1SlurryProcessorWorkTime = MECHANICRAFT_BUILDER.comment("Tier 1 Slurry Processor Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 200)")
				.worldRestart().defineInRange("Tier 1 Slurry Processor Work Time: ", defaultT1SlurryProcessorWorkTime, 1, 1000);
		
		t1SlurryProcessorEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 1 Slurry Processor Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 100)")
				.worldRestart().defineInRange("Tier 1 Slurry Processor Energy Consumed: ", defaultT1SlurryProcessorEnergyPerTick, 1, 8192);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 2 MACHINE SETTINGS");
		
		t2CrusherCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Crusher Capacity, minimum is 1, maximum is 1024000(DEFAULT: 256000)")
				.worldRestart().defineInRange("Tier 2 Crusher Capacity: ", defaultT2CrusherCapacity, 1, 1024000);
		
		t2CrusherReceive = MECHANICRAFT_BUILDER.comment("Tier 2 Crusher Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 5120)")
				.worldRestart().defineInRange("Tier 2 Crusher Energy Receive: ", defaultT2CrusherReceive, 1, 1024000);

		t2CrusherWorkTime = MECHANICRAFT_BUILDER.comment("Tier 2 Crusher Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 180)")
				.worldRestart().defineInRange("Tier 2 Crusher Work Time: ", defaultT2CrusherWorkTime, 1, 1000);
		
		t2CrusherEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 2 Crusher Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 120)")
				.worldRestart().defineInRange("Tier 2 Crusher Energy Consumed: ", defaultT2CrusherEnergyPerTick, 1, 8192);
		
		t2EnergyCubeCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Energy Cube Capacity, minimum is 1, maximum is 10240000(DEFAULT: 2560000)")
				.worldRestart().defineInRange("Tier 2 Energy Cube Capacity: ", defaultT2EnergyCubeCapacity, 1, 10240000);
		
		t2EnergyCubeTransfer = MECHANICRAFT_BUILDER.comment("Tier 2 Energy Cube Energy Transfer, minimum is 1, maximum is 1024000(DEFAULT: 256000)")
				.worldRestart().defineInRange("Tier 2 Energy Cube Transfer: ", defaultT2EnergyCubeTransfer, 1, 1024000);
		
		t2InfuserCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Metallic Infuser Capacity, minimum is 1, maximum is 1024000(DEFAULT: 256000)")
				.worldRestart().defineInRange("Tier 2 Metallic Infuser Capacity: ", defaultT2InfuserCapacity, 1, 1024000);
		
		t2InfuserReceive = MECHANICRAFT_BUILDER.comment("Tier 2 Metallic Infuser Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 5120)")
				.worldRestart().defineInRange("Tier 2 Metallic Infuser Energy Receive: ", defaultT2InfuserReceive, 1, 1024000);

		t2InfuserWorkTime = MECHANICRAFT_BUILDER.comment("Tier 2 Metallic Infuser Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 180)")
				.worldRestart().defineInRange("Tier 2 Metallic Infuser Work Time: ", defaultT2InfuserWorkTime, 1, 1000);
		
		t2InfuserEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 2 Metallic Infuser Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 120)")
				.worldRestart().defineInRange("Tier 2 Metallic Infuser Energy Consumed: ", defaultT2InfuserEnergyPerTick, 1, 8192);
		
		t2OreWasherEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Ore Washer Energy Capacity, minimum is 1, maximum is 1024000(DEFAULT: 256000)")
				.worldRestart().defineInRange("Tier 2 Ore Washer Energy Capacity: ", defaultT2OreWasherEnergyCapacity, 1, 1024000);
		
		t2OreWasherReceive = MECHANICRAFT_BUILDER.comment("Tier 2 Ore Washer Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 5120)")
				.worldRestart().defineInRange("Tier 2 Ore Washer Energy Receive: ", defaultT2OreWasherReceive, 1, 1024000);

		t2OreWasherWorkTime = MECHANICRAFT_BUILDER.comment("Tier 2 Ore Washer Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 180)")
				.worldRestart().defineInRange("Tier 2 Ore Washer Work Time: ", defaultT2OreWasherWorkTime, 1, 1000);
		
		t2OreWasherEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 2 Ore Washer Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 120)")
				.worldRestart().defineInRange("Tier 2 Ore Washer Energy Consumed: ", defaultT2OreWasherEnergyPerTick, 1, 8192);
		
		t2PoweredSieveCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Powered Sieve Capacity, minimum is 1, maximum is 1024000(DEFAULT: 256000)")
				.worldRestart().defineInRange("Tier 2 Powered Sieve Capacity: ", defaultT2PoweredSieveCapacity, 1, 1024000);
		
		t2PoweredSieveReceive = MECHANICRAFT_BUILDER.comment("Tier 2 Powered Sieve Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 5120)")
				.worldRestart().defineInRange("Tier 2 Powered Sieve Energy Receive: ", defaultT2PoweredSieveReceive, 1, 1024000);

		t2PoweredSieveWorkTime = MECHANICRAFT_BUILDER.comment("Tier 2 Powered Sieve Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 180)")
				.worldRestart().defineInRange("Tier 2 Powered Sieve Work Time: ", defaultT2PoweredSieveWorkTime, 1, 1000);
		
		t2PoweredSieveEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 2 Powered Sieve Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 120)")
				.worldRestart().defineInRange("Tier 2 Powered Sieve Energy Consumed: ", defaultT2PoweredSieveEnergyPerTick, 1, 8192);
		
		t2PressCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Press Capacity, minimum is 1, maximum is 1024000(DEFAULT: 256000)")
				.worldRestart().defineInRange("Tier 2 Press Capacity: ", defaultT2PressCapacity, 1, 1024000);
		
		t2PressReceive = MECHANICRAFT_BUILDER.comment("Tier 2 Press Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 5120)")
				.worldRestart().defineInRange("Tier 2 Press Energy Receive: ", defaultT2PressReceive, 1, 1024000);

		t2PressWorkTime = MECHANICRAFT_BUILDER.comment("Tier 2 Press Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 180)")
				.worldRestart().defineInRange("Tier 2 Press Work Time: ", defaultT2PressWorkTime, 1, 1000);
		
		t2PressEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 2 Press Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 120)")
				.worldRestart().defineInRange("Tier 2 Press Energy Consumed: ", defaultT2PressEnergyPerTick, 1, 8192);
		
		t2SlurryProcessorEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Slurry Processor Energy Capacity, minimum is 1, maximum is 1024000(DEFAULT: 256000)")
				.worldRestart().defineInRange("Tier 2 Slurry Processor Energy Capacity: ", defaultT2SlurryProcessorEnergyCapacity, 1, 1024000);
		
		t2SlurryProcessorReceive = MECHANICRAFT_BUILDER.comment("Tier 2 Slurry Processor Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 5120)")
				.worldRestart().defineInRange("Tier 2 Slurry Processor Energy Receive: ", defaultT2SlurryProcessorReceive, 1, 1024000);

		t2SlurryProcessorWorkTime = MECHANICRAFT_BUILDER.comment("Tier 2 Slurry Processor Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 180)")
				.worldRestart().defineInRange("Tier 2 Slurry Processor Work Time: ", defaultT2SlurryProcessorWorkTime, 1, 1000);
		
		t2SlurryProcessorEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 2 Slurry Processor Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 120)")
				.worldRestart().defineInRange("Tier 2 Slurry Processor Energy Consumed: ", defaultT2SlurryProcessorEnergyPerTick, 1, 8192);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 3 MACHINE SETTINGS");
		
		t3CrusherCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Crusher Capacity, minimum is 1, maximum is 1024000(DEFAULT: 320000)")
				.worldRestart().defineInRange("Tier 3 Crusher Capacity: ", defaultT3CrusherCapacity, 1, 1024000);
		
		t3CrusherReceive = MECHANICRAFT_BUILDER.comment("Tier 3 Crusher Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 6144)")
				.worldRestart().defineInRange("Tier 3 Crusher Energy Receive: ", defaultT3CrusherReceive, 1, 1024000);

		t3CrusherWorkTime = MECHANICRAFT_BUILDER.comment("Tier 3 Crusher Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 160)")
				.worldRestart().defineInRange("Tier 3 Crusher Work Time Work Time: ", defaultT3CrusherWorkTime, 1, 1000);
		
		t3CrusherEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 3 Crusher Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 140)")
				.worldRestart().defineInRange("Tier 3 Crusher Work Time Energy Consumed: ", defaultT3CrusherEnergyPerTick, 1, 8192);
		
		t3EnergyCubeCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Energy Cube Capacity, minimum is 1, maximum is 10240000(DEFAULT: 3200000)")
				.worldRestart().defineInRange("Tier 3 Energy Cube Capacity: ", defaultT3EnergyCubeCapacity, 1, 10240000);
		
		t3EnergyCubeTransfer = MECHANICRAFT_BUILDER.comment("Tier 3 Energy Cube Energy Transfer, 1 is 1000, maximum is 1024000(DEFAULT: 320000)")
				.worldRestart().defineInRange("Tier 3 Energy Cube Transfer: ", defaultT3EnergyCubeTransfer, 1, 1024000);
		
		t3InfuserCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Metallic Infuser Capacity, minimum is 1, maximum is 1024000(DEFAULT: 320000)")
				.worldRestart().defineInRange("Tier 3 Metallic Infuser Capacity: ", defaultT3InfuserCapacity, 1, 1024000);
		
		t3InfuserReceive = MECHANICRAFT_BUILDER.comment("Tier 3 Metallic Infuser Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 6144)")
				.worldRestart().defineInRange("Tier 3 Metallic Infuser Energy Receive: ", defaultT3InfuserReceive, 1, 1024000);

		t3InfuserWorkTime = MECHANICRAFT_BUILDER.comment("Tier 3 Metallic Infuser Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 160)")
				.worldRestart().defineInRange("Tier 3 Metallic Infuser Work Time: ", defaultT3InfuserWorkTime, 1, 1000);
		
		t3InfuserEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 3 Metallic Infuser Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 140)")
				.worldRestart().defineInRange("Tier 3 Metallic Infuser Energy Consumed: ", defaultT3InfuserEnergyPerTick, 1, 8192);
		
		t3OreWasherEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Ore Washer Energy Capacity, minimum is 1, maximum is 1024000(DEFAULT: 320000)")
				.worldRestart().defineInRange("Tier 3 Ore Washer Energy Capacity: ", defaultT3OreWasherEnergyCapacity, 1, 1024000);
		
		t3OreWasherReceive = MECHANICRAFT_BUILDER.comment("Tier 3 Ore Washer Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 6144)")
				.worldRestart().defineInRange("Tier 3 Ore Washer Energy Receive: ", defaultT3OreWasherReceive, 1, 1024000);

		t3OreWasherWorkTime = MECHANICRAFT_BUILDER.comment("Tier 3 Ore Washer Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 160)")
				.worldRestart().defineInRange("Tier 3 Ore Washer Work Time: ", defaultT3OreWasherWorkTime, 1, 1000);
		
		t3OreWasherEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 3 Ore Washer Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 140)")
				.worldRestart().defineInRange("Tier 3 Ore Washer Energy Consumed: ", defaultT3OreWasherEnergyPerTick, 1, 8192);
		
		t3PoweredSieveCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Powered Sieve Capacity, minimum is 1, maximum is 1024000(DEFAULT: 320000)")
				.worldRestart().defineInRange("Tier 3 Powered Sieve Capacity: ", defaultT3PoweredSieveCapacity, 1, 1024000);
		
		t3PoweredSieveReceive = MECHANICRAFT_BUILDER.comment("Tier 3 Powered Sieve Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 6144)")
				.worldRestart().defineInRange("Tier 3 Powered Sieve Energy Receive: ", defaultT3PoweredSieveReceive, 1, 1024000);

		t3PoweredSieveWorkTime = MECHANICRAFT_BUILDER.comment("Tier 3 Powered Sieve Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 160)")
				.worldRestart().defineInRange("Tier 3 Powered Sieve Work Time: ", defaultT3PoweredSieveWorkTime, 1, 1000);
		
		t3PoweredSieveEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 3 Powered Sieve Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 140)")
				.worldRestart().defineInRange("Tier 3 Powered Sieve Energy Consumed: ", defaultT3PoweredSieveEnergyPerTick, 1, 8192);
		
		t3PressCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Press Capacity, minimum is 1, maximum is 1024000(DEFAULT: 320000)")
				.worldRestart().defineInRange("Tier 3 Press Capacity: ", defaultT3PressCapacity, 1, 1024000);
		
		t3PressReceive = MECHANICRAFT_BUILDER.comment("Tier 3 Press Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 6144)")
				.worldRestart().defineInRange("Tier 3 Press Energy Receive: ", defaultT3PressReceive, 1, 1024000);

		t3PressWorkTime = MECHANICRAFT_BUILDER.comment("Tier 3 Press Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 160)")
				.worldRestart().defineInRange("Tier 3 Press Work Time: ", defaultT3PressWorkTime, 1, 1000);
		
		t3PressEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 3 Press Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 140)")
				.worldRestart().defineInRange("Tier 3 Press Energy Consumed: ", defaultT3PressEnergyPerTick, 1, 8192);
		
		t3SlurryProcessorEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Slurry Processor Energy Capacity, minimum is 1, maximum is 1024000(DEFAULT: 320000)")
				.worldRestart().defineInRange("Tier 3 Slurry Processor Energy Capacity: ", defaultT3SlurryProcessorEnergyCapacity, 1, 1024000);
		
		t3SlurryProcessorReceive = MECHANICRAFT_BUILDER.comment("Tier 3 Slurry Processor Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 6144)")
				.worldRestart().defineInRange("Tier 3 Slurry Processor Energy Receive: ", defaultT3SlurryProcessorReceive, 1, 1024000);

		t3SlurryProcessorWorkTime = MECHANICRAFT_BUILDER.comment("Tier 3 Slurry Processor Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 160)")
				.worldRestart().defineInRange("Tier 3 Slurry Processor Work Time: ", defaultT3SlurryProcessorWorkTime, 1, 1000);
		
		t3SlurryProcessorEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 3 Slurry Processor Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 140)")
				.worldRestart().defineInRange("Tier 3 Slurry Processor Energy Consumed: ", defaultT3SlurryProcessorEnergyPerTick, 1, 8192);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 4 MACHINE SETTINGS");
		
		t4CrusherCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Crusher Capacity, minimum is 1, maximum is 1024000(DEFAULT: 384000)")
				.worldRestart().defineInRange("Tier 4 Crusher Capacity: ", defaultT4CrusherCapacity, 1, 1024000);
		
		t4CrusherReceive = MECHANICRAFT_BUILDER.comment("Tier 4 Crusher Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 7168)")
				.worldRestart().defineInRange("Tier 4 Crusher Energy Receive: ", defaultT4CrusherReceive, 1, 1024000);

		t4CrusherWorkTime = MECHANICRAFT_BUILDER.comment("Tier 4 Crusher Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 140)")
				.worldRestart().defineInRange("Tier 4 Crusher Work Time: ", defaultT4CrusherWorkTime, 1, 1000);
		
		t4CrusherEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 4 Crusher Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 160)")
				.worldRestart().defineInRange("Tier 4 Crusher Energy Consumed: ", defaultT4CrusherEnergyPerTick, 1, 8192);
		
		t4EnergyCubeCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Energy Cube Capacity, minimum is 1, maximum is 10240000(DEFAULT: 3840000)")
				.worldRestart().defineInRange("Tier 4 Energy Cube Capacity: ", defaultT4EnergyCubeCapacity, 1, 10240000);
		
		t4EnergyCubeTransfer = MECHANICRAFT_BUILDER.comment("Tier 4 Energy Cube Energy Transfer, minimum is 1, maximum is 1024000(DEFAULT: 384000)")
				.worldRestart().defineInRange("Tier 4 Energy Cube Transfer: ", defaultT4EnergyCubeTransfer, 1, 1024000);
		
		t4InfuserCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Metallic Infuser Capacity, minimum is 1, maximum is 1024000(DEFAULT: 384000)")
				.worldRestart().defineInRange("Tier 4 Metallic Infuser Capacity: ", defaultT4InfuserCapacity, 1, 1024000);
		
		t4InfuserReceive = MECHANICRAFT_BUILDER.comment("Tier 4 Metallic Infuser Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 7168)")
				.worldRestart().defineInRange("Tier 4 Metallic Infuser Energy Receive: ", defaultT4InfuserReceive, 1, 1024000);

		t4InfuserWorkTime = MECHANICRAFT_BUILDER.comment("Tier 4 Metallic Infuser Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 140)")
				.worldRestart().defineInRange("Tier 4 Metallic Infuser Work Time: ", defaultT4InfuserWorkTime, 1, 1000);
		
		t4InfuserEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 4 Metallic Infuser Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 160)")
				.worldRestart().defineInRange("Tier 4 Metallic Infuser Energy Consumed: ", defaultT4InfuserEnergyPerTick, 1, 8192);
		
		t4OreWasherEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Ore Washer Energy Capacity, minimum is 1, maximum is 1024000(DEFAULT: 384000)")
				.worldRestart().defineInRange("Tier 4 Ore Washer Energy Capacity: ", defaultT4OreWasherEnergyCapacity, 1, 1024000);
		
		t4OreWasherReceive = MECHANICRAFT_BUILDER.comment("Tier 4 Ore Washer Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 7168)")
				.worldRestart().defineInRange("Tier 4 Ore Washer Energy Receive: ", defaultT4OreWasherReceive, 1, 1024000);

		t4OreWasherWorkTime = MECHANICRAFT_BUILDER.comment("Tier 4 Ore Washer Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 140)")
				.worldRestart().defineInRange("Tier 4 Ore Washer Work Time: ", defaultT4OreWasherWorkTime, 1, 1000);
		
		t4OreWasherEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 4 Ore Washer Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 160)")
				.worldRestart().defineInRange("Tier 4 Ore Washer Energy Consumed: ", defaultT4OreWasherEnergyPerTick, 1, 8192);
		
		t4PoweredSieveCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Powered Sieve Capacity, minimum is 1, maximum is 1024000(DEFAULT: 384000)")
				.worldRestart().defineInRange("Tier 4 Powered Sieve Capacity: ", defaultT4PoweredSieveCapacity, 1, 1024000);
		
		t4PoweredSieveReceive = MECHANICRAFT_BUILDER.comment("Tier 4 Powered Sieve Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 7168)")
				.worldRestart().defineInRange("Tier 4 Powered Sieve Energy Receive: ", defaultT4PoweredSieveReceive, 1, 1024000);

		t4PoweredSieveWorkTime = MECHANICRAFT_BUILDER.comment("Tier 4 Powered Sieve Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 140)")
				.worldRestart().defineInRange("Tier 4 Powered Sieve Work Time: ", defaultT4PoweredSieveWorkTime, 1, 1000);
		
		t4PoweredSieveEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 4 Powered Sieve Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 160)")
				.worldRestart().defineInRange("Tier 4 Powered Sieve Energy Consumed: ", defaultT4PoweredSieveEnergyPerTick, 1, 8192);
		
		t4PressCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Press Capacity, minimum is 1, maximum is 1024000(DEFAULT: 384000)")
				.worldRestart().defineInRange("Tier 4 Press Capacity: ", defaultT4PressCapacity, 1, 1024000);
		
		t4PressReceive = MECHANICRAFT_BUILDER.comment("Tier 4 Press Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 7168)")
				.worldRestart().defineInRange("Tier 4 Press Energy Receive: ", defaultT4PressReceive, 1, 1024000);

		t4PressWorkTime = MECHANICRAFT_BUILDER.comment("Tier 4 Press Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 140)")
				.worldRestart().defineInRange("Tier 4 Press Work Time: ", defaultT4PressWorkTime, 1, 1000);
		
		t4PressEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 4 Press Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 160)")
				.worldRestart().defineInRange("Tier 4 Press Energy Consumed: ", defaultT4PressEnergyPerTick, 1, 8192);
		
		t4SlurryProcessorEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Slurry Processor Energy Capacity, minimum is 1, maximum is 1024000(DEFAULT: 384000)")
				.worldRestart().defineInRange("Tier 4 Slurry Processor Energy Capacity: ", defaultT4SlurryProcessorEnergyCapacity, 1, 1024000);
		
		t4SlurryProcessorReceive = MECHANICRAFT_BUILDER.comment("Tier 4 Slurry Processor Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 7168)")
				.worldRestart().defineInRange("Tier 4 Slurry Processor Energy Receive: ", defaultT4SlurryProcessorReceive, 1, 1024000);

		t4SlurryProcessorWorkTime = MECHANICRAFT_BUILDER.comment("Tier 4 Slurry Processor Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 140)")
				.worldRestart().defineInRange("Tier 4 Slurry Processor Work Time: ", defaultT4SlurryProcessorWorkTime, 1, 1000);
		
		t4SlurryProcessorEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 4 Slurry Processor Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 160)")
				.worldRestart().defineInRange("Tier 4 Slurry Processor Energy Consumed: ", defaultT4SlurryProcessorEnergyPerTick, 1, 8192);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 5 MACHINE SETTINGS");
		
		t5CrusherCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Crusher Capacity, minimum is 1, maximum is 1024000(DEFAULT: 448000)")
				.worldRestart().defineInRange("Tier 5 Crusher Capacity: ", defaultT5CrusherCapacity, 1, 1024000);
		
		t5CrusherReceive = MECHANICRAFT_BUILDER.comment("Tier 5 Crusher Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 8192)")
				.worldRestart().defineInRange("Tier 5 Crusher Energy Receive: ", defaultT5CrusherReceive, 1, 1024000);

		t5CrusherWorkTime = MECHANICRAFT_BUILDER.comment("Tier 5 Crusher Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 120)")
				.worldRestart().defineInRange("Tier 5 Crusher Work Time: ", defaultT5CrusherWorkTime, 1, 1000);
		
		t5CrusherEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 5 Crusher Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 180)")
				.worldRestart().defineInRange("Tier 5 Crusher Energy Consumed: ", defaultT5CrusherEnergyPerTick, 1, 8192);
		
		t5EnergyCubeCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Energy Cube Capacity, minimum is 1, maximum is 10240000(DEFAULT: 4480000)")
				.worldRestart().defineInRange("Tier 5 Energy Cube Capacity: ", defaultT5EnergyCubeCapacity, 1, 10240000);
		
		t5EnergyCubeTransfer = MECHANICRAFT_BUILDER.comment("Tier 5 Energy Cube Energy Transfer, minimum is 1, maximum is 1024000(DEFAULT: 448000)")
				.worldRestart().defineInRange("Tier 5 Energy Cube Transfer: ", defaultT5EnergyCubeTransfer, 1, 1024000);
		
		t5InfuserCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Metallic Infuser Capacity, minimum is 1, maximum is 1024000(DEFAULT: 448000)")
				.worldRestart().defineInRange("Tier 5 Metallic Infuser Capacity: ", defaultT5InfuserCapacity, 1, 1024000);
		
		t5InfuserReceive = MECHANICRAFT_BUILDER.comment("Tier 5 Metallic Infuser Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 8192)")
				.worldRestart().defineInRange("Tier 5 Metallic Infuser Energy Receive: ", defaultT5InfuserReceive, 1, 1024000);

		t5InfuserWorkTime = MECHANICRAFT_BUILDER.comment("Tier 5 Metallic Infuser Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 120)")
				.worldRestart().defineInRange("Tier 5 Metallic Infuser Work Time: ", defaultT5InfuserWorkTime, 1, 1000);
		
		t5InfuserEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 5 Metallic Infuser Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 180)")
				.worldRestart().defineInRange("Tier 5 Metallic Infuser Energy Consumed: ", defaultT5InfuserEnergyPerTick, 1, 8192);
		
		t5OreWasherEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Ore Washer Energy Capacity, minimum is 1, maximum is 1024000(DEFAULT: 448000)")
				.worldRestart().defineInRange("Tier 5 Ore Washer Energy Capacity: ", defaultT5OreWasherEnergyCapacity, 1, 1024000);
		
		t5OreWasherReceive = MECHANICRAFT_BUILDER.comment("Tier 5 Ore Washer Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 8192)")
				.worldRestart().defineInRange("Tier 5 Ore Washer Energy Receive: ", defaultT5OreWasherReceive, 1, 1024000);

		t5OreWasherWorkTime = MECHANICRAFT_BUILDER.comment("Tier 5 Ore Washer Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 120)")
				.worldRestart().defineInRange("Tier 5 Ore Washer Work Time: ", defaultT5OreWasherWorkTime, 1, 1000);
		
		t5OreWasherEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 5 Ore Washer Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 180)")
				.worldRestart().defineInRange("Tier 5 Ore Washer Energy Consumed: ", defaultT5OreWasherEnergyPerTick, 1, 8192);
		
		t5PoweredSieveCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Powered Sieve Capacity, minimum is 1, maximum is 1024000(DEFAULT: 448000)")
				.worldRestart().defineInRange("Tier 5 Powered Sieve Capacity: ", defaultT5PoweredSieveCapacity, 1, 1024000);
		
		t5PoweredSieveReceive = MECHANICRAFT_BUILDER.comment("Tier 5 Powered Sieve Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 8192)")
				.worldRestart().defineInRange("Tier 5 Powered Sieve Energy Receive: ", defaultT5PoweredSieveReceive, 1, 1024000);

		t5PoweredSieveWorkTime = MECHANICRAFT_BUILDER.comment("Tier 5 Powered Sieve Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 120)")
				.worldRestart().defineInRange("Tier 5 Powered Sieve Work Time: ", defaultT5PoweredSieveWorkTime, 1, 1000);
		
		t5PoweredSieveEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 5 Powered Sieve Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 180)")
				.worldRestart().defineInRange("Tier 5 Powered Sieve Energy Consumed: ", defaultT5PoweredSieveEnergyPerTick, 1, 8192);
		
		t5PressCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Press Capacity, minimum is 1, maximum is 1024000(DEFAULT: 448000)")
				.worldRestart().defineInRange("Tier 5 Press Capacity: ", defaultT5PressCapacity, 1, 1024000);
		
		t5PressReceive = MECHANICRAFT_BUILDER.comment("Tier 5 Press Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 8192)")
				.worldRestart().defineInRange("Tier 5 Press Energy Receive: ", defaultT5PressReceive, 1, 1024000);

		t5PressWorkTime = MECHANICRAFT_BUILDER.comment("Tier 5 Press Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 120)")
				.worldRestart().defineInRange("Tier 5 Press Work Time: ", defaultT5PressWorkTime, 1, 1000);
		
		t5PressEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 5 Press Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 180)")
				.worldRestart().defineInRange("Tier 5 Press Energy Consumed: ", defaultT5PressEnergyPerTick, 1, 8192);
		
		t5SlurryProcessorEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Slurry Processor Energy Capacity, minimum is 1, maximum is 1024000(DEFAULT: 448000)")
				.worldRestart().defineInRange("Tier 5 Slurry Processor Energy Capacity: ", defaultT5SlurryProcessorEnergyCapacity, 1, 1024000);
		
		t5SlurryProcessorReceive = MECHANICRAFT_BUILDER.comment("Tier 5 Slurry Processor Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 8192)")
				.worldRestart().defineInRange("Tier 5 Slurry Processor Energy Receive: ", defaultT5SlurryProcessorReceive, 1, 1024000);

		t5SlurryProcessorWorkTime = MECHANICRAFT_BUILDER.comment("Tier 5 Slurry Processor Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 120)")
				.worldRestart().defineInRange("Tier 5 Slurry Processor Work Time: ", defaultT5SlurryProcessorWorkTime, 1, 1000);
		
		t5SlurryProcessorEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 5 Slurry Processor Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 180)")
				.worldRestart().defineInRange("Tier 5 Slurry Processor Energy Consumed: ", defaultT5SlurryProcessorEnergyPerTick, 1, 8192);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 6 MACHINE SETTINGS");
		
		t6CrusherCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Crusher Capacity, minimum is 1, maximum is 1024000(DEFAULT: 512000)")
				.worldRestart().defineInRange("Tier 6 Crusher Capacity: ", defaultT6CrusherCapacity, 1, 1024000);
		
		t6CrusherReceive = MECHANICRAFT_BUILDER.comment("Tier 6 Crusher Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 9216)")
				.worldRestart().defineInRange("Tier 6 Crusher Energy Receive: ", defaultT6CrusherReceive, 1, 1024000);

		t6CrusherWorkTime = MECHANICRAFT_BUILDER.comment("Tier 6 Crusher Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 100)")
				.worldRestart().defineInRange("Tier 6 Crusher Work Time: ", defaultT6CrusherWorkTime, 1, 1000);
		
		t6CrusherEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 6 Crusher Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 200)")
				.worldRestart().defineInRange("Tier 6 Crusher Energy Consumed: ", defaultT6CrusherEnergyPerTick, 1, 8192);
		
		t6EnergyCubeCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Energy Cube Capacity, minimum is 1, maximum is 10240000(DEFAULT: 5120000)")
				.worldRestart().defineInRange("Tier 6 Energy Cube Capacity: ", defaultT6EnergyCubeCapacity, 1, 10240000);
		
		t6EnergyCubeTransfer = MECHANICRAFT_BUILDER.comment("Tier 6 Energy Cube Energy Transfer, minimum is 1, maximum is 1024000(DEFAULT: 512000)")
				.worldRestart().defineInRange("Tier 6 Energy Cube Transfer: ", defaultT6EnergyCubeTransfer, 1, 1024000);
		
		t6InfuserCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Metallic Infuser Capacity, minimum is 1, maximum is 1024000(DEFAULT: 512000)")
				.worldRestart().defineInRange("Tier 6 Metallic Infuser Capacity: ", defaultT6InfuserCapacity, 1, 1024000);
		
		t6InfuserReceive = MECHANICRAFT_BUILDER.comment("Tier 6 Metallic Infuser Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 9216)")
				.worldRestart().defineInRange("Tier 6 Metallic Infuser Energy Receive: ", defaultT6InfuserReceive, 1, 1024000);

		t6InfuserWorkTime = MECHANICRAFT_BUILDER.comment("Tier 6 Metallic Infuser Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 100)")
				.worldRestart().defineInRange("Tier 6 Metallic Infuser Work Time: ", defaultT6InfuserWorkTime, 1, 1000);
		
		t6InfuserEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 6 Metallic Infuser Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 200)")
				.worldRestart().defineInRange("Tier 6 Metallic Infuser Energy Consumed: ", defaultT6InfuserEnergyPerTick, 1, 8192);
		
		t6OreWasherEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Ore Washer Energy Capacity, minimum is 1, maximum is 1024000(DEFAULT: 512000)")
				.worldRestart().defineInRange("Tier 6 Ore Washer Energy Capacity: ", defaultT6OreWasherEnergyCapacity, 1, 1024000);
		
		t6OreWasherReceive = MECHANICRAFT_BUILDER.comment("Tier 6 Ore Washer Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 9216)")
				.worldRestart().defineInRange("Tier 6 Ore Washer Energy Receive: ", defaultT6OreWasherReceive, 1, 1024000);

		t6OreWasherWorkTime = MECHANICRAFT_BUILDER.comment("Tier 6 Ore Washer Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 100)")
				.worldRestart().defineInRange("Tier 6 Ore Washer Work Time: ", defaultT6OreWasherWorkTime, 1, 1000);
		
		t6OreWasherEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 6 Ore Washer Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 200)")
				.worldRestart().defineInRange("Tier 6 Ore Washer Energy Consumed: ", defaultT6OreWasherEnergyPerTick, 1, 8192);
		
		t6PoweredSieveCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Powered Sieve Capacity, minimum is 1, maximum is 1024000(DEFAULT: 512000)")
				.worldRestart().defineInRange("Tier 6 Powered Sieve Capacity: ", defaultT6PoweredSieveCapacity, 1, 1024000);
		
		t6PoweredSieveReceive = MECHANICRAFT_BUILDER.comment("Tier 6 Powered Sieve Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 9216)")
				.worldRestart().defineInRange("Tier 6 Powered Sieve Energy Receive: ", defaultT6PoweredSieveReceive, 1, 1024000);

		t6PoweredSieveWorkTime = MECHANICRAFT_BUILDER.comment("Tier 6 Powered Sieve Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 100)")
				.worldRestart().defineInRange("Tier 6 Powered Sieve Work Time: ", defaultT6PoweredSieveWorkTime, 1, 1000);
		
		t6PoweredSieveEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 6 Powered Sieve Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 200)")
				.worldRestart().defineInRange("Tier 6 Powered Sieve Energy Consumed: ", defaultT6PoweredSieveEnergyPerTick, 1, 8192);
		
		t6PressCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Press Capacity, minimum is 1, maximum is 1024000(DEFAULT: 512000)")
				.worldRestart().defineInRange("Tier 6 Press Capacity: ", defaultT6PressCapacity, 1, 1024000);
		
		t6PressReceive = MECHANICRAFT_BUILDER.comment("Tier 6 Press Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 9216)")
				.worldRestart().defineInRange("Tier 6 Press Energy Receive: ", defaultT6PressReceive, 1, 1024000);

		t6PressWorkTime = MECHANICRAFT_BUILDER.comment("Tier 6 Press Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 100)")
				.worldRestart().defineInRange("Tier 6 Press Work Time: ", defaultT6PressWorkTime, 1, 1000);
		
		t6PressEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 6 Press Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 200)")
				.worldRestart().defineInRange("Tier 6 Press Energy Consumed: ", defaultT6PressEnergyPerTick, 1, 8192);
		
		t6SlurryProcessorEnergyCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Slurry Processor Energy Capacity, minimum is 1, maximum is 1024000(DEFAULT: 512000)")
				.worldRestart().defineInRange("Tier 6 Slurry Processor Energy Capacity: ", defaultT6SlurryProcessorEnergyCapacity, 1, 1024000);
		
		t6SlurryProcessorReceive = MECHANICRAFT_BUILDER.comment("Tier 6 Slurry Processor Energy Receive, minimum is 1, maximum is 1024000(DEFAULT: 9216)")
				.worldRestart().defineInRange("Tier 6 Slurry Processor Energy Receive: ", defaultT6SlurryProcessorReceive, 1, 1024000);

		t6SlurryProcessorWorkTime = MECHANICRAFT_BUILDER.comment("Tier 6 Slurry Processor Work Time Ticks, minimum is 1, maximum is 1000(DEFAULT: 100)")
				.worldRestart().defineInRange("Tier 6 Slurry Processor Work Time: ", defaultT6SlurryProcessorWorkTime, 1, 1000);
		
		t6SlurryProcessorEnergyPerTick = MECHANICRAFT_BUILDER.comment("Tier 6 Slurry Processor Energy Consumed Per Tick, minimum is 1, maximum is 8192(DEFAULT: 200)")
				.worldRestart().defineInRange("Tier 6 Slurry Processor Energy Consumed: ", defaultT6SlurryProcessorEnergyPerTick, 1, 8192);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 1 FLUID SETTINGS START");
		//Fluid Config
		t1OreWasherTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Ore Washer Tank Capacity, minimum is 8000, maximum is 32000(DEFAULT: 16000)")
				.worldRestart().defineInRange("Tier 1 Ore Washer Tank Capacity: ", defaultT1OreWasherTankCapacity, 8000, 32000);
		
		t1SlurryProcessorTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 1 Slurry Processor Tank Capacity, minimum is 8000, maximum is 32000(DEFAULT: 16000)")
				.worldRestart().defineInRange("Tier 1 Slurry Processor Tank Capacity: ", defaultT1SlurryProcessorTankCapacity, 8000, 32000);
		
		basicTankCapacity = MECHANICRAFT_BUILDER.comment("Basic Tank Capacity, minimum is 8000, maximum is 32000(DEFAULT: 16000)")
				.worldRestart().defineInRange("Basic Tank Capacity: ", defaultBasicTankCapacity, 8000, 32000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 2 FLUID SETTINGS START");
		
		t2OreWasherTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Ore Washer Tank Capacity, minimum is 16000, maximum is 64000(DEFAULT: 32000)")
				.worldRestart().defineInRange("Tier 2 Ore Washer Tank Capacity: ", defaultT2OreWasherTankCapacity, 16000, 64000);
		
		t2SlurryProcessorTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 2 Slurry Processor Tank Capacity, minimum is 16000, maximum is 64000(DEFAULT: 32000)")
				.worldRestart().defineInRange("Tier 2 Slurry Processor Tank Capacity: ", defaultT2SlurryProcessorTankCapacity, 16000, 64000);
		
		advancedTankCapacity = MECHANICRAFT_BUILDER.comment("Advanced Tank Capacity, minimum is 16000, maximum is 64000(DEFAULT: 32000)")
				.worldRestart().defineInRange("Advanced Tank Capacity: ", defaultAdvancedTankCapacity, 16000, 64000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 3 FLUID SETTINGS START");
		
		t3OreWasherTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Ore Washer Tank Capacity, minimum is 32000, maximum is 128000(DEFAULT: 64000)")
				.worldRestart().defineInRange("Tier 3 Ore Washer Tank Capacity: ", defaultT3OreWasherTankCapacity, 32000, 128000);
		
		t3SlurryProcessorTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 3 Slurry Processor Tank Capacity, minimum is 32000, maximum is 128000(DEFAULT: 64000)")
				.worldRestart().defineInRange("Tier 3 Slurry Processor Tank Capacity: ", defaultT3SlurryProcessorTankCapacity, 32000, 128000);
		
		eliteTankCapacity = MECHANICRAFT_BUILDER.comment("Elite Tank Capacity, minimum is 32000, maximum is 128000(DEFAULT: 64000)")
				.worldRestart().defineInRange("Elite Tank Capacity: ", defaultEliteTankCapacity, 32000, 128000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 4 FLUID SETTINGS START");
		
		t4OreWasherTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Ore Washer Tank Capacity, minimum is 64000, maximum is 256000(DEFAULT: 128000)")
				.worldRestart().defineInRange("Tier 4 Ore Washer Tank Capacity: ", defaultT4OreWasherTankCapacity, 64000, 256000);
		
		t4SlurryProcessorTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 4 Slurry Processor Tank Capacity, minimum is 64000, maximum is 256000(DEFAULT: 128000)")
				.worldRestart().defineInRange("Tier 4 Slurry Processor Tank Capacity: ", defaultT4SlurryProcessorTankCapacity, 64000, 256000);
		
		superiorTankCapacity = MECHANICRAFT_BUILDER.comment("Superior Tank Capacity, minimum is 64000, maximum is 256000(DEFAULT: 128000)")
				.worldRestart().defineInRange("Superior Tank Capacity: ", defaultSuperiorTankCapacity, 64000, 256000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 5 FLUID SETTINGS START");
		
		t5OreWasherTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Ore Washer Tank Capacity, minimum is 128000, maximum is 512000(DEFAULT: 256000)")
				.worldRestart().defineInRange("Tier 5 Ore Washer Tank Capacity: ", defaultT5OreWasherTankCapacity, 128000, 512000);
		
		t5SlurryProcessorTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 5 Slurry Processor Tank Capacity, minimum is 128000, maximum is 512000(DEFAULT: 256000)")
				.worldRestart().defineInRange("Tier 5 Slurry Processor Tank Capacity: ", defaultT5SlurryProcessorTankCapacity, 128000, 512000);
		
		supremeTankCapacity = MECHANICRAFT_BUILDER.comment("Supreme Tank Capacity, minimum is 128000, maximum is 512000(DEFAULT: 256000)")
				.worldRestart().defineInRange("Supreme Tank Capacity: ", defaultSupremeTankCapacity, 128000, 512000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("TIER 6 FLUID SETTINGS START");
		
		t6OreWasherTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Ore Washer Tank Capacity, minimum is 256000, maximum is 1024000(DEFAULT: 512000)")
				.worldRestart().defineInRange("Tier 6 Ore Washer Tank Capacity: ", defaultT6OreWasherTankCapacity, 256000, 1024000);
		
		t6SlurryProcessorTankCapacity = MECHANICRAFT_BUILDER.comment("Tier 6 Slurry Processor Tank Capacity, minimum is 256000, maximum is 1024000(DEFAULT: 512000)")
				.worldRestart().defineInRange("Tier 6 Slurry Processor Tank Capacity: ", defaultT6SlurryProcessorTankCapacity, 256000, 1024000);
		
		ultimateTankCapacity = MECHANICRAFT_BUILDER.comment("Ultimate Tank Capacity, minimum is 256000, maximum is 1024000(DEFAULT: 512000)")
				.worldRestart().defineInRange("Ultimate Tank Capacity: ", defaultUltimateTankCapacity, 256000, 1024000);
		
		MECHANICRAFT_BUILDER.pop();
		
		//Armors
		MECHANICRAFT_BUILDER.push("ARMOR SETTINGS");
		
		armorEffects = MECHANICRAFT_BUILDER.comment("Potion Effects for Armor Sets, true is enabled, false is disabled(DEFAULT: true)")
				.comment("WILL DISABLE ALL ARMOR EFFECTS, IF YOU ONLY WANT TO DISABLE CERTAIN ONES THAT IS DONE BY EACH ARMOR INDIVIDUALLY!!!")
				.worldRestart().define("Potion effects for armor: ", defaultArmorEffects);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("EMERONIUM ARMOR SETTINGS");
		
		emeroniumArmorDurability = MECHANICRAFT_BUILDER.comment("Emeronium Armor Durability, minimum is 2, maximum is 50(DEFAULT: 30)")
				.worldRestart().defineInRange("Emeronium Armor Durability: ", defaultEmeroniumArmorDurability, 2, 50);
		
		emeroniumArmorEnchantability = MECHANICRAFT_BUILDER.comment("Emeronium Armor Enchantability, minimum is 1, maximum is 30(DEFAULT: 12)")
				.worldRestart().defineInRange("Emeronium Armor Enchantability: ", defaultEmeroniumArmorEnchantability, 1, 30);
		
		emeroniumArmorToughness = MECHANICRAFT_BUILDER.comment("Emeronium Armor Toughness, minimum is 0.00, maximum is 10.00(DEFAULT: 2.00)")
				.worldRestart().defineInRange("Emeronium Armor Toughness: ", defaultEmeroniumArmorToughness, 0.00, 10.00);
		
		emeroniumArmorResistance = MECHANICRAFT_BUILDER.comment("Emeronium Armor Knockback Resistance, minimum is 0.00, maximum is 1.00(DEFAULT: 0.05)")
				.worldRestart().defineInRange("Emeronium Armor Resistance: ", defaultEmeroniumArmorResistance, 0.00, 1.00);
		
		
		emeroniumArmorHeroEffect = MECHANICRAFT_BUILDER.comment("Emeronium Armor Hero Of The Village Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Hero of the village effect enabled: ", defaultEmeroniumArmorHeroEffect);
			
		
		emeroniumBootsProtection = MECHANICRAFT_BUILDER.comment("Emeronium Boots Protection Amount, minimum is 1, maximum is 11(DEFAULT: 3)")
				.worldRestart().defineInRange("Emeronium Boots Protection: ", defaultEmeroniumBootsProtection, 1, 11);
		
		emeroniumLeggingsProtection = MECHANICRAFT_BUILDER.comment("Emeronium Leggings Protection Amount, minimum is 3, maximum is 15(DEFAULT: 5)")
				.worldRestart().defineInRange("Emeronium Leggings Protection: ", defaultEmeroniumLeggingsProtection, 3, 15);
		
		emeroniumChestplateProtection = MECHANICRAFT_BUILDER.comment("Emeronium Chestplate Protection Amount, minimum is 4, maximum is 16(DEFAULT: 7)")
				.worldRestart().defineInRange("Emeronium Chestplate Protection: ", defaultEmeroniumChestplateProtection, 4, 16);
		
		emeroniumHelmetProtection = MECHANICRAFT_BUILDER.comment("Emeronium Helmet Protection Amount, minimum is 2, maximum is 13(DEFAULT: 4)")
				.worldRestart().defineInRange("Emeronium Helmet Protection: ", defaultEmeroniumHelmetProtection, 2, 13);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("ENDONIUM ARMOR SETTINGS");
		
		endoniumArmorDurability = MECHANICRAFT_BUILDER.comment("Endonium Armor Durability, minimum is 2, maximum is 50(DEFAULT: 37)")
				.worldRestart().defineInRange("Endonium Armor Durability: ", defaultEndoniumArmorDurability, 2, 50);
		
		endoniumArmorEnchantability = MECHANICRAFT_BUILDER.comment("Endonium Armor Enchantability, minimum is 1, maximum is 30(DEFAULT: 14.00)")
				.worldRestart().defineInRange("Endonium Armor Enchantability: ", defaultEndoniumArmorEnchantability, 1, 30);
		
		endoniumArmorToughness = MECHANICRAFT_BUILDER.comment("Endonium Armor Toughness, minimum is 0.00, maximum is 10.00(DEFAULT: 3.00)")
				.worldRestart().defineInRange("Endonium Armor Toughness: ", defaultEndoniumArmorToughness, 0.00, 10.00);
		
		endoniumArmorResistance = MECHANICRAFT_BUILDER.comment("Endonium Armor Knockback Resistance, minimum is 0.00, maximum is 1.00(DEFAULT: 0.20)")
				.worldRestart().defineInRange("Endonium Armor Resistance: ", defaultEndoniumArmorResistance, 0.00, 1.00);
		
		
		endoniumArmorHealthEffect = MECHANICRAFT_BUILDER.comment("Endonium Armor Health Boost Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Health boost effect enabled: ", defaultEndoniumArmorHealthEffect);
		
		endoniumArmorSpeedEffect = MECHANICRAFT_BUILDER.comment("Endonium Armor Speed Boost Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Speed boost effect enabled: ", defaultEndoniumArmorSpeedEffect);
		
		endoniumArmorHeroEffect = MECHANICRAFT_BUILDER.comment("Endonium Armor Hero of The Village Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Hero of the village effect enabled: ", defaultEndoniumArmorHeroEffect);
		
		endoniumArmorFireEffect = MECHANICRAFT_BUILDER.comment("Endonium Armor Fire Resistance Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Fire resistance effect enabled: ", defaultEndoniumArmorFireEffect);
		
		endoniumArmorWaterEffect = MECHANICRAFT_BUILDER.comment("Endonium Armor Water Breathing Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Water breathing effect enabled: ", defaultEndoniumArmorWaterEffect);
		
		endoniumArmorVisionEffect = MECHANICRAFT_BUILDER.comment("Endonium Armor Night Vision Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Night vision effect enabled: ", defaultEndoniumArmorVisionEffect);
		
		
		endoniumBootsProtection = MECHANICRAFT_BUILDER.comment("Endonium Boots Protection Amount, minimum is 1, maximum is 11(DEFAULT: 4)")
				.worldRestart().defineInRange("Endonium Boots Protection: ", defaultEndoniumBootsProtection, 1, 11);
		
		endoniumLeggingsProtection = MECHANICRAFT_BUILDER.comment("Endonium Leggings Protection Amount, minimum is 3, maximum is 15(DEFAULT: 7)")
				.worldRestart().defineInRange("Endonium Leggings Protection: ", defaultEndoniumLeggingsProtection, 3, 15);
		
		endoniumChestplateProtection = MECHANICRAFT_BUILDER.comment("Endonium Chestplate Protection Amount, minimum is 4, maximum is 16(DEFAULT: 9)")
				.worldRestart().defineInRange("Endonium Chestplate Protection: ", defaultEndoniumChestplateProtection, 4, 16);
		
		endoniumHelmetProtection = MECHANICRAFT_BUILDER.comment("Endonium Helmet Protection Amount, minimum is 2, maximum is 13(DEFAULT: 7)")
				.worldRestart().defineInRange("Endonium Helmet Protection Amount: ", defaultEndoniumHelmetProtection, 2, 13);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("ENDONIUM CRYSTAL ARMOR SETTINGS");
		
		endoniumCrystalArmorDurability = MECHANICRAFT_BUILDER.comment("Endonium Crystal Armor Durability, minimum is 2, maximum is 50(DEFAULT: 40)")
				.worldRestart().defineInRange("Endonium Crystal Armor Durability: ", defaultEndoniumCrystalArmorDurability, 2, 50);
		
		endoniumCrystalArmorEnchantability = MECHANICRAFT_BUILDER.comment("Endonium Crystal Armor Enchantability, minimum is 1, maximum is 30(DEFAULT: 16)")
				.worldRestart().defineInRange("Endonium Crystal Armor Enchantability: ", defaultEndoniumCrystalArmorEnchantability, 1, 30);
		
		endoniumCrystalArmorToughness = MECHANICRAFT_BUILDER.comment("Endonium Crystal Armor Toughness, minimum is 0.00, maximum is 10.00(DEFAULT: 4.00)")
				.worldRestart().defineInRange("Endonium Crystal Armor Toughness: ", defaultEndoniumCrystalArmorToughness, 0.00, 10.00);
		
		endoniumCrystalArmorResistance = MECHANICRAFT_BUILDER.comment("Endonium Crystal Armor Knockback Resistance, minimum is 0.00, maximum is 1.00(DEFAULT: 0.30)")
				.worldRestart().defineInRange("Endonium Crystal Armor Resistance: ", defaultEndoniumCrystalArmorResistance, 0.00, 1.00);
		
		
		endoniumCrystalArmorHealthEffect = MECHANICRAFT_BUILDER.comment("Endonium Crystal Armor Health Boost Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Health boost effect enabled: ", defaultEndoniumCrystalArmorHealthEffect);
		
		endoniumCrystalArmorFlightEffect = MECHANICRAFT_BUILDER.comment("Endonium Crystal Armor Flight Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Flight effect enabled: ", defaultEndoniumCrystalArmorFlightEffect);
		
		endoniumCrystalArmorSpeedEffect = MECHANICRAFT_BUILDER.comment("Endonium Crystal Armor Speed Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Speed effect enabled: ", defaultEndoniumCrystalArmorSpeedEffect);
		
		endoniumCrystalArmorHeroEffect = MECHANICRAFT_BUILDER.comment("Endonium Crystal Armor Hero of The Village Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Hero of the village effect enabled: ", defaultEndoniumCrystalArmorHeroEffect);
		
		endoniumCrystalArmorFireEffect = MECHANICRAFT_BUILDER.comment("Endonium Crystal Armor Fire Resistance Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Fire resistance effect enabled: ", defaultEndoniumCrystalArmorFireEffect);
		
		endoniumCrystalArmorWaterEffect = MECHANICRAFT_BUILDER.comment("Endonium Crystal Armor Water Breathing Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Water breathing effect enabled: ", defaultEndoniumCrystalArmorWaterEffect);
		
		endoniumCrystalArmorVisionEffect = MECHANICRAFT_BUILDER.comment("Endonium Crystal Armor Night Vision Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Night vision effect enabled: ", defaultEndoniumCrystalArmorVisionEffect);
		
		
		endoniumCrystalBootsProtection = MECHANICRAFT_BUILDER.comment("Endonium Crystal Boots Protection Amount, minimum is 1, maximum is 11(DEFAULT: 5)")
				.worldRestart().defineInRange("Endonium Crystal Boots Protection: ", defaultEndoniumCrystalBootsProtection, 1, 11);
		
		endoniumCrystalLeggingsProtection = MECHANICRAFT_BUILDER.comment("Endonium Crystal Leggings Protection Amount, minimum is 3, maximum is 15(DEFAULT: 8)")
				.worldRestart().defineInRange("Endonium Crystal Leggings: ", defaultEndoniumCrystalLeggingsProtection, 3, 15);
		
		endoniumCrystalChestplateProtection = MECHANICRAFT_BUILDER.comment("Endonium Crystal Chestplate Protection Amount, minimum is 4, maximum is 16(DEFAULT: 10)")
				.worldRestart().defineInRange("Endonium Crystal Chestplate: ", defaultEndoniumCrystalChestplateProtection, 4, 16);
		
		endoniumCrystalHelmetProtection = MECHANICRAFT_BUILDER.comment("Endonium Crystal Helmet Protection Amount, minimum is 2, maximum is 13(DEFAULT: 5)")
				.worldRestart().defineInRange("Endonium Crystal Helmet: ", defaultEndoniumCrystalHelmetProtection, 2, 13);
				
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("OBSIDIUM ARMOR SETTINGS");
		
		obsidiumArmorDurability = MECHANICRAFT_BUILDER.comment("Obsidium Armor Durability, minimum is 2, maximum is 50(DEFAULT: 30)")
				.worldRestart().defineInRange("Obsidium Armor Durability: ", defaultObsidiumArmorDurability, 2, 50);
		
		obsidiumArmorEnchantability = MECHANICRAFT_BUILDER.comment("Obsidium Armor Enchantability, minimum is 1, maximum is 30(DEFAULT: 12)")
				.worldRestart().defineInRange("Obsidium Armor Enchantability: ", defaultObsidiumArmorEnchantability, 1, 30);
		
		obsidiumArmorToughness = MECHANICRAFT_BUILDER.comment("Obsidium Armor Toughness, minimum is 0.00, maximum is 10.00(DEFAULT: 2.00)")
				.worldRestart().defineInRange("Obsidium Armor Toughness: ", defaultObsidiumArmorToughness, 0.00, 10.00);
		
		obsidiumArmorResistance = MECHANICRAFT_BUILDER.comment("Obsidium Armor Knockback Resistance, minimum is 0.00, maximum is 1.00(DEFAULT: 0.10)")
				.worldRestart().defineInRange("Obsidium Armor Resistance: ", defaultObsidiumArmorResistance, 0.00, 1.00);
		
		
		obsidiumArmorFireEffect = MECHANICRAFT_BUILDER.comment("Obsidium Fire Resistance Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Fire resistance effect enabled: ", defaultObsidiumArmorFireEffect);
					
		
		obsidiumBootsProtection = MECHANICRAFT_BUILDER.comment("Obsidium Boots Protection Amount, minimum is 1, maximum is 11(DEFAULT: 3)")
				.worldRestart().defineInRange("Obsidium Boots Protection: ", defaultObsidiumBootsProtection, 1, 11);
		
		obsidiumLeggingsProtection = MECHANICRAFT_BUILDER.comment("Obsidium Leggings Protection Amount, minimum is 3, maximum is 15(DEFAULT: 5)")
				.worldRestart().defineInRange("Obsidium Leggings Protection: ", defaultObsidiumLeggingsProtection, 3, 15);
		
		obsidiumChestplateProtection = MECHANICRAFT_BUILDER.comment("Obsidium Chestplate Protection Amount, minimum is 4, maximum is 16(DEFAULT: 7)")
				.worldRestart().defineInRange("Obsidium Chestplate Protection: ", defaultObsidiumChestplateProtection, 4, 16);
		
		obsidiumHelmetProtection = MECHANICRAFT_BUILDER.comment("Obsidium Helmet Protection Amount, minimum is 2, maximum is 13(DEFAULT: 4)")
				.worldRestart().defineInRange("Obsidium Helmet Protection: ", defaultObsidiumHelmetProtection, 2, 13);
				
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("SAPHONIUM ARMOR SETTINGS");
		
		saphoniumArmorDurability = MECHANICRAFT_BUILDER.comment("Saphonium Armor Durability, minimum is 2, maximum is 50(DEFAULT: 30)")
				.worldRestart().defineInRange("Saphonium Armor Durability: ", defaultSaphoniumArmorDurability, 2, 50);
		
		saphoniumArmorEnchantability = MECHANICRAFT_BUILDER.comment("Saphonium Armor Enchantability, minimum is 1, maximum is 30(DEFAULT: 12)")
				.worldRestart().defineInRange("Saphonium Armor Enchantability: ", defaultSaphoniumArmorEnchantability, 1, 30);
		
		saphoniumArmorToughness = MECHANICRAFT_BUILDER.comment("Saphonium Armor Toughness, minimum is 0.00, maximum is 10.00(DEFAULT: 2.00)")
				.worldRestart().defineInRange("Saphonium Armor Toughness: ", defaultSaphoniumArmorToughness, 0.00, 10.00);
		
		saphoniumArmorResistance = MECHANICRAFT_BUILDER.comment("Saphonium Armor Knockback Resistance, minimum is 0.00, maximum is 1.00(DEFAULT: 0.05)")
				.worldRestart().defineInRange("Saphonium Armor Resistance: ", defaultSaphoniumArmorResistance, 0.00, 1.00);
		
		
		saphoniumArmorWaterEffect = MECHANICRAFT_BUILDER.comment("Saphonium Water Breathing Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Water Breathing effect enabled: ", defaultSaphoniumArmorWaterEffect);
					
		
		saphoniumBootsProtection = MECHANICRAFT_BUILDER.comment("Saphonium Boots Protection Amount, minimum is 1, maximum is 11(DEFAULT: 3)")
				.worldRestart().defineInRange("Saphonium Boots Protection: ", defaultSaphoniumBootsProtection, 1, 11);
		
		saphoniumLeggingsProtection = MECHANICRAFT_BUILDER.comment("Saphonium Leggings Protection Amount, minimum is 3, maximum is 15(DEFAULT: 5)")
				.worldRestart().defineInRange("Saphonium Leggings Protection: ", defaultSaphoniumLeggingsProtection, 3, 15);
		
		saphoniumChestplateProtection = MECHANICRAFT_BUILDER.comment("Saphonium Chestplate Protection Amount, minimum is 4, maximum is 16(DEFAULT: 7)")
				.worldRestart().defineInRange("Saphonium Chestplate Protection: ", defaultSaphoniumChestplateProtection, 4, 16);
		
		saphoniumHelmetProtection = MECHANICRAFT_BUILDER.comment("Saphonium Helmet Protection Amount, minimum is 2, maximum is 13(DEFAULT: 4)")
				.worldRestart().defineInRange("Saphonium Helmet Protection: ", defaultSaphoniumHelmetProtection, 2, 13);
				
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("RUBONIUM ARMOR SETTINGS");
		
		ruboniumArmorDurability = MECHANICRAFT_BUILDER.comment("Rubonium Armor Durability, minimum is 2, maximum is 50(DEFAULT: 30)")
				.worldRestart().defineInRange("Rubonium Armor Durability: ", defaultRuboniumArmorDurability, 2, 50);
		
		ruboniumArmorEnchantability = MECHANICRAFT_BUILDER.comment("Rubonium Armor Enchantability, minimum is 1, maximum is 30(DEFAULT: 12)")
				.worldRestart().defineInRange("Rubonium Armor Enchantability: ", defaultRuboniumArmorEnchantability, 1, 30);
		
		ruboniumArmorToughness = MECHANICRAFT_BUILDER.comment("Rubonium Armor Toughness, minimum is 0.00, maximum is 10.00(DEFAULT: 2.00)")
				.worldRestart().defineInRange("Rubonium Armor Toughness: ", defaultRuboniumArmorToughness, 0.00, 10.00);
		
		ruboniumArmorResistance = MECHANICRAFT_BUILDER.comment("Rubonium Armor Knockback Resistance, minimum is 0.00, maximum is 1.00(DEFAULT: 0.05)")
				.worldRestart().defineInRange("Rubonium Armor Resistance: ", defaultRuboniumArmorResistance, 0.00, 1.00);
		
		
		ruboniumArmorHealthEffect = MECHANICRAFT_BUILDER.comment("Rubonium Health Boost, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Health boost effect enabled: ", defaultRuboniumArmorHealthEffect);
				
		
		ruboniumBootsProtection = MECHANICRAFT_BUILDER.comment("Rubonium Boots Protection Amount, minimum is 1, maximum is 11(DEFAULT: 3)")
				.worldRestart().defineInRange("Rubonium Boots Protection: ", defaultRuboniumBootsProtection, 1, 11);
		
		ruboniumLeggingsProtection = MECHANICRAFT_BUILDER.comment("Rubonium Leggings Protection Amount, minimum is 3, maximum is 15(DEFAULT: 5)")
				.worldRestart().defineInRange("Rubonium Leggings Protection: ", defaultRuboniumLeggingsProtection, 3, 15);
		
		ruboniumChestplateProtection = MECHANICRAFT_BUILDER.comment("Rubonium Chestplate Protection Amount, minimum is 4, maximum is 16(DEFAULT: 7)")
				.worldRestart().defineInRange("Rubonium Chestplate Protection: ", defaultRuboniumChestplateProtection, 4, 16);
		
		ruboniumHelmetProtection = MECHANICRAFT_BUILDER.comment("Rubonium Helmet Protection Amount, minimum is 2, maximum is 13(DEFAULT: 4)")
				.worldRestart().defineInRange("Rubonium Helmet Protection: ", defaultRuboniumHelmetProtection, 2, 13);
				
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("GLASS ARMOR SETTINGS");
		
		glassArmorDurability = MECHANICRAFT_BUILDER.comment("Glass Armor Durability, minimum is 2, maximum is 50(DEFAULT: 2)")
				.worldRestart().defineInRange("Glass Armor Durability: ", defaultGlassArmorDurability, 2, 50);
		
		glassArmorEnchantability = MECHANICRAFT_BUILDER.comment("Glass Armor Enchantability, minimum is 1, maximum is 30(DEFAULT: 20)")
				.worldRestart().defineInRange("Glass Armor Enchantability: ", defaultGlassArmorEnchantability, 1, 30);
		
		glassArmorToughness = MECHANICRAFT_BUILDER.comment("Glass Armor Toughness, minimum is 0.00, maximum is 10.00(DEFAULT: 0.00)")
				.worldRestart().defineInRange("Glass Armor Toughness: ", defaultGlassArmorToughness, 0.00, 10.00);
		
		glassArmorResistance = MECHANICRAFT_BUILDER.comment("Glass Armor Knockback Resistance, minimum is 0.00, maximum is 1.00(DEFAULT: 0.00)")
				.worldRestart().defineInRange("Glass Armor Resistance: ", defaultGlassArmorResistance, 0.00, 1.00);
		
		
		glassArmorSpeedEffect = MECHANICRAFT_BUILDER.comment("Glass Armor Speed Boost Effect, true is enabled, false is disabled(DEFAULT: true)")
					.worldRestart().define("Speed boost effect enabled: ", defaultGlassArmorSpeedEffect);
					
		
		glassBootsProtection = MECHANICRAFT_BUILDER.comment("Glass Boots Protection Amount, minimum is 1, maximum is 11(DEFAULT: 1)")
				.worldRestart().defineInRange("Glass Boots Protection: ", defaultGlassBootsProtection, 1, 11);
		
		glassLeggingsProtection = MECHANICRAFT_BUILDER.comment("Glass Leggings Protection Amount, minimum is 3, maximum is 15(DEFAULT: 3)")
				.worldRestart().defineInRange("Glass Leggings Protection: ", defaultGlassLeggingsProtection, 3, 15);
		
		glassChestplateProtection = MECHANICRAFT_BUILDER.comment("Glass Chestplate Protection Amount, minimum is 4, maximum is 16(DEFAULT: 4)")
				.worldRestart().defineInRange("Glass Chestplate Protection: ", defaultGlassChestplateProtection, 4, 16);
		
		glassHelmetProtection = MECHANICRAFT_BUILDER.comment("Glass Helmet Protection Amount, minimum is 2, maximum is 13(DEFAULT: 2)")
				.worldRestart().defineInRange("Glass Helmet Protection: ", defaultGlassHelmetProtection, 2, 13);
				
		MECHANICRAFT_BUILDER.pop();
		
		//Tools
		MECHANICRAFT_BUILDER.push("EMERONIUM TOOL SETTINGS");
		
		emeroniumHarvestLevel = MECHANICRAFT_BUILDER.comment("Emeronium Tools Harvest Level, minimum is 1, maximum is 100(DEFAULT: 3)")
				.worldRestart().defineInRange("Emeronium Tools Harvest Level: ", defaultEmeroniumHarvestLevel, 1, 100);
		
		emeroniumToolsDurability = MECHANICRAFT_BUILDER.comment("Emeronium Tools Durability, minimum is 1, maximum is 5000(DEFAULT: 1400)")
				.worldRestart().defineInRange("Emeronium Tools Durability: ", defaultEmeroniumToolsDurability, 1, 5000);
		
		emeroniumToolsEfficiency = MECHANICRAFT_BUILDER.comment("Emeronium Tools Efficiency, minimum is 1.00, maximum is 20.00(DEFAULT: 8.50)")
				.worldRestart().defineInRange("Emeronium Tools Efficiency: ", defaultEmeroniumToolsEfficiency, 1.00, 20.00);
		
		emeroniumToolsDamage = MECHANICRAFT_BUILDER.comment("Emeronium Tools Damage, minimum is 1.00, maximum is 20.00(DEFAULT: 3.75)")
				.worldRestart().defineInRange("Emeronium Tools Damage: ", defaultEmeroniumToolsDamage, 1.00, 20.00);
		
		emeroniumToolsEnchantability = MECHANICRAFT_BUILDER.comment("Emeronium Tools Enchantability, minimum is 1, maximum is 30(DEFAULT: 12)")
				.worldRestart().defineInRange("Emeronium Tools Enchantability: ", defaultEmeroniumToolsEnchantability, 1, 30);
				
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("ENDONIUM TOOL SETTINGS");
		
		endoniumHarvestLevel = MECHANICRAFT_BUILDER.comment("Endonium Tools Harvest Level, minimum is 1, maximum is 100(DEFAULT: 3)")
				.worldRestart().defineInRange("Endonium Tools Harvest Level: ", defaultEndoniumHarvestLevel, 1, 100);
		
		endoniumToolsDurability = MECHANICRAFT_BUILDER.comment("Endonium Tools Durability, minimum is 1, maximum is 5000(DEFAULT: 1800)")
				.worldRestart().defineInRange("Endonium Tools Durability: ", defaultEndoniumToolsDurability, 1, 5000);
		
		endoniumToolsEfficiency = MECHANICRAFT_BUILDER.comment("Endonium Tools Efficiency, minimum is 1.00, maximum is 20.00(DEFAULT: 9.00)")
				.worldRestart().defineInRange("Endonium Tools Efficiency: ", defaultEndoniumToolsEfficiency, 1.00, 20.00);
		
		endoniumToolsDamage = MECHANICRAFT_BUILDER.comment("Endonium Tools Damage, minimum is 1.00, maximum is 20.00(DEFAULT: 5.00)")
				.worldRestart().defineInRange("Endonium Tools Damage: ", defaultEndoniumToolsDamage, 1.00, 20.00);
		
		endoniumToolsEnchantability = MECHANICRAFT_BUILDER.comment("Endonium Tools Enchantability, minimum is 1, maximum is 30(DEFAULT: 14)")
				.worldRestart().defineInRange("Endonium Tools Enchantability: ", defaultEndoniumToolsEnchantability, 1, 30);
				
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("ENDONIUM CRYSTAL TOOL SETTINGS").comment("Tools Settings");
		
		endoniumCrystalHarvestLevel = MECHANICRAFT_BUILDER.comment("Endonium Crystal Tools Harvest Level, minimum is 1, maximum is 100(DEFAULT: 4)")
				.worldRestart().defineInRange("Endonium Crystal Tools Harvest Level: ", defaultEndoniumCrystalHarvestLevel, 1, 100);
		
		endoniumCrystalToolsDurability = MECHANICRAFT_BUILDER.comment("Endonium Crystal Tools Durability, minimum is 1, maximum is 5000(DEFAULT: 2200)")
				.worldRestart().defineInRange("Endonium Crystal Tools Durability: ", defaultEndoniumCrystalToolsDurability, 1, 5000);
		
		endoniumCrystalToolsEfficiency = MECHANICRAFT_BUILDER.comment("Endonium Crystal Tools Efficiency, minimum is 1.00, maximum is 20.00(DEFAULT: 10.00)")
				.worldRestart().defineInRange("Endonium Crystal Tools Efficiency: ", defaultEndoniumCrystalToolsEfficiency, 1.00, 20.00);
		
		endoniumCrystalToolsDamage = MECHANICRAFT_BUILDER.comment("Endonium Crystal Tools Damage, minimum is 1.00, maximum is 20.00(DEFAULT: 6.00)")
				.worldRestart().defineInRange("Endonium Crystal Tools Damage: ", defaultEndoniumCrystalToolsDamage, 1.00, 20.00);
		
		endoniumCrystalToolsEnchantability = MECHANICRAFT_BUILDER.comment("Endonium Crystal Tools Enchantability, minimum is 1, maximum is 30(DEFAULT: 16)")
				.worldRestart().defineInRange("Endonium Crystal Tools Enchantability: ", defaultEndoniumCrystalToolsEnchantability, 1, 30);
				
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("OBSIDIUM TOOL SETTINGS");
		
		obsidiumHarvestLevel = MECHANICRAFT_BUILDER.comment("Obsidium Tools Harvest Level, minimum is 1, maximum is 100(DEFAULT: 3)")
				.worldRestart().defineInRange("Obsidium Tools Harvest Level: ", defaultObsidiumHarvestLevel, 1, 100);
		
		obsidiumToolsDurability = MECHANICRAFT_BUILDER.comment("Obsidium Tools Durability, minimum is 1, maximum is 5000(DEFAULT: 1600)")
				.worldRestart().defineInRange("Obsidium Tools Durability: ", defaultObsidiumToolsDurability, 1, 5000);
		
		obsidiumToolsEfficiency = MECHANICRAFT_BUILDER.comment("Obsidium Tools Efficiency, minimum is 1.00, maximum is 20.00(DEFAULT: 6.00)")
				.worldRestart().defineInRange("Obsidium Tools Efficiency: ", defaultObsidiumToolsEfficiency, 1.00, 20.00);
		
		obsidiumToolsDamage = MECHANICRAFT_BUILDER.comment("Obsidium Tools Damage, minimum is 1.00, maximum is 20.00(DEFAULT: 4.00)")
				.worldRestart().defineInRange("Obsidium Tools Damage: ", defaultObsidiumToolsDamage, 1.00, 20.00);
		
		obsidiumToolsEnchantability = MECHANICRAFT_BUILDER.comment("Obsidium Tools Enchantability, minimum is 1, maximum is 30(DEFAULT: 12)")
				.worldRestart().defineInRange("Obsidium Tools Enchantability: ", defaultObsidiumToolsEnchantability, 1, 30);
				
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("SAPHONIUM TOOL SETTINGS").comment("Tools Settings");
		
		saphoniumHarvestLevel = MECHANICRAFT_BUILDER.comment("Saphonium Tools Harvest Level, minimum is 1, maximum is 100(DEFAULT: 3)")
				.worldRestart().defineInRange("Saphonium Tools Harvest Level: ", defaultSaphoniumHarvestLevel, 1, 100);
		
		saphoniumToolsDurability = MECHANICRAFT_BUILDER.comment("Saphonium Tools Durability, minimum is 1, maximum is 5000(DEFAULT: 1400)")
				.worldRestart().defineInRange("Saphonium Tools Durability: ", defaultSaphoniumToolsDurability, 1, 5000);
		
		saphoniumToolsEfficiency = MECHANICRAFT_BUILDER.comment("Saphonium Tools Efficiency, minimum is 1.00, maximum is 20.00(DEFAULT: 8.50)")
				.worldRestart().defineInRange("Saphonium Tools Efficiency: ", defaultSaphoniumToolsEfficiency, 1.00, 20.00);
		
		saphoniumToolsDamage = MECHANICRAFT_BUILDER.comment("Saphonium Tools Damage, minimum is 1.00, maximum is 20.00(DEFAULT: 3.75)")
				.worldRestart().defineInRange("Saphonium Tools Damage: ", defaultSaphoniumToolsDamage, 1.00, 20.00);
		
		saphoniumToolsEnchantability = MECHANICRAFT_BUILDER.comment("Saphonium Tools Enchantability, minimum is 1, maximum is 30(DEFAULT: 12)")
				.worldRestart().defineInRange("Saphonium Tools Enchantability: ", defaultSaphoniumToolsEnchantability, 1, 30);
				
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("RUBONIUM TOOL SETTINGS").comment("Tools Settings");
		
		ruboniumHarvestLevel = MECHANICRAFT_BUILDER.comment("Rubonium Tools Harvest Level, minimum is 1, maximum is 100(DEFAULT: 3)")
				.worldRestart().defineInRange("Rubonium Tools Harvest Level: ", defaultRuboniumHarvestLevel, 1, 100);
		
		ruboniumToolsDurability = MECHANICRAFT_BUILDER.comment("Rubonium Tools Durability, minimum is 1, maximum is 5000(DEFAULT: 1400)")
				.worldRestart().defineInRange("Rubonium Tools Durability: ", defaultRuboniumToolsDurability, 1, 5000);
		
		ruboniumToolsEfficiency = MECHANICRAFT_BUILDER.comment("Rubonium Tools Efficiency, minimum is 1.00, maximum is 20.00(DEFAULT: 8.50)")
				.worldRestart().defineInRange("Rubonium Tools Efficiency: ", defaultRuboniumToolsEfficiency, 1.00, 20.00);
		
		ruboniumToolsDamage = MECHANICRAFT_BUILDER.comment("Rubonium Tools Damage, minimum is 1.00, maximum is 20.00(DEFAULT: 3.75)")
				.worldRestart().defineInRange("Rubonium Tools Damage: ", defaultRuboniumToolsDamage, 1.00, 20.00);
		
		ruboniumToolsEnchantability = MECHANICRAFT_BUILDER.comment("Rubonium Tools Enchantability, minimum is 1, maximum is 30(DEFAULT: 12)")
				.worldRestart().defineInRange("Rubonium Tools Enchantability: ", defaultRuboniumToolsEnchantability, 1, 30);
				
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_BUILDER.push("GLASS TOOL SETTINGS");
		
		glassHarvestLevel = MECHANICRAFT_BUILDER.comment("Glass Tools Harvest Level, minimum is 1, maximum is 100(DEFAULT: 1)")
				.worldRestart().defineInRange("Glass Tools Harvest Level: ", defaultGlassHarvestLevel, 1, 100);
		
		glassToolsDurability = MECHANICRAFT_BUILDER.comment("Glass Tools Durability, minimum is 1, maximum is 5000(DEFAULT: 30)")
				.worldRestart().defineInRange("Glass Tools Durability: ", defaultGlassToolsDurability, 1, 5000);
		
		glassToolsEfficiency = MECHANICRAFT_BUILDER.comment("Glass Tools Efficiency, minimum is 1.00, maximum is 20.00(DEFAULT: 1.50)")
				.worldRestart().defineInRange("Glass Tools Efficiency: ", defaultGlassToolsEfficiency, 1.00, 20.00);
		
		glassToolsDamage = MECHANICRAFT_BUILDER.comment("Glass Tools Damage, minimum is 1.00, maximum is 20.00(DEFAULT: 6.00)")
				.worldRestart().defineInRange("Glass Tools Damage: ", defaultGlassToolsDamage, 1.00, 20.00);
		
		glassToolsEnchantability = MECHANICRAFT_BUILDER.comment("Glass Tools Enchantability, minimum is 1, maximum is 30(DEFAULT: 20)")
				.worldRestart().defineInRange("Glass Tools Enchantability: ", defaultGlassToolsEnchantability, 1, 30);
				
		MECHANICRAFT_BUILDER.pop();
		
		//Mesh
		MECHANICRAFT_BUILDER.push("MESH SETTINGS");
		
		stringMeshDurability = MECHANICRAFT_BUILDER.comment("String Mesh Durability, minimum is 1, maximum is 640000(DEFAULT: 64)")
				.worldRestart().defineInRange("String Mesh Durability: ", defaultStringMeshDurability, 1, 640000);
		
		reinforcedStringMeshDurability = MECHANICRAFT_BUILDER.comment("Reinforced String Mesh Durability, minimum is 1, maximum is 640000(DEFAULT: 128)")
				.worldRestart().defineInRange("Reinforced String Mesh Durability: ", defaultReinforcedStringMeshDurability, 1, 640000);
		
		ironMeshDurability = MECHANICRAFT_BUILDER.comment("Iron Mesh Durability, minimum is 1, maximum is 640000(DEFAULT: 256)")
				.worldRestart().defineInRange("Iron Mesh Durability: ", defaultIronMeshDurability, 1, 640000);
		
		reinforcedIronMeshDurability = MECHANICRAFT_BUILDER.comment("Reinforced Iron Mesh Durability, minimum is 1, maximum is 640000(DEFAULT: 512)")
				.worldRestart().defineInRange("Reinforced Iron Mesh Durability: ", defaultReinforcedIronMeshDurability, 1, 640000);
		
		steelMeshDurability = MECHANICRAFT_BUILDER.comment("Steel Mesh Durability, minimum is 1, maximum is 640000(DEFAULT: 8192)")
				.worldRestart().defineInRange("Steel Mesh Durability: ", defaultSteelMeshDurability, 1, 640000);
		
		reinforcedSteelMeshDurability = MECHANICRAFT_BUILDER.comment("Reinforced Steel Mesh Durability, minimum is 1, maximum is 640000(DEFAULT: 2048)")
				.worldRestart().defineInRange("Reinforced Steel Mesh Durability: ", defaultReinforcedSteelMeshDurability, 1, 640000);
		
		diamondMeshDurability = MECHANICRAFT_BUILDER.comment("Diamond Mesh Durability, minimum is 1, maximum is 640000(DEFAULT: 4096)")
				.worldRestart().defineInRange("Diamond Mesh Durability: ", defaultDiamondMeshDurability, 1, 640000);
		
		reinforcedDiamondMeshDurability = MECHANICRAFT_BUILDER.comment("Reinforced Diamond Mesh Durability, minimum is 1, maximum is 640000(DEFAULT: 8192)")
				.worldRestart().defineInRange("Reinforced Diamond Mesh Durability: ", defaultReinforcedDiamondMeshDurability, 1, 640000);
		
		gemMeshDurability = MECHANICRAFT_BUILDER.comment("Gem Mesh Durability, minimum is 1, maximum is 640000(DEFAULT: 16384)")
				.worldRestart().defineInRange("Gem Mesh Durability: ", defaultGemMeshDurability, 1, 640000);
		
		reinforcedGemMeshDurability = MECHANICRAFT_BUILDER.comment("Reinforced Gem Mesh Durability, minimum is 1, maximum is 640000(DEFAULT: 32768)")
				.worldRestart().defineInRange("Reinforced Gem Mesh Durability: ", defaultReinforcedGemMeshDurability, 1, 640000);
		
		endoniumMeshDurability = MECHANICRAFT_BUILDER.comment("Endonium Mesh Durability, minimum is 1, maximum is 640000(DEFAULT: 65536)")
				.worldRestart().defineInRange("Endonium Mesh Durability: ", defaultEndoniumMeshDurability, 1, 640000);
		
		reinforcedEndoniumMeshDurability = MECHANICRAFT_BUILDER.comment("Reinforced Endonium Mesh Durability, minimum is 1, maximum is 640000(DEFAULT: 131072)")
				.worldRestart().defineInRange("Reinforced Endonium Mesh Durability: ", defaultReinforcedEndoniumMeshDurability, 1, 640000);
		
		MECHANICRAFT_BUILDER.pop();
		
		MECHANICRAFT_SPEC = MECHANICRAFT_BUILDER.build();
	}

	public static void bakeConfig() {
		
		//Ore Gen
		copperGenBool = copperGen.get();
		leadGenBool = leadGen.get();
		tinGenBool = tinGen.get();
		silverGenBool = silverGen.get();
		rubyGenHillsBool = rubyGenHills.get();
		sapphireGenHillsBool = rubyGenHills.get();
		rubyGenAllBool = rubyGenAll.get();
		sapphireGenAllBool = sapphireGenAll.get();
		enderGenBool = enderGen.get();
		
		copperVeinSizeInt = copperVeinSize.get();
		copperMinYInt = copperMinY.get();
		copperMaxYInt = copperMaxY.get();
		copperVeinsPerChunkInt = copperVeinsPerChunk.get();
		
		leadVeinSizeInt = leadVeinSize.get();
		leadMinYInt = leadMinY.get();
		leadMaxYInt = leadMaxY.get();
		leadVeinsPerChunkInt = leadVeinsPerChunk.get();
		
		tinVeinSizeInt = tinVeinSize.get();
		tinMinYInt = tinMinY.get();
		tinMaxYInt = tinMaxY.get();
		tinVeinsPerChunkInt = tinVeinsPerChunk.get();
		
		silverVeinSizeInt = silverVeinSize.get();
		silverMinYInt = silverMinY.get();
		silverMaxYInt = silverMaxY.get();
		silverVeinsPerChunkInt = silverVeinsPerChunk.get();
		
		rubyVeinSizeInt = rubyVeinSize.get();
		rubyMinYInt = rubyMinY.get();
		rubyMaxYInt = rubyMaxY.get();
		rubyVeinsPerChunkInt = rubyVeinsPerChunk.get();
		
		sapphireVeinSizeInt = sapphireVeinSize.get();
		sapphireMinYInt = sapphireMinY.get();
		sapphireMaxYInt = sapphireMaxY.get();
		sapphireVeinsPerChunkInt = sapphireVeinsPerChunk.get();
		
		enderVeinSizeInt = enderVeinSize.get();
		enderMinYInt = enderMinY.get();
		enderMaxYInt = enderMaxY.get();
		enderVeinsPerChunkInt = enderVeinsPerChunk.get();
		
		//Machine Config
		//(Basic)
		basicCoalGeneratorCapacityInt = basicCoalGeneratorCapacity.get();
		basicCoalGeneratorExtractInt = basicCoalGeneratorExtract.get();
		basicFurnaceCapacityInt = basicFurnaceCapacity.get();
		basicFurnaceReceiveInt = basicFurnaceReceive.get();
		
		basicCoalGeneratorPowerGenInt = basicCoalGeneratorPowerGen.get();
		basicFurnaceWorkTimeInt = basicFurnaceWorkTime.get();
		basicFurnaceEnergyPerTickInt = basicFurnaceEnergyPerTick.get();
		
		//(Advanced)
		advancedCoalGeneratorCapacityInt = advancedCoalGeneratorCapacity.get();
		advancedCoalGeneratorExtractInt = advancedCoalGeneratorExtract.get();
		advancedFurnaceCapacityInt = advancedFurnaceCapacity.get();
		advancedFurnaceReceiveInt = advancedFurnaceReceive.get();
		
		advancedCoalGeneratorPowerGenInt = advancedCoalGeneratorPowerGen.get();
		advancedFurnaceWorkTimeInt = advancedFurnaceWorkTime.get();
		advancedFurnaceEnergyPerTickInt = advancedFurnaceEnergyPerTick.get();
		
		//(Tier 1)
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

		t1CrusherWorkTimeInt = t1CrusherWorkTime.get();
		t1CrusherEnergyPerTickInt = t1CrusherEnergyPerTick.get();
		t1InfuserWorkTimeInt = t1InfuserWorkTime.get();
		t1InfuserEnergyPerTickInt = t1InfuserEnergyPerTick.get();
		t1OreWasherWorkTimeInt = t1OreWasherWorkTime.get();
		t1OreWasherEnergyPerTickInt = t1OreWasherEnergyPerTick.get();
		t1PoweredSieveWorkTimeInt = t1PoweredSieveWorkTime.get();
		t1PoweredSieveEnergyPerTickInt = t1PoweredSieveEnergyPerTick.get();
		t1PressWorkTimeInt = t1PressWorkTime.get();
		t1PressEnergyPerTickInt = t1PressEnergyPerTick.get();
		t1SlurryProcessorWorkTimeInt = t1SlurryProcessorWorkTime.get();
		t1SlurryProcessorEnergyPerTickInt = t1SlurryProcessorEnergyPerTick.get();
		
		//(Tier 2)
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

		t2CrusherWorkTimeInt = t2CrusherWorkTime.get();
		t2CrusherEnergyPerTickInt = t2CrusherEnergyPerTick.get();
		t2InfuserWorkTimeInt = t2InfuserWorkTime.get();
		t2InfuserEnergyPerTickInt = t2InfuserEnergyPerTick.get();
		t2OreWasherWorkTimeInt = t2OreWasherWorkTime.get();
		t2OreWasherEnergyPerTickInt = t2OreWasherEnergyPerTick.get();
		t2PoweredSieveWorkTimeInt = t2PoweredSieveWorkTime.get();
		t2PoweredSieveEnergyPerTickInt = t2PoweredSieveEnergyPerTick.get();
		t2PressWorkTimeInt = t2PressWorkTime.get();
		t2PressEnergyPerTickInt = t2PressEnergyPerTick.get();
		t2SlurryProcessorWorkTimeInt = t2SlurryProcessorWorkTime.get();
		t2SlurryProcessorEnergyPerTickInt = t2SlurryProcessorEnergyPerTick.get();
		
		//(Tier 3)
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

		t3CrusherWorkTimeInt = t3CrusherWorkTime.get();
		t3CrusherEnergyPerTickInt = t3CrusherEnergyPerTick.get();
		t3InfuserWorkTimeInt = t3InfuserWorkTime.get();
		t3InfuserEnergyPerTickInt = t3InfuserEnergyPerTick.get();
		t3OreWasherWorkTimeInt = t3OreWasherWorkTime.get();
		t3OreWasherEnergyPerTickInt = t3OreWasherEnergyPerTick.get();
		t3PoweredSieveWorkTimeInt = t3PoweredSieveWorkTime.get();
		t3PoweredSieveEnergyPerTickInt = t3PoweredSieveEnergyPerTick.get();
		t3PressWorkTimeInt = t3PressWorkTime.get();
		t3PressEnergyPerTickInt = t3PressEnergyPerTick.get();
		t3SlurryProcessorWorkTimeInt = t3SlurryProcessorWorkTime.get();
		t3SlurryProcessorEnergyPerTickInt = t3SlurryProcessorEnergyPerTick.get();
		
		//(Tier 4)
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

		t4CrusherWorkTimeInt = t4CrusherWorkTime.get();
		t4CrusherEnergyPerTickInt = t4CrusherEnergyPerTick.get();
		t4InfuserWorkTimeInt = t4InfuserWorkTime.get();
		t4InfuserEnergyPerTickInt = t4InfuserEnergyPerTick.get();
		t4OreWasherWorkTimeInt = t4OreWasherWorkTime.get();
		t4OreWasherEnergyPerTickInt = t4OreWasherEnergyPerTick.get();
		t4PoweredSieveWorkTimeInt = t4PoweredSieveWorkTime.get();
		t4PoweredSieveEnergyPerTickInt = t4PoweredSieveEnergyPerTick.get();
		t4PressWorkTimeInt = t4PressWorkTime.get();
		t4PressEnergyPerTickInt = t4PressEnergyPerTick.get();
		t4SlurryProcessorWorkTimeInt = t4SlurryProcessorWorkTime.get();
		t4SlurryProcessorEnergyPerTickInt = t4SlurryProcessorEnergyPerTick.get();
		
		//(Tier 5)
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

		t5CrusherWorkTimeInt = t5CrusherWorkTime.get();
		t5CrusherEnergyPerTickInt = t5CrusherEnergyPerTick.get();
		t5InfuserWorkTimeInt = t5InfuserWorkTime.get();
		t5InfuserEnergyPerTickInt = t5InfuserEnergyPerTick.get();
		t5OreWasherWorkTimeInt = t5OreWasherWorkTime.get();
		t5OreWasherEnergyPerTickInt = t5OreWasherEnergyPerTick.get();
		t5PoweredSieveWorkTimeInt = t5PoweredSieveWorkTime.get();
		t5PoweredSieveEnergyPerTickInt = t5PoweredSieveEnergyPerTick.get();
		t5PressWorkTimeInt = t5PressWorkTime.get();
		t5PressEnergyPerTickInt = t5PressEnergyPerTick.get();
		t5SlurryProcessorWorkTimeInt = t5SlurryProcessorWorkTime.get();
		t5SlurryProcessorEnergyPerTickInt = t5SlurryProcessorEnergyPerTick.get();
		
		//(Tier 6)
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

		t6CrusherWorkTimeInt = t6CrusherWorkTime.get();
		t6CrusherEnergyPerTickInt = t6CrusherEnergyPerTick.get();
		t6InfuserWorkTimeInt = t6InfuserWorkTime.get();
		t6InfuserEnergyPerTickInt = t6InfuserEnergyPerTick.get();
		t6OreWasherWorkTimeInt = t6OreWasherWorkTime.get();
		t6OreWasherEnergyPerTickInt = t6OreWasherEnergyPerTick.get();
		t6PoweredSieveWorkTimeInt = t6PoweredSieveWorkTime.get();
		t6PoweredSieveEnergyPerTickInt = t6PoweredSieveEnergyPerTick.get();
		t6PressWorkTimeInt = t6PressWorkTime.get();
		t6PressEnergyPerTickInt = t6PressEnergyPerTick.get();
		t6SlurryProcessorWorkTimeInt = t6SlurryProcessorWorkTime.get();
		t6SlurryProcessorEnergyPerTickInt = t6SlurryProcessorEnergyPerTick.get();
		
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
		
		//Item Config
		//(Mesh)
		stringMeshDurabilityInt = stringMeshDurability.get();
		reinforcedStringMeshDurabilityInt = reinforcedStringMeshDurability.get();
		ironMeshDurabilityInt = ironMeshDurability.get();
		reinforcedIronMeshDurabilityInt = reinforcedIronMeshDurability.get();
		steelMeshDurabilityInt = steelMeshDurability.get();
		reinforcedSteelMeshDurabilityInt = reinforcedSteelMeshDurability.get();
		diamondMeshDurabilityInt = diamondMeshDurability.get();
		reinforcedDiamondMeshDurabilityInt = reinforcedDiamondMeshDurability.get();
		gemMeshDurabilityInt = gemMeshDurability.get();
		reinforcedGemMeshDurabilityInt = reinforcedGemMeshDurability.get();
		endoniumMeshDurabilityInt = endoniumMeshDurability.get();
		reinforcedEndoniumMeshDurabilityInt = reinforcedEndoniumMeshDurability.get();
		
		//(Armor)
		armorEffectsBool = armorEffects.get();
		
		//[Emeronium]
		emeroniumArmorDurabilityInt = emeroniumArmorDurability.get();
		emeroniumArmorEnchantabilityInt = emeroniumArmorEnchantability.get();
		emeroniumArmorToughnessFloat = emeroniumArmorToughness.get();
		emeroniumArmorResistanceFloat = emeroniumArmorResistance.get();
		
		emeroniumBootsProtectionInt = emeroniumBootsProtection.get();
		emeroniumLeggingsProtectionInt = emeroniumLeggingsProtection.get();
		emeroniumChestplateProtectionInt = emeroniumChestplateProtection.get();
		emeroniumHelmetProtectionInt = emeroniumHelmetProtection.get();

		emeroniumArmorHeroEffectBool = emeroniumArmorHeroEffect.get();
		
		//[Endonium]
		endoniumArmorDurabilityInt = endoniumArmorDurability.get();
		endoniumArmorEnchantabilityInt = endoniumArmorEnchantability.get();
		endoniumArmorToughnessFloat = endoniumArmorToughness.get();
		endoniumArmorResistanceFloat = endoniumArmorResistance.get();
		
		endoniumBootsProtectionInt = endoniumBootsProtection.get();
		endoniumLeggingsProtectionInt = endoniumLeggingsProtection.get();
		endoniumChestplateProtectionInt = endoniumChestplateProtection.get();
		endoniumHelmetProtectionInt = endoniumHelmetProtection.get();

		endoniumArmorHealthEffectBool = endoniumArmorHealthEffect.get();
		endoniumArmorSpeedEffectBool = endoniumArmorSpeedEffect.get();
		endoniumArmorHeroEffectBool = endoniumArmorHeroEffect.get();
		endoniumArmorFireEffectBool = endoniumArmorFireEffect.get();
		endoniumArmorWaterEffectBool = endoniumArmorWaterEffect.get();
		endoniumArmorVisionEffectBool = endoniumArmorVisionEffect.get();
		
		//[Endonium Crystal]
		endoniumCrystalArmorDurabilityInt = endoniumCrystalArmorDurability.get();
		endoniumCrystalArmorEnchantabilityInt = endoniumCrystalArmorEnchantability.get();
		endoniumCrystalArmorToughnessFloat = endoniumCrystalArmorToughness.get();
		endoniumCrystalArmorResistanceFloat = endoniumCrystalArmorResistance.get();
		
		endoniumCrystalBootsProtectionInt = endoniumCrystalBootsProtection.get();
		endoniumCrystalLeggingsProtectionInt = endoniumCrystalLeggingsProtection.get();
		endoniumCrystalChestplateProtectionInt = endoniumCrystalChestplateProtection.get();
		endoniumCrystalHelmetProtectionInt = endoniumCrystalHelmetProtection.get();

		endoniumCrystalArmorHealthEffectBool = endoniumCrystalArmorHealthEffect.get();
		endoniumCrystalArmorFlightEffectBool = endoniumCrystalArmorFlightEffect.get();
		endoniumCrystalArmorSpeedEffectBool = endoniumCrystalArmorSpeedEffect.get();
		endoniumCrystalArmorHeroEffectBool = endoniumCrystalArmorHeroEffect.get();
		endoniumCrystalArmorFireEffectBool = endoniumCrystalArmorFireEffect.get();
		endoniumCrystalArmorWaterEffectBool = endoniumCrystalArmorWaterEffect.get();
		endoniumCrystalArmorVisionEffectBool = endoniumCrystalArmorVisionEffect.get();
		
		//[Saphonium]
		saphoniumArmorDurabilityInt = saphoniumArmorDurability.get();
		saphoniumArmorEnchantabilityInt = saphoniumArmorEnchantability.get();
		saphoniumArmorToughnessFloat = saphoniumArmorToughness.get();
		saphoniumArmorResistanceFloat = saphoniumArmorResistance.get();
		
		saphoniumBootsProtectionInt = saphoniumBootsProtection.get();
		saphoniumLeggingsProtectionInt = saphoniumLeggingsProtection.get();
		saphoniumChestplateProtectionInt = saphoniumChestplateProtection.get();
		saphoniumHelmetProtectionInt = saphoniumHelmetProtection.get();

		saphoniumArmorWaterEffectBool = saphoniumArmorWaterEffect.get();
		
		//[Rubonium]
		ruboniumArmorDurabilityInt = ruboniumArmorDurability.get();
		ruboniumArmorEnchantabilityInt = ruboniumArmorEnchantability.get();
		ruboniumArmorToughnessFloat = ruboniumArmorToughness.get();
		ruboniumArmorResistanceFloat = ruboniumArmorResistance.get();
		
		ruboniumBootsProtectionInt = ruboniumBootsProtection.get();
		ruboniumLeggingsProtectionInt = ruboniumLeggingsProtection.get();
		ruboniumChestplateProtectionInt = ruboniumChestplateProtection.get();
		ruboniumHelmetProtectionInt = ruboniumHelmetProtection.get();

		ruboniumArmorHealthEffectBool = ruboniumArmorHealthEffect.get();
		
		//[Obsidium]
		obsidiumArmorDurabilityInt = obsidiumArmorDurability.get();
		obsidiumArmorEnchantabilityInt = obsidiumArmorEnchantability.get();
		obsidiumArmorToughnessFloat = obsidiumArmorToughness.get();
		obsidiumArmorResistanceFloat = obsidiumArmorResistance.get();
		
		obsidiumBootsProtectionInt = obsidiumBootsProtection.get();
		obsidiumLeggingsProtectionInt = obsidiumLeggingsProtection.get();
		obsidiumChestplateProtectionInt = obsidiumChestplateProtection.get();
		obsidiumHelmetProtectionInt = obsidiumHelmetProtection.get();

		obsidiumArmorFireEffectBool = obsidiumArmorFireEffect.get();
		
		//[Glass]
		glassArmorDurabilityInt = glassArmorDurability.get();
		glassArmorEnchantabilityInt = glassArmorEnchantability.get();
		glassArmorToughnessFloat = glassArmorToughness.get();
		glassArmorResistanceFloat = glassArmorResistance.get();
		
		glassBootsProtectionInt = glassBootsProtection.get();
		glassLeggingsProtectionInt = glassLeggingsProtection.get();
		glassChestplateProtectionInt = glassChestplateProtection.get();
		glassHelmetProtectionInt = glassHelmetProtection.get();

		glassArmorSpeedEffectBool = glassArmorSpeedEffect.get();
		
		//(Tools)
		//[Emeronium]
		emeroniumHarvestLevelInt = emeroniumHarvestLevel.get();
		emeroniumToolsDurabilityInt = emeroniumToolsDurability.get();
		emeroniumToolsEfficiencyFloat = emeroniumToolsEfficiency.get();
		emeroniumToolsDamageFloat = emeroniumToolsDamage.get();
		emeroniumToolsEnchantabilityInt = emeroniumToolsEnchantability.get();
		
		//[Endonium]
		endoniumHarvestLevelInt = endoniumHarvestLevel.get();
		endoniumToolsDurabilityInt = endoniumToolsDurability.get();
		endoniumToolsEfficiencyFloat = endoniumToolsEfficiency.get();
		endoniumToolsDamageFloat = endoniumToolsDamage.get();
		endoniumToolsEnchantabilityInt = endoniumToolsEnchantability.get();
		
		//[Endonium Crystal]
		endoniumCrystalHarvestLevelInt = endoniumCrystalHarvestLevel.get();
		endoniumCrystalToolsDurabilityInt = endoniumCrystalToolsDurability.get();
		endoniumCrystalToolsEfficiencyFloat = endoniumCrystalToolsEfficiency.get();
		endoniumCrystalToolsDamageFloat = endoniumCrystalToolsDamage.get();
		endoniumCrystalToolsEnchantabilityInt = endoniumCrystalToolsEnchantability.get();
		
		//[Saphonium]
		saphoniumHarvestLevelInt = saphoniumHarvestLevel.get();
		saphoniumToolsDurabilityInt = saphoniumToolsDurability.get();
		saphoniumToolsEfficiencyFloat = saphoniumToolsEfficiency.get();
		saphoniumToolsDamageFloat = saphoniumToolsDamage.get();
		saphoniumToolsEnchantabilityInt = saphoniumToolsEnchantability.get();
		
		//[Rubonium]
		ruboniumHarvestLevelInt = ruboniumHarvestLevel.get();
		ruboniumToolsDurabilityInt = ruboniumToolsDurability.get();
		ruboniumToolsEfficiencyFloat = ruboniumToolsEfficiency.get();
		ruboniumToolsDamageFloat = ruboniumToolsDamage.get();
		ruboniumToolsEnchantabilityInt = ruboniumToolsEnchantability.get();
		
		//[Obsidium]
		obsidiumHarvestLevelInt = obsidiumHarvestLevel.get();
		obsidiumToolsDurabilityInt = obsidiumToolsDurability.get();
		obsidiumToolsEfficiencyFloat = obsidiumToolsEfficiency.get();
		obsidiumToolsDamageFloat = obsidiumToolsDamage.get();
		obsidiumToolsEnchantabilityInt = obsidiumToolsEnchantability.get();
		
		//[Glass]
		glassHarvestLevelInt = glassHarvestLevel.get();
		glassToolsDurabilityInt = glassToolsDurability.get();
		glassToolsEfficiencyFloat = glassToolsEfficiency.get();
		glassToolsDamageFloat = glassToolsDamage.get();
		glassToolsEnchantabilityInt = glassToolsEnchantability.get();
	}
}