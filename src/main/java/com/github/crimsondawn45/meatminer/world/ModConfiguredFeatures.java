package com.github.crimsondawn45.meatminer.world;

import java.util.List;

import com.github.crimsondawn45.meatminer.MeatMiner;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> MEAT_ORE_KEY = registerKey(MeatMiner.meat_ore.getName());
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_MEAT_ORE_KEY = registerKey(MeatMiner.nether_meat_ore.getName());
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_MEAT_ORE_KEY = registerKey(MeatMiner.end_meat_ore.getName());

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endStoneReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworld_meat_ores =
            List.of(OreFeatureConfig.createTarget(stoneReplaceables, MeatMiner.meat_ore.getBlock().getDefaultState()),
                    OreFeatureConfig.createTarget(deepslateReplaceables, MeatMiner.deepslate_meat_ore.getBlock().getDefaultState()));

        List<OreFeatureConfig.Target> nether_meat_ores =
            List.of(OreFeatureConfig.createTarget(netherrackReplaceables, MeatMiner.nether_meat_ore.getBlock().getDefaultState()));

        List<OreFeatureConfig.Target> end_meat_ores =
            List.of(OreFeatureConfig.createTarget(endStoneReplaceables, MeatMiner.end_meat_ore.getBlock().getDefaultState()));

        register(context, MEAT_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworld_meat_ores, 8));
        register(context, NETHER_MEAT_ORE_KEY, Feature.ORE, new OreFeatureConfig(nether_meat_ores, 8));
        register(context, END_MEAT_ORE_KEY, Feature.ORE, new OreFeatureConfig(end_meat_ores, 8));
    }
    
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MeatMiner.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
