package org.core.command.argument.arguments.block;

import org.core.command.argument.arguments.generic.SuggestibleParserArgument;
import org.core.configuration.parser.Parser;
import org.core.world.position.block.BlockType;

import java.io.IOException;

public class BlockTypeArgument extends SuggestibleParserArgument<BlockType> {

    public BlockTypeArgument(String id){
        super(id, Parser.STRING_TO_BLOCK_TYPE);
    }

    @Override
    protected IOException unableToParse(String next) {
        return new IOException("Unable to find block type of " + next);
    }
}
