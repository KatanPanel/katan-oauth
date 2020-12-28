package me.devnatan.katan.oauth.discord

import me.devnatan.katan.oauth.subscription.Subscription
import java.util.*

class DiscordSubscription(
    override val account: UUID,
    val discordId: String
) : Subscription {

    override fun toString(): String {
        return discordId
    }

}