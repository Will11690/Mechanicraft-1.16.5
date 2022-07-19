package com.github.will11690.mechanicraft.network.packet.burntime;

import java.util.UUID;
import java.util.function.Supplier;

import com.github.will11690.mechanicraft.blocks.machines.adv.advcgen.ContainerAdvancedCoalGenerator;
import com.github.will11690.mechanicraft.blocks.machines.adv.advfurnace.ContainerAdvancedFurnace;
import com.github.will11690.mechanicraft.blocks.machines.basic.basiccgen.ContainerBasicCoalGenerator;
import com.github.will11690.mechanicraft.blocks.machines.basic.basicfurnace.ContainerBasicFurnace;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1crusher.ContainerT1Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1energycube.ContainerT1EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1infuser.ContainerT1MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1poweredsieve.ContainerT1PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier1.t1press.ContainerT1Press;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2crusher.ContainerT2Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2energycube.ContainerT2EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2infuser.ContainerT2MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2poweredsieve.ContainerT2PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier2.t2press.ContainerT2Press;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3crusher.ContainerT3Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3energycube.ContainerT3EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3infuser.ContainerT3MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3poweredsieve.ContainerT3PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier3.t3press.ContainerT3Press;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4crusher.ContainerT4Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4energycube.ContainerT4EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4infuser.ContainerT4MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4poweredsieve.ContainerT4PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier4.t4press.ContainerT4Press;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5crusher.ContainerT5Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5energycube.ContainerT5EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5infuser.ContainerT5MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5poweredsieve.ContainerT5PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier5.t5press.ContainerT5Press;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6crusher.ContainerT6Crusher;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6energycube.ContainerT6EnergyCube;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6infuser.ContainerT6MetallicInfuser;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6poweredsieve.ContainerT6PoweredSieve;
import com.github.will11690.mechanicraft.blocks.machines.tier6.t6press.ContainerT6Press;
import com.github.will11690.mechanicraft.network.packet.PacketHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class ClientboundEnergyPacket {

    private static boolean validMessage;

    int energyStored;
    int energyCapacity;
    static BlockPos blockPos;
	UUID playerUUID;

    public ClientboundEnergyPacket(int energyStored, int energyCapacity,  BlockPos blockPos, UUID playerUUID) {
    	validMessage = true;
        this.energyStored = energyStored;
        this.energyCapacity = energyCapacity;
        ClientboundEnergyPacket.blockPos = blockPos;
        this.playerUUID = playerUUID;
    }
    
    public static ClientboundEnergyPacket decode(PacketBuffer buffer) {
        return new ClientboundEnergyPacket(buffer.readInt(), buffer.readInt(), buffer.readBlockPos(), buffer.readUUID());
    }

    public boolean isMessageValid() {
        return validMessage;
    }

    public void encode(PacketBuffer buffer) {
        if (!validMessage)
            return;
        buffer.writeInt(energyStored);
        buffer.writeInt(energyCapacity);
        buffer.writeBlockPos(blockPos);
        buffer.writeUUID(playerUUID);
    }

    public boolean isValid() {
        return validMessage;
    }
    
    public static void onMessageReceived(final ClientboundEnergyPacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().setPacketHandled(true);
    	
    	if (!message.isValid()) {
    		
    		return;
    	}

    	if (ctxSupplier.get().getDirection().getReceptionSide() != LogicalSide.CLIENT) {
    		
    		return;
    	}
    	
    	ctxSupplier.get().enqueueWork(() -> processMessage(message, ctxSupplier));
    }

    private static void processMessage(ClientboundEnergyPacket message, Supplier<NetworkEvent.Context> ctxSupplier) {

    	ctxSupplier.get().enqueueWork(() -> {
    		
    		ClientPlayerEntity player = Minecraft.getInstance().player;
            Container container = player.containerMenu;
            
            if(container instanceof ContainerBasicFurnace) {
    			
            	ContainerBasicFurnace energyContainer = (ContainerBasicFurnace)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerAdvancedFurnace) {
    			
    			ContainerAdvancedFurnace energyContainer = (ContainerAdvancedFurnace)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerBasicCoalGenerator) {
    			
    			ContainerBasicCoalGenerator energyContainer = (ContainerBasicCoalGenerator)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerAdvancedCoalGenerator) {
    			
    			ContainerAdvancedCoalGenerator energyContainer = (ContainerAdvancedCoalGenerator)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT1Crusher) {
    			
    			ContainerT1Crusher energyContainer = (ContainerT1Crusher)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT2Crusher) {
    			
    			ContainerT2Crusher energyContainer = (ContainerT2Crusher)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT3Crusher) {
    			
    			ContainerT3Crusher energyContainer = (ContainerT3Crusher)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT4Crusher) {
    			
    			ContainerT4Crusher energyContainer = (ContainerT4Crusher)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT5Crusher) {
    			
    			ContainerT5Crusher energyContainer = (ContainerT5Crusher)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT6Crusher) {
    			
    			ContainerT6Crusher energyContainer = (ContainerT6Crusher)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT1EnergyCube) {
    			
    			ContainerT1EnergyCube energyContainer = (ContainerT1EnergyCube)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT2EnergyCube) {
    			
    			ContainerT2EnergyCube energyContainer = (ContainerT2EnergyCube)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT3EnergyCube) {
    			
    			ContainerT3EnergyCube energyContainer = (ContainerT3EnergyCube)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT4EnergyCube) {
    			
    			ContainerT4EnergyCube energyContainer = (ContainerT4EnergyCube)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT5EnergyCube) {
    			
    			ContainerT5EnergyCube energyContainer = (ContainerT5EnergyCube)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT6EnergyCube) {
    			
    			ContainerT6EnergyCube energyContainer = (ContainerT6EnergyCube)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT1MetallicInfuser) {
    			
    			ContainerT1MetallicInfuser energyContainer = (ContainerT1MetallicInfuser)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT2MetallicInfuser) {
    			
    			ContainerT2MetallicInfuser energyContainer = (ContainerT2MetallicInfuser)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT3MetallicInfuser) {
    			
    			ContainerT3MetallicInfuser energyContainer = (ContainerT3MetallicInfuser)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT4MetallicInfuser) {
    			
    			ContainerT4MetallicInfuser energyContainer = (ContainerT4MetallicInfuser)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT5MetallicInfuser) {
    			
    			ContainerT5MetallicInfuser energyContainer = (ContainerT5MetallicInfuser)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT6MetallicInfuser) {
    			
    			ContainerT6MetallicInfuser energyContainer = (ContainerT6MetallicInfuser)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT1PoweredSieve) {
    			
    			ContainerT1PoweredSieve energyContainer = (ContainerT1PoweredSieve)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT2PoweredSieve) {
    			
    			ContainerT2PoweredSieve energyContainer = (ContainerT2PoweredSieve)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT3PoweredSieve) {
    			
    			ContainerT3PoweredSieve energyContainer = (ContainerT3PoweredSieve)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT4PoweredSieve) {
    			
    			ContainerT4PoweredSieve energyContainer = (ContainerT4PoweredSieve)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT5PoweredSieve) {
    			
    			ContainerT5PoweredSieve energyContainer = (ContainerT5PoweredSieve)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT6PoweredSieve) {
    			
    			ContainerT6PoweredSieve energyContainer = (ContainerT6PoweredSieve)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT1Press) {
    			
    			ContainerT1Press energyContainer = (ContainerT1Press)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT2Press) {
    			
    			ContainerT2Press energyContainer = (ContainerT2Press)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT3Press) {
    			
    			ContainerT3Press energyContainer = (ContainerT3Press)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT4Press) {
    			
    			ContainerT4Press energyContainer = (ContainerT4Press)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT5Press) {
    			
    			ContainerT5Press energyContainer = (ContainerT5Press)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
            
    		if(container instanceof ContainerT6Press) {
    			
    			ContainerT6Press energyContainer = (ContainerT6Press)container;
    			energyContainer.setEnergyStored(message.energyStored);
    			energyContainer.setEnergyCapacity(message.energyCapacity);
    		}
    	});
    	ctxSupplier.get().setPacketHandled(true);
    }

    public static boolean isProtocolAccepted(String protocolVersion) {
    	return PacketHandler.PROTOCOL_VERSION.equals(protocolVersion);
    }
}