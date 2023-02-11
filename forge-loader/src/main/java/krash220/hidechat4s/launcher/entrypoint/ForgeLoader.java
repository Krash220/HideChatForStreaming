package krash220.hidechat4s.launcher.entrypoint;

import krash220.hidechat4s.launcher.GameHandler;
import krash220.hidechat4s.launcher.Platform;
import krash220.hidechat4s.launcher.entrypoint.forge.CompatibilityMode;
import krash220.hidechat4s.launcher.entrypoint.forge.GuiEventHandler11605;
import krash220.hidechat4s.launcher.entrypoint.forge.GuiEventHandler11903;
import krash220.hidechat4s.launcher.entrypoint.forge.RenderTickHandler11302;
import krash220.hidechat4s.launcher.entrypoint.forge.RenderTickHandler11605;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.versions.mcp.MCPVersion;

@Mod(value = "${MOD_ID}", modid = "${MOD_ID}")
public class ForgeLoader {

    public ForgeLoader() {
        if (checkClass("net.minecraftforge.fml.common.eventhandler.SubscribeEvent")) {
            // <= 1.12
            CompatibilityMode.init();
        } else {
            GameHandler.onModInit(Platform.FORGE, MCPVersion.getMCVersion());

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
