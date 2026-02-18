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
        GTMaterials.Iron.addFlags(
                GENERATE_DOUBLE_INGOT,
                GENERATE_TRIPLE_INGOT,
                GENERATE_QUADRUPLE_INGOT,
                GENERATE_QUINTUPLE_INGOT,
                GENERATE_TRIPLE_PLATE,
                GENERATE_QUADRUPLE_PLATE,
                GENERATE_QUINTUPLE_PLATE,
                GENERATE_SUPERDENSE,
                GENERATE_BROAD_ROD,
                GENERATE_TUBE,
                GENERATE_FULLBLOCK_ORE_PROCESSING,
                GENERATE_SINGULARITY
        );
        GTMaterials.Aluminium.addFlags(
                GENERATE_DOUBLE_INGOT,
                GENERATE_TRIPLE_INGOT,
                GENERATE_QUADRUPLE_INGOT,
                GENERATE_QUINTUPLE_INGOT,
                GENERATE_TRIPLE_PLATE,
                GENERATE_QUADRUPLE_PLATE,
                GENERATE_QUINTUPLE_PLATE,
                GENERATE_SUPERDENSE,
                GENERATE_BROAD_ROD,
                GENERATE_TUBE,
                GENERATE_FULLBLOCK_ORE_PROCESSING,
                GENERATE_SINGULARITY
        );
        GTMaterials.Steel.addFlags(
                GENERATE_DOUBLE_INGOT,
                GENERATE_TRIPLE_INGOT,
                GENERATE_QUADRUPLE_INGOT,
                GENERATE_QUINTUPLE_INGOT,
                GENERATE_TRIPLE_PLATE,
                GENERATE_QUADRUPLE_PLATE,
                GENERATE_QUINTUPLE_PLATE,
                GENERATE_SUPERDENSE,
                GENERATE_BROAD_ROD,
                GENERATE_TUBE,
                GENERATE_SINGULARITY
        );
        GTMaterials.Silver.addFlags(
                GENERATE_DOUBLE_INGOT,
                GENERATE_TRIPLE_INGOT,
                GENERATE_QUADRUPLE_INGOT,
                GENERATE_QUINTUPLE_INGOT,
                GENERATE_TRIPLE_PLATE,
                GENERATE_QUADRUPLE_PLATE,
                GENERATE_QUINTUPLE_PLATE,
                GENERATE_SUPERDENSE,
                GENERATE_BROAD_ROD,
                GENERATE_TUBE,
                GENERATE_FULLBLOCK_ORE_PROCESSING,
                GENERATE_SINGULARITY
        );
        GTMaterials.Diamond.addFlags(
                GENERATE_DOUBLE_PLATE,
                GENERATE_TRIPLE_PLATE,
                GENERATE_QUADRUPLE_PLATE,
                GENERATE_QUINTUPLE_PLATE,
                GENERATE_SUPERDENSE,
                GENERATE_BROAD_ROD,
                GENERATE_TUBE,
                GENERATE_FULLBLOCK_ORE_PROCESSING,
                GENERATE_SINGULARITY
        );
    }
}
