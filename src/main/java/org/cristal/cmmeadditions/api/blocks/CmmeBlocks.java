package org.cristal.cmmeadditions.api.blocks;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.MaterialPipeBlock;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.MaterialPipeBlockItem;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.block.SurfaceRockBlock;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.cristal.cmmeadditions.api.CmmeTagPrefix;
import org.cristal.cmmeadditions.data.CmmeMaterials;

import java.util.Map;

import static net.minecraft.world.level.block.Blocks.*;

public class CmmeBlocks {

    static ImmutableTable.Builder<TagPrefix,Material, BlockEntry<Budding>> BUD_BLOCKS_BUILDER = ImmutableTable.builder();
    static ImmutableTable.Builder<TagPrefix,Material, BlockEntry<Cluster>> CLUSTER_BLOCKS_BUILDER = ImmutableTable.builder();

    public static Table<TagPrefix,Material, BlockEntry<Budding>> BUD_BLOCKS;
    public static Table<TagPrefix,Material, BlockEntry<Cluster>> CLUSTER_BLOCKS;

    public static void generateCrystals() {

        GTCEu.LOGGER.debug("Generating CMME Crystals...");
        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            GTRegistrate registrate = registry.getRegistrate();
            for (Material material : registry.getAllMaterials()) {
                if (material.hasProperty(PropertyKey.ORE) && material.hasProperty(PropertyKey.GEM)) {
                    registerCrystals(material, registrate);
                }
            }
        }
        BUD_BLOCKS = BUD_BLOCKS_BUILDER.build();
        CLUSTER_BLOCKS = CLUSTER_BLOCKS_BUILDER.build();
        GTCEu.LOGGER.debug("Generating CMME Crystals... Complete!");
    }

    @SuppressWarnings("removal")
    private static void registerCrystals(Material material, GTRegistrate registrate) {

        //Budding budding = new Budding(cluster,budLarge,budMedium,budSmall,BlockBehaviour.Properties.copy(BUDDING_AMETHYST),material);

        var clusterEntry = registrate
                .block("%s_cluster".formatted(material.getName()),
                        p->new Cluster(7,3,p,material,CmmeTagPrefix.cluster))
                .initialProperties(() -> Blocks.AMETHYST_CLUSTER)
                .properties(p->p)
                .blockstate(NonNullBiConsumer.noop())
                .transform(GTBlocks.unificationBlock(CmmeTagPrefix.cluster, material))

                .setData(ProviderType.LANG, NonNullBiConsumer.noop())
                .setData(ProviderType.LOOT, NonNullBiConsumer.noop())
                .setData(ProviderType.BLOCKSTATE, NonNullBiConsumer.noop())

                .addLayer(() -> RenderType::cutoutMipped)
                .color(() -> Cluster::tintedBlockColor)

                .item((b,p)->new ClusterBlockItem(b,p,CmmeTagPrefix.cluster,material))
                .color(() -> Cluster::tintedItemColor)
                .setData(ProviderType.ITEM_MODEL, NonNullBiConsumer.noop())
                .model(NonNullBiConsumer.noop())

                .build()
                .register();

        var budLargeEntry = registrate
                .block("large_%s_bud".formatted(material.getName()),
                        p->new Cluster(5,3,p,material,CmmeTagPrefix.budLarge))
                .initialProperties(() -> Blocks.LARGE_AMETHYST_BUD)
                .properties(p->p)
                .blockstate(NonNullBiConsumer.noop())
                .transform(GTBlocks.unificationBlock(CmmeTagPrefix.budLarge, material))

                .setData(ProviderType.LANG, NonNullBiConsumer.noop())
                .setData(ProviderType.LOOT, NonNullBiConsumer.noop())
                .setData(ProviderType.BLOCKSTATE, NonNullBiConsumer.noop())

                .addLayer(() -> RenderType::cutoutMipped)
                .color(() -> Cluster::tintedBlockColor)

                .item((b,p)->new ClusterBlockItem(b,p,CmmeTagPrefix.budLarge,material))
                .color(() -> Cluster::tintedItemColor)
                .setData(ProviderType.ITEM_MODEL, NonNullBiConsumer.noop())
                .model(NonNullBiConsumer.noop())

                .build()
                .register();

        var budMediumEntry = registrate
                .block("medium_%s_bud".formatted(material.getName()),p->
                        new Cluster(4,3,p,material,CmmeTagPrefix.budMedium))
                .initialProperties(() -> Blocks.MEDIUM_AMETHYST_BUD)
                .properties(p->p)
                .blockstate(NonNullBiConsumer.noop())
                .transform(GTBlocks.unificationBlock(CmmeTagPrefix.budMedium, material))

                .setData(ProviderType.LANG, NonNullBiConsumer.noop())
                .setData(ProviderType.LOOT, NonNullBiConsumer.noop())
                .setData(ProviderType.BLOCKSTATE, NonNullBiConsumer.noop())

                .addLayer(() -> RenderType::cutoutMipped)
                .color(() -> Cluster::tintedBlockColor)

                .item((b,p)->new ClusterBlockItem(b,p,CmmeTagPrefix.budMedium,material))
                .color(() -> Cluster::tintedItemColor)
                .setData(ProviderType.ITEM_MODEL, NonNullBiConsumer.noop())
                .model(NonNullBiConsumer.noop())

                .build()
                .register();

        var budSmallEntry = registrate
                .block("small_%s_bud".formatted(material.getName()),
                        p->new Cluster(3,4,p,material,CmmeTagPrefix.budSmall))
                .initialProperties(() -> Blocks.SMALL_AMETHYST_BUD)
                .properties(p->p)
                .blockstate(NonNullBiConsumer.noop())
                .transform(GTBlocks.unificationBlock(CmmeTagPrefix.budSmall, material))

                .setData(ProviderType.LANG, NonNullBiConsumer.noop())
                .setData(ProviderType.LOOT, NonNullBiConsumer.noop())
                .setData(ProviderType.BLOCKSTATE, NonNullBiConsumer.noop())

                .addLayer(() -> RenderType::cutoutMipped)
                .color(() -> Cluster::tintedBlockColor)

                .item((b,p)->new ClusterBlockItem(b,p,CmmeTagPrefix.budSmall,material))
                .color(() -> Cluster::tintedItemColor)
                .setData(ProviderType.ITEM_MODEL, NonNullBiConsumer.noop())
                .model(NonNullBiConsumer.noop())

                .build()
                .register();

        var budding = registrate
                .block("%s_budding".formatted(material.getName()),p->new Budding(
                        clusterEntry.get(),
                        budLargeEntry.get(),
                        budMediumEntry.get(),
                        budSmallEntry.get(),
                        p,material,CmmeTagPrefix.budding
                ))
                .initialProperties(() -> BUDDING_AMETHYST)
                .properties(p->p)
                .blockstate(NonNullBiConsumer.noop())
                .transform(GTBlocks.unificationBlock(CmmeTagPrefix.budding, material))

                .setData(ProviderType.LANG, NonNullBiConsumer.noop())
                .setData(ProviderType.LOOT, NonNullBiConsumer.noop())
                .setData(ProviderType.BLOCKSTATE, NonNullBiConsumer.noop())

                .addLayer(() -> RenderType::cutoutMipped)
                .color(() -> Budding::tintedBlockColor)

                .item((b,p)->new BuddingBlockItem(b,p,CmmeTagPrefix.budding,material))
                .color(() -> Budding::tintedItemColor)
                .setData(ProviderType.ITEM_MODEL, NonNullBiConsumer.noop())
                .model(NonNullBiConsumer.noop())

                .build()
                .register();


        CLUSTER_BLOCKS_BUILDER.put(CmmeTagPrefix.cluster,material,clusterEntry);
        CLUSTER_BLOCKS_BUILDER.put(CmmeTagPrefix.budLarge,material,budLargeEntry);
        CLUSTER_BLOCKS_BUILDER.put(CmmeTagPrefix.budMedium,material,budMediumEntry);
        CLUSTER_BLOCKS_BUILDER.put(CmmeTagPrefix.budSmall,material,budSmallEntry);
        BUD_BLOCKS_BUILDER.put(CmmeTagPrefix.budding,material,budding);

    }
}
