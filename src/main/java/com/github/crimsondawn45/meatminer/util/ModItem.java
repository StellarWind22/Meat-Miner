package com.github.crimsondawn45.meatminer.util;

import java.util.ArrayList;
import java.util.List;

import com.github.crimsondawn45.meatminer.MeatMiner;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItem {

    private String name;
    private Identifier identifier;
    private Item item;

    public static final List<ModItem> modItems = new ArrayList<ModItem>();

    public ModItem(String name, Item item) {
        this.name = name;
        this.identifier = new Identifier(MeatMiner.MOD_ID, name);
        this.item = item;

        Registry.register(Registries.ITEM, this.identifier, this.item);
        modItems.add(this);
    }

    public Item getItem() {
        return this.item;
    }

    public Identifier getIdentifier() {
        return this.identifier;
    }

    public String getName() {
        return this.name;
    }
}