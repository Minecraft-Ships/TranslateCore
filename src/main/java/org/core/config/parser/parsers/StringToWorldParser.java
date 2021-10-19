package org.core.config.parser.parsers;

import org.core.TranslateCore;
import org.core.config.parser.StringParser;
import org.core.world.WorldExtent;

import java.util.Optional;

public class StringToWorldParser implements StringParser<WorldExtent> {
    @Override
    public Optional<WorldExtent> parse(String original) {
        return TranslateCore.getServer().getWorldByPlatformSpecific(original);
    }

    @Override
    public String unparse(WorldExtent value) {
        return value.getPlatformUniqueId();
    }
}
