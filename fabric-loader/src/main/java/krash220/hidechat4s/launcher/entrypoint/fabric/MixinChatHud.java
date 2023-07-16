package krash220.hidechat4s.launcher.entrypoint.fabric;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.screen.ChatScreen;

@Mixin(ChatHud.class)
public class MixinChatHud {

    @Inject(method = "method_23677", at = @At("HEAD"), cancellable = true)
    public void isChatHidden(CallbackInfoReturnable<Boolean> ci) {
        if (!(MinecraftClient.getInstance().currentScreen == null || MinecraftClient.getInstance().currentScreen instanceof ChatScreen)) {
            ci.setReturnValue(true);
        }
    }
}
