package com.github.will11690.mechanicraft.util.compat.jei.catagories;

import java.util.LinkedList;
import java.util.List;

import com.github.will11690.mechanicraft.blocks.machines.basic.basicinfuser.TileEntityBasicMetallicInfuser;
import com.github.will11690.mechanicraft.init.ModBlocks;
import com.github.will11690.mechanicraft.recipes.Infuser.InfuserRecipes;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class BasicInfuserCatagory implements IRecipeCategory<InfuserRecipes> {
	
    public static final ResourceLocation ID = new ResourceLocation(Reference.MOD_ID, "basic_infuser_category");

    private IDrawable background;
    private IDrawable icon;
    private final int regularCookTime;
    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;

    public BasicInfuserCatagory(IGuiHelper helper) {
    	
        this.background = helper.createDrawable(JEICompat.MECHANICRAFT_BASIC_INFUSER_GUI_ID, 0, 0, 116, 51);
        
        this.icon = helper.createDrawableIngredient(new ItemStack(ModBlocks.BASIC_METALLIC_INFUSER.get()));
        this.regularCookTime = 200;
        staticFlame = helper.createDrawable(JEICompat.MECHANICRAFT_BASIC_INFUSER_GUI_ID, 117, 0, 14, 14);
        animatedFlame = helper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
        this.cachedArrows = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<Integer, IDrawableAnimated>() {
        	
            @Override
            public IDrawableAnimated load(Integer cookTime) {
            	
                return helper.drawableBuilder(JEICompat.MECHANICRAFT_BASIC_INFUSER_GUI_ID, 117, 14, 24, 17)
                        .buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
            }
        });
    }

    protected IDrawableAnimated getArrow(InfuserRecipes recipe) {
    	
        int cookTime = TileEntityBasicMetallicInfuser.getWorkTime();
        
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
    public Class<? extends InfuserRecipes> getRecipeClass() {
    	
        return InfuserRecipes.class;
    }

    @Override
    public String getTitle() {
    	
        return new TranslationTextComponent("com.github.will11690.mechanicraft.catagory.basic_infuser_recipes").getString();
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
    public void setIngredients(InfuserRecipes infuserRecipes, IIngredients iIngredients) {
    	
    	List<List<ItemStack>> inputs = new LinkedList<>();
    	
        iIngredients.setInputIngredients(infuserRecipes.getIngredients());
        
        inputs.addAll(0, iIngredients.getInputs(VanillaTypes.ITEM));
    	inputs.add(1, JEICompat.allFuels);
        
        iIngredients.setInputLists(VanillaTypes.ITEM, inputs);
        iIngredients.setOutput(VanillaTypes.ITEM, infuserRecipes.getResultItem());
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, InfuserRecipes infuserRecipes, IIngredients iIngredients) {

        IGuiItemStackGroup itemStackGroup = iRecipeLayout.getItemStacks();

        itemStackGroup.init(0, true, 0, 0);
        itemStackGroup.init(1, true, 14, 33);
        itemStackGroup.init(2, true, 28, 0);
        itemStackGroup.init(3, false, 94, 15);

        itemStackGroup.set(iIngredients);

    }

    protected void drawCookTime(InfuserRecipes recipe, MatrixStack matrixStack, int y) {
        int cookTime = TileEntityBasicMetallicInfuser.getWorkTime();
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
    public void draw(InfuserRecipes recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
        animatedFlame.draw(matrixStack, 17, 18);

        IDrawableAnimated arrow = getArrow(recipe);
        arrow.draw(matrixStack, 56, 16);

        drawCookTime(recipe, matrixStack, 45);

    }
}