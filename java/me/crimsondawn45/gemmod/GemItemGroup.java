package me.crimsondawn45.gemmod;

import me.crimsondawn45.gemmod.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GemItemGroup extends ItemGroup {

	public GemItemGroup()
	{
		super("gem");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(ItemList.amethyst);
	}

}
