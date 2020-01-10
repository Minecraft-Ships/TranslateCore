package org.core.configuration.parser;

import java.util.ArrayList;
import java.util.List;

public interface StringParser<T extends Object> extends Parser<String, T> {

    interface Suggestible<T> extends StringParser<T> {

        List<T> getSuggestions(String peek);
        List<T> getSuggestions();

        default List<String> getStringSuggestions(){
            List<String> suggestions = new ArrayList<>();
            getSuggestions().stream().forEach(v -> suggestions.add(unparse(v)));
            return suggestions;
        }

        default List<String> getStringSuggestions(String peek){
            List<String> suggestions = new ArrayList<>();
            getSuggestions(peek).stream().forEach(v -> suggestions.add(unparse(v)));
            return suggestions;
        }

    }
}
