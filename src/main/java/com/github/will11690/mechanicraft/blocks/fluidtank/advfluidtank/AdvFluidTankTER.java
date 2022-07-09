package com.github.will11690.mechanicraft.blocks.fluidtank.advfluidtank;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.util.math.vector.Vector4f;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.EmptyFluidHandler;

import java.awt.Color;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

@OnlyIn(Dist.CLIENT)
public class AdvFluidTankTER extends TileEntityRenderer<TileEntityAdvFluidTank> {

	public AdvFluidTankTER(TileEntityRendererDispatcher dispatcher) {
		
		super(dispatcher);
	}
	
	public static final float TANK_THICKNESS_HEIGHT = 0.0475f;
    public static final float TANK_THICKNESS_WIDTH = 0.15625f;
	
	@Override
	public void render(TileEntityAdvFluidTank tank, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer renderBuffer, int combinedLight, int combinedOverlay) {

		matrixStack.pushPose();
		IFluidHandler fluidHandler;
		
		if(tank.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY).isPresent()) {
			
			fluidHandler = tank.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY).orElse(null);
			
		} else {
			
			fluidHandler = EmptyFluidHandler.INSTANCE;
		}
		
		if (!fluidHandler.getFluidInTank(0).isEmpty()) {
			
			TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(PlayerContainer.BLOCK_ATLAS)
					.apply(fluidHandler.getFluidInTank(0).getFluid().getAttributes().getStillTexture());

			IVertexBuilder builder = renderBuffer.getBuffer(RenderType.translucent());

			Vector4f vec;
			if(fluidHandler.getFluidInTank(0).getFluid().equals(Fluids.WATER)) {
				
				vec = getColorVec(BiomeColors.getAverageWaterColor(tank.getWorld(), tank.getBlockPos()));
				
			} else {
				
				vec = getColorVec(fluidHandler.getFluidInTank(0).getFluid().getAttributes().getColor());
			}
			
			float scale = (1.0f - TANK_THICKNESS_HEIGHT/2 - TANK_THICKNESS_HEIGHT) * (fluidHandler.getFluidInTank(0).getAmount() / (float) fluidHandler.getTankCapacity(0));

			//Top Face
			add(builder, matrixStack, vec, 1 - TANK_THICKNESS_WIDTH, scale, TANK_THICKNESS_WIDTH, sprite.getU0(), sprite.getV1());
			add(builder, matrixStack, vec, TANK_THICKNESS_WIDTH, scale, TANK_THICKNESS_WIDTH, sprite.getU1(), sprite.getV1());
			add(builder, matrixStack, vec, TANK_THICKNESS_WIDTH, scale, 1 - TANK_THICKNESS_WIDTH, sprite.getU1(), sprite.getV0());
			add(builder, matrixStack, vec, 1 - TANK_THICKNESS_WIDTH, scale, 1 - TANK_THICKNESS_WIDTH, sprite.getU0(), sprite.getV0());

			//North Face
			add(builder, matrixStack, vec, TANK_THICKNESS_WIDTH, scale, TANK_THICKNESS_WIDTH, sprite.getU0(), sprite.getV(scale * 16));
			add(builder, matrixStack, vec, 1 - TANK_THICKNESS_WIDTH, scale, TANK_THICKNESS_WIDTH, sprite.getU1(), sprite.getV(scale * 16));
			add(builder, matrixStack, vec, 1 - TANK_THICKNESS_WIDTH, TANK_THICKNESS_HEIGHT, TANK_THICKNESS_WIDTH, sprite.getU1(), sprite.getV0());
			add(builder, matrixStack, vec, TANK_THICKNESS_WIDTH, TANK_THICKNESS_HEIGHT, TANK_THICKNESS_WIDTH, sprite.getU0(), sprite.getV0());
			
			//South Face
			add(builder, matrixStack, vec, TANK_THICKNESS_WIDTH, TANK_THICKNESS_HEIGHT, 1 - TANK_THICKNESS_WIDTH, sprite.getU0(), sprite.getV0());
			add(builder, matrixStack, vec, 1 - TANK_THICKNESS_WIDTH, TANK_THICKNESS_HEIGHT, 1 - TANK_THICKNESS_WIDTH, sprite.getU1(), sprite.getV0());
			add(builder, matrixStack, vec, 1 - TANK_THICKNESS_WIDTH, scale, 1 - TANK_THICKNESS_WIDTH, sprite.getU1(), sprite.getV(scale * 16));
			add(builder, matrixStack, vec, TANK_THICKNESS_WIDTH, scale, 1 - TANK_THICKNESS_WIDTH, sprite.getU0(), sprite.getV(scale * 16));

			//East Face
			add(builder, matrixStack, vec, 1 - TANK_THICKNESS_WIDTH, scale, TANK_THICKNESS_WIDTH, sprite.getU0(), sprite.getV(scale * 16));
			add(builder, matrixStack, vec, 1 - TANK_THICKNESS_WIDTH, scale, 1 - TANK_THICKNESS_WIDTH, sprite.getU1(), sprite.getV(scale * 16));
			add(builder, matrixStack, vec, 1 - TANK_THICKNESS_WIDTH, TANK_THICKNESS_HEIGHT, 1 - TANK_THICKNESS_WIDTH, sprite.getU1(), sprite.getV0());
			add(builder, matrixStack, vec, 1 - TANK_THICKNESS_WIDTH, TANK_THICKNESS_HEIGHT, TANK_THICKNESS_WIDTH, sprite.getU0(), sprite.getV0());

			//West Face
			add(builder, matrixStack, vec, TANK_THICKNESS_WIDTH, TANK_THICKNESS_HEIGHT, TANK_THICKNESS_WIDTH, sprite.getU1(), sprite.getV1());
			add(builder, matrixStack, vec, TANK_THICKNESS_WIDTH, TANK_THICKNESS_HEIGHT, 1 - TANK_THICKNESS_WIDTH, sprite.getU0(), sprite.getV1());
			add(builder, matrixStack, vec, TANK_THICKNESS_WIDTH, scale, 1 - TANK_THICKNESS_WIDTH, sprite.getU0(), sprite.getV(16 - scale * 16));
			add(builder, matrixStack, vec, TANK_THICKNESS_WIDTH, scale, TANK_THICKNESS_WIDTH, sprite.getU1(), sprite.getV(16 - scale * 16));

		}
		
		matrixStack.popPose();
	}

	private void add(IVertexBuilder renderer, MatrixStack stack, Vector4f colors, float x, float y, float z, float u, float v) {
		
		renderer.vertex(stack.last().pose(), x, y, z).color(colors.x(), colors.y(), colors.z(), colors.w()).uv(u, v).overlayCoords(0, 240).uv2(15728880).normal(1, 0, 0).endVertex();
	}
	
	
	private Vector4f getColorVec(int color) {
		
		Color c = new Color(color);
		
		return new Vector4f((float)c.getRed()/255f, (float)c.getGreen()/255f, (float)c.getBlue()/255f, 1f);
	}
}