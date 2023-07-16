package krash220.hidechat4s.launcher.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;

public class GuiHelperMO {

    public static boolean isChatScreen() {
        return Minecraft.getMinecraft().currentScreen == null || Minecraft.getMinecraft().currentScreen instanceof GuiChat;
    }
}
