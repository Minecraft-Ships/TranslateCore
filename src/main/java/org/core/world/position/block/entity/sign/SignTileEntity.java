package org.core.world.position.block.entity.sign;

import org.core.adventureText.AText;
import org.core.world.position.block.entity.TileEntity;

import java.util.*;

public interface SignTileEntity extends TileEntity {

    @Override
    SignTileEntitySnapshot getSnapshot();

    SignSide getSide(boolean frontSide);

    boolean isMultiSideSupported();

    default SignSide getFront() {
        return getSide(true);
    }

    default Optional<SignSide> getBack() {
        if (this.isMultiSideSupported()) {
            return Optional.of(getSide(false));
        }
        return Optional.empty();
    }

    @Deprecated(forRemoval = true)
    List<AText> getText();

    @Deprecated(forRemoval = true)
    SignTileEntity setText(Collection<? extends AText> text);

    @Deprecated(forRemoval = true)
    default SignTileEntity setText(AText... text) {
        return this.setText(Arrays.asList(text));
    }

    @Deprecated(forRemoval = true)
    default Optional<AText> getTextAt(int a) throws IndexOutOfBoundsException {
        List<AText> lines = this.getText();
        if (a >= lines.size()) {
            return Optional.empty();
        }
        return Optional.ofNullable(lines.get(a));
    }

    @Deprecated(forRemoval = true)
    default SignTileEntity setTextAt(int a, AText text) throws IndexOutOfBoundsException {
        List<AText> lines = new ArrayList<>(this.getText());
        lines.set(a, text);
        return this.setText(lines);
    }

}
