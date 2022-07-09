package com.github.will11690.mechanicraft.init;

import java.util.Map;

import com.github.will11690.mechanicraft.recipes.Crusher.CrusherRecipeType;
import com.github.will11690.mechanicraft.recipes.Crusher.CrusherRecipes;
import com.github.will11690.mechanicraft.recipes.Infuser.InfuserRecipeType;
import com.github.will11690.mechanicraft.recipes.Infuser.InfuserRecipes;
import com.github.will11690.mechanicraft.recipes.OreWasher.WasherRecipeType;
import com.github.will11690.mechanicraft.recipes.OreWasher.WasherRecipes;
import com.github.will11690.mechanicraft.recipes.Press.PressRecipeType;
import com.github.will11690.mechanicraft.recipes.Press.PressRecipes;
import com.github.will11690.mechanicraft.recipes.Sieve.SieveRecipeType;
import com.github.will11690.mechanicraft.recipes.Sieve.SieveRecipes;
import com.github.will11690.mechanicraft.recipes.SlurryProcessor.SlurryRecipeType;
import com.github.will11690.mechanicraft.recipes.SlurryProcessor.SlurryRecipes;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public final class ModRecipes {

	public static final IRecipeType<InfuserRecipes> INFUSER_RECIPES = new InfuserRecipeType();
	public static final IRecipeType<PressRecipes> PRESS_RECIPES = new PressRecipeType();
	public static final IRecipeType<CrusherRecipes> CRUSHER_RECIPES = new CrusherRecipeType();
	public static final IRecipeType<SieveRecipes> SIEVE_RECIPES = new SieveRecipeType();
	public static final IRecipeType<WasherRecipes> WASHER_RECIPES = new WasherRecipeType();
	public static final IRecipeType<SlurryRecipes> SLURRY_RECIPES = new SlurryRecipeType();
	
	public static void regiserRecipes(Register<IRecipeSerializer<?>> event) {
		
		regiserRecipe(event, INFUSER_RECIPES, InfuserRecipes.SERIALIZER);
		regiserRecipe(event, PRESS_RECIPES, PressRecipes.SERIALIZER);
		regiserRecipe(event, CRUSHER_RECIPES, CrusherRecipes.SERIALIZER);
		regiserRecipe(event, SIEVE_RECIPES, SieveRecipes.SERIALIZER);
		regiserRecipe(event, WASHER_RECIPES, WasherRecipes.SERIALIZER);
		regiserRecipe(event, SLURRY_RECIPES, SlurryRecipes.SERIALIZER);
		
	}
	
	private static void regiserRecipe(Register<IRecipeSerializer<?>> event, IRecipeType<?> type, IRecipeSerializer<?> serializer) {
		
		Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(type.toString()), type);
		event.getRegistry().register(serializer);
		
	}
	
	public static Map<ResourceLocation, IRecipe<?>> getRecipes(IRecipeType<?> type, RecipeManager manager) {
		
		final Map<IRecipeType<?>, Map<ResourceLocation, IRecipe<?>>> recipes = ObfuscationReflectionHelper.getPrivateValue(RecipeManager.class, manager, "field_199522_d");
		return recipes.get(type);
		
	}
	
}