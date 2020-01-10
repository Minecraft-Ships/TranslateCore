package org.core.inventory.parts;

import org.core.inventory.parts.snapshot.HotbarSnapshot;

public interface Hotbar extends InventoryPart {

    public int getSelectedSlotPos();

    @Override
    default HotbarSnapshot createSnapshot(){
        return new HotbarSnapshot(this);
    }

    public default Slot getSelectedSlot(){
        return this.getSlot(getSelectedSlotPos()).get();
    }
}
