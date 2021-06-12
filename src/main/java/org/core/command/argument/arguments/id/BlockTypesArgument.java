package org.core.command.argument.arguments.id;

import org.core.command.argument.arguments.operation.FlatRemainingArgument;
import org.core.command.argument.arguments.operation.MappedArgumentWrapper;
import org.core.world.position.block.BlockType;

import java.util.Arrays;
import java.util.Collections;

/**
 * Gets a list of blocks from the remaining string arguments. This can accept either {@link BlockTypeArgument} or {@link BlockGroupArgument}
 */
public class BlockTypesArgument extends FlatRemainingArgument<BlockType> {

    public BlockTypesArgument(String id) {
        super(id, new MappedArgumentWrapper<>(new BlockGroupArgument(id), g -> Arrays.asList(g.getGrouped())), new MappedArgumentWrapper<>(new BlockTypeArgument(id), Collections::singletonList));
    }

}
