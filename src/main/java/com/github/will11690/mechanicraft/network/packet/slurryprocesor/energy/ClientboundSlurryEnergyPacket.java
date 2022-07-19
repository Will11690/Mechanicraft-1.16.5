package com.github.will11690.mechanicraft.network.packet.slurryprocesor.energy;

import java.util.UUID;
import java.util.function.Supplier;

import com.github.will11690.mechanicraft.blocks.machines.tier1.t1slurryprocessor.ContainerT1SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2slurryprocessor.ContainerT2SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3slurryprocessor.ContainerT3SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4slurryprocessor.ContainerT4SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5slurryprocessor.ContainerT5SlurryProcessor;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6slurryprocessor.ContainerT6SlurryProcessor;
import com.github.will11690.mechanicraft.network.packet.PacketHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class ClientboundSlurryEnergyPacket {

    private static boolean validMessage;

    int energyStored;
    int energyCapacity;
    static BlockPos blockPos;
	UUID playerUUID;

    public ClientboundSlurryEnergyPacket(int energyStored, int energyCapacity,  BlockPos blockPos, UUID playerUUID) {
    	validMessage = true;
        this.energyStored = energyStored;
        this.energyCapacity = energyCapacity;
        ClientboundSlurryEnergyPacket.blockPos = blockPos;
        this.playerUUID = playerUUID;
    }
    
    public static ClientboundSlurryEnergyPacket decode(PacketBuffer buffer) {
        return new ClientboundSlurryEnergyPacket(buffer.readInt(), buffer.readInt(), buffer.readBlockPos(), buffer.readUUID());
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
    
    public static void onMessageReceived(final ClientboundSlurryEnergyPacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().setPacketHandled(true);
    	
    	if (!message.isValid()) {
    		
    		return;
    	}

    	if (ctxSupplier.get().getDirection().getReceptionSide() != LogicalSide.CLIENT) {
    		
    		return;
    	}
    	
    	ctxSupplier.get().enqueueWork(() -> processMessage(message, ctxSupplier));
    }

    private static void processMessage(ClientboundSlurryEnergyPacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().enqueueWork(() -> {
    		
    		ClientPlayerEntity player = Minecraft.getInstance().player;
            Container container = player.containerMenu;
            
    		if(container instanceof ContainerT1SlurryProcessor) {
    			
    			ContainerT1SlurryProcessor t1SlurryContainer = (ContainerT1SlurryProcessor)container;
    			t1SlurryContainer.setEnergyStored(message.energyStored);
    			t1SlurryContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT2SlurryProcessor) {
    			
    			ContainerT2SlurryProcessor t2SlurryContainer = (ContainerT2SlurryProcessor)container;
    			t2SlurryContainer.setEnergyStored(message.energyStored);
    			t2SlurryContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT3SlurryProcessor) {
    			
    			ContainerT3SlurryProcessor t3SlurryContainer = (ContainerT3SlurryProcessor)container;
    			t3SlurryContainer.setEnergyStored(message.energyStored);
    			t3SlurryContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT4SlurryProcessor) {
    			
    			ContainerT4SlurryProcessor t4SlurryContainer = (ContainerT4SlurryProcessor)container;
    			t4SlurryContainer.setEnergyStored(message.energyStored);
    			t4SlurryContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT5SlurryProcessor) {
    			
    			ContainerT5SlurryProcessor t5SlurryContainer = (ContainerT5SlurryProcessor)container;
    			t5SlurryContainer.setEnergyStored(message.energyStored);
    			t5SlurryContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT6SlurryProcessor) {
    			
    			ContainerT6SlurryProcessor t6SlurryContainer = (ContainerT6SlurryProcessor)container;
    			t6SlurryContainer.setEnergyStored(message.energyStored);
    			t6SlurryContainer.setEnergyCapacity(message.energyCapacity);
    		}
    	});
    	ctxSupplier.get().setPacketHandled(true);
    }

    public static boolean isProtocolAccepted(String protocolVersion) {
    	return PacketHandler.PROTOCOL_VERSION.equals(protocolVersion);
    }
}