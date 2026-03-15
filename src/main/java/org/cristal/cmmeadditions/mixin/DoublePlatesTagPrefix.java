package org.cristal.cmmeadditions.mixin;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import org.cristal.cmmeadditions.api.CmmeMaterialFlags;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = TagPrefix.class)
public class DoublePlatesTagPrefix {

    @Shadow @Final @Mutable
    public static TagPrefix plateDouble;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void cmme$overridePlateDouble(CallbackInfo ci) {
        plateDouble.generationCondition(mat ->
                        (mat.hasProperty(PropertyKey.INGOT) && mat.hasFlag(MaterialFlags.GENERATE_PLATE)  && !mat.hasFlag(MaterialFlags.NO_SMASHING)
                        ) || mat.hasFlag(CmmeMaterialFlags.GENERATE_DOUBLE_PLATE));
    }
}
