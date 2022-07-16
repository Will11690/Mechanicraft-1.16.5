package com.github.will11690.mechanicraft.init;

import com.github.will11690.mechanicraft.util.Reference;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModFeatures {
	
	private static final RuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);

    public static ConfiguredFeature<?, ?> SILVER_ORE_FEATURE;
    public static ConfiguredFeature<?, ?> COPPER_ORE_FEATURE;
    public static ConfiguredFeature<?, ?> TIN_ORE_FEATURE;
    public static ConfiguredFeature<?, ?> LEAD_ORE_FEATURE;
    
    public static ConfiguredFeature<?, ?> RUBY_ORE_FEATURE;
    public static ConfiguredFeature<?, ?> SAPPHIRE_ORE_FEATURE;
    
    public static ConfiguredFeature<?, ?> ENDER_ORE_FEATURE;

    public static void registerEvent(FMLCommonSetupEvent event) {
    	
    	//ALL(OVERWORLD)
    	SILVER_ORE_FEATURE = register(Reference.MOD_ID +":silver_ore", Feature.ORE.configured
    	(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.SILVER_ORE.get().defaultBlockState(), ModConfigs.silverVeinSizeInt))
    	.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(ModConfigs.silverMinYInt, 0, ModConfigs.silverMaxYInt))).squared().count(ModConfigs.silverVeinsPerChunkInt));
    	
    	COPPER_ORE_FEATURE = register(Reference.MOD_ID +":copper_ore", Feature.ORE.configured
    	(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.COPPER_ORE.get().defaultBlockState(), ModConfigs.copperVeinSizeInt))
    	.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(ModConfigs.copperMinYInt, 0, ModConfigs.copperMaxYInt))).squared().count(ModConfigs.copperVeinsPerChunkInt));
    	
    	TIN_ORE_FEATURE = register(Reference.MOD_ID +":tin_ore", Feature.ORE.configured
    	(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.TIN_ORE.get().defaultBlockState(), ModConfigs.tinVeinSizeInt))
    	.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(ModConfigs.tinMinYInt, 0, ModConfigs.tinMaxYInt))).squared().count(ModConfigs.tinVeinsPerChunkInt));
    	
    	LEAD_ORE_FEATURE = register(Reference.MOD_ID +":lead_ore", Feature.ORE.configured
    	(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.LEAD_ORE.get().defaultBlockState(), ModConfigs.leadVeinSizeInt))
    	.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(ModConfigs.leadMinYInt, 0, ModConfigs.leadMaxYInt))).squared().count(ModConfigs.leadVeinsPerChunkInt));

    	//HILLS
    	RUBY_ORE_FEATURE = register(Reference.MOD_ID +":ruby_ore", Feature.ORE.configured
    	(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.RUBY_ORE.get().defaultBlockState(), ModConfigs.rubyVeinSizeInt))
    	.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(ModConfigs.rubyMinYInt, 0, ModConfigs.rubyMaxYInt))).squared().count(ModConfigs.rubyVeinsPerChunkInt));
    	
    	SAPPHIRE_ORE_FEATURE = register(Reference.MOD_ID +":sapphire_ore", Feature.ORE.configured
    	(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.SAPPHIRE_ORE.get().defaultBlockState(), ModConfigs.sapphireVeinSizeInt))
    	.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(ModConfigs.sapphireMinYInt, 0, ModConfigs.sapphireMaxYInt))).squared().count(ModConfigs.sapphireVeinsPerChunkInt));

    	//END
    	ENDER_ORE_FEATURE = register(Reference.MOD_ID +":ender_ore", Feature.ORE.configured
    	(new OreFeatureConfig(END_STONE, ModBlocks.ENDER_ORE.get().defaultBlockState(), ModConfigs.enderVeinSizeInt))
    	.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(ModConfigs.enderMinYInt, 0, ModConfigs.enderMaxYInt))).squared().count(ModConfigs.enderVeinsPerChunkInt));
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
    	
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}