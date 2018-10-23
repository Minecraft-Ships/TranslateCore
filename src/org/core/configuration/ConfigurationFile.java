package org.core.configuration;

import org.core.configuration.parser.Parser;

import java.io.File;
import java.util.Map;
import java.util.Optional;

public interface ConfigurationFile {

    File getFile();
    Map<ConfigurationNode, Object> getKeyValues();
    <T extends Object> Optional<T> parse(ConfigurationNode node, Parser<? extends Object, T> parser);
    Optional<String> parseString(ConfigurationNode node);
    Optional<Integer> parseInt(ConfigurationNode node);
    Optional<Double> parseDouble(ConfigurationNode node);
    Optional<Boolean> parseBoolean(ConfigurationNode node);
    <T extends Object> void set(ConfigurationNode node, Parser<? extends Object, T> parser, T value);
    void set(ConfigurationNode node, Object value);
    ConfigurationNode getRootNode();
    void save();

}
