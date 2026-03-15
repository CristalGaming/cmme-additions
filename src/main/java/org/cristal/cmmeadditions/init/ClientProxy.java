package org.cristal.cmmeadditions.init;

import com.gregtechceu.gtceu.data.pack.event.RegisterDynamicResourcesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.cristal.cmmeadditions.api.blocks.ClusterRender;

public class ClientProxy extends CommonProxy{

    @SubscribeEvent
    public void registerDynamicAssets(RegisterDynamicResourcesEvent event) {
        ClusterRender.reinitModels();
    }
}
