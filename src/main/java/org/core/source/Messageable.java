package org.core.source;

import net.kyori.adventure.text.Component;
import org.core.adventureText.AText;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface Messageable {

    @Deprecated(forRemoval = true)
    Messageable sendMessage(AText message, UUID uuid);

    @Deprecated(forRemoval = true)
    Messageable sendMessage(AText message);

    Messageable sendMessage(@NotNull Component message, @Nullable UUID uuid);

    default Messageable sendMessage(@NotNull Component message) {
        return this.sendMessage(message, null);
    }

    default Messageable sendPlainMessage(@NotNull String message, @Nullable UUID uuid) {
        this.sendMessage(Component.text(message), uuid);
        return this;
    }
}
