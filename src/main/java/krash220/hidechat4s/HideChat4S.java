package krash220.hidechat4s;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import krash220.hidechat4s.launcher.IMod;
import krash220.hidechat4s.launcher.Platform;

public class HideChat4S implements IMod {

    public static final Logger LOGGER = LogManager.getLogger("HideChat4S");

    @Override
    public void init(Platform loader, String mcVersion) {
        LOGGER.info("ModLoader: {}, Game: {}", loader, mcVersion);
    }

}
