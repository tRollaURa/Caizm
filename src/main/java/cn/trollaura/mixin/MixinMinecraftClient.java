package cn.trollaura.mixin;

import cn.trollaura.config.ConfigManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

    @Shadow @Final private Window window;

    @Redirect(method = "updateWindowTitle",at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/Window;setTitle(Ljava/lang/String;)V"))
    public void setTitle(Window instance, String title) {
        this.window.setTitle("迷你世界");
    }


    @Inject(method = "scheduleStop", at = @At(value = "HEAD"))
    public void stop(CallbackInfo ci) {
        ConfigManager.INSTANCE.saveDefault();
    }


}
