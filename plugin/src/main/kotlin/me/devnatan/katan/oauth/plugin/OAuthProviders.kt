package me.devnatan.katan.oauth.plugin

import me.devnatan.katan.oauth.provider.OAuthProvider

internal class OAuthProviders : Iterable<OAuthProvider> {

    private val providers: MutableSet<OAuthProvider> = hashSetOf()

    fun getProvider(name: String): OAuthProvider? {
        return providers.find { it.name.equals(name, true) }
    }

    fun register(provider: OAuthProvider) {
        synchronized(providers) {
            providers.add(provider)
        }
    }

    internal suspend fun close() {
        val iterator = providers.iterator()
        while (iterator.hasNext()) {
            iterator.next().close()
            iterator.remove()
        }
    }

    override fun iterator(): Iterator<OAuthProvider> {
        return providers.iterator()
    }

}