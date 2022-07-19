package com.github.will11690.mechanicraft.network.packet.energy;

import java.util.UUID;
import java.util.function.Supplier;

import com.github.will11690.mechanicraft.blocks.machines.adv.advcgen.ContainerAdvancedCoalGenerator;
import com.github.will11690.mechanicraft.blocks.machines.basic.basiccgen.ContainerBasicCoalGenerator;
import com.github.will11690.mechanicraft.blocks.machines.basic.basicinfuser.ContainerBasicMetallicInfuser;
import com.github.will11690.mechanicraft.network.packet.PacketHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class ClientboundBurnTimePacket {

    private static boolean validMessage;

    int burnTime;
    int totalBurnTime;
    static BlockPos blockPos;
	UUID playerUUID;

    public ClientboundBurnTimePacket(int burnTime, int totalBurnTime,  BlockPos blockPos, UUID playerUUID) {
    	validMessage = true;
        this.burnTime = burnTime;
        this.totalBurnTime = totalBurnTime;
        ClientboundBurnTimePacket.blockPos = blockPos;
        this.playerUUID = playerUUID;
    }
    
    public static ClientboundBurnTimePacket decode(PacketBuffer buffer) {
        return new ClientboundBurnTimePacket(buffer.readInt(), buffer.readInt(), buffer.readBlockPos(), buffer.readUUID());
    }

    public boolean isMessageValid() {
        return validMessage;
    }

    public void encode(PacketBuffer buffer) {
        if (!validMessage)
            return;
        buffer.writeInt(burnTime);
        buffer.writeInt(totalBurnTime);
        buffer.writeBlockPos(blockPos);
        buffer.writeUUID(playerUUID);
    }

    public boolean isValid() {
        return validMessage;
    }
    
    public static void onMessageReceived(final ClientboundBurnTimePacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().setPacketHandled(true);
    	
    	if (!message.isValid()) {
    		
    		return;
    	}

    	if (ctxSupplier.get().getDirection().getReceptionSide() != LogicalSide.CLIENT) {
    		
    		return;
    	}
    	
    	ctxSupplier.get().enqueueWork(() -> processMessage(message, ctxSupplier));
    }

    private static void processMessage(ClientboundBurnTimePacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().enqueueWork(() -> {
    		
    		ClientPlayerEntity player = Minecraft.getInstance().player;
            Container container = player.containerMenu;
            
    		if(container instanceof ContainerBasicCoalGenerator) {
    			
    			ContainerBasicCoalGenerator basicCoalGeneratorContainer = (ContainerBasicCoalGenerator)container;
    			basicCoalGeneratorContainer.setBurnTime(message.burnTime);
    			basicCoalGeneratorContainer.setTotalBurnTime(message.totalBurnTime);
    		}
            
    		if(container instanceof ContainerAdvancedCoalGenerator) {
    			
    			ContainerAdvancedCoalGenerator advancedCoalGeneratorContainer = (ContainerAdvancedCoalGenerator)container;
    			advancedCoalGeneratorContainer.setBurnTime(message.burnTime);
    			advancedCoalGeneratorContainer.setTotalBurnTime(message.totalBurnTime);
    		}
            
    		if(container instanceof ContainerBasicMetallicInfuser) {
    			
    			ContainerBasicMetallicInfuser basicInfuserContainer = (ContainerBasicMetallicInfuser)container;
    			basicInfuserContainer.setBurnTime(message.burnTime);
    			basicInfuserContainer.setTotalBurnTime(message.totalBurnTime);
    		}
    	});
    	ctxSupplier.get().setPacketHandled(true);
    }

    public static boolean isProtocolAccepted(String protocolVersion) {
    	return PacketHandler.PROTOCOL_VERSION.equals(protocolVersion);
    }
}