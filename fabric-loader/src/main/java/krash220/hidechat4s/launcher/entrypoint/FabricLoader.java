package krash220.hidechat4s.launcher.entrypoint;

import krash220.hidechat4s.launcher.GameHandler;
import net.fabricmc.api.ModInitializer;

public class FabricLoader implements ModInitializer {

    public static FabricLoader instance;

    @Override
    public void onInitialize() {
        instance = this;

        GameHandler.onModInit();
    }
}
