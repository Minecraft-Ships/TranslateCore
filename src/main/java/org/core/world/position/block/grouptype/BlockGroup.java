package org.core.world.position.block.grouptype;

import org.core.utils.Identifiable;
import org.core.world.position.block.BlockType;

public class BlockGroup implements Identifiable {

    private String id;
    private String name;
    private BlockType[] grouped;

    public BlockGroup(String id, String name, BlockType... types){
        this.id = id;
        this.name = name;
        this.grouped = types;
    }

    public BlockType[] getGrouped() {
        return this.grouped;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
