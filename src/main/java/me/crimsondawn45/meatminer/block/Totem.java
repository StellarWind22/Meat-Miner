package me.crimsondawn45.meatminer.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Totem extends Block implements IGrowable {
	public static final BooleanProperty ACTIVE = BlockStateProperties.ENABLED;

	public Totem(Properties properties) {
		super(properties);
		this.setDefaultState(this.getDefaultState().with(ACTIVE, Boolean.valueOf(false)));
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return worldIn.getBlockState(pos).equals(this.getDefaultState().with(ACTIVE, Boolean.valueOf(true)));
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return false;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
		//Random Grass Death function here
		
	}

	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
	      if (worldIn.isRemote) {
	         return true;
	      } else {
	    	  if(worldIn.getBlockState(pos).equals(this.getDefaultState().with(ACTIVE, Boolean.valueOf(false)))) {
	    		  worldIn.playSound(pos.getX(), pos.up().getY(), pos.getZ(), SoundEvents.BLOCK_BELL_RESONATE, SoundCategory.BLOCKS, 2.0F, 0.0F, false);
	    		  worldIn.setBlockState(pos, this.getDefaultState().with(ACTIVE, Boolean.valueOf(true)));
	    	  } else {
	    		  //Spooky Stuff Goes Here
	    		  return true;
	    	  }
	         return true;
	      }
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	      builder.add(ACTIVE);
	 }
	
	@Override
	public BlockRenderType getRenderType(BlockState state) {
	      return BlockRenderType.MODEL;
	}
	
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
	      return false;
	}
	
	@Override
	public BlockRenderLayer getRenderLayer() {
	      return BlockRenderLayer.CUTOUT;
	}
}
