package cn.trollaura

import cn.trollaura.modules.*
import cn.trollaura.value.AbstractSetting
import java.util.concurrent.CopyOnWriteArrayList

object ModuleManager {
    var modules = CopyOnWriteArrayList<Module>()


    init {
        addModule(Sprint)
        addModule(Watermark)
        addModule(ClickGui)
        addModule(ArrayList)
        addModule(NoClickDelay)
        addModule(FastPlace)
    }


    fun addModule(module: Module) {
        module::class.java.declaredFields.forEach {
            it.isAccessible = true
            val obj = it.get(module)
            if(obj is AbstractSetting<*>) {
                module.settings.add(obj)
            }
        }
        modules.add(module)
    }



}