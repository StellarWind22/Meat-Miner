package me.crimsondawn45.meatminer.world;

import me.crimsondawn45.meatminer.lists.BlockList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration 
{	
	//Custom Ore Feature Instance
	private static final CustomOreFeature END_STONE = new CustomOreFeature(null);
	
	//Setup Generation
	public static void SetupOreGeneration()
	{
		
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			//Overworld
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.meat_ore.getDefaultState(), 7), Placement.COUNT_RANGE, new CountRangeConfig(10, 4, 0, 55)));
			
			//Nether
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK, BlockList.nether_meat_ore.getDefaultState(), 9), Placement.COUNT_RANGE, new CountRangeConfig(10, 4, 0, 124)));
			
			//End
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(END_STONE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.end_meat_ore.getDefaultState(), 9), Placement.COUNT_RANGE, new CountRangeConfig(10, 4, 0, 124)));
		}
	}
}
