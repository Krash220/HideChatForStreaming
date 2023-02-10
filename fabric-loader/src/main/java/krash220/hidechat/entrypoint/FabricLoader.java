package krash220.hidechat.entrypoint;

import krash220.hidechat.ModHandler;
import net.fabricmc.api.ModInitializer;

public class FabricLoader implements ModInitializer {

    public static FabricLoader instance;

    @Override
    public void onInitialize() {
        instance = this;

        ModHandler.onInit();
    }
}
