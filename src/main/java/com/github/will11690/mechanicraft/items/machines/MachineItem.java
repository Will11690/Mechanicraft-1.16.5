package com.github.will11690.mechanicraft.items.machines;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fluids.FluidStack;

public class MachineItem extends BlockItem {

	public MachineItem(Block block, Properties properties) {
		super(block, properties);
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> textComp, ITooltipFlag flag) {
	    
		super.appendHoverText(stack, world, textComp, flag);
		
		if(stack.hasTag() && stack.getTag().contains("BlockEntityTag")) {
			
			CompoundNBT stackNBT = stack.getTagElement("BlockEntityTag");
			CompoundNBT energyStoredNBT = stackNBT.getCompound("energy");
			
			int energyStored = energyStoredNBT.getInt("energy");
			
			if(energyStored > 0) {
				
				textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.machine_energy").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.GREEN));
				
			}
			
			if(energyStored == 0) {
				
				textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.machine_energy_empty").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.RED));
			}
			
			if(Screen.hasShiftDown()) {
				
				textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.energy_full", energyStored));
				
				if(stackNBT.contains("inputTank")) {
					
					FluidStack fluid = FluidStack.loadFluidStackFromNBT(stackNBT.getCompound("inputTank"));
					String fluidStored = fluid.getDisplayName().getString();
					
					int fluidAmount = fluid.getAmount();
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.fluid_tank_machine_full", fluidStored, fluidAmount));
					
				}
				
				if(stackNBT.contains("inputTank1")) {
					
					FluidStack fluid = FluidStack.loadFluidStackFromNBT(stackNBT.getCompound("inputTank1"));
					String fluidStored = fluid.getDisplayName().getString();
					
					int fluidAmount = fluid.getAmount();
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.fluid_tank_machine_full", fluidStored, fluidAmount));
					
				}
				
				if(stackNBT.contains("inputTank2")) {
					
					FluidStack fluid = FluidStack.loadFluidStackFromNBT(stackNBT.getCompound("inputTank2"));
					String fluidStored = fluid.getDisplayName().getString();
					
					int fluidAmount = fluid.getAmount();
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.fluid_tank_machine_full", fluidStored, fluidAmount));
					
				}
				
				if(stackNBT.contains("outputTank")) {
					
					FluidStack fluid = FluidStack.loadFluidStackFromNBT(stackNBT.getCompound("outputTank"));
					String fluidStored = fluid.getDisplayName().getString();
					
					int fluidAmount = fluid.getAmount();
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.fluid_tank_machine_full", fluidStored, fluidAmount));
					
				}
				
				if(stackNBT.contains("upgradeSlot")) {
					
					CompoundNBT upgradeNBT = stackNBT.getCompound("upgradeSlot");
					
					if(!upgradeNBT.getList("Items", Constants.NBT.TAG_COMPOUND).isEmpty()) {
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.upgrade"));
					
					}
				}
				
			} else {
				
				textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"));
				
				if(energyStored <= 1000 && energyStored < 1000000) {
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.energy_full", energyStored));
				}
				
				if(energyStored > 1000 && energyStored < 1000000) {
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.energy_thousand", energyStored / 1000));
				}
				
				if(energyStored >= 1000000) {
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.energy_million", energyStored / 1000000));
				}
				
				if(stackNBT.contains("inputTank")) {
					
					FluidStack fluid = FluidStack.loadFluidStackFromNBT(stackNBT.getCompound("inputTank"));
					String fluidStored = fluid.getDisplayName().getString();
					
					int fluidAmount = fluid.getAmount();
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.fluid_tank_machine", fluidStored, fluidAmount / 1000));
					
				}
				
				if(stackNBT.contains("inputTank1")) {
					
					FluidStack fluid = FluidStack.loadFluidStackFromNBT(stackNBT.getCompound("inputTank1"));
					String fluidStored = fluid.getDisplayName().getString();
					
					int fluidAmount = fluid.getAmount();
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.fluid_tank_machine", fluidStored, fluidAmount / 1000));
					
				}
				
				if(stackNBT.contains("inputTank2")) {
					
					FluidStack fluid = FluidStack.loadFluidStackFromNBT(stackNBT.getCompound("inputTank2"));
					String fluidStored = fluid.getDisplayName().getString();
					
					int fluidAmount = fluid.getAmount();
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.fluid_tank_machine", fluidStored, fluidAmount / 1000));
					
				}
				
				if(stackNBT.contains("outputTank")) {
					
					FluidStack fluid = FluidStack.loadFluidStackFromNBT(stackNBT.getCompound("outputTank"));
					String fluidStored = fluid.getDisplayName().getString();
					
					int fluidAmount = fluid.getAmount();
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.fluid_tank_machine", fluidStored, fluidAmount / 1000));
					
				}
				
				if(stackNBT.contains("upgradeSlot")) {
					
					CompoundNBT upgradeNBT = stackNBT.getCompound("upgradeSlot");
					
					if(!upgradeNBT.getList("Items", Constants.NBT.TAG_COMPOUND).isEmpty()) {
					
					textComp.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.upgrade"));
					
					}
				}
			}
		}
	}
}
