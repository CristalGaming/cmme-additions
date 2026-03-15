package org.cristal.cmmeadditions;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.cristal.cmmeadditions.api.CmmeMaterialFlags;
import org.cristal.cmmeadditions.api.CmmeTagPrefix;

@SuppressWarnings("unused")
public class CmmeRegistries {
    public static final GTRegistrate REGISTRATE = GTRegistrate.create(Cmmeadditions.MODID);

    @SubscribeEvent
    public static void registerMaterialRegistry(MaterialRegistryEvent event) {
        MaterialRegistry MATERIAL_REGISTRY = GTCEuAPI.materialManager.createRegistry(Cmmeadditions.MODID);
    }
    @SubscribeEvent
    public static void registerMaterials(MaterialEvent event){
        CmmeMaterialFlags.register();
        CmmeTagPrefix.register();
    }
}
