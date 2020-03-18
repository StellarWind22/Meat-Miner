package me.crimsondawn45.meatminer.item;

import me.crimsondawn45.meatminer.MeatMiner;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class ItemFood extends Item{

	public ItemFood(Properties group, int hunger, float saturation) {
		 super(new Properties().group(MeatMiner.MEAT_MINING).food(new Food.Builder().saturation(saturation).hunger(hunger).build()));
	}

}
