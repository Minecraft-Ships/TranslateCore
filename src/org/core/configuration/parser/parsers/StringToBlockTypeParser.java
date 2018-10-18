package org.core.configuration.parser.parsers;

import org.core.CorePlugin;
import org.core.configuration.parser.StringParser;
import org.core.world.position.block.BlockType;

import java.util.Optional;

public class StringToBlockTypeParser implements StringParser<BlockType> {
    @Override
    public Optional<BlockType> parse(String original) {
        return CorePlugin.getPlatform().get(original, BlockType.class);
    }

    @Override
    public String unparse(BlockType value) {
        return value.getId();
    }
}
