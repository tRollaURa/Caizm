package cn.trollaura.value

open class NumberSetting<N: Number>(override var name: String, override var description: String, override var value: N, open var max: N, open var min: N, open var step: N): AbstractSetting<N>(name,description,value)

class IntSetting(override var name: String, override var description: String, override var value: Int, override var max: Int, override var min: Int, override var step: Int): NumberSetting<Int>(name,description, value, max, min, step)
class DoubleSetting(override var name: String, override var description: String, override var value: Double, override var max: Double, override var min: Double, override var step: Double): NumberSetting<Double>(name,description, value, max, min, step)
class FloatSetting(override var name: String, override var description: String, override var value: Float, override var max: Float, override var min: Float, override var step: Float): NumberSetting<Float>(name,description, value, max, min, step)