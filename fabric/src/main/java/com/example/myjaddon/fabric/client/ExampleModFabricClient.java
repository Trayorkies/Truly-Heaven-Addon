package com.example.myjaddon.fabric.client;

import com.example.myjaddon.client.ExampleAddonClient;
import net.fabricmc.api.ClientModInitializer;

public final class ExampleModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ExampleAddonClient.init();
    }
}
