package org.core.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.jetbrains.annotations.NotNull;

public final class ComponentUtils {

    private ComponentUtils() {
        throw new RuntimeException("Should not create");
    }

    public static String toPlain(@NotNull Component component) {
        return PlainTextComponentSerializer.plainText().serialize(component);
    }

    public static String toGson(@NotNull Component component) {
        return GsonComponentSerializer.gson().serialize(component);
    }

    public static String toLegacy(@NotNull Component component) {
        return LegacyComponentSerializer.legacySection().serialize(component);
    }

    public static Component fromGson(@NotNull String message) {
        return GsonComponentSerializer.gson().deserialize(message);
    }

    public static Component fromPlain(@NotNull String message) {
        return PlainTextComponentSerializer.plainText().deserialize(message);
    }

    public static TextComponent fromLegacy(@NotNull String message) {
        return LegacyComponentSerializer.legacySection().deserialize(message);
    }

}
