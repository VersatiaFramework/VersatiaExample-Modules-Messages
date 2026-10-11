package com.github.marcoral.versatia.example.messages

import com.github.marcoral.versatia.messages.Messages
import com.github.marcoral.versatia.text.arg
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class Welcome(private val messages: Messages) : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) = messages["welcome.join"].send(event.player, arg("player", event.player))
}
