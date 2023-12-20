package com.github.crimsondawn45.meatminer;

import com.github.crimsondawn45.meatminer.datagen.ModBlockTagProvider;
import com.github.crimsondawn45.meatminer.datagen.ModItemTagProvider;
import com.github.crimsondawn45.meatminer.datagen.ModLootTableProvider;
import com.github.crimsondawn45.meatminer.datagen.ModModelProvider;
import com.github.crimsondawn45.meatminer.datagen.ModRecipeProvider;
import com.github.crimsondawn45.meatminer.datagen.ModWorldGenerator;
import com.github.crimsondawn45.meatminer.world.ModConfiguredFeatures;
import com.github.crimsondawn45.meatminer.world.ModPlacedFeatures;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class MeatMinerDataGen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        
        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModWorldGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder builder) {
        builder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        builder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}
