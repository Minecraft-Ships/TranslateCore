package org.core.command.argument.arguments.id;

import org.core.TranslateCore;
import org.core.world.position.block.grouptype.BlockGroup;

import java.util.Collection;

/**
 * Gets a block group from a single string argument
 */
public class BlockGroupArgument extends IdentifiableArgument<BlockGroup> {

    public BlockGroupArgument(String id) {
        super(id);
    }

    @Override
    public Collection<BlockGroup> getAll() {
        return TranslateCore.getPlatform().getBlockGroups();
    }
}
