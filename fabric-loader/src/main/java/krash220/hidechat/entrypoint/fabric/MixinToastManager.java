package krash220.hidechat.entrypoint.fabric;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import krash220.hidechat.ModHandler;
import krash220.hidechat.entrypoint.FabricLoader;
import net.minecraft.client.toast.ToastManager;

@Mixin(ToastManager.class)
public class MixinToastManager {

    @Inject(method = "method_1996", at = @At("RETURN"))
    public void renderEnd(CallbackInfo ci) {
        if (FabricLoader.instance != null) {
            ModHandler.onRenderTickEnd();
        }
    }
}
