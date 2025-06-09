package com.example.myjaddon.client.register;

import com.example.myjaddon.client.renderer.ExampleStandRenderer;
import com.example.myjaddon.common.register.EntityTypeRegistry;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.function.Supplier;

public interface EntityRendererRegister {
    static void register(EntityRendererRegistrar registrar) {
        registrar.register(EntityTypeRegistry.EXAMPLE_STAND, ExampleStandRenderer::new);
    }

    @FunctionalInterface
    interface EntityRendererRegistrar {
        <T extends Entity> void register(Supplier<? extends EntityType<? extends T>> type,
                                         EntityRendererProvider<T> rendererProvider);
    }
}
