package org.core.world.position.block.entity.sign;

import org.core.world.position.block.entity.TileEntity;

import java.util.Optional;

public interface SignTileEntity extends TileEntity {

    @Override
    SignTileEntitySnapshot getSnapshot();

    String[] getLines();
    SignTileEntity setLines(String... lines) throws IndexOutOfBoundsException;

    default Optional<String> getLine(int a) throws IndexOutOfBoundsException{
        String[] lines = getLines();
        if(a >= lines.length){
            return Optional.empty();
        }
        return Optional.ofNullable(lines[a]);
    }

    default SignTileEntity setLine(int a, String value) throws IndexOutOfBoundsException{
        String[] lines = getLines();
        lines[a] = value;
        return setLines(lines);
    }

}
