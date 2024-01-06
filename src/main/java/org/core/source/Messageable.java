package org.core.source;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.JoinConfiguration;
import org.core.adventureText.AText;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface Messageable {

    @Deprecated(forRemoval = true)
    Messageable sendMessage(AText message, UUID uuid);

    @Deprecated(forRemoval = true)
    Messageable sendMessage(AText message);

    void sendMessage(@NotNull Component message, @Nullable UUID uuid);

    void sendMessage(@NotNull Component message);

    default void sendMessage(@NotNull Component... messageToJoin) {
        this.sendMessage(Component.join(JoinConfiguration.noSeparators(), messageToJoin));
    }

    default void sendPlainMessage(@NotNull String message, @Nullable UUID uuid) {
        this.sendMessage(Component.text(message), uuid);
    }
}
