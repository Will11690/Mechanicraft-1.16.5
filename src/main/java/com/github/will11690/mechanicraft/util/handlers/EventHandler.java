package com.github.will11690.mechanicraft.util.handlers;

import com.github.will11690.mechanicraft.blocks.fluidtank.advfluidtank.AdvFluidTankTER;
import com.github.will11690.mechanicraft.blocks.fluidtank.basicfluidtank.BasicFluidTankTER;
import com.github.will11690.mechanicraft.blocks.fluidtank.elitefluidtank.EliteFluidTankTER;
import com.github.will11690.mechanicraft.blocks.fluidtank.superiorfluidtank.SuperiorFluidTankTER;
import com.github.will11690.mechanicraft.blocks.fluidtank.supremefluidtank.SupremeFluidTankTER;
import com.github.will11690.mechanicraft.blocks.fluidtank.ultimatefluidtank.UltimateFluidTankTER;
import com.github.will11690.mechanicraft.init.ModBlocks;
import com.github.will11690.mechanicraft.init.ModFluids;
import com.github.will11690.mechanicraft.util.Reference;
import com.github.will11690.mechanicraft.world.gen.MechanicraftOreGenerator;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventHandler {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void doFlying(TickEvent.PlayerTickEvent event) {

        PlayerEntity player = event.player;
        CompoundNBT tag = player.getPersistentData();
        boolean wasFlying = tag.getBoolean("wasFlying");

        if(!player.isCreative() && !player.isSpectator()) {

            if(player.hasEffect(RegistryHandler.FLIGHT_EFFECT.get()) && !player.hasEffect(Effects.LEVITATION)) {

                if(!player.abilities.mayfly){

                    player.abilities.mayfly = true;
                    tag.putBoolean("wasFlying", true);
                    player.onUpdateAbilities();
                }

                if(player.isOnGround()){

                    player.abilities.flying = false;
                    player.onUpdateAbilities();
                }

            } else if(wasFlying && !player.hasEffect(RegistryHandler.FLIGHT_EFFECT.get()) || player.hasEffect(Effects.LEVITATION)) {

                player.abilities.mayfly = false;
                player.abilities.flying = false;
                tag.putBoolean("wasFlying", false);
                player.onUpdateAbilities();
            }
        }
    }

    @SubscribeEvent
    public static void addNBTData(PlayerEvent.PlayerLoggedInEvent event) {

        PlayerEntity player = event.getPlayer();
        CompoundNBT tag = player.getPersistentData();
        INBT modeTag = tag.get("wasFlying");

        if(modeTag == null) {

            tag.putBoolean("wasFlying", false);
        }
    }

    @SubscribeEvent
    public static void fallDamageFlight(PlayerFlyableFallEvent event) {

        double distance = event.getDistance();
        PlayerEntity player = event.getPlayer();

        if (distance >= 3 && !player.isCreative() && player.hasEffect(RegistryHandler.FLIGHT_EFFECT.get())) {

            //float damage = (float)Math.floor(distance) - 2;
            player.hurt(DamageSource.FALL, 0);
        }
    }
    
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
    	
    	MechanicraftOreGenerator.generateOres(event);
    }
    
    @Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static final class Client {
    	
        private Client() {}

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        	
        	ContainerTypeHandler.registerScreens(event);
        	
        	ClientRegistry.bindTileEntityRenderer(TileEntityHandler.TILE_ENTITY_BASIC_FLUID_TANK.get(), BasicFluidTankTER::new);
        	ClientRegistry.bindTileEntityRenderer(TileEntityHandler.TILE_ENTITY_ADVANCED_FLUID_TANK.get(), AdvFluidTankTER::new);
        	ClientRegistry.bindTileEntityRenderer(TileEntityHandler.TILE_ENTITY_ELITE_FLUID_TANK.get(), EliteFluidTankTER::new);
        	ClientRegistry.bindTileEntityRenderer(TileEntityHandler.TILE_ENTITY_SUPERIOR_FLUID_TANK.get(), SuperiorFluidTankTER::new);
        	ClientRegistry.bindTileEntityRenderer(TileEntityHandler.TILE_ENTITY_SUPREME_FLUID_TANK.get(), SupremeFluidTankTER::new);
        	ClientRegistry.bindTileEntityRenderer(TileEntityHandler.TILE_ENTITY_ULTIMATE_FLUID_TANK.get(), UltimateFluidTankTER::new);
        	
        	event.enqueueWork(() -> {

                RenderTypeLookup.setRenderLayer(ModFluids.GOLD_ORE_SLURRY_FLUID.get(), RenderType.translucent());
                RenderTypeLookup.setRenderLayer(ModFluids.GOLD_ORE_SLURRY_BLOCK.get(), RenderType.translucent());
                RenderTypeLookup.setRenderLayer(ModFluids.GOLD_ORE_SLURRY_FLOWING.get(), RenderType.translucent());

                RenderTypeLookup.setRenderLayer(ModFluids.IRON_ORE_SLURRY_FLUID.get(), RenderType.translucent());
                RenderTypeLookup.setRenderLayer(ModFluids.IRON_ORE_SLURRY_BLOCK.get(), RenderType.translucent());
                RenderTypeLookup.setRenderLayer(ModFluids.IRON_ORE_SLURRY_FLOWING.get(), RenderType.translucent());

                RenderTypeLookup.setRenderLayer(ModFluids.TIN_ORE_SLURRY_FLUID.get(), RenderType.translucent());
                RenderTypeLookup.setRenderLayer(ModFluids.TIN_ORE_SLURRY_BLOCK.get(), RenderType.translucent());
                RenderTypeLookup.setRenderLayer(ModFluids.TIN_ORE_SLURRY_FLOWING.get(), RenderType.translucent());

                RenderTypeLookup.setRenderLayer(ModFluids.COPPER_ORE_SLURRY_FLUID.get(), RenderType.translucent());
                RenderTypeLookup.setRenderLayer(ModFluids.COPPER_ORE_SLURRY_BLOCK.get(), RenderType.translucent());
                RenderTypeLookup.setRenderLayer(ModFluids.COPPER_ORE_SLURRY_FLOWING.get(), RenderType.translucent());

                RenderTypeLookup.setRenderLayer(ModFluids.SILVER_ORE_SLURRY_FLUID.get(), RenderType.translucent());
                RenderTypeLookup.setRenderLayer(ModFluids.SILVER_ORE_SLURRY_BLOCK.get(), RenderType.translucent());
                RenderTypeLookup.setRenderLayer(ModFluids.SILVER_ORE_SLURRY_FLOWING.get(), RenderType.translucent());

                RenderTypeLookup.setRenderLayer(ModFluids.LEAD_ORE_SLURRY_FLUID.get(), RenderType.translucent());
                RenderTypeLookup.setRenderLayer(ModFluids.LEAD_ORE_SLURRY_BLOCK.get(), RenderType.translucent());
                RenderTypeLookup.setRenderLayer(ModFluids.LEAD_ORE_SLURRY_FLOWING.get(), RenderType.translucent());

                RenderTypeLookup.setRenderLayer(ModFluids.LIQUID_SLAG_FLUID.get(), RenderType.translucent());
                RenderTypeLookup.setRenderLayer(ModFluids.LIQUID_SLAG_BLOCK.get(), RenderType.translucent());
                RenderTypeLookup.setRenderLayer(ModFluids.LIQUID_SLAG_FLOWING.get(), RenderType.translucent());
                
                RenderTypeLookup.setRenderLayer(ModBlocks.MINING_CHUTE.get(), RenderType.cutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.T1_ENERGY_CHUTE.get(), RenderType.cutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.T1_ITEM_CHUTE.get(), RenderType.cutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.T1_FLUID_CHUTE.get(), RenderType.cutout());
                
                RenderTypeLookup.setRenderLayer(ModBlocks.BASIC_FLUID_TANK.get(), RenderType.cutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.ADVANCED_FLUID_TANK.get(), RenderType.cutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.ELITE_FLUID_TANK.get(), RenderType.cutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.SUPERIOR_FLUID_TANK.get(), RenderType.cutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.SUPREME_FLUID_TANK.get(), RenderType.cutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.ULTIMATE_FLUID_TANK.get(), RenderType.cutout());
            });
        }
    }
}