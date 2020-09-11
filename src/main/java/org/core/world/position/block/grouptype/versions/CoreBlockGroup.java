package org.core.world.position.block.grouptype.versions;

import org.array.utils.ArrayUtils;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.grouptype.BlockGroup;

public class CoreBlockGroup extends BlockGroup {

    CoreBlockGroup(String name, BlockType... types) {
        super("core:" + name.toLowerCase().replace(" ", "_"), name, types);
    }

    CoreBlockGroup(String name, BlockType[]... types){
        this(name, ArrayUtils.join(BlockType.class, types));
    }
}
