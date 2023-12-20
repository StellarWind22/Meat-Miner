package com.github.crimsondawn45.meatminer.world;

import java.util.List;

import com.github.crimsondawn45.meatminer.MeatMiner;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> MEAT_ORE_PLACED_KEY = registerKey(MeatMiner.meat_ore.getName() + "_placed");
    public static final RegistryKey<PlacedFeature> NETHER_MEAT_ORE_PLACED_KEY = registerKey(MeatMiner.nether_meat_ore.getName() + "_placed");
    public static final RegistryKey<PlacedFeature> END_MEAT_ORE_PLACED_KEY = registerKey(MeatMiner.end_meat_ore.getName() + "_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, MEAT_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MEAT_ORE_KEY), ModOrePlacement.modifiersWithCount(8, HeightRangePlacementModifier.uniform(YOffset.BOTTOM, YOffset.TOP)));

        register(context, NETHER_MEAT_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_MEAT_ORE_KEY), ModOrePlacement.modifiersWithCount(8, HeightRangePlacementModifier.uniform(YOffset.BOTTOM, YOffset.TOP)));

        register(context, END_MEAT_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.END_MEAT_ORE_KEY), ModOrePlacement.modifiersWithCount(8, HeightRangePlacementModifier.uniform(YOffset.BOTTOM, YOffset.TOP)));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MeatMiner.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
