package com.github.will11690.mechanicraft.util;

import java.util.UUID;

import com.mojang.authlib.GameProfile;

import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;

public class MechanicraftFakePlayer {
    private static final GameProfile profile = new GameProfile(UUID.fromString("77ED9E10-E5FD-45B4-9F29-955D76D53DDC"), "[MechanicraftFakePlayer]");

    public static FakePlayer get(ServerWorld world) {
        return FakePlayerFactory.get(world, profile);
    }
}