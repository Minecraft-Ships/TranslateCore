package org.core.config.parser.parsers;

import org.core.config.parser.StringParser;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class StringToIntegerParser implements StringParser<Integer> {

    private final boolean positiveOnly;
    private final @NotNull String defaultValue;

    public StringToIntegerParser(@NotNull String defaultValue, boolean positiveOnly) {
        this.positiveOnly = positiveOnly;
        this.defaultValue = defaultValue;
    }

    @Override
    public Optional<Integer> parse(String original) {
        try {
            int value = Integer.parseInt(original);
            if (!this.positiveOnly) {
                return Optional.of(value);
            }
            if (value > 0) {
                return Optional.of(value);
            }
            return Optional.empty();
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    @Override
    public String unparse(Integer value) {
        if (value == null) {
            return this.defaultValue;
        }
        return "" + value;
    }
}
