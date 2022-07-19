package com.github.will11690.mechanicraft.network.packet.slurryprocesor.output;

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

public class ClientboundSlurryOutputPacket {

    private static boolean validMessage;
    
    FluidStack output;
    int outputCapacity;
    static BlockPos blockPos;
	UUID playerUUID;

    public ClientboundSlurryOutputPacket(FluidStack output, int outputCapacity,  BlockPos blockPos, UUID playerUUID) {
    	validMessage = true;
        this.output = output;
        this.outputCapacity = outputCapacity;
        ClientboundSlurryOutputPacket.blockPos = blockPos;
        this.playerUUID = playerUUID;
    }
    
    public static ClientboundSlurryOutputPacket decode(PacketBuffer buffer) {
        return new ClientboundSlurryOutputPacket(buffer.readFluidStack(), buffer.readInt(), buffer.readBlockPos(), buffer.readUUID());
    }

    public boolean isMessageValid() {
        return validMessage;
    }

    public void encode(PacketBuffer buffer) {
        if (!validMessage)
            return;
        buffer.writeFluidStack(output);
        buffer.writeInt(outputCapacity);
        buffer.writeBlockPos(blockPos);
        buffer.writeUUID(playerUUID);
    }

    public boolean isValid() {
        return validMessage;
    }
    
    public static void onMessageReceived(final ClientboundSlurryOutputPacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().setPacketHandled(true);

    	if (!message.isValid()) {
    		
    		return;
    	}

    	if (ctxSupplier.get().getDirection().getReceptionSide() != LogicalSide.CLIENT) {
    		
    		return;
    	}
    	
    	ctxSupplier.get().enqueueWork(() -> processMessage(message, ctxSupplier));
    }

    private static void processMessage(ClientboundSlurryOutputPacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().enqueueWork(() -> {
    		
    		ClientPlayerEntity player = Minecraft.getInstance().player;
            Container container = player.containerMenu;
            
            if(container instanceof ContainerT1SlurryProcessor) {
    			
    			ContainerT1SlurryProcessor t1SlurryContainer = (ContainerT1SlurryProcessor)container;
    			t1SlurryContainer.setOutputFluid(message.output);
    			t1SlurryContainer.setOutputCapacity(message.outputCapacity);
    		}
            
    		if(container instanceof ContainerT2SlurryProcessor) {
    			
    			ContainerT2SlurryProcessor t2SlurryContainer = (ContainerT2SlurryProcessor)container;
    			t2SlurryContainer.setOutputFluid(message.output);
    			t2SlurryContainer.setOutputCapacity(message.outputCapacity);
    		}
            
    		if(container instanceof ContainerT3SlurryProcessor) {
    			
    			ContainerT3SlurryProcessor t3SlurryContainer = (ContainerT3SlurryProcessor)container;
    			t3SlurryContainer.setOutputFluid(message.output);
    			t3SlurryContainer.setOutputCapacity(message.outputCapacity);
    		}
            
    		if(container instanceof ContainerT4SlurryProcessor) {
    			
    			ContainerT4SlurryProcessor t4SlurryContainer = (ContainerT4SlurryProcessor)container;
    			t4SlurryContainer.setOutputFluid(message.output);
    			t4SlurryContainer.setOutputCapacity(message.outputCapacity);
    		}
            
    		if(container instanceof ContainerT5SlurryProcessor) {
    			
    			ContainerT5SlurryProcessor t5SlurryContainer = (ContainerT5SlurryProcessor)container;
    			t5SlurryContainer.setOutputFluid(message.output);
    			t5SlurryContainer.setOutputCapacity(message.outputCapacity);
    		}
            
    		if(container instanceof ContainerT6SlurryProcessor) {
    			
    			ContainerT6SlurryProcessor t6SlurryContainer = (ContainerT6SlurryProcessor)container;
    			t6SlurryContainer.setOutputFluid(message.output);
    			t6SlurryContainer.setOutputCapacity(message.outputCapacity);
    		}
        });
    	
        ctxSupplier.get().setPacketHandled(true);
    }

    public static boolean isProtocolAccepted(String protocolVersion) {
    	return PacketHandler.PROTOCOL_VERSION.equals(protocolVersion);
    }
}