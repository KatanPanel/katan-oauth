## Introduction
Currently, Katan has only a single native form of authentication, which is through the user's login and password.

katan-oauth-plugin is one of the official Katan plugins created that adds support
for multiple forms of authentication for Katan without the need for a password, only with the data of the corresponding application.

## CLI integration
This plugin has integration with the Katan CLI, to learn more, after its installation, use the following command:
```console
$ oauth
```

## Hooking into
Katan Dependency Manager (KDM)
```kotlin
init {
  dependencyManagement {
    plugin("katan-oauth-plugin")
  }
}
```

## How to contribute
If you want to contribute to the project, create an [Issue](https://github.com/KatanPanel/katan-oauth-plugin/issues) or a [PR](https://github.com/KatanPanel/katan-oauth-plugin/pulls) that will be analyzed.\
It is an open, open license project that can be maintained by the community.

If you have in mind to add a new alternative form of authentication, you can use the current implementation of Discord as an example.

## Translations
Like all official Katan plugins, katan-oauth-plugin has internationalized messages for other languages, independently.
If you want to contribute with new translations, you can find the file [here](https://github.com/KatanPanel/katan-oauth-plugin/tree/main/plugin/src/main/resources), edit it and rename it to your language and send a Pull Request to us.

**Supported languages**
* English
* Português (Brasil)

## Modules

| Module | Description |
| ----------- | ------ |
| [plugin](https://github.com/KatanPanel/katan-oauth-plugin/tree/main/plugin) | boot other modules as a Katan plugin. |
| [oauth](https://github.com/KatanPanel/katan-oauth-plugin/tree/main/oauth) | contains abstract code for creating new authentication providers. |
| [oauth-discord](https://github.com/KatanPanel/katan-oauth-plugin/tree/main/oauth-discord) | support for [Discord](https://discor.com) authentication provider. |

## License
katan-oauth-plugin is licensed under [MIT](https://github.com/KatanPanel/katan-oauth/blob/main/LICENSE).
