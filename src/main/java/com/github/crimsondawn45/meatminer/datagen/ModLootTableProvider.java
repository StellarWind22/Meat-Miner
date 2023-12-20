package com.github.crimsondawn45.meatminer.datagen;

import com.github.crimsondawn45.meatminer.MeatMiner;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider{

    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(MeatMiner.meat_ore.getBlock(), meatOreDrops(MeatMiner.meat_ore.getBlock(), MeatMiner.raw_meat.getItem(), 2.0F, 5.0F));
        addDrop(MeatMiner.deepslate_meat_ore.getBlock(), meatOreDrops(MeatMiner.deepslate_meat_ore.getBlock(), MeatMiner.raw_meat.getItem(), 2.0F, 5.0F));
        addDrop(MeatMiner.nether_meat_ore.getBlock(), meatOreDrops(MeatMiner.nether_meat_ore.getBlock(), MeatMiner.raw_meat.getItem(), 2.0F, 5.0F));
        addDrop(MeatMiner.end_meat_ore.getBlock(), meatOreDrops(MeatMiner.end_meat_ore.getBlock(), MeatMiner.raw_meat.getItem(), 2.0F, 5.0F));
    }

    public LootTable.Builder meatOreDrops(Block drop, Item ore_drop, Float min, Float max) {
      return dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ItemEntry.builder(ore_drop).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
   }
}
