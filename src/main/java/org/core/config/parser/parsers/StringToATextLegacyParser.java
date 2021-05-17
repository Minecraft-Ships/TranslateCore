package org.core.config.parser.parsers;

import org.core.adventureText.AText;
import org.core.adventureText.format.TextColour;
import org.core.config.parser.StringParser;

import java.util.Optional;

public class StringToATextLegacyParser implements StringParser<AText> {
    @Override
    public Optional<AText> parse(String original) {
        return Optional.of(AText.ofLegacy(original.replaceAll("&", TextColour.SYMBOL + "")));
    }

    @Override
    public String unparse(AText value) {
        return value.toLegacy().replaceAll(TextColour.SYMBOL + "", "&");
    }
}
