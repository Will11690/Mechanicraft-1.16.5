package com.github.will11690.mechanicraft.util.compat.jei.catagories;

import com.github.will11690.mechanicraft.blocks.machines.tier1.t1press.TileEntityT1Press;
import com.github.will11690.mechanicraft.init.ModBlocks;
import com.github.will11690.mechanicraft.recipes.Press.PressRecipes;
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

public class PressCatagory implements IRecipeCategory<PressRecipes> {
	//TODO GUI(draw energy amount like tooltip or something)
    public static final ResourceLocation ID = new ResourceLocation(Reference.MOD_ID, "press_category");

    private IDrawable background;
    private IDrawable icon;
    private final int regularCookTime;
    protected final IDrawableStatic staticEnergyBar;
    protected final IDrawableAnimated animatedEnergyBar;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;

    public PressCatagory(IGuiHelper helper) {
        this.background = helper.createDrawable(JEICompat.MECHANICRAFT_PRESS_GUI_ID, 0, 0, 141, 69);
        
        this.icon = helper.createDrawableIngredient(new ItemStack(ModBlocks.T1_PRESS.get()));
        this.regularCookTime = 200;
        staticEnergyBar = helper.createDrawable(JEICompat.MECHANICRAFT_PRESS_GUI_ID, 141, 17, 18, 47);
        animatedEnergyBar = helper.createAnimatedDrawable(staticEnergyBar, 300, IDrawableAnimated.StartDirection.TOP, true);
        this.cachedArrows = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<Integer, IDrawableAnimated>() {
        	
            @Override
            public IDrawableAnimated load(Integer cookTime) {
                return helper.drawableBuilder(JEICompat.MECHANICRAFT_PRESS_GUI_ID, 142, 0, 24, 17)
                        .buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
            }
        });
    }

    protected IDrawableAnimated getArrow(PressRecipes recipe) {
    	
        int cookTime = TileEntityT1Press.getWorkTime();
        
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
    public Class<? extends PressRecipes> getRecipeClass() {
    	
        return PressRecipes.class;
    }

    @Override
    public String getTitle() {
    	
        return new TranslationTextComponent("com.github.will11690.mechanicraft.catagory.press_recipes").getString();
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
    public void setIngredients(PressRecipes pressRecipes, IIngredients iIngredients) {
    	
        iIngredients.setInputIngredients(pressRecipes.getIngredients());
        iIngredients.setOutput(VanillaTypes.ITEM, pressRecipes.getResultItem());
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, PressRecipes pressRecipes, IIngredients iIngredients) {

        IGuiItemStackGroup itemStackGroup = iRecipeLayout.getItemStacks();

        itemStackGroup.init(0, true, 26, 7);
        itemStackGroup.init(1, true, 46, 3);
        itemStackGroup.init(2, true, 66, 7);
        itemStackGroup.init(3, true, 70, 27);
        itemStackGroup.init(4, true, 66, 47);
        itemStackGroup.init(5, true, 46, 51);
        itemStackGroup.init(6, true, 26, 47);
        itemStackGroup.init(7, true, 22, 27);
        itemStackGroup.init(8, true, 46, 27);
        itemStackGroup.init(9, false, 119, 28);

        itemStackGroup.set(iIngredients);
    }

    protected void drawCookTime(PressRecipes recipe, MatrixStack matrixStack, int y) {
    	
        int cookTime = TileEntityT1Press.getWorkTime();
        
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
    public void draw(PressRecipes recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
    	
    	animatedEnergyBar.draw(matrixStack, 0, 0);

        IDrawableAnimated arrow = getArrow(recipe);
        arrow.draw(matrixStack, 90, 29);

        drawCookTime(recipe, matrixStack, 63);
    }
}