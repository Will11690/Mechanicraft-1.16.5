package com.github.will11690.mechanicraft.util.capabilities.interfaces;

import net.minecraft.item.ItemStack;

public interface IUpgradeGeneratorHandler {
	
	void oneUpgradeModifier(int burnTime, int energyGen, ItemStack upgrade);
	
	void twoUpgradeModifier(int burnTime, int energyGen, ItemStack upgrade1, ItemStack upgrade2);
	
	void threeUpgradeModifier(int burnTime, int energyGen, ItemStack upgrade1, ItemStack upgrade2, ItemStack upgrade3);
	
	void fourUpgradeModifier(int burnTime, int energyGen, ItemStack upgrade1, ItemStack upgrade2, ItemStack upgrade3, ItemStack upgrade4);
	
	int upgrade1Count(ItemStack upgrade);
	
	int upgrade2Count(ItemStack upgrade);
	
	int upgrade3Count(ItemStack upgrade);
	
	int upgrade4Count(ItemStack upgrade);
	
	boolean canExtractFromSlot(int burnTime);
	
	int getTotalBurnTime();
	
	int getTotalEnergyGen();
	
	int setTotalBurnTime(int burnTime);
	
	int setTotalEnergyGen(int energyGen);

	int getBaseBurnTime();
	
	int getBaseEnergyGen();

	int setBaseBurnTime(int baseBurnTime);

	int setBaseEnergyGen(int baseEnergyGen);

	ItemStack getUpgrade1Stack();
	
	ItemStack getUpgrade2Stack();
	
	ItemStack getUpgrade3Stack();
	
	ItemStack getUpgrade4Stack();

	ItemStack setUpgrade1Stack(ItemStack upgrade1);
	
	ItemStack setUpgrade2Stack(ItemStack upgrade2);
	
	ItemStack setUpgrade3Stack(ItemStack upgrade3);
	
	ItemStack setUpgrade4Stack(ItemStack upgrade4);
	
	void onUpgradeChanged();
	
}
