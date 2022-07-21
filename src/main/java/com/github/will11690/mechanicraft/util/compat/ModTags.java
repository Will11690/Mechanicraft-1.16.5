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
    	
    	//FORGE TAGS
        public static final ITag.INamedTag<Block> ORES = forge("ores");
        public static final ITag.INamedTag<Block> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Block> ORES_RUBY = forge("ores/ruby");
        public static final ITag.INamedTag<Block> ORES_SAPPHIRE = forge("ores/sapphire");
        public static final ITag.INamedTag<Block> ORES_LEAD = forge("ores/lead");
        public static final ITag.INamedTag<Block> ORES_COPPER = forge("ores/copper");
        public static final ITag.INamedTag<Block> ORES_TIN = forge("ores/tin");
        public static final ITag.INamedTag<Block> ORES_ENDER = forge("ores/ender");
        
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS = forge("storage_blocks");
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
        
        //MOD TAGS
        public static final ITag.INamedTag<Block> MECHANICRAFT_ORES = mod("ores");
        public static final ITag.INamedTag<Block> MECHANICRAFT_ORES_SILVER = mod("ores/silver");
        public static final ITag.INamedTag<Block> MECHANICRAFT_ORES_RUBY = mod("ores/ruby");
        public static final ITag.INamedTag<Block> MECHANICRAFT_ORES_SAPPHIRE = mod("ores/sapphire");
        public static final ITag.INamedTag<Block> MECHANICRAFT_ORES_LEAD = mod("ores/lead");
        public static final ITag.INamedTag<Block> MECHANICRAFT_ORES_COPPER = mod("ores/copper");
        public static final ITag.INamedTag<Block> MECHANICRAFT_ORES_TIN = mod("ores/tin");
        public static final ITag.INamedTag<Block> MECHANICRAFT_ORES_ENDER = mod("ores/ender");
        
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS = mod("storage_blocks");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_SILVER = mod("storage_blocks/silver");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_COPPER = mod("storage_blocks/copper");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_TIN = mod("storage_blocks/tin");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_LEAD = mod("storage_blocks/lead");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_RUBY = mod("storage_blocks/ruby");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_SAPPHIRE = mod("storage_blocks/sapphire");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_BRONZE = mod("storage_blocks/bronze");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_EMERONIUM = mod("storage_blocks/emeronium");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_ENDONIUM = mod("storage_blocks/endonium");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_ENDONIUM_CRYSTAL = mod("storage_blocks/endonium_crystal");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_GOLD_INFUSED_IRON = mod("storage_blocks/gold_infused_iron");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_OBSIDIUM = mod("storage_blocks/obsidium");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_RUBONIUM = mod("storage_blocks/rubonium");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_SAPHONIUM = mod("storage_blocks/saphonium");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_ENDER = mod("storage_blocks/ender");
        public static final ITag.INamedTag<Block> MECHANICRAFT_STORAGE_BLOCKS_STEEL = mod("storage_blocks/steel");

        private static ITag.INamedTag<Block> forge(String path) {
        	
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
            
        }

        private static ITag.INamedTag<Block> mod(String path) {
        	
            return BlockTags.bind(new ResourceLocation(Reference.MOD_ID, path).toString());
            
        }
        
    }

    public static final class Items {
    	
    	//FORGE TAGS
        public static final ITag.INamedTag<Item> ORES = forge("ores");
        public static final ITag.INamedTag<Item> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Item> ORES_RUBY = forge("ores/ruby");
        public static final ITag.INamedTag<Item> ORES_SAPPHIRE = forge("ores/sapphire");
        public static final ITag.INamedTag<Item> ORES_LEAD = forge("ores/lead");
        public static final ITag.INamedTag<Item> ORES_COPPER = forge("ores/copper");
        public static final ITag.INamedTag<Item> ORES_TIN = forge("ores/tin");
        public static final ITag.INamedTag<Item> ORES_ENDER = forge("ores/ender");

        public static final ITag.INamedTag<Item> STORAGE_BLOCKS = forge("storage_blocks");
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

        public static final ITag.INamedTag<Item> INGOTS = forge("ingots");
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

        public static final ITag.INamedTag<Item> GEMS = forge("gems");
        public static final ITag.INamedTag<Item> GEMS_ENDONIUM_CRYSTAL = forge("gems/endonium_crystal");
        public static final ITag.INamedTag<Item> GEMS_RUBY = forge("gems/ruby");
        public static final ITag.INamedTag<Item> GEMS_SAPPHIRE = forge("gems/sapphire");
        public static final ITag.INamedTag<Item> GEMS_DIAMONIUM_CRYSTAL = forge("gems/diamonium_crystal");

        public static final ITag.INamedTag<Item> NUGGETS = forge("nuggets");
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

        public static final ITag.INamedTag<Item> DUSTS = forge("dusts");
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

        public static final ITag.INamedTag<Item> GEARS = forge("gears");
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

        public static final ITag.INamedTag<Item> PRESS_DIES = forge("press_dies");
        public static final ITag.INamedTag<Item> GEAR_DIE = forge("press_dies/gear_die");
        public static final ITag.INamedTag<Item> PLATE_DIE = forge("press_dies/plate_die");
        public static final ITag.INamedTag<Item> ROD_DIE = forge("press_dies/rod_die");

        public static final ITag.INamedTag<Item> MECHANICRAFT_ORES = mod("ores");
        public static final ITag.INamedTag<Item> MECHANICRAFT_ORES_SILVER = mod("ores/silver");
        public static final ITag.INamedTag<Item> MECHANICRAFT_ORES_RUBY = mod("ores/ruby");
        public static final ITag.INamedTag<Item> MECHANICRAFT_ORES_SAPPHIRE = mod("ores/sapphire");
        public static final ITag.INamedTag<Item> MECHANICRAFT_ORES_LEAD = mod("ores/lead");
        public static final ITag.INamedTag<Item> MECHANICRAFT_ORES_COPPER = mod("ores/copper");
        public static final ITag.INamedTag<Item> MECHANICRAFT_ORES_TIN = mod("ores/tin");
        public static final ITag.INamedTag<Item> MECHANICRAFT_ORES_ENDER = mod("ores/ender");

        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS = mod("storage_blocks");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_SILVER = mod("storage_blocks/silver");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_COPPER = mod("storage_blocks/copper");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_TIN = mod("storage_blocks/tin");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_LEAD = mod("storage_blocks/lead");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_RUBY = mod("storage_blocks/ruby");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_SAPPHIRE = mod("storage_blocks/sapphire");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_BRONZE = mod("storage_blocks/bronze");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_EMERONIUM = mod("storage_blocks/emeronium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_ENDONIUM = mod("storage_blocks/endonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_ENDONIUM_CRYSTAL = mod("storage_blocks/endonium_crystal");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_GOLD_INFUSED_IRON = mod("storage_blocks/gold_infused_iron");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_OBSIDIUM = mod("storage_blocks/obsidium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_RUBONIUM = mod("storage_blocks/rubonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_SAPHONIUM = mod("storage_blocks/saphonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_STEEL = mod("storage_blocks/steel");
        public static final ITag.INamedTag<Item> MECHANICRAFT_STORAGE_BLOCKS_ENDER = mod("storage_blocks/ender");

        //MOD TAGS
        public static final ITag.INamedTag<Item> MECHANICRAFT_INGOTS = mod("ingots");
        public static final ITag.INamedTag<Item> MECHANICRAFT_INGOTS_SILVER = mod("ingots/silver");
        public static final ITag.INamedTag<Item> MECHANICRAFT_INGOTS_COPPER = mod("ingots/copper");
        public static final ITag.INamedTag<Item> MECHANICRAFT_INGOTS_TIN = mod("ingots/tin");
        public static final ITag.INamedTag<Item> MECHANICRAFT_INGOTS_LEAD = mod("ingots/lead");
        public static final ITag.INamedTag<Item> MECHANICRAFT_INGOTS_BRONZE = mod("ingots/bronze");
        public static final ITag.INamedTag<Item> MECHANICRAFT_INGOTS_EMERONIUM = mod("ingots/emeronium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_INGOTS_ENDONIUM = mod("ingots/endonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_INGOTS_GOLD_INFUSED_IRON = mod("ingots/gold_infused_iron");
        public static final ITag.INamedTag<Item> MECHANICRAFT_INGOTS_OBSIDIUM = mod("ingots/obsidium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_INGOTS_RUBONIUM = mod("ingots/rubonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_INGOTS_SAPHONIUM = mod("ingots/saphonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_INGOTS_STEEL = mod("ingots/steel");
        public static final ITag.INamedTag<Item> MECHANICRAFT_INGOTS_ENDER = mod("ingots/ender");

        public static final ITag.INamedTag<Item> MECHANICRAFT_GEMS = mod("gems");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEMS_ENDONIUM_CRYSTAL = mod("gems/endonium_crystal");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEMS_RUBY = mod("gems/ruby");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEMS_SAPPHIRE = mod("gems/sapphire");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEMS_DIAMONIUM_CRYSTAL = mod("gems/diamonium_crystal");

        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS = mod("nuggets");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_SILVER = mod("nuggets/silver");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_TIN = mod("nuggets/tin");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_COPPER = mod("nuggets/copper");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_BRONZE = mod("nuggets/bronze");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_DIAMOND = mod("nuggets/diamond");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_EMERALD = mod("nuggets/emerald");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_RUBY = mod("nuggets/ruby");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_SAPPHIRE = mod("nuggets/sapphire");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_RUBONIUM = mod("nuggets/rubonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_EMERONIUM = mod("nuggets/emeronium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_SAPHONIUM = mod("nuggets/saphonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_ENDONIUM = mod("nuggets/endonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_OBSIDIUM = mod("nuggets/obsidium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_DIAMONIUM_CRYSTAL = mod("nuggets/diamonium_crystal");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_ENDONIUM_CRYSTAL = mod("nuggets/endonium_crystal");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_GOLD_INFUSED_IRON = mod("nuggets/gold_infused_iron");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_LEAD = mod("nuggets/lead");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_STEEL = mod("nuggets/steel");
        public static final ITag.INamedTag<Item> MECHANICRAFT_NUGGETS_ENDER = mod("nuggets/ender");

        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS = mod("dusts");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_SILVER = mod("dusts/silver");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_TIN = mod("dusts/tin");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_COPPER = mod("dusts/copper");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_BRONZE = mod("dusts/bronze");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_IRON = mod("dusts/iron");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_GOLD = mod("dusts/gold");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_DIAMOND = mod("dusts/diamond");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_EMERALD = mod("dusts/emerald");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_OBSIDIAN = mod("dusts/obsidian");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_RUBY = mod("dusts/ruby");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_SAPPHIRE = mod("dusts/sapphire");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_RUBONIUM = mod("dusts/rubonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_EMERONIUM = mod("dusts/emeronium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_SAPHONIUM = mod("dusts/saphonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_ENDONIUM = mod("dusts/endonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_OBSIDIUM = mod("dusts/obsidium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_DIAMONIUM_CRYSTAL = mod("dusts/diamonium_crystal");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_ENDONIUM_CRYSTAL = mod("dusts/endonium_crystal");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_GOLD_INFUSED_IRON = mod("dusts/gold_infused_iron");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_LEAD = mod("dusts/lead");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_STEEL = mod("dusts/steel");
        public static final ITag.INamedTag<Item> MECHANICRAFT_DUSTS_ENDER = mod("dusts/ender");

        public static final ITag.INamedTag<Item> MECHANICRAFT_GEARS = mod("gears");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEARS_DIAMONIUM = mod("gears/diamonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEARS_EMERONIUM = mod("gears/emeronium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEARS_ENDONIUM = mod("gears/endonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEARS_GOLD_INFUSED_IRON = mod("gears/gold_infused_iron");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEARS_OBSIDIUM = mod("gears/obsidium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEARS_RUBONIUM = mod("gears/rubonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEARS_SAPHONIUM = mod("gears/saphonium");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEARS_WOODEN = mod("gears/wooden");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEARS_WOOD = mod("gears/wood");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEARS_IRON = mod("gears/iron");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEARS_STONE = mod("gears/stone");
        
        public static final ITag.INamedTag<Item> MECHANICRAFT_PRESS_DIES = mod("press_dies");
        public static final ITag.INamedTag<Item> MECHANICRAFT_GEAR_DIE = mod("press_dies/gear_die");
        public static final ITag.INamedTag<Item> MECHANICRAFT_PLATE_DIE = mod("press_dies/plate_die");
        public static final ITag.INamedTag<Item> MECHANICRAFT_ROD_DIE = mod("press_dies/rod_die");

        private static ITag.INamedTag<Item> forge(String path) {
        	
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
        	
            return ItemTags.bind(new ResourceLocation(Reference.MOD_ID, path).toString());
        }
    }
}