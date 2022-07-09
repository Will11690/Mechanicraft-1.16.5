package com.github.will11690.mechanicraft.world.gen;

import com.github.will11690.mechanicraft.init.ModConfigs;
import com.github.will11690.mechanicraft.init.ModFeatures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class MechanicraftOreGenerator {
	
	public static void generateOres(BiomeLoadingEvent event) {
		
		//Overworld(ALL)
		if(!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND))) {
			
			if(ModConfigs.copperGenBool == true) {
				
				event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModFeatures.COPPER_ORE_FEATURE);
			}
			
			if(ModConfigs.tinGenBool == true) {
				
				event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModFeatures.TIN_ORE_FEATURE);
			}
			
			if(ModConfigs.silverGenBool == true) {
				
				event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModFeatures.SILVER_ORE_FEATURE);
			}
			
			if(ModConfigs.leadGenBool == true) {
				
				event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModFeatures.LEAD_ORE_FEATURE);
			}
			
			if(ModConfigs.rubyGenAllBool == true) {
			
				event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModFeatures.RUBY_ORE_FEATURE);
			}
			
			if(ModConfigs.sapphireGenAllBool == true) {
			
				event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModFeatures.SAPPHIRE_ORE_FEATURE);
			}
			
		}
		
		//Overworld(Hills)
		if(event.getCategory().equals(Biome.Category.EXTREME_HILLS)) {
			
			if(ModConfigs.rubyGenHillsBool == true) {
			
				event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModFeatures.RUBY_ORE_FEATURE);
			}
			
			if(ModConfigs.sapphireGenHillsBool == true) {
			
				event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModFeatures.SAPPHIRE_ORE_FEATURE);
			}
		}
		
		//END
		if(event.getCategory().equals(Biome.Category.THEEND)) {
			
			if(ModConfigs.enderGenBool == true) {
				
				event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModFeatures.ENDER_ORE_FEATURE);
			}
		}
	}
}