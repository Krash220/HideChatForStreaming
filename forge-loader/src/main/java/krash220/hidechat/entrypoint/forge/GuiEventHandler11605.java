package krash220.hidechat.entrypoint.forge;

import krash220.hidechat.ModHandler;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.eventbus.api.SubscribeEvent;

// 1.13-1.18
public class GuiEventHandler11605 {

    @SubscribeEvent
    public void onChatRenderStart(RenderGameOverlayEvent.Chat event) {
        ModHandler.onChatRenderStart();
    }

    @SubscribeEvent
    public void onChatRenderEnd(RenderGameOverlayEvent.Post event) {
        if (event.getType() == ElementType.ALL) {
            ModHandler.onChatRenderEnd();
        }
    }
}