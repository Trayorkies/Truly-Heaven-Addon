package com.example.myjaddon.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.example.myjaddon.ExampleAddon;

@Mod(ExampleAddon.MOD_ID)
public final class ExampleAddonForge {
    public ExampleAddonForge(FMLJavaModLoadingContext ctx) {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(ExampleAddon.MOD_ID, ctx.getModEventBus());

        // Run our common setup.
        ExampleAddon.init();
    }
}
