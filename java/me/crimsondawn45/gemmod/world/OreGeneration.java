package me.crimsondawn45.gemmod.world;

import java.util.function.Predicate;

import me.crimsondawn45.gemmod.lists.BlockList;
import me.crimsondawn45.gemmod.world.DimensionalGenerator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.CompositeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRange;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration 
{
	private static final Predicate<IBlockState> IS_NETHERRACK = state -> state.getBlock() == Blocks.NETHERRACK;
	private static final Predicate<IBlockState> IS_END_STONE = state -> state.getBlock() == Blocks.END_STONE;
	
	
	public static void SetupOreGeneration()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			//Overworld
			CountRangeConfig amethyst_ore_placement = new CountRangeConfig(1, 0, 0, 25);
			biome.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.amethyst_ore.getDefaultState(), 1), new CountRange(), amethyst_ore_placement));
			
			//Nether
			CountRangeConfig amethyst_ore_nether_placement = new CountRangeConfig(1, 7, 7, 120);
			biome.addFeature(Decoration.UNDERGROUND_ORES, new DimensionalGenerator<>(Feature.MINABLE, new MinableConfig(IS_NETHERRACK, BlockList.amethyst_ore_nether.getDefaultState(), 1), new CountRange(), amethyst_ore_nether_placement, DimensionType.NETHER));
			
			//End
			CountRangeConfig amethyst_ore_end_placement = new CountRangeConfig(2, 5, 5, 35);
			biome.addFeature(Decoration.UNDERGROUND_ORES, new DimensionalGenerator<>(Feature.MINABLE, new MinableConfig(IS_END_STONE, BlockList.amethyst_ore_end.getDefaultState(), 8), new CountRange(), amethyst_ore_end_placement, DimensionType.THE_END));
		}
	}
}
