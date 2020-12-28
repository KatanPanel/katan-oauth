package me.devnatan.katan.oauth.provider

import me.devnatan.katan.oauth.subscription.Subscription

abstract class AbstractOAuthProvider(override val id: String, override val name: String) : OAuthProvider {

    override val subscriptions: MutableSet<Subscription> = hashSetOf()

    override suspend fun register(subscription: Subscription): Boolean {
        return synchronized(subscriptions) {
            subscriptions.add(subscription)
        }
    }

    override suspend fun unregister(subscription: Subscription): Boolean {
        return synchronized(subscriptions) {
            subscriptions.remove(subscription)
        }
    }

    override suspend fun close() {
        val iterator = subscriptions.iterator()
        while (iterator.hasNext()) {
            iterator.next()
            iterator.remove()
        }
    }

}