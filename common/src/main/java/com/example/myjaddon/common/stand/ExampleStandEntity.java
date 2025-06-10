package com.example.myjaddon.common.stand;

import com.example.myjaddon.common.register.StandTypeRegistry;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.core.animation.RawAnimation;
import net.arna.jcraft.JCraft;
import net.arna.jcraft.api.attack.MoveMap;
import net.arna.jcraft.api.attack.MoveSet;
import net.arna.jcraft.api.attack.MoveSetManager;
import net.arna.jcraft.api.attack.enums.MoveClass;
import net.arna.jcraft.api.stand.StandData;
import net.arna.jcraft.api.stand.StandEntity;
import net.arna.jcraft.api.stand.StandInfo;
import net.arna.jcraft.common.attack.moves.shared.MainBarrageAttack;
import net.arna.jcraft.common.attack.moves.shared.SimpleAttack;
import net.arna.jcraft.common.util.StandAnimationState;
import net.arna.jcraft.registry.JSoundRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class ExampleStandEntity extends StandEntity<ExampleStandEntity, ExampleStandEntity.State> {
    public static final MoveSet<ExampleStandEntity, State> MOVE_SET = MoveSetManager.create(StandTypeRegistry.EXAMPLE_STAND,
            ExampleStandEntity::registerMoves, State.class);
    public static final StandData DATA = StandData.of(StandInfo.of(Component.literal("Example Stand")));

    public static final SimpleAttack<ExampleStandEntity> LIGHT = new SimpleAttack<ExampleStandEntity>(JCraft.LIGHT_COOLDOWN,
            5, 8, 0.75f, 5f, 16, 1.5f, 0.2f, -0.1f)
            .withImpactSound(JSoundRegistry.IMPACT_1)
            .withInfo(
                    Component.literal("Punch"),
                    Component.literal("An example punch attack")
            );
    public static final MainBarrageAttack<ExampleStandEntity> BARRAGE = new MainBarrageAttack<ExampleStandEntity>(280,
            0, 40, 0.75f, 1f, 30, 2f, 0.25f, 0f, 3, Blocks.OBSIDIAN.defaultDestroyTime())
            .withSound(JSoundRegistry.STAR_PLATINUM_BARRAGE)
            .withInfo(
                    Component.translatable("jcraft.generic.barrage"),
                    Component.literal("An example barrage attack")
            );

    public ExampleStandEntity(Level world) {
        super(StandTypeRegistry.EXAMPLE_STAND.get(), world);
    }

    private static void registerMoves(MoveMap<ExampleStandEntity, State> moveMap) {
        moveMap.register(MoveClass.LIGHT, LIGHT, State.LIGHT);
        moveMap.register(MoveClass.HEAVY, LIGHT, State.LIGHT);
        moveMap.register(MoveClass.BARRAGE, BARRAGE, State.BARRAGE);
    }

    @NotNull
    @Override
    public ExampleStandEntity getThis() {
        return this;
    }

    @Override
    protected State[] getStateValues() {
        return State.values();
    }

    @Override
    public State getBlockState() {
        return State.BLOCK;
    }

    @Override
    protected @Nullable String getSummonAnimation() {
        return "summon";
    }

    public enum State implements StandAnimationState<ExampleStandEntity> {
        IDLE(builder -> builder.setAnimation(RawAnimation.begin().thenLoop("idle"))),
        LIGHT(builder -> builder.setAnimation(RawAnimation.begin().thenPlayAndHold("light"))),
        BLOCK(builder -> builder.setAnimation(RawAnimation.begin().thenLoop("block"))),
        BARRAGE(builder -> builder.setAnimation(RawAnimation.begin().thenLoop("barrage")));

        private final Consumer<AnimationState<ExampleStandEntity>> animator;

        State(Consumer<AnimationState<ExampleStandEntity>> animator) {
            this.animator = animator;
        }

        @Override
        public void playAnimation(ExampleStandEntity attacker, AnimationState<ExampleStandEntity> builder) {
            animator.accept(builder);
        }
    }
}
