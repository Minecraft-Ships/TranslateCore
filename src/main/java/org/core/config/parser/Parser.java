package org.core.config.parser;

import org.core.config.parser.parsers.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface Parser <O, T> {

    StringToDoubleParser STRING_TO_DOUBLE = new StringToDoubleParser();
    StringToBooleanParser STRING_TO_BOOLEAN = new StringToBooleanParser();
    StringToIntegerParser STRING_TO_INTEGER = new StringToIntegerParser();
    StringToBlockTypeParser STRING_TO_BLOCK_TYPE = new StringToBlockTypeParser();
    StringToItemTypeParser STRING_TO_ITEM_TYPE = new StringToItemTypeParser();
    StringToWorldParser STRING_TO_WORLD = new StringToWorldParser();
    StringToStringParser STRING_TO_STRING_PARSER = new StringToStringParser();
    StringToVector3Int STRING_TO_VECTOR3INT = new StringToVector3Int();
    StringToUniqueIdParser STRING_TO_UNIQUE_ID = new StringToUniqueIdParser();
    StringToMinecraftTimeUnitParser STRING_TO_MINECRAFT_TIME_UNIT = new StringToMinecraftTimeUnitParser();
    StringToBlockPosition STRING_TO_BLOCK_POSITION = new StringToBlockPosition();
    StringToExactPosition STRING_TO_EXACT_POSITION = new StringToExactPosition();
    StringToATextLegacyParser STRING_TO_TEXT = new StringToATextLegacyParser();
    StringToTimeParser STRING_TO_TIME = new StringToTimeParser();
    StringToTimeRangeParser STRING_TO_TIME_RANGE = new StringToTimeRangeParser();

    Optional<T> parse(O original);
    O unparse(T value);

    static <E extends Enum> StringToEnumParser<E> getEnumParser(Class<E> clazz){
        return new StringToEnumParser<>(clazz);
    }

    static <O, T> List<T> parseList(Parser<O, T> parser, Collection<O> collection){
        List<T> list = new ArrayList<>();
        collection.forEach(v -> parser.parse(v).ifPresent(list::add));
        return list;
    }

    static <O, T> List<O> unparseList(Parser<O, T> parser, Collection<T> collection){
        List<O> list = new ArrayList<>();
        collection.forEach(v -> list.add(parser.unparse(v)));
        return list;
    }

}
