package me.devnatan.katan.oauth.discord

import me.devnatan.katan.api.Katan
import me.devnatan.katan.api.account.Account
import me.devnatan.katan.api.security.credentials.Credentials
import me.devnatan.katan.oauth.provider.AbstractOAuthProvider
import me.devnatan.katan.oauth.provider.getSubscription
import me.devnatan.katan.oauth.subscription.Subscription

class DiscordOAuthProvider(private val katan: Katan) : AbstractOAuthProvider("discord", "Discord") {

    override suspend fun authenticate(account: Account, credentials: Credentials): Boolean {
        val subscription = getSubscription(account.id) ?: return false
        require(subscription is DiscordSubscription) {
            "Only Discord subscriptions are accepted"
        }
        return true
    }

    override suspend fun wrap(args: Array<out String>): Subscription {
        val username = args.getOrNull(0) ?: error("Must specify Katan account username.")
        val discord = args.getOrNull(1) ?: error("Must specify discord account id.")

        val account = katan.accountManager.getAccount(username)
            ?: error("Account $username not found.")

        return getSubscription(account.id) ?: DiscordSubscription(account.id, discord)
    }

}