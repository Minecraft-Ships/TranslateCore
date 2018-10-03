package org.core.world.position.block.entity.sign;

import org.core.world.position.block.entity.TileEntity;

public interface SignTileEntity extends TileEntity {

    public String[] getLines();
    public SignTileEntity setLines(String... lines) throws IndexOutOfBoundsException;

}
