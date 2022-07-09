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
    	(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.SILVER_ORE.get().defaultBlockState(), 8))
    	.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(1, 0, 32))).squared().count(4));
    	
    	COPPER_ORE_FEATURE = register(Reference.MOD_ID +":copper_ore", Feature.ORE.configured
    	(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.COPPER_ORE.get().defaultBlockState(), 8))
    	.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(1, 0, 63))).squared().count(15));
    	
    	TIN_ORE_FEATURE = register(Reference.MOD_ID +":tin_ore", Feature.ORE.configured
    	(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.TIN_ORE.get().defaultBlockState(), 8))
    	.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(1, 0, 63))).squared().count(15));
    	
    	LEAD_ORE_FEATURE = register(Reference.MOD_ID +":lead_ore", Feature.ORE.configured
    	(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.LEAD_ORE.get().defaultBlockState(), 8))
    	.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(1, 0, 63))).squared().count(10));

    	//HILLS
    	RUBY_ORE_FEATURE = register(Reference.MOD_ID +":ruby_ore", Feature.ORE.configured
    	(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.RUBY_ORE.get().defaultBlockState(), 4))
    	.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(1, 0, 32))).squared().count(4));
    	
    	SAPPHIRE_ORE_FEATURE = register(Reference.MOD_ID +":sapphire_ore", Feature.ORE.configured
    	(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.SAPPHIRE_ORE.get().defaultBlockState(), 4))
    	.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(1, 0, 32))).squared().count(4));

    	//END
    	ENDER_ORE_FEATURE = register(Reference.MOD_ID +":ender_ore", Feature.ORE.configured
    	(new OreFeatureConfig(END_STONE, ModBlocks.ENDER_ORE.get().defaultBlockState(), 24))
    	.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(0, 0, 255))).squared().count(20));
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
    	
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}