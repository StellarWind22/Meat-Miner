package me.crimsondawn45.meatminer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.crimsondawn45.meatminer.block.Totem;
import me.crimsondawn45.meatminer.item.ItemFood;
import me.crimsondawn45.meatminer.lists.BlockList;
import me.crimsondawn45.meatminer.lists.ItemList;
import me.crimsondawn45.meatminer.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("cdmmm")
public class MeatMiner {

	public static MeatMiner instance;
	public static final String MODID = "cdmmm";
	private static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public static final ItemGroup MEAT_MINING = new MeatMinerItemGroup();
	
	public MeatMiner()
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
		LOGGER.info("[" + MODID + "]: Setup method registered...");
	}
	
	//Client Registries
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		LOGGER.info("[" + MODID + "]: Client Registries method registered...");
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
					ItemList.mystery_meat = new ItemFood(new Item.Properties().group(MEAT_MINING), 3, 0.15F).setRegistryName(location("mystery_meat")),
					ItemList.cooked_mystery_meat = new ItemFood(new Item.Properties().group(MEAT_MINING), 7, 0.25F).setRegistryName(location("cooked_mystery_meat")),
					
					//Item Blocks
					ItemList.meat_ore = new BlockItem(BlockList.meat_ore, new Item.Properties().group(MEAT_MINING)).setRegistryName(BlockList.meat_ore.getRegistryName()),
					ItemList.nether_meat_ore = new BlockItem(BlockList.nether_meat_ore, new Item.Properties().group(MEAT_MINING)).setRegistryName(BlockList.nether_meat_ore.getRegistryName()),
					ItemList.end_meat_ore = new BlockItem(BlockList.end_meat_ore, new Item.Properties().group(MEAT_MINING)).setRegistryName(BlockList.end_meat_ore.getRegistryName()),
					
					//Totem
					ItemList.totem = new BlockItem(BlockList.totem, new Item.Properties().group(MEAT_MINING)).setRegistryName(BlockList.totem.getRegistryName())
			);
			
			LOGGER.info("[" + MODID + "]: Items Registered...");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			//List Of Blocks
			
			event.getRegistry().registerAll
			(
					//Building
					BlockList.meat_ore = new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0F, 3.0F).harvestLevel(1)).setRegistryName(location("meat_ore")),
					BlockList.nether_meat_ore = new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0F, 3.0F).harvestLevel(1)).setRegistryName(location("nether_meat_ore")),
					BlockList.end_meat_ore = new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4.5F, 4.5F).harvestLevel(1)).setRegistryName(location("end_meat_ore")),
					
					//Totem
					BlockList.totem = new Totem(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0F, 3.0F).harvestLevel(1)).setRegistryName(location("totem"))
			);
			
			LOGGER.info("[" + MODID + "]: Blocks Registered...");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(MODID, name);
		}
	}
}
