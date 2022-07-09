package com.github.will11690.mechanicraft.items.armor;

import com.github.will11690.mechanicraft.init.ModItems;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class SArmorBase extends ArmorItem {

    public SArmorBase(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
    	
        super(materialIn, slot, builder);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
    	
        if(player.getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.SAPHONIUM_HELMET.get() &&
           player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.SAPHONIUM_CHESTPLATE.get() &&
           player.getItemBySlot(EquipmentSlotType.LEGS).getItem() == ModItems.SAPHONIUM_LEGGINGS.get() &&
           player.getItemBySlot(EquipmentSlotType.FEET).getItem() == ModItems.SAPHONIUM_BOOTS.get()) {
        	
        	player.addEffect(new EffectInstance(Effects.WATER_BREATHING, 300, 0, false, false, false));
        }
        
        else {
        		
        	player.removeEffect(Effects.WATER_BREATHING);
        }
    }
}