package org.cristal.cmmeadditions.api;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.Conditions.hasIngotProperty;

public class CmmeMaterialFlags {

    public CmmeMaterialFlags(){
    }

    public static final MaterialFlag GENERATE_DOUBLE_INGOTS = new MaterialFlag.Builder("generate_double_ingots")
            .requireProps(PropertyKey.INGOT)
            .build();

    public static final MaterialFlag GENERATE_TRIPLE_INGOTS = new MaterialFlag.Builder("generate_triple_ingots")
            .requireProps(PropertyKey.INGOT)
            .build();

    public static final MaterialFlag GENERATE_QUADRUPLE_INGOTS = new MaterialFlag.Builder("generate_quadruple_ingots")
            .requireProps(PropertyKey.INGOT)
            .build();

    public static final MaterialFlag GENERATE_QUINTUPLE_INGOTS = new MaterialFlag.Builder("generate_quadruple_ingots")
            .requireProps(PropertyKey.INGOT)
            .build();

    public static void register(){
        new CmmeMaterialFlags();
    }


}
