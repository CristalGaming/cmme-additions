package org.cristal.cmmeadditions.data;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTRecipeCategories;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.GTValues.ULV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static org.cristal.cmmeadditions.api.CmmeMaterialFlags.*;
import static org.cristal.cmmeadditions.api.CmmeTagPrefix.*;

public final class CmmeRecipes {

    public static void run(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {
        processPlateDoubleAddition(provider,material);

        processPlateTriple(provider,material);
        processPlateQuadruple(provider,material);
        processPlateQuintuple(provider,material);
        processPlateSuperdense(provider,material);

        processIngotDouble(provider,material);
        processIngotTriple(provider,material);
        processIngotQuadruple(provider,material);
        processIngotQuintuple(provider,material);

        processBroadRod(provider,material);
        processTube(provider,material);

        processDustBlock(provider,material);
        processImpureDustBlock(provider,material);
        processPureDustBlock(provider,material);
        processCrushedOreBlock(provider,material);
        processPurifiedOreBlock(provider,material);
        processRefinedOreBlock(provider,material);
    }
    private static void processPlateDoubleAddition(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material){
        if (!material.shouldGenerateRecipesFor(plateDouble) || !material.hasProperty(PropertyKey.INGOT)){
            return;
        }

        var magMaterial = material.hasFlag(IS_MAGNETIC) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material;

        if (material.hasFlag(GENERATE_PLATE) && material.hasFlag(GENERATE_DOUBLE_INGOT)) {
            BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_double_ingot_to_double_plate")
                    .EUt(96).duration((int) material.getMass() * 2)
                    .inputItems(doubleIngot, material)
                    .outputItems(plateDouble, magMaterial)
                    .circuitMeta(1)
                    .save(provider);
        }
    }
    private static void processPlateTriple(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {

        if (!material.shouldGenerateRecipesFor(triplePlate) || !material.hasProperty(PropertyKey.INGOT)){
            return;
        }

        var magMaterial = material.hasFlag(IS_MAGNETIC) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material;
        if (material.hasFlag(GENERATE_PLATE)) {
            if (!material.hasFlag(NO_SMASHING)) {
                VanillaRecipeHelper.addShapedRecipe(provider, String.format("%s_plates_to_triple_plate_1", material.getName()),
                        ChemicalHelper.get(triplePlate, magMaterial),
                        "h", "P", "D",
                        'P', new MaterialEntry(plate, material),
                        'D', new MaterialEntry(plateDouble,material)
                );
                VanillaRecipeHelper.addShapedRecipe(provider, String.format("%s_plates_to_triple_plate_2", material.getName()),
                        ChemicalHelper.get(triplePlate, magMaterial),
                        "h", "D", "P",
                        'D', new MaterialEntry(plateDouble,material),
                        'P', new MaterialEntry(plate, material)
                );
                if(material.hasFlag(GENERATE_TRIPLE_INGOT)) {
                    VanillaRecipeHelper.addShapedRecipe(provider, String.format("%s_ingots_to_triple_plate", material.getName()),
                            ChemicalHelper.get(triplePlate, magMaterial),
                            "h", "I", "I",
                            'I', new MaterialEntry(tripleIngot, material)
                    );
                }

            }

            BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_plate_to_triple_plate")
                    .EUt(96).duration((int) material.getMass() * 3)
                    .inputItems(plate, material, 3)
                    .outputItems(triplePlate, magMaterial)
                    .circuitMeta(3)
                    .save(provider);

            BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_ingot_to_triple_plate")
                    .inputItems(ingot, material, 3)
                    .circuitMeta(3)
                    .outputItems(triplePlate, magMaterial)
                    .duration((int) material.getMass() * 3)
                    .EUt(96)
                    .save(provider);

            if(material.hasFlag(GENERATE_TRIPLE_INGOT)){
                BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_triple_ingot_to_triple_plate")
                        .EUt(96).duration((int) material.getMass() * 3)
                        .inputItems(tripleIngot, material)
                        .outputItems(triplePlate, magMaterial)
                        .circuitMeta(1)
                        .save(provider);

            }

        }
    }

    private static void processPlateQuadruple(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {

        if (!material.shouldGenerateRecipesFor(quadruplePlate) || !material.hasProperty(PropertyKey.INGOT)){
            return;
        }

        var magMaterial = material.hasFlag(IS_MAGNETIC) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material;
        if (material.hasFlag(GENERATE_PLATE)) {
            if (!material.hasFlag(NO_SMASHING)) {

                VanillaRecipeHelper.addShapedRecipe(provider, String.format("%s_plates_to_quadruple_plate_1", material.getName()),
                        ChemicalHelper.get(quadruplePlate, magMaterial),
                        "h", "P", "D",
                        'P', new MaterialEntry(plate, material),
                        'D', new MaterialEntry(triplePlate,material)
                );

                VanillaRecipeHelper.addShapedRecipe(provider, String.format("%s_plates_to_quadruple_plate_2", material.getName()),
                        ChemicalHelper.get(quadruplePlate, magMaterial),
                        "h", "D", "P",
                        'D', new MaterialEntry(triplePlate,material),
                        'P', new MaterialEntry(plate, material)
                );

                VanillaRecipeHelper.addShapedRecipe(provider, String.format("%s_double_plates_to_quadruple_plate", material.getName()),
                        ChemicalHelper.get(quadruplePlate, magMaterial),
                        "h", "P", "P",
                        'P', new MaterialEntry(plateDouble, material)
                );
                if(material.hasFlag(GENERATE_QUADRUPLE_INGOT)) {
                    VanillaRecipeHelper.addShapedRecipe(provider, String.format("%s_ingots_to_quadruple_plate", material.getName()),
                            ChemicalHelper.get(quadruplePlate, magMaterial),
                            "h", "P", "P",
                            'P', new MaterialEntry(quadrupleIngot, material)
                    );
                }

            }

            BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_plate_to_quadruple_plate")
                    .EUt(96).duration((int) material.getMass() * 4)
                    .inputItems(plate, material, 4)
                    .outputItems(quadruplePlate, magMaterial)
                    .circuitMeta(4)
                    .save(provider);

            BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_ingot_to_quadruple_plate")
                    .inputItems(ingot, material, 4)
                    .circuitMeta(4)
                    .outputItems(quadruplePlate, magMaterial)
                    .duration((int) material.getMass() * 4)
                    .EUt(96)
                    .save(provider);

            if(material.hasFlag(GENERATE_QUADRUPLE_PLATE)){
                BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_quadruple_ingot_to_quadruple_plate")
                        .EUt(96).duration((int) material.getMass() * 4)
                        .inputItems(quadrupleIngot, material)
                        .outputItems(quadruplePlate, magMaterial)
                        .circuitMeta(1)
                        .save(provider);
                BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_double_ingots_to_quadruple_plate")
                        .EUt(96).duration((int) material.getMass() * 4)
                        .inputItems(doubleIngot, material,2)
                        .outputItems(quadruplePlate, magMaterial)
                        .circuitMeta(2)
                        .save(provider);

            }
        }
    }

    private static void processPlateQuintuple(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {

        if (!material.shouldGenerateRecipesFor(quintuplePlate) || !material.hasProperty(PropertyKey.INGOT)){
            return;
        }

        var magMaterial = material.hasFlag(IS_MAGNETIC) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material;
        if (material.hasFlag(GENERATE_PLATE)) {
            if (!material.hasFlag(NO_SMASHING)) {

                VanillaRecipeHelper.addShapedRecipe(provider, String.format("%s_plates_to_quintuple_plate_1", material.getName()),
                        ChemicalHelper.get(quintuplePlate, magMaterial),
                        "h", "P", "D",
                        'P', new MaterialEntry(plate, material),
                        'D', new MaterialEntry(quadruplePlate,material));
                VanillaRecipeHelper.addShapedRecipe(provider, String.format("%s_plates_to_quintuple_plate_2", material.getName()),
                        ChemicalHelper.get(quintuplePlate, magMaterial),
                        "h", "D", "P",
                        'P', new MaterialEntry(plate, material),
                        'D', new MaterialEntry(quadruplePlate,material));

                VanillaRecipeHelper.addShapedRecipe(provider, String.format("%s_double_plates_to_quintuple_plate_1", material.getName()),
                        ChemicalHelper.get(quintuplePlate, magMaterial),
                        "h", "P", "D",
                        'P', new MaterialEntry(plateDouble, material),
                        'D', new MaterialEntry(triplePlate,material));
                VanillaRecipeHelper.addShapedRecipe(provider, String.format("%s_double_plates_to_quintuple_plate_2", material.getName()),
                        ChemicalHelper.get(quintuplePlate, magMaterial),
                        "h", "D", "P",
                        'P', new MaterialEntry(plateDouble, material),
                        'D', new MaterialEntry(triplePlate,material));
                if(material.hasFlag(GENERATE_QUINTUPLE_INGOT)) {
                    VanillaRecipeHelper.addShapedRecipe(provider, String.format("%s_ingots_to_quintuple_plate", material.getName()),
                            ChemicalHelper.get(quadruplePlate, magMaterial),
                            "h", "P", "P",
                            'P', new MaterialEntry(quintupleIngot, material)
                    );
                }
            }

            BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_plate_to_quintuple_plate")
                    .EUt(96).duration((int) material.getMass() * 5)
                    .inputItems(plate, material, 5)
                    .outputItems(quintuplePlate, magMaterial)
                    .circuitMeta(5)
                    .save(provider);

            BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_ingot_to_quintuple_plate")
                    .inputItems(ingot, material, 5)
                    .circuitMeta(5)
                    .outputItems(quintuplePlate, magMaterial)
                    .duration((int) material.getMass() * 5)
                    .EUt(96)
                    .save(provider);

            if(material.hasFlag(GENERATE_QUINTUPLE_PLATE)){
                BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_quintuple_ingot_to_quintuple_plate")
                        .EUt(96).duration((int) material.getMass() * 5)
                        .inputItems(quintupleIngot, material)
                        .outputItems(quintuplePlate, magMaterial)
                        .circuitMeta(1)
                        .save(provider);
            }
        }
    }

    private static void processPlateSuperdense(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {
        if (!material.shouldGenerateRecipesFor(superdensePlate) || !material.hasProperty(PropertyKey.DUST)) {
            return;
        }

        var magMaterial = material.hasFlag(IS_MAGNETIC) && material.hasProperty(PropertyKey.INGOT) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material;
        BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_plate_to_superdense_plate")
                .inputItems(plate, material, 64)
                .circuitMeta(6)
                .outputItems(superdensePlate, magMaterial)
                .duration((int) Math.max(material.getMass() * 64L, 1L))
                .EUt(96)
                .save(provider);

        if (material.hasProperty(PropertyKey.INGOT)) {
            BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_ingot_to_superdense_plate")
                    .inputItems(ingot, material, 64)
                    .circuitMeta(6)
                    .outputItems(superdensePlate, magMaterial)
                    .duration((int) Math.max(material.getMass() * 64L, 1L))
                    .EUt(96)
                    .save(provider);
        }
    }

    private static void processIngotDouble(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {

        if (!material.shouldGenerateRecipesFor(doubleIngot) || !material.hasProperty(PropertyKey.INGOT)){
            return;
        }

        var magMaterial = material.hasFlag(IS_MAGNETIC) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material;

        if (!material.hasFlag(NO_SMASHING)) {
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("ingot_double_%s", material.getName()),
                    ChemicalHelper.get(doubleIngot, magMaterial),
                    "P", "P", "h",
                    'P', new MaterialEntry(ingot, material));
        }

        BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_ingot_to_double_ingot")
                .inputItems(ingot, material, 2)
                .circuitMeta(16)
                .outputItems(doubleIngot, magMaterial)
                .duration((int) material.getMass() * 2)
                .EUt(96)
                .save(provider); // doesn't always work for some reason
    }

    private static void processIngotTriple(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {

        if (!material.shouldGenerateRecipesFor(tripleIngot) || !material.hasProperty(PropertyKey.INGOT)){
            return;
        }

        var magMaterial = material.hasFlag(IS_MAGNETIC) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material;

        if (!material.hasFlag(NO_SMASHING)) {
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("ingot_triple_%s", material.getName()),
                    ChemicalHelper.get(tripleIngot, magMaterial),
                    "D", "P", "h",
                    'P', new MaterialEntry(ingot, material),
                    'D', new MaterialEntry(doubleIngot,material));

        }

        BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_ingot_to_triple_ingot")
                .inputItems(ingot, material, 3)
                .circuitMeta(17)
                .outputItems(tripleIngot, magMaterial)
                .duration((int) material.getMass() * 3)
                .EUt(96)
                .save(provider);

    }
    private static void processIngotQuadruple(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {

        if (!material.shouldGenerateRecipesFor(quadrupleIngot) || !material.hasProperty(PropertyKey.INGOT)){
            return;
        }

        var magMaterial = material.hasFlag(IS_MAGNETIC) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material;

        if (!material.hasFlag(NO_SMASHING)) {
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("ingot_quadruple_%s", material.getName()),
                    ChemicalHelper.get(quadrupleIngot, magMaterial),
                    "D", "P", "h",
                    'P', new MaterialEntry(ingot, material),
                    'D', new MaterialEntry(tripleIngot,material));

            VanillaRecipeHelper.addShapedRecipe(provider, String.format("double_ingots_quadruple_%s", material.getName()),
                    ChemicalHelper.get(quadrupleIngot, magMaterial),
                    "P", "P", "h",
                    'P', new MaterialEntry(doubleIngot, material));

        }

        BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_ingot_to_quadruple_ingot")
                .inputItems(ingot, material, 4)
                .circuitMeta(18)
                .outputItems(quadrupleIngot, magMaterial)
                .duration((int) material.getMass() * 4)
                .EUt(96)
                .save(provider);

        BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_double_ingots_to_quadruple_ingot")
                .inputItems(doubleIngot, material, 2)
                .circuitMeta(16)
                .outputItems(quadrupleIngot, magMaterial)
                .duration((int) material.getMass() * 4)
                .EUt(96)
                .save(provider);

    }
    private static void processIngotQuintuple(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {

        if (!material.shouldGenerateRecipesFor(quintupleIngot) || !material.hasProperty(PropertyKey.INGOT)){
            return;
        }

        var magMaterial = material.hasFlag(IS_MAGNETIC) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material;

        if (!material.hasFlag(NO_SMASHING)) {
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("ingot_quintuple_%s", material.getName()),
                    ChemicalHelper.get(quintupleIngot, magMaterial),
                    "D", "P", "h",
                    'P', new MaterialEntry(ingot, material),
                    'D', new MaterialEntry(quadrupleIngot,material));
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("double_ingots_quintuple_%s", material.getName()),
                    ChemicalHelper.get(quintupleIngot, magMaterial),
                    "D", "P", "h",
                    'P', new MaterialEntry(doubleIngot, material),
                    'D',new MaterialEntry(tripleIngot,material));

        }

        BENDER_RECIPES.recipeBuilder("bend_" + material.getName() + "_ingot_to_quintuple_ingot")
                .inputItems(ingot, material, 5)
                .circuitMeta(19)
                .outputItems(quintupleIngot, magMaterial)
                .duration((int) material.getMass() * 5)
                .EUt(96)
                .save(provider);

    }
    private static void processBroadRod(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material){

        if (!material.shouldGenerateRecipesFor(broadRod) || !material.hasProperty(PropertyKey.DUST)){
            return;
        }
        var magMaterial = material.hasFlag(IS_MAGNETIC) && material.hasProperty(PropertyKey.INGOT) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material;

        if (material.hasProperty(PropertyKey.GEM) || material.hasProperty(PropertyKey.INGOT)) {

            GTRecipeBuilder builder = LATHE_RECIPES.recipeBuilder("lathe_" + material.getName() + "_to_broad_rod")
                    .inputItems( material.hasProperty(PropertyKey.GEM) ? gemFlawless : doubleIngot, material )
                    .duration((int) Math.max(material.getMass() * 4, 2))
                    .EUt(16);

            if (ConfigHolder.INSTANCE.recipes.harderRods) {
                builder.outputItems(broadRod, magMaterial);
                builder.outputItems(dust, magMaterial);
            } else {
                builder.outputItems(broadRod, magMaterial, 2);
            }
                builder.save(provider);
        }
        if (material.hasFlag(GENERATE_ROD) && material.hasFlag(GENERATE_DOUBLE_INGOT) && material.hasProperty(PropertyKey.INGOT)) {
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("broad_stick_%s", material.getName()),
                    ChemicalHelper.get(broadRod, magMaterial),
                    "f ", " X",
                    'X', new MaterialEntry(doubleIngot, material));
        }
    }
    private static void processTube(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material){

        if (!material.shouldGenerateRecipesFor(tube) || !material.hasProperty(PropertyKey.DUST)){
            return;
        }
        var magMaterial = material.hasFlag(IS_MAGNETIC) && material.hasProperty(PropertyKey.INGOT) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material;

        if (material.hasProperty(PropertyKey.GEM) || material.hasProperty(PropertyKey.INGOT)) {

            if(material.hasFlag(GENERATE_BROAD_ROD)){
                GTRecipeBuilder builder = LATHE_RECIPES.recipeBuilder("lathe_" + material.getName() + "_to_tube")
                        .inputItems(broadRod, material)
                        .duration((int) Math.max(material.getMass() * 2, 1))
                        .EUt(16);
                if (ConfigHolder.INSTANCE.recipes.harderRods) {
                    builder.outputItems(tube, magMaterial);
                    builder.outputItems(dustSmall, magMaterial,2);
                } else {
                    builder.outputItems(tube, magMaterial, 2);
                }
                builder.save(provider);
            }
        }
        if (material.hasFlag(GENERATE_ROD) && material.hasFlag(GENERATE_DOUBLE_INGOT) && material.hasProperty(PropertyKey.INGOT)) {
            VanillaRecipeHelper.addShapedRecipe(provider, String.format("tube_%s", material.getName()),
                    ChemicalHelper.get(tube, magMaterial),
                    "f ", " X",
                    'X', new MaterialEntry(broadRod, material));
        }
        if(material.hasFlag(GENERATE_RING)){
            CUTTER_RECIPES.recipeBuilder(material.getName() + "_tube_to_rings")
                    .inputItems(tube,material)
                    .outputItems(ring,material,2)
                    .duration((int) Math.max(material.getMass()*2,1))
                    .EUt(16)
                    .save(provider);

            VanillaRecipeHelper.addShapedRecipe(provider, String.format("tube_to_rings_%s", material.getName()),
                    ChemicalHelper.get(ring, magMaterial,2),
                    "h ", "sX",
                    'X', new MaterialEntry(tube, material));
        }
    }
    private static void processDustBlock(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material){
        if (
                !material.hasProperty(PropertyKey.DUST) ||
                !material.hasFlag(GENERATE_FULLBLOCK_ORE_PROCESSING) ||
                !(material.hasProperty(PropertyKey.GEM) || material.hasProperty(PropertyKey.INGOT))
        ) return;

        ItemStack magBlock = ChemicalHelper.get(dustBlock, material.hasFlag(IS_MAGNETIC) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material);

        long materialAmount = dustBlock.getMaterialAmount(material);
        int size = (int) (materialAmount / M);
        int sizeSqrt = Math.round(Mth.sqrt(size));

        MaterialEntry blockEntry = new MaterialEntry(dust, material);

        if (!material.hasFlag(EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES) && !ConfigHolder.INSTANCE.recipes.disableManualCompression) {

            String patternString = "B".repeat(Math.max(0, sizeSqrt));
            String[] pattern = new String[sizeSqrt];
            Arrays.fill(pattern, patternString);

            VanillaRecipeHelper.addShapedRecipe(provider, String.format("dust_block_compress_%s", material.getName()),
                    magBlock, pattern, 'B', blockEntry);

            VanillaRecipeHelper.addShapelessRecipe(provider,
                    String.format("dust_block_decompress_%s", material.getName()),
                    ChemicalHelper.get(blockEntry.tagPrefix(), blockEntry.material()).copyWithCount(size),
                    new MaterialEntry(dustBlock, material));
        }

        COMPRESSOR_RECIPES.recipeBuilder("compress_" + material.getName() + "_dust_to_dust_block")
                .inputItems(dust, material, (int) (dustBlock.getMaterialAmount(material) / M))
                .outputItems(dustBlock, material)
                .duration(300).EUt(2).save(provider);

        FORGE_HAMMER_RECIPES.recipeBuilder("hammer_" + material.getName() + "_dust_block_to_dust")
                .inputItems(dustBlock, material)
                .outputItems(dust, material, (int) (dustBlock.getMaterialAmount(material) / M))
                .duration(100).EUt(24).save(provider);

    }

    private static void processPureDustBlock(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material){
        if (!material.hasProperty(PropertyKey.DUST) || !material.hasFlag(GENERATE_FULLBLOCK_ORE_PROCESSING)) return;

        ItemStack magBlock = ChemicalHelper.get(dustImpureBlock, material.hasFlag(IS_MAGNETIC) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material);

        long materialAmount = dustPureBlock.getMaterialAmount(material);
        int size = (int) (materialAmount / M);
        int sizeSqrt = Math.round(Mth.sqrt(size));

        MaterialEntry blockEntry = new MaterialEntry(dustPure, material);

        if (!material.hasFlag(EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES) && !ConfigHolder.INSTANCE.recipes.disableManualCompression) {

            String patternString = "B".repeat(Math.max(0, sizeSqrt));
            String[] pattern = new String[sizeSqrt];
            Arrays.fill(pattern, patternString);

            VanillaRecipeHelper.addShapedRecipe(provider, String.format("pure_dust_block_compress_%s", material.getName()),
                    magBlock, pattern, 'B', blockEntry);

            VanillaRecipeHelper.addShapelessRecipe(provider,
                    String.format("pure_dust_block_decompress_%s", material.getName()),
                    ChemicalHelper.get(blockEntry.tagPrefix(), blockEntry.material()).copyWithCount(size),
                    new MaterialEntry(block, material));
        }

        COMPRESSOR_RECIPES.recipeBuilder("compress_" + material.getName() + "_pure_dust_to_pure_dust_block")
                .inputItems(dustPure, material, (int) (dustPureBlock.getMaterialAmount(material) / M))
                .outputItems(dustPureBlock, material)
                .duration(300).EUt(2).save(provider);

        FORGE_HAMMER_RECIPES.recipeBuilder("hammer_" + material.getName() + "_pure_dust_block_to_pure_dust")
                .inputItems(dustPureBlock, material)
                .outputItems(dustPure, material, (int) (dustPureBlock.getMaterialAmount(material) / M))
                .duration(100).EUt(24).save(provider);

    }

    private static void processImpureDustBlock(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material){
        if (!material.hasProperty(PropertyKey.DUST) || !material.hasFlag(GENERATE_FULLBLOCK_ORE_PROCESSING)) return;

        ItemStack magBlock = ChemicalHelper.get(dustImpureBlock, material.hasFlag(IS_MAGNETIC) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material);

        long materialAmount = dustImpureBlock.getMaterialAmount(material);
        int size = (int) (materialAmount / M);
        int sizeSqrt = Math.round(Mth.sqrt(size));

        MaterialEntry blockEntry = new MaterialEntry(dustImpure, material);

        if (!material.hasFlag(EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES) && !ConfigHolder.INSTANCE.recipes.disableManualCompression) {

            String patternString = "B".repeat(Math.max(0, sizeSqrt));
            String[] pattern = new String[sizeSqrt];
            Arrays.fill(pattern, patternString);

            VanillaRecipeHelper.addShapedRecipe(provider, String.format("impure_dust_block_compress_%s", material.getName()),
                    magBlock, pattern, 'B', blockEntry);

            VanillaRecipeHelper.addShapelessRecipe(provider,
                    String.format("impure_dust_block_decompress_%s", material.getName()),
                    ChemicalHelper.get(blockEntry.tagPrefix(), blockEntry.material()).copyWithCount(size),
                    new MaterialEntry(dustImpureBlock, material));
        }

        COMPRESSOR_RECIPES.recipeBuilder("compress_" + material.getName() + "_impure_dust_to_impure_dust_block")
                .inputItems(dustImpure, material, (int) (dustImpureBlock.getMaterialAmount(material) / M))
                .outputItems(dustImpureBlock, material)
                .duration(300).EUt(2).save(provider);

        FORGE_HAMMER_RECIPES.recipeBuilder("hammer_" + material.getName() + "_pure_dust_block_to_pure_dust")
                .inputItems(dustImpureBlock, material)
                .outputItems(dustImpure, material, (int) (dustImpureBlock.getMaterialAmount(material) / M))
                .duration(100).EUt(24).save(provider);

    }

    private static void processCrushedOreBlock(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material){
        if (!material.hasProperty(PropertyKey.DUST) || !material.hasFlag(GENERATE_FULLBLOCK_ORE_PROCESSING)) return;

        ItemStack magBlock = ChemicalHelper.get(dustImpureBlock, material.hasFlag(IS_MAGNETIC) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material);

        long materialAmount = crushedOreBlock.getMaterialAmount(material);
        int size = (int) (materialAmount / M);
        int sizeSqrt = Math.round(Mth.sqrt(size));

        MaterialEntry blockEntry = new MaterialEntry(crushed, material);

        if (!material.hasFlag(EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES) && !ConfigHolder.INSTANCE.recipes.disableManualCompression) {

            String patternString = "B".repeat(Math.max(0, sizeSqrt));
            String[] pattern = new String[sizeSqrt];
            Arrays.fill(pattern, patternString);

            VanillaRecipeHelper.addShapedRecipe(provider, String.format("crushed_ore_block_compress_%s", material.getName()),
                    magBlock, pattern, 'B', blockEntry);

            VanillaRecipeHelper.addShapelessRecipe(provider,
                    String.format("crushed_ore_block_decompress_%s", material.getName()),
                    ChemicalHelper.get(blockEntry.tagPrefix(), blockEntry.material()).copyWithCount(size),
                    new MaterialEntry(crushedOreBlock, material));
        }

        COMPRESSOR_RECIPES.recipeBuilder("compress_" + material.getName() + "_crushed_ore_to_crushed_ore_block")
                .inputItems(crushed, material, (int) (crushedOreBlock.getMaterialAmount(material) / M))
                .outputItems(crushedOreBlock, material)
                .duration(300).EUt(2).save(provider);

        FORGE_HAMMER_RECIPES.recipeBuilder("hammer_" + material.getName() + "_crushed_ore_block_to_crushed_ore")
                .inputItems(crushedOreBlock, material)
                .outputItems(crushed, material, (int) (crushedOreBlock.getMaterialAmount(material) / M))
                .duration(100).EUt(24).save(provider);

    }

    private static void processPurifiedOreBlock(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material){
        if (!material.hasProperty(PropertyKey.DUST) || !material.hasFlag(GENERATE_FULLBLOCK_ORE_PROCESSING)) return;

        ItemStack magBlock = ChemicalHelper.get(dustImpureBlock, material.hasFlag(IS_MAGNETIC) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material);

        long materialAmount = purifiedOreBlock.getMaterialAmount(material);
        int size = (int) (materialAmount / M);
        int sizeSqrt = Math.round(Mth.sqrt(size));

        MaterialEntry blockEntry = new MaterialEntry(crushedPurified, material);

        if (!material.hasFlag(EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES) && !ConfigHolder.INSTANCE.recipes.disableManualCompression) {

            String patternString = "B".repeat(Math.max(0, sizeSqrt));
            String[] pattern = new String[sizeSqrt];
            Arrays.fill(pattern, patternString);

            VanillaRecipeHelper.addShapedRecipe(provider, String.format("purified_ore_block_compress_%s", material.getName()),
                    magBlock, pattern, 'B', blockEntry);

            VanillaRecipeHelper.addShapelessRecipe(provider,
                    String.format("purified_ore_block_decompress_%s", material.getName()),
                    ChemicalHelper.get(blockEntry.tagPrefix(), blockEntry.material()).copyWithCount(size),
                    new MaterialEntry(purifiedOreBlock, material));
        }

        COMPRESSOR_RECIPES.recipeBuilder("compress_" + material.getName() + "_purified_ore_to_purified_ore_block")
                .inputItems(crushedPurified, material, (int) (purifiedOreBlock.getMaterialAmount(material) / M))
                .outputItems(purifiedOreBlock, material)
                .duration(300).EUt(2).save(provider);

        FORGE_HAMMER_RECIPES.recipeBuilder("hammer_" + material.getName() + "_purified_ore_block_to_purified_ore")
                .inputItems(purifiedOreBlock, material)
                .outputItems(crushedPurified, material, (int) (purifiedOreBlock.getMaterialAmount(material) / M))
                .duration(100).EUt(24).save(provider);

    }

    private static void processRefinedOreBlock(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material){
        if (!material.hasProperty(PropertyKey.DUST) || !material.hasFlag(GENERATE_FULLBLOCK_ORE_PROCESSING)) return;

        ItemStack magBlock = ChemicalHelper.get(dustImpureBlock, material.hasFlag(IS_MAGNETIC) ?
                material.getProperty(PropertyKey.INGOT).getMacerateInto() : material);

        long materialAmount = refinedOreBlock.getMaterialAmount(material);
        int size = (int) (materialAmount / M);
        int sizeSqrt = Math.round(Mth.sqrt(size));

        MaterialEntry blockEntry = new MaterialEntry(crushedRefined, material);

        if (!material.hasFlag(EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES) && !ConfigHolder.INSTANCE.recipes.disableManualCompression) {

            String patternString = "B".repeat(Math.max(0, sizeSqrt));
            String[] pattern = new String[sizeSqrt];
            Arrays.fill(pattern, patternString);

            VanillaRecipeHelper.addShapedRecipe(provider, String.format("refined_ore_block_compress_%s", material.getName()),
                    magBlock, pattern, 'B', blockEntry);

            VanillaRecipeHelper.addShapelessRecipe(provider,
                    String.format("refined_ore_block_decompress_%s", material.getName()),
                    ChemicalHelper.get(blockEntry.tagPrefix(), blockEntry.material()).copyWithCount(size),
                    new MaterialEntry(refinedOreBlock, material));
        }

        COMPRESSOR_RECIPES.recipeBuilder("compress_" + material.getName() + "_refined_ore_to_reefined_ore_block")
                .inputItems(crushedRefined, material, (int) (refinedOreBlock.getMaterialAmount(material) / M))
                .outputItems(refinedOreBlock, material)
                .duration(300).EUt(2).save(provider);

        FORGE_HAMMER_RECIPES.recipeBuilder("hammer_" + material.getName() + "_refined_ore_block_to_refined_ore")
                .inputItems(refinedOreBlock, material)
                .outputItems(crushedRefined, material, (int) (refinedOreBlock.getMaterialAmount(material) / M))
                .duration(100).EUt(24).save(provider);

    }

    private static int getVoltageMultiplier(Material material) {
        return material.getBlastTemperature() >= 2800 ? VA[LV] : VA[ULV];
    }
}
