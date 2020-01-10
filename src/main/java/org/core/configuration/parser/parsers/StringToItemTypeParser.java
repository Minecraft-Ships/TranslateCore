package org.core.configuration.parser.parsers;

import org.core.CorePlugin;
import org.core.configuration.parser.StringParser;
import org.core.inventory.item.ItemType;
import org.core.platform.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringToItemTypeParser implements StringParser.Suggestible<ItemType> {
    @Override
    public Optional<ItemType> parse(String original) {
        Platform platform = CorePlugin.getPlatform();
        return platform.getItemType(original);
    }

    @Override
    public String unparse(ItemType value) {
        return value.getId();
    }

    @Override
    public List<ItemType> getSuggestions(String peek) {
        return CorePlugin.getPlatform().getItemTypes().stream().filter(it -> it.getId().toLowerCase().startsWith(peek.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public List<ItemType> getSuggestions() {
        return new ArrayList<>(CorePlugin.getPlatform().getItemTypes());
    }
}
