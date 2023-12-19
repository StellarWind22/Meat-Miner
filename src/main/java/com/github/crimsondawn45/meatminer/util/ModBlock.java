package com.github.crimsondawn45.meatminer.util;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlock extends ModItem {

    private Block block;

    public ModBlock(String name, BlockItem item) {
        super(name, item);
        this.block = item.getBlock();

        Registry.register(Registries.BLOCK, this.getIdentifier(), this.block);
    }

    public Block getBlock() {
        return this.block;
    }
}
