package krash220.hidechat4s.launcher.entrypoint.fabric;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import krash220.hidechat4s.launcher.GameHandler;
import krash220.hidechat4s.launcher.entrypoint.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.screen.ChatScreen;

@Mixin(InGameHud.class)
public class MixinInGameHud {

    @Inject(method = "method_1753", at = {
            @At(value = "INVOKE", target = "Lnet/minecraft/class_338;method_1805(Lnet/minecraft/class_332;III)V"),
            @At(value = "INVOKE", target = "Lnet/minecraft/class_338;method_1805(Lnet/minecraft/class_4587;III)V"),
            @At(value = "INVOKE", target = "Lnet/minecraft/class_338;method_1805(Lnet/minecraft/class_4587;I)V"),
            @At(value = "INVOKE", target = "Lnet/minecraft/class_338;method_1805(I)V")
    })
    public void chatRenderStart(CallbackInfo ci) {
        if (FabricLoader.instance != null && (MinecraftClient.getInstance().currentScreen == null || MinecraftClient.getInstance().currentScreen instanceof ChatScreen)) {
            GameHandler.onChatRenderStart();
        }
    }
}
