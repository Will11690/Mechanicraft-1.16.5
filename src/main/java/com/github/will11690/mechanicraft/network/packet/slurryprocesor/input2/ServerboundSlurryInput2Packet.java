package com.github.will11690.mechanicraft.network.packet.slurryprocesor.input2;

import java.util.function.Supplier;

import com.github.will11690.mechanicraft.network.packet.PacketHandler;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class ServerboundSlurryInput2Packet {

    private static boolean validMessage;

    public ServerboundSlurryInput2Packet() {
    	
    	validMessage = true;
    }

    public static ServerboundSlurryInput2Packet decode(PacketBuffer buffer) {
    	
        return new ServerboundSlurryInput2Packet();
    }

    public void encode(PacketBuffer buffer) {
        
    }

    public boolean isValid() {
    	
        return validMessage;
    }
    
    public static void onMessageReceived(final ServerboundSlurryInput2Packet message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().setPacketHandled(true);

    	if (!message.isValid()) {
    		return;
    	}
    	
    	if (ctxSupplier.get().getDirection().getReceptionSide() != LogicalSide.SERVER) {}

    	ctxSupplier.get().enqueueWork(() -> processMessage(message));
    }

    private static void processMessage(ServerboundSlurryInput2Packet message) {

    }

    public static boolean isProtocolAccepted(String protocolVersion) {
    	
    	return PacketHandler.PROTOCOL_VERSION.equals(protocolVersion);
    }
}