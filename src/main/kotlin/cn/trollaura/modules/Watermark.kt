package cn.trollaura.modules

import cn.trollaura.CaizM
import cn.trollaura.Category
import cn.trollaura.Module
import cn.trollaura.event.events.DrawEvent
import org.lwjgl.glfw.GLFW

object Watermark: Module("Watermark","watermark.",Category.RENDER) {
    init {
        this.key = GLFW.GLFW_KEY_J
    }

    override fun onDraw(event: DrawEvent) {
        event.context.drawText(mc.textRenderer,"${CaizM::class.java.simpleName}v0.1",100,100,-1, true)
    }
}