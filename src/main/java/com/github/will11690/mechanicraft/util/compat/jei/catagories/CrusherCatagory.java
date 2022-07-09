package com.github.will11690.mechanicraft.util.compat.jei.catagories;

import java.util.LinkedList;
import java.util.List;

import com.github.will11690.mechanicraft.blocks.machines.tier1.t1crusher.TileEntityT1Crusher;
import com.github.will11690.mechanicraft.init.ModBlocks;
import com.github.will11690.mechanicraft.recipes.Crusher.CrusherRecipes;
import com.github.will11690.mechanicraft.util.Reference;
import com.github.will11690.mechanicraft.util.compat.jei.JEICompat;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mojang.blaze3d.matrix.MatrixStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class CrusherCatagory implements IRecipeCategory<CrusherRecipes> {
	//TODO GUI(draw energy amount like tooltip or something)
    public static final ResourceLocation ID = new ResourceLocation(Reference.MOD_ID, "crusher_category");

    private IDrawable background;
    private IDrawable icon;
    private final int regularCookTime;
    protected final IDrawableStatic staticEnergyBar;
    protected final IDrawableAnimated animatedEnergyBar;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;

    public CrusherCatagory(IGuiHelper helper) {
    	
        this.background = helper.createDrawable(JEICompat.MECHANICRAFT_CRUSHER_GUI_ID, 0, 0, 108, 65);
        
        this.icon = helper.createDrawableIngredient(new ItemStack(ModBlocks.T1_CRUSHER.get()));
        this.regularCookTime = 200;
        staticEnergyBar = helper.createDrawable(JEICompat.MECHANICRAFT_CRUSHER_GUI_ID, 108, 17, 18, 47);
        animatedEnergyBar = helper.createAnimatedDrawable(staticEnergyBar, 300, IDrawableAnimated.StartDirection.TOP, true);
        this.cachedArrows = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<Integer, IDrawableAnimated>() {
        	
            @Override
            public IDrawableAnimated load(Integer cookTime) {
                return helper.drawableBuilder(JEICompat.MECHANICRAFT_CRUSHER_GUI_ID, 109, 0, 24, 17)
                        .buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
            }
        });
    }

    protected IDrawableAnimated getArrow(CrusherRecipes recipe) {
    	
        int cookTime = TileEntityT1Crusher.getWorkTime();
        
        if (cookTime <= 0) {
        	
            cookTime = regularCookTime;
        }
        
        return this.cachedArrows.getUnchecked(cookTime);
    }

    @Override
    public ResourceLocation getUid() {
    	
        return ID;
    }

    @Override
    public Class<? extends CrusherRecipes> getRecipeClass() {
    	
        return CrusherRecipes.class;
    }

    @Override
    public String getTitle() {
    	
        return new TranslationTextComponent("com.github.will11690.mechanicraft.catagory.crusher_recipes").getString();
    }

    @Override
    public IDrawable getBackground() {
    	
        return background;
    }

    @Override
    public IDrawable getIcon() {
    	
        return icon;
    }

    @Override
    public void setIngredients(CrusherRecipes crusherRecipes, IIngredients iIngredients) {
    	
    	List<ItemStack> outputs = new LinkedList<ItemStack>();
    	
    	if(!crusherRecipes.getResultItem().equals(ItemStack.EMPTY) && !outputs.contains(crusherRecipes.getResultItem())) {
    		
    		outputs.add(crusherRecipes.getResultItem());
    	}
    	
    	if(!crusherRecipes.getSecondaryResultJEI().getItem().equals(Items.AIR) && !crusherRecipes.getSecondaryResultJEI().equals(ItemStack.EMPTY) &&
    			!outputs.contains(crusherRecipes.getSecondaryResultJEI())) {
    		
    		outputs.add(crusherRecipes.getSecondaryResultJEI());
    	}
    	
        iIngredients.setInputIngredients(crusherRecipes.getIngredients());
        iIngredients.setOutputs(VanillaTypes.ITEM, outputs);
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, CrusherRecipes crusherRecipes, IIngredients iIngredients) {

    	boolean secondaryOut;
    	
        IGuiItemStackGroup itemStackGroup = iRecipeLayout.getItemStacks();
        
        if(crusherRecipes.getSecondaryResultJEI().getItem().equals(Items.AIR)) {
        	
        	secondaryOut = false;
        	
        } else {
        	
        	secondaryOut = true;
        }

        itemStackGroup.init(0, true, 20, 15);
        itemStackGroup.init(1, false, 86, 15);
        
        if(secondaryOut == true) {
        	
        	itemStackGroup.init(2, false, 86, 39);
        }
        
        itemStackGroup.set(iIngredients);
    }

    protected void drawCookTime(CrusherRecipes recipe, MatrixStack matrixStack, int y) {
    	
        int cookTime = TileEntityT1Crusher.getWorkTime();
        
        if (cookTime > 0) {
        	
            int cookTimeSeconds = cookTime / 20;
            TranslationTextComponent timeString = new TranslationTextComponent("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
            Minecraft minecraft = Minecraft.getInstance();
            FontRenderer fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(timeString);
            fontRenderer.draw(matrixStack, timeString, background.getWidth() - stringWidth, y, 0xFF808080);
        }
    }

    @Override
    public void draw(CrusherRecipes recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
    	
    	animatedEnergyBar.draw(matrixStack, 0, 0);

        IDrawableAnimated arrow = getArrow(recipe);
        arrow.draw(matrixStack, 48, 17);

        drawCookTime(recipe, matrixStack, 59);
    }
}