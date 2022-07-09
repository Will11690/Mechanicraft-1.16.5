package com.github.will11690.mechanicraft.energy;

import java.util.function.BooleanSupplier;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.energy.EnergyStorage;

public class MechaniCraftEnergyStorage extends EnergyStorage implements INBTSerializable<CompoundNBT> {
	
	protected BooleanSupplier creative;
	
    protected int baseCapacity;
    protected int baseReceive;
    protected int baseExtract;
    
    protected int upgradedCapacity;
    protected int upgradedExtract;
    protected int upgradedReceive;

	public MechaniCraftEnergyStorage(final int setCapacity) {
		
		super(setCapacity);
		
		capacity = setCapacity;
		
	}

	public MechaniCraftEnergyStorage(final int setCapacity, final int setMaxTransfer) {
		
		super(setCapacity, setMaxTransfer);
		
		baseCapacity = setCapacity;
		baseReceive = setMaxTransfer;
		baseExtract = setMaxTransfer;
		
		capacity = getIEnergyCapacity();
		maxReceive = getIEnergyReceive();
		maxExtract = getIEnergyExtract();
		
	}

	public MechaniCraftEnergyStorage(final int setCapacity, final int setMaxReceive, final int setMaxExtract) {
		
		super(setCapacity, setMaxReceive, setMaxExtract);
		
		baseCapacity = setCapacity;
		baseReceive = setMaxReceive;
		baseExtract = setMaxExtract;
		
		capacity = getIEnergyCapacity();
		maxReceive = getIEnergyReceive();
		maxExtract = getIEnergyExtract();
		
	}

	public MechaniCraftEnergyStorage(final int setCapacity, final int setMaxReceive, final int setMaxExtract, final int setEnergy) {
		
		super(setCapacity, setMaxReceive, setMaxExtract, setEnergy);
		
		baseCapacity = setCapacity;
		baseReceive = setMaxReceive;
		baseExtract = setMaxExtract;
			
		capacity = getIEnergyCapacity();
		maxReceive = getIEnergyReceive();
		maxExtract = getIEnergyExtract();
		
	    energy = Math.max(0 , Math.min(setCapacity, setEnergy));
		
	}
	
    @Override
    public CompoundNBT serializeNBT() {
    	
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("energy", getEnergyStored());
        return tag;
        
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
    	
    	setEnergy(nbt.getInt("energy"));
    	
    }
	
	public int upgradedCapacity(int capacityUpgrade) {
		
		int setMaxCapacity;
		
		if(baseCapacity != 0 && baseCapacity != upgradedCapacity && capacityUpgrade > 0) {
			
			setMaxCapacity = (int)Math.round(baseCapacity * (capacityUpgrade * 1.10));
			upgradedCapacity = setMaxCapacity;
			
			onEnergyChanged();
			
			return upgradedCapacity;
			
		} else
			
			upgradedCapacity = baseCapacity;
		
			onEnergyChanged();
		
			return upgradedCapacity;
		
	}
	
	public int upgradedReceive(int transferUpgrade) {
		
		int setMaxReceive;
		
		if(baseReceive != 0 && baseReceive != upgradedReceive && transferUpgrade > 0) {
			
			setMaxReceive = (int)Math.round(baseReceive * (transferUpgrade * 1.10));
			upgradedReceive = setMaxReceive;
			
			onEnergyChanged();
			
			return upgradedReceive;
			
		} else
			
			upgradedReceive = baseReceive;
		
			onEnergyChanged();
		
			return upgradedReceive;
		
	}
	
	public int upgradedExtract(int transferUpgrade) {
		
		int setMaxExtract;
		
		if(baseExtract != 0 && baseExtract != upgradedExtract && transferUpgrade > 0) {
			
			setMaxExtract = (int)Math.round(baseExtract * (transferUpgrade * 1.10));
			upgradedExtract = setMaxExtract;
			
			onEnergyChanged();
			
			return upgradedExtract;
			
		}
		
		upgradedExtract = baseExtract;
		
		onEnergyChanged();
		
		return upgradedExtract;
	}
	
	public void applyCapacityUpgrades(int capacityUpgrade) {
		
        setCapacity(upgradedCapacity(capacityUpgrade));
        onEnergyChanged();
        
    }
	
	public void applyTransferUpgrades(int transferUpgrade) {
			
		if(baseReceive > 0) {
			
			setMaxReceive(upgradedReceive(transferUpgrade));
			onEnergyChanged();
			
		}
		
		if(baseExtract > 0) {
			
			setMaxExtract(upgradedExtract(transferUpgrade));
			onEnergyChanged();
			
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
    
    private int getIEnergyCapacity() {
    	
    	int cap;
    	
    	if(upgradedCapacity > 0) {
    		
    		cap = upgradedCapacity;
    		onEnergyChanged();
    		return cap;
    		
		} else if(capacity != baseCapacity && upgradedCapacity <= 0) {
			
			cap = baseCapacity;
			onEnergyChanged();
			return cap;
		}
    	
    	return baseCapacity;
    }
    
    private int getIEnergyReceive() {
    	
    	int rec;
    	
    	if(upgradedReceive > 0) {
    		
    		rec = upgradedReceive;
    		onEnergyChanged();
    		return rec;
    		
		} else if(maxReceive != baseReceive && upgradedReceive <= 0) {
			
			rec = baseReceive;
			onEnergyChanged();
			return rec;
		}
    	
    	return baseReceive;
    }
    
    private int getIEnergyExtract() {
    	
    	int ext;
    	
    	if(upgradedExtract > 0) {
    		
    		ext = upgradedExtract;
    		onEnergyChanged();
			return ext;
			
		} else if(maxExtract != baseExtract && upgradedExtract <= 0) {
			
			ext = baseExtract;
			onEnergyChanged();
			return ext;
		}
    	
    	return baseExtract;
    }
    
    public int getBaseCapacity() {
		
		return baseCapacity;
	}
    
    public int getBaseReceive() {
		
		return baseReceive;
		
	}

	public int getBaseExtract() {
		
		return baseExtract;
		
	}
	
	public int getUpgradedCapacity() {
		
		return upgradedCapacity;
	}
    
    public int getUpgradedReceive() {
		
		return upgradedReceive;
		
	}

	public int getUpgradedExtract() {
		
		return upgradedExtract;
		
	}

	public void setBaseCapacity(int setBaseCapacity) {
		
		baseCapacity = setBaseCapacity;
		onEnergyChanged();
		
	}
}