package com.github.will11690.mechanicraft.util.compat;

import com.github.will11690.mechanicraft.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
	
    public static final class Blocks {
    	
        public static final ITag.INamedTag<Block> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Block> ORES_RUBY = forge("ores/ruby");
        public static final ITag.INamedTag<Block> ORES_SAPPHIRE = forge("ores/sapphire");
        public static final ITag.INamedTag<Block> ORES_LEAD = forge("ores/lead");
        public static final ITag.INamedTag<Block> ORES_COPPER = forge("ores/copper");
        public static final ITag.INamedTag<Block> ORES_TIN = forge("ores/tin");
        public static final ITag.INamedTag<Block> ORES_ENDER = forge("ores/ender");
        
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_SILVER = forge("storage_blocks/silver");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_COPPER = forge("storage_blocks/copper");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_TIN = forge("storage_blocks/tin");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_LEAD = forge("storage_blocks/lead");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_RUBY = forge("storage_blocks/ruby");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_SAPPHIRE = forge("storage_blocks/sapphire");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_BRONZE = forge("storage_blocks/bronze");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_EMERONIUM = forge("storage_blocks/emeronium");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_ENDONIUM = forge("storage_blocks/endonium");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_ENDONIUM_CRYSTAL = forge("storage_blocks/endonium_crystal");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_GOLD_INFUSED_IRON = forge("storage_blocks/gold_infused_iron");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_OBSIDIUM = forge("storage_blocks/obsidium");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_RUBONIUM = forge("storage_blocks/rubonium");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_SAPHONIUM = forge("storage_blocks/saphonium");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_ENDER = forge("storage_blocks/ender");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_STEEL = forge("storage_blocks/steel");

        private static ITag.INamedTag<Block> forge(String path) {
        	
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
            
        }
        
        //RESERVED PATH FOR MOD SPECIFIC TAGS(Will remove if never used)

        /*private static ITag.INamedTag<Block> mod(String path) {
        	//TODO Evaluate the need for this to ever be used
            return BlockTags.bind(new ResourceLocation(Reference.MOD_ID, path).toString());
            
        }*/
        
    }

    public static final class Items {
    	
        public static final ITag.INamedTag<Item> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Item> ORES_RUBY = forge("ores/ruby");
        public static final ITag.INamedTag<Item> ORES_SAPPHIRE = forge("ores/sapphire");
        public static final ITag.INamedTag<Item> ORES_LEAD = forge("ores/lead");
        public static final ITag.INamedTag<Item> ORES_COPPER = forge("ores/copper");
        public static final ITag.INamedTag<Item> ORES_TIN = forge("ores/tin");
        public static final ITag.INamedTag<Item> ORES_ENDER = forge("ores/ender");
        
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_SILVER = forge("storage_blocks/silver");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_COPPER = forge("storage_blocks/copper");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_TIN = forge("storage_blocks/tin");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_LEAD = forge("storage_blocks/lead");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_RUBY = forge("storage_blocks/ruby");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_SAPPHIRE = forge("storage_blocks/sapphire");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_BRONZE = forge("storage_blocks/bronze");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_EMERONIUM = forge("storage_blocks/emeronium");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_ENDONIUM = forge("storage_blocks/endonium");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_ENDONIUM_CRYSTAL = forge("storage_blocks/endonium_crystal");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_GOLD_INFUSED_IRON = forge("storage_blocks/gold_infused_iron");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_OBSIDIUM = forge("storage_blocks/obsidium");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_RUBONIUM = forge("storage_blocks/rubonium");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_SAPHONIUM = forge("storage_blocks/saphonium");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_STEEL = forge("storage_blocks/steel");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_ENDER = forge("storage_blocks/ender");

        public static final ITag.INamedTag<Item> INGOTS_SILVER = forge("ingots/silver");
        public static final ITag.INamedTag<Item> INGOTS_COPPER = forge("ingots/copper");
        public static final ITag.INamedTag<Item> INGOTS_TIN = forge("ingots/tin");
        public static final ITag.INamedTag<Item> INGOTS_LEAD = forge("ingots/lead");
        public static final ITag.INamedTag<Item> INGOTS_BRONZE = forge("ingots/bronze");
        public static final ITag.INamedTag<Item> INGOTS_EMERONIUM = forge("ingots/emeronium");
        public static final ITag.INamedTag<Item> INGOTS_ENDONIUM = forge("ingots/endonium");
        public static final ITag.INamedTag<Item> INGOTS_GOLD_INFUSED_IRON = forge("ingots/gold_infused_iron");
        public static final ITag.INamedTag<Item> INGOTS_OBSIDIUM = forge("ingots/obsidium");
        public static final ITag.INamedTag<Item> INGOTS_RUBONIUM = forge("ingots/rubonium");
        public static final ITag.INamedTag<Item> INGOTS_SAPHONIUM = forge("ingots/saphonium");
        public static final ITag.INamedTag<Item> INGOTS_STEEL = forge("ingots/steel");
        public static final ITag.INamedTag<Item> INGOTS_ENDER = forge("ingots/ender");
        
        public static final ITag.INamedTag<Item> GEMS_ENDONIUM_CRYSTAL = forge("gems/endonium_crystal");
        public static final ITag.INamedTag<Item> GEMS_RUBY = forge("gems/ruby");
        public static final ITag.INamedTag<Item> GEMS_SAPPHIRE = forge("gems/sapphire");
        public static final ITag.INamedTag<Item> GEMS_DIAMONIUM_CRYSTAL = forge("gems/diamonium_crystal");
        
        public static final ITag.INamedTag<Item> NUGGETS_SILVER = forge("nuggets/silver");
        public static final ITag.INamedTag<Item> NUGGETS_TIN = forge("nuggets/tin");
        public static final ITag.INamedTag<Item> NUGGETS_COPPER = forge("nuggets/copper");
        public static final ITag.INamedTag<Item> NUGGETS_BRONZE = forge("nuggets/bronze");
        public static final ITag.INamedTag<Item> NUGGETS_DIAMOND = forge("nuggets/diamond");
        public static final ITag.INamedTag<Item> NUGGETS_EMERALD = forge("nuggets/emerald");
        public static final ITag.INamedTag<Item> NUGGETS_RUBY = forge("nuggets/ruby");
        public static final ITag.INamedTag<Item> NUGGETS_SAPPHIRE = forge("nuggets/sapphire");
        public static final ITag.INamedTag<Item> NUGGETS_RUBONIUM = forge("nuggets/rubonium");
        public static final ITag.INamedTag<Item> NUGGETS_EMERONIUM = forge("nuggets/emeronium");
        public static final ITag.INamedTag<Item> NUGGETS_SAPHONIUM = forge("nuggets/saphonium");
        public static final ITag.INamedTag<Item> NUGGETS_ENDONIUM = forge("nuggets/endonium");
        public static final ITag.INamedTag<Item> NUGGETS_OBSIDIUM = forge("nuggets/obsidium");
        public static final ITag.INamedTag<Item> NUGGETS_DIAMONIUM_CRYSTAL = forge("nuggets/diamonium_crystal");
        public static final ITag.INamedTag<Item> NUGGETS_ENDONIUM_CRYSTAL = forge("nuggets/endonium_crystal");
        public static final ITag.INamedTag<Item> NUGGETS_GOLD_INFUSED_IRON = forge("nuggets/gold_infused_iron");
        public static final ITag.INamedTag<Item> NUGGETS_LEAD = forge("nuggets/lead");
        public static final ITag.INamedTag<Item> NUGGETS_STEEL = forge("nuggets/steel");
        public static final ITag.INamedTag<Item> NUGGETS_ENDER = forge("nuggets/ender");
        
        public static final ITag.INamedTag<Item> DUSTS_SILVER = forge("dusts/silver");
        public static final ITag.INamedTag<Item> DUSTS_TIN = forge("dusts/tin");
        public static final ITag.INamedTag<Item> DUSTS_COPPER = forge("dusts/copper");
        public static final ITag.INamedTag<Item> DUSTS_BRONZE = forge("dusts/bronze");
        public static final ITag.INamedTag<Item> DUSTS_IRON = forge("dusts/iron");
        public static final ITag.INamedTag<Item> DUSTS_GOLD = forge("dusts/gold");
        public static final ITag.INamedTag<Item> DUSTS_DIAMOND = forge("dusts/diamond");
        public static final ITag.INamedTag<Item> DUSTS_EMERALD = forge("dusts/emerald");
        public static final ITag.INamedTag<Item> DUSTS_OBSIDIAN = forge("dusts/obsidian");
        public static final ITag.INamedTag<Item> DUSTS_RUBY = forge("dusts/ruby");
        public static final ITag.INamedTag<Item> DUSTS_SAPPHIRE = forge("dusts/sapphire");
        public static final ITag.INamedTag<Item> DUSTS_RUBONIUM = forge("dusts/rubonium");
        public static final ITag.INamedTag<Item> DUSTS_EMERONIUM = forge("dusts/emeronium");
        public static final ITag.INamedTag<Item> DUSTS_SAPHONIUM = forge("dusts/saphonium");
        public static final ITag.INamedTag<Item> DUSTS_ENDONIUM = forge("dusts/endonium");
        public static final ITag.INamedTag<Item> DUSTS_OBSIDIUM = forge("dusts/obsidium");
        public static final ITag.INamedTag<Item> DUSTS_DIAMONIUM_CRYSTAL = forge("dusts/diamonium_crystal");
        public static final ITag.INamedTag<Item> DUSTS_ENDONIUM_CRYSTAL = forge("dusts/endonium_crystal");
        public static final ITag.INamedTag<Item> DUSTS_GOLD_INFUSED_IRON = forge("dusts/gold_infused_iron");
        public static final ITag.INamedTag<Item> DUSTS_LEAD = forge("dusts/lead");
        public static final ITag.INamedTag<Item> DUSTS_STEEL = forge("dusts/steel");
        public static final ITag.INamedTag<Item> DUSTS_ENDER = forge("dusts/ender");
        
        public static final ITag.INamedTag<Item> GEARS_DIAMONIUM = forge("gears/diamonium");
        public static final ITag.INamedTag<Item> GEARS_EMERONIUM = forge("gears/emeronium");
        public static final ITag.INamedTag<Item> GEARS_ENDONIUM = forge("gears/endonium");
        public static final ITag.INamedTag<Item> GEARS_GOLD_INFUSED_IRON = forge("gears/gold_infused_iron");
        public static final ITag.INamedTag<Item> GEARS_OBSIDIUM = forge("gears/obsidium");
        public static final ITag.INamedTag<Item> GEARS_RUBONIUM = forge("gears/rubonium");
        public static final ITag.INamedTag<Item> GEARS_SAPHONIUM = forge("gears/saphonium");
        public static final ITag.INamedTag<Item> GEARS_WOODEN = forge("gears/wooden");
        public static final ITag.INamedTag<Item> GEARS_WOOD = forge("gears/wood");
        public static final ITag.INamedTag<Item> GEARS_IRON = forge("gears/iron");
        public static final ITag.INamedTag<Item> GEARS_STONE = forge("gears/stone");
        
        public static final ITag.INamedTag<Item> GEAR_DIE = mod("press_dies/gear_die");
        public static final ITag.INamedTag<Item> PLATE_DIE = mod("press_dies/plate_die");
        public static final ITag.INamedTag<Item> ROD_DIE = mod("press_dies/rod_die");

        private static ITag.INamedTag<Item> forge(String path) {
        	
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
        	
            return ItemTags.bind(new ResourceLocation(Reference.MOD_ID, path).toString());
        }
    }
}