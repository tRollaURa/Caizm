package cn.trollaura.command

abstract class Command(var command: String,var usage: Array<out String>) {
    abstract fun run(args: Array<out String>)
}