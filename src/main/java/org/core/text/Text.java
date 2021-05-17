package org.core.text;

import org.core.adventureText.AText;

@Deprecated
public interface Text {

    boolean equalsExact(String chars);

    String toPlain();

    Text append(Text... text);

    AText toAdventure();

    default boolean equalsPlain(String text, boolean ignorecase) {
        return ignorecase ? toPlain().equalsIgnoreCase(text) : toPlain().equals(text);
    }

}
