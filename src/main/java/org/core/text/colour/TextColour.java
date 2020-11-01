package org.core.text.colour;

public interface TextColour {

    interface Named extends TextColour {

        String getName();

    }

    interface Legacy extends TextColour {

        char getLegacySign();
    }

    int getRed();
    int getGreen();
    int getBlue();
}
