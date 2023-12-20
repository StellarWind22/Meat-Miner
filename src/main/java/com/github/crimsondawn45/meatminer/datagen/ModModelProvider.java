package com.github.crimsondawn45.meatminer.datagen;

import com.github.crimsondawn45.meatminer.MeatMiner;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
       blockStateModelGenerator.registerSimpleCubeAll(MeatMiner.meat_ore.getBlock());
       blockStateModelGenerator.registerSimpleCubeAll(MeatMiner.deepslate_meat_ore.getBlock());
       blockStateModelGenerator.registerSimpleCubeAll(MeatMiner.nether_meat_ore.getBlock());
       blockStateModelGenerator.registerSimpleCubeAll(MeatMiner.end_meat_ore.getBlock());
       blockStateModelGenerator.registerSimpleCubeAll(MeatMiner.raw_meat_block.getBlock());
       blockStateModelGenerator.registerSimpleCubeAll(MeatMiner.cooked_meat_block.getBlock());
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(MeatMiner.raw_meat.getItem(), Models.GENERATED);
        itemModelGenerator.register(MeatMiner.cooked_meat.getItem(), Models.GENERATED);
    }
}
