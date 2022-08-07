package org.core.config;

import org.array.utils.ArrayUtils;
import org.core.TranslateCore;
import org.core.adventureText.AText;
import org.core.adventureText.format.NamedTextColours;
import org.core.config.parser.Parser;
import org.core.config.parser.StringMapParser;
import org.core.config.parser.StringParser;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public interface ConfigurationStream {

    ConfigurationFormat getFormat();

    Optional<Double> getDouble(ConfigurationNode node);

    Optional<Integer> getInteger(ConfigurationNode node);

    Optional<Boolean> getBoolean(ConfigurationNode node);

    Optional<String> getString(ConfigurationNode node);

    <T, C extends Collection<T>> C parseCollection(ConfigurationNode node, Parser<? super String, T> parser,
            C collection);

    void set(ConfigurationNode node, int value);

    void set(ConfigurationNode node, double value);

    void set(ConfigurationNode node, boolean value);

    void set(ConfigurationNode node, String value);

    <T> void set(ConfigurationNode node, Parser<String, ? super T> parser, Collection<T> collection);

    Set<ConfigurationNode> getChildren(ConfigurationNode node);

    void reload();

    void save();

    default Set<ConfigurationNode> getChildren() {
        return this.getChildren(new ConfigurationNode());
    }

    default void set(ConfigurationNode node, Map<String, String> value) {
        value.forEach((key, value1) -> {
            String[] args = key.split(Pattern.quote("."));
            String[] fullArgs = ArrayUtils.join(String.class, node.getPath(), args);
            this.set(new ConfigurationNode(fullArgs), value1);
        });
    }

    default <T> void set(ConfigurationNode node, StringMapParser<T> parser, T value) {
        this.set(node, parser.unparse(value));
    }

    default <T> void set(ConfigurationNode node, StringParser<T> parser, T value) {
        if (parser.equals(Parser.STRING_TO_BOOLEAN)) {
            this.set(node, (Boolean) value);
            return;
        } else if (parser.equals(Parser.STRING_TO_DOUBLE)) {
            this.set(node, ((Number) value).doubleValue());
            return;
        } else if (parser.equals(Parser.STRING_TO_INTEGER)) {
            this.set(node, ((Number) value).intValue());
            return;
        }
        try {
            this.set(node, parser.unparse(value));
        } catch (ClassCastException e) {
            TranslateCore
                    .getConsole()
                    .sendMessage(AText
                            .ofPlain("Path: " + String.join(".", node.getPath()))
                            .withColour(NamedTextColours.RED));
            TranslateCore
                    .getConsole()
                    .sendMessage(AText
                            .ofPlain("Value: (" + value.getClass().getName() + ") '" + value + "'")
                            .withColour(NamedTextColours.RED));
            e.printStackTrace();
        }
    }

    default <T> void set(ConfigurationNode.KnownParser.ChildKnown<T> node, T value) {
        this.set(node, node.getParser(), value);
    }

    default <T> void set(ConfigurationNode.KnownParser.SingleKnown<T> node, T value) {
        this.set(node, node.getParser(), value);
    }

    default <T, C extends Collection<T>> void set(ConfigurationNode.KnownParser.CollectionKnown<T> node, C value) {
        this.set(node, node.getParser(), value);
    }

    default <T> void set(ConfigurationNode.GroupKnown<T> node, Collection<? extends T> values) {
        Map<String, String> map = new HashMap<>();
        values.forEach(v -> {
            String key = node.toKey(v);
            Parser<String, T> mappedValue = node.getValueParsers().get(key);
            if (mappedValue == null) {
                throw new IllegalStateException(
                        "Can not save GroupKnown. Unknown Key of '"
                                + key
                                + "' from '"
                                + node
                                .getValueParsers()
                                .keySet()
                                .stream()
                                .map(t -> "\"" + t + "\t")
                                .collect(Collectors.joining(", "))
                                + "' which was created from GroupKnown.toKey(T)");
            }
            String value = mappedValue.unparse(v);
            map.put(key, value);
        });
        this.set(node, map);

    }

    default <T> Optional<T> parse(ConfigurationNode node, Parser<? super String, T> parser) {
        if (parser.equals(Parser.STRING_TO_INTEGER)) {
            return (Optional<T>) this.getInteger(node);
        } else if (parser.equals(Parser.STRING_TO_DOUBLE)) {
            return (Optional<T>) this.getDouble(node);
        } else if (parser.equals(Parser.STRING_TO_BOOLEAN)) {
            return (Optional<T>) this.getBoolean(node);
        }
        Optional<String> opValue = this.getString(node);
        if (!opValue.isPresent()) {
            return Optional.empty();
        }
        return parser.parse(opValue.get());
    }

    default <T> Optional<T> parse(ConfigurationNode.KnownParser<?, T> node) {
        if (node.getParser() instanceof StringParser) {
            return this.parse(node, (Parser<? super String, T>) node.getParser());
        } else if (node.getParser() instanceof StringMapParser) {
            return this.parse(node, (StringMapParser<T>) node.getParser());
        } else {
            throw new IllegalArgumentException("Unknown type of parser of '" + node.getParser().getClass().getName() +
                    "', ConfigurationStream.parse(ConfigurationNode.KnownParser) only accepts StringParser and " +
                    "StringMapParser");
        }
    }

    default <T> Optional<T> parse(ConfigurationNode node, StringMapParser<T> parser) {
        Map<String, String> map = new HashMap<>();
        for (String k : parser.getKeys()) {
            ConfigurationNode node1 = new ConfigurationNode(
                    ArrayUtils.join(String.class, node.getPath(), k.split("\\.")));
            Optional<String> opString = this.getString(node1);
            if (!opString.isPresent()) {
                return Optional.empty();
            }
            map.put(k, opString.get());
        }
        return parser.parse(map);
    }

    default <T> T parse(ConfigurationNode node, StringParser<T> parser, T value) {
        return this.parse(node, parser).orElse(value);
    }

    default <T> T parse(ConfigurationNode node, StringMapParser<T> parser, T value) {
        return this.parse(node, parser).orElse(value);
    }

    default <T> T parse(ConfigurationNode.KnownParser<?, T> node, T value) {
        return this.parse(node).orElse(value);
    }

    default <T, C extends Collection<T>> C parseCollection(ConfigurationNode.GroupKnown<T> node, C collection) {
        node.getValueParsers().forEach((key, value) -> {
            ConfigurationNode directNode = new ConfigurationNode(
                    ArrayUtils.join(String.class, node.getPath(), new String[]{key}));
            Optional<String> opValue = this.getString(directNode);
            if (!opValue.isPresent()) {
                return;
            }
            Optional<T> opParsed = value.parse(opValue.get());
            if (!opParsed.isPresent()) {
                return;
            }
            collection.add(opParsed.get());
        });
        return collection;
    }

    default <T, C extends Collection<T>> C parseCollection(ConfigurationNode.KnownParser<? super String, T> node,
            C collection) {
        return this.parseCollection(node, node.getParser(), collection);
    }

    default boolean getBoolean(ConfigurationNode node, boolean value) {
        return this.getBoolean(node).orElse(value);
    }

    default double getDouble(ConfigurationNode node, double value) {
        return this.getDouble(node).orElse(value);
    }

    default int getInteger(ConfigurationNode node, int value) {
        return this.getInteger(node).orElse(value);
    }

    default String getString(ConfigurationNode node, String value) {
        return this.getString(node).orElse(value);
    }

    interface ConfigurationFile extends ConfigurationStream {

        File getFile();

    }

}
