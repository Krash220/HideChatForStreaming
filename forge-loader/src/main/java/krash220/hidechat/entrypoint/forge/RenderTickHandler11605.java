package krash220.hidechat.entrypoint.forge;

import krash220.hidechat.ModHandler;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.RenderTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

// 1.14+
public class RenderTickHandler11605 {

    @SubscribeEvent
    public void onRenderTick(RenderTickEvent event) {
        if (event.phase == Phase.START) {
            ModHandler.onRenderTickStart();
        } else {
            ModHandler.onRenderTickEnd();
        }
    }
}
