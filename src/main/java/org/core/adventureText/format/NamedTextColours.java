package org.core.adventureText.format;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface NamedTextColours {

    TextColour AQUA = new TextColour("AQUA", 'b', 21, 63, 63);
    TextColour BLACK = new TextColour("BLACK", '0', 0, 0, 0);
    TextColour BLUE = new TextColour("BLUE", '9', 21, 21, 63);
    TextColour DARK_AQUA = new TextColour("DARK_AQUA", '3', 0, 42, 42);
    TextColour DARK_BLUE = new TextColour("DARK_BLUE", '1', 0, 0, 42);
    TextColour DARK_GRAY = new TextColour("DARK_GRAY", '8', 21, 21, 21);
    TextColour DARK_GREEN = new TextColour("DARK_GREEN", '2', 0, 42, 0);
    TextColour DARK_PURPLE = new TextColour("DARK_PURPLE", '5', 42, 0, 42);
    TextColour DARK_RED = new TextColour("DARK_RED", '4', 42, 0, 0);
    TextColour GOLD = new TextColour("GOLD", '6', 42, 42, 0);
    TextColour GRAY = new TextColour("GRAY", '7', 42, 42, 42);
    TextColour GREEN = new TextColour("GREEN", 'a', 21, 63, 21);
    TextColour LIGHT_PURPLE = new TextColour("LIGHT_PURPLE", 'd', 63, 21, 63);
    TextColour RED = new TextColour("RED", 'c', 63, 21, 21);
    TextColour WHITE = new TextColour("WHITE", 'f', 63, 63, 63);
    TextColour YELLOW = new TextColour("YELLOW", 'e', 63, 63, 21);


    static Set<TextColour> colours() {
        return new HashSet<>(Arrays.asList(
                AQUA,
                BLACK,
                BLUE,
                DARK_AQUA,
                DARK_BLUE,
                DARK_GRAY,
                DARK_GREEN,
                DARK_PURPLE,
                DARK_RED,
                GOLD,
                GRAY,
                GREEN,
                LIGHT_PURPLE,
                RED,
                WHITE,
                YELLOW
        ));
    }
}
