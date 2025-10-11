package cn.trollaura.notification

import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.DrawContext
import java.awt.Color
import kotlin.math.min

object NotificationManager {
    val notifies = mutableListOf<Notify>()
    val mc = MinecraftClient.getInstance()


    data class Notify(val time: Long,val msg: String) {
        val startTime = System.currentTimeMillis()

        fun progress() = min(1f,(System.currentTimeMillis() - startTime) / time.toFloat() )

        fun expired() = System.currentTimeMillis() - startTime >= time
    }


    data class NotifyRenderer(val notify: Notify,val x: Number,val y: Number) {
        fun draw(context: DrawContext) {
            context.drawTextWithShadow(mc.textRenderer,notify.msg,x.toInt(),y.toInt(),Color(255,255,255,(255 * (1 - notify.progress())).toInt()).rgb)
        }
    }

    fun addNotification(time: Long, msg: String) {
        notifies.add(Notify(time,msg))
    }
}