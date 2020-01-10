package org.core.world.position.block.entity.sign;

import org.core.text.Text;
import org.core.world.position.block.entity.TileEntity;

import java.util.Optional;

public interface SignTileEntity extends TileEntity {

    @Override
    SignTileEntitySnapshot getSnapshot();

    Text[] getLines();
    SignTileEntity setLines(Text... lines) throws IndexOutOfBoundsException;

    default Optional<Text> getLine(int a) throws IndexOutOfBoundsException{
        Text[] lines = getLines();
        if(a >= lines.length){
            return Optional.empty();
        }
        return Optional.ofNullable(lines[a]);
    }

    default SignTileEntity setLine(int a, Text value) throws IndexOutOfBoundsException{
        Text[] lines = getLines();
        lines[a] = value;
        return setLines(lines);
    }

}
