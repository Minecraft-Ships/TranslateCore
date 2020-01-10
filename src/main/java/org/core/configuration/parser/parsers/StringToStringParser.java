package org.core.configuration.parser.parsers;

import org.core.configuration.parser.StringParser;

import java.util.Optional;

public class StringToStringParser implements StringParser<String> {
    @Override
    public Optional<String> parse(String original) {
        return Optional.of(original);
    }

    @Override
    public String unparse(String value) {
        return value;
    }
}
