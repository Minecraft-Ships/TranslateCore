package org.core.command.argument.arguments.id;

import org.core.command.argument.arguments.operation.FlatRemainingArgument;
import org.core.command.argument.arguments.operation.MappedArgumentWrapper;
import org.core.world.position.block.BlockType;

import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Gets a list of blocks from the remaining string arguments. This can accept either {@link BlockTypeArgument} or
 * {@link BlockGroupArgument}
 */
public class BlockTypesArgument extends FlatRemainingArgument<BlockType> {

    public BlockTypesArgument(String id) {
        super(id,
              new MappedArgumentWrapper<>(new BlockGroupArgument(id), g -> g.getBlocks().collect(Collectors.toList())),
              new MappedArgumentWrapper<>(new BlockTypeArgument(id), Collections::singletonList));
    }

}
