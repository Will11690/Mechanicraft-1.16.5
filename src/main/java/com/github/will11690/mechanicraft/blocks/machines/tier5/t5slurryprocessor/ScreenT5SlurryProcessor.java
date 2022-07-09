package com.github.will11690.mechanicraft.blocks.machines.tier5.t5slurryprocessor;

import java.util.Arrays;

import com.github.will11690.mechanicraft.util.Reference;
import com.github.will11690.mechanicraft.util.Utils;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.LanguageMap;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fluids.FluidStack;

public class ScreenT5SlurryProcessor extends ContainerScreen<ContainerT5SlurryProcessor> {
	
    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/slurry_processor/t5_slurry_processor.png");
    private TileEntityT5SlurryProcessor tile;

    //Progress INFO
  	public static final int PROGRESS_METER_FROM_X = 176;
  	public static final int PROGRESS_METER_FROM_Y = 0;
  	public static final int PROGRESS_METER_WIDTH = 24;
  	public static final int PROGRESS_METER_HEIGHT = 17;
  	public static final int PROGRESS_METER_TO_X = 68;
  	public static final int PROGRESS_METER_TO_Y = 32;
  	   	
  	//Progress INFO
  	public static final int INFO_PROGRESS_METER_WIDTH = 24;
  	public static final int INFO_PROGRESS_METER_HEIGHT = 17;
  	public static final int INFO_PROGRESS_METER_TO_X = 68;
  	public static final int INFO_PROGRESS_METER_TO_Y = 32;
  	 	
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
  	
  	//Input Fluid 1 INFO
  	public static final int INFO_INPUT_FLUID_1_WIDTH = 18;
  	public static final int INFO_INPUT_FLUID_1_HEIGHT = 60;
  	public static final int INFO_INPUT_FLUID_1_TO_X = 26;
  	public static final int INFO_INPUT_FLUID_1_TO_Y = 11;
  	
  	//Input Fluid 2 INFO
  	public static final int INFO_INPUT_FLUID_2_WIDTH = 18;
  	public static final int INFO_INPUT_FLUID_2_HEIGHT = 60;
  	public static final int INFO_INPUT_FLUID_2_TO_X = 46;
  	public static final int INFO_INPUT_FLUID_2_TO_Y = 11;
	 	
	//Input Fluid 1 Texture
	public static final int INPUT_FLUID_1_WIDTH = 16;
	public static final int INPUT_FLUID_1_HEIGHT = 59;
	public static final int INPUT_FLUID_1_TO_X = 27;
	public static final int INPUT_FLUID_1_TO_Y = 71;
 	
	//Input Fluid 2 Texture
	public static final int INPUT_FLUID_2_WIDTH = 16;
	public static final int INPUT_FLUID_2_HEIGHT = 59;
	public static final int INPUT_FLUID_2_TO_X = 47;
	public static final int INPUT_FLUID_2_TO_Y = 71;
  	
  	//Output Fluid INFO
  	public static final int INFO_OUTPUT_FLUID_WIDTH = 18;
  	public static final int INFO_OUTPUT_FLUID_HEIGHT = 59;
  	public static final int INFO_OUTPUT_FLUID_TO_X = 129;
  	public static final int INFO_OUTPUT_FLUID_TO_Y = 11;
	 	
	//Output Fluid Texture
	public static final int OUTPUT_FLUID_WIDTH = 16;
	public static final int OUTPUT_FLUID_HEIGHT = 59;
	public static final int OUTPUT_FLUID_TO_X = 130;
	public static final int OUTPUT_FLUID_TO_Y = 71;
    
    public ScreenT5SlurryProcessor(ContainerT5SlurryProcessor container, PlayerInventory playerInventory, ITextComponent title) {
        
    	super(container, playerInventory, title);
    	this.tile = container.getTileEntity();
    	
    }
    
    @Override
    protected void renderLabels(MatrixStack stack, int x, int y) {
    	
        this.font.draw(stack, this.title, (float)this.titleLabelX + 18.0F, (float)this.titleLabelY - 3.0F, 4210752);
        this.font.draw(stack, this.inventory.getDisplayName(), (float)this.inventoryLabelX, (float)this.inventoryLabelY + 2.0F, 4210752);
        
    }

   @Override
   public void render(MatrixStack matrixStack, int x, int y, float partialTicks) {
   	
       this.renderBackground(matrixStack);
       super.render(matrixStack, x, y, partialTicks);
       this.renderTooltip(matrixStack, x, y);
       
       int inputCapacity1 = this.menu.getInputTank1Capacity();
       int inputCapacity2 = this.menu.getInputTank2Capacity();
       int outputCapacity = this.menu.getOutputTankCapacity();
       
       int inputStored1 = this.menu.getInputTank1Stored();
       int inputStored2 = this.menu.getInputTank2Stored();
       int outputStored = this.menu.getOutputTankStored();
       
       FluidStack inputStack1 = tile.getInputFluidStack1();
       FluidStack inputStack2 = tile.getInputFluidStack2();
       FluidStack outputStack = tile.getOutputFluidStack();
       
       if(Screen.hasShiftDown()) {
       	
       	//Draw Full Input Tank 1
       	if (x > (getGuiLeft() + INFO_INPUT_FLUID_1_TO_X) && x < (getGuiLeft() + INFO_INPUT_FLUID_1_TO_X) + INFO_INPUT_FLUID_1_WIDTH && y > (getGuiTop() + INFO_INPUT_FLUID_1_TO_Y) && y < (getGuiTop() + INFO_INPUT_FLUID_1_TO_Y) + INFO_INPUT_FLUID_1_HEIGHT) {
       		
       		String inputFluidStored = "EMPTY";
       		
       		if(!inputStack1.equals(FluidStack.EMPTY)) {
       			
       			inputFluidStored = inputStack1.getDisplayName().getString();
       			
       		}
       		
           	this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
           	new StringTextComponent(inputFluidStored),
           	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t5_slurry_processor.fluid_amount_stored_full", inputStored1, inputCapacity1))), x, y);
   	
   		}
       	
       	//Draw Full Input Tank 2
       	if (x > (getGuiLeft() + INFO_INPUT_FLUID_2_TO_X) && x < (getGuiLeft() + INFO_INPUT_FLUID_2_TO_X) + INFO_INPUT_FLUID_2_WIDTH && y > (getGuiTop() + INFO_INPUT_FLUID_2_TO_Y) && y < (getGuiTop() + INFO_INPUT_FLUID_2_TO_Y) + INFO_INPUT_FLUID_2_HEIGHT) {
       		
       		String inputFluidStored = "EMPTY";
       		
       		if(!inputStack2.equals(FluidStack.EMPTY)) {
       			
       			inputFluidStored = inputStack2.getDisplayName().getString();
       			
       		}
       		
           	this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
           	new StringTextComponent(inputFluidStored),
           	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t5_slurry_processor.fluid_amount_stored_full", inputStored2, inputCapacity2))), x, y);
   	
   		}
       	
       	//Draw Full Output Tank
       	if (x > (getGuiLeft() + INFO_OUTPUT_FLUID_TO_X) && x < (getGuiLeft() + INFO_OUTPUT_FLUID_TO_X) + INFO_OUTPUT_FLUID_WIDTH && y > (getGuiTop() + INFO_OUTPUT_FLUID_TO_Y) && y < (getGuiTop() + INFO_OUTPUT_FLUID_TO_Y) + INFO_OUTPUT_FLUID_HEIGHT) {
       		
       		String outputFluidStored = "EMPTY";
       		
       		if(!outputStack.equals(FluidStack.EMPTY)) {
       			
       			outputFluidStored = outputStack.getDisplayName().getString();
       			
       		}
       		
           	this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
           	new StringTextComponent(outputFluidStored),
           	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t5_slurry_processor.fluid_amount_stored_full", outputStored, outputCapacity))), x, y);
   	
   		}
       	
       	//Draw Full Progress ToolTip
       	if (x > (getGuiLeft() + INFO_PROGRESS_METER_TO_X) && x < (getGuiLeft() + INFO_PROGRESS_METER_TO_X) + INFO_PROGRESS_METER_WIDTH && y > (getGuiTop() + INFO_PROGRESS_METER_TO_Y) && y < (getGuiTop() + INFO_PROGRESS_METER_TO_Y) + INFO_PROGRESS_METER_HEIGHT) {
       	
           	this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
           	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t5_slurry_processor.cook_progress", this.menu.getProgress(), this.menu.getMaxProgress()))), x, y);
   	
   		}
       
       	//Draw Energy ToolTip Full Number
			if (x > (getGuiLeft() + INFO_ENERGY_BAR_TO_X) && x < (getGuiLeft() + INFO_ENERGY_BAR_TO_X) + INFO_ENERGY_BAR_WIDTH && y > (getGuiTop() + INFO_ENERGY_BAR_TO_Y) && y < (getGuiTop() + INFO_ENERGY_BAR_TO_Y) + INFO_ENERGY_BAR_HEIGHT) {
	            	
				this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
				new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t5_slurry_processor.energy", this.menu.getEnergy(), this.menu.getCapacity())
				)), x, y);
	        	
			}
       	
       } else {
       
       	//Draw Input Tank 1
       	if (x > (getGuiLeft() + INFO_INPUT_FLUID_1_TO_X) && x < (getGuiLeft() + INFO_INPUT_FLUID_1_TO_X) + INFO_INPUT_FLUID_1_WIDTH && y > (getGuiTop() + INFO_INPUT_FLUID_1_TO_Y) && y < (getGuiTop() + INFO_INPUT_FLUID_1_TO_Y) + INFO_INPUT_FLUID_1_HEIGHT) {
       		
       		String inputFluidStored = "EMPTY";
       		
       		if(!inputStack1.equals(FluidStack.EMPTY)) {
       			
       			inputFluidStored = inputStack1.getDisplayName().getString();
       			
       		}
       		
           	this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
           	new StringTextComponent(inputFluidStored),
           	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t5_slurry_processor.fluid_amount_stored", Math.round(inputStored1 / 1000), Math.round(inputCapacity1 / 1000)),
       		new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"))), x, y);
   	
   		}
       
       	//Draw Input Tank 2
       	if (x > (getGuiLeft() + INFO_INPUT_FLUID_2_TO_X) && x < (getGuiLeft() + INFO_INPUT_FLUID_2_TO_X) + INFO_INPUT_FLUID_2_WIDTH && y > (getGuiTop() + INFO_INPUT_FLUID_2_TO_Y) && y < (getGuiTop() + INFO_INPUT_FLUID_2_TO_Y) + INFO_INPUT_FLUID_2_HEIGHT) {
       		
       		String inputFluidStored = "EMPTY";
       		
       		if(!inputStack2.equals(FluidStack.EMPTY)) {
       			
       			inputFluidStored = inputStack2.getDisplayName().getString();
       			
       		}
       		
           	this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
           	new StringTextComponent(inputFluidStored),
           	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t5_slurry_processor.fluid_amount_stored", Math.round(inputStored2 / 1000), Math.round(inputCapacity2 / 1000)),
       		new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"))), x, y);
   	
   		}
       
       	//Draw Output Tank
       	if (x > (getGuiLeft() + INFO_OUTPUT_FLUID_TO_X) && x < (getGuiLeft() + INFO_OUTPUT_FLUID_TO_X) + INFO_OUTPUT_FLUID_WIDTH && y > (getGuiTop() + INFO_OUTPUT_FLUID_TO_Y) && y < (getGuiTop() + INFO_OUTPUT_FLUID_TO_Y) + INFO_OUTPUT_FLUID_HEIGHT) {
       		
       		String outputFluidStored = "EMPTY";
       		
       		if(!outputStack.equals(FluidStack.EMPTY)) {
       			
       			outputFluidStored = outputStack.getDisplayName().getString();
       			
       		}
       		
           	this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
           	new StringTextComponent(outputFluidStored),
           	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t5_slurry_processor.fluid_amount_stored", Math.round(outputStored / 1000), Math.round(outputCapacity / 1000)),
       		new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"))), x, y);
   	
   		}
       
       	//Draw Progress ToolTip
       	if (x > (getGuiLeft() + INFO_PROGRESS_METER_TO_X) && x < (getGuiLeft() + INFO_PROGRESS_METER_TO_X) + INFO_PROGRESS_METER_WIDTH && y > (getGuiTop() + INFO_PROGRESS_METER_TO_Y) && y < (getGuiTop() + INFO_PROGRESS_METER_TO_Y) + INFO_PROGRESS_METER_HEIGHT) {
       	
           	this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
           	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t5_slurry_processor.cook_progress", Utils.withSuffix(this.menu.getProgress()), Utils.withSuffix(this.menu.getMaxProgress())),
       		new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"))), x, y);
   	
   		}
       
       	//Draw Energy ToolTip
			if (x > (getGuiLeft() + INFO_ENERGY_BAR_TO_X) && x < (getGuiLeft() + INFO_ENERGY_BAR_TO_X) + INFO_ENERGY_BAR_WIDTH && y > (getGuiTop() + INFO_ENERGY_BAR_TO_Y) && y < (getGuiTop() + INFO_ENERGY_BAR_TO_Y) + INFO_ENERGY_BAR_HEIGHT) {
	        	
				this.renderTooltip(matrixStack, LanguageMap.getInstance().getVisualOrder(Arrays.asList(
	        	new TranslationTextComponent("com.github.will11690.mechanicraft.screen.t5_slurry_processor.energy", Utils.withSuffix(this.menu.getEnergy()), Utils.withSuffix(this.menu.getCapacity())),
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

       int maxEnergy = this.menu.getCapacity();
       int energyHeight = ENERGY_BAR_HEIGHT;
       int inputCapacity1 = this.menu.getInputTank1Capacity();
       int inputCapacity2 = this.menu.getInputTank2Capacity();
       int outputCapacity = this.menu.getOutputTankCapacity();
       
       int inputStored1 = this.menu.getInputTank1Stored();
       int inputStored2 = this.menu.getInputTank2Stored();
       int outputStored = this.menu.getOutputTankStored();
       
       FluidStack inputStack1 = tile.getInputFluidStack1();
       FluidStack inputStack2 = tile.getInputFluidStack2();
       FluidStack outputStack = tile.getOutputFluidStack();
       
		if (maxEnergy > 0) {
	        //Draw Energy Bar
			int remainingEnergy = (this.menu.getEnergy() * energyHeight) / maxEnergy;
			this.blit(matrixStack, posX + ENERGY_BAR_TO_X, posY + ENERGY_BAR_TO_Y - remainingEnergy, ENERGY_BAR_FROM_X, /*Pixels from top of gui to bottom of drawn texture*/64 - remainingEnergy, ENERGY_BAR_WIDTH, remainingEnergy + 1);
	            
		}

		if (this.menu.getProgress() > 0) {
       	//Draw Progress Bar
			int cookProgress = this.menu.getProgressionScaled() + 1;
			this.blit(matrixStack, posX + PROGRESS_METER_TO_X, posY + PROGRESS_METER_TO_Y, PROGRESS_METER_FROM_X, PROGRESS_METER_FROM_Y, cookProgress, PROGRESS_METER_HEIGHT);
	         	
		}
		
		if(inputStored1 > 0) {
			//Draw Input Fluid Tank 1
			AtlasTexture texture = minecraft.getModelManager().getAtlas(PlayerContainer.BLOCK_ATLAS);
			TextureAtlasSprite sprite = texture.getSprite(inputStack1.getFluid().getAttributes().getStillTexture());
			texture.bind();
			
			int color = inputStack1.getFluid().getAttributes().getColor();
			
			int scaledHeight = scaledFluid(inputStored1, inputCapacity1, INPUT_FLUID_1_HEIGHT);

	        int yCount = scaledHeight / 16;
	        int yRemainder = scaledHeight % 16;
	        RenderSystem.color4f(((color >> 16) & 0xFF) / 255f, ((color >> 8) & 0xFF) / 255f, (color & 0xFF) / 255f, ((color >> 24) & 0xFF) / 255f);

	        for (int i = 1; i <= yCount; i++) {
	        	
	        	blit(matrixStack, posX + INPUT_FLUID_1_TO_X, posY + INPUT_FLUID_1_TO_Y - 16 * i, INPUT_FLUID_1_HEIGHT - scaledHeight, INPUT_FLUID_1_WIDTH, 16, sprite);
	        }
	        
	        blit(matrixStack, posX + INPUT_FLUID_1_TO_X, posY + INPUT_FLUID_1_TO_Y - 16 * yCount - yRemainder, INPUT_FLUID_1_HEIGHT - scaledHeight, INPUT_FLUID_1_WIDTH, yRemainder, sprite);
	                
	       RenderSystem.color4f(1f, 1f, 1f, 1f);
		}
		
		if(inputStored2 > 0) {
			//Draw Input Fluid Tank 2
			AtlasTexture texture = minecraft.getModelManager().getAtlas(PlayerContainer.BLOCK_ATLAS);
			TextureAtlasSprite sprite = texture.getSprite(inputStack2.getFluid().getAttributes().getStillTexture());
			texture.bind();
			
			int color = inputStack2.getFluid().getAttributes().getColor();
			
			int scaledHeight = scaledFluid(inputStored2, inputCapacity2, INPUT_FLUID_2_HEIGHT);

	        int yCount = scaledHeight / 16;
	        int yRemainder = scaledHeight % 16;
	        RenderSystem.color4f(((color >> 16) & 0xFF) / 255f, ((color >> 8) & 0xFF) / 255f, (color & 0xFF) / 255f, ((color >> 24) & 0xFF) / 255f);

	        for (int i = 1; i <= yCount; i++) {
	        	
	        	blit(matrixStack, posX + INPUT_FLUID_2_TO_X, posY + INPUT_FLUID_2_TO_Y - 16 * i, INPUT_FLUID_2_HEIGHT - scaledHeight, INPUT_FLUID_2_WIDTH, 16, sprite);
	        }
	        
	        blit(matrixStack, posX + INPUT_FLUID_2_TO_X, posY + INPUT_FLUID_2_TO_Y - 16 * yCount - yRemainder, INPUT_FLUID_2_HEIGHT - scaledHeight, INPUT_FLUID_2_WIDTH, yRemainder, sprite);
	                
	       RenderSystem.color4f(1f, 1f, 1f, 1f);
		}
		
		if(outputStored > 0) {
			//Draw Output Fluid Tank
			AtlasTexture texture = minecraft.getModelManager().getAtlas(PlayerContainer.BLOCK_ATLAS);
			TextureAtlasSprite sprite = texture.getSprite(outputStack.getFluid().getAttributes().getStillTexture());
			texture.bind();
			
			int color = outputStack.getFluid().getAttributes().getColor();
			
			int scaledHeight = scaledFluid(outputStored, outputCapacity, OUTPUT_FLUID_HEIGHT);

	        int yCount = scaledHeight / 16;
	        int yRemainder = scaledHeight % 16;
	        RenderSystem.color4f(((color >> 16) & 0xFF) / 255f, ((color >> 8) & 0xFF) / 255f, (color & 0xFF) / 255f, ((color >> 24) & 0xFF) / 255f);

	        for (int i = 1; i <= yCount; i++) {
	        	
	        	blit(matrixStack, posX + OUTPUT_FLUID_TO_X, posY + OUTPUT_FLUID_TO_Y - 16 * i, OUTPUT_FLUID_HEIGHT - scaledHeight, OUTPUT_FLUID_WIDTH, 16, sprite);
	        }
	        
	        blit(matrixStack, posX + OUTPUT_FLUID_TO_X, posY + OUTPUT_FLUID_TO_Y - 16 * yCount - yRemainder, OUTPUT_FLUID_HEIGHT - scaledHeight, OUTPUT_FLUID_WIDTH, yRemainder, sprite);
	                
	       RenderSystem.color4f(1f, 1f, 1f, 1f);
		}
   }
   
   public static int scaledFluid(float value, float maxValue, int height) {
       if (value <= 0 || maxValue <= 0) {
           return 0;
       }
       return (int) (value / maxValue * height);
   }
}