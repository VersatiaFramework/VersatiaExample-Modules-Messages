package com.github.marcoral.versatia.example.messages

import com.github.marcoral.versatia.EventType
import com.github.marcoral.versatia.FriendlyName
import com.github.marcoral.versatia.VersatiaPlugin
import com.github.marcoral.versatia.lifecycle.AutoInvoke
import com.github.marcoral.versatia.messages.Messages
import com.github.marcoral.versatia.text.arg

/** `Messages` is the module's prototype: this plugin's own bank, read from its `messages/` directory. */
@FriendlyName("shop")
class MessagesPlugin : VersatiaPlugin() {
    /** Runs at start and at `/versatia reload shop`; the bank was reloaded just before, so an edited file shows here. */
    @AutoInvoke(EventType.PLUGIN_RELOAD_OR_START)
    fun announce(messages: Messages) {
        componentLogger.info(messages["shop.open"].get(arg("offers", 3)))
        componentLogger.info(messages["shop.closed"].get())
        logger.info("${messages.keys.size} messages: ${messages.keys}")
    }
}
