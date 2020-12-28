package me.devnatan.katan.oauth.plugin

import me.devnatan.katan.api.MapBasedTranslator
import me.devnatan.katan.api.Translator
import me.devnatan.katan.api.plugin.*
import me.devnatan.katan.oauth.discord.DiscordOAuthProvider
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class OAuthPlugin : KatanPlugin("katan-oauth", "0.0.1") {

    companion object {

        private const val FALLBACK_LANGUAGE = "en"
        private const val MESSAGE_FILE_PATTERN = "messages-%s.properties"

    }

    internal lateinit var providers: OAuthProviders
    internal lateinit var translator: Translator

    init {
        handle(PluginEnabled, ::onEnable)
        handle(PluginDisabled) {
            for (provider in providers)
                unregisterService(provider::class)

            // ensure that all resources are finalized from providers
            // if this is a reload rather than a Katan finalization.
            providers.close()
        }
    }

    private fun onEnable() {
        setupTranslator()
        registerProviders()
        registerCommands()
    }

    private fun setupTranslator() {
        val locale = katan.translator.locale
        val tag = locale.toLanguageTag()
        val classLoader = this::class.java.classLoader
        translator = MapBasedTranslator(locale, Properties().apply {
            BufferedReader(
                InputStreamReader(
                    classLoader.getResourceAsStream(MESSAGE_FILE_PATTERN.format(tag))
                        ?: classLoader.getResourceAsStream(MESSAGE_FILE_PATTERN.format(FALLBACK_LANGUAGE))!!,
                    Charsets.UTF_8
                )
            ).use { input -> load(input) }
        }.mapKeys { (key, _) -> key.toString() })
    }

    private fun registerProviders() {
        providers = OAuthProviders()

        for (provider in arrayOf(DiscordOAuthProvider(katan))) {
            providers.register(provider)
            registerService(provider)
        }
    }

}