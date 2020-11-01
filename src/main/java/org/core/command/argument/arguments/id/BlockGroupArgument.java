package org.core.command.argument.arguments.id;

import org.core.CorePlugin;
import org.core.world.position.block.grouptype.BlockGroup;

import java.util.Collection;

public class BlockGroupArgument extends IdentifiableArgument<BlockGroup> {

    public BlockGroupArgument(String id) {
        super(id);
    }

    @Override
    public Collection<BlockGroup> getAll() {
        return CorePlugin.getPlatform().getBlockGroups();
    }
}
