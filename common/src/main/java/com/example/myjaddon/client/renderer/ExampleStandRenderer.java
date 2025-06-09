package com.example.myjaddon.client.renderer;

import com.example.myjaddon.client.renderer.model.ExampleStandModel;
import com.example.myjaddon.common.stand.ExampleStandEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import net.arna.jcraft.client.renderer.entity.stands.StandEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ExampleStandRenderer extends StandEntityRenderer<ExampleStandEntity> {
    public ExampleStandRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ExampleStandModel());
    }

    @Override
    public void actuallyRender(PoseStack poseStack, ExampleStandEntity animatable, BakedGeoModel model, RenderType renderType,
                               MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick,
                               int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        float a = getAlpha(animatable, partialTick);
        super.actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, isReRender, partialTick,
                packedLight, packedOverlay, red, green, blue, a);
    }
}
