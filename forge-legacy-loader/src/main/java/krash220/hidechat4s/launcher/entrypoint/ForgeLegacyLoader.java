package krash220.hidechat4s.launcher.entrypoint;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import krash220.hidechat4s.launcher.GameHandler;
import krash220.hidechat4s.launcher.Platform;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "${MOD_ID}")
public class ForgeLegacyLoader {

    @EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);

        GameHandler.onModInit(Platform.FORGE, MinecraftForge.MC_VERSION);
    }

    @SubscribeEvent
    public void onRenderTick(RenderTickEvent event) {
        if (event.phase == Phase.START) {
            GameHandler.onRenderTickStart();
        } else {
            GameHandler.onRenderTickEnd();
        }
    }

    @SubscribeEvent
    public void onChatRenderStart(RenderGameOverlayEvent.Chat event) {
        GameHandler.onChatRenderStart();
    }

    @SubscribeEvent
    public void onChatRenderEnd(RenderGameOverlayEvent.Post event) {
        if (event.type == ElementType.ALL) {
            GameHandler.onChatRenderEnd();
        }
    }
}
