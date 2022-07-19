package com.github.will11690.mechanicraft.blocks.machines.tier1.t1slurryprocessor;

import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.blocks.machines.common.slots.SlotEnergyItem;
import com.github.will11690.mechanicraft.network.packet.PacketHandler;
import com.github.will11690.mechanicraft.network.packet.slurryprocesor.energy.ClientboundSlurryEnergyPacket;
import com.github.will11690.mechanicraft.network.packet.slurryprocesor.input1.ClientboundSlurryInput1Packet;
import com.github.will11690.mechanicraft.network.packet.slurryprocesor.input2.ClientboundSlurryInput2Packet;
import com.github.will11690.mechanicraft.network.packet.slurryprocesor.output.ClientboundSlurryOutputPacket;
import com.github.will11690.mechanicraft.util.handlers.ContainerTypeHandler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.PacketDistributor.PacketTarget;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class ContainerT1SlurryProcessor extends Container {
	
	private final IItemHandler playerInventory;
	private PlayerEntity player;
    private IItemHandler handler;
    private IIntArray fields;
    private TileEntityT1SlurryProcessor tile;
    private int energyStored;
    private int energyCapacity;
    private FluidStack input1;
    private int input1Capacity;
    private FluidStack input2;
    private int input2Capacity;
    private FluidStack output;
    private int outputCapacity;

    public ContainerT1SlurryProcessor(int id, PlayerInventory playerInventory, PacketBuffer exData) {
    	
    	this((TileEntityT1SlurryProcessor) playerInventory.player.level.getBlockEntity(exData.readBlockPos()), new IntArray(2), id, playerInventory, new ItemStackHandler(2));
    	
    }
    
    public ContainerT1SlurryProcessor(@Nullable TileEntityT1SlurryProcessor tile, IIntArray fields, int id, PlayerInventory playerInventory, IItemHandler iItemHandler) {
    	
        super(ContainerTypeHandler.CONTAINER_T1_SLURRY_PROCESSOR.get(), id);
        
        this.handler = iItemHandler;
        this.fields = fields;
        this.tile = tile;
        this.player = playerInventory.player;
        this.playerInventory = new InvWrapper(playerInventory);
        
        this.energyStored = 0;
        this.energyCapacity = 0;
        this.input1 = FluidStack.EMPTY;
        this.input1Capacity = 0;
        this.input2 = FluidStack.EMPTY;
        this.input2Capacity = 0;
        this.output = FluidStack.EMPTY;
        this.outputCapacity = 0;
        
        layoutPlayerInventorySlots(8, 86);
        
        this.addSlot(new SlotEnergyItem(this.handler, 0, 8, 55));

        this.addSlot(new SlotItemHandler(this.handler, 1, 103, 32) {
        	
            @Override
            public boolean mayPlace(ItemStack stack) {
            	
                return false;
                
            }
        });
        
        this.addDataSlots(fields);
    }
    
    private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
        
    	for (int i = 0; i < amount; i++) {
        	
            addSlot(new SlotItemHandler(handler, index, x, y-2));
            x += dx;
            index++;
            
        }

        return index;
        
    }

    private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        
    	for (int j = 0; j < verAmount; j++) {
        	
            index = addSlotRange(handler, index, x, y, horAmount, dx);
            y += dy;
            
        }

        return index;
        
    }

    private void layoutPlayerInventorySlots(int leftCol, int topRow) {
    	
        addSlotBox(playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);

        topRow += 58;
        addSlotRange(playerInventory, 0, leftCol, topRow, 9, 18);
        
    }
    
    private IEnergyStorage getEnergy() {
    	
    	return tile.getCapability(CapabilityEnergy.ENERGY, Direction.DOWN).orElse(null);
    }
    
    private IFluidHandler getFluid1() {
    	//INPUT 1
    	return tile.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, tile.getBlockState().getValue(T1SlurryProcessor.FACING).getClockWise()).orElse(null);
    }
    
    private IFluidHandler getFluid2() {
    	//INPUT 2
    	return tile.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, tile.getBlockState().getValue(T1SlurryProcessor.FACING).getCounterClockWise()).orElse(null);
    }
    
    private IFluidHandler getFluid3() {
    	//OUTPUT
    	return tile.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, tile.getBlockState().getValue(T1SlurryProcessor.FACING).getOpposite()).orElse(null);
    }
    
    @Override
    public void broadcastChanges() {
    	super.broadcastChanges();
    	if((player instanceof ServerPlayerEntity) && !(player instanceof FakePlayer)) {
			
			PacketTarget target = PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player);
			ClientboundSlurryEnergyPacket messageEnergy = new ClientboundSlurryEnergyPacket(this.energyStored, this.energyCapacity, tile.getBlockPos(), player.getUUID());
			ClientboundSlurryInput1Packet messageInput1 = new ClientboundSlurryInput1Packet(this.input1, this.input1Capacity, tile.getBlockPos(), player.getUUID());
			ClientboundSlurryInput2Packet messageInput2 = new ClientboundSlurryInput2Packet(this.input2, this.input2Capacity, tile.getBlockPos(), player.getUUID());
			ClientboundSlurryOutputPacket messageOutput = new ClientboundSlurryOutputPacket(this.output, this.outputCapacity, tile.getBlockPos(), player.getUUID());
			
			int newEnergyStored = getEnergy().getEnergyStored();
			int newEnergyCapacity = getEnergy().getMaxEnergyStored();
			
			//INPUT 1
			FluidStack newFluidStack1 = getFluid1().getFluidInTank(0).copy();
			int newFluid1Capacity = getFluid1().getTankCapacity(0);
			
			//INPUT 2
			FluidStack newFluidStack2 = getFluid2().getFluidInTank(0).copy();
			int newFluid2Capacity = getFluid2().getTankCapacity(0);
			
			//OUTPUT
			FluidStack newFluidStack3 = getFluid3().getFluidInTank(0).copy();
			int newFluid3Capacity = getFluid3().getTankCapacity(0);
			
			if(getEnergy() != null) {
				
				PacketHandler.INSTANCE_SLURRY_ENERGY.send(target, messageEnergy);
				this.energyStored = newEnergyStored;
				this.energyCapacity = newEnergyCapacity;
			}
			
			if(!getFluid1().equals(null)) {
				
				PacketHandler.INSTANCE_SLURRY_INPUT1.send(target, messageInput1);
				this.input1 = newFluidStack1;
				this.input1Capacity = newFluid1Capacity;
			}
			
			if(!getFluid2().equals(null)) {
				
				PacketHandler.INSTANCE_SLURRY_INPUT2.send(target, messageInput2);
				this.input2 = newFluidStack2;
				this.input2Capacity = newFluid2Capacity;
			}
			
			if(!getFluid3().equals(null)) {
				
				PacketHandler.INSTANCE_SLURRY_OUTPUT.send(target, messageOutput);
				this.output = newFluidStack3;
				this.outputCapacity = newFluid3Capacity;
			}
		}
    }
	
	public int setEnergyStored(int energyStored) {
		
       return this.energyStored = energyStored;
    }

    public int setEnergyCapacity(int energyCapacity) {
    	
        return this.energyCapacity = energyCapacity;
    }

    public FluidStack setInputFluid1(FluidStack input1) {
    	
    	if(!input1.equals(null)) {
    	
    		return this.input1 = input1;
    	}
    	
    	return this.input1 = FluidStack.EMPTY;
    }

    public int setInput1Capacity(int input1Capacity) {
    	
        return this.input1Capacity = input1Capacity;
    }

    public FluidStack setInputFluid2(FluidStack input2) {
    	
    	if(!input2.equals(null)) {
    	
    		return this.input2 = input2;
    	}
    	
    	return this.input2 = FluidStack.EMPTY;
    }

    public int setInput2Capacity(int input2Capacity) {
    	
        return this.input2Capacity = input2Capacity;
    }

    public FluidStack setOutputFluid(FluidStack output) {
    	
    	if(!output.equals(null)) {
    	
    		return this.output = output;
    	}
    	
    	return this.output = FluidStack.EMPTY;
    }

    public int setOutputCapacity(int outputCapacity) {
    	
        return this.outputCapacity = outputCapacity;
    }

    public int getProgress() {
    	
		return this.fields.get(0);
		
	}
    
    public int getMaxProgress() {
    	
    	return this.fields.get(1);
    	
    }

	public int getProgressionScaled() {
		
		int cookProgress = this.getProgress();
		int cookTimeForRecipe = this.fields.get(1);
		return cookTimeForRecipe != 0 && cookProgress != 0 ? cookProgress * 24 / cookTimeForRecipe : 0;
		
	}
	
	public int getEnergyStored() {
		
       return this.energyStored;
    }

    public int getEnergyCapacity() {
    	
        return this.energyCapacity;
    }

    public FluidStack getInputFluid1() {
    	
    	return this.input1;
    }

    public int getInput1Capacity() {
    	
        return this.input1Capacity;
    }

    public FluidStack getInputFluid2() {
    	
    	return this.input2;
    }

    public int getInput2Capacity() {
    	
        return this.input2Capacity;
    }
    public FluidStack getOutputFluid() {
    	
    	return this.output;
    }

    public int getOutputCapacity() {
    	
        return this.outputCapacity;
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
    	
    	BlockPos pos = this.tile.getBlockPos();
        return this.tile != null && !this.tile.isRemoved() && player.distanceToSqr(new Vector3d(pos.getX(), pos.getY(), pos.getZ()).add(0.5D, 0.5D, 0.5D)) <= 64D;
        
    }

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 2;  //must match TileEntityInventoryBasic.NUMBER_OF_SLOTS

    @Override
    public ItemStack quickMoveStack(PlayerEntity playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT - 1, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }
}