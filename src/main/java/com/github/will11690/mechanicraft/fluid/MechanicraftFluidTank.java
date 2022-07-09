package com.github.will11690.mechanicraft.fluid;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nonnull;
import java.util.function.Predicate;

/**
 * Flexible implementation of a Fluid Storage object. NOT REQUIRED.
 *
 * Copied to add methods for calculating Mechanicraft Upgrades
 * All credits go to Minecraft Forge and King Lemming
 *
 * @author King Lemming
 */
public class MechanicraftFluidTank implements IFluidHandler, IFluidTank {

	//TODO add capacity upgrade methods
	
    protected Predicate<FluidStack> validator;
    @Nonnull
    protected FluidStack fluid = FluidStack.EMPTY;
    protected int capacity;
    protected int baseCapacity;
    protected int upgradedCapacity;

    public MechanicraftFluidTank(int capacity) {
    	
        this(capacity, e -> true);
    }

    public MechanicraftFluidTank(int capacity, Predicate<FluidStack> validator) {
    	
    	this.baseCapacity = capacity;
        this.capacity = getFluidCapacity();
        this.validator = validator;
    }

    public MechanicraftFluidTank setCapacity(int capacity) {
    	
        this.capacity = capacity;
        return this;
    }

    public MechanicraftFluidTank setValidator(Predicate<FluidStack> validator) {
    	
        if (validator != null) {
        	
            this.validator = validator;
        }
        
        return this;
    }

    public boolean isFluidValid(FluidStack stack) {
    	
        return validator.test(stack);
    }

    public int getCapacity() {
    	
        return capacity;
    }

    @Nonnull
    public FluidStack getFluid() {
    	
        return fluid;
    }

    public int getFluidAmount() {
    	
        return fluid.getAmount();
    }

    public MechanicraftFluidTank readFromNBT(CompoundNBT nbt) {

        FluidStack fluid = FluidStack.loadFluidStackFromNBT(nbt);
        setFluid(fluid);
        return this;
    }

    public CompoundNBT writeToNBT(CompoundNBT nbt) {

        fluid.writeToNBT(nbt);

        return nbt;
    }

    @Override
    public int getTanks() {

        return 1;
    }

    @Nonnull
    @Override
    public FluidStack getFluidInTank(int tank) {

        return getFluid();
    }

    @Override
    public int getTankCapacity(int tank) {

        return getCapacity();
    }

    @Override
    public boolean isFluidValid(int tank, @Nonnull FluidStack stack) {

        return isFluidValid(stack);
    }

    @Override
    public int fill(FluidStack resource, FluidAction action) {
    	
        if (resource.isEmpty() || !isFluidValid(resource)) {
        	
            return 0;
        }
        
        if (action.simulate()) {
        	
            if (fluid.isEmpty()) {
            	
                return Math.min(capacity, resource.getAmount());
            }
            if (!fluid.isFluidEqual(resource)) {
            	
                return 0;
            }
            
            return Math.min(capacity - fluid.getAmount(), resource.getAmount());
        }
        if (fluid.isEmpty()) {
        	
            fluid = new FluidStack(resource, Math.min(capacity, resource.getAmount()));
            onContentsChanged();
            return fluid.getAmount();
        }
        if (!fluid.isFluidEqual(resource)) {
        	
            return 0;
        }
        
        int filled = capacity - fluid.getAmount();

        if (resource.getAmount() < filled) {
        	
            fluid.grow(resource.getAmount());
            filled = resource.getAmount();
        }
        
        else {
        	
            fluid.setAmount(capacity);
        }
        
        if (filled > 0)
            onContentsChanged();
        
        return filled;
    }

    @Nonnull
    @Override
    public FluidStack drain(FluidStack resource, FluidAction action) {
    	
        if (resource.isEmpty() || !resource.isFluidEqual(fluid)) {
        	
            return FluidStack.EMPTY;
        }
        
        return drain(resource.getAmount(), action);
    }

    @Nonnull
    @Override
    public FluidStack drain(int maxDrain, FluidAction action) {
    	
        int drained = maxDrain;
        
        if (fluid.getAmount() < drained) {
        	
            drained = fluid.getAmount();
        }
        
        FluidStack stack = new FluidStack(fluid, drained);
        
        if (action.execute() && drained > 0) {
        	
            fluid.shrink(drained);
            onContentsChanged();
        }
        
        return stack;
    }

    protected void onContentsChanged() {}

    public void setFluid(FluidStack stack) {
    	
        this.fluid = stack;
    }

    public boolean isEmpty() {
    	
        return fluid.isEmpty();
    }

    public int getSpace() {
    	
        return Math.max(0, capacity - fluid.getAmount());
    }
    
    //From this point on are Mechanicraft additions
	public int upgradedCapacity(int capacityUpgrade) {
		
		int setMaxCapacity;
		
		if(baseCapacity != 0 && baseCapacity != upgradedCapacity && capacityUpgrade > 0) {
			
			setMaxCapacity = (int)Math.round(baseCapacity * (capacityUpgrade * 1.10));
			upgradedCapacity = setMaxCapacity;
			
			onContentsChanged();
			
			return upgradedCapacity;
			
		} else {
			
			upgradedCapacity = baseCapacity;
		}
		
		onContentsChanged();
		return upgradedCapacity;
	}
	
	public void applyCapacityUpgrades(int capacityUpgrade) {
		
        setCapacity(upgradedCapacity(capacityUpgrade));
        onContentsChanged();
    }
	
    private int getFluidCapacity() {
    	
    	int cap;
    	
    	if(upgradedCapacity > 0) {
    		
    		cap = upgradedCapacity;
    		onContentsChanged();
    		return cap;
    		
		} else if(capacity != baseCapacity && upgradedCapacity <= 0) {
			
			cap = baseCapacity;
			onContentsChanged();
			return cap;
		}
    	
    	return baseCapacity;
    }
    
    public int getBaseCapacity() {
		
		return baseCapacity;
	}
	
	public int getUpgradedCapacity() {
		
		return upgradedCapacity;
	}
}