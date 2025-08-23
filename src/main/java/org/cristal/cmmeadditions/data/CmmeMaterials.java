package org.cristal.cmmeadditions.data;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.resources.ResourceLocation;

import static org.cristal.cmmeadditions.api.CmmeMaterialFlags.*;

public class CmmeMaterials extends Material {
    protected CmmeMaterials(ResourceLocation resourceLocation) {
        super(resourceLocation);
    }
    public static void init() {
        GTMaterials.Iron.addFlags(GENERATE_DOUBLE_INGOTS,GENERATE_TRIPLE_INGOTS,GENERATE_QUADRUPLE_INGOTS,GENERATE_QUINTUPLE_INGOTS);
        GTMaterials.Aluminium.addFlags(GENERATE_DOUBLE_INGOTS,GENERATE_TRIPLE_INGOTS,GENERATE_QUADRUPLE_INGOTS,GENERATE_QUINTUPLE_INGOTS);
        GTMaterials.Steel.addFlags(GENERATE_DOUBLE_INGOTS,GENERATE_TRIPLE_INGOTS,GENERATE_QUADRUPLE_INGOTS,GENERATE_QUINTUPLE_INGOTS);
    }
}
