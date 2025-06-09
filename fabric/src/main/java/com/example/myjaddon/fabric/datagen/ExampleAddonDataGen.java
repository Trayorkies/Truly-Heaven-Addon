package com.example.myjaddon.fabric.datagen;

import com.example.myjaddon.fabric.datagen.movesets.ExampleStandMoveSetProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ExampleAddonDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGen) {
        FabricDataGenerator.Pack pack = dataGen.createPack();
        pack.addProvider(ExampleStandMoveSetProvider::new);
        pack.addProvider(ExampleAddonStandDataProvider::new);
    }
}
