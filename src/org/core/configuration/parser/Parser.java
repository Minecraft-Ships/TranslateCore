package org.core.configuration.parser;

import org.core.configuration.parser.parsers.*;

import java.util.Optional;

public interface Parser <O extends Object, T extends Object> {

    StringToDoubleParser STRING_TO_DOUBLE = new StringToDoubleParser();
    StringToBooleanParser STRING_TO_BOOLEAN = new StringToBooleanParser();
    StringToIntegerParser STRING_TO_INTEGER = new StringToIntegerParser();
    StringToBlockTypeParser STRING_TO_BLOCK_TYPE = new StringToBlockTypeParser();
    StringToWorldParser STRING_TO_WORLD = new StringToWorldParser();
    StringToStringParser STRING_TO_STRING_PARSER = new StringToStringParser();
    StringToVector3Int STRING_TO_VECTOR3INT = new StringToVector3Int();

    public Optional<T> parse(O original);
    public O unparse(T value);

}
