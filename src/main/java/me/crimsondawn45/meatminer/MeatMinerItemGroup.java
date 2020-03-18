package me.crimsondawn45.meatminer;

import me.crimsondawn45.meatminer.lists.BlockList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MeatMinerItemGroup extends ItemGroup {

	public MeatMinerItemGroup()
	{
		super("meat_mining");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(Item.BLOCK_TO_ITEM.get(BlockList.meat_ore));
	}

}
