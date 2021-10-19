package org.core.config.parser.parsers;

import org.core.TranslateCore;
import org.core.config.parser.StringParser;
import org.core.inventory.item.ItemType;
import org.core.platform.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringToItemTypeParser implements StringParser.Suggestible<ItemType> {
    @Override
    public Optional<ItemType> parse(String original) {
        Platform platform = TranslateCore.getPlatform();
        return platform.getItemType(original);
    }

    @Override
    public String unparse(ItemType value) {
        return value.getId();
    }

    @Override
    public List<ItemType> getSuggestions(String peek) {
        return TranslateCore.getPlatform().getItemTypes().stream().filter(it -> it.getId().toLowerCase().startsWith(peek.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public List<ItemType> getSuggestions() {
        return new ArrayList<>(TranslateCore.getPlatform().getItemTypes());
    }
}
