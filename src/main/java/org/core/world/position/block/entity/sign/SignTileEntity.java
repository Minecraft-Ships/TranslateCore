package org.core.world.position.block.entity.sign;

import org.core.adventureText.AText;
import org.core.world.position.block.entity.TileEntity;

import java.util.*;

public interface SignTileEntity extends TileEntity {

    @Override
    SignTileEntitySnapshot getSnapshot();

    List<AText> getText();

    SignTileEntity setText(Collection<? extends AText> text);

    default SignTileEntity setText(AText... text) {
        return this.setText(Arrays.asList(text));
    }

    default Optional<AText> getTextAt(int a) throws IndexOutOfBoundsException {
        List<AText> lines = this.getText();
        if (a >= lines.size()) {
            return Optional.empty();
        }
        return Optional.ofNullable(lines.get(a));
    }

    default SignTileEntity setTextAt(int a, AText text) throws IndexOutOfBoundsException {
        List<AText> lines = new ArrayList<>(this.getText());
        lines.set(a, text);
        return this.setText(lines);
    }

}
