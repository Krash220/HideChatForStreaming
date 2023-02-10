package krash220.hidechat.entrypoint;

import krash220.hidechat.ModHandler;
import krash220.hidechat.entrypoint.forge.*;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

@Mod(value = "hidechat4s", modid = "hidechat4s")
public class ForgeLoader {

    public ForgeLoader() {
        ModHandler.onInit();

        if (checkClass("net.minecraftforge.fml.common.eventhandler.SubscribeEvent")) {
            // <= 1.12
            CompatibilityMode.init();
        } else {
            IEventBus bus = MinecraftForge.EVENT_BUS;

            if (checkClass("net.minecraftforge.fml.common.gameevent.TickEvent")) {
                // 1.13
                bus.register(new RenderTickHandler11302());
            } else {
                // >=1.14
                bus.register(new RenderTickHandler11605());
            }

            if (checkClass("net.minecraftforge.client.event.CustomizeGuiOverlayEvent")) {
                // 1.19
                bus.register(new GuiEventHandler11903());
            } else {
                // 1.13-1.18
                bus.register(new GuiEventHandler11605());
            }
        }
    }

    private boolean checkClass(String clazz) {
        try {
            Class.forName(clazz, false, this.getClass().getClassLoader());

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
