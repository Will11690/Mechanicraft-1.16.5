package com.github.will11690.mechanicraft.blocks.machines.tier1.t1crusher;

import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.blocks.machines.common.slots.SlotEnergyItem;
import com.github.will11690.mechanicraft.network.packet.PacketHandler;
import com.github.will11690.mechanicraft.network.packet.burntime.ClientboundEnergyPacket;
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
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.PacketDistributor.PacketTarget;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class ContainerT1Crusher  extends Container {
	
	private final IItemHandler playerInventory;
	private PlayerEntity player;
    private IItemHandler handler;
    private IIntArray fields;
    private TileEntityT1Crusher tile;
    private int energyStored;
    private int energyCapacity;

    public ContainerT1Crusher(int id, PlayerInventory playerInventory, PacketBuffer exData) {
    	
        this((TileEntityT1Crusher) playerInventory.player.level.getBlockEntity(exData.readBlockPos()), new IntArray(2), id, playerInventory, new ItemStackHandler(4));
        
    }

    public ContainerT1Crusher(@Nullable TileEntityT1Crusher tile, IIntArray fields, int id, PlayerInventory playerInventory, IItemHandler iItemHandler) {
    	
        super(ContainerTypeHandler.CONTAINER_T1_CRUSHER.get(), id);

        this.handler = iItemHandler;
        this.fields = fields;
        this.tile = tile;
        this.player = playerInventory.player;
        this.playerInventory = new InvWrapper(playerInventory);
        
        this.energyStored = 0;
        this.energyCapacity = 0;
        
        layoutPlayerInventorySlots(8, 86);

        this.addSlot(new SlotEnergyItem(this.handler, 0, 8, 55));
        this.addSlot(new SlotItemHandler(this.handler, 1, 50, 32) {
        	
        	@Override
        	public boolean mayPlace(ItemStack stack) {
        		
        		if(TileEntityT1Crusher.isRecipeInput(tile.getLevel(), stack)) {
        			
        			return true;
        			
        		}
        		
        		else return false;
        		
        	}
        		
    });
        
        this.addSlot(new SlotItemHandler(this.handler, 2, 116, 32) {
        	
            @Override
            public boolean mayPlace(ItemStack output) {
            	
                return false;
                
            }
        });
        
        this.addSlot(new SlotItemHandler(this.handler, 3, 116, 56) {
        	
            @Override
            public boolean mayPlace(ItemStack secondaryOutput) {
            	
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
    
    @Override
    public void broadcastChanges() {
    	super.broadcastChanges();
    	if((player instanceof ServerPlayerEntity) && !(player instanceof FakePlayer)) {
    		
    		PacketTarget target = PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player);
    		ClientboundEnergyPacket messageEnergy = new ClientboundEnergyPacket(this.energyStored, this.energyCapacity, tile.getBlockPos(), player.getUUID());
			
			int newEnergyStored = getEnergy().getEnergyStored();
			int newEnergyCapacity = getEnergy().getMaxEnergyStored();
			
			if(getEnergy() != null) {
				
				PacketHandler.INSTANCE_ENERGY.send(target, messageEnergy);
				this.energyStored = newEnergyStored;
				this.energyCapacity = newEnergyCapacity;
			}
    	}
    }
	
	public int setEnergyStored(int energyStored) {
		
       return this.energyStored = energyStored;
    }

    public int setEnergyCapacity(int energyCapacity) {
    	
        return this.energyCapacity = energyCapacity;
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
    private static final int TE_INVENTORY_SLOT_COUNT = 4;  //must match TileEntityInventoryBasic.NUMBER_OF_SLOTS

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
                    + TE_INVENTORY_SLOT_COUNT - 2, false)) {
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