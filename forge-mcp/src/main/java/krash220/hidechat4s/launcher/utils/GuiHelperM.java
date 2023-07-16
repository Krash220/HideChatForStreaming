package krash220.hidechat4s.launcher.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.ChatScreen;

public class GuiHelperM {

    public static boolean isChatScreen() {
        return Minecraft.getInstance().screen == null || Minecraft.getInstance().screen instanceof ChatScreen;
    }
}
