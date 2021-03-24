<p align="center"><img src="https://i.imgur.com/A4T861z.png" alt="Katan Logo"/></p>
<h1 align="center">katan-oauth</h1>

* [Introduction](#introduction)
  * [CLI Integration](#cli-integration)
  * [Hooking into](#hooking-into)
  * [Translations](#translations)
* [How to contribute](#how-to-contribute)
* [Modules](#modules)
* [License](#license)

## Introduction
katan-oauth is one of the official plug-ins developed by the creators of Katan, with it it is possible to add new authentication methods in addition to the username and password for an account.

Modules follows the [OAuth 2.0](https://tools.ietf.org/html/rfc6749) standard, so your password will not be exposed and we guarantee that your Katan account and the authentication method will be secure.

### CLI integration
Integration with the Katan CLI, to learn more, after its installation, use the following command:
```console
$ oauth
```

### Hooking into
Katan Dependency Manager (KDM)
```kotlin
init {
  dependencyManagement {
    plugin("katan-oauth-plugin")
  }
}
```

### Translations
Like all official Katan plugins, katan-oauth-plugin has internationalized messages for other languages, independently.
If you want to contribute with new translations, you can find the file [here](https://github.com/KatanPanel/katan-oauth-plugin/tree/main/plugin/src/main/resources), edit it and rename it to your language and send a Pull Request to us.

**Supported languages**
* English
* Português (Brasil)

## How to contribute
If you want to contribute to the project, create an [Issue](https://github.com/KatanPanel/katan-oauth-plugin/issues) or a [Pull Request](https://github.com/KatanPanel/katan-oauth-plugin/pulls) that will be analyzed.\
It is an open, open license project that can be maintained by the community.

If you have in mind to add a new alternative form of authentication, you can use the current implementation of Discord as an example.

## Modules

| Module | Description |
| ----------- | ------ |
| [plugin](https://github.com/KatanPanel/katan-oauth-plugin/tree/main/plugin) | boot other modules as a Katan plugin. |
| [oauth](https://github.com/KatanPanel/katan-oauth-plugin/tree/main/oauth) | contains abstract code for creating new authentication providers. |
| [oauth-discord](https://github.com/KatanPanel/katan-oauth-plugin/tree/main/oauth-discord) | support for [Discord](https://discor.com) authentication provider. |

## License
katan-oauth-plugin is licensed under [MIT](https://github.com/KatanPanel/katan-oauth-plugin/blob/main/LICENSE).
