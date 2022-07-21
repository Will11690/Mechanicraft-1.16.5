package com.github.will11690.mechanicraft.fluid;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nonnull;

import com.github.will11690.mechanicraft.init.ModItems;

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
        this.capacity = capacity;
        this.validator = validator;
    }

    public MechanicraftFluidTank setCapacity(int capacity) {
    	
        this.capacity = capacity;
        
        if(fluid.getAmount() > capacity) {
        	
        	fluid.setAmount(capacity);
        }
        
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
    public void upgradeCapacity(ItemStack stack1, ItemStack stack2, ItemStack stack3, ItemStack stack4) {
    	
    	int stack1Count = 0;
    	int stack2Count = 0;
    	int stack3Count = 0;
    	int stack4Count = 0;
    	
    	int totalCount = 0;
    	
    	if(!stack1.isEmpty() && stack1.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    		
    		stack1Count = stack1.getCount();
    	}
    	
    	if(!stack2.isEmpty() && stack2.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    		
    		stack2Count = stack2.getCount();
    	}
    	
    	if(!stack3.isEmpty() && stack3.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    		
    		stack3Count = stack3.getCount();
    	}
    	
    	if(!stack4.isEmpty() && stack4.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    		
    		stack4Count = stack4.getCount();
    	}
    	
    	totalCount = stack1Count + stack2Count + stack3Count + stack4Count;
    	
    	if(totalCount > 0) {
    		
    		applyCapacityUpgrades(totalCount);
    		onContentsChanged();
    	}
    }
    
	public int upgradedCapacity(int capacityUpgrade) {
		
		int setMaxCapacity;
		
		if(baseCapacity != 0 && capacityUpgrade > 0) {
			double modify = (baseCapacity * 0.10) * capacityUpgrade;
			setMaxCapacity = (int)(baseCapacity + modify);
			upgradedCapacity = setMaxCapacity;
			
			return upgradedCapacity;
		}
		
		return baseCapacity;
	}
	
	public void applyCapacityUpgrades(int capacityUpgrade) {
		
        setCapacity(upgradedCapacity(capacityUpgrade));
        onContentsChanged();
    }
    
    public int getBaseCapacity() {
		
		return baseCapacity;
	}
	
	public int getUpgradedCapacity() {
		
		return upgradedCapacity;
	}
}