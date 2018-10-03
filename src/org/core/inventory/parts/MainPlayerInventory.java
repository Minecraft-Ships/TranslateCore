package org.core.inventory.parts;

import org.core.inventory.parts.snapshot.MainPlayerInventorySnapshot;

public interface MainPlayerInventory extends InventoryPart {

    @Override
    default MainPlayerInventorySnapshot createSnapshot(){
        return new MainPlayerInventorySnapshot(this);
    }
}
