package com.github.will11690.mechanicraft.blocks.machines.basic.basicinfuser;

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

public class ScreenBasicMetallicInfuser extends ContainerScreen<ContainerBasicMetallicInfuser> {
	
    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/infuser/basic_metallic_infuser.png");

    //Burn Time Texture
 	public static final int BURN_METER_FROM_X = 176;
 	public static final int BURN_METER_FROM_Y = 0;
 	public static final int BURN_METER_WIDTH = 14;
 	public static final int BURN_METER_HEIGHT = 14;
 	public static final int BURN_METER_TO_X = 46;
 	public static final int BURN_METER_TO_Y = 37;
 	
 	//Burn Time INFO
 	public static final int INFO_BURN_METER_WIDTH = 14;
 	public static final int INFO_BURN_METER_HEIGHT = 14;
 	public static final int INFO_BURN_METER_TO_X = 45;
	public static final int INFO_BURN_METER_TO_Y = 37;
 	
 	//Progress Texture
 	public static final int PROGRESS_METER_FROM_X = 176;
 	public static final int PROGRESS_METER_FROM_Y = 14;
 	public static final int PROGRESS_METER_WIDTH = 24;
 	public static final int PROGRESS_METER_HEIGHT = 17;
 	public static final int PROGRESS_METER_TO_X = 84;
 	public static final int PROGRESS_METER_TO_Y = 36;
   	
   	//Progress INFO
   	public static final int INFO_PROGRESS_METER_WIDTH = 24;
   	public static final int INFO_PROGRESS_METER_HEIGHT = 17;
   	public static final int INFO_PROGRESS_METER_TO_X = 84;
   	public static final int INFO_PROGRESS_METER_TO_Y = 35;
    
    public ScreenBasicMetallicInfuser(ContainerBasicMetallicInfuser container, PlayerInventory playerInventory, ITextComponent title) {
        
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
            	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.basic_metallic_infuser.cook_progress", this.menu.getProgress(), this.menu.getMaxProgress()))), x, y);
    	
    		}
        
        	//Draw Full Burn Time ToolTip
        	if (x > (getGuiLeft() + INFO_BURN_METER_TO_X) && x < (getGuiLeft() + INFO_BURN_METER_TO_X) + INFO_BURN_METER_WIDTH && y > (getGuiTop() + INFO_BURN_METER_TO_Y) && y < (getGuiTop() + INFO_BURN_METER_TO_Y) + INFO_BURN_METER_HEIGHT) {
        	
            	this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
            	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.basic_metallic_infuser.burn_time", this.menu.getBurnTime(), this.menu.getTotalBurnTime()))), x, y);
    	
    		}
        	
        } else {
        
        	//Draw Progress ToolTip
        	if (x > (getGuiLeft() + INFO_PROGRESS_METER_TO_X) && x < (getGuiLeft() + INFO_PROGRESS_METER_TO_X) + INFO_PROGRESS_METER_WIDTH && y > (getGuiTop() + INFO_PROGRESS_METER_TO_Y) && y < (getGuiTop() + INFO_PROGRESS_METER_TO_Y) + INFO_PROGRESS_METER_HEIGHT) {
        	
            	this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
            	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.basic_metallic_infuser.cook_progress", Utils.withSuffix(this.menu.getProgress()), Utils.withSuffix(this.menu.getMaxProgress())),
        		new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"))), x, y);
    	
    		}
        
        	//Draw Burn Time ToolTip
        	if (x > (getGuiLeft() + INFO_BURN_METER_TO_X) && x < (getGuiLeft() + INFO_BURN_METER_TO_X) + INFO_BURN_METER_WIDTH && y > (getGuiTop() + INFO_BURN_METER_TO_Y) && y < (getGuiTop() + INFO_BURN_METER_TO_Y) + INFO_BURN_METER_HEIGHT) {
        	
            	this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
            	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.basic_metallic_infuser.burn_time", Utils.withSuffix(this.menu.getBurnTime()), Utils.withSuffix(this.menu.getTotalBurnTime())),
        		new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"))), x, y);
    	
    		}
        }
    }

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

        int maxHeight = BURN_METER_HEIGHT;
        
     	if (this.menu.getBurnTime() > 0) {
     			
     		int remaining = (this.menu.getBurnTime() * maxHeight) / this.menu.getTotalBurnTime();
     		this.blit(matrixStack, posX + BURN_METER_TO_X, posY + BURN_METER_TO_Y + BURN_METER_HEIGHT - remaining, BURN_METER_FROM_X, BURN_METER_HEIGHT - remaining, BURN_METER_WIDTH, remaining);
     		
     	}

     	int cookProgress = this.menu.getProgressionScaled() + 1;
     	this.blit(matrixStack, posX + PROGRESS_METER_TO_X, posY + PROGRESS_METER_TO_Y, PROGRESS_METER_FROM_X, PROGRESS_METER_FROM_Y, cookProgress, PROGRESS_METER_HEIGHT);
     	
    }
}