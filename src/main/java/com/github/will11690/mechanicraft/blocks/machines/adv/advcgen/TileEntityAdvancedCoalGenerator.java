package com.github.will11690.mechanicraft.blocks.machines.adv.advcgen;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

import com.github.will11690.mechanicraft.blocks.machines.basic.basiccgen.BasicCoalGenerator;
import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.init.ModItems;
import com.github.will11690.mechanicraft.util.capabilities.factory.UpgradeGeneratorHandlerFactory;
import com.github.will11690.mechanicraft.util.capabilities.interfaces.IUpgradeGeneratorHandler;
import com.github.will11690.mechanicraft.util.handlers.NonExtractableStackHandler;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;

public class TileEntityAdvancedCoalGenerator extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
	
	//TODO Clean this up and assign ItemStackHandlers via CombinedInvWrapper instead of per slot
	
    MechaniCraftEnergyStorage energyStorage = createEnergy();
    UpgradeGeneratorHandlerFactory upgradeHandler = createUpgrade();
    
    private ItemStackHandler fuelSlotHandler = createFuel();
    private ItemStackHandler fuelSlotHandlerWrapper = createFuelWrapper(fuelSlotHandler);
    public ItemStackHandler upgradeSlotHandler = createUpgradeHandler();
    private ItemStackHandler upgradeSlotHandlerWrapper = createUpgradeWrapper(upgradeSlotHandler);
    private ItemStackHandler chargeSlotHandler = createCharge();
    
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
    private LazyOptional<IUpgradeGeneratorHandler> upgrade = LazyOptional.of(() -> upgradeHandler);
    private LazyOptional<IItemHandler> fuelSlot  = LazyOptional.of(() -> fuelSlotHandler);
    private LazyOptional<IItemHandler> fuelSlotWrapper  = LazyOptional.of(() -> fuelSlotHandlerWrapper);
    private LazyOptional<IItemHandler> chargeSlot  = LazyOptional.of(() -> chargeSlotHandler);
    
    private final LazyOptional<IItemHandler> allSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotHandler, fuelSlotHandlerWrapper, upgradeSlotHandlerWrapper));

    //TODO Create config for powergen, Capacity, and Transfer
    
    //For Configs Later
    private static final int capacity = 500000;
    private static final int extract = 2500;
    private int powerGenBase = 250;
    
    private int burnTime = 0;
    private int totalBurnTime = 0;
    
    
    //For upgrade capability
    private int burnTimeBase = 0;
    
    private int upgradableBurnTime = 0;
    private int upgradablePowerGen = 0;

    private final IIntArray fields = new IIntArray() {
    	
        @Override
        public int get(int index) {
        	
            switch (index) {
            
                case 0:
                    return burnTime;
                case 1:
                	return totalBurnTime;
                case 2:
                	return energyStorage.getEnergyStored();
                case 3:
                	return Math.max(energyStorage.getBaseCapacity(), energyStorage.getUpgradedCapacity());
                case 4:
                	return energyStorage.getBaseCapacity();
                default:
                    return 0;
                    
            }
        }

        @Override
        public void set(int index, int value) {
        	
            switch (index) {
            
                case 0:
                	burnTime = value;
                    break;
                case 1:
                	totalBurnTime = value;
                    break;
                case 2:
                	energyStorage.setEnergy(value);
                    break;
                case 3:
                	energyStorage.setCapacity(value);
                    break;
                case 4:
                	energyStorage.setBaseCapacity(value);
                    break;
                default:
                	break;
                    
            }
        }

        @Override
        public int getCount() {
        	
            return 5;
            
        }
    };

    public TileEntityAdvancedCoalGenerator() {
    	
        super(TileEntityHandler.TILE_ENTITY_ADVANCED_COAL_GENERATOR.get());
        
    }
    
    private MechaniCraftEnergyStorage createEnergy() {
    	
        return new MechaniCraftEnergyStorage(capacity, 0, extract) {
        	
            @Override
			protected void onEnergyChanged() {

                setChanged();
                
            }
        };
    }
    
    private ItemStackHandler createFuel() {
    	
    	return new ItemStackHandler() {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }
    		
    		@SuppressWarnings("deprecation")
			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

    			Item item = stack.getItem();

				if(ForgeHooks.getBurnTime(stack) != 0 || stack.getItem().equals(Items.BUCKET)) {
					
					if(item.equals(Items.COAL) || item.equals(Items.COAL_BLOCK) || item.equals(Items.CHARCOAL)) {

						return true;
						
					}
				}

				return false;
				
			}
		};
    	
    }
    
    private ItemStackHandler createFuelWrapper(ItemStackHandler fuelSlotHandler) {
    	
    	return new NonExtractableStackHandler(this.fuelSlotHandler) {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }
    		
    		@SuppressWarnings("deprecation")
			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
    			
    			Item item = stack.getItem();

				if(ForgeHooks.getBurnTime(stack) != 0 || stack.getItem().equals(Items.BUCKET)) {
					
					if(item.equals(Items.COAL) || item.equals(Items.COAL_BLOCK) || item.equals(Items.CHARCOAL)) {

						return true;
						
					}
				}

				return false;
				
			}
		};
    }
    
    private ItemStackHandler createCharge() {
    	
    	return new ItemStackHandler() {
    		
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

	private ItemStackHandler createUpgradeHandler() {

    	return new ItemStackHandler(2) {
    		
    		@Override
            protected void onContentsChanged(int slot) {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
            }
    		
    		@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

    			Item item = stack.getItem();
				
				if(item.equals(ModItems.CAPACITY_UPGRADE.get()) || item.equals(ModItems.EFFICIENCY_UPGRADE.get()) || item.equals(ModItems.SPEED_UPGRADE.get()) || item.equals(ModItems.TRANSFER_UPGRADE.get())) {
					
					return true;
					
				}

				return false;
				
			}
    		
    		@Override
    		@Nonnull
    		public ItemStack extractItem(int slot, int amount, boolean simulate) {
    			 
    			if(!(upgradeHandler.canExtractFromSlot(burnTime))) {
    				 
    				return ItemStack.EMPTY;
    				 
    			}
    			
    			if(energyStorage.getEnergyStored() > energyStorage.getBaseCapacity()) {
    				
    				return ItemStack.EMPTY;
    				
    			} else
    			 	
    				return super.extractItem(slot, amount, simulate);
    		 }
		};
		
    }
	
	private ItemStackHandler createUpgradeWrapper(ItemStackHandler upgradeSlot1Handler) {

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
				
				if(item.equals(ModItems.CAPACITY_UPGRADE.get()) || item.equals(ModItems.EFFICIENCY_UPGRADE.get()) || item.equals(ModItems.SPEED_UPGRADE.get()) || item.equals(ModItems.TRANSFER_UPGRADE.get())) {

					return true;
					
				}

				return false;
				
			}
    		
    		@Override
    		@Nonnull
    		public ItemStack extractItem(int slot, int amount, boolean simulate) {
    			 
    			if(!(upgradeHandler.canExtractFromSlot(burnTime))) {
    				 
    				return ItemStack.EMPTY;
    				 
    			}
    			
    			if(energyStorage.getEnergyStored() > energyStorage.getBaseCapacity()) {
    				
    				return ItemStack.EMPTY;
    				
    			} else
    			 	
    				return super.extractItem(slot, amount, simulate);
    		 }
		};
    }
    
	private UpgradeGeneratorHandlerFactory createUpgrade() {
    	
        return new UpgradeGeneratorHandlerFactory() {
        	
            @Override
			public void onUpgradeChanged() {

				BlockState state = level.getBlockState(worldPosition);
				level.sendBlockUpdated(worldPosition, state, state, 3);
                setChanged();
                
            }
        };
    }

	@SuppressWarnings("deprecation")
	@Override
    public void tick() {
    	
        if(this.level == null || this.level.isClientSide) {
        	
            return;
            
        }
        
        ItemStack chargeStack = chargeSlotHandler.getStackInSlot(0);
    	ItemStack fuelStack = fuelSlotHandler.getStackInSlot(0);
		
        ItemStack upgradeStack1 = upgradeSlotHandler.getStackInSlot(0);
        ItemStack upgradeStack2 = upgradeSlotHandler.getStackInSlot(1);
    	
        if(hasCapUpgrades() && energyStorage.getCapacity() != energyStorage.getUpgradedCapacity()) {
        	
        	if(upgradeStack1.getItem().equals(ModItems.CAPACITY_UPGRADE.get()) || upgradeStack2.getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
        		
        		applyCapUpgrades(upgradeStack1, upgradeStack2);
        		
        	}
        }
        
        if(hasTransUpgrades() && (energyStorage.getMaxExtract() != energyStorage.getUpgradedExtract()) &&
        						 (energyStorage.getMaxReceive() != energyStorage.getUpgradedReceive())) {
        	
        	if(upgradeStack1.getItem().equals(ModItems.TRANSFER_UPGRADE.get()) || upgradeStack2.getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
        		
        		applyTransUpgrades(upgradeStack1, upgradeStack2);
        		
        	}
        }
        
       if(!hasCapUpgrades() && energyStorage.getCapacity() != energyStorage.getBaseCapacity()) {
        	
        	energyStorage.setCapacity(energyStorage.getBaseCapacity());
        	
        }
        
        if(!hasTransUpgrades() && energyStorage.getMaxExtract() != energyStorage.getBaseExtract()) {
        	
        	energyStorage.setMaxExtract(energyStorage.getBaseExtract());
        	
        }
    	
    	if(!(fuelStack.isEmpty()) && burnTimeBase == 0) {
    		
    		burnTimeBase = ForgeHooks.getBurnTime(fuelStack);
    		
        }
    	
    	if(burnTime == 0) {
    		
    		this.setUpgradeModifiers();
    		
    	}
        
        if(burnTime <= 0 && this.level.getBlockState(this.worldPosition).getValue(BasicCoalGenerator.LIT) == true) {
        	
        	this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(BasicCoalGenerator.LIT, Boolean.valueOf(false)));
        
        }
        	
        if(!fuelStack.isEmpty() && burnTime <= 0 && canGenerate()) {
        		
        	consumeFuel();
        		
        }
        	
        if(hasEnergy()) {
        		
        	if(!chargeStack.isEmpty()) {
        			
        		sendPowerItem(chargeStack);
        			
        	}
        		
        	sendPower();
        		
        }
        	
        if(canGenerate()) {
        		
        	if(burnTime > 0) {
            			
        		startGenerating();
            			
        	}	
        }
        
        if(burnTime > 0 && this.level.getBlockState(this.worldPosition).getValue(BasicCoalGenerator.LIT) == false) {
        	
        	this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(BasicCoalGenerator.LIT, Boolean.valueOf(true)));
        	
        }
        
        if(burnTime > 0) {
        	
        	--burnTime;
        	
        }
        
        if(fuelStack.equals(ItemStack.EMPTY) && burnTime == 0) {
        	
        	totalBurnTime = 0;
        	
        }
    }
    
    private boolean hasEnergy() {
    	
    	if(energyStorage.getEnergyStored() > 0) {
    		
    		return true;
    		
    	} else {
    		
    		return false;
    		
    	}
    	
    }
	
	private boolean hasTransUpgrades() {
    	
    	if(upgradeSlotHandler.getStackInSlot(0).getItem().equals(ModItems.TRANSFER_UPGRADE.get()) || upgradeSlotHandler.getStackInSlot(1).getItem().equals(ModItems.TRANSFER_UPGRADE.get())) {
    		
    		return true;
    	}
    	
    	return false;
    }
    
    public boolean hasCapUpgrades() {
    	
    	if(upgradeSlotHandler.getStackInSlot(0).getItem().equals(ModItems.CAPACITY_UPGRADE.get()) || upgradeSlotHandler.getStackInSlot(1).getItem().equals(ModItems.CAPACITY_UPGRADE.get())) {
    		
    		return true;
    	}
    	
    	return false;
    }

	private void applyCapUpgrades(ItemStack stack1, ItemStack stack2) {
		
    	int capUpgradeCount = 0;
    	int modify1;
    	int modify2;
			
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
			
		capUpgradeCount = modify1 + modify2;
		
		if(capUpgradeCount > 0) {
				
			energyStorage.applyCapacityUpgrades(capUpgradeCount);
			
		} 
    }
    
    private void applyTransUpgrades(ItemStack stack1, ItemStack stack2) {
		
    	int transUpgradeCount = 0;
    	int modify1;
    	int modify2;
			
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
			
		transUpgradeCount = modify1 + modify2;
		
		if(transUpgradeCount > 0) {
			
			energyStorage.applyTransferUpgrades(transUpgradeCount);
		
		}
    }
    
    private void setUpgradeModifiers() {
    	
    	if(upgrade.isPresent()) {
    		
    		upgradeHandler.setUpgrade1Stack(upgradeSlotHandler.getStackInSlot(0));
    		upgradeHandler.setUpgrade2Stack(upgradeSlotHandler.getStackInSlot(1));
    		
    		upgradeHandler.twoUpgradeModifier(burnTimeBase, powerGenBase, upgradeSlotHandler.getStackInSlot(0), upgradeSlotHandler.getStackInSlot(1));
    			
    		upgradableBurnTime = upgradeHandler.getTotalBurnTime();
    		upgradablePowerGen = upgradeHandler.getTotalEnergyGen();
    	}
    }
    
    private boolean canGenerate() {
    	
    	if(upgradablePowerGen > 0 && energyStorage.getMaxEnergyStored() - energyStorage.getEnergyStored() > 0) {
    		
    		return true;
    		
    	} else {
    		
    		return false;
    		
    	}
    	
    }
    
    private void startGenerating() {
    	
    	if(burnTime > 0) {
    		
    		if(energyStorage.getMaxEnergyStored() - energyStorage.getEnergyStored() > 0) {
    		
    			energyStorage.addEnergy(upgradablePowerGen);
    		
    		}
    	}
    }
    
	@SuppressWarnings("deprecation")
	public void consumeFuel() {
        	
		ItemStack fuelStack = fuelSlotHandler.getStackInSlot(0);
		
		if(!(fuelStack.equals(ItemStack.EMPTY))) {
    		
			if(ForgeHooks.getBurnTime(fuelStack) != 0 && burnTime == 0) {
				
				burnTime = upgradableBurnTime;
        			
				if(fuelStack.getItem().equals(Items.LAVA_BUCKET)) {
    				
					totalBurnTime = upgradableBurnTime;
					fuelSlotHandler.setStackInSlot(0, new ItemStack(Items.BUCKET, 1));
    				
				} else {
    				
					totalBurnTime = upgradableBurnTime;
					fuelStack.shrink(1);
    				
				}
			}
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
    
    @Nullable
    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        assert level != null;
        return new ContainerAdvancedCoalGenerator(this, this.fields, id, playerInventory, new CombinedInvWrapper(chargeSlotHandler, fuelSlotHandler, upgradeSlotHandler));
    }

    @Override
    public void load(BlockState state, CompoundNBT tags) {
    	
        super.load(state, tags);
        this.burnTime = tags.getInt("BurnTime");
        this.burnTimeBase = tags.getInt("BurnTimeBase");
        this.totalBurnTime = tags.getInt("TotalBurnTime");
        this.upgradableBurnTime = tags.getInt("UpgradableBurnTime");
        this.upgradablePowerGen = tags.getInt("UpgradablePowerGen");
        this.energyStorage.deserializeNBT(tags.getCompound("energy"));
		this.fuelSlotHandler.deserializeNBT(tags.getCompound("fuelSlot"));
		this.chargeSlotHandler.deserializeNBT(tags.getCompound("chargeSlot"));
		this.upgradeSlotHandler.deserializeNBT(tags.getCompound("upgradeSlot"));
        
    }

    @Override
    public CompoundNBT save(CompoundNBT tags) {
    	
        super.save(tags);
        tags.putInt("BurnTime", this.burnTime);
        tags.putInt("BurnTimeBase", this.burnTimeBase);
        tags.putInt("TotalBurnTime", this.totalBurnTime);
        tags.putInt("UpgradableBurnTime", this.upgradableBurnTime);
        tags.putInt("UpgradablePowerGen", this.upgradablePowerGen);
        tags.put("energy", energyStorage.serializeNBT());
		tags.put("fuelSlot", fuelSlotHandler.serializeNBT());
		tags.put("chargeSlot", chargeSlotHandler.serializeNBT());
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
		fuelSlotWrapper.invalidate();
		fuelSlot.invalidate();
		chargeSlot.invalidate();
		allSlots.invalidate();
		upgrade.invalidate();
        super.setRemoved();
        
    }

	@Override
	public ITextComponent getDisplayName() {
		
		return new TranslationTextComponent("container.mechanicraft.adv_coal_generator");
		
	}
}