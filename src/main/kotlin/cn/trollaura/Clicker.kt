package cn.trollaura

import java.awt.Robot
import java.awt.event.MouseEvent

object Clicker {
    @JvmStatic
    fun main(args: Array<String>) {

        while (true) {
            val robot = Robot()
            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK)
            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK)
            Thread.sleep(10)
            println("我操我点击了一次")
        }
    }
}