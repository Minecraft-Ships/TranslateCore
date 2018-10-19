package org.core.configuration;

import org.core.configuration.parser.Parser;

import java.io.File;
import java.util.Map;
import java.util.Optional;

public interface ConfigurationFile {

    File getFile();
    Map<ConfigurationNode, Object> getKeyValues();
    <T extends Object> Optional<T> parse(ConfigurationNode node, Parser<? extends Object, T> parser);
    ConfigurationNode getRootNode();
    void save();


}
