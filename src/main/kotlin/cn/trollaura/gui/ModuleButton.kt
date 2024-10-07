package cn.trollaura.gui

import cn.trollaura.Module
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.DrawContext
import java.awt.Color

class ModuleButton(var module: Module,var x: Int,var y: Int) {
    var width = 120
    var height = 15


    fun render(context: DrawContext?, mouseX: Int, mouseY: Int, delta: Float) {
        context!!.fill(x,y,x + width,y + height,-1)
        context.fill(x,y,x + width,y + if(module.enabled) height else 0,Color(255).rgb)
        context.drawText(MinecraftClient.getInstance().textRenderer,module.name,x + 3,y + 3,-1,true)
    }

    fun mouseClicked(mouseX: Double, mouseY: Double, button: Int): Boolean {
        if(!this.isHover(x,y,width.toDouble(),height.toDouble(),mouseX.toInt(), mouseY.toInt())) return false
        when(button) {
            0 -> {
                module.toggle()
            }
        }
        return false
    }

    fun mouseReleased(mouseX: Double, mouseY: Double, button: Int): Boolean {
        return false
    }

    fun isHover(x: Int, y: Int, w: Double, h: Double, mouseX: Int, mouseY: Int): Boolean {
        return (mouseX >= x * 1.0f && mouseX <= (x + w) * 1.0f && mouseY >= y * 1.0f) && mouseY <= (y + h) * 1.0f
    }

    fun setLocation(x: Int,y: Int) {
        this.x = x
        this.y = y
    }
}