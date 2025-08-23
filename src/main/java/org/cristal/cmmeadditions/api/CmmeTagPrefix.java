package org.cristal.cmmeadditions.api;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.Conditions.hasIngotProperty;
import static org.cristal.cmmeadditions.api.CmmeMaterialFlags.*;

public class CmmeTagPrefix {
    public static final com.gregtechceu.gtceu.api.data.tag.TagPrefix doubleIngot = new com.gregtechceu.gtceu.api.data.tag.TagPrefix("doubleIngot")
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
            .generationCondition(hasIngotProperty.and(mat -> mat.hasFlag(GENERATE_DOUBLE_INGOTS)));

    public static final com.gregtechceu.gtceu.api.data.tag.TagPrefix tripleIngot = new com.gregtechceu.gtceu.api.data.tag.TagPrefix("tripleIngot")
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
            .generationCondition(hasIngotProperty.and(mat -> mat.hasFlag(GENERATE_TRIPLE_INGOTS)));

    public static final com.gregtechceu.gtceu.api.data.tag.TagPrefix quadrupleIngot = new com.gregtechceu.gtceu.api.data.tag.TagPrefix("quadrupleIngot")
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
            .generationCondition(hasIngotProperty.and(mat -> mat.hasFlag(GENERATE_QUADRUPLE_INGOTS)));

    public static void register(){
        new CmmeTagPrefix();
    }
}
