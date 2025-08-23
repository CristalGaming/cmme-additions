package org.cristal.cmmeadditions.integration;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import org.cristal.cmmeadditions.api.CmmeMaterialFlags;

public class CmmeKubeJSPlugin extends KubeJSPlugin {
    @Override
    public void initStartup() {
        super.initStartup();
    }
    @Override
    public void registerBindings(BindingsEvent event){
        super.registerBindings(event);
        event.add("CMMEMaterialFlags", CmmeMaterialFlags.class);
    }
}
