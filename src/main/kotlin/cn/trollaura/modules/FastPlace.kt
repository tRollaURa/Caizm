package cn.trollaura.modules

import cn.trollaura.Category
import cn.trollaura.Module
import cn.trollaura.mixin.IMinecraft
import net.minecraft.client.MinecraftClient

object FastPlace: Module("FastPlace","just fp.",Category.CLIENT) {
    override fun onTick() {
        (mc as IMinecraft).setItemUseCooldown(0)
    }
}