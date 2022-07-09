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

public class GArmorBase extends ArmorItem {

    public GArmorBase(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
    	
        super(materialIn, slot, builder);
        
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
    	
        if(player.getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.GLASS_HELMET.get() &&
           player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.GLASS_CHESTPLATE.get() &&
           player.getItemBySlot(EquipmentSlotType.LEGS).getItem() == ModItems.GLASS_LEGGINGS.get() &&
           player.getItemBySlot(EquipmentSlotType.FEET).getItem() == ModItems.GLASS_BOOTS.get()) {
        	
        	player.addEffect(new EffectInstance(Effects.DIG_SPEED, 300, 0, false, false, false));
        	player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 300, 1, false, false, false));
        }
        
        else {
        		
        	player.removeEffect(Effects.DIG_SPEED);
        	player.removeEffect(Effects.MOVEMENT_SPEED);
        }
    }
}