package com.github.will11690.mechanicraft.network.packet.burntime;

import java.util.function.Supplier;

import com.github.will11690.mechanicraft.network.packet.PacketHandler;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class ServerboundBurnTimePacket {

    private static boolean validMessage;

    public ServerboundBurnTimePacket() {
    	
    	validMessage = true;
    }

    public static ServerboundBurnTimePacket decode(PacketBuffer buffer) {
    	
        return new ServerboundBurnTimePacket();
    }

    public void encode(PacketBuffer buffer) {
        
    }

    public boolean isValid() {
    	
        return validMessage;
    }
    
    public static void onMessageReceived(final ServerboundBurnTimePacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().setPacketHandled(true);

    	if (!message.isValid()) {
    		return;
    	}
    	
    	if (ctxSupplier.get().getDirection().getReceptionSide() != LogicalSide.SERVER) {}

    	ctxSupplier.get().enqueueWork(() -> processMessage(message));
    }

    private static void processMessage(ServerboundBurnTimePacket message) {

    }

    public static boolean isProtocolAccepted(String protocolVersion) {
    	
    	return PacketHandler.PROTOCOL_VERSION.equals(protocolVersion);
    }
}