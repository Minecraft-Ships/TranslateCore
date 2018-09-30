package org.core.inventory.parts;

public interface Hotbar extends InventoryPart {

    public int getSelectedSlotPos();

    public default Slot getSelectedSlot(){
        return getSlot(this.getSlotRange()[getSelectedSlotPos()]).get();
    }
}
