package com.github.will11690.mechanicraft.items.armor;

import com.github.will11690.mechanicraft.init.ModItems;
import com.github.will11690.mechanicraft.util.handlers.RegistryHandler;

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

public class ECArmorBase extends ArmorItem {

    public ECArmorBase(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
    	
        super(materialIn, slot, builder);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
    	
        if(player.getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.ENDONIUM_CRYSTAL_HELMET.get() &&
           player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.ENDONIUM_CRYSTAL_CHESTPLATE.get() &&
           player.getItemBySlot(EquipmentSlotType.LEGS).getItem() == ModItems.ENDONIUM_CRYSTAL_LEGGINGS.get() &&
           player.getItemBySlot(EquipmentSlotType.FEET).getItem() == ModItems.ENDONIUM_CRYSTAL_BOOTS.get()) {
        	
        	if(player.getAttribute(Attributes.MAX_HEALTH).getValue() < 40.0D) {
        		
        		player.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(new AttributeModifier("MaxHealth", 20.0D, AttributeModifier.Operation.ADDITION));
        	}
        	
			player.addEffect(new EffectInstance(RegistryHandler.FLIGHT_EFFECT.get(), 300, 0, false, false, false));
        	player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 300, 2, false, false, false));
        	player.addEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 300, 0, false, false, false));
			player.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 300, 0, false, false, false));
			player.addEffect(new EffectInstance(Effects.WATER_BREATHING, 300, 0, false, false, false));
			player.addEffect(new EffectInstance(Effects.NIGHT_VISION, 300, 0, false, false, false));
        }
        
        else {
        	
        	if(player.getAttribute(Attributes.MAX_HEALTH).getValue() > 20.0D) {
        		
        		player.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(new AttributeModifier("MaxHealth", -20.0D, AttributeModifier.Operation.ADDITION));
        	}
        	
        	player.removeEffect(RegistryHandler.FLIGHT_EFFECT.get());
        	player.removeEffect(Effects.MOVEMENT_SPEED);
        	player.removeEffect(Effects.HERO_OF_THE_VILLAGE);
        	player.removeEffect(Effects.FIRE_RESISTANCE);
        	player.removeEffect(Effects.WATER_BREATHING);
        	player.removeEffect(Effects.NIGHT_VISION);
        }
    }
}