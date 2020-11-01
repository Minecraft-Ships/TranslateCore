package org.core.command.argument.arguments.id;

import org.core.command.argument.arguments.operation.CollectedRemainingArgument;
import org.core.command.argument.arguments.operation.MappedArgumentWrapper;
import org.core.world.position.block.BlockType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BlockTypesArgument extends CollectedRemainingArgument<BlockType, List<BlockType>> {

    public BlockTypesArgument(String id){
        super(id, new MappedArgumentWrapper<>(new BlockGroupArgument(id), g -> Arrays.asList(g.getGrouped())), new MappedArgumentWrapper<>(new BlockTypeArgument(id), Collections::singletonList));
    }

}
