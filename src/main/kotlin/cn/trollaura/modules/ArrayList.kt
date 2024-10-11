package cn.trollaura.modules

import cn.trollaura.Category
import cn.trollaura.Module
import cn.trollaura.ModuleManager
import cn.trollaura.event.events.DrawEvent
import org.lwjgl.glfw.GLFW

object ArrayList: Module("ArrayList","array list",Category.RENDER) {
    init {
        key = GLFW.GLFW_KEY_X
    }

    override fun onDraw(event: DrawEvent) {
        var y = 100
        ModuleManager.modules.filter { it.enabled }.forEach {
            event.context.drawTextWithShadow(mc.textRenderer,it.name,100,y,-1)
            y += mc.textRenderer.fontHeight + 1
        }
    }
}