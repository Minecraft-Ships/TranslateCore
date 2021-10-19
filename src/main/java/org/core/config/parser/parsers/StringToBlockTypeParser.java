package org.core.config.parser.parsers;

import org.core.TranslateCore;
import org.core.config.parser.StringParser;
import org.core.platform.Platform;
import org.core.world.position.block.BlockType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringToBlockTypeParser implements StringParser.Suggestible<BlockType> {
    @Override
    public Optional<BlockType> parse(String original) {
        Platform platform = TranslateCore.getPlatform();
        return platform.getBlockType(original);
    }

    @Override
    public String unparse(BlockType value) {
        return value.getId();
    }

    @Override
    public List<BlockType> getSuggestions(String peek) {
        return TranslateCore.getPlatform().getBlockTypes().stream().filter(bt -> bt.getId().toLowerCase().startsWith(peek.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public List<BlockType> getSuggestions() {
        return new ArrayList<>(TranslateCore.getPlatform().getBlockTypes());
    }
}
