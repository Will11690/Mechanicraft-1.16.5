package com.github.will11690.mechanicraft.util.compat.jei;

import com.github.will11690.mechanicraft.init.ModRecipes;
import com.github.will11690.mechanicraft.util.Reference;
import com.github.will11690.mechanicraft.util.compat.jei.catagories.BasicInfuserCatagory;
import com.github.will11690.mechanicraft.util.compat.jei.catagories.CrusherCatagory;
import com.github.will11690.mechanicraft.util.compat.jei.catagories.InfuserCatagory;
import com.github.will11690.mechanicraft.util.compat.jei.catagories.OreWasherCatagory;
import com.github.will11690.mechanicraft.util.compat.jei.catagories.PressCatagory;
import com.github.will11690.mechanicraft.util.compat.jei.catagories.SieveCatagory;
import com.github.will11690.mechanicraft.util.compat.jei.catagories.SlurryProcessorCatagory;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@JeiPlugin
public class JEICompat implements IModPlugin {

    private static final ResourceLocation PLUGIN_ID = new ResourceLocation(Reference.MOD_ID, "jei_plugin");
    public static final ResourceLocation MECHANICRAFT_BASIC_INFUSER_GUI_ID = new ResourceLocation(Reference.MOD_ID, "jei/basic_infuser.png");
    public static final ResourceLocation MECHANICRAFT_INFUSER_GUI_ID = new ResourceLocation(Reference.MOD_ID, "jei/t1_infuser.png");
    public static final ResourceLocation MECHANICRAFT_CRUSHER_GUI_ID = new ResourceLocation(Reference.MOD_ID, "jei/t1_crusher.png");
    public static final ResourceLocation MECHANICRAFT_WASHER_GUI_ID = new ResourceLocation(Reference.MOD_ID, "jei/t1_washer.png");
    public static final ResourceLocation MECHANICRAFT_PRESS_GUI_ID = new ResourceLocation(Reference.MOD_ID, "jei/t1_press.png");
    public static final ResourceLocation MECHANICRAFT_SIEVE_GUI_ID = new ResourceLocation(Reference.MOD_ID, "jei/t1_sieve.png");
    public static final ResourceLocation MECHANICRAFT_SLURRY_GUI_ID = new ResourceLocation(Reference.MOD_ID, "jei/t1_slurry.png");
    
    public static List<ItemStack> coalFuels = new ArrayList<ItemStack>();
    public static List<ItemStack> allFuels = new ArrayList<ItemStack>();
    

    @Override
    public ResourceLocation getPluginUid() {
    	
        return PLUGIN_ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
    	
        IGuiHelper helper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new BasicInfuserCatagory(helper));
        registration.addRecipeCategories(new InfuserCatagory(helper));
        registration.addRecipeCategories(new CrusherCatagory(helper));
        registration.addRecipeCategories(new OreWasherCatagory(helper));
        registration.addRecipeCategories(new PressCatagory(helper));
        registration.addRecipeCategories(new SieveCatagory(helper));
        registration.addRecipeCategories(new SlurryProcessorCatagory(helper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
    	
        RecipeManager manager = Minecraft.getInstance().level.getRecipeManager();
        registration.addRecipes(getRecipes(manager, ModRecipes.INFUSER_RECIPES), BasicInfuserCatagory.ID);
        registration.addRecipes(getRecipes(manager, ModRecipes.INFUSER_RECIPES), InfuserCatagory.ID);
        registration.addRecipes(getRecipes(manager, ModRecipes.CRUSHER_RECIPES), CrusherCatagory.ID);
        registration.addRecipes(getRecipes(manager, ModRecipes.WASHER_RECIPES), OreWasherCatagory.ID);
        registration.addRecipes(getRecipes(manager, ModRecipes.PRESS_RECIPES), PressCatagory.ID);
        registration.addRecipes(getRecipes(manager, ModRecipes.SIEVE_RECIPES), SieveCatagory.ID);
        registration.addRecipes(getRecipes(manager, ModRecipes.SLURRY_RECIPES), SlurryProcessorCatagory.ID);
        this.addFuels();
    }

    private static Collection<?> getRecipes(RecipeManager manager, IRecipeType<?> type) {
    	
        return manager.getRecipes().parallelStream().filter(recipe -> recipe.getType() == type).collect(Collectors.toList());
    }
    
    @SuppressWarnings("deprecation")
	public void addFuels() {
    	
    	FurnaceTileEntity.getFuel().entrySet().forEach(e -> allFuels.add(new ItemStack(e.getKey())));
    	
    	for(int i = 0; allFuels.size() > i; i++) {
    		
    		if(allFuels.get(i).getItem().equals(Items.COAL) || allFuels.get(i).getItem().equals(Items.CHARCOAL) || allFuels.get(i).getItem().equals(Items.COAL_BLOCK)) {
    			
    			coalFuels.add(allFuels.get(i));
    			
    		}
    		
    	}
    	
    }
    
    public ItemStack getCoalFuel() {
    	
    	ItemStack coalFuel = ItemStack.EMPTY;
    	
    	for(int i = 0; coalFuels.size() > i; i++) {
    	
    		coalFuel = coalFuels.get(i);
    	}
    	
		return coalFuel;
    }
    
    public ItemStack getFuel() {
    	
    	ItemStack fuel = ItemStack.EMPTY;
    	
    	for(int i = 0; allFuels.size() > i; i++) {
    	
    		fuel = allFuels.get(i);
    	}
    	
		return fuel;
    }
}