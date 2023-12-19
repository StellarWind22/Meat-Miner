package com.github.crimsondawn45.food;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    
    //This is just a copy of beef's stats
    public static final FoodComponent RAW_MEAT_COMPONENT = new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).meat().build();
    public static final FoodComponent COOKED_MEAT_COMPONENT = new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).meat().build();
}
