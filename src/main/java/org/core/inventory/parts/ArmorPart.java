package org.core.inventory.parts;

import org.core.inventory.parts.snapshot.ArmorPartSnapshot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
    default Set<Slot> getSlots() {
        return new HashSet<>(Arrays.asList(
                this.getHelmetSlot(),
                this.getArmorSlot(),
                this.getLeggingsSlot(),
                this.getShoesSlot()));
    }
}
