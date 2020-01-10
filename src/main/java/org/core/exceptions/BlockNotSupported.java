package org.core.exceptions;

import org.core.world.position.block.BlockType;

import java.io.IOException;

public class BlockNotSupported extends IOException {

    public BlockNotSupported(BlockType type, String what){
        super(what + " is not supported with " + type.getId());
    }

}
