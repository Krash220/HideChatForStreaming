package krash220.hidechat.entrypoint.fabric;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import krash220.hidechat.ModHandler;
import krash220.hidechat.entrypoint.FabricLoader;
import net.minecraft.client.gui.hud.InGameHud;

@Mixin(InGameHud.class)
public class MixinInGameHud {

    @Inject(method = "method_1753", at = {
            @At(value = "INVOKE", target = "Lnet/minecraft/class_338;method_1805(Lnet/minecraft/class_4587;III)V"),
            @At(value = "INVOKE", target = "Lnet/minecraft/class_338;method_1805(Lnet/minecraft/class_4587;I)V"),
            @At(value = "INVOKE", target = "Lnet/minecraft/class_338;method_1805(I)V")
    })
    public void chatRenderStart(CallbackInfo ci) {
        if (FabricLoader.instance != null) {
            ModHandler.onChatRenderStart();
        }
    }

    @Inject(method = "method_1753", at = @At(value = "RETURN"))
    public void chatRenderEnd(CallbackInfo ci) {
        if (FabricLoader.instance != null) {
            ModHandler.onChatRenderEnd();
        }
    }
}
