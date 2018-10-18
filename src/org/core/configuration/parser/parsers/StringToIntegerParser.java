package org.core.configuration.parser.parsers;

import org.core.configuration.parser.StringParser;

import java.util.Optional;

public class StringToIntegerParser implements StringParser<Integer> {

    @Override
    public Optional<Integer> parse(String original) {
        int value = Integer.parseInt(original);
        return Optional.of(value);
    }

    @Override
    public String unparse(Integer value) {
        if(value == null){
            return "" + 0;
        }
        return "" + value;
    }
}
