package org.core.configuration.parser;

import org.core.configuration.ConfigurationFile;
import org.core.configuration.ConfigurationNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface StringParser<T extends Object> extends Parser<String, T> {

    interface SpecialParser<T> extends StringParser<T> {

        Optional<T> get(ConfigurationFile file, ConfigurationNode node);

        default void set(T value, ConfigurationFile file, ConfigurationNode node){
            file.set(node, value);
        }

        default void set(T value, ConfigurationFile file, String... node){
            set(value, file, new ConfigurationNode(node));
        }

        default Optional<T> get(ConfigurationFile file, String... node){
            return get(file, new ConfigurationNode(node));
        }

    }

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
