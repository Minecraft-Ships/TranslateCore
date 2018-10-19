package org.core.world.position.block.entity.sign;

import org.core.world.position.block.entity.TileEntity;

public interface SignTileEntity extends TileEntity {

    @Override
    public SignTileEntitySnapshot getSnapshot();

    public String[] getLines();
    public SignTileEntity setLines(String... lines) throws IndexOutOfBoundsException;

    default String getLine(int a) throws IndexOutOfBoundsException{
        return getLines()[a];
    }

    default SignTileEntity setLine(int a, String value) throws IndexOutOfBoundsException{
        String[] lines = getLines();
        lines[a] = value;
        return setLines(lines);
    }

}
