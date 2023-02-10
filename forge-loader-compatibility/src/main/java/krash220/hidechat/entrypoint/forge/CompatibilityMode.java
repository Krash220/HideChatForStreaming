package krash220.hidechat.entrypoint.forge;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventBus;

public class CompatibilityMode {

    public static void init() {
        EventBus bus = MinecraftForge.EVENT_BUS;

        bus.register(new RenderTickHandler11202());

        if (checkField(RenderGameOverlayEvent.Post.class, "type")) {
            // 1.8
            bus.register(new GuiEventHandler10809());
        } else {
            bus.register(new GuiEventHandler11202());
        }
    }

    private static boolean checkField(Class<?> clazz, String field) {
        try {
            clazz.getField(field);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}