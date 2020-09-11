package org.core.config.parser.parsers;

import org.core.config.parser.StringParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StringToBooleanParser implements StringParser.Suggestible<Boolean> {

    @Override
    public Optional<Boolean> parse(String original) {
        if(original.equalsIgnoreCase("true")){
            return Optional.of(true);
        }else if(original.equalsIgnoreCase("false")) {
            return Optional.of(false);
        }
        return Optional.empty();
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
