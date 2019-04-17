package org.core.world.position.block.blocktypes;

import org.core.CorePlugin;
import org.core.world.position.block.BlockType;

public class CommonBlockTypes extends GarenteedBlockType {

    public static BlockType AIR = CorePlugin.getPlatform().get(new CommonBlockTypes("minecraft:air"));


    protected CommonBlockTypes(String id) {
        super(id);
    }
}
