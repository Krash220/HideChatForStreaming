package krash220.hidechat4s.launcher;

import krash220.hidechat4s.launcher.ModLauncher.Event;

public class GameHandler {
    public static void onModInit() {
        ModLauncher.launch();
    }

    public static void onRenderTickStart() {
        ModLauncher.post(Event.RENDER_START);
    }

    public static void onRenderTickEnd() {
        ModLauncher.post(Event.RENDER_END);
    }

    public static void onChatRenderStart() {
        ModLauncher.post(Event.RENDER_CHAT_START);
    }
}
