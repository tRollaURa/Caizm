package cn.trollaura.modules

import cn.trollaura.Category
import cn.trollaura.Module
import cn.trollaura.event.events.DrawEvent
import cn.trollaura.notification.NotificationManager

object Notification: Module("Notification","notify",Category.RENDER) {
    val startX = 100
    val startY = 100

    override fun onDraw(event: DrawEvent) {
        val x = startX
        var y = startY
        NotificationManager.notifies.apply { removeIf {it.expired()}  }.forEach { notify ->
            NotificationManager.NotifyRenderer(notify,x,y).draw(event.context).also { y += 20 }

        }
    }
}