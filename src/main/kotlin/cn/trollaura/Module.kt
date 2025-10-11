package cn.trollaura

import cn.trollaura.event.events.DrawEvent
import cn.trollaura.notification.NotificationManager
import cn.trollaura.value.AbstractSetting
import net.minecraft.client.MinecraftClient
import java.util.concurrent.CopyOnWriteArrayList

open class Module(var name: String,var description: String,var category: Category) {

    var enabled = false
    val settings = CopyOnWriteArrayList<AbstractSetting<*>>()
    var key = -1
    val mc = MinecraftClient.getInstance()

    open fun onTick() {

    }

    open fun onEnable() {}
    open fun onDisable() {}
    open fun onDraw(event: DrawEvent) {}
    fun enable() {
        this.enabled = true
        onEnable()
    }

    fun disable() {
        this.enabled = false
        onDisable()
    }
    fun toggle() {
        if (enabled) {
            NotificationManager.addNotification(3000,"$name has been disabled.")
            disable()
        }else {
            NotificationManager.addNotification(3000,"$name has been enabled.")
            enable()
        }
    }
}