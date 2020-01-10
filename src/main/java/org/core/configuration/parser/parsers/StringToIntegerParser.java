package org.core.configuration.parser.parsers;

import org.core.configuration.parser.StringParser;

import java.util.Optional;

public class StringToIntegerParser implements StringParser<Integer> {

    @Override
    public Optional<Integer> parse(String original) {
        try {
            int value = Integer.parseInt(original);
            return Optional.of(value);
        }catch (NumberFormatException e){
            return Optional.empty();
        }
    }

    @Override
    public String unparse(Integer value) {
        if(value == null){
            return "" + 0;
        }
        return "" + value;
    }
}
