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

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.will11690.mechanicraft.energy.MechaniCraftEnergyStorage;
import com.github.will11690.mechanicraft.util.handlers.NonExtractableStackHandler;
import com.github.will11690.mechanicraft.util.handlers.TileEntityHandler;

public class TileEntityBasicCoalGenerator extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
    
	//TODO Clean this up and assign ItemStackHandlers via CombinedInvWrapper instead of per slot
	
    private MechaniCraftEnergyStorage energyStorage = createEnergy();
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);
    
    private ItemStackHandler fuelSlotHandler = createFuel();
    private ItemStackHandler fuelSlotHandlerWrapper = createFuelWrapper(fuelSlotHandler);
    private ItemStackHandler chargeSlotHandler = createCharge();
    
    public LazyOptional<IItemHandler> fuelSlot  = LazyOptional.of(() -> fuelSlotHandler);
    public LazyOptional<IItemHandler> fuelSlotWrapper  = LazyOptional.of(() -> fuelSlotHandlerWrapper);
    public LazyOptional<IItemHandler> chargeSlot  = LazyOptional.of(() -> chargeSlotHandler);
    
    private final LazyOptional<IItemHandler> allSlots  = LazyOptional.of(() -> new CombinedInvWrapper(chargeSlotHandler, fuelSlotHandlerWrapper));

    //TODO Create config for powergen
    
    private int burnTime = 0;
    private int powerGen = 100;
    public int totalBurnTime = 0;
    
    private static final int capacity = 250000;
    private static final int extract = 1000;

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
                	return energyStorage.getCapacity();
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
                default:
                	break;
                    
            }
        }

        @Override
        public int getCount() {
        	
            return 4;
            
        }
    };

    public TileEntityBasicCoalGenerator() {
    	
        super(TileEntityHandler.TILE_ENTITY_BASIC_COAL_GENERATOR.get());
        
    }

	@Override
    public void tick() {
    	
        if (this.level == null || this.level.isClientSide) {
        	
            return;
            
        }
        
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
    
    private boolean hasEnergy() {
    	
    	if(energyStorage.getEnergyStored() > 0) {
    		
    		return true;
    		
    	} else {
    		
    		return false;
    		
    	}
    	
    }
    
    private boolean canGenerate() {
    	
    	if(energyStorage.getMaxEnergyStored() - energyStorage.getEnergyStored() >= 0) {
    		
    		return true;
    		
    	} else {
    		
    		return false;
    		
    	}
    	
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
        return new ContainerBasicCoalGenerator(this, this.fields, id, playerInventory, new CombinedInvWrapper(chargeSlotHandler, fuelSlotHandler));
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
        super.setRemoved();
        
    }

	@Override
	public ITextComponent getDisplayName() {
		
		return new TranslationTextComponent("container.mechanicraft.basic_coal_generator");
		
	}
}