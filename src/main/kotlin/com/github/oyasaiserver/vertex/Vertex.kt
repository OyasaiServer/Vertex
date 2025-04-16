package com.github.oyasaiserver.vertex

import org.bukkit.plugin.java.JavaPlugin

class Vertex : JavaPlugin() {
    override fun onLoad() {}

    override fun onEnable() {}

    override fun onDisable() {}

    companion object {
        val plugin by lazy { getPlugin(Vertex::class.java) }
    }
}
