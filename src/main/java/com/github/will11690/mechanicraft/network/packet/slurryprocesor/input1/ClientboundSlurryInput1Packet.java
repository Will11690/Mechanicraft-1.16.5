package com.github.will11690.mechanicraft.network.packet.slurryprocesor.input1;

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

public class ClientboundSlurryInput1Packet {

    private static boolean validMessage;

    FluidStack input1;
    int input1Capacity;
    static BlockPos blockPos;
	UUID playerUUID;

    public ClientboundSlurryInput1Packet(FluidStack input1, int input1Capacity,  BlockPos blockPos, UUID playerUUID) {
    	validMessage = true;
        this.input1 = input1;
        this.input1Capacity = input1Capacity;
        ClientboundSlurryInput1Packet.blockPos = blockPos;
        this.playerUUID = playerUUID;
    }
    
    public static ClientboundSlurryInput1Packet decode(PacketBuffer buffer) {
        return new ClientboundSlurryInput1Packet(buffer.readFluidStack(), buffer.readInt(), buffer.readBlockPos(), buffer.readUUID());
    }

    public boolean isMessageValid() {
        return validMessage;
    }

    public void encode(PacketBuffer buffer) {
        if (!validMessage)
            return;
        buffer.writeFluidStack(input1);
        buffer.writeInt(input1Capacity);
        buffer.writeBlockPos(blockPos);
        buffer.writeUUID(playerUUID);
    }

    public boolean isValid() {
        return validMessage;
    }
    
    public static void onMessageReceived(final ClientboundSlurryInput1Packet message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().setPacketHandled(true);

    	if (!message.isValid()) {
    		
    		return;
    	}

    	if (ctxSupplier.get().getDirection().getReceptionSide() != LogicalSide.CLIENT) {
    		
    		return;
    	}
    	
    	ctxSupplier.get().enqueueWork(() -> processMessage(message, ctxSupplier));
    }

    private static void processMessage(ClientboundSlurryInput1Packet message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().enqueueWork(() -> {
    		
    		ClientPlayerEntity player = Minecraft.getInstance().player;
            Container container = player.containerMenu;
            
            if(container instanceof ContainerT1SlurryProcessor) {
    			
    			ContainerT1SlurryProcessor t1SlurryContainer = (ContainerT1SlurryProcessor)container;
    			t1SlurryContainer.setInputFluid1(message.input1);
    			t1SlurryContainer.setInput1Capacity(message.input1Capacity);
    		}
            
    		if(container instanceof ContainerT2SlurryProcessor) {
    			
    			ContainerT2SlurryProcessor t2SlurryContainer = (ContainerT2SlurryProcessor)container;
    			t2SlurryContainer.setInputFluid1(message.input1);
    			t2SlurryContainer.setInput1Capacity(message.input1Capacity);
    		}
            
    		if(container instanceof ContainerT3SlurryProcessor) {
    			
    			ContainerT3SlurryProcessor t3SlurryContainer = (ContainerT3SlurryProcessor)container;
    			t3SlurryContainer.setInputFluid1(message.input1);
    			t3SlurryContainer.setInput1Capacity(message.input1Capacity);
    		}
            
    		if(container instanceof ContainerT4SlurryProcessor) {
    			
    			ContainerT4SlurryProcessor t4SlurryContainer = (ContainerT4SlurryProcessor)container;
    			t4SlurryContainer.setInputFluid1(message.input1);
    			t4SlurryContainer.setInput1Capacity(message.input1Capacity);
    		}
            
    		if(container instanceof ContainerT5SlurryProcessor) {
    			
    			ContainerT5SlurryProcessor t5SlurryContainer = (ContainerT5SlurryProcessor)container;
    			t5SlurryContainer.setInputFluid1(message.input1);
    			t5SlurryContainer.setInput1Capacity(message.input1Capacity);
    		}
            
    		if(container instanceof ContainerT6SlurryProcessor) {
    			
    			ContainerT6SlurryProcessor t6SlurryContainer = (ContainerT6SlurryProcessor)container;
    			t6SlurryContainer.setInputFluid1(message.input1);
    			t6SlurryContainer.setInput1Capacity(message.input1Capacity);
    		}
        });
        ctxSupplier.get().setPacketHandled(true);
    }

    public static boolean isProtocolAccepted(String protocolVersion) {
    	return PacketHandler.PROTOCOL_VERSION.equals(protocolVersion);
    }
}