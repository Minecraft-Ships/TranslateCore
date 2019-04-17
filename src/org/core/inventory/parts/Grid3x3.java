package org.core.inventory.parts;

import org.core.inventory.parts.snapshot.Grid3x3Snapshot;

public interface Grid3x3 extends InventoryPart {

    @Override
    Grid3x3Snapshot createSnapshot();
}
