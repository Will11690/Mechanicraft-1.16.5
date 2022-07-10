package com.github.will11690.mechanicraft.blocks.machines.tier1.t1energycube;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.init.ModConfigs;
import com.github.will11690.mechanicraft.init.ModItems;
import com.github.will11690.mechanicraft.util.handlers.NonExtractableStackHandler;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

public class TileEntityT1EnergyCube extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
	
	public ItemStackHandler upgradeSlotHandler = createUpgrade();
    private ItemStackHandler upgradeSlotHandlerWrapper = createUpgradeWrapper(upgradeSlotHandler);
    private ItemStackHandler chargeSlotsHandler = createCharge();
    private MechaniCraftEnergyStorage energyStorage = createEnergy();
    
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
    public LazyOptional<IItemHandler> chargeSlots  = LazyOptional.of(() -> chargeSlotsHandler);
    private LazyOptional<IItemHandler> upgradeSlotWrapper  = LazyOptional.of(() -> upgradeSlotHandlerWrapper);
    
    private final LazyOptional<IItemHandler> allSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotsHandler, upgradeSlotHandlerWrapper));
	
	private final LazyOptional<IItemHandler> dropSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotsHandler));
	boolean breakBlock = false;
    
    private static int capacity = ModConfigs.t1EnergyCubeCapacityInt;
    private static int transfer = ModConfigs.t1EnergyCubeTransferInt;

    private final IIntArray fields = new IIntArray() {
    	
        @Override
        public int get(int index) {
        	
            switch (index) {
            
                case 0:
                	return energyStorage.getEnergyStored();
                case 1:
                	return energyStorage.getCapacity();
                case 2:
                	return energyStorage.getBaseCapacity();
                default:
                    return 0;
                    
            }
        }

        @Override
        public void set(int index, int value) {
        	
            switch (index) {
            
                case 0:
                	energyStorage.setEnergy(value);
                    break;
                case 1:
                	energyStorage.setCapacity(value);
                    break;
                case 2:
                	energyStorage.setBaseCapacity(value);
                    break;
                default:
                	break;
                    
            }
        }

        @Override
        public int getCount() {
        	
            return 2;
            
        }
    };
    
    private MechaniCraftEnergyStorage createEnergy() {
    	
        return new MechaniCraftEnergyStorage(capacity, transfer) {
        	
            @Override
            protected void onEnergyChanged() {
            	
                setChanged();
            }
        };
    }
    
    private ItemStackHandler createCharge() {
    	
    	return new ItemStackHandler(2) {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }
    		
    		@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

				if(stack.getCapability(CapabilityEnergy.ENERGY).isPresent()) {

					return true;

				}

				return false;
				
			}
		};
    }

	private ItemStackHandler createUpgrade() {

    	return new ItemStackHandler() {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }
    		
    		@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

    			Item item = stack.getItem();
				
				if(item.equals(ModItems.CAPACITY_UPGRADE.get()) || item.equals(ModItems.TRANSFER_UPGRADE.get())) {
					
					return true;
					
				}

				return false;
				
			}
    		
    		@Override
    		@Nonnull
    		public ItemStack extractItem(int slot, int amount, boolean simulate) {
    			
    			if(energyStorage.getEnergyStored() > energyStorage.getBaseCapacity()) {
    				
    				return ItemStack.EMPTY;
    				
    			} else
    			 	
    				return super.extractItem(slot, amount, simulate);
    		 }
		};
		
    }
	
	private ItemStackHandler createUpgradeWrapper(ItemStackHandler upgradeSlotHandler) {

    	return new NonExtractableStackHandler(this.upgradeSlotHandler) {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }
    		
    		@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
    			
    			Item item = stack.getItem();
				
				if(item.equals(ModItems.CAPACITY_UPGRADE.get()) || item.equals(ModItems.TRANSFER_UPGRADE.get())) {

					return true;
					
				}

				return false;
				
			}
    		
    		@Override
    		@Nonnull
    		public ItemStack extractItem(int slot, int amount, boolean simulate) {
    			
    			if(energyStorage.getEnergyStored() > energyStorage.getBaseCapacity()) {
    				
    				return ItemStack.EMPTY;
    				
    			} else
    			 	
    				return super.extractItem(slot, amount, simulate);
    		 }
		};
    }

    public TileEntityT1EnergyCube() {
    	
        super(TileEntityHandler.TILE_ENTITY_T1_ENERGY_CUBE.get());
        
    }

	@Override
    public void tick() {
    	
        if (this.level == null || this.level.isClientSide) {
        	
            return;
            
        }
        	
        ItemStack chargeStack1 = chargeSlotsHandler.getStackInSlot(0);
        ItemStack chargeStack2 = chargeSlotsHandler.getStackInSlot(1);
        ItemStack upgradeStack = upgradeSlotHandler.getStackInSlot(0);
    	
        if(hasCapUpgrades() && energyStorage.getCapacity() != energyStorage.getUpgradedCapacity()) {
        	
        	if(upgradeStack.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
        		
        		applyCapUpgrades(upgradeStack);
        		
        	}
        }
        
        if(hasTransUpgrades() && (energyStorage.getMaxExtract() != energyStorage.getUpgradedExtract()) &&
        						 (energyStorage.getMaxReceive() != energyStorage.getUpgradedReceive())) {
        	
        	if(upgradeStack.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
        		
        		applyTransUpgrades(upgradeStack);
        		
        	}
        }
        
        if(!hasCapUpgrades() && energyStorage.getCapacity() != energyStorage.getBaseCapacity()) {
        	
        	energyStorage.setCapacity(energyStorage.getBaseCapacity());
        	
        }
        
        if(!hasTransUpgrades() && (energyStorage.getMaxExtract() != energyStorage.getBaseExtract()) &&
        						  (energyStorage.getMaxReceive() != energyStorage.getBaseReceive())) {
        	
        	energyStorage.setMaxExtract(energyStorage.getBaseExtract());
        	energyStorage.setMaxReceive(energyStorage.getBaseReceive());
        	
        }
        
        if(energyStorage.getEnergyStored() < energyStorage.getCapacity()) {
        		
        	if(!chargeStack2.isEmpty()) {
        			
        		receivePowerItem(chargeStack2);
        			
        	}
        }
        	
        if(hasEnergy()) {
        		
        	if(!chargeStack1.isEmpty()) {
        			
        		sendPowerItem(chargeStack1);
        			
        	}
        		
        	sendPower();
        		
        }
        
    }
	
	private boolean hasTransUpgrades() {
    	
    	if(upgradeSlotHandler.getStackInSlot(0).getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
    		
    		return true;
    		
    	}
    	
    	return false;
    	
    }
    
    public boolean hasCapUpgrades() {
    	
    	if(upgradeSlotHandler.getStackInSlot(0).getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    		
    		return true;
    		
    	}
    	
    	return false;
    	
    }

	private void applyCapUpgrades(ItemStack stack) {
    		
    	if(stack.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    		
    		energyStorage.applyCapacityUpgrades(stack.getCount());
    		
    	}
    }
    
    private void applyTransUpgrades(ItemStack stack) {
    		
    	if(stack.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
    		
    		energyStorage.applyTransferUpgrades(stack.getCount());
    		
    	}
    }
	
	private void receivePower() {
		
        AtomicInteger energy = new AtomicInteger(energyStorage.getEnergyStored());
        
        if(energy.get() < energyStorage.getCapacity()) {
        	
            for(Direction direction : Direction.values()) {
            	
                TileEntity te = level.getBlockEntity(worldPosition.relative(direction));
                
                if(te != null) {
                	
                    boolean doContinue = te.getCapability(CapabilityEnergy.ENERGY, direction).map(handler -> {
                    	
                        if(handler.canExtract() ) {
                                	
                            int extracted = handler.extractEnergy(Math.min(handler.getEnergyStored(), energyStorage.getMaxReceive()), false);
                            energy.addAndGet(extracted);
                            energyStorage.receiveEnergy(extracted, false);
                            setChanged();
                                    
                            return energy.get() > 0;
                                    
                            } else {
                                	
                                return true;
                                
                            }
                                
                        }).orElse(true);
                    
                    if(!doContinue) {
                    	
                        return;
                    }
                }
            }
        }
    }
	
	private void receivePowerItem(ItemStack stack) {
		
		AtomicInteger energy = new AtomicInteger(energyStorage.getEnergyStored());
        
		if(energy.get() < energyStorage.getCapacity()) {
                
			if(stack.getCapability(CapabilityEnergy.ENERGY).isPresent()) {
                	
				boolean doContinue = stack.getCapability(CapabilityEnergy.ENERGY).map(handler -> {
                    	
					if(handler.canReceive()) {
                                	
						int extracted = handler.extractEnergy(handler.getEnergyStored(), false);
                        energy.addAndGet(extracted);
                        energyStorage.addEnergy(extracted);
                        setChanged();
                                    
						return energy.get() > 0;
                                    
					} else {
                                	
						return true;
					}
					
				}).orElse(true);
                    
				if(!doContinue) {
                    	
					return;
                   
				}
			}
        }
    }
    
    private boolean hasEnergy() {
    	
    	if(energyStorage.getEnergyStored() > 0) {
    		
    		return true;
    		
    	} else {
    		
    		return false;
    		
    	}
    	
    }
    
	private void sendPower() {
		
        AtomicInteger energy = new AtomicInteger(energyStorage.getEnergyStored());
        
        if(energy.get() > 0) {
        	
            for(Direction direction : Direction.values()) {
            	
                TileEntity te = level.getBlockEntity(worldPosition.relative(direction));
                
                if(te != null) {
                	
                    boolean doContinue = te.getCapability(CapabilityEnergy.ENERGY, direction).map(handler -> {
                    	
                        if(handler.canReceive()) {
                                	
                            int received = handler.receiveEnergy(Math.min(energy.get(), energyStorage.getMaxExtract()), false);
                            energy.addAndGet(-received);
                            energyStorage.extractEnergy(received, false);
                            setChanged();
                                    
                            return energy.get() > 0;
                                    
                            } else {
                                	
                                return true;
                                
                            }
                                
                        }).orElse(true);
                    
                    if(!doContinue) {
                    	
                        return;
                    }
                }
            }
        }
    }
	
	private void sendPowerItem(ItemStack stack) {
		
		AtomicInteger energy = new AtomicInteger(energyStorage.getEnergyStored());
        
		if(energy.get() > 0) {
                
			if(stack.getCapability(CapabilityEnergy.ENERGY).isPresent()) {
                	
				boolean doContinue = stack.getCapability(CapabilityEnergy.ENERGY).map(handler -> {
                    	
					if(handler.canReceive()) {
                                	
						int received = handler.receiveEnergy(energy.get(), false);
						energy.addAndGet(-received);
						energyStorage.consumeEnergy(received);
						setChanged();
                                    
						return energy.get() > 0;
                                    
					} else {
                                	
						return true;
					}
					
				}).orElse(true);
                    
				if(!doContinue) {
                    	
					return;
                   
				}
			}
        }
    }
    
    @Nullable
    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        assert level != null;
        return new ContainerT1EnergyCube(this, this.fields, id, playerInventory, new CombinedInvWrapper(chargeSlotsHandler, upgradeSlotHandler));
    }

    @Override
    public void load(BlockState state, CompoundNBT tags) {
    	
        super.load(state, tags);
        this.energyStorage.deserializeNBT(tags.getCompound("energy"));
		this.chargeSlotsHandler.deserializeNBT(tags.getCompound("chargeSlots"));
		this.upgradeSlotHandler.deserializeNBT(tags.getCompound("upgradeSlot"));
        
    }

    @Override
    public CompoundNBT save(CompoundNBT tags) {
    	
        super.save(tags);
        tags.put("energy", energyStorage.serializeNBT());
		tags.put("chargeSlots", chargeSlotsHandler.serializeNBT());
		tags.put("upgradeSlot", upgradeSlotHandler.serializeNBT());
        return tags;
        
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
    	
        CompoundNBT tags = this.getUpdateTag();
        return new SUpdateTileEntityPacket(this.worldPosition, 1, tags);
    }
    
    @Override
    public CompoundNBT getUpdateTag() {
    	
        return save(new CompoundNBT());
    }

    @Override
    public void handleUpdateTag(BlockState stateIn, CompoundNBT tag) {
    	
        load(stateIn, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
    	
        load(this.getBlockState(), pkt.getTag());
    }

	boolean blockBeingBroken(boolean onRemoved) {
		
		return breakBlock = onRemoved;
	}

    @Nullable
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
    	
    	if(!this.remove && side != null) {
    	
    		if (cap == CapabilityEnergy.ENERGY) {
    		
    			return energy.cast();
            
    		}
    	
    		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
        	
    			return allSlots.cast();
            
    		}
    		
    	} else if(breakBlock == true && side == null) {

			if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
				
				return dropSlots.cast();
			}
		}
        
		return super.getCapability(cap, side);
    }

    @Override
    public void setRemoved() {
    	
        energy.invalidate();
		chargeSlots.invalidate();
		upgradeSlotWrapper.invalidate();
		allSlots.invalidate();
		dropSlots.invalidate();
        super.setRemoved();
        
    }

	@Override
	public ITextComponent getDisplayName() {
		
		return new TranslationTextComponent("container.mechanicraft.t1_energy_cube");
		
	}
}