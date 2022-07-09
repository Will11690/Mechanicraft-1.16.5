package com.github.will11690.mechanicraft.util.capabilities.interfaces;

import net.minecraft.item.ItemStack;

public interface IUpgradeMachineHandler {
	
	void oneUpgradeModifier(int processingTime, int energyUsed, ItemStack upgrade);
	
	void twoUpgradeModifier(int processingTime, int energyUsed, ItemStack upgrade1, ItemStack upgrade2);
	
	void threeUpgradeModifier(int processingTime, int energyUsed, ItemStack upgrade1, ItemStack upgrade2, ItemStack upgrade3);
	
	void fourUpgradeModifier(int processingTime, int energyUsed, ItemStack upgrade1, ItemStack upgrade2, ItemStack upgrade3, ItemStack upgrade4);
	
	int upgrade1Count(ItemStack upgrade);
	
	int upgrade2Count(ItemStack upgrade);
	
	int upgrade3Count(ItemStack upgrade);
	
	int upgrade4Count(ItemStack upgrade);
	
	boolean canExtractFromSlot(int processingTime);
	
	int getTotalProcessingTime();
	
	int getTotalEnergyUsed();
	
	int setTotalProcessingTime(int processingTime);
	
	int setTotalEnergyUsed(int energyUsed);
	
	int getBaseProcessingTime();
	
	int getBaseEnergyUsed();
	
	int setBaseProcessingTime(int baseProcessingTime);

	int setBaseEnergyUsed(int baseEnergyUsed);

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
