package org.cristal.cmmeadditions.api;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_PLATE;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_ROD;

public class CmmeMaterialFlags {

    public CmmeMaterialFlags(){
    }

    public static final MaterialFlag GENERATE_DOUBLE_INGOT = new MaterialFlag.Builder("generate_double_ingot")
            .requireProps(PropertyKey.INGOT)
            .build();

    public static final MaterialFlag GENERATE_TRIPLE_INGOT = new MaterialFlag.Builder("generate_triple_ingot")
            .requireProps(PropertyKey.INGOT)
            .build();

    public static final MaterialFlag GENERATE_QUADRUPLE_INGOT = new MaterialFlag.Builder("generate_quadruple_ingot")
            .requireProps(PropertyKey.INGOT)
            .build();

    public static final MaterialFlag GENERATE_QUINTUPLE_INGOT = new MaterialFlag.Builder("generate_quintuple_ingot")
            .requireProps(PropertyKey.INGOT)
            .build();

    public static final MaterialFlag GENERATE_DOUBLE_PLATE = new MaterialFlag.Builder("generate_double_plate")
            .requireFlags(GENERATE_PLATE)
            .requireProps(PropertyKey.DUST)
            .build();

    public static final MaterialFlag GENERATE_TRIPLE_PLATE = new MaterialFlag.Builder("generate_triple_plate")
            .requireFlags(GENERATE_PLATE)
            .requireProps(PropertyKey.DUST)
            .build();

    public static final MaterialFlag GENERATE_QUADRUPLE_PLATE = new MaterialFlag.Builder("generate_quadruple_plate")
            .requireFlags(GENERATE_PLATE)
            .requireProps(PropertyKey.DUST)
            .build();

    public static final MaterialFlag GENERATE_QUINTUPLE_PLATE = new MaterialFlag.Builder("generate_quintuple_plate")
            .requireFlags(GENERATE_PLATE)
            .requireProps(PropertyKey.DUST)
            .build();

    public static final MaterialFlag GENERATE_SUPERDENSE = new MaterialFlag.Builder("generate_superdense")
            .requireFlags(GENERATE_PLATE)
            .requireProps(PropertyKey.DUST)
            .build();

    public static final MaterialFlag GENERATE_BROAD_ROD = new MaterialFlag.Builder("generate_broad_rod")
            .requireFlags(GENERATE_ROD)
            .requireProps(PropertyKey.DUST)
            .build();

    public static final MaterialFlag GENERATE_TUBE = new MaterialFlag.Builder("generate_tube")
            .requireProps(PropertyKey.DUST)
            .build();


    public static final MaterialFlag GENERATE_SINGULARITY = new MaterialFlag.Builder("generate_singularity")
            .build();

    public static final MaterialFlag GENERATE_FULLBLOCK_ORE_PROCESSING = new MaterialFlag.Builder("generate_crushed_ore_block")
            .requireProps(PropertyKey.ORE)
            .build();

    public static void register(){
        new CmmeMaterialFlags();
    }


}
