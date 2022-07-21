package com.github.will11690.mechanicraft.energy;

import java.util.function.BooleanSupplier;

import com.github.will11690.mechanicraft.init.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.energy.EnergyStorage;

public class MechaniCraftEnergyStorage extends EnergyStorage implements INBTSerializable<CompoundNBT> {
	
	protected BooleanSupplier creative;
	
    protected int baseCapacity;
    protected int baseReceive;
    protected int baseExtract;
    
    protected int upgradedCapacity = 0;
    protected int upgradedExtract = 0;
    protected int upgradedReceive = 0;
	protected int upgrade1Count = 0;
	protected int upgrade2Count = 0;
	protected int upgrade3Count = 0;
	protected int upgrade4Count = 0;
	
	protected ItemStack upgrade1Stack = ItemStack.EMPTY;
	protected ItemStack upgrade2Stack = ItemStack.EMPTY;
	protected ItemStack upgrade3Stack = ItemStack.EMPTY;
	protected ItemStack upgrade4Stack = ItemStack.EMPTY;

	public MechaniCraftEnergyStorage(final int setCapacity) {
		
		super(setCapacity);
		
		capacity = setCapacity;
		
	}

	public MechaniCraftEnergyStorage(final int setCapacity, final int setMaxTransfer) {
		
		super(setCapacity, setMaxTransfer);
		
		capacity = setCapacity;
		maxReceive = setMaxTransfer;
		maxExtract = setMaxTransfer;
		
	}

	public MechaniCraftEnergyStorage(final int setCapacity, final int setMaxReceive, final int setMaxExtract) {
		
		super(setCapacity, setMaxReceive, setMaxExtract);
		
		capacity = setCapacity;
		maxReceive = setMaxReceive;
		maxExtract = setMaxExtract;
		
	}

	public MechaniCraftEnergyStorage(final int setCapacity, final int setMaxReceive, final int setMaxExtract, final int setEnergy) {
		
		super(setCapacity, setMaxReceive, setMaxExtract, setEnergy);
			
		capacity = setCapacity;
		maxReceive = setMaxReceive;
		maxExtract = setMaxExtract;
		
	    energy = Math.max(0 , Math.min(setCapacity, setEnergy));
		
	}
	
    @Override
    public CompoundNBT serializeNBT() {
    	
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("energy", getEnergyStored());
        tag.putInt("baseCapacity", getBaseCapacity());
        tag.putInt("upgradedCapacity", getUpgradedCapacity());
        tag.putInt("capacity", getCapacity());
        tag.putInt("baseReceive", getBaseReceive());
        tag.putInt("upgradedReceive", getUpgradedReceive());
        tag.putInt("maxReceive", getMaxReceive());
        tag.putInt("baseExtract", getBaseExtract());
        tag.putInt("upgradedExtract", getUpgradedExtract());
        tag.putInt("maxExtract", getMaxExtract());
        
        if(!upgrade1Stack.isEmpty() && (upgrade1Stack.getItem().equals(ModItems.CAPACITY_UPGRADE.get()) || upgrade1Stack.getItem().equals(ModItems.TRANSFER_UPGRADE.get()))) {
            CompoundNBT upgradeOneTag = upgrade1Stack.serializeNBT();
            tag.put("upgradeOne", upgradeOneTag);
        }
        
        if(!upgrade2Stack.isEmpty() && (upgrade2Stack.getItem().equals(ModItems.CAPACITY_UPGRADE.get()) || upgrade2Stack.getItem().equals(ModItems.TRANSFER_UPGRADE.get()))) {
            CompoundNBT upgradeTwoTag = upgrade2Stack.serializeNBT();
            tag.put("upgradeTwo", upgradeTwoTag);
        }
        
        if(!upgrade3Stack.isEmpty() && (upgrade3Stack.getItem().equals(ModItems.CAPACITY_UPGRADE.get()) || upgrade3Stack.getItem().equals(ModItems.TRANSFER_UPGRADE.get()))) {
            CompoundNBT upgradeThreeTag = upgrade3Stack.serializeNBT();
            tag.put("upgradeThree", upgradeThreeTag);
        }
        
        if(!upgrade4Stack.isEmpty() && (upgrade4Stack.getItem().equals(ModItems.CAPACITY_UPGRADE.get()) || upgrade4Stack.getItem().equals(ModItems.TRANSFER_UPGRADE.get()))) {
            CompoundNBT upgradeFourTag = upgrade4Stack.serializeNBT();
            tag.put("upgradeFour", upgradeFourTag);
        }
        	
        return tag;
        
    }

    @Override
    public void deserializeNBT(CompoundNBT tag) {
    	
    	setEnergy(tag.getInt("energy"));
    	setBaseCapacity(tag.getInt("baseCapacity"));
    	setUpgradedCapacity(tag.getInt("upgradedCapacity"));
    	setCapacity(tag.getInt("capacity"));
    	setBaseReceive(tag.getInt("baseReceive"));
    	setUpgradedReceive(tag.getInt("upgradedReceive"));
    	setMaxReceive(tag.getInt("receive"));
    	setBaseExtract(tag.getInt("baseExtract"));
    	setUpgradedExtract(tag.getInt("upgradedExtract"));
    	setMaxExtract(tag.getInt("maxExtract"));
    	if(tag.contains("upgradeOne")) {
    		CompoundNBT upgradeOneTag = tag.getCompound("upgradeOne");
    		upgrade1Stack.deserializeNBT(upgradeOneTag);
    	}
    	
    	if(tag.contains("upgradeTwo")) {
    		CompoundNBT upgradeTwoTag = tag.getCompound("upgradeTwo");
    		upgrade2Stack.deserializeNBT(upgradeTwoTag);
    	}
    	
    	if(tag.contains("upgradeThree")) {
    		CompoundNBT upgradeThreeTag = tag.getCompound("upgradeThree");
    		upgrade3Stack.deserializeNBT(upgradeThreeTag);
    	}
    	
    	if(tag.contains("upgradeFour")) {
    		CompoundNBT upgradeFourTag = tag.getCompound("upgradeFour");
    		upgrade4Stack.deserializeNBT(upgradeFourTag);
    	}
    	
    }
	
	//TODO Test implementation on upgradeable machine
	
	public void setCreative(BooleanSupplier creativeUpgrade, int maxCreativeReceive, int maxCreativeExtract) {
		
        creative = creativeUpgrade;
        
        if(isCreative() == true) {
        	
        	energy = capacity;
        	maxReceive = maxCreativeReceive;
        	maxExtract = maxCreativeExtract;
        	onEnergyChanged();
        	
        }
        
    }
    
    public void consumeEnergy(int consumedEnergy) {
    	
    	if(energy > 0) {
    		
    		energy -= consumedEnergy;
    		
    		onEnergyChanged();
    		
    	}
    	
    	else energy = 0;
    	
		onEnergyChanged();
    	
    }
    
    public void addEnergy(int addedEnergy) {
    	
    	if(energy < capacity && energy + addedEnergy <= capacity) {
    		
    		energy += addedEnergy;
    		
    		onEnergyChanged();
    		
    	} else {
    		
    		energy = capacity;
    	
    		onEnergyChanged();
		
    	}
    }

	public int getMaxReceive() {
		
		return maxReceive;
		
	}

	public void setMaxReceive(final int setReceive) {
		
		maxReceive = setReceive;
		onEnergyChanged();
		
	}

	public int getMaxExtract() {
		
		return maxExtract;
		
	}

	public void setMaxExtract(final int setExtract) {
		
		maxExtract = setExtract;
		onEnergyChanged();
		
	}

	public int getCapacity() {
		
		return capacity;
		
	}

	public void setCapacity(int setCapacity) {
		
		capacity = setCapacity;
		if(energy > capacity) {
			setEnergy(capacity);
		}
		onEnergyChanged();
		
	}
	
    public boolean isCreative() {

        return creative.getAsBoolean();
        
    }
	
	public void setEnergy(final int setEnergy) {
		
		energy = setEnergy;
		onEnergyChanged();
		
	}
	
	/**
	 * Capped by max receive
	 */
	public int setEnergyStored(final int setEnergy, final boolean simulate) {
		
		final int toSet = Math.min(setEnergy, maxReceive);
		
		if (!simulate) {
			
			energy = toSet;
			onEnergyChanged();
			
		}
		
		return toSet;
	}

	/**
	 * Override this in TE to use setChanged() for Energy Storage
	 */
	protected void onEnergyChanged() {
		
	}
	
	public void updateEnergyStorageNoUpgrades(int capacity, int receive, int extract) {
		
		this.baseCapacity = capacity;
		this.baseExtract = extract;
		this.baseReceive = receive;
		
		if(this.capacity <= 0 && baseCapacity > 0) {
			
			setCapacity(baseCapacity);
			onEnergyChanged();
		}
		
		if(this.maxExtract <= 0 && baseExtract > 0) {
			
			setMaxExtract(baseExtract);
			onEnergyChanged();
		}
		
		if(this.maxReceive <= 0 && baseReceive > 0) {
			
			setMaxReceive(baseReceive);
			onEnergyChanged();
		}
	}
	
	public void oneUpgradeModifier(int capacity, int receive, int extract, ItemStack upgrade) {
		
		int capacityCount = 0;
		int transferCount = 0;
		
		this.baseCapacity = capacity;
		this.baseExtract = extract;
		this.baseReceive = receive;
		
		if(!(upgrade1Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade1Count = upgrade1Count(upgrade);
		}
		
		int totalCapacity = 0;
		int totalTransfer = 0;
		
		if(this.baseCapacity > 0 && this.capacity < this.baseCapacity) {
			
			this.setCapacity(capacity);
			onEnergyChanged();
		}
		
		if(this.baseExtract > 0 && this.maxExtract < this.baseExtract) {
			
			this.setMaxExtract(extract);
			onEnergyChanged();
		}
		
		if(this.baseReceive > 0 && this.maxReceive < this.baseReceive) {
			
			this.setMaxReceive(receive);
			onEnergyChanged();
		}
		
		if(upgrade1Count != 0 || upgrade2Count != 0) {
			
			if(upgrade.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
				
				capacityCount = upgrade1Count;
				
			}
			
			if(upgrade.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
				
				transferCount = upgrade1Count;
				
			}
			
			totalCapacity = capacityCount;
			totalTransfer = transferCount;
			
		}
			
		if(totalCapacity > 0 || totalTransfer > 0) {
			
			if(totalCapacity != 0 && totalTransfer != 0) {
				
				double modifyCap = (baseCapacity * 0.10) * totalCapacity;
				double upgradeCap = baseCapacity + modifyCap;
				double modifyExtract = (baseExtract * 0.10) * totalTransfer;
				double modifyReceive = (baseReceive * 0.10) * totalTransfer;
				double upgradeExt = 0;
				double upgradeRec = 0;
			
				if(baseExtract > 0) {
					upgradeExt = baseExtract + modifyExtract;
				}
		
				if(baseReceive > 0) {
					upgradeRec = baseReceive + modifyReceive;
				}
			
				this.setUpgradedExtract((int)upgradeExt);
				this.setUpgradedReceive((int)upgradeRec);
				this.setUpgradedCapacity((int)upgradeCap);
    		
				this.setCapacity(upgradedCapacity);
				this.setMaxExtract(upgradedExtract);
				this.setMaxReceive(upgradedReceive);
				this.onEnergyChanged();
				
			} else if(totalCapacity > 0 && totalTransfer == 0) {
			
				double modify = (baseCapacity * 0.10) * totalCapacity;
				double upgradeCap = baseCapacity + modify;
		
				this.upgradedCapacity = (int)upgradeCap;
				this.setCapacity(upgradedCapacity);
				this.setMaxExtract(baseExtract);
				this.setMaxReceive(baseReceive);
				this.onEnergyChanged();
			
			} else if(totalTransfer > 0 && totalCapacity == 0) {
			
				double modifyExtract = (baseExtract * 0.10) * totalTransfer;
				double modifyReceive = (baseReceive * 0.10) * totalTransfer;
				double upgradeExt = 0;
				double upgradeRec = 0;
			
				if(baseExtract > 0) {
					upgradeExt = baseExtract + modifyExtract;
				}
		
				if(baseReceive > 0) {
					upgradeRec = baseReceive + modifyReceive;
				}
		
				this.setUpgradedExtract((int)upgradeExt);
				this.setUpgradedReceive((int)upgradeRec);
				this.setCapacity(baseCapacity);
				this.setMaxExtract(upgradedExtract);
				this.setMaxReceive(upgradedReceive);
				this.onEnergyChanged();
			
			}
			
		} else {
			//Default(No Upgrades)
			this.setCapacity(baseCapacity);
    		this.setMaxExtract(baseExtract);
    		this.setMaxReceive(baseReceive);
    		this.onEnergyChanged();
			
		}
	}

	public void twoUpgradeModifier(int capacity, int receive, int extract, ItemStack upgrade1, ItemStack upgrade2) {
		
		int capacityCount1 = 0;
		int capacityCount2 = 0;
		
		int transferCount1 = 0;
		int transferCount2 = 0;
		
		if(!(upgrade1Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade1Count = upgrade1Count(upgrade1);
		}
		
		if(!(upgrade2Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade2Count = upgrade2Count(upgrade2);
		}
		
		int totalCapacity = 0;
		int totalTransfer = 0;
		
		this.baseCapacity = capacity;
		this.baseExtract = extract;
		this.baseReceive = receive;
		
		if(this.baseCapacity > 0 && this.capacity < this.baseCapacity) {
			
			this.setCapacity(capacity);
			onEnergyChanged();
		}
		
		if(this.baseExtract > 0 && this.maxExtract < this.baseExtract) {
			
			this.setMaxExtract(extract);
			onEnergyChanged();
		}
		
		if(this.baseReceive > 0 && this.maxReceive < this.baseReceive) {
			
			this.setMaxReceive(receive);
			onEnergyChanged();
		}
		
		if(upgrade1Count != 0 || upgrade2Count != 0) {
			
			if(upgrade1.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
				
				capacityCount1 = upgrade1Count;
				
			}
			
			if(upgrade2.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
				
				capacityCount2 = upgrade2Count;
				
			}
			
			if(upgrade1.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
				
				transferCount1 = upgrade1Count;
				
			}
			
			if(upgrade2.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
				
				transferCount2 = upgrade2Count;
				
			}
			
			totalCapacity = capacityCount1 + capacityCount2;
			totalTransfer = transferCount1 + transferCount2;
			
		}
			
		if(totalCapacity > 0 || totalTransfer > 0) {
			
			if(totalCapacity != 0 && totalTransfer != 0) {
				
				double modifyCap = (baseCapacity * 0.10) * totalCapacity;
				double upgradeCap = baseCapacity + modifyCap;
				double modifyExtract = (baseExtract * 0.10) * totalTransfer;
				double modifyReceive = (baseReceive * 0.10) * totalTransfer;
				double upgradeExt = 0;
				double upgradeRec = 0;
			
				if(baseExtract > 0) {
					upgradeExt = baseExtract + modifyExtract;
				}
		
				if(baseReceive > 0) {
					upgradeRec = baseReceive + modifyReceive;
				}
			
				this.setUpgradedExtract((int)upgradeExt);
				this.setUpgradedReceive((int)upgradeRec);
				this.setUpgradedCapacity((int)upgradeCap);
    		
				this.setCapacity(upgradedCapacity);
				this.setMaxExtract(upgradedExtract);
				this.setMaxReceive(upgradedReceive);
				this.onEnergyChanged();
				
			} else if(totalCapacity > 0 && totalTransfer == 0) {
			
				double modify = (baseCapacity * 0.10) * totalCapacity;
				double upgradeCap = baseCapacity + modify;
		
				this.upgradedCapacity = (int)upgradeCap;
				this.setCapacity(upgradedCapacity);
				this.setMaxExtract(baseExtract);
				this.setMaxReceive(baseReceive);
				this.onEnergyChanged();
			
			} else if(totalTransfer > 0 && totalCapacity == 0) {
			
				double modifyExtract = (baseExtract * 0.10) * totalTransfer;
				double modifyReceive = (baseReceive * 0.10) * totalTransfer;
				double upgradeExt = 0;
				double upgradeRec = 0;
			
				if(baseExtract > 0) {
					upgradeExt = baseExtract + modifyExtract;
				}
		
				if(baseReceive > 0) {
					upgradeRec = baseReceive + modifyReceive;
				}
		
				this.setUpgradedExtract((int)upgradeExt);
				this.setUpgradedReceive((int)upgradeRec);
				this.setCapacity(baseCapacity);
				this.setMaxExtract(upgradedExtract);
				this.setMaxReceive(upgradedReceive);
				this.onEnergyChanged();
			
			}
	
		} else {
			//Default(No Upgrades)
			this.setCapacity(baseCapacity);
			this.setMaxExtract(baseExtract);
			this.setMaxReceive(baseReceive);
			this.onEnergyChanged();
	
		}
	}

	public void threeUpgradeModifier(int capacity, int receive, int extract, ItemStack upgrade1, ItemStack upgrade2, ItemStack upgrade3) {
		
		int capacityCount1 = 0;
		int capacityCount2 = 0;
		int capacityCount3 = 0;
		
		int transferCount1 = 0;
		int transferCount2 = 0;
		int transferCount3 = 0;
		
		this.baseCapacity = capacity;
		this.baseExtract = extract;
		this.baseReceive = receive;
		
		if(!(upgrade1Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade1Count = upgrade1Count(upgrade1);
		}
		
		if(!(upgrade2Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade2Count = upgrade2Count(upgrade2);
		}
		
		if(!(upgrade3Stack.equals(ItemStack.EMPTY))) {
			
			this.upgrade3Count = upgrade3Count(upgrade3);
		}
		
		int totalCapacity = 0;
		int totalTransfer = 0;
		
		if(this.baseCapacity > 0 && this.capacity < this.baseCapacity) {
			
			this.setCapacity(capacity);
			onEnergyChanged();
		}
		
		if(this.baseExtract > 0 && this.maxExtract < this.baseExtract) {
			
			this.setMaxExtract(extract);
			onEnergyChanged();
		}
		
		if(this.baseReceive > 0 && this.maxReceive < this.baseReceive) {
			
			this.setMaxReceive(receive);
			onEnergyChanged();
		}
		
		if(upgrade1Count != 0 || upgrade2Count != 0 || upgrade3Count != 0) {
			
			if(upgrade1.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
				
				capacityCount1 = upgrade1Count;
				
			}
			
			if(upgrade2.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
				
				capacityCount2 = upgrade2Count;
				
			}

			if(upgrade3.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
	
				capacityCount3 = upgrade3Count;
	
			}
			
			if(upgrade1.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
				
				transferCount1 = upgrade1Count;
				
			}
			
			if(upgrade2.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
				
				transferCount2 = upgrade2Count;
				
			}

			if(upgrade3.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
	
				transferCount3 = upgrade3Count;
	
			}
			
			totalCapacity = capacityCount1 + capacityCount2 + capacityCount3;
			totalTransfer = transferCount1 + transferCount2 + transferCount3;
			
		}
			
		if(totalCapacity > 0 || totalTransfer > 0) {
			
			if(totalCapacity != 0 && totalTransfer != 0) {
				
				double modifyCap = (baseCapacity * 0.10) * totalCapacity;
				double upgradeCap = baseCapacity + modifyCap;
				double modifyExtract = (baseExtract * 0.10) * totalTransfer;
				double modifyReceive = (baseReceive * 0.10) * totalTransfer;
				double upgradeExt = 0;
				double upgradeRec = 0;
			
				if(baseExtract > 0) {
					upgradeExt = baseExtract +  modifyExtract;
				}
		
				if(baseReceive > 0) {
					upgradeRec = baseReceive + modifyReceive;
				}
			
				this.setUpgradedExtract((int)upgradeExt);
				this.setUpgradedReceive((int)upgradeRec);
				this.setUpgradedCapacity((int)upgradeCap);
    		
				this.setCapacity(upgradedCapacity);
				this.setMaxExtract(upgradedExtract);
				this.setMaxReceive(upgradedReceive);
				this.onEnergyChanged();
				
			} else if(totalCapacity > 0 && totalTransfer == 0) {
			
				double modify = (baseCapacity * 0.10) * totalCapacity;
				double upgradeCap = baseCapacity + modify;
		
				this.upgradedCapacity = (int)upgradeCap;
				this.setCapacity(upgradedCapacity);
				this.setMaxExtract(baseExtract);
				this.setMaxReceive(baseReceive);
				this.onEnergyChanged();
			
			} else if(totalTransfer > 0 && totalCapacity == 0) {
			
				double modifyExtract = (baseExtract * 0.10) * totalTransfer;
				double modifyReceive = (baseReceive * 0.10) * totalTransfer;
				double upgradeExt = 0;
				double upgradeRec = 0;
			
				if(baseExtract > 0) {
					upgradeExt = baseExtract + modifyExtract;
				}
		
				if(baseReceive > 0) {
					upgradeRec = baseReceive + modifyReceive;
				}
		
				this.setUpgradedExtract((int)upgradeExt);
				this.setUpgradedReceive((int)upgradeRec);
				this.setCapacity(baseCapacity);
				this.setMaxExtract(upgradedExtract);
				this.setMaxReceive(upgradedReceive);
				this.onEnergyChanged();
			
			}
	
		} else {
			//Default(No Upgrades)
			this.setCapacity(baseCapacity);
			this.setMaxExtract(baseExtract);
			this.setMaxReceive(baseReceive);
			this.onEnergyChanged();
	
		}
	}

	public void fourUpgradeModifier(int capacity, int receive, int extract, ItemStack upgrade1, ItemStack upgrade2, ItemStack upgrade3, ItemStack upgrade4) {
		
		int capacityCount1 = 0;
		int capacityCount2 = 0;
		int capacityCount3 = 0;
		int capacityCount4 = 0;
		
		int transferCount1 = 0;
		int transferCount2 = 0;
		int transferCount3 = 0;
		int transferCount4 = 0;
		
		this.baseCapacity = capacity;
		this.baseExtract = extract;
		this.baseReceive = receive;
		
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
		
		int totalCapacity = 0;
		int totalTransfer = 0;
		
		if(this.baseCapacity > 0 && this.capacity < this.baseCapacity) {
			
			this.setCapacity(capacity);
			onEnergyChanged();
		}
		
		if(this.baseExtract > 0 && this.maxExtract < this.baseExtract) {
			
			this.setMaxExtract(extract);
			onEnergyChanged();
		}
		
		if(this.baseReceive > 0 && this.maxReceive < this.baseReceive) {
			
			this.setMaxReceive(receive);
			onEnergyChanged();
		}
		
		if(upgrade1Count != 0 || upgrade2Count != 0 || upgrade3Count != 0 || upgrade4Count != 0) {
			
			if(upgrade1.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
				
				capacityCount1 = upgrade1Count;
				
			}
			
			if(upgrade2.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
				
				capacityCount2 = upgrade2Count;
				
			}

			if(upgrade3.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
	
				capacityCount3 = upgrade3Count;
	
			}

			if(upgrade4.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
	
				capacityCount4 = upgrade4Count;
	
			}
			
			if(upgrade1.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
				
				transferCount1 = upgrade1Count;
				
			}
			
			if(upgrade2.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
				
				transferCount2 = upgrade2Count;
				
			}

			if(upgrade3.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
	
				transferCount3 = upgrade3Count;
	
			}

			if(upgrade4.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
	
				transferCount4 = upgrade4Count;
	
			}
			
			totalCapacity = capacityCount1 + capacityCount2 + capacityCount3 + capacityCount4;
			totalTransfer = transferCount1 + transferCount2 + transferCount3 + transferCount4;
			
		}
		
		if(totalCapacity > 0 || totalTransfer > 0) {
		
			if(totalCapacity != 0 && totalTransfer != 0) {
				
				double modifyCap = (baseCapacity * 0.10) * totalCapacity;
				double upgradeCap = baseCapacity + modifyCap;
				double modifyExtract = (baseExtract * 0.10) * totalTransfer;
				double modifyReceive = (baseReceive * 0.10) * totalTransfer;
				double upgradeExt = 0;
				double upgradeRec = 0;
			
				if(baseExtract > 0) {
					upgradeExt = baseExtract + modifyExtract;
				}
		
				if(baseReceive > 0) {
					upgradeRec = baseReceive + modifyReceive;
				}
			
				this.setUpgradedExtract((int)upgradeExt);
				this.setUpgradedReceive((int)upgradeRec);
				this.setUpgradedCapacity((int)upgradeCap);
    		
				this.setCapacity(upgradedCapacity);
				this.setMaxExtract(upgradedExtract);
				this.setMaxReceive(upgradedReceive);
				this.onEnergyChanged();
				
			} else if(totalCapacity > 0 && totalTransfer == 0) {
			
				double modify = (baseCapacity * 0.10) * totalCapacity;
				double upgradeCap = baseCapacity + modify;
		
				this.upgradedCapacity = (int)upgradeCap;
				this.setCapacity(upgradedCapacity);
				this.setMaxExtract(baseExtract);
				this.setMaxReceive(baseReceive);
				this.onEnergyChanged();
			
			} else if(totalTransfer > 0 && totalCapacity == 0) {
			
				double modifyExtract = (baseExtract * 0.10) * totalTransfer;
				double modifyReceive = (baseReceive * 0.10) * totalTransfer;
				double upgradeExt = 0;
				double upgradeRec = 0;
			
				if(baseExtract > 0) {
					upgradeExt = baseExtract + modifyExtract;
				}
		
				if(baseReceive > 0) {
					upgradeRec = baseReceive + modifyReceive;
				}
		
				this.setUpgradedExtract((int)upgradeExt);
				this.setUpgradedReceive((int)upgradeRec);
				this.setCapacity(baseCapacity);
				this.setMaxExtract(upgradedExtract);
				this.setMaxReceive(upgradedReceive);
				this.onEnergyChanged();
			
			}
	
		} else {
			//Default(No Upgrades)
			this.setCapacity(baseCapacity);
			this.setMaxExtract(baseExtract);
			this.setMaxReceive(baseReceive);
			this.onEnergyChanged();
	
		}
	}

	public int upgrade1Count(ItemStack upgrade) {
		
		return upgrade.getCount();
	}

	public int upgrade2Count(ItemStack upgrade) {
		
		return upgrade.getCount();
	}

	public int upgrade3Count(ItemStack upgrade) {
		
		return upgrade.getCount();
	}

	public int upgrade4Count(ItemStack upgrade) {
		
		return upgrade.getCount();
	}
	
	public int getBaseCapacity() {
		
		return this.baseCapacity;
	}
	
	public int getBaseExtract() {
		
		return this.baseExtract;
	}
	
	public int getBaseReceive() {
		
		return this.baseReceive;
	}
	
	public int getUpgradedCapacity() {
		
		return this.upgradedCapacity;
	}
	
	public int getUpgradedExtract() {
		
		return this.upgradedExtract;
	}
	
	public int getUpgradedReceive() {
		
		return this.upgradedReceive;
	}

	public int setBaseCapacity(int baseCapacity) {
		
		return this.baseCapacity = baseCapacity;
	}

	public int setBaseExtract(int baseExtract) {
		
		return this.baseExtract = baseExtract;
	}

	public int setBaseReceive(int baseReceive) {
		
		return this.baseReceive = baseReceive;
	}

	public int setUpgradedCapacity(int upgradedCapacity) {
		
		return this.upgradedCapacity = upgradedCapacity;
	}

	public int setUpgradedExtract(int upgradedExtract) {
		
		return this.upgradedExtract = upgradedExtract;
	}

	public int setUpgradedReceive(int upgradedReceive) {
		
		return this.upgradedReceive = upgradedReceive;
	}

	public ItemStack getUpgrade1Stack() {
		
		return upgrade1Stack;
	}

	public ItemStack getUpgrade2Stack() {
		
		return upgrade2Stack;
	}

	public ItemStack getUpgrade3Stack() {
		
		return upgrade3Stack;
	}

	public ItemStack getUpgrade4Stack() {
		
		return upgrade4Stack;
	}

	public ItemStack setUpgrade1Stack(ItemStack upgrade1) {
		
		return upgrade1Stack = upgrade1;
	}

	public ItemStack setUpgrade2Stack(ItemStack upgrade2) {
		
		return upgrade2Stack = upgrade2;
	}

	public ItemStack setUpgrade3Stack(ItemStack upgrade3) {
		
		return upgrade3Stack = upgrade3;
	}

	public ItemStack setUpgrade4Stack(ItemStack upgrade4) {
		
		return upgrade4Stack = upgrade4;
	}
	
	public boolean canExtractFromSlot(int energy) {
		
		if(energy <= baseCapacity) {
			
			return true;
			
		} else 
			return false;
	}
}