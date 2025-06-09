package com.example.myjaddon.client.renderer;

import com.example.myjaddon.client.renderer.model.ExampleStandModel;
import com.example.myjaddon.common.stand.ExampleStandEntity;
import net.arna.jcraft.client.renderer.entity.stands.StandEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ExampleStandRenderer extends StandEntityRenderer<ExampleStandEntity> {
    public ExampleStandRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ExampleStandModel());
    }
}
