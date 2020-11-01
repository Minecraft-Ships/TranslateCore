package org.core.text.type;

public interface Text {

    char LEGACY_CHARACTER_CODE = '§';

    interface Charactable extends Text {

        String getText();

    }

    String toLegacyString();
}
