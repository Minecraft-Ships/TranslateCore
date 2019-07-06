package org.core.configuration.parser.parsers;

import org.core.configuration.parser.StringParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StringToBooleanParser implements StringParser.Suggestible<Boolean> {

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

    @Override
    public List<Boolean> getSuggestions(String peek) {
        List<Boolean> suggestions = new ArrayList<>();
        if("false".startsWith(peek.toLowerCase())){
            suggestions.add(false);
        }
        if("true".startsWith(peek.toLowerCase())){
            suggestions.add(true);
        }
        return suggestions;
    }

    @Override
    public List<Boolean> getSuggestions() {
        return Arrays.asList(false, true);
    }
}
