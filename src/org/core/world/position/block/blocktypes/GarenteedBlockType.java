package org.core.world.position.block.blocktypes;

import org.core.utils.Guaranteed;
import org.core.world.position.block.BlockType;

public class GarenteedBlockType implements Guaranteed<BlockType> {

    private String id;

    protected GarenteedBlockType(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        String nameLowercase = getId().split(":")[1];
        char first = Character.toUpperCase(nameLowercase.charAt(0));
        return first + nameLowercase.substring(1);
    }
}
