package org.core.adventureText.format;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface NamedTextColours {

    TextColour AQUA = new TextColour("AQUA", 'b', 85, 255, 255);
    TextColour BLACK = new TextColour("BLACK", '0', 0, 0, 0);
    TextColour BLUE = new TextColour("BLUE", '9', 85, 85, 255);
    TextColour DARK_AQUA = new TextColour("DARK_AQUA", '3', 0, 170, 170);
    TextColour DARK_BLUE = new TextColour("DARK_BLUE", '1', 0, 0, 170);
    TextColour DARK_GRAY = new TextColour("DARK_GRAY", '8', 85, 85, 85);
    TextColour DARK_GREEN = new TextColour("DARK_GREEN", '2', 0, 170, 0);
    TextColour DARK_PURPLE = new TextColour("DARK_PURPLE", '5', 170, 0, 170);
    TextColour DARK_RED = new TextColour("DARK_RED", '4', 170, 0, 0);
    TextColour GOLD = new TextColour("GOLD", '6', 255, 170, 0);
    TextColour GRAY = new TextColour("GRAY", '7', 170, 170, 170);
    TextColour GREEN = new TextColour("GREEN", 'a', 85, 255, 85);
    TextColour LIGHT_PURPLE = new TextColour("LIGHT_PURPLE", 'd', 255, 85, 255);
    TextColour RED = new TextColour("RED", 'c', 255, 85, 85);
    TextColour WHITE = new TextColour("WHITE", 'f', 255, 255, 255);
    TextColour YELLOW = new TextColour("YELLOW", 'e', 255, 255, 85);


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
