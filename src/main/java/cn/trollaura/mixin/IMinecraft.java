package cn.trollaura.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * @author tRollaURa_
 * @since 2025/07/10 19:14
 */
@Mixin(MinecraftClient.class)
public interface IMinecraft {
    @Accessor("itemUseCooldown")
    @Mutable
    void setItemUseCooldown(int cooldown);
}
