package org.core.config.parser.unspecific;

import org.core.config.ConfigurationNode;
import org.core.config.ConfigurationStream;
import org.core.utils.Identifiable;

import java.util.Optional;

@Deprecated
public interface UnspecificParser<T> extends Identifiable {

    void set(ConfigurationStream file, T value, ConfigurationNode node);

    Optional<T> parse(ConfigurationStream file, ConfigurationNode node);

    default Optional<T> parse(ConfigurationStream file, String... node) {
        return this.parse(file, new ConfigurationNode(node));
    }

    default void set(ConfigurationStream file, T value, String... node) {
        this.set(file, value, new ConfigurationNode(node));
    }
}
