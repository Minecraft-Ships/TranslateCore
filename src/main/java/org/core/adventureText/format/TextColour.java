package org.core.adventureText.format;

import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class TextColour {

    private final int red;
    private final int green;
    private final int blue;
    private final String name;
    private final Character legacy;

    public static final char SYMBOL = '§';

    public TextColour(@Nullable String name, @Nullable Character legacy, int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
        this.legacy = legacy;
    }

    public int getRed() {
        return this.red;
    }

    public int getGreen() {
        return this.green;
    }

    public int getBlue() {
        return this.blue;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(this.name);
    }

    public Optional<Character> getLegacy() {
        return Optional.ofNullable(this.legacy);
    }
}
