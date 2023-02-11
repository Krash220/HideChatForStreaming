package krash220.hidechat4s.launcher.entrypoint.forge;

import krash220.hidechat4s.launcher.GameHandler;
import net.minecraftforge.client.event.CustomizeGuiOverlayEvent;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

// 1.19
public class GuiEventHandler11903 {

    @SubscribeEvent
    public void onChatRenderStart(CustomizeGuiOverlayEvent.Chat event) {
        GameHandler.onChatRenderStart();
    }

    @SubscribeEvent
    public void onChatRenderEnd(RenderGuiEvent.Post event) {
        GameHandler.onChatRenderEnd();
    }
}
