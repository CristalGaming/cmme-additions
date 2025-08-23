package org.cristal.cmmeadditions.init;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.cristal.cmmeadditions.CmmeRegistries;
public class CommonProxy {
    IEventBus register = Mod.EventBusSubscriber.Bus.MOD.bus().get();
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    public CommonProxy(){
        CommonProxy.serverEventBusSubscriberRegister(register);
    }
    public static void serverEventBusSubscriberRegister(IEventBus modBus){
        modBus.addListener(CmmeRegistries::registerMaterialRegistry);
        modBus.addListener(CmmeRegistries::registerMaterials);
    }
}
