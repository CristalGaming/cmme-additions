package org.cristal.cmmeadditions.api.blocks;


import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;
import com.gregtechceu.gtceu.data.pack.GTDynamicResourcePack;
import com.lowdragmc.lowdraglib.utils.ResourceHelper;
import com.mojang.blaze3d.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.DelegatedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashSet;
import java.util.Set;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ClusterRender {

    private static final Set<ClusterRender> MODELS = new HashSet<>();

    public static void create(Cluster block, MaterialIconType type, MaterialIconSet iconSet) {
        MODELS.add(new ClusterRender(block,type,iconSet));
    }

    private final Block block;
    private final MaterialIconType type;
    private final MaterialIconSet iconSet;

    public static void reinitModels() {
        for (ClusterRender model : MODELS) {
            ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(model.block);
            ResourceLocation modelId = blockId.withPrefix("block/");

            //GTDynamicResourcePack.addBlockModel(modelId, new DelegatedModel( getBlockModelPath(model.iconSet,model.type) ));

            GTDynamicResourcePack.addBlockState(blockId, MultiVariantGenerator
                    .multiVariant(model.block, Variant.variant().with(VariantProperties.MODEL, modelId))
                    .with(PropertyDispatch.property(BlockStateProperties.FACING)
                            .select(Direction.DOWN, Variant.variant())
                            .select(Direction.UP, Variant.variant())
                            .select(Direction.NORTH,
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                            .select(Direction.SOUTH,
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                            .select(Direction.WEST,
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                            .select(Direction.EAST,
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))));
            GTDynamicResourcePack.addItemModel(blockId, new DelegatedModel(modelId));
        }
    }


    public static ResourceLocation getBlockModelPath(MaterialIconSet set,MaterialIconType type) {

        return GTCEu.id(String.format("models/block/material_sets/%s/%s.json", set.name, type.name() ));
    }

    protected ClusterRender(Cluster block, MaterialIconType type, MaterialIconSet iconSet) {
        this.block = block;
        this.type = type;
        this.iconSet = iconSet;
    }
}