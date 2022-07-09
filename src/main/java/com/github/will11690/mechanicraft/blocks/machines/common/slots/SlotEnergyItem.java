package com.github.will11690.mechanicraft.blocks.machines.common.slots;

import com.github.will11690.mechanicraft.blocks.machines.common.ItemValidForSlot;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotEnergyItem extends SlotItemHandler {

	public SlotEnergyItem(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		
		super(itemHandler, index, xPosition, yPosition);
		
	}
		
	@Override
	public boolean mayPlace(ItemStack stack) {
			
		if(ItemValidForSlot.isEnergyItem(stack)) {
			
			return true;
		
		} else {
			
			return false;
			
		}
	}
}