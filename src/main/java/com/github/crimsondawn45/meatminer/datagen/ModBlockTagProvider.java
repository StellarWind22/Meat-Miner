package com.github.crimsondawn45.meatminer.datagen;

import java.util.concurrent.CompletableFuture;

import com.github.crimsondawn45.meatminer.MeatMiner;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.BlockTags;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(WrapperLookup arg) {
       getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(MeatMiner.meat_ore.getBlock())
            .add(MeatMiner.deepslate_meat_ore.getBlock())
            .add(MeatMiner.nether_meat_ore.getBlock())
            .add(MeatMiner.end_meat_ore.getBlock());
    }
}
