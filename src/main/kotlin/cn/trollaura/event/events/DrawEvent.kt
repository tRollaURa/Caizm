package cn.trollaura.event.events

import cn.trollaura.event.Event
import net.minecraft.client.gui.DrawContext

class DrawEvent(var context: DrawContext,var delta: Float): Event()