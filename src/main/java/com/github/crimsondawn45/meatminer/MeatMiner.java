package com.github.crimsondawn45.meatminer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.crimsondawn45.meatminer.food.ModFoodComponents;
import com.github.crimsondawn45.meatminer.util.ModBlock;
import com.github.crimsondawn45.meatminer.util.ModItem;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup.Builder;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MeatMiner implements ModInitializer {

	public static final String MOD_ID = "meatminer";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static ModBlock meat_ore;
	public static ModBlock deepslate_meat_ore;
	public static ModBlock nether_meat_ore;
	public static ModBlock end_meat_ore;

	public static ModItem raw_meat;
	public static ModItem cooked_meat;

	public static final Builder MEAT_GROUP = FabricItemGroup.builder()
		.icon(() -> new ItemStack(meat_ore.getItem()))
		.displayName(Text.translatable("itemGroup.meatminer.meat_group"));

	@Override
	public void onInitialize() {

		meat_ore = new ModBlock("meat_ore", new BlockItem(new Block(FabricBlockSettings.copyOf(Blocks.STONE)), new FabricItemSettings()));
		deepslate_meat_ore = new ModBlock("deepslate_meat_ore", new BlockItem(new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)), new FabricItemSettings()));
		nether_meat_ore = new ModBlock("nether_meat_ore", new BlockItem(new Block(FabricBlockSettings.copyOf(Blocks.NETHERRACK)), new FabricItemSettings()));
		end_meat_ore = new ModBlock("end_meat_ore", new BlockItem(new Block(FabricBlockSettings.copyOf(Blocks.END_STONE)), new FabricItemSettings()));

		raw_meat = new ModItem("raw_meat", new Item(new FabricItemSettings().food(ModFoodComponents.RAW_MEAT_COMPONENT)));
		cooked_meat = new ModItem("cooked_meat", new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_MEAT_COMPONENT)));

		MEAT_GROUP.entries((context, entries) -> {

			for(ModItem item : ModItem.modItems) {
				entries.add(item.getItem());
			}
		});

		//Register item group
		Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "meat_group"), MEAT_GROUP.build());

		LOGGER.info("Meat Miner initialized.");
	}
}