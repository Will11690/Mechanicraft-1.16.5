package com.github.will11690.mechanicraft.blocks.machines.basic.basiccgen;

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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.init.ModConfigs;
import com.github.will11690.mechanicraft.util.handlers.NonExtractableStackHandler;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;

public class TileEntityBasicCoalGenerator extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
    
	//TODO Clean this up and assign ItemStackHandlers via CombinedInvWrapper instead of per slot
	
    private MechaniCraftEnergyStorage energyStorage = createEnergy();
    private final LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
    
    private ItemStackHandler fuelSlotHandler = createFuel();
    private ItemStackHandler fuelSlotHandlerWrapper = createFuelWrapper(fuelSlotHandler);
    private ItemStackHandler chargeSlotHandler = createCharge();
    
    private final LazyOptional<IItemHandler> fuelSlot  = LazyOptional.of(() -> fuelSlotHandler);
    private final LazyOptional<IItemHandler> fuelSlotWrapper  = LazyOptional.of(() -> fuelSlotHandlerWrapper);
    private final LazyOptional<IItemHandler> chargeSlot  = LazyOptional.of(() -> chargeSlotHandler);
    
    private final LazyOptional<IItemHandler> allSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotHandler, fuelSlotHandlerWrapper));
	
	private final LazyOptional<IItemHandler> dropSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotHandler, fuelSlotHandler));
	boolean breakBlock = false;
    
    public int burnTime = 0;
    private int powerGen = ModConfigs.basicCoalGeneratorPowerGenInt;
    public int totalBurnTime = 0;
    
    private static int capacity = ModConfigs.basicCoalGeneratorCapacityInt;
    private static int extract = ModConfigs.basicCoalGeneratorExtractInt;

    public TileEntityBasicCoalGenerator() {
    	
        super(TileEntityHandler.TILE_ENTITY_BASIC_COAL_GENERATOR.get());
        
    }

	@Override
    public void tick() {
    	
        if (this.level == null || this.level.isClientSide) {
        	
            return;
            
        }
		
		this.updateEnergyStorage();
        
        if(burnTime <= 0 && this.level.getBlockState(this.worldPosition).getValue(BasicCoalGenerator.LIT) == true) {
        	
        	this.level.setBlockAndUpdate(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(BasicCoalGenerator.LIT, Boolean.valueOf(false)));
        
        }
        	
        	ItemStack chargeStack = chargeSlotHandler.getStackInSlot(0);
        	ItemStack fuelStack = fuelSlotHandler.getStackInSlot(0);
        	
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
        
    }

	private void updateEnergyStorage() {
		
		if(energy.isPresent()) {
			if(energyStorage.getCapacity() != capacity || energyStorage.getMaxExtract() != extract)
				energyStorage.updateEnergyStorageNoUpgrades(capacity, 0, extract);
		}
	}
    
    private MechaniCraftEnergyStorage createEnergy() {
    	
        return new MechaniCraftEnergyStorage(capacity, 0, extract) {
        	
            @Override
            protected void onEnergyChanged() {
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
            }
        };
    }
    
    private ItemStackHandler createFuel() {
    	
    	return new ItemStackHandler() {
    		
    		@Override
            protected void onContentsChanged(int slot) {
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
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
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
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
				if(level != null) {
					BlockState state = level.getBlockState(worldPosition);
					level.sendBlockUpdated(worldPosition, state, state, Constants.BlockFlags.DEFAULT);
					setChanged();
				}
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
    
    private boolean hasEnergy() {
    	
    	if(energyStorage.getEnergyStored() > 0) {
    		
    		return true;
    		
    	} else {
    		
    		return false;
    		
    	}
    	
    }
    
    private boolean canGenerate() {
    	
    	if(allSlots.isPresent()) {
    		
    		if(energyStorage.getMaxEnergyStored() - energyStorage.getEnergyStored() >= 0) {
    		
    			return true;
    		
    		} else {
    		
    			return false;
    		
    		}
    	}
    	return false;
    }
    
    private void startGenerating() {
    	
    	if(burnTime > 0) {
    		
    		if(energyStorage.getMaxEnergyStored() - energyStorage.getEnergyStored() >= powerGen) {
    		
    			energyStorage.addEnergy(powerGen);
    		
    		}
    	}
    }
    
    @SuppressWarnings("deprecation")
	public void consumeFuel() {
        	
        ItemStack fuelStack = fuelSlotHandler.getStackInSlot(0);
    	
        if(!(fuelStack.equals(ItemStack.EMPTY))) {
    		
        	if(ForgeHooks.getBurnTime(fuelStack) != 0 && burnTime == 0) {
    			
        		this.burnTime = ForgeHooks.getBurnTime(fuelStack);
    			
        		if(fuelStack.getItem().equals(Items.LAVA_BUCKET)) {
    				
        			totalBurnTime = ForgeHooks.getBurnTime(fuelStack);
        			fuelSlotHandler.setStackInSlot(0, new ItemStack(Items.BUCKET, 1));
    				
        		} else {
    				
        			totalBurnTime = ForgeHooks.getBurnTime(fuelStack);
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
        return new ContainerBasicCoalGenerator(this, id, playerInventory, new CombinedInvWrapper(chargeSlotHandler, fuelSlotHandler));
    }

    @Override
    public void load(BlockState state, CompoundNBT tags) {
    	
        super.load(state, tags);
        this.burnTime = tags.getInt("BurnTime");
        this.totalBurnTime = tags.getInt("TotalBurnTime");
        this.energyStorage.deserializeNBT(tags.getCompound("energy"));
		this.fuelSlotHandler.deserializeNBT(tags.getCompound("fuelSlot"));
		this.chargeSlotHandler.deserializeNBT(tags.getCompound("chargeSlot"));
        
    }

    @Override
    public CompoundNBT save(CompoundNBT tags) {
    	
        super.save(tags);
        tags.putInt("BurnTime", this.burnTime);
        tags.putInt("TotalBurnTime", this.totalBurnTime);
        tags.put("energy", energyStorage.serializeNBT());
		tags.put("fuelSlot", fuelSlotHandler.serializeNBT());
		tags.put("chargeSlot", chargeSlotHandler.serializeNBT());
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
		fuelSlotWrapper.invalidate();
		fuelSlot.invalidate();
		chargeSlot.invalidate();
		allSlots.invalidate();
		dropSlots.invalidate();
        super.setRemoved();
        
    }

	@Override
	public ITextComponent getDisplayName() {
		
		return new TranslationTextComponent("container.mechanicraft.basic_coal_generator");
		
	}
}