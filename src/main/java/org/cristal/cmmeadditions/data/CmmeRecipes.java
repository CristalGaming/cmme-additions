package org.cristal.cmmeadditions.data;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import net.minecraft.data.recipes.FinishedRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.BENDER_RECIPES;
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
                VanillaRecipeHelper.addShapedRecipe(provider, String.format("plate_triple_%s", material.getName()),
                        ChemicalHelper.get(triplePlate, magMaterial),
                        "h", "P", "D",
                        'P', new MaterialEntry(plate, material),
                        'D', new MaterialEntry(plateDouble,material));
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

                VanillaRecipeHelper.addShapedRecipe(provider, String.format("plates_quadruple_%s", material.getName()),
                        ChemicalHelper.get(quadruplePlate, magMaterial),
                        "h", "P", "D",
                        'P', new MaterialEntry(plate, material),
                        'D', new MaterialEntry(triplePlate,material));

                VanillaRecipeHelper.addShapedRecipe(provider, String.format("double_plates_quadruple_%s", material.getName()),
                        ChemicalHelper.get(quadruplePlate, magMaterial),
                        "h", "P", "P",
                        'P', new MaterialEntry(plateDouble, material));
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

                VanillaRecipeHelper.addShapedRecipe(provider, String.format("plates_quintuple_%s", material.getName()),
                        ChemicalHelper.get(quintuplePlate, magMaterial),
                        "h", "P", "D",
                        'P', new MaterialEntry(plate, material),
                        'D', new MaterialEntry(quadruplePlate,material));

                VanillaRecipeHelper.addShapedRecipe(provider, String.format("double_plates_quintuple_%s", material.getName()),
                        ChemicalHelper.get(quintuplePlate, magMaterial),
                        "h", "P", "D",
                        'P', new MaterialEntry(plateDouble, material),
                        'D', new MaterialEntry(triplePlate,material));
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
}
