package com.github.will11690.mechanicraft.items.tanks;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.blocks.fluidtank.advfluidtank.AdvFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.basicfluidtank.BasicFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.elitefluidtank.EliteFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.superiorfluidtank.SuperiorFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.supremefluidtank.SupremeFluidTank;
import com.github.will11690.mechanicraft.blocks.fluidtank.ultimatefluidtank.UltimateFluidTank;
import com.github.will11690.mechanicraft.init.ModConfigs;

import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack;

public class TankItem extends BlockItem {

	private int CAPACITY;
	
	public TankItem(Block block, Properties properties) {
		super(block, properties.stacksTo(1));
		
		if(block instanceof BasicFluidTank) {
			
			CAPACITY = ModConfigs.basicTankCapacityInt;
		}
		
		if(block instanceof AdvFluidTank) {
			
			CAPACITY = ModConfigs.advancedTankCapacityInt;
		}
		
		if(block instanceof EliteFluidTank) {
			
			CAPACITY = ModConfigs.eliteTankCapacityInt;
		}
		
		if(block instanceof SuperiorFluidTank) {
			
			CAPACITY = ModConfigs.superiorTankCapacityInt;
		}
		
		if(block instanceof SupremeFluidTank) {
			
			CAPACITY = ModConfigs.supremeTankCapacityInt;
		}
		
		if(block instanceof UltimateFluidTank) {
			
			CAPACITY = ModConfigs.ultimateTankCapacityInt;
		}
	}
	
	@Override
	public ICapabilityProvider initCapabilities(@Nonnull ItemStack stack, @Nullable CompoundNBT nbt) {
		 
		return new FluidHandlerItemStack(stack, CAPACITY);
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> textComp, ITooltipFlag flag) {
	    
		super.appendHoverText(stack, world, textComp, flag);
		
		if(stack.hasTag()) {
			
			CompoundNBT stackNBT = stack.getTagElement("BlockEntityTag");
			
			if(stackNBT.contains("fluidTank")) {
				
				FluidStack fluid = FluidStack.loadFluidStackFromNBT(stackNBT.getCompound("fluidTank"));
				String fluidInTank = fluid.getDisplayName().getString();
				
				int fluidStored = fluid.getAmount();
				int capacity = ModConfigs.basicTankCapacityInt;
				
				if(!fluid.isEmpty()) {
					
					textComp.add(new StringTextComponent(fluidInTank).withStyle(TextFormatting.BOLD).withStyle(TextFormatting.AQUA));
				}
				
				if(fluidStored > 0) {
					
					if(Screen.hasShiftDown()) {
				
						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.fluid_tank_storage_full", fluidStored, capacity));
				
					} else {

						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"));
						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.fluid_tank_storage", fluidStored / 1000, capacity / 1000));
					}
					
				} else {
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.empty_tank").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.AQUA));
				}
			}
			
			if(stackNBT.contains("advancedFluidTank")) {
				
				FluidStack fluid = FluidStack.loadFluidStackFromNBT(stackNBT.getCompound("advancedFluidTank"));
				String fluidInTank = fluid.getDisplayName().getString();
				
				int fluidStored = fluid.getAmount();
				int capacity = ModConfigs.advancedTankCapacityInt;
				
				if(!fluid.isEmpty()) {
					
					textComp.add(new StringTextComponent(fluidInTank).withStyle(TextFormatting.BOLD).withStyle(TextFormatting.AQUA));
				}
				
				if(fluidStored > 0) {
					
					if(Screen.hasShiftDown()) {
				
						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.fluid_tank_storage_full", fluidStored, capacity));
				
					} else {

						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"));
						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.fluid_tank_storage", fluidStored / 1000, capacity / 1000));
					}
					
				} else {
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.empty_tank").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.AQUA));
				}
			}
			
			if(stackNBT.contains("eliteFluidTank")) {
				
				FluidStack fluid = FluidStack.loadFluidStackFromNBT(stackNBT.getCompound("eliteFluidTank"));
				String fluidInTank = fluid.getDisplayName().getString();
				
				int fluidStored = fluid.getAmount();
				int capacity = ModConfigs.eliteTankCapacityInt;
				
				if(!fluid.isEmpty()) {
					
					textComp.add(new StringTextComponent(fluidInTank).withStyle(TextFormatting.BOLD).withStyle(TextFormatting.AQUA));
				}
				
				if(fluidStored > 0) {
					
					if(Screen.hasShiftDown()) {
				
						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.fluid_tank_storage_full", fluidStored, capacity));
				
					} else {

						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"));
						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.fluid_tank_storage", fluidStored / 1000, capacity / 1000));
					}
					
				} else {
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.empty_tank").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.AQUA));
				}
			}
			
			if(stackNBT.contains("superiorFluidTank")) {
				
				FluidStack fluid = FluidStack.loadFluidStackFromNBT(stackNBT.getCompound("superiorFluidTank"));
				String fluidInTank = fluid.getDisplayName().getString();
				
				int fluidStored = fluid.getAmount();
				int capacity = ModConfigs.superiorTankCapacityInt;
				
				if(!fluid.isEmpty()) {
					
					textComp.add(new StringTextComponent(fluidInTank).withStyle(TextFormatting.BOLD).withStyle(TextFormatting.AQUA));
				}
				
				if(fluidStored > 0) {
					
					if(Screen.hasShiftDown()) {
				
						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.fluid_tank_storage_full", fluidStored, capacity));
				
					} else {

						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"));
						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.fluid_tank_storage", fluidStored / 1000, capacity / 1000));
					}
					
				} else {
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.empty_tank").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.AQUA));
				}
			}
			
			if(stackNBT.contains("supremeFluidTank")) {
				
				FluidStack fluid = FluidStack.loadFluidStackFromNBT(stackNBT.getCompound("supremeFluidTank"));
				String fluidInTank = fluid.getDisplayName().getString();
				
				int fluidStored = fluid.getAmount();
				int capacity = ModConfigs.supremeTankCapacityInt;
				
				if(!fluid.isEmpty()) {
					
					textComp.add(new StringTextComponent(fluidInTank).withStyle(TextFormatting.BOLD).withStyle(TextFormatting.AQUA));
				}
				
				if(fluidStored > 0) {
					
					if(Screen.hasShiftDown()) {
				
						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.fluid_tank_storage_full", fluidStored, capacity));
				
					} else {

						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"));
						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.fluid_tank_storage", fluidStored / 1000, capacity / 1000));
					}
					
				} else {
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.empty_tank").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.AQUA));
				}
			}
			
			if(stackNBT.contains("ultimateFluidTank")) {
				
				FluidStack fluid = FluidStack.loadFluidStackFromNBT(stackNBT.getCompound("ultimateFluidTank"));
				String fluidInTank = fluid.getDisplayName().getString();
				
				int fluidStored = fluid.getAmount();
				int capacity = ModConfigs.ultimateTankCapacityInt;
				
				if(!fluid.isEmpty()) {
					
					textComp.add(new StringTextComponent(fluidInTank).withStyle(TextFormatting.BOLD).withStyle(TextFormatting.AQUA));
				}
				
				if(fluidStored > 0) {
					
					if(Screen.hasShiftDown()) {
				
						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.fluid_tank_storage_full", fluidStored, capacity));
				
					} else {

						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"));
						textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.fluid_tank_storage", fluidStored / 1000, capacity / 1000));
					}
					
				} else {
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.empty_tank").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.AQUA));
				}
			}
		} else {
			
			textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.empty_tank").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.AQUA));
		}
	}
}