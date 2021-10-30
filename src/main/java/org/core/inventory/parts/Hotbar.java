package org.core.inventory.parts;

import org.core.inventory.parts.snapshot.HotbarSnapshot;

public interface Hotbar extends InventoryPart {

    int getSelectedSlotPos();

    @Override
    default HotbarSnapshot createSnapshot() {
        return new HotbarSnapshot(this);
    }

    default Slot getSelectedSlot() {
        return this
                .getSlot(this.getSelectedSlotPos())
                .orElseThrow(() -> new IllegalStateException("Cannot get slot of " + this.getSelectedSlotPos()));
    }
}
