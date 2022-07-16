package com.github.will11690.mechanicraft.items.tools;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.item.Items;

import com.github.will11690.mechanicraft.init.ModConfigs;
import com.github.will11690.mechanicraft.init.ModItems;

public enum MechanicraftToolTiers implements IItemTier {

	EMERONIUM(/*harvest level*/ModConfigs.emeroniumHarvestLevelInt, /*durability*/ModConfigs.emeroniumToolsDurabilityInt, /*efficiency*/(float)ModConfigs.emeroniumToolsEfficiencyFloat, /*damage*/(float)ModConfigs.emeroniumToolsDamageFloat, /*enchantability*/ModConfigs.emeroniumToolsEnchantabilityInt, () -> Ingredient.of(ModItems.EMERONIUM_INGOT.get())),
	ENDONIUM(/*harvest level*/ModConfigs.endoniumHarvestLevelInt, /*durability*/ModConfigs.endoniumToolsDurabilityInt, /*efficiency*/(float)ModConfigs.endoniumToolsEfficiencyFloat, /*damage*/(float)ModConfigs.endoniumToolsDamageFloat, /*enchantability*/ModConfigs.endoniumToolsEnchantabilityInt, () -> Ingredient.of(ModItems.ENDONIUM_INGOT.get())),
	ENDONIUM_CRYSTAL(/*harvest level*/ModConfigs.endoniumCrystalHarvestLevelInt, /*durability*/ModConfigs.endoniumCrystalToolsDurabilityInt, /*efficiency*/(float)ModConfigs.endoniumCrystalToolsEfficiencyFloat, /*damage*/(float)ModConfigs.endoniumCrystalToolsDamageFloat, /*enchantability*/ModConfigs.endoniumCrystalToolsEnchantabilityInt, () -> Ingredient.of(ModItems.ENDONIUM_CRYSTAL.get())),
	GLASS(/*harvest level*/ModConfigs.glassHarvestLevelInt, /*durability*/ModConfigs.glassToolsDurabilityInt, /*efficiency*/(float)ModConfigs.glassToolsEfficiencyFloat, /*damage*/(float)ModConfigs.glassToolsDamageFloat, /*enchantability*/ModConfigs.glassToolsEnchantabilityInt, () -> Ingredient.of(Items.GLASS)),
	OBSIDIUM(/*harvest level*/ModConfigs.obsidiumHarvestLevelInt, /*durability*/ModConfigs.obsidiumToolsDurabilityInt,/*efficiency*/(float)ModConfigs.obsidiumToolsEfficiencyFloat, /*damage*/(float)ModConfigs.obsidiumToolsDamageFloat, /*enchantability*/ModConfigs.obsidiumToolsEnchantabilityInt, () -> Ingredient.of(ModItems.OBSIDIUM_INGOT.get())),
	RUBONIUM(/*harvest level*/ModConfigs.ruboniumHarvestLevelInt, /*durability*/ModConfigs.ruboniumToolsDurabilityInt, /*efficiency*/(float)ModConfigs.ruboniumToolsEfficiencyFloat, /*damage*/(float)ModConfigs.ruboniumToolsDamageFloat, /*enchantability*/ModConfigs.ruboniumToolsEnchantabilityInt, () -> Ingredient.of(ModItems.RUBONIUM_INGOT.get())),
	SAPHONIUM(/*harvest level*/ModConfigs.saphoniumHarvestLevelInt, /*durability*/ModConfigs.saphoniumToolsDurabilityInt, /*efficiency*/(float)ModConfigs.saphoniumToolsEfficiencyFloat, /*damage*/(float)ModConfigs.saphoniumToolsDamageFloat, /*enchantability*/ModConfigs.saphoniumToolsEnchantabilityInt, () -> Ingredient.of(ModItems.SAPHONIUM_INGOT.get()));

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