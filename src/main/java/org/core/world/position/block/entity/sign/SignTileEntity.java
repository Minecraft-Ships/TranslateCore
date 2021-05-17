package org.core.world.position.block.entity.sign;

import org.core.adventureText.AText;
import org.core.text.Text;
import org.core.world.position.block.entity.TileEntity;

import java.util.*;

public interface SignTileEntity extends TileEntity {

    @Override
    SignTileEntitySnapshot getSnapshot();

    @Deprecated
    Text[] getLines();
    @Deprecated
    SignTileEntity setLines(Text... lines) throws IndexOutOfBoundsException;

    List<AText> getText();
    SignTileEntity setText(Collection<AText> text);

    default SignTileEntity setText(AText... text){
        return this.setText(Arrays.asList(text));
    }

    default Optional<AText> getTextAt(int a) throws IndexOutOfBoundsException {
        List<AText> lines = getText();
        if(a >= lines.size()){
            return Optional.empty();
        }
        return Optional.ofNullable(lines.get(a));
    }

    default Optional<Text> getLine(int a) throws IndexOutOfBoundsException{
        Text[] lines = getLines();
        if(a >= lines.length){
            return Optional.empty();
        }
        return Optional.ofNullable(lines[a]);
    }

    default SignTileEntity setTextAt(int a, AText text) throws IndexOutOfBoundsException {
        List<AText> lines = new ArrayList<>(getText());
        lines.set(a, text);
        return setText(lines);
    }

    default SignTileEntity setLine(int a, Text value) throws IndexOutOfBoundsException{
        Text[] lines = getLines();
        lines[a] = value;
        return setLines(lines);
    }

}
