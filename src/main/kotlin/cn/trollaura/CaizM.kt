package cn.trollaura

import cn.trollaura.config.ConfigManager
import cn.trollaura.event.EventBus
import cn.trollaura.event.EventManager
import cn.trollaura.gui.ScreenGui
import net.fabricmc.api.ModInitializer
import net.minecraft.client.gui.screen.Screen
import org.slf4j.LoggerFactory

object CaizM : ModInitializer {
    private val logger = LoggerFactory.getLogger("caizm")
	lateinit var screen: Screen

	override fun onInitialize() {
		EventManager.init()
		ModuleManager
		ConfigManager.loadDefault()
		screen = ScreenGui

	}

}