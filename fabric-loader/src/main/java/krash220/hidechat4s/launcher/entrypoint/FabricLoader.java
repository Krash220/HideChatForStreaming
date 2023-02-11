package krash220.hidechat4s.launcher.entrypoint;

import krash220.hidechat4s.launcher.GameHandler;
import krash220.hidechat4s.launcher.Platform;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.impl.FabricLoaderImpl;

public class FabricLoader implements ModInitializer {

    public static FabricLoader instance;

    @Override
    public void onInitialize() {
        instance = this;

        GameHandler.onModInit(Platform.FABRIC, FabricLoaderImpl.INSTANCE.getGameProvider().getRawGameVersion());
    }
}
