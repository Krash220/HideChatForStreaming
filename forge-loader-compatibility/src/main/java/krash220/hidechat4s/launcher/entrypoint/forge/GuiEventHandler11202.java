package krash220.hidechat4s.launcher.entrypoint.forge;

import krash220.hidechat4s.launcher.GameHandler;
import krash220.hidechat4s.launcher.utils.GuiHelperMO;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

// 1.8-1.12
public class GuiEventHandler11202 {

    @SubscribeEvent
    public void onChatRenderStart(RenderGameOverlayEvent.Chat event) {
        if (!GuiHelperMO.isChatScreen()) {
            event.setCanceled(true);
        } else {
            GameHandler.onChatRenderStart();
        }
    }
}
