package cn.trollaura.config

import cn.trollaura.ModuleManager
import cn.trollaura.value.BooleanSetting
import cn.trollaura.value.DoubleSetting
import cn.trollaura.value.IntSetting
import cn.trollaura.value.StringSetting
import jdk.internal.org.jline.utils.Colors.J
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

    fun saveDefault0() = MODULE_FILE.apply {
        if (!exists()) createNewFile()
        writeText(JSONArray(ModuleManager.modules.map { m ->
            JSONObject(buildMap {
                put("name", m.name)
                put("bind", m.key)
                m.settings.forEach { put(it.name, it.value) }
            })
        }).toString(4))
    }


    fun loadDefault0() {
        if (!MODULE_FILE.exists()) return

        val jsonArray = JSONArray(MODULE_FILE.readText())

        repeat(jsonArray.length()) { i ->
            val obj = jsonArray.getJSONObject(i)
            val module = ModuleManager.modules.find { it.name == obj.getString("name") } ?: return@repeat

            module.settings.forEach { s ->
                when (s) {
                    is BooleanSetting -> s.value = obj.optBoolean(s.name, s.value)
                    is StringSetting  -> s.value = obj.optString(s.name, s.value)
                    is IntSetting     -> s.value = obj.optInt(s.name, s.value)
                    is DoubleSetting  -> s.value = obj.optDouble(s.name, s.value)
                }
            }
        }
    }

    fun loadDefault() {
        if (MODULE_FILE.exists().not()) return
        load("modules.json")
    }

    fun saveDefault() {
        if (MODULE_FILE.exists().not()) {
            MODULE_FILE.createNewFile()
        }
        save("modules.json")
    }

    fun save(name:String) {
        File(CONFIG_FOLDER,name).also {
            if (!it.exists()) it.createNewFile()
        }.writeText (JSONArray().apply {
            ModuleManager.modules.forEach { m ->
                put(JSONObject().apply {
                    put(
                        "name",
                        m.name
                    )
                    put ("bind", m.key)
                    m.settings.forEach { put(it.name, it.value) }
                })
            }
        }.toString(4))
    }

    fun load(name:String) {
        val cfg = File(CONFIG_FOLDER,name).takeIf { it.exists() }
            ?.readText()
            ?: return
        val ja = JSONArray(cfg)
        for (i in 0 until ja.length()) {
            val jo = ja.getJSONObject(i)
            ModuleManager. modules. forEach {
                val nam = jo.getString("name")
                if (nam == it.name) {
                    it.settings.forEach { s ->
                        when (s) {
                            is BooleanSetting ->
                                s.value = jo.getBoolean(s.name)
                            is StringSetting
                                -> s.value = jo.getString(s.name)
                            is IntSetting
                                -> s.value = jo.getInt(s.name)
                            is DoubleSetting
                                -> s.value = jo.getDouble(s.name)
                        }
                    }
                }
            }
        }
    }

}