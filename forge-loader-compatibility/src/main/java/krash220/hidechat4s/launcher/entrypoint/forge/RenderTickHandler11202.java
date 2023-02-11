package krash220.hidechat4s.launcher.entrypoint.forge;

import krash220.hidechat4s.launcher.GameHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

// 1.8-1.12
public class RenderTickHandler11202 {

    @SubscribeEvent
    public void onRenderTick(RenderTickEvent event) {
        if (event.phase == Phase.START) {
            GameHandler.onRenderTickStart();
        } else {
            GameHandler.onRenderTickEnd();
        }
    }
}
