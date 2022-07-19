package com.github.will11690.mechanicraft.network.packet.orewasher.output;

import java.util.function.Supplier;

import com.github.will11690.mechanicraft.network.packet.PacketHandler;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class ServerboundWasherOutputPacket {

    private static boolean validMessage;

    public ServerboundWasherOutputPacket() {
    	
    	validMessage = true;
    }

    public static ServerboundWasherOutputPacket decode(PacketBuffer buffer) {
    	
        return new ServerboundWasherOutputPacket();
    }

    public void encode(PacketBuffer buffer) {
        
    }

    public boolean isValid() {
    	
        return validMessage;
    }
    
    public static void onMessageReceived(final ServerboundWasherOutputPacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().setPacketHandled(true);

    	if (!message.isValid()) {
    		return;
    	}
    	
    	if (ctxSupplier.get().getDirection().getReceptionSide() != LogicalSide.SERVER) {}

    	ctxSupplier.get().enqueueWork(() -> processMessage(message));
    }

    private static void processMessage(ServerboundWasherOutputPacket message) {

    }

    public static boolean isProtocolAccepted(String protocolVersion) {
    	
    	return PacketHandler.PROTOCOL_VERSION.equals(protocolVersion);
    }
}