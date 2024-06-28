package org.core.command.argument.arguments.id;

import org.core.TranslateCore;
import org.core.world.position.block.BlockType;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Gets a single BlockType from a single string argument
 */
public class BlockTypeArgument extends IdentifiableArgument<BlockType> {

    public BlockTypeArgument(String id) {
        super(id);
    }

    @Override
    public Collection<BlockType> getAll() {
        return TranslateCore.getPlatform().getAllBlockTypes().collect(Collectors.toList());
    }
}
