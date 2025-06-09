package com.example.myjaddon.common.register;

import com.example.myjaddon.ExampleAddon;
import com.example.myjaddon.common.stand.ExampleStandEntity;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public interface EntityTypeRegistry {
    DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ExampleAddon.MOD_ID, Registries.ENTITY_TYPE);

    RegistrySupplier<EntityType<ExampleStandEntity>> EXAMPLE_STAND = REGISTRY.register("example_stand", () ->
            EntityType.Builder.of((EntityType.EntityFactory<ExampleStandEntity>)
                            (t, level) -> new ExampleStandEntity(level),
                            MobCategory.CREATURE)
                    .sized(0.6f, 1.8f)
                    .build("example_stand"));

    static void registerAttributes() {
        EntityAttributeRegistry.register(EXAMPLE_STAND, ExampleStandEntity::createMobAttributes);
    }
}
