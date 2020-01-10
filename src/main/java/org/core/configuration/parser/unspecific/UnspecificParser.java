package org.core.configuration.parser.unspecific;

import org.core.configuration.ConfigurationFile;
import org.core.configuration.ConfigurationNode;
import org.core.utils.Identifable;

import java.util.Optional;

@Deprecated
public interface UnspecificParser<T> extends Identifable {

    void set(ConfigurationFile file, T value, ConfigurationNode node);
    Optional<T> parse(ConfigurationFile file, ConfigurationNode node);

    default Optional<T> parse(ConfigurationFile file, String... node){
        return parse(file, new ConfigurationNode(node));
    }

    default void set(ConfigurationFile file, T value, String... node){
        set(file, value, new ConfigurationNode(node));
    }
}
