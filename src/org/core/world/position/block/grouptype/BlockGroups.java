package org.core.world.position.block.grouptype;

import org.core.world.position.block.BlockType;
import org.core.world.position.block.BlockTypes;

public enum BlockGroups implements BlockGroup{

    SIGN("Sign", BlockTypes.OAK_SIGN.get(), BlockTypes.OAK_WALL_SIGN.get());

    private String name;
    private BlockType[] grouped;

    BlockGroups(String name, BlockType... types){
        this.name = name;
        this.grouped = types;
    }

    @Override
    public BlockType[] getGrouped() {
        return this.grouped;
    }

    @Override
    public String getId() {
        return "core," + this.name.toLowerCase();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
