package com.example.myjaddon.client.renderer.model;

import com.example.myjaddon.common.register.StandTypeRegistry;
import com.example.myjaddon.common.stand.ExampleStandEntity;
import net.arna.jcraft.client.model.entity.stand.StandEntityModel;

public class ExampleStandModel extends StandEntityModel<ExampleStandEntity> {
    public ExampleStandModel() {
        super(StandTypeRegistry.EXAMPLE_STAND.get());
    }
}
