package cn.trollaura.mixin;

import cn.trollaura.event.EventBus;
import cn.trollaura.event.events.DrawEvent;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHUDDraw {

    @Inject(method = "render",at = @At(value = "HEAD"))
    public void onRender(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        EventBus.INSTANCE.post(new DrawEvent(context,tickCounter.getTickDelta(true)));
    }
}
