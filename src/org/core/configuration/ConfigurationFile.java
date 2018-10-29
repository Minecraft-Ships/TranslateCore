package org.core.configuration;

import org.core.configuration.parser.Parser;
import org.core.configuration.parser.StringParser;

import java.io.File;
import java.util.*;

public interface ConfigurationFile {

    File getFile();
    Map<ConfigurationNode, Object> getKeyValues();
    <T extends Object> Optional<T> parse(ConfigurationNode node, Parser<? extends Object, T> parser);
    Optional<String> parseString(ConfigurationNode node);
    Optional<Integer> parseInt(ConfigurationNode node);
    Optional<Double> parseDouble(ConfigurationNode node);
    Optional<Boolean> parseBoolean(ConfigurationNode node);
    <T extends Object> Optional<List<T>> parseList(ConfigurationNode node, StringParser<T> parser);
    <T extends Object> void set(ConfigurationNode node, Parser<? extends Object, T> parser, T value);
    void set(ConfigurationNode node, Object value);
    ConfigurationNode getRootNode();
    void save();

    default <T extends Object, C extends Collection<T>> void set(ConfigurationNode node, StringParser<T> parser, C value){
        List<String> list = new ArrayList<>();
        value.stream().forEach(v -> list.add(parser.unparse(v)));
        set(node, list);
    }

}
