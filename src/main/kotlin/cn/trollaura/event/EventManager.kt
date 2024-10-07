package cn.trollaura.event

import cn.trollaura.Module
import cn.trollaura.ModuleManager.modules
import cn.trollaura.event.events.DrawEvent
import cn.trollaura.event.events.KeyboardEvent
import cn.trollaura.event.events.TickEvent

object EventManager {
    fun init() {
        EventBus.register(this)
    }

    @Listener
    fun onTick(event: TickEvent) {
        modules
            .filter { it.enabled}
            .forEach { it.onTick() }
    }

    @Listener
    fun onKey(event: KeyboardEvent) {
        modules.forEach {
            if(it.key == event.key) {
                it.toggle()
            }
        }
    }

    @Listener
    fun onDraw(event: DrawEvent) {
        modules
            .filter { it.enabled }
            .forEach {
                it.onDraw(event)
            }
    }
}