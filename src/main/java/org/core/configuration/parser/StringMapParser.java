package org.core.configuration.parser;

import java.util.List;
import java.util.Map;

public interface StringMapParser<T extends Object> extends Parser<Map<String, String>, T> {

    List<String> getKeys();
}
