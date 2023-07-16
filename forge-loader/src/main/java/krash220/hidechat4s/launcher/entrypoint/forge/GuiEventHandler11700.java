package krash220.hidechat4s.launcher.entrypoint.forge;

import krash220.hidechat4s.launcher.GameHandler;
import krash220.hidechat4s.launcher.utils.GuiHelperO;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class GuiEventHandler11700 {

    @SubscribeEvent
    public void onChatRenderStart(RenderGameOverlayEvent.Chat event) {
        if (!GuiHelperO.isChatScreen()) {
            event.setCanceled(true);
        } else {
            GameHandler.onChatRenderStart();
        }
    }
}
