package cn.trollaura

import cn.trollaura.modules.*
import cn.trollaura.value.AbstractSetting
import java.util.concurrent.CopyOnWriteArrayList

object ModuleManager {
    var modules = CopyOnWriteArrayList<Module>()
    val settingsCache = mutableMapOf<Class<*>,MutableList<AbstractSetting<*>>>()


    init {
        addModules(FastPlace,
            Sprint,
            Watermark,
            ClickGui,
            ArrayList,
            NoClickDelay,
            Notification)
    }



    fun addModules(vararg moduleList: Module) {
        moduleList.forEach {
            val clazz = it::class.java
            val settings = settingsCache.getOrPut(clazz) {
                clazz.declaredFields.mapNotNull { i ->
                    i.isAccessible = true
                    i.get(it) as? AbstractSetting<*>
                }.toMutableList()
            }
            it.settings.addAll(settings)
        }
        modules.addAll(moduleList)
    }



}