package org.core.world.position.block.entity.sign;

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

}
