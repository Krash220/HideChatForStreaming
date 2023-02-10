package krash220.hidechat.entrypoint;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import krash220.hidechat.ModHandler;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "hidechat4s")
public class ForgeLegacyLoader {

    @EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);

        ModHandler.onInit();
    }

    @SubscribeEvent
    public void onRenderTick(RenderTickEvent event) {
        if (event.phase == Phase.START) {
            ModHandler.onRenderTickStart();
        } else {
            ModHandler.onRenderTickEnd();
        }
    }

    @SubscribeEvent
    public void onChatRenderStart(RenderGameOverlayEvent.Chat event) {
        ModHandler.onChatRenderStart();
    }

    @SubscribeEvent
    public void onChatRenderEnd(RenderGameOverlayEvent.Post event) {
        if (event.type == ElementType.ALL) {
            ModHandler.onChatRenderEnd();
        }
    }
}
