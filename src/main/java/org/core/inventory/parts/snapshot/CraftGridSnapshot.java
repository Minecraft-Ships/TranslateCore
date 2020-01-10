package org.core.inventory.parts.snapshot;

import org.core.inventory.parts.CraftGrid;
import org.core.inventory.parts.Slot;

import java.util.Collection;

public class CraftGridSnapshot extends Grid3x3Snapshot implements CraftGrid, InventoryPartSnapshot {

    public CraftGridSnapshot(CraftGrid grid){
        super(grid);
    }

    public CraftGridSnapshot(Slot... slots){
        super(slots);
    }

    public CraftGridSnapshot(Collection<Slot> slots){
        super(slots);
    }

    @Override
    public CraftGridSnapshot createSnapshot() {
        return new CraftGridSnapshot(this);
    }
}
