package org.cristal.cmmeadditions.mixin;

import com.gregtechceu.gtceu.common.data.GTBlocks;
import org.cristal.cmmeadditions.api.blocks.CmmeBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(GTBlocks.class)
public class GTBlocksMixin {


    @Inject(
            method = "init",
            at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/common/data/GTMaterialBlocks;generateOreIndicators()V"),
            remap = false,
            require = 1
    )
    private static void cmmeGenerate$init(CallbackInfo ci) {
        CmmeBlocks.generateCrystals();
    }

    @Inject(
            method = "init",
            at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/common/data/GTMaterialBlocks;generateItemPipeBlocks()V"),
            remap = false,
            require = 1
    )
    private static void cmmeSetNull$init(CallbackInfo ci){
        CmmeBlocks.CLUSTER_BLOCKS = null;
        CmmeBlocks.BUD_BLOCKS = null;
    }

}
