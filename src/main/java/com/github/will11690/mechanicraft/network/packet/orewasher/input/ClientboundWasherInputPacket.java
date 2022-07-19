package com.github.will11690.mechanicraft.network.packet.orewasher.input;

import java.util.UUID;
import java.util.function.Supplier;

import com.github.will11690.mechanicraft.blocks.machines.tier1.t1orewasher.ContainerT1OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2orewasher.ContainerT2OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3orewasher.ContainerT3OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4orewasher.ContainerT4OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5orewasher.ContainerT5OreWasher;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6orewasher.ContainerT6OreWasher;
import com.github.will11690.mechanicraft.network.packet.PacketHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class ClientboundWasherInputPacket {

    private static boolean validMessage;

    FluidStack input;
    int inputCapacity;
    static BlockPos blockPos;
	UUID playerUUID;

    public ClientboundWasherInputPacket(FluidStack input, int inputCapacity,  BlockPos blockPos, UUID playerUUID) {
    	validMessage = true;
        this.input = input;
        this.inputCapacity = inputCapacity;
        ClientboundWasherInputPacket.blockPos = blockPos;
        this.playerUUID = playerUUID;
    }
    
    public static ClientboundWasherInputPacket decode(PacketBuffer buffer) {
        return new ClientboundWasherInputPacket(buffer.readFluidStack(), buffer.readInt(), buffer.readBlockPos(), buffer.readUUID());
    }

    public boolean isMessageValid() {
        return validMessage;
    }

    public void encode(PacketBuffer buffer) {
        if (!validMessage)
            return;
        buffer.writeFluidStack(input);
        buffer.writeInt(inputCapacity);
        buffer.writeBlockPos(blockPos);
        buffer.writeUUID(playerUUID);
    }

    public boolean isValid() {
        return validMessage;
    }
    
    public static void onMessageReceived(final ClientboundWasherInputPacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().setPacketHandled(true);

    	if (!message.isValid()) {
    		
    		return;
    	}

    	if (ctxSupplier.get().getDirection().getReceptionSide() != LogicalSide.CLIENT) {
    		
    		return;
    	}
    	
    	ctxSupplier.get().enqueueWork(() -> processMessage(message, ctxSupplier));
    }

    private static void processMessage(ClientboundWasherInputPacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().enqueueWork(() -> {
    		
    		ClientPlayerEntity player = Minecraft.getInstance().player;
            Container container = player.containerMenu;
            
    		if(container instanceof ContainerT1OreWasher) {
    			
    			ContainerT1OreWasher t1WasherContainer = (ContainerT1OreWasher)container;
    			t1WasherContainer.setInputFluid(message.input);
    			t1WasherContainer.setInputCapacity(message.inputCapacity);
    		}
            
    		if(container instanceof ContainerT2OreWasher) {
    			
    			ContainerT2OreWasher t2WasherContainer = (ContainerT2OreWasher)container;
    			t2WasherContainer.setInputFluid(message.input);
    			t2WasherContainer.setInputCapacity(message.inputCapacity);
    		}
            
    		if(container instanceof ContainerT3OreWasher) {
    			
    			ContainerT3OreWasher t3WasherContainer = (ContainerT3OreWasher)container;
    			t3WasherContainer.setInputFluid(message.input);
    			t3WasherContainer.setInputCapacity(message.inputCapacity);
    		}
            
    		if(container instanceof ContainerT4OreWasher) {
    			
    			ContainerT4OreWasher t4WasherContainer = (ContainerT4OreWasher)container;
    			t4WasherContainer.setInputFluid(message.input);
    			t4WasherContainer.setInputCapacity(message.inputCapacity);
    		}
            
    		if(container instanceof ContainerT5OreWasher) {
    			
    			ContainerT5OreWasher t5WasherContainer = (ContainerT5OreWasher)container;
    			t5WasherContainer.setInputFluid(message.input);
    			t5WasherContainer.setInputCapacity(message.inputCapacity);
    		}
            
    		if(container instanceof ContainerT6OreWasher) {
    			
    			ContainerT6OreWasher t6WasherContainer = (ContainerT6OreWasher)container;
    			t6WasherContainer.setInputFluid(message.input);
    			t6WasherContainer.setInputCapacity(message.inputCapacity);
    		}
        });
        ctxSupplier.get().setPacketHandled(true);
    }

    public static boolean isProtocolAccepted(String protocolVersion) {
    	return PacketHandler.PROTOCOL_VERSION.equals(protocolVersion);
    }
}