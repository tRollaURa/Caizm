package cn.trollaura.modules

import cn.trollaura.Category
import cn.trollaura.Module
import net.minecraft.client.MinecraftClient

object FastPlace: Module("FastPlace","just fp.",Category.CLIENT) {
    override fun onTick() {
        MinecraftClient.getInstance()::class.java.getDeclaredField("field_1752").apply {
            isAccessible = true
        }
            .set(MinecraftClient.getInstance(),0)
    }
}