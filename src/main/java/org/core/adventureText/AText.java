package org.core.adventureText;

import org.core.adventureText.adventure.AdventureText;
import org.core.adventureText.format.TextColour;
import org.core.adventureText.legacy.LegacyText;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface AText {

    @NotNull
    AText append(@NotNull AText aText);

    boolean contains(@NotNull AText aText);

    @NotNull
    AText withAllAs(@NotNull String containing, @Nullable AText aText);

    Optional<TextColour> getColour();

    @NotNull
    AText withColour(@Nullable TextColour colour);

    @NotNull
    List<AText> getChildren();

    @NotNull
    String toPlain();

    @NotNull
    String toLegacy();

    default AText removeColour() {
        return withColour(null);
    }

    default boolean equalsLegacy(AText text) {
        return this.toLegacy().equals(text.toLegacy());
    }

    default boolean equalsIgnoreCase(AText text) {
        return this.toPlain().equalsIgnoreCase(text.toPlain());
    }

    static AText ofPlain(String text) {
        try {
            Class.forName("net.kyori.adventure.text.Component");
            Class.forName("net.kyori.adventure.text.serializer.plain.PlainComponentSerializer");
            return AdventureText.plain(text);
        } catch (ClassNotFoundException e) {
            return new LegacyText(null, text, Collections.emptyList());
        }
    }

    static AText ofLegacy(String text) {
        try {
            Class.forName("net.kyori.adventure.text.Component");
            Class.forName("net.kyori.adventure.text.serializer.plain.PlainComponentSerializer");
            Class.forName("net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer");
            return AdventureText.legacy(text);
        } catch (ClassNotFoundException e) {
            return new LegacyText(null, text, Collections.emptyList());
        }
    }

}
