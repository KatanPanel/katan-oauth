package me.devnatan.katan.oauth.plugin

import me.devnatan.katan.api.cli.command
import me.devnatan.katan.api.cli.fail
import me.devnatan.katan.api.cli.log
import me.devnatan.katan.api.plugin.registerCommand
import me.devnatan.katan.oauth.provider.containsSubscription
import me.devnatan.katan.oauth.provider.hasSubscription

fun OAuthPlugin.registerCommands() {
    registerCommand(command("oauth") {
        command("add", translator.translate("command.add")) {
            execute {
                if (args.isEmpty())
                    fail(translator.translate("correct-usage", "$label [${translator.translate("label.provider")}]"))

                val provider = providers.getProvider(args[0])
                    ?: fail(translator.translate("provider-not-found", args[0]))

                if (args.size == 1)
                    fail(translator.translate("correct-usage", "$label [${translator.translate("label.subscription")}]"))

                val subscription = try {
                    provider.wrap(args.copyOfRange(1, args.size))
                } catch (e: Throwable) {
                    fail(e.message!!)
                }

                if (provider.containsSubscription(subscription))
                    log(translator.translate("subscription-already-registered", subscription, provider.name))

                provider.register(subscription)
                log(translator.translate("subscription-registered", provider.name, subscription))
            }
        }

        command("remove", translator.translate("command.remove")) {
            execute {
                if (args.isEmpty())
                    fail(translator.translate("correct-usage", "$label [${translator.translate("label.provider")}]"))

                val provider = providers.getProvider(args[0])
                    ?: fail(translator.translate("provider-not-found", args[0]))

                if (args.size == 1)
                    fail(translator.translate("correct-usage", "$label [${translator.translate("label.subscription")}]"))

                val subscription = try {
                    provider.wrap(args.copyOfRange(1, args.size))
                } catch (e: Throwable) {
                    fail(e.message!!)
                }

                if (!provider.containsSubscription(subscription))
                    log(translator.translate("subscription-not-registered", subscription, provider.name))

                provider.unregister(subscription)
                log(translator.translate("subscription-unregistered", provider.name, subscription))
            }
        }
    })
}