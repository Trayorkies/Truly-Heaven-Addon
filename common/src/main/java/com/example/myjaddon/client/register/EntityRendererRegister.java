package com.example.myjaddon.client.register;

import com.example.myjaddon.client.renderer.ExampleStandRenderer;
import com.example.myjaddon.common.register.EntityTypeRegistry;

import static dev.architectury.registry.client.level.entity.EntityRendererRegistry.register;

public interface EntityRendererRegister {
    static void register() {
        register(EntityTypeRegistry.EXAMPLE_STAND, ExampleStandRenderer::new);
    }
}
