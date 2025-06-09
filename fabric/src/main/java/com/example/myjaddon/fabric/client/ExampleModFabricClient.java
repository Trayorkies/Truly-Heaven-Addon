package com.example.myjaddon.fabric.client;

import com.example.myjaddon.client.ExampleAddonClient;
import com.example.myjaddon.client.register.EntityRendererRegister;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.function.Supplier;

public final class ExampleModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ExampleAddonClient.init();

        // Register entity renderers
        EntityRendererRegister.register(new EntityRendererRegister.EntityRendererRegistrar() {
            @Override
            public <T extends Entity> void register(Supplier<? extends EntityType<? extends T>> type, EntityRendererProvider<T> rendererProvider) {
                EntityRendererRegistry.register(type.get(), rendererProvider);
            }
        });
    }
}
