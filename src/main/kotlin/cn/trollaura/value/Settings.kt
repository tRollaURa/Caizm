package cn.trollaura.value

class BooleanSetting(override var name: String, override var description: String, override var value: Boolean): AbstractSetting<Boolean>(name,description,value)
class ModeSetting(override var name: String, override var description: String, override var value: String,var modes: MutableList<String>): AbstractSetting<String>(name,description,value)
class StringSetting(override var name: String, override var description: String, override var value: String): AbstractSetting<String>(name,description,value)