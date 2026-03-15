package org.cristal.cmmeadditions.api.blocks;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.client.renderer.block.MaterialBlockRenderer;
import com.gregtechceu.gtceu.data.pack.GTDynamicResourcePack;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.model.DelegatedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class Cluster extends Block implements SimpleWaterloggedBlock {

    public final Material material;
    public final TagPrefix tagPrefix;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    protected final VoxelShape northAabb;
    protected final VoxelShape southAabb;
    protected final VoxelShape eastAabb;
    protected final VoxelShape westAabb;
    protected final VoxelShape upAabb;
    protected final VoxelShape downAabb;

    public Cluster(int size1, int size2,Properties properties, Material material,TagPrefix tagPrefix) {
        super(properties);
        this.material = material;
        this.tagPrefix = tagPrefix;
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(FACING, Direction.UP));


        this.upAabb =    Block.box(size2,        (0),          size2,        (16 - size2), size1,        (16 - size2));
        this.downAabb =  Block.box(size2,        (16 - size1), size2,        (16 - size2), (16),         (16 - size2));
        this.northAabb = Block.box(size2,        size2,        (16 - size1), (16 - size2), (16 - size2), (16)        );
        this.southAabb = Block.box(size2,        size2,        (0),          (16 - size2), (16 - size2), size1       );
        this.eastAabb =  Block.box((0),          size2,        size2,        size1,        (16 - size2), (16 - size2));
        this.westAabb =  Block.box((16 - size1), size2,        size2,        (16),         (16 - size2), (16 - size2));

        if(GTCEu.isClientSide()){
            //ClusterRender.create(this,tagPrefix.materialIconType(),material.getMaterialIconSet());
            MaterialBlockRenderer.create(this,tagPrefix.materialIconType(),material.getMaterialIconSet());
        }
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        Direction direction = blockState.getValue(FACING);
        switch (direction) {
            case NORTH:
                return this.northAabb;
            case SOUTH:
                return this.southAabb;
            case EAST:
                return this.eastAabb;
            case WEST:
                return this.westAabb;
            case DOWN:
                return this.downAabb;
            case UP:
            default:
                return this.upAabb;
        }
    }


    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        Direction direction = blockState.getValue(FACING);
        BlockPos blockpos = blockPos.relative(direction.getOpposite());
        return levelReader.getBlockState(blockpos).isFaceSturdy(levelReader, blockpos, direction);
    }

    public BlockState updateShape(BlockState p_152036_, Direction direction, BlockState blockState, LevelAccessor levelAccessor, BlockPos blockPos1, BlockPos blockPos2) {
        if (p_152036_.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos1, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return direction == p_152036_.getValue(FACING).getOpposite() && !p_152036_.canSurvive(levelAccessor, blockPos1) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_152036_, direction, blockState, levelAccessor, blockPos1, blockPos2);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        LevelAccessor levelaccessor = blockPlaceContext.getLevel();
        BlockPos blockpos = blockPlaceContext.getClickedPos();
        return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER)).setValue(FACING, blockPlaceContext.getClickedFace());
    }


    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }

    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_152043_) {
        p_152043_.add(WATERLOGGED, FACING);
    }

    public static BlockColor tintedBlockColor() {
        return (state, reader, pos, tintIndex) -> {
            if (state.getBlock() instanceof Cluster block) {
                return block.material.getMaterialRGB();
            }
            return -1;
        };
    }

    public static ItemColor tintedItemColor() {
        return (stack, tintIndex) -> {
            if (stack.getItem() instanceof ClusterBlockItem item) {
                return item.getMaterial().getMaterialRGB();
            }
            return -1;
        };
    }

}
