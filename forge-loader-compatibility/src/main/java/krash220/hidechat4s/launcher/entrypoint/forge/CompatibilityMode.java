package krash220.hidechat4s.launcher.entrypoint.forge;

import krash220.hidechat4s.launcher.GameHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventBus;

public class CompatibilityMode {

    public static void init() {
        GameHandler.onModInit();

        EventBus bus = MinecraftForge.EVENT_BUS;

        bus.register(new RenderTickHandler11202());
        bus.register(new GuiEventHandler11202());
    }
}