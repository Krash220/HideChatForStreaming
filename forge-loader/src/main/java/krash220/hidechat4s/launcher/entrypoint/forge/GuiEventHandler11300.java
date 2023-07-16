package krash220.hidechat4s.launcher.entrypoint.forge;

import krash220.hidechat4s.launcher.GameHandler;
import krash220.hidechat4s.launcher.utils.GuiHelperM;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

// 1.13
public class GuiEventHandler11300 {

    @SubscribeEvent
    public void onChatRenderStart(RenderGameOverlayEvent.Chat event) {
        if (!GuiHelperM.isChatScreen()) {
            event.setCanceled(true);
        } else {
            GameHandler.onChatRenderStart();
        }
    }
}
