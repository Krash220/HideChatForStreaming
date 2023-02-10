package krash220.hidechat.entrypoint.fabric;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import krash220.hidechat.ModHandler;
import krash220.hidechat.entrypoint.FabricLoader;
import net.minecraft.client.MinecraftClient;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

    @Inject(method = "method_1523(Z)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_757;method_3192(FJZ)V"))
    public void renderStart(CallbackInfo ci) {
        if (FabricLoader.instance != null) {
            ModHandler.onRenderTickStart();
        }
    }
}
