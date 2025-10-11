package cn.trollaura.mixin;

import cn.trollaura.modules.NoClickDelay;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class MixinPlayerEntity {
    @Inject(method = "getAttackCooldownProgressPerTick",at = @At("HEAD"), cancellable = true)
    public void modifyAttackCooldown(CallbackInfoReturnable<Float> cir) {
        if(NoClickDelay.INSTANCE.getEnabled()) {
            cir.setReturnValue(1.0F);
        }
    }
}
