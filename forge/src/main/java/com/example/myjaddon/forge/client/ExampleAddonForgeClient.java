package com.example.myjaddon.forge.client;

import com.example.myjaddon.ExampleAddon;
import com.example.myjaddon.client.ExampleAddonClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD, modid = ExampleAddon.MOD_ID)
public class ExampleAddonForgeClient {
    @SubscribeEvent
    public static void handleClientSetup(final FMLClientSetupEvent event) {
        ExampleAddonClient.init();
    }
}
