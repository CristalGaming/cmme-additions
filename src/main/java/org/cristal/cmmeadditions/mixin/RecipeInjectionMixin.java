package org.cristal.cmmeadditions.mixin;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTRecipes;
import net.minecraft.data.recipes.FinishedRecipe;
import org.cristal.cmmeadditions.data.CmmeRecipes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.function.Consumer;

@Mixin(value = GTRecipes.class)
public class RecipeInjectionMixin {
    @Redirect(method = "recipeAddition",
            at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/data/recipe/generated/MaterialRecipeHandler;run(Ljava/util/function/Consumer;Lcom/gregtechceu/gtceu/api/data/chemical/material/Material;)V"
            ),
            remap = false,
            require = 0
    )
    private static void cmme$recipeAddition(
            java.util.function.Consumer<net.minecraft.data.recipes.FinishedRecipe> consumer,
            com.gregtechceu.gtceu.api.data.chemical.material.Material material
    ){
        CmmeRecipes.run(consumer,material);
        com.gregtechceu.gtceu.data.recipe.generated.MaterialRecipeHandler.run(consumer, material);
    }
}
