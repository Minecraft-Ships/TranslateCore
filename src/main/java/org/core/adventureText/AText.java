package org.core.adventureText;

import org.core.adventureText.adventure.AdventureText;
import org.core.adventureText.format.TextColour;
import org.core.adventureText.legacy.LegacyText;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * AText is a wrapper for all text on the server. If the server platform has AdventureComponent provided with it
 * (such as Sponge or Paper) then AText will wrap over that, however if the platform doesn't have AdventureComponent
 * then AText will wrap over a String using Legacy chat colours.
 * <p>
 * AText is immutable, therefore any modifications you do will be applied to the result of the method
 */
public interface AText {

    String COMPONENT_CLASS_PATH = "net.kyori.adventure.text.Component";
    String PLAIN_COMPONENT_CLASS_PATH = "net.kyori.adventure.text.serializer.plain.PlainComponentSerializer";
    String LEGACY_COMPONENT_CLASS_PATH = "net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer";

    /**
     * Converts a string with no formatting into AText
     *
     * @param text The text to wrap
     * @return The text object
     */
    static AText ofPlain(@NotNull String text) {
        try {
            Class.forName(COMPONENT_CLASS_PATH);
            Class.forName(PLAIN_COMPONENT_CLASS_PATH);
            return AdventureText.plain(text);
        } catch (ClassNotFoundException e) {
            return new LegacyText(null, text, Collections.emptyList());
        }
    }

    /**
     * Converts a string with legacy formatting into AText
     *
     * @param text The text to wrap
     * @return The text object
     */
    static AText ofLegacy(@NotNull String text) {
        try {
            Class.forName(COMPONENT_CLASS_PATH);
            Class.forName(PLAIN_COMPONENT_CLASS_PATH);
            Class.forName(LEGACY_COMPONENT_CLASS_PATH);
            return AdventureText.legacy(text);
        } catch (ClassNotFoundException e) {
            return new LegacyText(null, text, Collections.emptyList());
        }
    }

    /**
     * Adds the provided text to the end of this text
     *
     * @param aText The text to add to the end
     * @return The modified text
     */
    @NotNull AText append(@NotNull AText aText);

    /**
     * Checks if the provided text is included in this text
     * Note, that colours must match, if you don't need to match colours, then use {@link #toPlain()}
     *
     * @param aText The text to check for
     * @return if the provided text is contained
     */
    boolean contains(@NotNull AText aText);

    /**
     * Checks if the provided string is included in this text
     * Node, that the colours, styles, etc don't need to match
     *
     * @param s The string to check for
     * @return If the provided text is contained
     */
    default boolean contains(@NotNull String s) {
        return this.toPlain().contains(s);
    }

    /**
     * Checks if the provided string is included in this text
     * Node, that the colours, styles, etc don't need to match
     *
     * @param s          The string to check for
     * @param ignoreCase true if the s should be ignored on case
     * @return If the provided text is contained
     */
    default boolean contains(@NotNull String s, boolean ignoreCase) {
        if (ignoreCase) {
            return this.containsIgnoreCase(s);
        }
        return this.toPlain().contains(s);
    }

    boolean containsIgnoreCase(@NotNull String s);

    /**
     * Replace all the matching with the provided AText
     *
     * @param containing The text to look for
     * @param aText      The text to replace with
     * @return The modified text
     */
    @NotNull AText withAllAs(@NotNull String containing, @Nullable AText aText);

    @NotNull AText withAllAsIgnoreCase(@NotNull String containing, @Nullable AText aText);

    /**
     * Gets the text colour of this text
     *
     * @return The colour of the text - if colour is not changed, then it will be {@link Optional#empty()}
     */
    Optional<TextColour> getColour();

    /**
     * Changes the colour of this text with the provided colour,
     * this can be null to remove the colour. Removing the colour
     * will set the colour to the default. If default and this has
     * a parent with a colour then that colour will be displayed on this text
     *
     * @param colour The colour to change to
     * @return The modified text
     */
    @NotNull AText withColour(@Nullable TextColour colour);

    /**
     * Gets the children of the AText
     *
     * @return The children of the AText
     */
    @NotNull List<AText> getChildren();

    /**
     * Gets the text within this text
     *
     * @return the text in String form
     */
    @NotNull String toPlain();

    /**
     * Gets the text in legacy form
     *
     * @return the legacy text in String form
     */
    @NotNull String toLegacy();

    /**
     * Removes the colour. See {@link #withColour(TextColour)} for more info
     *
     * @return The modified text
     */
    default AText removeColour() {
        return this.withColour(null);
    }

    /**
     * Checks if the provided text is equal via legacy text
     *
     * @param text The text to compare
     * @return boolean check
     */
    default boolean equalsLegacy(AText text) {
        return this.toLegacy().equals(text.toLegacy());
    }

    /**
     * Checks if the provided text has the same text
     *
     * @param text The provided text
     * @return boolean check
     */
    default boolean equalsIgnoreCase(AText text) {
        return this.toPlain().equalsIgnoreCase(text.toPlain());
    }

}
