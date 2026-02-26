package org.cristal.cmmeadditions.mixin;

import com.gregtechceu.gtceu.common.data.GTMaterialBlocks;
import org.cristal.cmmeadditions.api.blocks.CmmeBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GTMaterialBlocks.class, remap = false)
public class MaterialBlockMixin {

    @Inject(method = "generateOreIndicators", at = @At(value = "TAIL"))
    private static void tfg$generateOreIndicators(CallbackInfo ci) {

    }
}
