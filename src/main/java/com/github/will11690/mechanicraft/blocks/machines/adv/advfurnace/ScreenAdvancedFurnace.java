package com.github.will11690.mechanicraft.blocks.machines.adv.advfurnace;

import java.util.Arrays;

import com.github.will11690.mechanicraft.util.Reference;
import com.github.will11690.mechanicraft.util.Utils;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.LanguageMap;
import net.minecraft.util.text.TranslationTextComponent;

public class ScreenAdvancedFurnace extends ContainerScreen<ContainerAdvancedFurnace> {
	
    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/furnace/adv_furnace.png");
    
    //Progress INFO1
   	public static final int PROGRESS_METER_FROM_X1 = 176;
   	public static final int PROGRESS_METER_FROM_Y1 = 0;
   	public static final int PROGRESS_METER_WIDTH1 = 24;
   	public static final int PROGRESS_METER_HEIGHT1 = 17;
   	public static final int PROGRESS_METER_TO_X1 = 76;
   	public static final int PROGRESS_METER_TO_Y1 = 19;
   	
   	//Progress INFO1
   	public static final int INFO_PROGRESS_METER_WIDTH1 = 24;
   	public static final int INFO_PROGRESS_METER_HEIGHT1 = 17;
   	public static final int INFO_PROGRESS_METER_TO_X1 = 76;
   	public static final int INFO_PROGRESS_METER_TO_Y1 = 18;
   	
    //Progress INFO2
   	public static final int PROGRESS_METER_FROM_X2 = 176;
   	public static final int PROGRESS_METER_FROM_Y2 = 0;
   	public static final int PROGRESS_METER_WIDTH2 = 24;
   	public static final int PROGRESS_METER_HEIGHT2 = 17;
   	public static final int PROGRESS_METER_TO_X2 = 76;
   	public static final int PROGRESS_METER_TO_Y2 = 47;
   	
   	//Progress INFO2
   	public static final int INFO_PROGRESS_METER_WIDTH2 = 24;
   	public static final int INFO_PROGRESS_METER_HEIGHT2 = 17;
   	public static final int INFO_PROGRESS_METER_TO_X2 = 76;
   	public static final int INFO_PROGRESS_METER_TO_Y2 = 46;
 	
 	//Energy Bar Texture
 	public static final int ENERGY_BAR_FROM_X = 176;
 	public static final int ENERGY_BAR_FROM_Y = 17;
 	public static final int ENERGY_BAR_WIDTH = 18;
 	public static final int ENERGY_BAR_HEIGHT = 47;
 	public static final int ENERGY_BAR_TO_X = 7;
 	public static final int ENERGY_BAR_TO_Y = 54;
 	
 	//Energy Bar INFO
 	public static final int INFO_ENERGY_BAR_WIDTH = 18;
 	public static final int INFO_ENERGY_BAR_HEIGHT = 47;
 	public static final int INFO_ENERGY_BAR_TO_X = 7;
 	public static final int INFO_ENERGY_BAR_TO_Y = 7;
    
    public ScreenAdvancedFurnace(ContainerAdvancedFurnace container, PlayerInventory playerInventory, ITextComponent title) {
        
    	super(container, playerInventory, title);
    	
    }
    
    @Override
    protected void renderLabels(MatrixStack stack, int x, int y) {
    	
        this.font.draw(stack, this.title, (float)this.titleLabelX + 40.0F, (float)this.titleLabelY, 4210752);
        this.font.draw(stack, this.inventory.getDisplayName(), (float)this.inventoryLabelX, (float)this.inventoryLabelY + 2.0F, 4210752);
        
     }

    @Override
    public void render(MatrixStack matrixStack, int x, int y, float partialTicks) {
    	
        this.renderBackground(matrixStack);
        super.render(matrixStack, x, y, partialTicks);
        this.renderTooltip(matrixStack, x, y);
        
        if(Screen.hasShiftDown()) {
        	
        	//Draw Energy ToolTip Full Number
        	if (x > (getGuiLeft() + INFO_ENERGY_BAR_TO_X) && x < (getGuiLeft() + INFO_ENERGY_BAR_TO_X) + INFO_ENERGY_BAR_WIDTH && y > (getGuiTop() + INFO_ENERGY_BAR_TO_Y) && y < (getGuiTop() + INFO_ENERGY_BAR_TO_Y) + INFO_ENERGY_BAR_HEIGHT) {
            	
                this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
                new TranslationTextComponent("com.github.will11690.mechanicraft.screen.advanced_furnace.energy", this.menu.getEnergy(), this.menu.getCapacity()))), x, y);
        	
        	}
        	
        	//Draw Progress ToolTip1
            if (x > (getGuiLeft() + INFO_PROGRESS_METER_TO_X1) && x < (getGuiLeft() + INFO_PROGRESS_METER_TO_X1) + INFO_PROGRESS_METER_WIDTH1 && y > (getGuiTop() + INFO_PROGRESS_METER_TO_Y1) && y < (getGuiTop() + INFO_PROGRESS_METER_TO_Y1) + INFO_PROGRESS_METER_HEIGHT1) {
            	
                this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
                new TranslationTextComponent("com.github.will11690.mechanicraft.screen.advanced_furnace.cook_progress1", this.menu.getProgress1(), this.menu.getMaxProgress()))), x, y);
        	
            }
        	
        	//Draw Progress ToolTip2
            if (x > (getGuiLeft() + INFO_PROGRESS_METER_TO_X2) && x < (getGuiLeft() + INFO_PROGRESS_METER_TO_X2) + INFO_PROGRESS_METER_WIDTH2 && y > (getGuiTop() + INFO_PROGRESS_METER_TO_Y2) && y < (getGuiTop() + INFO_PROGRESS_METER_TO_Y2) + INFO_PROGRESS_METER_HEIGHT2) {
            	
                this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
                new TranslationTextComponent("com.github.will11690.mechanicraft.screen.advanced_furnace.cook_progress2", this.menu.getProgress2(), this.menu.getMaxProgress()))), x, y);
        	
            }
            
        } else {
        	
        	//Draw Energy ToolTip
        	if (x > (getGuiLeft() + INFO_ENERGY_BAR_TO_X) && x < (getGuiLeft() + INFO_ENERGY_BAR_TO_X) + INFO_ENERGY_BAR_WIDTH && y > (getGuiTop() + INFO_ENERGY_BAR_TO_Y) && y < (getGuiTop() + INFO_ENERGY_BAR_TO_Y) + INFO_ENERGY_BAR_HEIGHT) {
        	
        		this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
        		new TranslationTextComponent("com.github.will11690.mechanicraft.screen.advanced_furnace.energy", Utils.withSuffix(this.menu.getEnergy()), Utils.withSuffix(this.menu.getCapacity())),
        		new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"))), x, y);
    	
        	}
        
        	//Draw Progress ToolTip1
            if (x > (getGuiLeft() + INFO_PROGRESS_METER_TO_X1) && x < (getGuiLeft() + INFO_PROGRESS_METER_TO_X1) + INFO_PROGRESS_METER_WIDTH1 && y > (getGuiTop() + INFO_PROGRESS_METER_TO_Y1) && y < (getGuiTop() + INFO_PROGRESS_METER_TO_Y1) + INFO_PROGRESS_METER_HEIGHT1) {
            	
                this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
                new TranslationTextComponent("com.github.will11690.mechanicraft.screen.advanced_furnace.cook_progress1", Utils.withSuffix(this.menu.getProgress1()), Utils.withSuffix(this.menu.getMaxProgress())),
                new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"))), x, y);
        
            }
        
        	//Draw Progress ToolTip2
            if (x > (getGuiLeft() + INFO_PROGRESS_METER_TO_X2) && x < (getGuiLeft() + INFO_PROGRESS_METER_TO_X2) + INFO_PROGRESS_METER_WIDTH2 && y > (getGuiTop() + INFO_PROGRESS_METER_TO_Y2) && y < (getGuiTop() + INFO_PROGRESS_METER_TO_Y2) + INFO_PROGRESS_METER_HEIGHT2) {
            	
                this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
                new TranslationTextComponent("com.github.will11690.mechanicraft.screen.advanced_furnace.cook_progress2", Utils.withSuffix(this.menu.getProgress2()), Utils.withSuffix(this.menu.getMaxProgress())),
                new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"))), x, y);
        
            }
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int x, int y) {
    	
        if (minecraft == null) {
        	
            return;
            
        }

        RenderSystem.color4f(1, 1, 1, 1);
        minecraft.getTextureManager().bind(TEXTURE);

        int posX = (this.width - this.imageWidth) / 2;
        int posY = (this.height - this.imageHeight) / 2;

        blit(matrixStack, posX, posY, 0, 0, this.imageWidth, this.imageHeight);
        
        if (this.menu.getProgress1() > 0) {
        	
        	int cookProgress = this.menu.getProgressionScaled1() + 1;
         	this.blit(matrixStack, posX + PROGRESS_METER_TO_X1, posY + PROGRESS_METER_TO_Y1, PROGRESS_METER_FROM_X1, PROGRESS_METER_FROM_Y1, cookProgress, PROGRESS_METER_HEIGHT1);
         	
        }
        
        if (this.menu.getProgress2() > 0) {
        	
        	int cookProgress = this.menu.getProgressionScaled2() + 1;
         	this.blit(matrixStack, posX + PROGRESS_METER_TO_X2, posY + PROGRESS_METER_TO_Y2, PROGRESS_METER_FROM_X2, PROGRESS_METER_FROM_Y2, cookProgress, PROGRESS_METER_HEIGHT2);
         	
        }

        int maxEnergy = this.menu.getCapacity(), height = ENERGY_BAR_HEIGHT;
        
        if (maxEnergy > 0) {
        	
            int remaining = (this.menu.getEnergy() * height) / maxEnergy;
            this.blit(matrixStack, posX + ENERGY_BAR_TO_X, posY + ENERGY_BAR_TO_Y - remaining, ENERGY_BAR_FROM_X, /*Pixels from top of gui to bottom of drawn texture*/64 - remaining, ENERGY_BAR_WIDTH, remaining + 1);
            
        }
    }
}