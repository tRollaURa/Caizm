package cn.trollaura.modules

import cn.trollaura.Category
import cn.trollaura.Module
import cn.trollaura.value.BooleanSetting
import net.minecraft.client.MinecraftClient
import org.lwjgl.glfw.GLFW

object Sprint: Module("Sprint","sprint.",Category.CLIENT) {
    val test = BooleanSetting("test","sb.",false)
    init {
        this.enabled = true
        this.key = GLFW.GLFW_KEY_I
    }


    override fun onTick() {
        if ((mc.player != null && mc.world != null )) {
            mc.player!!.isSprinting = true
        }
        if(test.value) println("Sunxiaochuan")

    }

}