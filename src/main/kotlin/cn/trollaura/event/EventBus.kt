package cn.trollaura.event

import java.lang.reflect.Method

object EventBus {
    data class ListenerMethod(val target: Any, val method: Method, val p: Int)

    val listeners = mutableMapOf<Class<*>, MutableList<ListenerMethod>>()

    fun register(listener: Any) {
        val methods = listener::class.java.declaredMethods.filter { it.isAnnotationPresent(Listener::class.java) && it.parameterTypes.size == 1 }
        methods.forEach {
            val annotation = it.getAnnotation(Listener::class.java)
            val eventtype = it.parameterTypes.first()
            listeners.computeIfAbsent(eventtype) { mutableListOf() }
                .add(ListenerMethod(listener,it,annotation.p))
        }
    }

    fun post(event: Any) {
        listeners[event::class.java]?.sortedByDescending { it.p }
            ?.forEach {
                it.method.invoke(it.target,event)
                if(event is Event && event.cancelled) return
            }
    }

}