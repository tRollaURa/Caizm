package cn.trollaura.gui

import cn.trollaura.Category
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.text.Text
import java.util.concurrent.CopyOnWriteArrayList

object ScreenGui: Screen(Text.of("")) {
    val windows = CopyOnWriteArrayList<Window>()
    init {
        var x = 3
        Category.entries.forEach {
            windows.add(Window(it,x,5))
            x += 121
        }
    }


    override fun render(context: DrawContext?, mouseX: Int, mouseY: Int, delta: Float) {
        this.windows.forEach { it.render(context,mouseX, mouseY, delta) }
    }

    override fun mouseClicked(mouseX: Double, mouseY: Double, button: Int): Boolean {
        this.windows.forEach { it.mouseClicked(mouseX, mouseY, button) }
        return false
    }

    override fun mouseReleased(mouseX: Double, mouseY: Double, button: Int): Boolean {
        this.windows.forEach { it.mouseReleased(mouseX, mouseY, button) }
        return super.mouseReleased(mouseX, mouseY, button)
    }
}