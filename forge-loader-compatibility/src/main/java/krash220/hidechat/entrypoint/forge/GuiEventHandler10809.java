package krash220.hidechat.entrypoint.forge;

import krash220.hidechat.ModHandler;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

// 1.8
public class GuiEventHandler10809 {

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
