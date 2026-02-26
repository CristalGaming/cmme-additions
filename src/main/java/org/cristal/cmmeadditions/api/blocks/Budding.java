package org.cristal.cmmeadditions.api.blocks;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.client.renderer.block.MaterialBlockRenderer;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Budding extends Block{

    private final Material material;

    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public static final int GROWTH_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();
    private final Cluster cluster;
    private final Cluster budLarge;
    private final Cluster budMedium;
    private final Cluster budSmall;

    public Budding(
            Cluster cluster,
            Cluster budLarge,
            Cluster budMedium,
            Cluster budSmall,
            Properties properties, Material material, TagPrefix tagPrefix
    ) {
        super(properties);

        this.material = material;

        this.cluster = cluster;
        this.budLarge = budLarge;
        this.budMedium = budMedium;
        this.budSmall = budSmall;

        if(GTCEu.isClientSide()){
            MaterialBlockRenderer.create(this,tagPrefix.materialIconType(),material.getMaterialIconSet());
        }
    }


    public void randomTick(BlockState _blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {

        if (randomSource.nextInt(5) == 0) {

            Direction direction = DIRECTIONS[randomSource.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = blockPos.relative(direction);
            BlockState blockstate = serverLevel.getBlockState(blockpos);
            Block block = null;

            if (canClusterGrowAtState(blockstate)) {
                block = budSmall;
            } else if (blockstate.is(budSmall) && blockstate.getValue(Cluster.FACING) == direction) {
                block = budMedium;
            } else if (blockstate.is(budMedium) && blockstate.getValue(Cluster.FACING) == direction) {
                block = budLarge;
            } else if (blockstate.is(budLarge) && blockstate.getValue(Cluster.FACING) == direction) {
                block = cluster;
            }

            if (block != null) {
                BlockState blockstate1 = block.defaultBlockState().setValue(Cluster.FACING, direction).setValue(Cluster.WATERLOGGED, Boolean.valueOf(blockstate.getFluidState().getType() == Fluids.WATER));
                serverLevel.setBlockAndUpdate(blockpos, blockstate1);
            }

        }
    }

    @OnlyIn(Dist.CLIENT)
    public static BlockColor tintedBlockColor() {
        return (state, reader, pos, tintIndex) -> {
            if (state.getBlock() instanceof Budding block) {
                if (tintIndex == 0)
                    return block.material.getMaterialRGB();
                else if (tintIndex == 1)
                    return block.material.getMaterialSecondaryARGB();
            }
            return -1;
        };
    }

    @OnlyIn(Dist.CLIENT)
    public static ItemColor tintedItemColor() {
        return (stack, tintIndex) -> {
            if (stack.getItem() instanceof BuddingBlockItem item) {
                if (tintIndex == 0)
                    return item.getMaterial().getMaterialRGB();
                else if (tintIndex == 1)
                    return item.getMaterial().getMaterialSecondaryARGB();
            }
            return -1;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }
    public BlockState getStateForDirection(Direction direction) {
        return defaultBlockState().setValue(FACING, direction);
    }

    public static boolean canClusterGrowAtState(BlockState blockState) {
        return blockState.isAir() || blockState.is(Blocks.WATER) && blockState.getFluidState().getAmount() == 8;
    }

}
