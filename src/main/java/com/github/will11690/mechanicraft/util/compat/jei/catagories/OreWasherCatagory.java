package com.github.will11690.mechanicraft.util.compat.jei.catagories;

import com.github.will11690.mechanicraft.blocks.machines.tier1.t1orewasher.TileEntityT1OreWasher;
import com.github.will11690.mechanicraft.init.ModBlocks;
import com.github.will11690.mechanicraft.recipes.OreWasher.WasherRecipes;
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
import mezz.jei.api.gui.ingredient.IGuiFluidStackGroup;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class OreWasherCatagory implements IRecipeCategory<WasherRecipes> {
	//TODO GUI(draw energy amount like tooltip or something)
    public static final ResourceLocation ID = new ResourceLocation(Reference.MOD_ID, "washer_category");

    private IDrawable background;
    private IDrawable icon;
    private final int regularCookTime;
    protected final IDrawableStatic staticEnergyBar;
    protected final IDrawableAnimated animatedEnergyBar;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;

    public OreWasherCatagory(IGuiHelper helper) {
    	
        this.background = helper.createDrawable(JEICompat.MECHANICRAFT_WASHER_GUI_ID, 0, 0, 115, 65);
        
        this.icon = helper.createDrawableIngredient(new ItemStack(ModBlocks.T1_ORE_WASHER.get()));
        this.regularCookTime = 200;
        staticEnergyBar = helper.createDrawable(JEICompat.MECHANICRAFT_WASHER_GUI_ID, 115, 17, 18, 47);
        animatedEnergyBar = helper.createAnimatedDrawable(staticEnergyBar, 300, IDrawableAnimated.StartDirection.TOP, true);
        this.cachedArrows = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<Integer, IDrawableAnimated>() {
        	
            @Override
            public IDrawableAnimated load(Integer cookTime) {
                return helper.drawableBuilder(JEICompat.MECHANICRAFT_WASHER_GUI_ID, 116, 0, 24, 17)
                        .buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
            }
        });
    }

    protected IDrawableAnimated getArrow(WasherRecipes recipe) {
    	
        int cookTime = TileEntityT1OreWasher.getWorkTime();
        
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
    public Class<? extends WasherRecipes> getRecipeClass() {
    	
        return WasherRecipes.class;
    }

    @Override
    public String getTitle() {
    	
        return new TranslationTextComponent("com.github.will11690.mechanicraft.catagory.washer_recipes").getString();
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
    public void setIngredients(WasherRecipes washerRecipes, IIngredients iIngredients) {
    	
        iIngredients.setInputIngredients(washerRecipes.getIngredients());
        iIngredients.setInput(VanillaTypes.FLUID, washerRecipes.getInputFluid());
        iIngredients.setOutput(VanillaTypes.FLUID, washerRecipes.getResultFluid());
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, WasherRecipes washerRecipes, IIngredients iIngredients) {

        IGuiItemStackGroup itemStackGroup = iRecipeLayout.getItemStacks();
        IGuiFluidStackGroup fluidStackGroup = iRecipeLayout.getFluidStacks();

        itemStackGroup.init(0, true, 45, 23);
        fluidStackGroup.init(1, true, 20, 48);
        fluidStackGroup.init(2, false, 98, 48);

        itemStackGroup.set(iIngredients);
        fluidStackGroup.set(iIngredients);
    }

    protected void drawCookTime(WasherRecipes recipe, MatrixStack matrixStack, int y) {
    	
        int cookTime = TileEntityT1OreWasher.getWorkTime();
        
        if (cookTime > 0) {
        	
            int cookTimeSeconds = cookTime / 20;
            TranslationTextComponent timeString = new TranslationTextComponent("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
            Minecraft minecraft = Minecraft.getInstance();
            FontRenderer fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(timeString);
            fontRenderer.draw(matrixStack, timeString, (background.getWidth() - stringWidth) - 18, y, 0xFF808080);
        }
    }

    @Override
    public void draw(WasherRecipes recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
    	
    	animatedEnergyBar.draw(matrixStack, 0, 0);

        IDrawableAnimated arrow = getArrow(recipe);
        arrow.draw(matrixStack, 71, 25);

        drawCookTime(recipe, matrixStack, 58);
    }
}