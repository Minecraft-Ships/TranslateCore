package org.core.config.parser;

import java.util.ArrayList;
import java.util.List;

public interface StringParser<T extends Object> extends Parser<String, T> {

    /*interface SpecialParser<T> extends StringParser<T> {

        Optional<T> get(ConfigurationStream file, ConfigurationNode node);

        default void set(T value, ConfigurationStream file, ConfigurationNode node){
            file.set(node, value);
        }

        default void set(T value, ConfigurationStream file, String... node){
            set(value, file, new ConfigurationNode(node));
        }

        default Optional<T> get(ConfigurationStream file, String... node){
            return get(file, new ConfigurationNode(node));
        }

    }*/

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
