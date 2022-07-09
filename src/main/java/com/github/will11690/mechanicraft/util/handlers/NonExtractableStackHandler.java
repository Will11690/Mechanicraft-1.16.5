package com.github.will11690.mechanicraft.util.handlers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class NonExtractableStackHandler extends ItemStackHandler {
	
	private final ItemStackHandler internalSlot;

	public NonExtractableStackHandler(ItemStackHandler hidden) {
		
		super();
		internalSlot = hidden;
		
	}

	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		
		return internalSlot.insertItem(slot, stack, simulate);
		
	}

	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		
		return ItemStack.EMPTY;
		
	}
}