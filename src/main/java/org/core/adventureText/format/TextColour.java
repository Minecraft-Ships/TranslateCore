package org.core.adventureText.format;

import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * A text colour with RGB ability
 */
public class TextColour {

    public static final char SYMBOL = '§';
    private final int red;
    private final int green;
    private final int blue;
    private final String name;
    private final Character legacy;

    /**
     * Creates a text colour using RGB. Note that this will only work if AdventureComponent is enabled
     *
     * @param red   The red colour, between 0-255
     * @param green The green colour, between 0-255
     * @param blue  The blue colour, between 0-255
     */
    public TextColour(int red, int green, int blue) {
        this(null, null, red, green, blue);
    }

    TextColour(@Nullable String name, @Nullable Character legacy, int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
        this.legacy = legacy;
    }

    /**
     * The red colour
     *
     * @return The red colour between 0-255
     */
    public int getRed() {
        return this.red;
    }

    /**
     * The green colour
     *
     * @return The green colour between 0-255
     */
    public int getGreen() {
        return this.green;
    }

    /**
     * The blue colour
     *
     * @return The blue colour between 0-255
     */
    public int getBlue() {
        return this.blue;
    }

    /**
     * If a legacy colour, a name will be present
     *
     * @return The name of the colour, {@link Optional#empty()} if no name
     */
    public Optional<String> getName() {
        return Optional.ofNullable(this.name);
    }

    /**
     * If a legacy colour, a charact will be present (typically a hex number)
     *
     * @return The legacy colour code of the colour, {@link Optional#empty()} if no character
     */
    public Optional<Character> getLegacy() {
        return Optional.ofNullable(this.legacy);
    }
}
