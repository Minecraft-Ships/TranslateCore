package org.core.config.parser.parsers;

import net.kyori.adventure.text.Component;
import org.core.config.parser.StringParser;
import org.core.utils.ComponentUtils;

import java.util.Optional;

public class StringToComponentLegacyParser implements StringParser<Component> {
    @Override
    public Optional<Component> parse(String original) {
        return Optional.of(ComponentUtils.fromLegacy(original));
    }

    @Override
    public String unparse(Component value) {
        return ComponentUtils.toLegacy(value);
    }
}
