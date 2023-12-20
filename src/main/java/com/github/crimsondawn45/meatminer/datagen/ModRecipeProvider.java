package com.github.crimsondawn45.meatminer.datagen;

import java.util.List;

import com.github.crimsondawn45.meatminer.MeatMiner;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> meat_smeltables = List.of(
        MeatMiner.raw_meat.getItem(),
        MeatMiner.meat_ore.getItem(),
        MeatMiner.deepslate_meat_ore.getItem(),
        MeatMiner.nether_meat_ore.getItem(),
        MeatMiner.end_meat_ore.getItem()
    );

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, meat_smeltables, RecipeCategory.FOOD, MeatMiner.cooked_meat.getItem(), 0.35F, 200, MeatMiner.cooked_meat.getName());
        offerSmoking(exporter, meat_smeltables, RecipeCategory.FOOD, MeatMiner.cooked_meat.getItem(), 0.35F, 100, MeatMiner.cooked_meat.getName());
        offerCampfire(exporter, meat_smeltables, RecipeCategory.FOOD, MeatMiner.cooked_meat.getItem(), 0.35F, 600, MeatMiner.cooked_meat.getName());
    }

    private static void offerSmoking(RecipeExporter exporter, List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group) {
      offerMultipleOptions(exporter, RecipeSerializer.SMOKING, SmokingRecipe::new, inputs, category, output, experience, cookingTime, group, "_from_smoking");
    }

    private static void offerCampfire(RecipeExporter exporter, List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group) {
      offerMultipleOptions(exporter, RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, inputs, category, output, experience, cookingTime, group, "_from_campfire");
    }
}
