package com.github.will11690.mechanicraft.network.packet.slurryprocesor.input2;

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
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class ClientboundSlurryInput2Packet {

    private static boolean validMessage;

    FluidStack input2;
    int input2Capacity;
    static BlockPos blockPos;
	UUID playerUUID;

    public ClientboundSlurryInput2Packet(FluidStack input2, int input2Capacity,  BlockPos blockPos, UUID playerUUID) {
    	validMessage = true;
        this.input2 = input2;
        this.input2Capacity = input2Capacity;
        ClientboundSlurryInput2Packet.blockPos = blockPos;
        this.playerUUID = playerUUID;
    }
    
    public static ClientboundSlurryInput2Packet decode(PacketBuffer buffer) {
        return new ClientboundSlurryInput2Packet(buffer.readFluidStack(), buffer.readInt(), buffer.readBlockPos(), buffer.readUUID());
    }

    public boolean isMessageValid() {
        return validMessage;
    }

    public void encode(PacketBuffer buffer) {
        if (!validMessage)
            return;
        buffer.writeFluidStack(input2);
        buffer.writeInt(input2Capacity);
        buffer.writeBlockPos(blockPos);
        buffer.writeUUID(playerUUID);
    }

    public boolean isValid() {
        return validMessage;
    }
    
    public static void onMessageReceived(final ClientboundSlurryInput2Packet message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().setPacketHandled(true);

    	if (!message.isValid()) {
    		
    		return;
    	}

    	if (ctxSupplier.get().getDirection().getReceptionSide() != LogicalSide.CLIENT) {
    		
    		return;
    	}
    	
    	ctxSupplier.get().enqueueWork(() -> processMessage(message, ctxSupplier));
    }

    private static void processMessage(ClientboundSlurryInput2Packet message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().enqueueWork(() -> {
    		
    		ClientPlayerEntity player = Minecraft.getInstance().player;
            Container container = player.containerMenu;
            
            if(container instanceof ContainerT1SlurryProcessor) {
    			
    			ContainerT1SlurryProcessor t1SlurryContainer = (ContainerT1SlurryProcessor)container;
    			t1SlurryContainer.setInputFluid2(message.input2);
    			t1SlurryContainer.setInput2Capacity(message.input2Capacity);
    		}
            
    		if(container instanceof ContainerT2SlurryProcessor) {
    			
    			ContainerT2SlurryProcessor t2SlurryContainer = (ContainerT2SlurryProcessor)container;
    			t2SlurryContainer.setInputFluid2(message.input2);
    			t2SlurryContainer.setInput2Capacity(message.input2Capacity);
    		}
            
    		if(container instanceof ContainerT3SlurryProcessor) {
    			
    			ContainerT3SlurryProcessor t3SlurryContainer = (ContainerT3SlurryProcessor)container;
    			t3SlurryContainer.setInputFluid2(message.input2);
    			t3SlurryContainer.setInput2Capacity(message.input2Capacity);
    		}
            
    		if(container instanceof ContainerT4SlurryProcessor) {
    			
    			ContainerT4SlurryProcessor t4SlurryContainer = (ContainerT4SlurryProcessor)container;
    			t4SlurryContainer.setInputFluid2(message.input2);
    			t4SlurryContainer.setInput2Capacity(message.input2Capacity);
    		}
            
    		if(container instanceof ContainerT5SlurryProcessor) {
    			
    			ContainerT5SlurryProcessor t5SlurryContainer = (ContainerT5SlurryProcessor)container;
    			t5SlurryContainer.setInputFluid2(message.input2);
    			t5SlurryContainer.setInput2Capacity(message.input2Capacity);
    		}
            
    		if(container instanceof ContainerT6SlurryProcessor) {
    			
    			ContainerT6SlurryProcessor t6SlurryContainer = (ContainerT6SlurryProcessor)container;
    			t6SlurryContainer.setInputFluid2(message.input2);
    			t6SlurryContainer.setInput2Capacity(message.input2Capacity);
    		}
        });
        ctxSupplier.get().setPacketHandled(true);
    }

    public static boolean isProtocolAccepted(String protocolVersion) {
    	return PacketHandler.PROTOCOL_VERSION.equals(protocolVersion);
    }
}