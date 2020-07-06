package org.core.configuration;

import org.core.configuration.parser.Parser;
import org.core.configuration.parser.StringParser;

import java.io.File;
import java.util.*;

public interface ConfigurationFile {

    /**
     * Gets the file that the config is attached to
     * @return A File of the config
     */
    File getFile();

    /**
     * Reloads the data within the file. This will undo any unsaved changes.
     * @return itself for chaining
     */
    ConfigurationFile reload();

    /**
     * Gets all known configuration nodes and the value that is attached to it
     * @return A map of all nodes with the attached object
     */
    Map<ConfigurationNode, Object> getKeyValues();

    /**
     * Gets the value at the node position with the conversion of the parser
     * @param node the location of the data to get
     * @param parser The converter
     * @param <T> The type of the value
     * @return An optional of the value, if the value is not present then it will return Optional.empty
     */
    <T extends Object> Optional<T> parse(ConfigurationNode node, Parser<? extends Object, T> parser);

    default <T> T parse(ConfigurationNode node, Parser<? extends Object, T> parser, T defaut) {
        return parse(node, parser).orElse(defaut);
    }

    /**
     * Gets a string value from the node placement
     * @param node the location of the value
     * @return An optional of String, if the node does not have a value it will return Optional.empty
     */
    Optional<String> parseString(ConfigurationNode node);
    Optional<Integer> parseInt(ConfigurationNode node);
    Optional<Double> parseDouble(ConfigurationNode node);
    Optional<Boolean> parseBoolean(ConfigurationNode node);
    <T extends Object> Optional<List<T>> parseList(ConfigurationNode node, StringParser<T> parser);

    String parseString(ConfigurationNode node, String defaut);
    int parseInt(ConfigurationNode node, int defaut);
    double parseDouble(ConfigurationNode node, double defaut);
    boolean parseBoolean(ConfigurationNode node, boolean defaut);
    <T extends Object> List<T> parseList(ConfigurationNode node, StringParser<T> parser, List<T> defaut);

    <T extends Object> void set(ConfigurationNode node, Parser<? extends Object, T> parser, T value);
    void set(ConfigurationNode node, Object value);

    ConfigurationNode getRootNode();
    void save();

    /**
     * Sets a collection value at the node, This will convert the collection to a String list to be saved correctly
     * @param node the location in the file to save
     * @param parser the converter to convert a value within the list to a String
     * @param value the collection
     * @param <T> The value type found inside the collection
     * @param <C> the collection type
     */
    default <T extends Object, C extends Collection<T>> void set(ConfigurationNode node, StringParser<T> parser, C value){
        List<String> list = new ArrayList<>();
        value.stream().forEach(v -> list.add(parser.unparse(v)));
        set(node, list);
    }

}
