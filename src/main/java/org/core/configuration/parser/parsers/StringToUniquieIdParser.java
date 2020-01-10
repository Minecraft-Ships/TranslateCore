package org.core.configuration.parser.parsers;

import org.core.configuration.parser.StringParser;

import java.util.Optional;
import java.util.UUID;

public class StringToUniquieIdParser implements StringParser<UUID> {
    @Override
    public Optional<UUID> parse(String original) {
        return Optional.of(UUID.fromString(original));
    }

    @Override
    public String unparse(UUID value) {
        return value.toString();
    }
}
