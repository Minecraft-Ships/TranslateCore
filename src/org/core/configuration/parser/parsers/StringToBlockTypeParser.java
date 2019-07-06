package org.core.configuration.parser.parsers;

import org.core.CorePlugin;
import org.core.configuration.parser.StringParser;
import org.core.platform.Platform;
import org.core.world.position.block.BlockType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringToBlockTypeParser implements StringParser.Suggestible<BlockType> {
    @Override
    public Optional<BlockType> parse(String original) {
        Platform platform = CorePlugin.getPlatform();
        return platform.getBlockType(original);
    }

    @Override
    public String unparse(BlockType value) {
        return value.getId();
    }

    @Override
    public List<BlockType> getSuggestions(String peek) {
        return CorePlugin.getPlatform().getBlockTypes().stream().filter(bt -> bt.getId().toLowerCase().startsWith(peek.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public List<BlockType> getSuggestions() {
        return new ArrayList<>(CorePlugin.getPlatform().getBlockTypes());
    }
}
