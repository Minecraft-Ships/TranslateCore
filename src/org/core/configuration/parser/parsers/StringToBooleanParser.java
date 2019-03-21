package org.core.configuration.parser.parsers;

import org.core.configuration.parser.StringParser;

import java.util.Optional;

public class StringToBooleanParser implements StringParser<Boolean> {

    @Override
    public Optional<Boolean> parse(String original) {
        if(original.equalsIgnoreCase("true")){
            return Optional.of(true);
        }
        return Optional.of(false);
    }

    @Override
    public String unparse(Boolean value) {
        return value.toString();
    }
}
