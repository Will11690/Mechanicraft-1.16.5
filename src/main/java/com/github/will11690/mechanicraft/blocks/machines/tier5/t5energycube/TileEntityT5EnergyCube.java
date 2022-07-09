package com.github.will11690.mechanicraft.blocks.machines.tier5.t5energycube;

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

public class TileEntityT5EnergyCube extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
	
	public ItemStackHandler upgradeSlotHandler = createUpgrade();
    private ItemStackHandler upgradeSlotHandlerWrapper = createUpgradeWrapper(upgradeSlotHandler);
    private ItemStackHandler chargeSlotsHandler = createCharge();
    private MechaniCraftEnergyStorage energyStorage = createEnergy();
    
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
    public LazyOptional<IItemHandler> chargeSlots  = LazyOptional.of(() -> chargeSlotsHandler);
    private LazyOptional<IItemHandler> upgradeSlotWrapper  = LazyOptional.of(() -> upgradeSlotHandlerWrapper);
    
    private final LazyOptional<IItemHandler> allSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotsHandler, upgradeSlotHandlerWrapper));
    
    private static final int capacity = ModConfigs.t5EnergyCubeCapacityInt;
    private static final int transfer = ModConfigs.t5InfuserReceiveInt;

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
    	
    	return new ItemStackHandler(10) {
    		
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

    	return new ItemStackHandler(3) {
    		
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

    public TileEntityT5EnergyCube() {
    	
        super(TileEntityHandler.TILE_ENTITY_T5_ENERGY_CUBE.get());
        
    }

	@Override
    public void tick() {
    	
        if (this.level == null || this.level.isClientSide) {
        	
            return;
            
        }
        	
        ItemStack chargeStack1 = chargeSlotsHandler.getStackInSlot(0);
        ItemStack chargeStack2 = chargeSlotsHandler.getStackInSlot(1);
        ItemStack chargeStack3 = chargeSlotsHandler.getStackInSlot(2);
        ItemStack chargeStack4 = chargeSlotsHandler.getStackInSlot(3);
        ItemStack chargeStack5 = chargeSlotsHandler.getStackInSlot(4);
        ItemStack chargeStack6 = chargeSlotsHandler.getStackInSlot(5);
        ItemStack chargeStack7 = chargeSlotsHandler.getStackInSlot(6);
        ItemStack chargeStack8 = chargeSlotsHandler.getStackInSlot(7);
        ItemStack chargeStack9 = chargeSlotsHandler.getStackInSlot(8);
        ItemStack chargeStack10 = chargeSlotsHandler.getStackInSlot(9);
        ItemStack upgradeStack1 = upgradeSlotHandler.getStackInSlot(0);
        ItemStack upgradeStack2 = upgradeSlotHandler.getStackInSlot(1);
        ItemStack upgradeStack3 = upgradeSlotHandler.getStackInSlot(2);
    	
        if(hasCapUpgrades() && energyStorage.getCapacity() != energyStorage.getUpgradedCapacity()) {
        	
        	if(upgradeStack1.getItem().equals(ModItems.CAPACITY_UPGRADE.get()) || upgradeStack2.getItem().equals(ModItems.CAPACITY_UPGRADE.get()) ||
        	   upgradeStack3.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
        		
        		applyCapUpgrades(upgradeStack1, upgradeStack2, upgradeStack3);
        		
        	}
        }
        
        if(hasTransUpgrades() && (energyStorage.getMaxExtract() != energyStorage.getUpgradedExtract()) &&
        						 (energyStorage.getMaxReceive() != energyStorage.getUpgradedReceive())) {
        	
        	if(upgradeStack1.getItem().equals(ModItems.TRANSFER_UPGRADE.get()) || upgradeStack2.getItem().equals(ModItems.TRANSFER_UPGRADE.get()) ||
               upgradeStack3.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
        		
        		applyTransUpgrades(upgradeStack1, upgradeStack2, upgradeStack3);
        		
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
        		
        	if(!chargeStack6.isEmpty()) {
        			
        		receivePowerItem(chargeStack6);
        			
        	}
        	
        	if(!chargeStack7.isEmpty()) {
    			
        		receivePowerItem(chargeStack7);
    			
        	}
    		
        	if(!chargeStack8.isEmpty()) {
    			
        		receivePowerItem(chargeStack8);
    			
        	}
    	
        	if(!chargeStack9.isEmpty()) {
			
        		receivePowerItem(chargeStack9);
			
        	}
		
        	if(!chargeStack10.isEmpty()) {
			
        		receivePowerItem(chargeStack10);
			
        	}
        }
        	
        if(hasEnergy()) {
        		
        	if(!chargeStack1.isEmpty()) {
        			
        		sendPowerItem(chargeStack1);
        			
        	}
    		
        	if(!chargeStack2.isEmpty()) {
    			
        		sendPowerItem(chargeStack2);
    			
        	}
		
        	if(!chargeStack3.isEmpty()) {
			
        		sendPowerItem(chargeStack3);
			
        	}
	
        	if(!chargeStack4.isEmpty()) {
		
        		sendPowerItem(chargeStack4);
		
        	}

        	if(!chargeStack5.isEmpty()) {
	
        		sendPowerItem(chargeStack5);
	
        	}
        		
        	sendPower();
        		
        }
        
    }
	
	private boolean hasTransUpgrades() {
    	
		if(upgradeSlotHandler.getStackInSlot(0).getItem().equals(ModItems.TRANSFER_UPGRADE.get()) || upgradeSlotHandler.getStackInSlot(1).getItem().equals(ModItems.TRANSFER_UPGRADE.get()) ||
		   upgradeSlotHandler.getStackInSlot(2).getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
    		
    		return true;
    		
    	}
		
    	return false;
    }
    
    public boolean hasCapUpgrades() {
	
    	if(upgradeSlotHandler.getStackInSlot(0).getItem().equals(ModItems.CAPACITY_UPGRADE.get()) || upgradeSlotHandler.getStackInSlot(1).getItem().equals(ModItems.CAPACITY_UPGRADE.get()) ||
    	   upgradeSlotHandler.getStackInSlot(2).getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
		
    		return true;
		
    	}
    	
    	return false;
    }

	private void applyCapUpgrades(ItemStack stack1, ItemStack stack2, ItemStack stack3) {
		
		int capUpgradeCount = 0;
    	int modify1;
    	int modify2;
    	int modify3;
			
		if(stack1.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
		
			modify1 = stack1.getCount();
			
		} else {
				
			modify1 = 0;
				
		}
			
		if(stack2.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
		
			modify2 = stack2.getCount();
				
		} else {
				
			modify2 = 0;
				
		}
		
		if(stack3.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
	
			modify3 = stack3.getCount();
			
		} else {
			
			modify3 = 0;
			
		}
			
		capUpgradeCount = modify1 + modify2 + modify3;
		
		if(capUpgradeCount > 0) {
				
			energyStorage.applyCapacityUpgrades(capUpgradeCount);
			
		} 
    }
    
    private void applyTransUpgrades(ItemStack stack1, ItemStack stack2, ItemStack stack3) {
		
    	int transUpgradeCount = 0;
    	int modify1;
    	int modify2;
    	int modify3;
			
		if(stack1.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
		
			modify1 = stack1.getCount();
			
		} else {
			
			modify1 = 0;
		}
			
		if(stack2.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
		
			modify2 = stack2.getCount();
			
		} else {
			
			modify2 = 0;
		}
		
		if(stack3.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
	
			modify3 = stack3.getCount();
		
		} else {
		
			modify3 = 0;
		}
			
		transUpgradeCount = modify1 + modify2 + modify3;
		
		if(transUpgradeCount > 0) {
			
			energyStorage.applyTransferUpgrades(transUpgradeCount);
		
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
        return new ContainerT5EnergyCube(this, this.fields, id, playerInventory, new CombinedInvWrapper(chargeSlotsHandler, upgradeSlotHandler));
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

    @Nullable
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
    	
    	if (cap == CapabilityEnergy.ENERGY) {
    		
            return energy.cast();
            
        }
    	
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
        	
            return allSlots.cast();
            
        }
        
		return super.getCapability(cap, side);
    }

    @Override
    public void setRemoved() {
    	
        energy.invalidate();
		chargeSlots.invalidate();
		upgradeSlotWrapper.invalidate();
		allSlots.invalidate();
        super.setRemoved();
        
    }

	@Override
	public ITextComponent getDisplayName() {
		
		return new TranslationTextComponent("container.mechanicraft.t5_energy_cube");
		
	}
}