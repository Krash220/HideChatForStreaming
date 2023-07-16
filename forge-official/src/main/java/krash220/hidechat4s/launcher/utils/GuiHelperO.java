package krash220.hidechat4s.launcher.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ChatScreen;

public class GuiHelperO {

    public static boolean isChatScreen() {
        return Minecraft.getInstance().screen == null || Minecraft.getInstance().screen instanceof ChatScreen;
    }
}
