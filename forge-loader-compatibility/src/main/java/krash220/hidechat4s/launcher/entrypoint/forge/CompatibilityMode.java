package krash220.hidechat4s.launcher.entrypoint.forge;

import krash220.hidechat4s.launcher.GameHandler;
import krash220.hidechat4s.launcher.Platform;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventBus;

public class CompatibilityMode {

    public static void init() {
        GameHandler.onModInit(Platform.FORGE, ForgeVersion.mcVersion);

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