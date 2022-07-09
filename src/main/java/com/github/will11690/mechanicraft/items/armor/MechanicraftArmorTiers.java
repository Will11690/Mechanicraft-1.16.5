package com.github.will11690.mechanicraft.items.armor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

import com.github.will11690.mechanicraft.init.ModItems;
import com.github.will11690.mechanicraft.util.Reference;

public enum MechanicraftArmorTiers implements IArmorMaterial {

    EMERONIUM("emeronium", 30, new int[] { 3, 6, 8, 3 }, 14, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.5f, () -> {
        return Ingredient.of(ModItems.EMERONIUM_INGOT.get());}),
	
	ENDONIUM("endonium", 37, new int[] { 4, 7, 9, 4 }, 16, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 1.0f, () -> {
        return Ingredient.of(ModItems.ENDONIUM_INGOT.get());}),
	
	ENDONIUM_CRYSTAL("endonium_crystal", 40, new int[] { 5, 8, 10, 5 }, 16, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0f, 1.0f, () -> {
        return Ingredient.of(ModItems.ENDONIUM_CRYSTAL.get());}),
	
	SAPHONIUM("saphonium", 30, new int[] { 3, 6, 8, 3 }, 14, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.5f, () -> {
        return Ingredient.of(ModItems.SAPHONIUM_INGOT.get());}),
	
	RUBONIUM("rubonium", 30, new int[] { 3, 6, 8, 3 }, 14, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.5f, () -> {
        return Ingredient.of(ModItems.RUBONIUM_INGOT.get());}),
	
	OBSIDIUM("obsidium", 30, new int[] { 3, 6, 8, 3 }, 12, SoundEvents.ARMOR_EQUIP_IRON, 3.0f, 0.8f, () -> {
        return Ingredient.of(ModItems.OBSIDIUM_INGOT.get());}),
	
	GLASS("glass", 2, new int[] { 1, 6, 4, 1 }, 5, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f, () -> {
        return Ingredient.of(Items.GLASS);});

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairMaterial;

    private MechanicraftArmorTiers(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability,
                             SoundEvent soundEvent, float toughness, float knockbackResistance,
                             Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }


	@Override
	public int getDurabilityForSlot(EquipmentSlotType p_200896_1_) {

		return MAX_DAMAGE_ARRAY[p_200896_1_.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlotType p_200902_1_) {

		return this.damageReductionAmountArray[p_200902_1_.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {

		return this.enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {

		return this.soundEvent;
	}

	@Override
	public Ingredient getRepairIngredient() {

		return this.repairMaterial.get();
	}

    @OnlyIn(Dist.CLIENT)
    public String getName() {
    	
        return Reference.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
    	
        return this.toughness;
    }

    public float getKnockbackResistance() {
    	
        return this.knockbackResistance;
    }
}