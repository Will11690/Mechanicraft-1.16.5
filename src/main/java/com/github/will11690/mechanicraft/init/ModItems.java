package com.github.will11690.mechanicraft.init;

import java.util.List;

import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.items.armor.EArmorBase;
import com.github.will11690.mechanicraft.items.armor.ECArmorBase;
import com.github.will11690.mechanicraft.items.armor.EMArmorBase;
import com.github.will11690.mechanicraft.items.armor.GArmorBase;
import com.github.will11690.mechanicraft.items.armor.MechanicraftArmorTiers;
import com.github.will11690.mechanicraft.items.armor.OArmorBase;
import com.github.will11690.mechanicraft.items.armor.RArmorBase;
import com.github.will11690.mechanicraft.items.armor.SArmorBase;
import com.github.will11690.mechanicraft.items.tools.MechanicraftToolTiers;
import com.github.will11690.mechanicraft.tabs.TabGroups;
import com.github.will11690.mechanicraft.util.handlers.RegistryHandler;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
	
	//INGOTS
    public static final RegistryObject<Item> COPPER_INGOT = RegistryHandler.ITEMS.register("copper_ingot", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> TIN_INGOT = RegistryHandler.ITEMS.register("tin_ingot", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> BRONZE_INGOT = RegistryHandler.ITEMS.register("bronze_ingot", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> SILVER_INGOT = RegistryHandler.ITEMS.register("silver_ingot", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> EMERONIUM_INGOT = RegistryHandler.ITEMS.register("emeronium_ingot", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> ENDONIUM_INGOT = RegistryHandler.ITEMS.register("endonium_ingot", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> GOLD_INFUSED_IRON_INGOT = RegistryHandler.ITEMS.register("gold_infused_iron_ingot", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> LEAD_INGOT = RegistryHandler.ITEMS.register("lead_ingot", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> STEEL_INGOT = RegistryHandler.ITEMS.register("steel_ingot", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> ENDER_INGOT = RegistryHandler.ITEMS.register("ender_ingot", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> OBSIDIUM_INGOT = RegistryHandler.ITEMS.register("obsidium_ingot", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> RUBONIUM_INGOT = RegistryHandler.ITEMS.register("rubonium_ingot", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> SAPHONIUM_INGOT = RegistryHandler.ITEMS.register("saphonium_ingot", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    //GEMS
    public static final RegistryObject<Item> ENDONIUM_CRYSTAL = RegistryHandler.ITEMS.register("endonium_crystal", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> DIAMONIUM_CRYSTAL = RegistryHandler.ITEMS.register("diamonium_crystal", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> RUBY = RegistryHandler.ITEMS.register("ruby_gem", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> SAPPHIRE = RegistryHandler.ITEMS.register("sapphire_gem", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    //NUGGETS
    public static final RegistryObject<Item> BRONZE_NUGGET = RegistryHandler.ITEMS.register("bronze_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> COPPER_NUGGET = RegistryHandler.ITEMS.register("copper_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> TIN_NUGGET = RegistryHandler.ITEMS.register("tin_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> STEEL_NUGGET = RegistryHandler.ITEMS.register("steel_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> ENDER_NUGGET = RegistryHandler.ITEMS.register("ender_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> SILVER_NUGGET = RegistryHandler.ITEMS.register("silver_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> GOLD_INFUSED_IRON_NUGGET = RegistryHandler.ITEMS.register("gold_infused_iron_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> DIAMONIUM_CRYSTAL_NUGGET = RegistryHandler.ITEMS.register("diamonium_crystal_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> DIAMOND_NUGGET = RegistryHandler.ITEMS.register("diamond_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> RUBY_NUGGET = RegistryHandler.ITEMS.register("ruby_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> SAPPHIRE_NUGGET = RegistryHandler.ITEMS.register("sapphire_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> EMERALD_NUGGET = RegistryHandler.ITEMS.register("emerald_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> OBSIDIUM_NUGGET = RegistryHandler.ITEMS.register("obsidium_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> RUBONIUM_NUGGET = RegistryHandler.ITEMS.register("rubonium_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> SAPHONIUM_NUGGET = RegistryHandler.ITEMS.register("saphonium_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> ENDONIUM_NUGGET = RegistryHandler.ITEMS.register("endonium_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> ENDONIUM_CRYSTAL_NUGGET = RegistryHandler.ITEMS.register("endonium_crystal_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> EMERONIUM_NUGGET = RegistryHandler.ITEMS.register("emeronium_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> LEAD_NUGGET = RegistryHandler.ITEMS.register("lead_nugget", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    //DUSTS
    public static final RegistryObject<Item> TIN_DUST = RegistryHandler.ITEMS.register("tin_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> ENDER_DUST = RegistryHandler.ITEMS.register("ender_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> STEEL_DUST = RegistryHandler.ITEMS.register("steel_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> COPPER_DUST = RegistryHandler.ITEMS.register("copper_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> BRONZE_DUST = RegistryHandler.ITEMS.register("bronze_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> IRON_DUST = RegistryHandler.ITEMS.register("iron_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> GOLD_DUST = RegistryHandler.ITEMS.register("gold_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> DIAMOND_DUST = RegistryHandler.ITEMS.register("diamond_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> EMERALD_DUST = RegistryHandler.ITEMS.register("emerald_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> SILVER_DUST = RegistryHandler.ITEMS.register("silver_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> OBSIDIAN_DUST = RegistryHandler.ITEMS.register("obsidian_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> RUBY_DUST = RegistryHandler.ITEMS.register("ruby_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> SAPPHIRE_DUST = RegistryHandler.ITEMS.register("sapphire_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> RUBONIUM_DUST = RegistryHandler.ITEMS.register("rubonium_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> EMERONIUM_DUST = RegistryHandler.ITEMS.register("emeronium_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> SAPHONIUM_DUST = RegistryHandler.ITEMS.register("saphonium_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> ENDONIUM_DUST = RegistryHandler.ITEMS.register("endonium_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> OBSIDIUM_DUST = RegistryHandler.ITEMS.register("obsidium_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> DIAMONIUM_CRYSTAL_DUST = RegistryHandler.ITEMS.register("diamonium_crystal_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> ENDONIUM_CRYSTAL_DUST = RegistryHandler.ITEMS.register("endonium_crystal_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> GOLD_INFUSED_IRON_DUST = RegistryHandler.ITEMS.register("gold_infused_iron_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> LEAD_DUST = RegistryHandler.ITEMS.register("lead_dust", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    //DIRTY CHUNKS(doubling)
    public static final RegistryObject<Item> TIN_DIRTY_CHUNKS = RegistryHandler.ITEMS.register("tin_dirty_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> COPPER_DIRTY_CHUNKS = RegistryHandler.ITEMS.register("copper_dirty_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> SILVER_DIRTY_CHUNKS = RegistryHandler.ITEMS.register("silver_dirty_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> IRON_DIRTY_CHUNKS = RegistryHandler.ITEMS.register("iron_dirty_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> GOLD_DIRTY_CHUNKS = RegistryHandler.ITEMS.register("gold_dirty_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> LEAD_DIRTY_CHUNKS = RegistryHandler.ITEMS.register("lead_dirty_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    //REFINED CHUNKS(tripling)
    public static final RegistryObject<Item> TIN_REFINED_CHUNKS = RegistryHandler.ITEMS.register("tin_refined_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> COPPER_REFINED_CHUNKS = RegistryHandler.ITEMS.register("copper_refined_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> SILVER_REFINED_CHUNKS = RegistryHandler.ITEMS.register("silver_refined_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> IRON_REFINED_CHUNKS = RegistryHandler.ITEMS.register("iron_refined_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> GOLD_REFINED_CHUNKS = RegistryHandler.ITEMS.register("gold_refined_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> LEAD_REFINED_CHUNKS = RegistryHandler.ITEMS.register("lead_refined_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    //PURE CHUNKS(quadrupling)
    public static final RegistryObject<Item> TIN_PURE_CHUNKS = RegistryHandler.ITEMS.register("tin_pure_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> COPPER_PURE_CHUNKS = RegistryHandler.ITEMS.register("copper_pure_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> SILVER_PURE_CHUNKS = RegistryHandler.ITEMS.register("silver_pure_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> GOLD_PURE_CHUNKS = RegistryHandler.ITEMS.register("gold_pure_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> IRON_PURE_CHUNKS = RegistryHandler.ITEMS.register("iron_pure_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> LEAD_PURE_CHUNKS = RegistryHandler.ITEMS.register("lead_pure_chunks", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    //BUCKETS
    public static final RegistryObject<Item> GOLD_ORE_SLURRY_BUCKET = RegistryHandler.ITEMS.register("gold_ore_slurry_bucket", () -> 
    	new BucketItem(() -> ModFluids.GOLD_ORE_SLURRY_FLUID.get(), new Item.Properties().stacksTo(1).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> IRON_ORE_SLURRY_BUCKET = RegistryHandler.ITEMS.register("iron_ore_slurry_bucket", () -> 
	new BucketItem(() -> ModFluids.IRON_ORE_SLURRY_FLUID.get(), new Item.Properties().stacksTo(1).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> COPPER_ORE_SLURRY_BUCKET = RegistryHandler.ITEMS.register("copper_ore_slurry_bucket", () -> 
	new BucketItem(() -> ModFluids.COPPER_ORE_SLURRY_FLUID.get(), new Item.Properties().stacksTo(1).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> SILVER_ORE_SLURRY_BUCKET = RegistryHandler.ITEMS.register("silver_ore_slurry_bucket", () -> 
	new BucketItem(() -> ModFluids.SILVER_ORE_SLURRY_FLUID.get(), new Item.Properties().stacksTo(1).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> TIN_ORE_SLURRY_BUCKET = RegistryHandler.ITEMS.register("tin_ore_slurry_bucket", () -> 
	new BucketItem(() -> ModFluids.TIN_ORE_SLURRY_FLUID.get(), new Item.Properties().stacksTo(1).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> LEAD_ORE_SLURRY_BUCKET = RegistryHandler.ITEMS.register("lead_ore_slurry_bucket", () -> 
	new BucketItem(() -> ModFluids.LEAD_ORE_SLURRY_FLUID.get(), new Item.Properties().stacksTo(1).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> LIQUID_SLAG_BUCKET = RegistryHandler.ITEMS.register("liquid_slag_bucket", () -> 
	new BucketItem(() -> ModFluids.LIQUID_SLAG_FLUID.get(), new Item.Properties().stacksTo(1).tab(TabGroups.MOD_ITEM_GROUP)));
    
    //GEARS
    public static final RegistryObject<Item> DIAMONIUM_GEAR = RegistryHandler.ITEMS.register("diamonium_gear", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> EMERONIUM_GEAR = RegistryHandler.ITEMS.register("emeronium_gear", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> ENDONIUM_GEAR = RegistryHandler.ITEMS.register("endonium_gear", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> GOLD_INFUSED_IRON_GEAR = RegistryHandler.ITEMS.register("gold_infused_iron_gear", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> OBSIDIUM_GEAR = RegistryHandler.ITEMS.register("obsidium_gear", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> RUBONIUM_GEAR = RegistryHandler.ITEMS.register("rubonium_gear", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> SAPHONIUM_GEAR = RegistryHandler.ITEMS.register("saphonium_gear", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> WOODEN_GEAR = RegistryHandler.ITEMS.register("wooden_gear", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> STONE_GEAR = RegistryHandler.ITEMS.register("stone_gear", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> IRON_GEAR = RegistryHandler.ITEMS.register("iron_gear", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)));
    
    //UPGRADES
    public static final RegistryObject<Item> CAPACITY_UPGRADE = RegistryHandler.ITEMS.register("capacity_upgrade", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)) {
            @Override
            @OnlyIn(Dist.CLIENT)
            public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag tooltipFlag) {
            	
            	if(Screen.hasShiftDown()) {
            		
            		tooltip.add(new TranslationTextComponent("com.github.will11690.mechanicraft.capacity_upgrade.modifier"));
            		
            	} else
            	
            	tooltip.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"));
            	
            }
        });
    
    public static final RegistryObject<Item> EFFICIENCY_UPGRADE = RegistryHandler.ITEMS.register("efficiency_upgrade", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)) {
            @Override
            @OnlyIn(Dist.CLIENT)
            public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag tooltipFlag) {
            	
            	if(Screen.hasShiftDown()) {
            		
            		tooltip.add(new TranslationTextComponent("com.github.will11690.mechanicraft.efficiency_upgrade.modifier"));
            		tooltip.add(new TranslationTextComponent("com.github.will11690.mechanicraft.efficiency_upgrade.cost"));
            		
            	} else
            	
            	tooltip.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"));
            	
            }
        });
    
    public static final RegistryObject<Item> SPEED_UPGRADE = RegistryHandler.ITEMS.register("speed_upgrade", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)) {
            @Override
            @OnlyIn(Dist.CLIENT)
            public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag tooltipFlag) {
            	
            	if(Screen.hasShiftDown()) {
            		
            		tooltip.add(new TranslationTextComponent("com.github.will11690.mechanicraft.speed_upgrade.modifier"));
            		tooltip.add(new TranslationTextComponent("com.github.will11690.mechanicraft.speed_upgrade.cost"));
            		
            	} else
            	
            	tooltip.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"));
            	
            }
        });
    
    public static final RegistryObject<Item> TRANSFER_UPGRADE = RegistryHandler.ITEMS.register("transfer_upgrade", () ->
		new Item(new Item.Properties().tab(TabGroups.MOD_ITEM_GROUP)) {
            @Override
            @OnlyIn(Dist.CLIENT)
            public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag tooltipFlag) {
            	
            	if(Screen.hasShiftDown()) {
            		
            		tooltip.add(new TranslationTextComponent("com.github.will11690.mechanicraft.transfer_upgrade.modifier"));
            		
            	} else
            	
            	tooltip.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"));
            	
            }
        });
    
    public static final RegistryObject<Item> CREATIVE_UPGRADE = RegistryHandler.ITEMS.register("creative_upgrade", () ->
		new Item(new Item.Properties().stacksTo(1).tab(TabGroups.MOD_ITEM_GROUP)) {
            @Override
            @OnlyIn(Dist.CLIENT)
            public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag tooltipFlag) {
            	
            	if(Screen.hasShiftDown()) {
            		
            		tooltip.add(new TranslationTextComponent("com.github.will11690.mechanicraft.creative_upgrade.modifier"));
            		
            	} else
            	
            	tooltip.add(new TranslationTextComponent("com.github.will11690.mechanicraft.screen.gui_details"));
            	
            }
        });
    
    //Press Dies
    public static final RegistryObject<Item> GEAR_PRESS_DIE = RegistryHandler.ITEMS.register("gear_press_die", () ->
		new Item(new Item.Properties().stacksTo(1).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> PLATE_PRESS_DIE = RegistryHandler.ITEMS.register("plate_press_die", () ->
		new Item(new Item.Properties().stacksTo(1).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> ROD_PRESS_DIE = RegistryHandler.ITEMS.register("rod_press_die", () ->
		new Item(new Item.Properties().stacksTo(1).tab(TabGroups.MOD_ITEM_GROUP)));
    
    //TOOLS
    public static final RegistryObject<Item> EMERONIUM_SWORD = RegistryHandler.ITEMS.register("emeronium_sword",
            () -> new SwordItem(MechanicraftToolTiers.EMERONIUM, 3, -2.4F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> EMERONIUM_PICKAXE = RegistryHandler.ITEMS.register("emeronium_pickaxe",
            () -> new PickaxeItem(MechanicraftToolTiers.EMERONIUM, 1, -2.8F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> EMERONIUM_SHOVEL = RegistryHandler.ITEMS.register("emeronium_shovel",
            () -> new ShovelItem(MechanicraftToolTiers.EMERONIUM, 1.5F, -3.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> EMERONIUM_AXE = RegistryHandler.ITEMS.register("emeronium_axe",
            () -> new AxeItem(MechanicraftToolTiers.EMERONIUM, 5.0F, -3.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> EMERONIUM_HOE = RegistryHandler.ITEMS.register("emeronium_hoe",
            () -> new HoeItem(MechanicraftToolTiers.EMERONIUM, -3, 0.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));
    
    public static final RegistryObject<Item> RUBONIUM_SWORD = RegistryHandler.ITEMS.register("rubonium_sword",
            () -> new SwordItem(MechanicraftToolTiers.RUBONIUM, 3, -2.4F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> RUBONIUM_PICKAXE = RegistryHandler.ITEMS.register("rubonium_pickaxe",
            () -> new PickaxeItem(MechanicraftToolTiers.RUBONIUM, 1, -2.8F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> RUBONIUM_SHOVEL = RegistryHandler.ITEMS.register("rubonium_shovel",
            () -> new ShovelItem(MechanicraftToolTiers.RUBONIUM, 1.5F, -3.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> RUBONIUM_AXE = RegistryHandler.ITEMS.register("rubonium_axe",
            () -> new AxeItem(MechanicraftToolTiers.RUBONIUM, 5.0F, -3.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> RUBONIUM_HOE = RegistryHandler.ITEMS.register("rubonium_hoe",
            () -> new HoeItem(MechanicraftToolTiers.RUBONIUM, -3, 0.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));
    
    public static final RegistryObject<Item> SAPHONIUM_SWORD = RegistryHandler.ITEMS.register("saphonium_sword",
            () -> new SwordItem(MechanicraftToolTiers.SAPHONIUM, 3, -2.4F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> SAPHONIUM_PICKAXE = RegistryHandler.ITEMS.register("saphonium_pickaxe",
            () -> new PickaxeItem(MechanicraftToolTiers.SAPHONIUM, 1, -2.8F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> SAPHONIUM_SHOVEL = RegistryHandler.ITEMS.register("saphonium_shovel",
            () -> new ShovelItem(MechanicraftToolTiers.SAPHONIUM, 1.5F, -3.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> SAPHONIUM_AXE = RegistryHandler.ITEMS.register("saphonium_axe",
            () -> new AxeItem(MechanicraftToolTiers.SAPHONIUM, 5.0F, -3.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> SAPHONIUM_HOE = RegistryHandler.ITEMS.register("saphonium_hoe",
            () -> new HoeItem(MechanicraftToolTiers.SAPHONIUM, -3, 0.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));
    
    public static final RegistryObject<Item> OBSIDIUM_SWORD = RegistryHandler.ITEMS.register("obsidium_sword",
            () -> new SwordItem(MechanicraftToolTiers.OBSIDIUM, 3, -2.4F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP).fireResistant()));

    public static final RegistryObject<Item> OBSIDIUM_PICKAXE = RegistryHandler.ITEMS.register("obsidium_pickaxe",
            () -> new PickaxeItem(MechanicraftToolTiers.OBSIDIUM, 1, -2.8F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP).fireResistant()));

    public static final RegistryObject<Item> OBSIDIUM_SHOVEL = RegistryHandler.ITEMS.register("obsidium_shovel",
            () -> new ShovelItem(MechanicraftToolTiers.OBSIDIUM, 1.5F, -3.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP).fireResistant()));

    public static final RegistryObject<Item> OBSIDIUM_AXE = RegistryHandler.ITEMS.register("obsidium_axe",
            () -> new AxeItem(MechanicraftToolTiers.OBSIDIUM, 5.0F, -3.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP).fireResistant()));

    public static final RegistryObject<Item> OBSIDIUM_HOE = RegistryHandler.ITEMS.register("obsidium_hoe",
            () -> new HoeItem(MechanicraftToolTiers.OBSIDIUM, -3, 0.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP).fireResistant()));
    
    public static final RegistryObject<Item> ENDONIUM_SWORD = RegistryHandler.ITEMS.register("endonium_sword",
            () -> new SwordItem(MechanicraftToolTiers.ENDONIUM, 3, -2.4F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> ENDONIUM_PICKAXE = RegistryHandler.ITEMS.register("endonium_pickaxe",
            () -> new PickaxeItem(MechanicraftToolTiers.ENDONIUM, 1, -2.8F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> ENDONIUM_SHOVEL = RegistryHandler.ITEMS.register("endonium_shovel",
            () -> new ShovelItem(MechanicraftToolTiers.ENDONIUM, 1.5F, -3.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> ENDONIUM_AXE = RegistryHandler.ITEMS.register("endonium_axe",
            () -> new AxeItem(MechanicraftToolTiers.ENDONIUM, 5.0F, -3.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> ENDONIUM_HOE = RegistryHandler.ITEMS.register("endonium_hoe",
            () -> new HoeItem(MechanicraftToolTiers.ENDONIUM, -3, 0.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));
    
    public static final RegistryObject<Item> ENDONIUM_CRYSTAL_SWORD = RegistryHandler.ITEMS.register("endonium_crystal_sword",
            () -> new SwordItem(MechanicraftToolTiers.ENDONIUM_CRYSTAL, 3, -2.4F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP).fireResistant()));

    public static final RegistryObject<Item> ENDONIUM_CRYSTAL_PICKAXE = RegistryHandler.ITEMS.register("endonium_crystal_pickaxe",
            () -> new PickaxeItem(MechanicraftToolTiers.ENDONIUM_CRYSTAL, 1, -2.8F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP).fireResistant()));

    public static final RegistryObject<Item> ENDONIUM_CRYSTAL_SHOVEL = RegistryHandler.ITEMS.register("endonium_crystal_shovel",
            () -> new ShovelItem(MechanicraftToolTiers.ENDONIUM_CRYSTAL, 1.5F, -3.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP).fireResistant()));

    public static final RegistryObject<Item> ENDONIUM_CRYSTAL_AXE = RegistryHandler.ITEMS.register("endonium_crystal_axe",
            () -> new AxeItem(MechanicraftToolTiers.ENDONIUM_CRYSTAL, 5.0F, -3.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP).fireResistant()));

    public static final RegistryObject<Item> ENDONIUM_CRYSTAL_HOE = RegistryHandler.ITEMS.register("endonium_crystal_hoe",
            () -> new HoeItem(MechanicraftToolTiers.ENDONIUM_CRYSTAL, -3, 0.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP).fireResistant()));
    
    public static final RegistryObject<Item> GLASS_SWORD = RegistryHandler.ITEMS.register("glass_sword",
            () -> new SwordItem(MechanicraftToolTiers.GLASS, 3, -2.4F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> GLASS_PICKAXE = RegistryHandler.ITEMS.register("glass_pickaxe",
            () -> new PickaxeItem(MechanicraftToolTiers.GLASS, 1, -2.8F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> GLASS_SHOVEL = RegistryHandler.ITEMS.register("glass_shovel",
            () -> new ShovelItem(MechanicraftToolTiers.GLASS, 1.5F, -3.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> GLASS_AXE = RegistryHandler.ITEMS.register("glass_axe",
            () -> new AxeItem(MechanicraftToolTiers.GLASS, 5.0F, -3.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));

    public static final RegistryObject<Item> GLASS_HOE = RegistryHandler.ITEMS.register("glass_hoe",
            () -> new HoeItem(MechanicraftToolTiers.GLASS, -3, 0.0F,
                    new Item.Properties().tab(TabGroups.MOD_TOOL_GROUP)));
    
    //ARMOR
    public static final RegistryObject<Item> EMERONIUM_BOOTS = RegistryHandler.ITEMS.register("emeronium_boots",
            () -> new EMArmorBase(MechanicraftArmorTiers.EMERONIUM, EquipmentSlotType.FEET,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));

    public static final RegistryObject<Item> EMERONIUM_CHESTPLATE = RegistryHandler.ITEMS.register("emeronium_chestplate",
            () -> new EMArmorBase(MechanicraftArmorTiers.EMERONIUM, EquipmentSlotType.CHEST,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));

    public static final RegistryObject<Item> EMERONIUM_LEGGINGS = RegistryHandler.ITEMS.register("emeronium_leggings",
            () -> new EMArmorBase(MechanicraftArmorTiers.EMERONIUM, EquipmentSlotType.LEGS,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));

    public static final RegistryObject<Item> EMERONIUM_HELMET = RegistryHandler.ITEMS.register("emeronium_helmet",
            () -> new EMArmorBase(MechanicraftArmorTiers.EMERONIUM, EquipmentSlotType.HEAD,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));
    
    public static final RegistryObject<Item> ENDONIUM_BOOTS = RegistryHandler.ITEMS.register("endonium_boots",
            () -> new EArmorBase(MechanicraftArmorTiers.ENDONIUM, EquipmentSlotType.FEET,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));

    public static final RegistryObject<Item> ENDONIUM_CHESTPLATE = RegistryHandler.ITEMS.register("endonium_chestplate",
            () -> new EArmorBase(MechanicraftArmorTiers.ENDONIUM, EquipmentSlotType.CHEST,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));

    public static final RegistryObject<Item> ENDONIUM_LEGGINGS = RegistryHandler.ITEMS.register("endonium_leggings",
            () -> new EArmorBase(MechanicraftArmorTiers.ENDONIUM, EquipmentSlotType.LEGS,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));

    public static final RegistryObject<Item> ENDONIUM_HELMET = RegistryHandler.ITEMS.register("endonium_helmet",
            () -> new EArmorBase(MechanicraftArmorTiers.ENDONIUM, EquipmentSlotType.HEAD,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));
    
    public static final RegistryObject<Item> ENDONIUM_CRYSTAL_BOOTS = RegistryHandler.ITEMS.register("endonium_crystal_boots",
            () -> new ECArmorBase(MechanicraftArmorTiers.ENDONIUM_CRYSTAL, EquipmentSlotType.FEET,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP).fireResistant()));

    public static final RegistryObject<Item> ENDONIUM_CRYSTAL_CHESTPLATE = RegistryHandler.ITEMS.register("endonium_crystal_chestplate",
            () -> new ECArmorBase(MechanicraftArmorTiers.ENDONIUM_CRYSTAL, EquipmentSlotType.CHEST,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP).fireResistant()));

    public static final RegistryObject<Item> ENDONIUM_CRYSTAL_LEGGINGS = RegistryHandler.ITEMS.register("endonium_crystal_leggings",
            () -> new ECArmorBase(MechanicraftArmorTiers.ENDONIUM_CRYSTAL, EquipmentSlotType.LEGS,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP).fireResistant()));

    public static final RegistryObject<Item> ENDONIUM_CRYSTAL_HELMET = RegistryHandler.ITEMS.register("endonium_crystal_helmet",
            () -> new ECArmorBase(MechanicraftArmorTiers.ENDONIUM_CRYSTAL, EquipmentSlotType.HEAD,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP).fireResistant()));
    
    public static final RegistryObject<Item> SAPHONIUM_BOOTS = RegistryHandler.ITEMS.register("saphonium_boots",
            () -> new SArmorBase(MechanicraftArmorTiers.SAPHONIUM, EquipmentSlotType.FEET,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));

    public static final RegistryObject<Item> SAPHONIUM_CHESTPLATE = RegistryHandler.ITEMS.register("saphonium_chestplate",
            () -> new SArmorBase(MechanicraftArmorTiers.SAPHONIUM, EquipmentSlotType.CHEST,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));

    public static final RegistryObject<Item> SAPHONIUM_LEGGINGS = RegistryHandler.ITEMS.register("saphonium_leggings",
            () -> new SArmorBase(MechanicraftArmorTiers.SAPHONIUM, EquipmentSlotType.LEGS,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));

    public static final RegistryObject<Item> SAPHONIUM_HELMET = RegistryHandler.ITEMS.register("saphonium_helmet",
            () -> new SArmorBase(MechanicraftArmorTiers.SAPHONIUM, EquipmentSlotType.HEAD,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));
    
    public static final RegistryObject<Item> RUBONIUM_BOOTS = RegistryHandler.ITEMS.register("rubonium_boots",
            () -> new RArmorBase(MechanicraftArmorTiers.RUBONIUM, EquipmentSlotType.FEET,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));

    public static final RegistryObject<Item> RUBONIUM_CHESTPLATE = RegistryHandler.ITEMS.register("rubonium_chestplate",
            () -> new RArmorBase(MechanicraftArmorTiers.RUBONIUM, EquipmentSlotType.CHEST,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));

    public static final RegistryObject<Item> RUBONIUM_LEGGINGS = RegistryHandler.ITEMS.register("rubonium_leggings",
            () -> new RArmorBase(MechanicraftArmorTiers.RUBONIUM, EquipmentSlotType.LEGS,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));

    public static final RegistryObject<Item> RUBONIUM_HELMET = RegistryHandler.ITEMS.register("rubonium_helmet",
            () -> new RArmorBase(MechanicraftArmorTiers.RUBONIUM, EquipmentSlotType.HEAD,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));
    
    public static final RegistryObject<Item> OBSIDIUM_BOOTS = RegistryHandler.ITEMS.register("obsidium_boots",
            () -> new OArmorBase(MechanicraftArmorTiers.OBSIDIUM, EquipmentSlotType.FEET,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP).fireResistant()));

    public static final RegistryObject<Item> OBSIDIUM_CHESTPLATE = RegistryHandler.ITEMS.register("obsidium_chestplate",
            () -> new OArmorBase(MechanicraftArmorTiers.OBSIDIUM, EquipmentSlotType.CHEST,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP).fireResistant()));

    public static final RegistryObject<Item> OBSIDIUM_LEGGINGS = RegistryHandler.ITEMS.register("obsidium_leggings",
            () -> new OArmorBase(MechanicraftArmorTiers.OBSIDIUM, EquipmentSlotType.LEGS,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP).fireResistant()));

    public static final RegistryObject<Item> OBSIDIUM_HELMET = RegistryHandler.ITEMS.register("obsidium_helmet",
            () -> new OArmorBase(MechanicraftArmorTiers.OBSIDIUM, EquipmentSlotType.HEAD,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP).fireResistant()));
    
    public static final RegistryObject<Item> GLASS_BOOTS = RegistryHandler.ITEMS.register("glass_boots",
            () -> new GArmorBase(MechanicraftArmorTiers.GLASS, EquipmentSlotType.FEET,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));

    public static final RegistryObject<Item> GLASS_CHESTPLATE = RegistryHandler.ITEMS.register("glass_chestplate",
            () -> new GArmorBase(MechanicraftArmorTiers.GLASS, EquipmentSlotType.CHEST,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));

    public static final RegistryObject<Item> GLASS_LEGGINGS = RegistryHandler.ITEMS.register("glass_leggings",
            () -> new GArmorBase(MechanicraftArmorTiers.GLASS, EquipmentSlotType.LEGS,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));

    public static final RegistryObject<Item> GLASS_HELMET = RegistryHandler.ITEMS.register("glass_helmet",
            () -> new GArmorBase(MechanicraftArmorTiers.GLASS, EquipmentSlotType.HEAD,
                    new Item.Properties().tab(TabGroups.MOD_ARMOR_GROUP)));
    
    //MESH
    public static final RegistryObject<Item> STRING_MESH = RegistryHandler.ITEMS.register("string_mesh", () ->
		new Item(new Item.Properties().durability(ModConfigs.stringMeshDurabilityInt).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> REINFORCED_STRING_MESH = RegistryHandler.ITEMS.register("reinforced_string_mesh", () ->
		new Item(new Item.Properties().durability(ModConfigs.reinforcedStringMeshDurabilityInt).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> IRON_MESH = RegistryHandler.ITEMS.register("iron_mesh", () ->
		new Item(new Item.Properties().durability(ModConfigs.ironMeshDurabilityInt).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> REINFORCED_IRON_MESH = RegistryHandler.ITEMS.register("reinforced_iron_mesh", () ->
		new Item(new Item.Properties().durability(ModConfigs.reinforcedIronMeshDurabilityInt).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> STEEL_MESH = RegistryHandler.ITEMS.register("steel_mesh", () ->
		new Item(new Item.Properties().durability(ModConfigs.steelMeshDurabilityInt).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> REINFORCED_STEEL_MESH = RegistryHandler.ITEMS.register("reinforced_steel_mesh", () ->
		new Item(new Item.Properties().durability(ModConfigs.reinforcedSteelMeshDurabilityInt).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> DIAMOND_MESH = RegistryHandler.ITEMS.register("diamond_mesh", () ->
		new Item(new Item.Properties().durability(ModConfigs.diamondMeshDurabilityInt).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> REINFORCED_DIAMOND_MESH = RegistryHandler.ITEMS.register("reinforced_diamond_mesh", () ->
		new Item(new Item.Properties().durability(ModConfigs.reinforcedDiamondMeshDurabilityInt).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> GEM_MESH = RegistryHandler.ITEMS.register("gem_mesh", () ->
		new Item(new Item.Properties().durability(ModConfigs.gemMeshDurabilityInt).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> REINFORCED_GEM_MESH = RegistryHandler.ITEMS.register("reinforced_gem_mesh", () ->
		new Item(new Item.Properties().durability(ModConfigs.reinforcedGemMeshDurabilityInt).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> ENDONIUM_MESH = RegistryHandler.ITEMS.register("endonium_mesh", () ->
		new Item(new Item.Properties().durability(ModConfigs.endoniumMeshDurabilityInt).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> REINFORCED_ENDONIUM_MESH = RegistryHandler.ITEMS.register("reinforced_endonium_mesh", () ->
		new Item(new Item.Properties().durability(ModConfigs.reinforcedEndoniumMeshDurabilityInt).tab(TabGroups.MOD_ITEM_GROUP)));
    
    public static void register() {}
    
}