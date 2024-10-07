package cn.trollaura.value

abstract class AbstractSetting<T: Any> @JvmOverloads constructor(open var name: String, open var description: String = "none", var defaultValue: T) {

    open val value = defaultValue
}