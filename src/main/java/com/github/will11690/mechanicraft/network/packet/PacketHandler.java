package com.github.will11690.mechanicraft.network.packet;

import com.github.will11690.mechanicraft.network.packet.burntime.ClientboundEnergyPacket;
import com.github.will11690.mechanicraft.network.packet.burntime.ServerboundBurnTimePacket;
import com.github.will11690.mechanicraft.network.packet.energy.ClientboundBurnTimePacket;
import com.github.will11690.mechanicraft.network.packet.energy.ServerboundEnergyPacket;
import com.github.will11690.mechanicraft.network.packet.orewasher.energy.ClientboundWasherEnergyPacket;
import com.github.will11690.mechanicraft.network.packet.orewasher.energy.ServerboundWasherEnergyPacket;
import com.github.will11690.mechanicraft.network.packet.orewasher.input.ClientboundWasherInputPacket;
import com.github.will11690.mechanicraft.network.packet.orewasher.input.ServerboundWasherInputPacket;
import com.github.will11690.mechanicraft.network.packet.orewasher.output.ClientboundWasherOutputPacket;
import com.github.will11690.mechanicraft.network.packet.orewasher.output.ServerboundWasherOutputPacket;
import com.github.will11690.mechanicraft.network.packet.slurryprocesor.energy.ClientboundSlurryEnergyPacket;
import com.github.will11690.mechanicraft.network.packet.slurryprocesor.energy.ServerboundSlurryEnergyPacket;
import com.github.will11690.mechanicraft.network.packet.slurryprocesor.input1.ClientboundSlurryInput1Packet;
import com.github.will11690.mechanicraft.network.packet.slurryprocesor.input1.ServerboundSlurryInput1Packet;
import com.github.will11690.mechanicraft.network.packet.slurryprocesor.input2.ClientboundSlurryInput2Packet;
import com.github.will11690.mechanicraft.network.packet.slurryprocesor.input2.ServerboundSlurryInput2Packet;
import com.github.will11690.mechanicraft.network.packet.slurryprocesor.output.ClientboundSlurryOutputPacket;
import com.github.will11690.mechanicraft.network.packet.slurryprocesor.output.ServerboundSlurryOutputPacket;
import com.github.will11690.mechanicraft.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PacketHandler {
	
    public static final String PROTOCOL_VERSION = "1";
    
	public static final SimpleChannel INSTANCE_ENERGY = NetworkRegistry.newSimpleChannel(
	new ResourceLocation(Reference.MOD_ID, "energy"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
    
	public static final SimpleChannel INSTANCE_BURN_TIME = NetworkRegistry.newSimpleChannel(
	new ResourceLocation(Reference.MOD_ID, "burn_time"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
    
	public static final SimpleChannel INSTANCE_WASHER_ENERGY = NetworkRegistry.newSimpleChannel(
	new ResourceLocation(Reference.MOD_ID, "washer_energy"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	
	public static final SimpleChannel INSTANCE_WASHER_INPUT = NetworkRegistry.newSimpleChannel(
	new ResourceLocation(Reference.MOD_ID, "washer_input"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	
	public static final SimpleChannel INSTANCE_WASHER_OUTPUT = NetworkRegistry.newSimpleChannel(
	new ResourceLocation(Reference.MOD_ID, "washer_output"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
    
	public static final SimpleChannel INSTANCE_SLURRY_ENERGY = NetworkRegistry.newSimpleChannel(
	new ResourceLocation(Reference.MOD_ID, "slurry_energy"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	
	public static final SimpleChannel INSTANCE_SLURRY_INPUT1 = NetworkRegistry.newSimpleChannel(
	new ResourceLocation(Reference.MOD_ID, "slurry_input1"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	
	public static final SimpleChannel INSTANCE_SLURRY_INPUT2 = NetworkRegistry.newSimpleChannel(
	new ResourceLocation(Reference.MOD_ID, "slurry_input2"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	
	public static final SimpleChannel INSTANCE_SLURRY_OUTPUT = NetworkRegistry.newSimpleChannel(
	new ResourceLocation(Reference.MOD_ID, "slurry_output"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    private PacketHandler() {
    }

    public static void init() {
    	
        int index = 0;
        //WASHER PACKETS
        INSTANCE_WASHER_ENERGY.messageBuilder(ServerboundWasherEnergyPacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
        .encoder(ServerboundWasherEnergyPacket::encode).decoder(ServerboundWasherEnergyPacket::decode)
        .consumer(ServerboundWasherEnergyPacket::onMessageReceived).add();
        
        INSTANCE_WASHER_ENERGY.messageBuilder(ClientboundWasherEnergyPacket.class, index++, NetworkDirection.PLAY_TO_CLIENT)
        .encoder(ClientboundWasherEnergyPacket::encode).decoder(ClientboundWasherEnergyPacket::decode)
        .consumer(ClientboundWasherEnergyPacket::onMessageReceived).add();
        
        INSTANCE_WASHER_INPUT.messageBuilder(ServerboundWasherInputPacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
        .encoder(ServerboundWasherInputPacket::encode).decoder(ServerboundWasherInputPacket::decode)
        .consumer(ServerboundWasherInputPacket::onMessageReceived).add();

        INSTANCE_WASHER_INPUT.messageBuilder(ClientboundWasherInputPacket.class, index++, NetworkDirection.PLAY_TO_CLIENT)
        .encoder(ClientboundWasherInputPacket::encode).decoder(ClientboundWasherInputPacket::decode)
        .consumer(ClientboundWasherInputPacket::onMessageReceived).add();

        INSTANCE_WASHER_OUTPUT.messageBuilder(ServerboundWasherOutputPacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
        .encoder(ServerboundWasherOutputPacket::encode).decoder(ServerboundWasherOutputPacket::decode)
        .consumer(ServerboundWasherOutputPacket::onMessageReceived).add();

        INSTANCE_WASHER_OUTPUT.messageBuilder(ClientboundWasherOutputPacket.class, index++, NetworkDirection.PLAY_TO_CLIENT)
        .encoder(ClientboundWasherOutputPacket::encode).decoder(ClientboundWasherOutputPacket::decode)
        .consumer(ClientboundWasherOutputPacket::onMessageReceived).add();
        
        //SLURRY PROCESSOR PACKETS
        INSTANCE_SLURRY_ENERGY.messageBuilder(ServerboundSlurryEnergyPacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
        .encoder(ServerboundSlurryEnergyPacket::encode).decoder(ServerboundSlurryEnergyPacket::decode)
        .consumer(ServerboundSlurryEnergyPacket::onMessageReceived).add();
        
        INSTANCE_SLURRY_ENERGY.messageBuilder(ClientboundSlurryEnergyPacket.class, index++, NetworkDirection.PLAY_TO_CLIENT)
        .encoder(ClientboundSlurryEnergyPacket::encode).decoder(ClientboundSlurryEnergyPacket::decode)
        .consumer(ClientboundSlurryEnergyPacket::onMessageReceived).add();
        
        INSTANCE_SLURRY_INPUT1.messageBuilder(ServerboundSlurryInput1Packet.class, index++, NetworkDirection.PLAY_TO_SERVER)
        .encoder(ServerboundSlurryInput1Packet::encode).decoder(ServerboundSlurryInput1Packet::decode)
        .consumer(ServerboundSlurryInput1Packet::onMessageReceived).add();

        INSTANCE_SLURRY_INPUT1.messageBuilder(ClientboundSlurryInput1Packet.class, index++, NetworkDirection.PLAY_TO_CLIENT)
        .encoder(ClientboundSlurryInput1Packet::encode).decoder(ClientboundSlurryInput1Packet::decode)
        .consumer(ClientboundSlurryInput1Packet::onMessageReceived).add();
        
        INSTANCE_SLURRY_INPUT2.messageBuilder(ServerboundSlurryInput2Packet.class, index++, NetworkDirection.PLAY_TO_SERVER)
        .encoder(ServerboundSlurryInput2Packet::encode).decoder(ServerboundSlurryInput2Packet::decode)
        .consumer(ServerboundSlurryInput2Packet::onMessageReceived).add();

        INSTANCE_SLURRY_INPUT2.messageBuilder(ClientboundSlurryInput2Packet.class, index++, NetworkDirection.PLAY_TO_CLIENT)
        .encoder(ClientboundSlurryInput2Packet::encode).decoder(ClientboundSlurryInput2Packet::decode)
        .consumer(ClientboundSlurryInput2Packet::onMessageReceived).add();

        INSTANCE_SLURRY_OUTPUT.messageBuilder(ServerboundSlurryOutputPacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
        .encoder(ServerboundSlurryOutputPacket::encode).decoder(ServerboundSlurryOutputPacket::decode)
        .consumer(ServerboundSlurryOutputPacket::onMessageReceived).add();

        INSTANCE_SLURRY_OUTPUT.messageBuilder(ClientboundSlurryOutputPacket.class, index++, NetworkDirection.PLAY_TO_CLIENT)
        .encoder(ClientboundSlurryOutputPacket::encode).decoder(ClientboundSlurryOutputPacket::decode)
        .consumer(ClientboundSlurryOutputPacket::onMessageReceived).add();
        
        //BURN TIME PACKETS
        INSTANCE_ENERGY.messageBuilder(ServerboundEnergyPacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
        .encoder(ServerboundEnergyPacket::encode).decoder(ServerboundEnergyPacket::decode)
        .consumer(ServerboundEnergyPacket::onMessageReceived).add();
        
        INSTANCE_ENERGY.messageBuilder(ClientboundEnergyPacket.class, index++, NetworkDirection.PLAY_TO_CLIENT)
        .encoder(ClientboundEnergyPacket::encode).decoder(ClientboundEnergyPacket::decode)
        .consumer(ClientboundEnergyPacket::onMessageReceived).add();
        
        //ENERGY PACKETS
        INSTANCE_BURN_TIME.messageBuilder(ServerboundBurnTimePacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
        .encoder(ServerboundBurnTimePacket::encode).decoder(ServerboundBurnTimePacket::decode)
        .consumer(ServerboundBurnTimePacket::onMessageReceived).add();
        
        INSTANCE_BURN_TIME.messageBuilder(ClientboundBurnTimePacket.class, index++, NetworkDirection.PLAY_TO_CLIENT)
        .encoder(ClientboundBurnTimePacket::encode).decoder(ClientboundBurnTimePacket::decode)
        .consumer(ClientboundBurnTimePacket::onMessageReceived).add();
    }
    
    @SubscribeEvent
    public static void onCommonSetupEvent(FMLCommonSetupEvent event) {
        init();
    }
}