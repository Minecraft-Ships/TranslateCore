package org.core.source;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.JoinConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface Messageable {

    void sendMessage(@NotNull Component message, @Nullable UUID uuid);

    void sendMessage(@NotNull Component message);

    default void sendMessage(@NotNull Component... messageToJoin) {
        this.sendMessage(Component.join(JoinConfiguration.noSeparators(), messageToJoin));
    }

    default void sendPlainMessage(@NotNull String message, @Nullable UUID uuid) {
        this.sendMessage(Component.text(message), uuid);
    }
}
