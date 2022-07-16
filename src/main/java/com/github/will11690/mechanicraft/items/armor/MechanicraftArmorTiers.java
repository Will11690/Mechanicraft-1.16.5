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

import com.github.will11690.mechanicraft.init.ModConfigs;
import com.github.will11690.mechanicraft.init.ModItems;
import com.github.will11690.mechanicraft.util.Reference;

public enum MechanicraftArmorTiers implements IArmorMaterial {

    EMERONIUM("emeronium", /*durability*/ModConfigs.emeroniumArmorDurabilityInt, new int[] { /*boots*/ModConfigs.emeroniumBootsProtectionInt, /*leggings*/ModConfigs.emeroniumLeggingsProtectionInt, /*chestplate*/ModConfigs.emeroniumChestplateProtectionInt, /*helmet*/ModConfigs.emeroniumHelmetProtectionInt },
    /*enchantability*/ModConfigs.emeroniumArmorEnchantabilityInt, SoundEvents.ARMOR_EQUIP_DIAMOND, /*toughness*/(float)ModConfigs.emeroniumArmorToughnessFloat, /*resistance*/(float)ModConfigs.emeroniumArmorResistanceFloat, () -> { return Ingredient.of(ModItems.EMERONIUM_INGOT.get());}),
	
	ENDONIUM("endonium", /*durability*/ModConfigs.endoniumArmorDurabilityInt, new int[] { /*boots*/ModConfigs.endoniumBootsProtectionInt, /*leggings*/ModConfigs.endoniumLeggingsProtectionInt, /*chestplate*/ModConfigs.endoniumChestplateProtectionInt, /*helmet*/ModConfigs.endoniumHelmetProtectionInt },
	/*enchantability*/ModConfigs.endoniumArmorEnchantabilityInt, SoundEvents.ARMOR_EQUIP_DIAMOND, /*toughness*/(float)ModConfigs.endoniumArmorToughnessFloat, /*resistance*/(float)ModConfigs.endoniumArmorResistanceFloat, () -> { return Ingredient.of(ModItems.ENDONIUM_INGOT.get());}),
	
	ENDONIUM_CRYSTAL("endonium_crystal", /*durability*/ModConfigs.endoniumCrystalArmorDurabilityInt, new int[] { /*boots*/ModConfigs.endoniumCrystalBootsProtectionInt, /*leggings*/ModConfigs.endoniumCrystalLeggingsProtectionInt, /*chestplate*/ModConfigs.endoniumCrystalChestplateProtectionInt, /*helmet*/ModConfigs.endoniumCrystalHelmetProtectionInt },
	/*enchantability*/ModConfigs.endoniumCrystalArmorEnchantabilityInt, SoundEvents.ARMOR_EQUIP_NETHERITE, /*toughness*/(float)ModConfigs.endoniumCrystalArmorToughnessFloat, /*resistance*/(float)ModConfigs.endoniumCrystalArmorResistanceFloat, () -> { return Ingredient.of(ModItems.ENDONIUM_CRYSTAL.get());}),
	
	SAPHONIUM("saphonium", /*durability*/ModConfigs.saphoniumArmorDurabilityInt, new int[] { /*boots*/ModConfigs.saphoniumBootsProtectionInt, /*leggings*/ModConfigs.saphoniumLeggingsProtectionInt, /*chestplate*/ModConfigs.saphoniumChestplateProtectionInt, /*helmet*/ModConfigs.saphoniumHelmetProtectionInt },
	/*enchantability*/ModConfigs.saphoniumArmorEnchantabilityInt, SoundEvents.ARMOR_EQUIP_DIAMOND, /*toughness*/(float)ModConfigs.saphoniumArmorToughnessFloat, /*resistance*/(float)ModConfigs.saphoniumArmorResistanceFloat, () -> { return Ingredient.of(ModItems.SAPHONIUM_INGOT.get());}),
	
	RUBONIUM("rubonium", /*durability*/ModConfigs.ruboniumArmorDurabilityInt, new int[] { /*boots*/ModConfigs.ruboniumBootsProtectionInt, /*leggings*/ModConfigs.ruboniumLeggingsProtectionInt, /*chestplate*/ModConfigs.ruboniumChestplateProtectionInt, /*helmet*/ModConfigs.ruboniumHelmetProtectionInt },
	/*enchantability*/ModConfigs.ruboniumArmorEnchantabilityInt, SoundEvents.ARMOR_EQUIP_DIAMOND, /*toughness*/(float)ModConfigs.ruboniumArmorToughnessFloat, /*resistance*/(float)ModConfigs.ruboniumArmorResistanceFloat, () -> { return Ingredient.of(ModItems.RUBONIUM_INGOT.get());}),
	
	OBSIDIUM("obsidium", /*durability*/ModConfigs.obsidiumArmorDurabilityInt, new int[] { /*boots*/ModConfigs.obsidiumBootsProtectionInt, /*leggings*/ModConfigs.obsidiumLeggingsProtectionInt, /*chestplate*/ModConfigs.obsidiumChestplateProtectionInt, /*helmet*/ModConfigs.obsidiumHelmetProtectionInt },
	/*enchantability*/ModConfigs.obsidiumArmorEnchantabilityInt, SoundEvents.ARMOR_EQUIP_IRON, /*toughness*/(float)ModConfigs.obsidiumArmorToughnessFloat, /*resistance*/(float)ModConfigs.obsidiumArmorResistanceFloat, () -> { return Ingredient.of(ModItems.OBSIDIUM_INGOT.get());}),
	
	GLASS("glass", /*durability*/ModConfigs.glassArmorDurabilityInt, new int[] { /*boots*/ModConfigs.glassBootsProtectionInt, /*leggings*/ModConfigs.glassLeggingsProtectionInt, /*chestplate*/ModConfigs.glassChestplateProtectionInt, /*helmet*/ModConfigs.glassHelmetProtectionInt },
	/*enchantability*/ModConfigs.glassArmorEnchantabilityInt, SoundEvents.ARMOR_EQUIP_DIAMOND, /*toughness*/(float)ModConfigs.glassArmorToughnessFloat, /*resistance*/(float)ModConfigs.glassArmorResistanceFloat, () -> { return Ingredient.of(Items.GLASS);});

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{/*boots*/11, /*leggings*/15, /*chestplate*/16, /*helmet*/13};
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