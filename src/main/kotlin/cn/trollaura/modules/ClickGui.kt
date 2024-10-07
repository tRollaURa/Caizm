package cn.trollaura.modules

import cn.trollaura.CaizM
import cn.trollaura.Category
import cn.trollaura.Module
import org.lwjgl.glfw.GLFW

object ClickGui: Module("Clickgui","click gui",Category.CLIENT) {
    init {
        this.key = GLFW.GLFW_KEY_Y
    }
    override fun onEnable() {
        mc.setScreen(CaizM.screen)
    }
}