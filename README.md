# VersatiaExample-Modules-Messages

Messages read from YAML files under `messages/`, reloaded with the plugin, sent with runtime arguments: inject `Messages` from the Messages module and write `messages["shop.bought"].send(player, arg("item", stack))`.

Part of the [Versatia examples](https://github.com/VersatiaFramework/VersatiaExamples); documentation: [Messages module](https://versatiaframework.github.io/VersatiaDocs/docs/modules/messages).

**Start with** `src/main/resources/resources/messages/` and [`MessagesPlugin.kt`](src/main/kotlin/com/github/marcoral/versatia/example/messages/MessagesPlugin.kt), then [`Shop.kt`](src/main/kotlin/com/github/marcoral/versatia/example/messages/Shop.kt).

## What the log shows

```
The shop is open: 3 offers today.
The shop is closed.
Come back tomorrow.
4 messages: [shop.bought, shop.closed, shop.open, welcome.join]
```

A player joining is greeted with their name, world and position.

## Things to try

- Edit `plugins/VersatiaExample-Modules-Messages/messages/shop.yml` on the server and run
  `/versatia reload shop`: the new text is logged, nothing in the plugin knows about reloading.
- Break the YAML and reload: the reload fails with `Plugin ... failed to reload` naming the file,
  and the previous messages stay in use.
- Ask for `messages["shop.byu"]`: `Plugin VersatiaExample-Modules-Messages has no message "shop.byu";
  the messages under "shop" are: shop.bought, shop.closed, shop.open`.

## Building

Requires JDK 21 and VersatiaStarter with what it exports in your local Maven repository
(`./gradlew publishToMavenLocal` in each checkout; see
[Building the framework](https://versatiaframework.github.io/VersatiaDocs/docs/contributing/building)); running it requires a
Paper 1.21.4 server with VersatiaCore, VersatiaModule-Text and VersatiaModule-Messages installed.

```bash
./gradlew build
```

To have the JAR copied to your server after every build, copy `local.properties.example` to
`local.properties` and set `pluginsDir`. The generated descriptor is in
`build/generated/ksp/main/kotlin`; open it to see exactly what the runtime executes.
