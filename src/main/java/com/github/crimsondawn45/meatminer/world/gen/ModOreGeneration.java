package com.github.crimsondawn45.meatminer.world.gen;

import com.github.crimsondawn45.meatminer.world.ModPlacedFeatures;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), 
            GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.MEAT_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), 
            GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.NETHER_MEAT_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), 
            GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.END_MEAT_ORE_PLACED_KEY);
    }
}
