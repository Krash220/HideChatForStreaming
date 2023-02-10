package krash220.hidechat.entrypoint.forge;

import krash220.hidechat.ModHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

// 1.8-1.12
public class RenderTickHandler11202 {

    @SubscribeEvent
    public void onRenderTick(RenderTickEvent event) {
        if (event.phase == Phase.START) {
            ModHandler.onRenderTickStart();
        } else {
            ModHandler.onRenderTickEnd();
        }
    }
}
