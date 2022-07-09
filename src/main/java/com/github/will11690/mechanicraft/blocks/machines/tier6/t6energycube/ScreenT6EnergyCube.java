package com.github.will11690.mechanicraft.blocks.machines.tier6.t6energycube;

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

public class ScreenT6EnergyCube extends ContainerScreen<ContainerT6EnergyCube> {
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/gui/energy_cube/t6energy_cube.png");
	
 	//Energy Bar Texture
 	public static final int ENERGY_BAR_FROM_X = 176;
 	public static final int ENERGY_BAR_FROM_Y = 65;
 	public static final int ENERGY_BAR_WIDTH = 18;
 	public static final int ENERGY_BAR_HEIGHT = 65;
 	public static final int ENERGY_BAR_TO_X = 79;
 	public static final int ENERGY_BAR_TO_Y = 76;
 	
 	//Energy Bar INFO
 	public static final int INFO_ENERGY_BAR_WIDTH = 18;
 	public static final int INFO_ENERGY_BAR_HEIGHT = 65;
 	public static final int INFO_ENERGY_BAR_TO_X = 79;
 	public static final int INFO_ENERGY_BAR_TO_Y = 7;
    
    public ScreenT6EnergyCube(ContainerT6EnergyCube container, PlayerInventory playerInventory, ITextComponent title) {
        
    	super(container, playerInventory, title);
    	
    }
    
    @Override
    protected void renderLabels(MatrixStack stack, int x, int y) {
    	
        this.font.draw(stack, this.title, (float)this.titleLabelX + 32.0F, (float)this.titleLabelY - 3.0F, 4210752);
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
                new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t6_energy_cube.energy", this.menu.getEnergy(), this.menu.getCapacity()))), x, y);
        	
        	}
        	
        } else {
        	
        	//Draw Energy ToolTip
        	if (x > (getGuiLeft() + INFO_ENERGY_BAR_TO_X) && x < (getGuiLeft() + INFO_ENERGY_BAR_TO_X) + INFO_ENERGY_BAR_WIDTH && y > (getGuiTop() + INFO_ENERGY_BAR_TO_Y) && y < (getGuiTop() + INFO_ENERGY_BAR_TO_Y) + INFO_ENERGY_BAR_HEIGHT) {
        	
        		this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
        		new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t6_energy_cube.energy", Utils.withSuffix(this.menu.getEnergy()), Utils.withSuffix(this.menu.getCapacity())),
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
        
        if (this.menu.getEnergy() > 0) {
        	
            int remaining = (this.menu.getEnergy() * height) / maxEnergy;
            this.blit(matrixStack, posX + ENERGY_BAR_TO_X, posY + ENERGY_BAR_TO_Y - remaining, ENERGY_BAR_FROM_X, /*Pixels from top of gui to bottom of drawn texture*/65 - remaining, ENERGY_BAR_WIDTH, remaining + 1);
            
        }
    }
}