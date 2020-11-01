package org.core.command.argument.arguments.id;

import org.core.CorePlugin;
import org.core.world.position.block.BlockType;

import java.util.Collection;

public class BlockTypeArgument extends IdentifiableArgument<BlockType>{

    public BlockTypeArgument(String id) {
        super(id);
    }

    @Override
    public Collection<BlockType> getAll() {
        return CorePlugin.getPlatform().getBlockTypes();
    }
}
