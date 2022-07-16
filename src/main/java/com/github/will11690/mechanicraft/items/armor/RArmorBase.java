package com.github.will11690.mechanicraft.items.armor;

import com.github.will11690.mechanicraft.init.ModConfigs;
import com.github.will11690.mechanicraft.init.ModItems;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RArmorBase extends ArmorItem {

    public RArmorBase(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
    	
        super(materialIn, slot, builder);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
    	
        if(ModConfigs.armorEffectsBool == true && player.getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.RUBONIUM_HELMET.get() &&
           player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.RUBONIUM_CHESTPLATE.get() &&
           player.getItemBySlot(EquipmentSlotType.LEGS).getItem() == ModItems.RUBONIUM_LEGGINGS.get() &&
           player.getItemBySlot(EquipmentSlotType.FEET).getItem() == ModItems.RUBONIUM_BOOTS.get()) {
        	
        	if(ModConfigs.ruboniumArmorHealthEffectBool == true && player.getAttribute(Attributes.MAX_HEALTH).getValue() < 30.0D) {
        		
        		player.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(new AttributeModifier("MaxHealth", 10.0D, AttributeModifier.Operation.ADDITION));
        	}
        	
        } else {
        	
        	if(ModConfigs.ruboniumArmorHealthEffectBool == true && player.getAttribute(Attributes.MAX_HEALTH).getValue() > 20.0D) {
        		
        		player.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(new AttributeModifier("MaxHealth", -20.0D, AttributeModifier.Operation.ADDITION));
        	}
        }
    }
}