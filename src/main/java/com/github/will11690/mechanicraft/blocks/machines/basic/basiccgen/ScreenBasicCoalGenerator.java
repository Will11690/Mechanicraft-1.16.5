package com.github.will11690.mechanicraft.blocks.machines.basic.basiccgen;

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

public class ScreenBasicCoalGenerator extends ContainerScreen<ContainerBasicCoalGenerator> {
	
    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/generator/basic_coal_generator.png");
    
    //Burn Time Texture
 	public static final int BURN_METER_FROM_X = 176;
 	public static final int BURN_METER_FROM_Y = 0;
 	public static final int BURN_METER_WIDTH = 14;
 	public static final int BURN_METER_HEIGHT = 14;
 	public static final int BURN_METER_TO_X = 82;
 	public static final int BURN_METER_TO_Y = 55;
 	
 	//Burn Time INFO
 	public static final int INFO_BURN_METER_WIDTH = 14;
 	public static final int INFO_BURN_METER_HEIGHT = 14;
 	public static final int INFO_BURN_METER_TO_X = 82;
	public static final int INFO_BURN_METER_TO_Y = 55;
 	
 	//Energy Bar Texture
 	public static final int ENERGY_BAR_FROM_X = 176;
 	public static final int ENERGY_BAR_FROM_Y = 14;
 	public static final int ENERGY_BAR_WIDTH = 18;
 	public static final int ENERGY_BAR_HEIGHT = 47;
 	public static final int ENERGY_BAR_TO_X = 7;
 	public static final int ENERGY_BAR_TO_Y = 54;
 	
 	//Energy Bar INFO
 	public static final int INFO_ENERGY_BAR_WIDTH = 18;
 	public static final int INFO_ENERGY_BAR_HEIGHT = 47;
 	public static final int INFO_ENERGY_BAR_TO_X = 7;
 	public static final int INFO_ENERGY_BAR_TO_Y = 7;
    
    public ScreenBasicCoalGenerator(ContainerBasicCoalGenerator container, PlayerInventory playerInventory, ITextComponent title) {
        
    	super(container, playerInventory, title);
    	
    }
    
    @Override
    protected void renderLabels(MatrixStack stack, int x, int y) {
    	
        this.font.draw(stack, this.title, (float)this.titleLabelX + 30.0F, (float)this.titleLabelY, 4210752);
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
                new TranslationTextComponent("com.github.will11690.mechanicraft.screen.basic_coal_generator.energy", this.menu.getEnergy(), this.menu.getCapacity()))), x, y);
        	
        	}
        	
        	//Draw Burn Time ToolTip Full Number
        	if (x > (getGuiLeft() + INFO_BURN_METER_TO_X) && x < (getGuiLeft() + INFO_BURN_METER_TO_X) + INFO_BURN_METER_WIDTH && y > (getGuiTop() + INFO_BURN_METER_TO_Y) && y < (getGuiTop() + INFO_BURN_METER_TO_Y) + INFO_BURN_METER_HEIGHT) {
            	
                this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
                new TranslationTextComponent("com.github.will11690.mechanicraft.screen.basic_coal_generator.burn_time", this.menu.getBurnTimeRemaining(), this.menu.getItemBurnTime()))), x, y);
        	
        	}
        	
        } else {
        	
        	//Draw Energy ToolTip
        	if (x > (getGuiLeft() + INFO_ENERGY_BAR_TO_X) && x < (getGuiLeft() + INFO_ENERGY_BAR_TO_X) + INFO_ENERGY_BAR_WIDTH && y > (getGuiTop() + INFO_ENERGY_BAR_TO_Y) && y < (getGuiTop() + INFO_ENERGY_BAR_TO_Y) + INFO_ENERGY_BAR_HEIGHT) {
        	
        		this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
        		new TranslationTextComponent("com.github.will11690.mechanicraft.screen.basic_coal_generator.energy", Utils.withSuffix(this.menu.getEnergy()), Utils.withSuffix(this.menu.getCapacity())),
        		new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"))), x, y);
        		
        	}
        
        	//Draw Burn Time ToolTip
        	if (x > (getGuiLeft() + INFO_BURN_METER_TO_X) && x < (getGuiLeft() + INFO_BURN_METER_TO_X) + INFO_BURN_METER_WIDTH && y > (getGuiTop() + INFO_BURN_METER_TO_Y) && y < (getGuiTop() + INFO_BURN_METER_TO_Y) + INFO_BURN_METER_HEIGHT) {
        	
        		this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
                new TranslationTextComponent("com.github.will11690.mechanicraft.screen.basic_coal_generator.burn_time", Utils.withSuffix(this.menu.getBurnTimeRemaining()), Utils.withSuffix(this.menu.getItemBurnTime())),
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
        
        if (this.menu.getItemBurnTime() > 0) {
        	
            int remaining = (this.menu.getBurnTimeRemaining() * maxHeight) / this.menu.getItemBurnTime();
            this.blit(matrixStack, posX + BURN_METER_TO_X, posY + BURN_METER_TO_Y + BURN_METER_HEIGHT - remaining, BURN_METER_FROM_X, /*Pixels from top of gui to bottom of drawn texture*/13 - remaining, BURN_METER_WIDTH, remaining + 1);
            
        }

        int maxEnergy = this.menu.getCapacity(), height = ENERGY_BAR_HEIGHT;
        
        if (this.menu.getEnergy() > 0) {
        	
            int remaining = (this.menu.getEnergy() * height) / maxEnergy;
            this.blit(matrixStack, posX + ENERGY_BAR_TO_X, posY + ENERGY_BAR_TO_Y - remaining, ENERGY_BAR_FROM_X, /*Pixels from top of gui to bottom of drawn texture*/61 - remaining, ENERGY_BAR_WIDTH, remaining + 1);
            
        }
    }
}