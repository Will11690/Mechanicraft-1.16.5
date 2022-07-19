package com.github.will11690.mechanicraft.blocks.machines.basic.basicinfuser;

import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.network.packet.PacketHandler;
import com.github.will11690.mechanicraft.network.packet.energy.ClientboundBurnTimePacket;
import com.github.will11690.mechanicraft.util.handlers.ContainerTypeHandler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.PacketDistributor.PacketTarget;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class ContainerBasicMetallicInfuser extends Container {
	
	private final IItemHandler playerInventory;
	private PlayerEntity player;
    private IItemHandler handler;
    private IIntArray fields;
    private TileEntityBasicMetallicInfuser tile;
    private int burnTime;
    private int totalBurnTime;

    public ContainerBasicMetallicInfuser(int id, PlayerInventory playerInventory, PacketBuffer exData) {
    	
    	this((TileEntityBasicMetallicInfuser) playerInventory.player.level.getBlockEntity(exData.readBlockPos()), new IntArray(1), id, playerInventory, new ItemStackHandler(4));
    	
    }
    
    public ContainerBasicMetallicInfuser(@Nullable TileEntityBasicMetallicInfuser tile, IIntArray fields, int id, PlayerInventory playerInventory, IItemHandler iItemHandler) {
    	
        super(ContainerTypeHandler.CONTAINER_BASIC_METALLIC_INFUSER.get(), id);
        
    	this.handler = iItemHandler;
        this.fields = fields;
        this.tile = tile;
        this.player = playerInventory.player;
        this.playerInventory = new InvWrapper(playerInventory);
        
        this.burnTime = 0;
        this.totalBurnTime = 0;
        
        layoutPlayerInventorySlots(8, 86);

        this.addSlot(new SlotItemHandler(this.handler, 0, 30, 20) {
        	
            @Override
            public boolean mayPlace(ItemStack stack) {
            	
            	if(TileEntityBasicMetallicInfuser.isRecipeInput1(tile.getLevel(), stack)) {
            		
            		return true;
            		
            	}
            	
                return false;
                
            }
        });
        
        this.addSlot(new SlotItemHandler(this.handler, 1, 58, 20) {
        	
            @Override
            public boolean mayPlace(ItemStack stack) {
            	
            	if(TileEntityBasicMetallicInfuser.isRecipeInput2(tile.getLevel(), stack)) {
            		
            		return true;
            		
            	}
            	
                return false;
                
            }
        });
        
        this.addSlot(new SlotItemHandler(this.handler, 2, 44, 53) {
        	
            @SuppressWarnings("deprecation")
			@Override
            public boolean mayPlace(ItemStack stack) {
            	
            	if(ForgeHooks.getBurnTime(stack) != 0 || stack.getItem().equals(Items.BUCKET)) {
            		
            		return true;
            		
            	} else {
            			
            			return false;
            			
            	}
            }
        });
        
        this.addSlot(new SlotItemHandler(this.handler, 3, 124, 35) {
        	
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
    
    private int getBurn() {
    	
    	return tile.burnTime;
    }
    
    private int getTotalBurn() {
    	
    	return tile.totalBurnTime;
    }
    
    @Override
    public void broadcastChanges() {
    	super.broadcastChanges();
    	if((player instanceof ServerPlayerEntity) && !(player instanceof FakePlayer)) {
    		
    		PacketTarget target = PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player);
    		ClientboundBurnTimePacket messageBurn = new ClientboundBurnTimePacket(this.burnTime, this.totalBurnTime, tile.getBlockPos(), player.getUUID());
    		
    		int newBurnTime = getBurn();
			int newTotalBurnTime = getTotalBurn();
    		
			if(getBurn() > -1 || getTotalBurn() > -1) {
				
				PacketHandler.INSTANCE_BURN_TIME.send(target, messageBurn);
				this.burnTime = newBurnTime;
				this.totalBurnTime = newTotalBurnTime;
			}
    	}
    }
    
    public int setBurnTime(int burnTime) {
    	
    	return this.burnTime = burnTime;
    }
    
    public int setTotalBurnTime(int totalBurnTime) {
    	
    	return this.totalBurnTime = totalBurnTime;
    }

	public int getMaxProgress() {
		
		return TileEntityBasicMetallicInfuser.WORK_TIME;
		
	}
	
	public int getProgress() {
		
		return this.fields.get(0);
	}

	public int getProgressionScaled() {
		
		int cookProgress = this.getProgress();
		int cookTimeForRecipe = TileEntityBasicMetallicInfuser.WORK_TIME;
		return cookTimeForRecipe != 0 && cookProgress != 0 ? cookProgress * 24 / cookTimeForRecipe : 0;
		
	}
    
    public int getBurnTime() {
    	
    	return this.burnTime;
    }
    
    public int getTotalBurnTime() {
    	
    	return this.totalBurnTime;
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