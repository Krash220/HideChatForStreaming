package krash220.hidechat;

public class ModHandler {

    public static void onInit() {
        System.out.println("onInit");
    }

    public static void onRenderTickStart() {
        System.out.println("onRenderTickStart");
    }

    public static void onRenderTickEnd() {
        System.out.println("onRenderTickEnd");
    }

    public static void onChatRenderStart() {
        System.out.println("onChatRenderStart");
    }

    public static void onChatRenderEnd() {
        System.out.println("onChatRenderEnd");
    }
}
