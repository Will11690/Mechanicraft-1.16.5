package com.github.will11690.mechanicraft.network.packet.orewasher.energy;

import java.util.UUID;
import java.util.function.Supplier;

import com.github.will11690.mechanicraft.blocks.machines.tier1.t1orewasher.ContainerT1OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2orewasher.ContainerT2OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3orewasher.ContainerT3OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4orewasher.ContainerT4OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5orewasher.ContainerT5OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6orewasher.ContainerT6OreWasher;
import com.github.will11690.mechanicraft.network.packet.PacketHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class ClientboundWasherEnergyPacket {

    private static boolean validMessage;

    int energyStored;
    int energyCapacity;
    static BlockPos blockPos;
	UUID playerUUID;

    public ClientboundWasherEnergyPacket(int energyStored, int energyCapacity,  BlockPos blockPos, UUID playerUUID) {
    	validMessage = true;
        this.energyStored = energyStored;
        this.energyCapacity = energyCapacity;
        ClientboundWasherEnergyPacket.blockPos = blockPos;
        this.playerUUID = playerUUID;
    }
    
    public static ClientboundWasherEnergyPacket decode(PacketBuffer buffer) {
        return new ClientboundWasherEnergyPacket(buffer.readInt(), buffer.readInt(), buffer.readBlockPos(), buffer.readUUID());
    }

    public boolean isMessageValid() {
        return validMessage;
    }

    public void encode(PacketBuffer buffer) {
        if (!validMessage)
            return;
        buffer.writeInt(energyStored);
        buffer.writeInt(energyCapacity);
        buffer.writeBlockPos(blockPos);
        buffer.writeUUID(playerUUID);
    }

    public boolean isValid() {
        return validMessage;
    }
    
    public static void onMessageReceived(final ClientboundWasherEnergyPacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().setPacketHandled(true);
    	
    	if (!message.isValid()) {
    		
    		return;
    	}

    	if (ctxSupplier.get().getDirection().getReceptionSide() != LogicalSide.CLIENT) {
    		
    		return;
    	}
    	
    	ctxSupplier.get().enqueueWork(() -> processMessage(message, ctxSupplier));
    }

    private static void processMessage(ClientboundWasherEnergyPacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().enqueueWork(() -> {
    		
    		ClientPlayerEntity player = Minecraft.getInstance().player;
            Container container = player.containerMenu;
            
    		if(container instanceof ContainerT1OreWasher) {
    			
    			ContainerT1OreWasher t1WasherContainer = (ContainerT1OreWasher)container;
    			t1WasherContainer.setEnergyStored(message.energyStored);
    			t1WasherContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT2OreWasher) {
    			
    			ContainerT2OreWasher t2WasherContainer = (ContainerT2OreWasher)container;
    			t2WasherContainer.setEnergyStored(message.energyStored);
    			t2WasherContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT3OreWasher) {
    			
    			ContainerT3OreWasher t3WasherContainer = (ContainerT3OreWasher)container;
    			t3WasherContainer.setEnergyStored(message.energyStored);
    			t3WasherContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT4OreWasher) {
    			
    			ContainerT4OreWasher t4WasherContainer = (ContainerT4OreWasher)container;
    			t4WasherContainer.setEnergyStored(message.energyStored);
    			t4WasherContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT5OreWasher) {
    			
    			ContainerT5OreWasher t5WasherContainer = (ContainerT5OreWasher)container;
    			t5WasherContainer.setEnergyStored(message.energyStored);
    			t5WasherContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT6OreWasher) {
    			
    			ContainerT6OreWasher t6WasherContainer = (ContainerT6OreWasher)container;
    			t6WasherContainer.setEnergyStored(message.energyStored);
    			t6WasherContainer.setEnergyCapacity(message.energyCapacity);
    		}
    	});
    	ctxSupplier.get().setPacketHandled(true);
    }

    public static boolean isProtocolAccepted(String protocolVersion) {
    	return PacketHandler.PROTOCOL_VERSION.equals(protocolVersion);
    }
}