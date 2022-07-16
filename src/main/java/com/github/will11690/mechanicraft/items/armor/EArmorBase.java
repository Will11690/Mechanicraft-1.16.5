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
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class EArmorBase extends ArmorItem {

    public EArmorBase(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
    	
        super(materialIn, slot, builder);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
    	
        if(ModConfigs.armorEffectsBool == true && player.getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.ENDONIUM_HELMET.get() &&
           player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.ENDONIUM_CHESTPLATE.get() &&
           player.getItemBySlot(EquipmentSlotType.LEGS).getItem() == ModItems.ENDONIUM_LEGGINGS.get() &&
           player.getItemBySlot(EquipmentSlotType.FEET).getItem() == ModItems.ENDONIUM_BOOTS.get()) {
        	
        	if(ModConfigs.endoniumArmorHealthEffectBool == true && player.getAttribute(Attributes.MAX_HEALTH).getValue() < 30.0D) {
        		
        		player.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(new AttributeModifier("MaxHealth", 10.0D, AttributeModifier.Operation.ADDITION));
        	}
        	
        	if(ModConfigs.endoniumArmorSpeedEffectBool == true) {
        		
        		player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 300, 2, false, false, false));
        	}
        	
        	if(ModConfigs.endoniumArmorHeroEffectBool == true) {
        		
        		player.addEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 300, 0, false, false, false));
        	}
        	
        	if(ModConfigs.endoniumArmorFireEffectBool == true) {
        		
        		player.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 300, 0, false, false, false));
        	}
        	
			if(ModConfigs.endoniumArmorWaterEffectBool == true) {
				
				player.addEffect(new EffectInstance(Effects.WATER_BREATHING, 300, 0, false, false, false));
        	}
			
			if(ModConfigs.endoniumArmorVisionEffectBool == true) {
				
				player.addEffect(new EffectInstance(Effects.NIGHT_VISION, 300, 0, false, false, false));
        	}
			
        } else {
        	
        	if(ModConfigs.endoniumArmorHealthEffectBool == true && player.getAttribute(Attributes.MAX_HEALTH).getValue() > 20.0D) {
        		
        		player.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(new AttributeModifier("MaxHealth", -10.0D, AttributeModifier.Operation.ADDITION));
        	}
        	
        	if(ModConfigs.endoniumArmorSpeedEffectBool == true) {
        		
        		player.removeEffect(Effects.MOVEMENT_SPEED);
        	}
        	
        	if(ModConfigs.endoniumArmorHeroEffectBool == true) {
        		
        		player.removeEffect(Effects.HERO_OF_THE_VILLAGE);
        	}
        	
        	if(ModConfigs.endoniumArmorFireEffectBool == true) {
        		
        		player.removeEffect(Effects.FIRE_RESISTANCE);
        	}
        	
        	if(ModConfigs.endoniumArmorWaterEffectBool == true) {
        		
        		player.removeEffect(Effects.WATER_BREATHING);
        	}
        	
        	if(ModConfigs.endoniumArmorVisionEffectBool == true) {
        		
        		player.removeEffect(Effects.NIGHT_VISION);
        	}
        }
    }
}