package me.devnatan.katan.oauth.provider

import me.devnatan.katan.api.security.auth.AuthenticationProvider
import me.devnatan.katan.api.security.auth.ExternalAuthenticationProvider
import me.devnatan.katan.oauth.subscription.Subscription
import java.util.*

interface OAuthProvider : ExternalAuthenticationProvider {

    val subscriptions: MutableSet<Subscription>

    val name: String

    suspend fun wrap(args: Array<out String>): Subscription

    suspend fun register(subscription: Subscription): Boolean

    suspend fun unregister(subscription: Subscription): Boolean

    suspend fun close()

}

fun OAuthProvider.getSubscription(accountId: UUID): Subscription? {
    return subscriptions.find { it.account == accountId }
}

fun OAuthProvider.hasSubscription(accountId: UUID): Boolean {
    return subscriptions.any { it.account == accountId }
}

fun OAuthProvider.containsSubscription(subscription: Subscription): Boolean {
    return subscriptions.contains(subscription)
}