package org.core.config.parser.parsers;

import net.kyori.adventure.text.Component;
import org.core.config.parser.StringParser;
import org.core.utils.ComponentUtils;

import java.util.Optional;

public class StringToComponentGsonParser implements StringParser<Component> {
    @Override
    public Optional<Component> parse(String original) {
        if (original.contains("{")) {
            return Optional.of(ComponentUtils.fromGson(original));
        }
        return Optional.of(ComponentUtils.fromLegacy(original));
    }

    @Override
    public String unparse(Component value) {
        return ComponentUtils.toGson(value);
    }
}
