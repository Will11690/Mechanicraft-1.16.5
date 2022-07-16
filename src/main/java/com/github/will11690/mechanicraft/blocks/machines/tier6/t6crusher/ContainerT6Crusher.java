package com.github.will11690.mechanicraft.blocks.machines.tier6.t6crusher;

import java.util.Optional;

import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.blocks.machines.common.slots.SlotEnergyItem;
import com.github.will11690.mechanicraft.blocks.machines.common.slots.SlotUpgrade;
import com.github.will11690.mechanicraft.init.ModItems;
import com.github.will11690.mechanicraft.recipes.Crusher.CrusherRecipes;
import com.github.will11690.mechanicraft.util.handlers.ContainerTypeHandler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class ContainerT6Crusher  extends Container {
	
	private final IItemHandler playerInventory;
    private IItemHandler handler;
    private IIntArray fields;
    private TileEntityT6Crusher tile;

    public ContainerT6Crusher(int id, PlayerInventory playerInventory, PacketBuffer exData) {
    	
        this((TileEntityT6Crusher) playerInventory.player.level.getBlockEntity(exData.readBlockPos()), new IntArray(4), id, playerInventory, new ItemStackHandler(8));
        
    }

    public ContainerT6Crusher(@Nullable TileEntityT6Crusher tile, IIntArray fields, int id, PlayerInventory playerInventory, IItemHandler iItemHandler) {
    	
        super(ContainerTypeHandler.CONTAINER_T6_CRUSHER.get(), id);

        this.handler = iItemHandler;
        this.fields = fields;
        this.tile = tile;
        this.playerInventory = new InvWrapper(playerInventory);
        layoutPlayerInventorySlots(8, 86);

        this.addSlot(new SlotEnergyItem(this.handler, 0, 8, 55));
        this.addSlot(new SlotItemHandler(this.handler, 1, 50, 32) {
        	
        	@Override
        	public boolean mayPlace(ItemStack input) {
        		
        		Optional<CrusherRecipes> recipe = TileEntityT6Crusher.getRecipeForInput(tile.getLevel(), input);
        		
        		if(recipe.isPresent() && !(ItemStack.matches(TileEntityT6Crusher.getResultForItem(tile.getLevel(), input), input))) {
        			
        			return true;
        			
        		}
        		
        		else return false;
        		
        	}
        		
    });
        
        this.addSlot(new SlotUpgrade(this.handler, 2, 152, 4) {
    	
    	@Override
        public boolean mayPickup(PlayerEntity playerIn) {
    		
    		if(tile.canExtractCapacity() == false && tile.upgradeSlotHandler.getStackInSlot(0).getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    			
    			return false;
    			
    		} else
    		
    		if((tile.upgradeSlotHandler.getStackInSlot(0).getItem().equals(ModItems.SPEED_UPGRADE.get()) || tile.upgradeSlotHandler.getStackInSlot(0).getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) 
    				&& canExtractSpeedorEfficiency() != true) {
    			
    			return false;
    			
    		} else 
    			
    			return super.mayPickup(playerIn);
        }
    });
        
        this.addSlot(new SlotUpgrade(this.handler, 3, 152, 24) {
    	
    	@Override
        public boolean mayPickup(PlayerEntity playerIn) {
    		
    		if(tile.canExtractCapacity() == false && tile.upgradeSlotHandler.getStackInSlot(1).getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    			
    			return false;
    			
    		} else
    		
    		if((tile.upgradeSlotHandler.getStackInSlot(1).getItem().equals(ModItems.SPEED_UPGRADE.get()) || tile.upgradeSlotHandler.getStackInSlot(1).getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) 
    				&& canExtractSpeedorEfficiency() != true) {
    			
    			return false;
    			
    		} else 
    			
    			return super.mayPickup(playerIn);
        }
    });
        
        this.addSlot(new SlotUpgrade(this.handler, 4, 152, 44) {
    	
    	@Override
        public boolean mayPickup(PlayerEntity playerIn) {
    		
    		if(tile.canExtractCapacity() == false && tile.upgradeSlotHandler.getStackInSlot(2).getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    			
    			return false;
    			
    		} else
    		
    		if((tile.upgradeSlotHandler.getStackInSlot(2).getItem().equals(ModItems.SPEED_UPGRADE.get()) || tile.upgradeSlotHandler.getStackInSlot(2).getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) 
    				&& canExtractSpeedorEfficiency() != true) {
    			
    			return false;
    			
    		} else 
    			
    			return super.mayPickup(playerIn);
        }
    });
        
        this.addSlot(new SlotUpgrade(this.handler, 5, 152, 64) {
    	
    	@Override
        public boolean mayPickup(PlayerEntity playerIn) {
    		
    		if(tile.canExtractCapacity() == false && tile.upgradeSlotHandler.getStackInSlot(2).getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    			
    			return false;
    			
    		} else
    		
    		if((tile.upgradeSlotHandler.getStackInSlot(2).getItem().equals(ModItems.SPEED_UPGRADE.get()) || tile.upgradeSlotHandler.getStackInSlot(2).getItem().equals(ModItems.EFFICIENCY_UPGRADE.get())) 
    				&& canExtractSpeedorEfficiency() != true) {
    			
    			return false;
    			
    		} else 
    			
    			return super.mayPickup(playerIn);
        }
    });
        
        this.addSlot(new SlotItemHandler(this.handler, 6, 116, 32) {
        	
            @Override
            public boolean mayPlace(ItemStack output) {
            	
                return false;
                
            }
        });
        
        this.addSlot(new SlotItemHandler(this.handler, 7, 116, 56) {
        	
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
    
    private boolean canExtractSpeedorEfficiency() {
    	
    	return tile.upgradeHandler.canExtractFromSlot(this.fields.get(1));
    }

    public int getProgress() {
    	
		return this.fields.get(1);
		
	}
    
    public int getMaxProgress() {
    	
    	return this.fields.get(3);
    	
    }

	public int getProgressionScaled() {
		
		int cookProgress = this.getProgress();
		int cookTimeForRecipe = this.fields.get(3);
		return cookTimeForRecipe != 0 && cookProgress != 0 ? cookProgress * 24 / cookTimeForRecipe : 0;
		
	}
	
	public int getEnergy() {
		
		return this.fields.get(0);
		
	}
	
	public int getCapacity() {
		
		return this.fields.get(2);
		
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
    private static final int TE_INVENTORY_SLOT_COUNT = 8;  //must match TileEntityInventoryBasic.NUMBER_OF_SLOTS

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