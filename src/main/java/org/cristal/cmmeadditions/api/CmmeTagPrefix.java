package org.cristal.cmmeadditions.api;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.MaterialBlock;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.data.tag.TagUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.SoundType;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.Conditions.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.pipeLargeItem;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.pipeLargeRestrictive;
import static org.cristal.cmmeadditions.api.CmmeMaterialFlags.*;
@SuppressWarnings("unused")
public class CmmeTagPrefix {

    public static final TagPrefix doubleIngot = new TagPrefix("doubleIngot")
            .idPattern("double_%s_ingot")
            .defaultTagPath("double_ingots/%s")
            .unformattedTagPath("double_ingots")
            .langValue("Double %s Ingot")
            .materialAmount(GTValues.M*2)
            .maxStackSize(32)
            .materialIconType(MaterialIconType.ingotDouble)
            .unificationEnabled(true)
            .enableRecycling()
            .generateItem(true)
            .generationCondition(hasIngotProperty.and(mat -> mat.hasFlag(GENERATE_DOUBLE_INGOT)));

    public static final TagPrefix tripleIngot = new TagPrefix("tripleIngot")
            .idPattern("triple_%s_ingot")
            .defaultTagPath("triple_ingots/%s")
            .unformattedTagPath("triple_ingots")
            .langValue("Triple %s Ingot")
            .materialAmount(GTValues.M*3)
            .maxStackSize(32)
            .materialIconType(MaterialIconType.ingotTriple)
            .unificationEnabled(true)
            .enableRecycling()
            .generateItem(true)
            .generationCondition(hasIngotProperty.and(mat -> mat.hasFlag(GENERATE_TRIPLE_INGOT)));

    public static final TagPrefix quadrupleIngot = new TagPrefix("quadrupleIngot")
            .idPattern("quadruple_%s_ingot")
            .defaultTagPath("quadruple_ingots/%s")
            .unformattedTagPath("quadruple_ingots")
            .langValue("Quadruple %s Ingot")
            .materialAmount(GTValues.M*4)
            .maxStackSize(32)
            .materialIconType(MaterialIconType.ingotQuadruple)
            .unificationEnabled(true)
            .enableRecycling()
            .generateItem(true)
            .generationCondition(hasIngotProperty.and(mat -> mat.hasFlag(GENERATE_QUADRUPLE_INGOT)));

    public static final TagPrefix quintupleIngot = new TagPrefix("quintupleIngot")
            .idPattern("quintuple_%s_ingot")
            .defaultTagPath("quintuple_ingots/%s")
            .unformattedTagPath("quintuple_ingots")
            .langValue("Quintuple %s Ingot")
            .materialAmount(GTValues.M*5)
            .maxStackSize(32)
            .materialIconType(MaterialIconType.ingotQuintuple)
            .unificationEnabled(true)
            .enableRecycling()
            .generateItem(true)
            .generationCondition(hasIngotProperty.and(mat -> mat.hasFlag(GENERATE_QUINTUPLE_INGOT)));

    public static final TagPrefix curvedPlate = new TagPrefix("curvedPlate")
            .idPattern("curved_%s_plate")
            .defaultTagPath("curved_plates/%s")
            .unformattedTagPath("curved_plates")
            .langValue("Curved %s Plate")
            .materialAmount(GTValues.M)
            .maxStackSize(64)
            .materialIconType(new MaterialIconType("plateCurved"))
            .unificationEnabled(true)
            .enableRecycling()
            .generateItem(true)
            .generationCondition(hasDustProperty.and(mat -> mat.hasFlag(GENERATE_CURVED_PLATE)));

    public static final TagPrefix triplePlate = new TagPrefix("triplePlate")
            .idPattern("triple_%s_plate")
            .defaultTagPath("triple_plates/%s")
            .unformattedTagPath("triple_plates")
            .langValue("Triple %s Plate")
            .materialAmount(GTValues.M*3)
            .maxStackSize(32)
            .materialIconType(MaterialIconType.plateTriple)
            .unificationEnabled(true)
            .enableRecycling()
            .generateItem(true)
            .generationCondition(hasDustProperty.and(mat -> mat.hasFlag(GENERATE_TRIPLE_PLATE)));

    public static final TagPrefix quadruplePlate = new TagPrefix("quadruplePlate")
            .idPattern("quadruple_%s_plate")
            .defaultTagPath("quadruple_plates/%s")
            .unformattedTagPath("quadruple_plates")
            .langValue("Quadruple %s Plate")
            .materialAmount(GTValues.M*4)
            .maxStackSize(32)
            .materialIconType(MaterialIconType.plateQuadruple)
            .unificationEnabled(true)
            .enableRecycling()
            .generateItem(true)
            .generationCondition(hasDustProperty.and(mat -> mat.hasFlag(GENERATE_QUADRUPLE_PLATE)));

    public static final TagPrefix quintuplePlate = new TagPrefix("quintuplePlate")
            .idPattern("quintuple_%s_plate")
            .defaultTagPath("quintuple_plates/%s")
            .unformattedTagPath("quintuple_plates")
            .langValue("Quintuple %s Plate")
            .materialAmount(GTValues.M*5)
            .maxStackSize(32)
            .materialIconType(MaterialIconType.plateQuintuple)
            .unificationEnabled(true)
            .enableRecycling()
            .generateItem(true)
            .generationCondition(hasDustProperty.and(mat -> mat.hasFlag(GENERATE_QUINTUPLE_PLATE)));

    public static final TagPrefix superdensePlate = new TagPrefix("superdensePlate")
            .idPattern("superdense_%s_plate")
            .defaultTagPath("superdense_plates/%s")
            .unformattedTagPath("superdense_plates")
            .langValue("Superdense %s Plate")
            .materialAmount(GTValues.M*64)
            .maxStackSize(16)
            .materialIconType(new MaterialIconType("plateSuperdense"))
            .unificationEnabled(true)
            .enableRecycling()
            .generateItem(true)
            .generationCondition(hasDustProperty.and(mat -> mat.hasFlag(GENERATE_QUINTUPLE_PLATE)));

    public static final TagPrefix broadRod = new TagPrefix("broadRod")
            .idPattern("%s_broad_rod")
            .defaultTagPath("broad_rods/%s")
            .unformattedTagPath("broad_rods")
            .langValue("%s Broad Rod Plate")
            .materialAmount(GTValues.M)
            .maxStackSize(64)
            .materialIconType(new MaterialIconType("rodBroad"))
            .unificationEnabled(true)
            .enableRecycling()
            .generateItem(true)
            .generationCondition(hasDustProperty.and(mat -> mat.hasFlag(GENERATE_BROAD_ROD)));

    public static final TagPrefix tube = new TagPrefix("tube")
            .idPattern("%s_tube")
            .defaultTagPath("tubes/%s")
            .unformattedTagPath("tubes")
            .langValue("%s Tube")
            .materialAmount(GTValues.M/2)
            .maxStackSize(64)
            .materialIconType(new MaterialIconType("tube"))
            .unificationEnabled(true)
            .enableRecycling()
            .generateItem(true)
            .generationCondition(hasDustProperty.and(mat -> mat.hasFlag(GENERATE_TUBE)));

    public static final TagPrefix singularity = new TagPrefix("singularity")
            .idPattern("%s_singularity")
            .defaultTagPath("singularities/%s")
            .unformattedTagPath("singularities")
            .langValue("%s Singularity")
            .materialIconType(new MaterialIconType("singularity"))
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> mat.hasFlag(GENERATE_SINGULARITY));

    public static final TagPrefix crushedOreBlock = new TagPrefix("crushedOreBlock")
            .defaultTagPath("storage_blocks/crushed_ores/%s")
            .unformattedTagPath("storage_blocks/crushed_ores")
            .unformattedTagPath("storage_blocks")
            .langValue("Block of Crushed %s Ore")
            .materialIconType(new MaterialIconType("crushedOreBlock"))
            .materialAmount(GTValues.M * 9)
            .miningToolTag(BlockTags.MINEABLE_WITH_SHOVEL)
            .generateBlock(true)
            .blockConstructor((properties, prefix, material) -> new MaterialBlock(properties.sound(SoundType.GRAVEL),prefix,material))
            .generationCondition(hasOreProperty.and(mat -> mat.hasFlag(GENERATE_FULLBLOCK_ORE_PROCESSING)))
            .unificationEnabled(true);
    public static final TagPrefix purifiedOreBlock = new TagPrefix("purifiedOreBlock")
            .defaultTagPath("storage_blocks/purified_ores/%s")
            .unformattedTagPath("storage_blocks/purified_ores")
            .unformattedTagPath("storage_blocks")
            .langValue("Block of Purified %s Ore")
            .materialIconType(new MaterialIconType("purifiedOreBlock"))
            .materialAmount(GTValues.M * 9)
            .miningToolTag(BlockTags.MINEABLE_WITH_SHOVEL)
            .generateBlock(true)
            .blockConstructor((properties, prefix, material) -> new MaterialBlock(properties.sound(SoundType.GRAVEL),prefix,material))
            .generationCondition(hasOreProperty.and(mat -> mat.hasFlag(GENERATE_FULLBLOCK_ORE_PROCESSING)))
            .unificationEnabled(true);
    public static final TagPrefix refinedOreBlock = new TagPrefix("refinedOreBlock")
            .defaultTagPath("storage_blocks/refined_ores/%s")
            .unformattedTagPath("storage_blocks/refined_ores")
            .unformattedTagPath("storage_blocks")
            .langValue("Block of Refined %s Ore")
            .materialIconType(new MaterialIconType("refinedOreBlock"))
            .materialAmount(GTValues.M * 9)
            .miningToolTag(BlockTags.MINEABLE_WITH_SHOVEL)
            .generateBlock(true)
            .blockConstructor((properties, prefix, material) -> new MaterialBlock(properties.sound(SoundType.GRAVEL),prefix,material))
            .generationCondition(hasOreProperty.and(mat -> mat.hasFlag(GENERATE_FULLBLOCK_ORE_PROCESSING)))
            .unificationEnabled(true);
    public static final TagPrefix dustImpureBlock = new TagPrefix("dustImpureBlock")
            .defaultTagPath("storage_blocks/impure_dusts/%s")
            .unformattedTagPath("storage_blocks/impure_dusts")
            .unformattedTagPath("storage_blocks")
            .langValue("Block of Impure %s Dust")
            .materialIconType(new MaterialIconType("dustImpureBlock"))
            .materialAmount(GTValues.M * 9)
            .miningToolTag(BlockTags.MINEABLE_WITH_SHOVEL)
            .generateBlock(true)
            .blockConstructor((properties, prefix, material) -> new MaterialBlock(properties.sound(SoundType.SAND),prefix,material))
            .generationCondition(hasOreProperty.and(mat -> mat.hasFlag(GENERATE_FULLBLOCK_ORE_PROCESSING)))
            .unificationEnabled(true);
    public static final TagPrefix dustPureBlock = new TagPrefix("dustPureBlock")
            .defaultTagPath("storage_blocks/pure_dusts/%s")
            .unformattedTagPath("storage_blocks/pure_dusts")
            .unformattedTagPath("storage_blocks")
            .langValue("Block of Purified %s Dust")
            .materialIconType(new MaterialIconType("dustPureBlock"))
            .materialAmount(GTValues.M * 9)
            .miningToolTag(BlockTags.MINEABLE_WITH_SHOVEL)
            .generateBlock(true)
            .blockConstructor((properties, prefix, material) -> new MaterialBlock(properties.sound(SoundType.SAND),prefix,material))
            .generationCondition(hasOreProperty.and(mat -> mat.hasFlag(GENERATE_FULLBLOCK_ORE_PROCESSING)))
            .unificationEnabled(true);
    public static final TagPrefix dustBlock = new TagPrefix("dustBlock")
            .defaultTagPath("storage_blocks/dusts/%s")
            .unformattedTagPath("storage_blocks/dusts")
            .unformattedTagPath("storage_blocks")
            .langValue("Block of %s Dust")
            .materialIconType(new MaterialIconType("dustBlock"))
            .materialAmount(GTValues.M * 9)
            .miningToolTag(BlockTags.MINEABLE_WITH_SHOVEL)
            .generateBlock(true)
            .blockConstructor((properties, prefix, material) -> new MaterialBlock(properties.sound(SoundType.SAND),prefix,material))
            .generationCondition(mat ->
                    mat.hasProperty(PropertyKey.ORE) &&
                            mat.hasFlag(GENERATE_FULLBLOCK_ORE_PROCESSING) &&
                            (mat.hasProperty(PropertyKey.INGOT) || mat.hasProperty(PropertyKey.GEM))
            )
            .unificationEnabled(true);

    //  It is very difficult for me to implement this
    // I disabled these because they don't have a model

    public static final TagPrefix cluster = new TagPrefix("cluster")
            .generationCondition(mat -> false);

    public static final TagPrefix budLarge = new TagPrefix("budLarge")
            .generationCondition(mat -> false);

    public static final TagPrefix budMedium = new TagPrefix("budMedium")
            .generationCondition(mat -> false);

    public static final TagPrefix budSmall = new TagPrefix("budSmall")
            .generationCondition(mat -> false);

    public static final TagPrefix budding = new TagPrefix("budding")
            .generationCondition(mat -> false);



    @SuppressWarnings("deprecation")
    private static void tagAddition(){

        // ===== Fluid Pipes ===== //

        pipeTinyFluid.customTagPath("pipes/fluid/tiny/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid/tiny/"+mat.getName())
        ).customTagPath("pipes/fluid/tiny",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid/tiny")
        ).customTagPath("pipes/fluid",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid")
        ).customTagPath("pipes",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes")
        ).customTagPath("pipes/fluid/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid/"+mat.getName())
        ).customTagPath("pipes/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/"+mat.getName())
        ).customTagPath("pipes/tiny/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/tiny/"+mat.getName())
        ).customTagPath("pipes/tiny",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/tiny")
        );

        pipeSmallFluid.customTagPath("pipes/fluid/small/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid/small/"+mat.getName())
        ).customTagPath("pipes/fluid/small",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid/small")
        ).customTagPath("pipes/fluid",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid")
        ).customTagPath("pipes",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes")
        ).customTagPath("pipes/fluid/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid/"+mat.getName())
        ).customTagPath("pipes/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/"+mat.getName())
        ).customTagPath("pipes/small/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/small/"+mat.getName())
        ).customTagPath("pipes/small",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/small")
        );

        pipeNormalFluid.customTagPath("pipes/fluid/medium/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid/medium/"+mat.getName())
        ).customTagPath("pipes/fluid/medium",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid/medium")
        ).customTagPath("pipes/fluid",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid")
        ).customTagPath("pipes",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes")
        ).customTagPath("pipes/fluid/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid/"+mat.getName())
        ).customTagPath("pipes/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/"+mat.getName())
        ).customTagPath("pipes/medium/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/medium/"+mat.getName())
        ).customTagPath("pipes/medium",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/medium")
        );

        pipeLargeFluid.customTagPath("pipes/fluid/large/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid/large/"+mat.getName())
        ).customTagPath("pipes/fluid/large",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid/large")
        ).customTagPath("pipes/fluid",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid")
        ).customTagPath("pipes",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes")
        ).customTagPath("pipes/fluid/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid/"+mat.getName())
        ).customTagPath("pipes/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/"+mat.getName())
        ).customTagPath("pipes/large/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/large/"+mat.getName())
        ).customTagPath("pipes/large",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/large")
        );

        pipeHugeFluid.customTagPath("pipes/fluid/huge/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid/huge/"+mat.getName())
        ).customTagPath("pipes/fluid/huge",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid/huge")
        ).customTagPath("pipes/fluid",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid")
        ).customTagPath("pipes",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes")
        ).customTagPath("pipes/fluid/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/fluid/"+mat.getName())
        ).customTagPath("pipes/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/"+mat.getName())
        ).customTagPath("pipes/huge/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/huge/"+mat.getName())
        ).customTagPath("pipes/huge",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/huge")
        );

        // ===== Item Pipes ===== //

        pipeSmallItem.customTagPath("pipes/item/small/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item/small/"+mat.getName())
        ).customTagPath("pipes/item/small",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item/small")
        ).customTagPath("pipes/item",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item")
        ).customTagPath("pipes",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes")
        ).customTagPath("pipes/item/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item/"+mat.getName())
        ).customTagPath("pipes/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/"+mat.getName())
        ).customTagPath("pipes/small/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/small/"+mat.getName())
        ).customTagPath("pipes/small",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/small")
        );
        pipeNormalItem.customTagPath("pipes/item/medium/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item/medium/"+mat.getName())
        ).customTagPath("pipes/item/medium",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item/medium")
        ).customTagPath("pipes/item",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item")
        ).customTagPath("pipes",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes")
        ).customTagPath("pipes/item/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item/"+mat.getName())
        ).customTagPath("pipes/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/"+mat.getName())
        ).customTagPath("pipes/medium/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/medium/"+mat.getName())
        ).customTagPath("pipes/medium",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/medium")
        );

        pipeLargeItem.customTagPath("pipes/item/large/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item/large/"+mat.getName())
        ).customTagPath("pipes/item/large",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item/large")
        ).customTagPath("pipes/item",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item")
        ).customTagPath("pipes",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes")
        ).customTagPath("pipes/item/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item/"+mat.getName())
        ).customTagPath("pipes/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/"+mat.getName())
        ).customTagPath("pipes/large/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/large/"+mat.getName())
        ).customTagPath("pipes/large",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/large")
        );

        pipeHugeItem.customTagPath("pipes/item/huge/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item/huge/"+mat.getName())
        ).customTagPath("pipes/item/huge",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item/huge")
        ).customTagPath("pipes/item",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item")
        ).customTagPath("pipes",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes")
        ).customTagPath("pipes/item/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/item/"+mat.getName())
        ).customTagPath("pipes/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/"+mat.getName())
        ).customTagPath("pipes/huge/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/huge/"+mat.getName())
        ).customTagPath("pipes/huge",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/huge")
        );

        // ===== Restrictive Pipes =====//

        pipeSmallRestrictive.customTagPath("pipes/restrictive/small/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive/small/"+mat.getName())
        ).customTagPath("pipes/restrictive/small",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive/small")
        ).customTagPath("pipes/restrictive",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive")
        ).customTagPath("pipes",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes")
        ).customTagPath("pipes/restrictive/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive/"+mat.getName())
        ).customTagPath("pipes/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/"+mat.getName())
        ).customTagPath("pipes/small/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/small/"+mat.getName())
        ).customTagPath("pipes/small",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/small")
        );

        pipeNormalRestrictive.customTagPath("pipes/restrictive/medium/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive/medium/"+mat.getName())
        ).customTagPath("pipes/restrictive/medium",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive/medium")
        ).customTagPath("pipes/restrictive",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive")
        ).customTagPath("pipes",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes")
        ).customTagPath("pipes/restrictive/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive/"+mat.getName())
        ).customTagPath("pipes/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/"+mat.getName())
        ).customTagPath("pipes/medium/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/medium/"+mat.getName())
        ).customTagPath("pipes/medium",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/medium")
        );
        pipeLargeRestrictive.customTagPath("pipes/restrictive/large/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive/large/"+mat.getName())
        ).customTagPath("pipes/restrictive/large",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive/large")
        ).customTagPath("pipes/restrictive",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive")
        ).customTagPath("pipes",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes")
        ).customTagPath("pipes/restrictive/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive/"+mat.getName())
        ).customTagPath("pipes/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/"+mat.getName())
        ).customTagPath("pipes/large/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/large/"+mat.getName())
        ).customTagPath("pipes/large",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/large")
        );
        pipeHugeRestrictive.customTagPath("pipes/restrictive/huge/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive/huge/"+mat.getName())
        ).customTagPath("pipes/restrictive/huge",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive/huge")
        ).customTagPath("pipes/restrictive",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive")
        ).customTagPath("pipes",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes")
        ).customTagPath("pipes/restrictive/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/restrictive/"+mat.getName())
        ).customTagPath("pipes/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/"+mat.getName())
        ).customTagPath("pipes/huge/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/huge/"+mat.getName())
        ).customTagPath("pipes/huge",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"pipes/huge")
        );

        // ===== //

        wireGtHex.customTagPath("wires/hex/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires/hex/"+mat.getName())
        ).customTagPath("wires/hex",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires/hex")
        ).customTagPath("wires",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires")
        ).customTagPath("wires/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires/"+mat.getName())
        );
        wireGtOctal.customTagPath("wires/octal/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires/octal/"+mat.getName())
        ).customTagPath("wires/octal",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires/hex")
        ).customTagPath("wires",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires")
        ).customTagPath("wires/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires/"+mat.getName())
        );
        wireGtQuadruple.customTagPath("wires/quadruple/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires/quadruple/"+mat.getName())
        ).customTagPath("wires/quadruple",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires/hex")
        ).customTagPath("wires",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires")
        ).customTagPath("wires/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires/"+mat.getName())
        );
        wireGtDouble.customTagPath("wires/double/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires/double/"+mat.getName())
        ).customTagPath("wires/double",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires/hex")
        ).customTagPath("wires",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires")
        ).customTagPath("wires/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires/"+mat.getName())
        );
        wireGtSingle.customTagPath("wires/single/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires/single/"+mat.getName())
        ).customTagPath("wires/single",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires/hex")
        ).customTagPath("wires",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires")
        ).customTagPath("wires/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"wires/"+mat.getName())
        );
        cableGtHex.customTagPath("cables/hex/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables/hex/"+mat.getName())
        ).customTagPath("cables/hex",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables/hex")
        ).customTagPath("cables",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables")
        ).customTagPath("cables/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables/"+mat.getName())
        );
        cableGtOctal.customTagPath("cables/octal/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables/octal/"+mat.getName())
        ).customTagPath("cables/octal",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables/octal")
        ).customTagPath("cables",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables")
        ).customTagPath("cables/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables/"+mat.getName())
        );
        cableGtQuadruple.customTagPath("cables/quadruple/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables/quadruple/"+mat.getName())
        ).customTagPath("cables/quadruple",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables/quadruple")
        ).customTagPath("cables",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables")
        ).customTagPath("cables/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables/"+mat.getName())
        );
        cableGtDouble.customTagPath("cables/double/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables/double/"+mat.getName())
        ).customTagPath("cables/double",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables/double")
        ).customTagPath("cables",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables")
        ).customTagPath("cables/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables/"+mat.getName())
        );
        cableGtSingle.customTagPath("cables/single/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables/single/"+mat.getName())
        ).customTagPath("cables/single",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables/single")
        ).customTagPath("cables",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables")
        ).customTagPath("cables/%s",(prefix, mat) ->
                TagUtil.createModTag(BuiltInRegistries.ITEM,"cables/"+mat.getName())
        );
    }

    public static void register(){
        new CmmeTagPrefix();
        tagAddition();
    }
}
