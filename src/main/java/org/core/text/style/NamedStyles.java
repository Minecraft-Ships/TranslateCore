package org.core.text.style;

public enum NamedStyles implements TextStyle.Legacy, TextStyle.Named {

    OBFUSCATED("Obfuscated", 'k'),
    BOLD("Bold", 'l'),
    STRIKE_THOUGH("StrikeThough", 'm'),
    UNDERLINE("Underline", 'n'),
    ITALIC("Italic", 'o'),
    RESET("Reset", 'r');

    private final String name;
    private final char legacySign;

    NamedStyles(String name, char sign){
        this.name = name;
        this.legacySign = sign;
    }

    @Override
    public char getLegacySign() {
        return this.legacySign;
    }

    @Override
    public String getStyleName() {
        return this.name;
    }
}
