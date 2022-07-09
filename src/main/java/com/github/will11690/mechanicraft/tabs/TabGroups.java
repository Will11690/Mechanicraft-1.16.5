package com.github.will11690.mechanicraft.tabs;

import com.github.will11690.mechanicraft.init.ModBlocks;
import com.github.will11690.mechanicraft.init.ModItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TabGroups {

	public static final ItemGroup MOD_ITEM_GROUP = new ItemGroup("mechanicraft_items_tab") {

		@Override
		public ItemStack makeIcon() {
			
			return new ItemStack(ModItems.GOLD_INFUSED_IRON_GEAR.get());
		}
    };
    
	public static final ItemGroup MOD_BLOCK_GROUP = new ItemGroup("mechanicraft_blocks_tab") {

		@Override
		public ItemStack makeIcon() {

			return new ItemStack(ModBlocks.GOLD_INFUSED_IRON_BLOCK.get());
		}
    };
    
	public static final ItemGroup MOD_TOOL_GROUP = new ItemGroup("mechanicraft_tools_tab") {

		@Override
		public ItemStack makeIcon() {
			
			return new ItemStack(ModItems.ENDONIUM_CRYSTAL_PICKAXE.get());
		}
    };
    
	public static final ItemGroup MOD_ARMOR_GROUP = new ItemGroup("mechanicraft_armor_tab") {

		@Override
		public ItemStack makeIcon() {
			
			return new ItemStack(ModItems.ENDONIUM_CRYSTAL_CHESTPLATE.get());
		}
    };
    
	public static final ItemGroup MOD_MACHINES_GROUP = new ItemGroup("mechanicraft_machines_tab") {

		@Override
		public ItemStack makeIcon() {
			
			return new ItemStack(ModBlocks.T1_METALLIC_INFUSER.get());
		}
    };
}