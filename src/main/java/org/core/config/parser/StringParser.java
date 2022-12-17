package org.core.config.parser;

import java.util.ArrayList;
import java.util.List;

public interface StringParser<T> extends Parser<String, T> {

    interface Suggestible<T> extends StringParser<T> {

        List<T> getSuggestions(String peek);

        List<T> getSuggestions();

        default List<String> getStringSuggestions() {
            List<String> suggestions = new ArrayList<>();
            this.getSuggestions().forEach(v -> suggestions.add(this.unparse(v)));
            return suggestions;
        }

        default List<String> getStringSuggestions(String peek) {
            List<String> suggestions = new ArrayList<>();
            this.getSuggestions(peek).forEach(v -> suggestions.add(this.unparse(v)));
            return suggestions;
        }

    }
}
