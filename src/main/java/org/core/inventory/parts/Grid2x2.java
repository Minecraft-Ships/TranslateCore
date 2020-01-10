package org.core.inventory.parts;

import org.core.inventory.parts.snapshot.Grid2x2Snapshot;

public interface Grid2x2 extends InventoryPart {

    @Override
    default Grid2x2Snapshot createSnapshot(){
        return new Grid2x2Snapshot(this);
    }
}
