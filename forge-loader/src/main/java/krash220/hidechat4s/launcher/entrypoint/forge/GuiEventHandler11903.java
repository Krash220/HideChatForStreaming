package krash220.hidechat4s.launcher.entrypoint.forge;

import krash220.hidechat4s.launcher.GameHandler;
import krash220.hidechat4s.launcher.utils.GuiHelperO;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;

// 1.19
public class GuiEventHandler11903 {

    @SubscribeEvent
    public void onChatRenderStart(RenderGuiOverlayEvent.Pre event) {
        if (event.getOverlay() == VanillaGuiOverlay.CHAT_PANEL.type()) {
            if (!GuiHelperO.isChatScreen()) {
                event.setCanceled(true);
            } else {
                GameHandler.onChatRenderStart();
            }
        }
    }
}
