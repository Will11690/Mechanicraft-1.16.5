package com.github.will11690.mechanicraft.blocks.machines.tier4.t4infuser;

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

public class ScreenT4MetallicInfuser extends ContainerScreen<ContainerT4MetallicInfuser> {
	
    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/infuser/t4_metallic_infuser.png");

    //Progress INFO
  	public static final int PROGRESS_METER_FROM_X = 176;
  	public static final int PROGRESS_METER_FROM_Y = 0;
  	public static final int PROGRESS_METER_WIDTH = 24;
  	public static final int PROGRESS_METER_HEIGHT = 17;
  	public static final int PROGRESS_METER_TO_X = 88;
  	public static final int PROGRESS_METER_TO_Y = 29;
  	   	
  	//Progress INFO
  	public static final int INFO_PROGRESS_METER_WIDTH = 24;
  	public static final int INFO_PROGRESS_METER_HEIGHT = 17;
  	public static final int INFO_PROGRESS_METER_TO_X = 88;
  	public static final int INFO_PROGRESS_METER_TO_Y = 29;
  	 	
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
    
    public ScreenT4MetallicInfuser(ContainerT4MetallicInfuser container, PlayerInventory playerInventory, ITextComponent title) {
        
    	super(container, playerInventory, title);
    	
    }
    
    @Override
    protected void renderLabels(MatrixStack stack, int x, int y) {
    	
        this.font.draw(stack, this.title, (float)this.titleLabelX + 28.0F, (float)this.titleLabelY, 4210752);
        this.font.draw(stack, this.inventory.getDisplayName(), (float)this.inventoryLabelX, (float)this.inventoryLabelY + 2.0F, 4210752);
        
     }

    @Override
    public void render(MatrixStack matrixStack, int x, int y, float partialTicks) {
    	
        this.renderBackground(matrixStack);
        super.render(matrixStack, x, y, partialTicks);
        this.renderTooltip(matrixStack, x, y);
        
        if(Screen.hasShiftDown()) {
        	
        	//Draw Full Progress ToolTip
        	if (x > (getGuiLeft() + INFO_PROGRESS_METER_TO_X) && x < (getGuiLeft() + INFO_PROGRESS_METER_TO_X) + INFO_PROGRESS_METER_WIDTH && y > (getGuiTop() + INFO_PROGRESS_METER_TO_Y) && y < (getGuiTop() + INFO_PROGRESS_METER_TO_Y) + INFO_PROGRESS_METER_HEIGHT) {
        	
            	this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
            	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t4_metallic_infuser.cook_progress", this.menu.getProgress(), this.menu.getMaxProgress()))), x, y);
    	
    		}
        
        	//Draw Energy ToolTip Full Number
			if (x > (getGuiLeft() + INFO_ENERGY_BAR_TO_X) && x < (getGuiLeft() + INFO_ENERGY_BAR_TO_X) + INFO_ENERGY_BAR_WIDTH && y > (getGuiTop() + INFO_ENERGY_BAR_TO_Y) && y < (getGuiTop() + INFO_ENERGY_BAR_TO_Y) + INFO_ENERGY_BAR_HEIGHT) {
	            	
				this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
				new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t4_metallic_infuser.energy", this.menu.getEnergy(), this.menu.getCapacity()))), x, y);
	        	
			}
        	
        } else {
        
        	//Draw Progress ToolTip
        	if (x > (getGuiLeft() + INFO_PROGRESS_METER_TO_X) && x < (getGuiLeft() + INFO_PROGRESS_METER_TO_X) + INFO_PROGRESS_METER_WIDTH && y > (getGuiTop() + INFO_PROGRESS_METER_TO_Y) && y < (getGuiTop() + INFO_PROGRESS_METER_TO_Y) + INFO_PROGRESS_METER_HEIGHT) {
        	
            	this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
            	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t4_metallic_infuser.cook_progress", Utils.withSuffix(this.menu.getProgress()), Utils.withSuffix(this.menu.getMaxProgress())),
        		new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"))), x, y);
    	
    		}
        
        	//Draw Energy ToolTip
			if (x > (getGuiLeft() + INFO_ENERGY_BAR_TO_X) && x < (getGuiLeft() + INFO_ENERGY_BAR_TO_X) + INFO_ENERGY_BAR_WIDTH && y > (getGuiTop() + INFO_ENERGY_BAR_TO_Y) && y < (getGuiTop() + INFO_ENERGY_BAR_TO_Y) + INFO_ENERGY_BAR_HEIGHT) {
	        	
				this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
	        	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t4_metallic_infuser.energy", Utils.withSuffix(this.menu.getEnergy()), Utils.withSuffix(this.menu.getCapacity())),
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

        int maxEnergy = this.menu.getCapacity(), height = ENERGY_BAR_HEIGHT;
        
		if (maxEnergy > 0) {
	        	
			int remaining = (this.menu.getEnergy() * height) / maxEnergy;
			this.blit(matrixStack, posX + ENERGY_BAR_TO_X, posY + ENERGY_BAR_TO_Y - remaining, ENERGY_BAR_FROM_X, /*Pixels from top of gui to bottom of drawn texture*/64 - remaining, ENERGY_BAR_WIDTH, remaining + 1);
	            
		}

		if (this.menu.getProgress() > 0) {
        	
			int cookProgress = this.menu.getProgressionScaled() + 1;
			this.blit(matrixStack, posX + PROGRESS_METER_TO_X, posY + PROGRESS_METER_TO_Y, PROGRESS_METER_FROM_X, PROGRESS_METER_FROM_Y, cookProgress, PROGRESS_METER_HEIGHT);
	         	
		}
     	
    }
}