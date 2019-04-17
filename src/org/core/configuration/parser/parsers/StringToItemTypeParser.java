package org.core.configuration.parser.parsers;

import org.core.CorePlugin;
import org.core.configuration.parser.StringParser;
import org.core.inventory.item.ItemType;
import org.core.platform.Platform;

import java.util.Optional;

public class StringToItemTypeParser implements StringParser<ItemType> {
    @Override
    public Optional<ItemType> parse(String original) {
        Platform platform = CorePlugin.getPlatform();
        return platform.getItemType(original);
    }

    @Override
    public String unparse(ItemType value) {
        return value.getId();
    }
}
