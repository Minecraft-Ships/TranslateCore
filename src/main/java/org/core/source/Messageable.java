package org.core.source;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.JoinConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface Messageable {

    void sendMessage(@NotNull Component message);

    default void sendMessage(@NotNull Component... messageToJoin) {
        this.sendMessage(Component.join(JoinConfiguration.noSeparators(), messageToJoin));
    }
}
