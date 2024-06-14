package org.core.inventory.parts;

import org.core.inventory.parts.snapshot.ArmorPartSnapshot;

import java.util.stream.Stream;

public interface ArmorPart extends InventoryPart {

    Slot getHelmetSlot();

    Slot getArmorSlot();

    Slot getLeggingsSlot();

    Slot getShoesSlot();

    @Override
    default ArmorPartSnapshot createSnapshot() {
        return new ArmorPartSnapshot(this);
    }

    @Override
    default Stream<Slot> getItemSlots() {
        return Stream.of(this.getHelmetSlot(), this.getArmorSlot(), this.getLeggingsSlot(), this.getShoesSlot());
    }

    @Override
    default int getSlotCount() {
        return 4;
    }
}
