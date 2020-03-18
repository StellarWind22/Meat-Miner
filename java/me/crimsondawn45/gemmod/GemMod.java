package me.crimsondawn45.gemmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.crimsondawn45.gemmod.item.ItemModAxe;
import me.crimsondawn45.gemmod.item.ItemModPickaxe;
import me.crimsondawn45.gemmod.lists.BlockList;
import me.crimsondawn45.gemmod.lists.ItemList;
import me.crimsondawn45.gemmod.lists.ToolMaterialList;
import me.crimsondawn45.gemmod.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("cdgm")
public class GemMod {

	public static GemMod instance;
	public static final String modid = "cdgm";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup gem = new GemItemGroup();
	
	public GemMod()
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	//Setup
	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.SetupOreGeneration();
		logger.info("[" + modid + "]: Setup method registered...");
	}
	
	//Client Registries
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("[" + modid + "]: Client Registries method registered...");
	}
	
	//Registry Events Class
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			//List Of Items
			
			event.getRegistry().registerAll
			(
					//Items
					ItemList.amethyst = new Item(new Item.Properties().group(gem)).setRegistryName(location("amethyst")),
					
					//Tool
					ItemList.amethyst_axe = new ItemModAxe(ToolMaterialList.amethyst, 2.0F, -3.0F , new Item.Properties().group(gem)).setRegistryName(location("amethyst_axe")),
					ItemList.amethyst_hoe = new ItemHoe(ToolMaterialList.amethyst, 0.0F, new Item.Properties().group(gem)).setRegistryName(location("amethyst_hoe")),
					ItemList.amethyst_pickaxe = new ItemModPickaxe(ToolMaterialList.amethyst, -2, -2.8F, new Item.Properties().group(gem)).setRegistryName(location("amethyst_pickaxe")),
					ItemList.amethyst_shovel = new ItemSpade(ToolMaterialList.amethyst, -1.5F, -3.0F, new Item.Properties().group(gem)).setRegistryName(location("amethyst_shovel")),
					ItemList.amethyst_sword = new ItemSword(ToolMaterialList.amethyst, 0 , -2.4F, new Item.Properties().group(gem)).setRegistryName(location("amethyst_sword")),
					
					//Item Blocks
						//Building
					ItemList.amethyst_block = new ItemBlock(BlockList.amethyst_block, new Item.Properties().group(gem)).setRegistryName(BlockList.amethyst_block.getRegistryName()),
					
						//Ores
					ItemList.amethyst_ore = new ItemBlock(BlockList.amethyst_ore, new Item.Properties().group(gem)).setRegistryName(BlockList.amethyst_ore.getRegistryName()),
					ItemList.amethyst_ore_nether = new ItemBlock(BlockList.amethyst_ore_nether, new Item.Properties().group(gem)).setRegistryName(BlockList.amethyst_ore_nether.getRegistryName()),
					ItemList.amethyst_ore_end = new ItemBlock(BlockList.amethyst_ore_end, new Item.Properties().group(gem)).setRegistryName(BlockList.amethyst_ore_end.getRegistryName())
			);
			
			logger.info("[" + modid + "]: Items Registered...");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			//List Of Blocks
			
			event.getRegistry().registerAll
			(
					//Building
					BlockList.amethyst_block = new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(0.9F, 0.65F)).setRegistryName(location("amethyst_block")),
					
					//Ores
					BlockList.amethyst_ore = new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(0.9F, 0.65F)).setRegistryName(location("amethyst_ore")),
					BlockList.amethyst_ore_nether = new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(0.9F, 0.65F)).setRegistryName(location("amethyst_ore_nether")),
					BlockList.amethyst_ore_end = new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(0.9F, 0.65F)).setRegistryName(location("amethyst_ore_end"))
			);
			
			logger.info("[" + modid + "]: Blocks Registered...");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}
}
