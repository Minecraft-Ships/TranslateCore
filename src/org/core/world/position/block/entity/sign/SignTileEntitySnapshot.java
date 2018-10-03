package org.core.world.position.block.entity.sign;

import org.core.world.position.block.entity.TileEntitySnapshot;

public interface SignTileEntitySnapshot extends TileEntitySnapshot<SignTileEntity> {

    public String[] getLines();
    public SignTileEntitySnapshot setLines(String... lines) throws IndexOutOfBoundsException;
}
