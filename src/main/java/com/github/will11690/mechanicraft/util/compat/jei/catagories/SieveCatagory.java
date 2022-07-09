package com.github.will11690.mechanicraft.util.compat.jei.catagories;

import java.util.LinkedList;
import java.util.List;

import com.github.will11690.mechanicraft.blocks.machines.tier1.t1poweredsieve.TileEntityT1PoweredSieve;
import com.github.will11690.mechanicraft.init.ModBlocks;
import com.github.will11690.mechanicraft.recipes.Sieve.SieveRecipes;
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

public class SieveCatagory implements IRecipeCategory<SieveRecipes> {
	//TODO GUI(draw energy amount like tooltip or something)
    public static final ResourceLocation ID = new ResourceLocation(Reference.MOD_ID, "sieve_category");

    private IDrawable background;
    private IDrawable icon;
    private final int regularCookTime;
    protected final IDrawableStatic staticEnergyBar;
    protected final IDrawableAnimated animatedEnergyBar;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;

    public SieveCatagory(IGuiHelper helper) {
    	
        this.background = helper.createDrawable(JEICompat.MECHANICRAFT_SIEVE_GUI_ID, 0, 0, 104, 65);
        
        this.icon = helper.createDrawableIngredient(new ItemStack(ModBlocks.T1_POWERED_SIEVE.get()));
        this.regularCookTime = 200;
        staticEnergyBar = helper.createDrawable(JEICompat.MECHANICRAFT_SIEVE_GUI_ID, 104, 17, 18, 47);
        animatedEnergyBar = helper.createAnimatedDrawable(staticEnergyBar, 300, IDrawableAnimated.StartDirection.TOP, true);
        this.cachedArrows = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<Integer, IDrawableAnimated>() {
        	
            @Override
            public IDrawableAnimated load(Integer cookTime) {
                return helper.drawableBuilder(JEICompat.MECHANICRAFT_SIEVE_GUI_ID, 105, 0, 24, 17)
                        .buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
            }
        });
    }

    protected IDrawableAnimated getArrow(SieveRecipes recipe) {
    	
        int cookTime = TileEntityT1PoweredSieve.getWorkTime();
        
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
    public Class<? extends SieveRecipes> getRecipeClass() {
    	
        return SieveRecipes.class;
    }

    @Override
    public String getTitle() {
    	
        return new TranslationTextComponent("com.github.will11690.mechanicraft.catagory.sieve_recipes").getString();
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
    public void setIngredients(SieveRecipes sieveRecipes, IIngredients iIngredients) {
    	
    	List<ItemStack> outputs = new LinkedList<ItemStack>();
    	
    	if(!sieveRecipes.getResultItem().equals(ItemStack.EMPTY) && !outputs.contains(sieveRecipes.getResultItem())) {
    		
    		outputs.add(sieveRecipes.getResultItem());
    	}
    	
    	if(!sieveRecipes.getSecondaryResultJEI().equals(ItemStack.EMPTY) && !outputs.contains(sieveRecipes.getSecondaryResultJEI())) {
    		
    		outputs.add(sieveRecipes.getSecondaryResultJEI());
    	}
    	
        iIngredients.setInputIngredients(sieveRecipes.getIngredients());
        iIngredients.setOutputs(VanillaTypes.ITEM, outputs);
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, SieveRecipes sieveRecipes, IIngredients iIngredients) {

        IGuiItemStackGroup itemStackGroup = iRecipeLayout.getItemStacks();

        itemStackGroup.init(0, true, 23, 12);
        itemStackGroup.init(1, true, 23, 31);
        itemStackGroup.init(2, false, 83, 12);
        itemStackGroup.init(3, false, 83, 36);

        itemStackGroup.set(iIngredients);
    }

    protected void drawCookTime(SieveRecipes recipe, MatrixStack matrixStack, int y) {
    	
        int cookTime = TileEntityT1PoweredSieve.getWorkTime();
        
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
    public void draw(SieveRecipes recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
    	
    	animatedEnergyBar.draw(matrixStack, 0, 0);

        IDrawableAnimated arrow = getArrow(recipe);
        arrow.draw(matrixStack, 51, 23);

        drawCookTime(recipe, matrixStack, 58);
    }
}