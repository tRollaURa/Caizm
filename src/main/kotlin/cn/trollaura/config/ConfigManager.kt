package cn.trollaura.config

import cn.trollaura.ModuleManager
import cn.trollaura.value.BooleanSetting
import cn.trollaura.value.DoubleSetting
import cn.trollaura.value.IntSetting
import cn.trollaura.value.StringSetting
import org.json.JSONArray
import org.json.JSONObject
import java.io.File

object ConfigManager {
    val MAIN_FOLDER = File("Caizm")
    val CONFIG_FOLDER = File(MAIN_FOLDER,"configs")
    val MODULE_FILE = File(CONFIG_FOLDER,"modules.json")

    init {
        MAIN_FOLDER.mkdirs()
        CONFIG_FOLDER.mkdirs()
    }

    fun saveDefault() {
        if (MODULE_FILE.exists().not()) {
            MODULE_FILE.createNewFile()
        }
        MODULE_FILE.writeText(JSONArray().apply {
            ModuleManager.modules.forEach { m ->
                put(JSONObject().apply {
                    put("name",m.name)
                    put("bind",m.key)
                    m.settings.forEach {
                        put(it.name,it.value)
                    }
                })
            }
        }.toString(4))

    }


    fun loadDefault() {
        if(MODULE_FILE.exists().not()) return

        val cfg = MODULE_FILE.readText()
        val ja = JSONArray(cfg)
        for (i in 0 until ja.length()) {
            val jo = ja.getJSONObject(i)
            ModuleManager.modules.forEach {
                val name = jo.getString("name")
                if(name == it.name) {
                    it.settings.forEach { s ->
                        when(s) {
                            is BooleanSetting -> s.value = jo.getBoolean(s.name)
                            is StringSetting -> s.value = jo.getString(s.name)
                            is IntSetting -> s.value = jo.getInt(s.name)
                            is DoubleSetting -> s.value = jo.getDouble(s.name)
                        }
                    }
                }
            }
        }
    }
}