GTCEuStartupEvents.registry('gtceu:material', event => {
     GTMaterials.Tin.addFlags(
         CMMEMaterialFlags.GENERATE_DOUBLE_INGOT,
         CMMEMaterialFlags.GENERATE_TRIPLE_INGOT,
         CMMEMaterialFlags.GENERATE_QUADRUPLE_INGOT,
         CMMEMaterialFlags.GENERATE_QUINTUPLE_INGOT,
         CMMEMaterialFlags.GENERATE_TRIPLE_PLATE,
         CMMEMaterialFlags.GENERATE_QUADRUPLE_PLATE,
         CMMEMaterialFlags.GENERATE_QUINTUPLE_PLATE,
         CMMEMaterialFlags.GENERATE_SINGULARITY
     )
})