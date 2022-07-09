package com.github.will11690.mechanicraft.blocks.machines.common;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.energy.CapabilityEnergy;

public class ItemValidForSlot {

	public static boolean isEnergyItem(ItemStack stack) {
		
		return stack.getCapability(CapabilityEnergy.ENERGY).isPresent();
		
	}
	
	@SuppressWarnings("deprecation")
	public static boolean isItemFuel(ItemStack stack) {
		
		if(ForgeHooks.getBurnTime(stack) != 0 || stack.getItem().equals(Items.BUCKET)) {
    		
    		return true;
    		
    	} else {
    			
    		return false;
    			
    	}
		
	}
	
	public static boolean isItemFuelCoalGenerator(ItemStack stack) {
		
		Item item = stack.getItem();
		
		if(isItemFuel(stack)) {
			
			if(item.equals(Items.COAL) || item.equals(Items.COAL_BLOCK) || item.equals(Items.CHARCOAL)) {
				
				return true;
				
			} else
				
				return false;
			
		} else
			
			return false;
		
	}
}
