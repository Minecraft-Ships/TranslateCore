package org.core.config.parser.parsers;

import org.core.config.parser.StringParser;

import java.time.LocalTime;
import java.util.Optional;

public class StringToTimeParser implements StringParser<LocalTime> {

    @Override
    public Optional<LocalTime> parse(String original) {
        return Optional.of(LocalTime.parse(original));
    }

    @Override
    public String unparse(LocalTime value) {
        return value.toString();
    }
}
