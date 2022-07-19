package com.github.will11690.mechanicraft.network.packet.slurryprocesor.output;

import java.util.function.Supplier;

import com.github.will11690.mechanicraft.network.packet.PacketHandler;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class ServerboundSlurryOutputPacket {

    private static boolean validMessage;

    public ServerboundSlurryOutputPacket() {
    	
    	validMessage = true;
    }

    public static ServerboundSlurryOutputPacket decode(PacketBuffer buffer) {
    	
        return new ServerboundSlurryOutputPacket();
    }

    public void encode(PacketBuffer buffer) {
        
    }

    public boolean isValid() {
    	
        return validMessage;
    }
    
    public static void onMessageReceived(final ServerboundSlurryOutputPacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().setPacketHandled(true);

    	if (!message.isValid()) {
    		return;
    	}
    	
    	if (ctxSupplier.get().getDirection().getReceptionSide() != LogicalSide.SERVER) {}

    	ctxSupplier.get().enqueueWork(() -> processMessage(message));
    }

    private static void processMessage(ServerboundSlurryOutputPacket message) {

    }

    public static boolean isProtocolAccepted(String protocolVersion) {
    	
    	return PacketHandler.PROTOCOL_VERSION.equals(protocolVersion);
    }
}