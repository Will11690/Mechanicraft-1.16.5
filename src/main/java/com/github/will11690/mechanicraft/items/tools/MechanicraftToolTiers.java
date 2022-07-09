package com.github.will11690.mechanicraft.items.tools;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.item.Items;

import com.github.will11690.mechanicraft.init.ModItems;

public enum MechanicraftToolTiers implements IItemTier {

	EMERONIUM(2, 1400, 8.5F, 8.0F, 14, () -> Ingredient.of(ModItems.EMERONIUM_INGOT.get())),
	ENDONIUM(2, 1800, 9.0F, 9.0F, 16, () -> Ingredient.of(ModItems.ENDONIUM_INGOT.get())),
	ENDONIUM_CRYSTAL(3, 2200, 10.0F, 10.0F, 16, () -> Ingredient.of(ModItems.ENDONIUM_CRYSTAL.get())),
	GLASS(1, 80, 6.0F, 10.0F, 5, () -> Ingredient.of(Items.GLASS)),
	OBSIDIUM(4, 1600, 6.0F, 9.0F, 12, () -> Ingredient.of(ModItems.OBSIDIUM_INGOT.get())),
	RUBONIUM(2, 1400, 8.5F, 8.0F, 14, () -> Ingredient.of(ModItems.RUBONIUM_INGOT.get())),
	SAPHONIUM(2, 1400, 8.5F, 8.0F, 14, () -> Ingredient.of(ModItems.SAPHONIUM_INGOT.get()));

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    MechanicraftToolTiers(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        
    	this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
        
    }

	@Override
	public int getUses() {

		return maxUses;
		
	}

	@Override
	public float getSpeed() {

		return efficiency;
		
	}

	@Override
	public float getAttackDamageBonus() {

		return attackDamage;
		
	}

	@Override
	public int getLevel() {

		return harvestLevel;
		
	}

	@Override
	public int getEnchantmentValue() {

		return enchantability;
		
	}

	@Override
	public Ingredient getRepairIngredient() {

		return repairMaterial.get();
		
	}
	
}