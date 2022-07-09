package com.github.will11690.mechanicraft.blocks.machines.common.slots;

import javax.annotation.Nonnull;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import com.github.will11690.mechanicraft.init.ModItems;

public class SlotUpgrade extends SlotItemHandler {
	
	public SlotUpgrade(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        	
		super(itemHandler, index, xPosition, yPosition);
            
	}

	@Override
	public boolean mayPlace(@Nonnull ItemStack stack) {
        	
		Item item = stack.getItem();
        	
		if(item.equals(ModItems.CAPACITY_UPGRADE.get()) || item.equals(ModItems.EFFICIENCY_UPGRADE.get()) || item.equals(ModItems.SPEED_UPGRADE.get()) || item.equals(ModItems.TRANSFER_UPGRADE.get())) {
    			
			return true;
    			
		} else 
        		
			return false;
        	
	}
}