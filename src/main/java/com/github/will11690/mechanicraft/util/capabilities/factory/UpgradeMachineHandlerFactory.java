package com.github.will11690.mechanicraft.util.capabilities.factory;

import com.github.will11690.mechanicraft.init.ModItems;
import com.github.will11690.mechanicraft.util.capabilities.interfaces.IUpgradeMachineHandler;

import net.minecraft.item.ItemStack;

public class UpgradeMachineHandlerFactory implements IUpgradeMachineHandler {
	
	protected int totalProcessingTime;
	protected int totalEnergyUsed;
	protected int baseProcessingTime;
	protected int baseEnergyUsed;
	protected int upgrade1Count;
	protected int upgrade2Count;
	protected int upgrade3Count;
	protected int upgrade4Count;
	
	protected ItemStack upgrade1Stack = ItemStack.EMPTY;
	protected ItemStack upgrade2Stack = ItemStack.EMPTY;
	protected ItemStack upgrade3Stack = ItemStack.EMPTY;
	protected ItemStack upgrade4Stack = ItemStack.EMPTY;
	
	public UpgradeMachineHandlerFactory() {}
	
	@Override
	public void oneUpgradeModifier(int processingTime, int energyUsed, ItemStack upgrade) {
		
		int speedCount = 0;
		
		int efficiencyCount = 0;
		
		if(!(upgrade1Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade1Count = upgrade1Count(upgrade);
		}
		
		int totalSpeed = 0;
		int totalEfficiency = 0;
		
		this.baseProcessingTime = processingTime;
		this.baseEnergyUsed = energyUsed;
		
		if(upgrade1Count != 0) {
			
			if(upgrade.getItem().equals(ModItems.SPEED_UPGRADE.get())) {
				
				speedCount = upgrade1Count;
				
			}
			
			if(upgrade.getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) {
				
				efficiencyCount = upgrade1Count;
				
			}
			
			totalSpeed = speedCount;
			totalEfficiency = efficiencyCount;
			
			if(totalSpeed > 19) {
				
				totalSpeed = 19;
			}
			
			if(totalEfficiency > 19) {
				
				totalEfficiency = 19;
			}
		}
			
		if(totalSpeed > 0 || totalEfficiency > 0) {
			
			if(totalSpeed != 0 && totalEfficiency != 0) {
				
				double totalEnergy = energyUsed * processingTime;
				double efficiencyLossEnergy = totalEnergy + ((totalEnergy * 0.05) * totalSpeed);
				double efficiencyLossTime = totalEnergy + ((totalEnergy * 0.05) * totalEfficiency);
				
				double workTime = efficiencyLossEnergy / energyUsed - (energyUsed / (totalSpeed * 0.10));
				double workEnergy = efficiencyLossTime / processingTime - (processingTime / (totalEfficiency * 0.10));
		    		
		    	this.totalEnergyUsed = (int)workEnergy;
		    	this.totalProcessingTime = (int)workTime;
		    	this.onUpgradeChanged();
					
			} else if(totalSpeed > 0 && totalEfficiency == 0) {
				
				double totalEnergy = energyUsed * processingTime;
				double efficiencyLoss = totalEnergy + ((totalEnergy * 0.05) * totalSpeed);
				
				double workEnergy = efficiencyLoss / processingTime + (processingTime * (totalSpeed * 0.10));
				double workTime = efficiencyLoss / workEnergy;
    			
	    		this.totalEnergyUsed = (int)workEnergy;
	    		this.totalProcessingTime = (int)workTime;
	    		this.onUpgradeChanged();
					
			} else if(totalEfficiency > 0 && totalSpeed == 0) {
					
				double totalEnergy = energyUsed * processingTime;
				double efficiencyLoss = totalEnergy + ((totalEnergy * 0.05) * totalEfficiency);
				
				double workTime = efficiencyLoss / energyUsed + (energyUsed * (totalEfficiency * 0.10));
				double workEnergy = efficiencyLoss / workTime;
        			
        		this.totalEnergyUsed = (int)workEnergy;
        		this.totalProcessingTime = (int)workTime;
        		this.onUpgradeChanged();
			}
			
		} else {
			//Default(No Upgrades)
			this.totalEnergyUsed = this.baseEnergyUsed;
			this.totalProcessingTime = this.baseProcessingTime;
			this.onUpgradeChanged();
		}
	}

	@Override
	public void twoUpgradeModifier(int processingTime, int energyUsed, ItemStack upgrade1, ItemStack upgrade2) {
		
		int speedCount1 = 0;
		int speedCount2 = 0;
		
		int efficiencyCount1 = 0;
		int efficiencyCount2 = 0;
		
		if(!(upgrade1Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade1Count = upgrade1Count(upgrade1);
		}
		
		if(!(upgrade2Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade2Count = upgrade2Count(upgrade2);
		}
		
		int totalSpeed = 0;
		int totalEfficiency = 0;
		
		this.baseProcessingTime = processingTime;
		this.baseEnergyUsed = energyUsed;
		
		if(upgrade1Count != 0 || upgrade2Count != 0) {
			
			if(upgrade1.getItem().equals(ModItems.SPEED_UPGRADE.get())) {
				
				speedCount1 = upgrade1Count;
				
			}
			
			if(upgrade2.getItem().equals(ModItems.SPEED_UPGRADE.get())) {
				
				speedCount2 = upgrade2Count;
				
			}
			
			if(upgrade1.getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) {
				
				efficiencyCount1 = upgrade1Count;
				
			}
			
			if(upgrade2.getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) {
				
				efficiencyCount2 = upgrade2Count;
				
			}
			
			totalSpeed = speedCount1 + speedCount2;
			totalEfficiency = efficiencyCount1 + efficiencyCount2;
			
			if(totalSpeed > 19) {
				
				totalSpeed = 19;
			}
			
			if(totalEfficiency > 19) {
				
				totalEfficiency = 19;
			}
		}
			
		if(totalSpeed > 0 || totalEfficiency > 0) {
			
			if(totalSpeed != 0 && totalEfficiency != 0) {
				
				double totalEnergy = energyUsed * processingTime;
				double efficiencyLossEnergy = totalEnergy + ((totalEnergy * 0.05) * totalSpeed);
				double efficiencyLossTime = totalEnergy + ((totalEnergy * 0.05) * totalEfficiency);
				
				double workTime = efficiencyLossEnergy / energyUsed - (energyUsed / (totalSpeed * 0.10));
				double workEnergy = efficiencyLossTime / processingTime - (processingTime / (totalEfficiency * 0.10));
		    		
		    	this.totalEnergyUsed = (int)workEnergy;
		    	this.totalProcessingTime = (int)workTime;
		    	this.onUpgradeChanged();
					
			} else if(totalSpeed > 0 && totalEfficiency == 0) {
				
				double totalEnergy = energyUsed * processingTime;
				double efficiencyLoss = totalEnergy + ((totalEnergy * 0.05) * totalSpeed);
				
				double workEnergy = efficiencyLoss / processingTime + (processingTime * (totalSpeed * 0.10));
				double workTime = efficiencyLoss / workEnergy;
    			
	    		this.totalEnergyUsed = (int)workEnergy;
	    		this.totalProcessingTime = (int)workTime;
	    		this.onUpgradeChanged();
					
			} else if(totalEfficiency > 0 && totalSpeed == 0) {
					
				double totalEnergy = energyUsed * processingTime;
				double efficiencyLoss = totalEnergy + ((totalEnergy * 0.05) * totalEfficiency);
				
				double workTime = efficiencyLoss / energyUsed + (energyUsed * (totalEfficiency * 0.10));
				double workEnergy = efficiencyLoss / workTime;
        			
        		this.totalEnergyUsed = (int)workEnergy;
        		this.totalProcessingTime = (int)workTime;
        		this.onUpgradeChanged();
			}
			
		} else {
			
			this.totalEnergyUsed = this.baseEnergyUsed;
    		this.totalProcessingTime = this.baseProcessingTime;
    		this.onUpgradeChanged();
			
		}
	}

	@Override
	public void threeUpgradeModifier(int processingTime, int energyUsed, ItemStack upgrade1, ItemStack upgrade2, ItemStack upgrade3) {
		
		int speedCount1 = 0;
		int speedCount2 = 0;
		int speedCount3 = 0;
		
		int efficiencyCount1 = 0;
		int efficiencyCount2 = 0;
		int efficiencyCount3 = 0;
		
		if(!(upgrade1Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade1Count = upgrade1Count(upgrade1);
		}
		
		if(!(upgrade2Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade2Count = upgrade2Count(upgrade2);
		}
		
		if(!(upgrade3Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade3Count = upgrade3Count(upgrade3);
		}
		
		int totalSpeed = 0;
		int totalEfficiency = 0;
		
		this.baseProcessingTime = processingTime;
		this.baseEnergyUsed = energyUsed;
		
		if(upgrade1Count != 0 || upgrade2Count != 0 || upgrade3Count != 0) {
			
			if(upgrade1.getItem().equals(ModItems.SPEED_UPGRADE.get())) {
				
				speedCount1 = upgrade1Count;
				
			}
			
			if(upgrade2.getItem().equals(ModItems.SPEED_UPGRADE.get())) {
				
				speedCount2 = upgrade2Count;
				
			}

			if(upgrade3.getItem().equals(ModItems.SPEED_UPGRADE.get())) {
	
				speedCount3 = upgrade3Count;
	
			}
			
			if(upgrade1.getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) {
				
				efficiencyCount1 = upgrade1Count;
				
			}
			
			if(upgrade2.getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) {
				
				efficiencyCount2 = upgrade2Count;
				
			}

			if(upgrade3.getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) {
	
				efficiencyCount3 = upgrade3Count;
	
			}
			
			totalSpeed = speedCount1 + speedCount2 + speedCount3;
			totalEfficiency = efficiencyCount1 + efficiencyCount2 + efficiencyCount3;
			
			if(totalSpeed > 19) {
				
				totalSpeed = 19;
			}
			
			if(totalEfficiency > 19) {
				
				totalEfficiency = 19;
			}
		}
			
		if(totalSpeed > 0 || totalEfficiency > 0) {
			
			if(totalSpeed != 0 && totalEfficiency != 0) {
				
				double totalEnergy = energyUsed * processingTime;
				double efficiencyLossEnergy = totalEnergy + ((totalEnergy * 0.05) * totalSpeed);
				double efficiencyLossTime = totalEnergy + ((totalEnergy * 0.05) * totalEfficiency);
				
				double workTime = efficiencyLossEnergy / energyUsed - (energyUsed / (totalSpeed * 0.10));
				double workEnergy = efficiencyLossTime / processingTime - (processingTime / (totalEfficiency * 0.10));
		    		
		    	this.totalEnergyUsed = (int)workEnergy;
		    	this.totalProcessingTime = (int)workTime;
		    	this.onUpgradeChanged();
					
			} else if(totalSpeed > 0 && totalEfficiency == 0) {
				
				double totalEnergy = energyUsed * processingTime;
				double efficiencyLoss = totalEnergy + ((totalEnergy * 0.05) * totalSpeed);
				
				double workEnergy = efficiencyLoss / processingTime + (processingTime * (totalSpeed * 0.10));
				double workTime = efficiencyLoss / workEnergy;
    			
	    		this.totalEnergyUsed = (int)workEnergy;
	    		this.totalProcessingTime = (int)workTime;
	    		this.onUpgradeChanged();
					
			} else if(totalEfficiency > 0 && totalSpeed == 0) {
					
				double totalEnergy = energyUsed * processingTime;
				double efficiencyLoss = totalEnergy + ((totalEnergy * 0.05) * totalEfficiency);
				
				double workTime = efficiencyLoss / energyUsed + (energyUsed * (totalEfficiency * 0.10));
				double workEnergy = efficiencyLoss / workTime;
        			
        		this.totalEnergyUsed = (int)workEnergy;
        		this.totalProcessingTime = (int)workTime;
        		this.onUpgradeChanged();
			}
			
		} else {
				
			this.totalEnergyUsed = this.baseEnergyUsed;
	    	this.totalProcessingTime = this.baseProcessingTime;
	    	this.onUpgradeChanged();
		}
	}

	@Override
	public void fourUpgradeModifier(int processingTime, int energyUsed, ItemStack upgrade1, ItemStack upgrade2, ItemStack upgrade3, ItemStack upgrade4) {
		
		int speedCount1 = 0;
		int speedCount2 = 0;
		int speedCount3 = 0;
		int speedCount4 = 0;
		
		int efficiencyCount1 = 0;
		int efficiencyCount2 = 0;
		int efficiencyCount3 = 0;
		int efficiencyCount4 = 0;
		
		if(!(upgrade1Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade1Count = upgrade1Count(upgrade1);
		}
		
		if(!(upgrade2Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade2Count = upgrade2Count(upgrade2);
		}
		
		if(!(upgrade3Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade3Count = upgrade3Count(upgrade3);
		}
		
		if(!(upgrade4Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade4Count = upgrade4Count(upgrade4);
		}
		
		int totalSpeed = 0;
		int totalEfficiency = 0;
		
		this.baseProcessingTime = processingTime;
		this.baseEnergyUsed = energyUsed;
		
		if(upgrade1Count != 0 || upgrade2Count != 0 || upgrade3Count != 0 || upgrade4Count != 0) {
			
			if(upgrade1.getItem().equals(ModItems.SPEED_UPGRADE.get())) {
				
				speedCount1 = upgrade1Count;
				
			}
			
			if(upgrade2.getItem().equals(ModItems.SPEED_UPGRADE.get())) {
				
				speedCount2 = upgrade2Count;
				
			}

			if(upgrade3.getItem().equals(ModItems.SPEED_UPGRADE.get())) {
	
				speedCount3 = upgrade3Count;
	
			}

			if(upgrade4.getItem().equals(ModItems.SPEED_UPGRADE.get())) {
	
				speedCount4 = upgrade4Count;
	
			}
			
			if(upgrade1.getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) {
				
				efficiencyCount1 = upgrade1Count;
				
			}
			
			if(upgrade2.getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) {
				
				efficiencyCount2 = upgrade2Count;
				
			}

			if(upgrade3.getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) {
	
				efficiencyCount3 = upgrade3Count;
	
			}

			if(upgrade4.getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) {
	
				efficiencyCount4 = upgrade4Count;
	
			}
			
			totalSpeed = speedCount1 + speedCount2 + speedCount3 + speedCount4;
			totalEfficiency = efficiencyCount1 + efficiencyCount2 + efficiencyCount3 + efficiencyCount4;
			
			if(totalSpeed > 19) {
				
				totalSpeed = 19;
			}
			
			if(totalEfficiency > 19) {
				
				totalEfficiency = 19;
			}
		}
			
		if(totalSpeed > 0 || totalEfficiency > 0) {
			
			if(totalSpeed != 0 && totalEfficiency != 0) {
				
				double totalEnergy = energyUsed * processingTime;
				double efficiencyLossEnergy = totalEnergy + ((totalEnergy * 0.05) * totalSpeed);
				double efficiencyLossTime = totalEnergy + ((totalEnergy * 0.05) * totalEfficiency);
				
				double workTime = efficiencyLossEnergy / energyUsed - (energyUsed / (totalSpeed * 0.10));
				double workEnergy = efficiencyLossTime / processingTime - (processingTime / (totalEfficiency * 0.10));
		    		
		    	this.totalEnergyUsed = (int)workEnergy;
		    	this.totalProcessingTime = (int)workTime;
		    	this.onUpgradeChanged();
					
			} else if(totalSpeed > 0 && totalEfficiency == 0) {
				
				double totalEnergy = energyUsed * processingTime;
				double efficiencyLoss = totalEnergy + ((totalEnergy * 0.05) * totalSpeed);
				
				double workEnergy = efficiencyLoss / processingTime + (processingTime * (totalSpeed * 0.10));
				double workTime = efficiencyLoss / workEnergy;
    			
	    		this.totalEnergyUsed = (int)workEnergy;
	    		this.totalProcessingTime = (int)workTime;
	    		this.onUpgradeChanged();
					
			} else if(totalEfficiency > 0 && totalSpeed == 0) {
					
				double totalEnergy = energyUsed * processingTime;
				double efficiencyLoss = totalEnergy + ((totalEnergy * 0.05) * totalEfficiency);
				
				double workTime = efficiencyLoss / energyUsed + (energyUsed * (totalEfficiency * 0.10));
				double workEnergy = efficiencyLoss / workTime;
        			
        		this.totalEnergyUsed = (int)workEnergy;
        		this.totalProcessingTime = (int)workTime;
        		this.onUpgradeChanged();
			}
				
		} else {
				
			this.totalEnergyUsed = this.baseEnergyUsed;
	    	this.totalProcessingTime = this.baseProcessingTime;
	    	this.onUpgradeChanged();
		}
	}

	@Override
	public int upgrade1Count(ItemStack upgrade) {
		
		return upgrade.getCount();
	}

	@Override
	public int upgrade2Count(ItemStack upgrade) {
		
		return upgrade.getCount();
	}

	@Override
	public int upgrade3Count(ItemStack upgrade) {
		
		return upgrade.getCount();
	}

	@Override
	public int upgrade4Count(ItemStack upgrade) {
		
		return upgrade.getCount();
	}

	@Override
	public boolean canExtractFromSlot(int processingTime) {
		
		if(processingTime <= 0) {
			
			return true;
			
		} else
			
		return false;
	}
	
	@Override
	public int getTotalProcessingTime() {
		
		return this.totalProcessingTime;
	}
	
	@Override
	public int getTotalEnergyUsed() {
		
		return this.totalEnergyUsed;
	}

	@Override
	public int setTotalProcessingTime(int processingTime) {
		
		return this.totalProcessingTime = processingTime;
	}

	@Override
	public int setTotalEnergyUsed(int energyUsed) {
		
		return this.totalEnergyUsed = energyUsed;
	}
	
	@Override
	public int getBaseProcessingTime() {
		
		return this.baseProcessingTime;
	}
	
	@Override
	public int getBaseEnergyUsed() {
		
		return this.baseEnergyUsed;
	}

	@Override
	public int setBaseProcessingTime(int baseProcessingTime) {
		
		return this.baseProcessingTime = baseProcessingTime;
	}

	@Override
	public int setBaseEnergyUsed(int baseEnergyUsed) {
		
		return this.baseEnergyUsed = baseEnergyUsed;
	}

	@Override
	public ItemStack getUpgrade1Stack() {
		
		return upgrade1Stack;
	}

	@Override
	public ItemStack getUpgrade2Stack() {
		
		return upgrade2Stack;
	}

	@Override
	public ItemStack getUpgrade3Stack() {
		
		return upgrade3Stack;
	}

	@Override
	public ItemStack getUpgrade4Stack() {
		
		return upgrade4Stack;
	}

	@Override
	public ItemStack setUpgrade1Stack(ItemStack upgrade1) {
		
		return upgrade1Stack = upgrade1;
	}

	@Override
	public ItemStack setUpgrade2Stack(ItemStack upgrade2) {
		
		return upgrade2Stack = upgrade2;
	}

	@Override
	public ItemStack setUpgrade3Stack(ItemStack upgrade3) {
		
		return upgrade3Stack = upgrade3;
	}

	@Override
	public ItemStack setUpgrade4Stack(ItemStack upgrade4) {
		
		return upgrade4Stack = upgrade4;
	}

	@Override
	public void onUpgradeChanged() {}
}