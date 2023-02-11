package krash220.hidechat4s.launcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

public class ModLauncher {

    public static enum Event {
        RENDER_START, RENDER_END, RENDER_CHAT_START, RENDER_CHAT_END;
    }

    private static Map<Event, List<Runnable>> bus = new HashMap<>();

    static {
        for (Event e : Event.values()) {
            bus.put(e, new ArrayList<>());
        }
    }

    static void launch(Platform loader, String mcVersion) {
        

        ServiceLoader<IMod> services = ServiceLoader.load(IMod.class);

        services.forEach(mod -> {
            mod.init(loader, mcVersion);
        });
    }

    public static void register(Event event, Runnable listener) {
        bus.get(event).add(listener);
    }

    public static void post(Event event) {
        bus.get(event).forEach(listener -> listener.run());
    }
}
