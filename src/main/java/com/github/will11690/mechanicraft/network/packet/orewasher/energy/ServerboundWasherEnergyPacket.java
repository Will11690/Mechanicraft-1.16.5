package com.github.will11690.mechanicraft.network.packet.orewasher.energy;

import java.util.function.Supplier;

import com.github.will11690.mechanicraft.network.packet.PacketHandler;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class ServerboundWasherEnergyPacket {

    private static boolean validMessage;

    public ServerboundWasherEnergyPacket() {
    	
    	validMessage = true;
    }

    public static ServerboundWasherEnergyPacket decode(PacketBuffer buffer) {
    	
        return new ServerboundWasherEnergyPacket();
    }

    public void encode(PacketBuffer buffer) {
        
    }

    public boolean isValid() {
    	
        return validMessage;
    }
    
    public static void onMessageReceived(final ServerboundWasherEnergyPacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().setPacketHandled(true);

    	if (!message.isValid()) {
    		return;
    	}
    	
    	if (ctxSupplier.get().getDirection().getReceptionSide() != LogicalSide.SERVER) {}

    	ctxSupplier.get().enqueueWork(() -> processMessage(message));
    }

    private static void processMessage(ServerboundWasherEnergyPacket message) {

    }

    public static boolean isProtocolAccepted(String protocolVersion) {
    	
    	return PacketHandler.PROTOCOL_VERSION.equals(protocolVersion);
    }
}