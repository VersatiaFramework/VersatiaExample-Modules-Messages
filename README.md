# VersatiaExample-Modules-Messages

Messages read from YAML files under `messages/`, reloaded with the plugin, sent with runtime arguments: inject `Messages` from the Messages module and write `messages["shop.bought"].send(player, arg("item", stack))`. The text decides what to show of an argument, `{offer}`, `{offer.price.coins}`, `{player.location}`, and the plugin's own `Text` describes the types it shows.

Part of the [Versatia examples](https://github.com/VersatiaFramework/VersatiaExamples); documentation: [Messages module](https://versatiaframework.github.io/VersatiaDocs/docs/modules/messages).

**Start with** `src/main/resources/resources/messages/` and [`MessagesPlugin.kt`](src/main/kotlin/com/github/marcoral/versatia/example/messages/MessagesPlugin.kt), then [`Offer.kt`](src/main/kotlin/com/github/marcoral/versatia/example/messages/Offer.kt) and [`Shop.kt`](src/main/kotlin/com/github/marcoral/versatia/example/messages/Shop.kt).

## What the log shows

```
The shop is open: 3 offers today.
Today: Diamond for 5 coins (5 coins).
The shop is closed.
Come back tomorrow.
6 messages: [shop.open, shop.offer, shop.restock, shop.bought, shop.closed, welcome.join]
New stock in 3 min (180 s).
Chat stays text: <red>not red</red>
```

A player joining is greeted with their name, world and position.

## Things to try

- Edit `plugins/VersatiaExample-Modules-Messages/messages/shop.yml` on the server and run
  `/versatia reload shop`: the new text is logged, nothing in the plugin knows about reloading.
- Break the YAML and reload: the reload fails with `Plugin ... failed to reload` naming the file,
  and the previous messages stay in use.
- Write `{offer.colour}` in `shop.offer` and reload: the reload fails with
  `{offer} has no property "colour"; it has: item, price`. Write `{ofer}`:
  `No argument "ofer"; the arguments are: offer`. Braces that name nothing known, such as `{}` or
  `{ x }`, stay plain text.
- Ask for `messages["shop.byu"]`: `Plugin VersatiaExample-Modules-Messages has no message "shop.byu";
  the messages under "shop" are: shop.open, shop.offer, shop.restock, shop.bought, shop.closed`.

## Building

Requires JDK 21 and VersatiaStarter with what it exports in your local Maven repository
(`./gradlew publishToMavenLocal` in each checkout; see
[Building the framework](https://versatiaframework.github.io/VersatiaDocs/docs/contributing/building)); running it requires a
Paper 1.21.4 server with VersatiaCore and VersatiaModule-Messages installed.

```bash
./gradlew build
```

To have the JAR copied to your server after every build, copy `local.properties.example` to
`local.properties` and set `pluginsDir`. The generated descriptor is in
`build/generated/ksp/main/kotlin`; open it to see exactly what the runtime executes.
