package org.core.inventory.parts;

import org.core.inventory.parts.snapshot.ArmorPartSnapshot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface ArmorPart extends InventoryPart {

    public Slot getHelmetSlot();
    public Slot getArmorSlot();
    public Slot getLeggingsSlot();
    public Slot getShoesSlot();

    @Override
    default ArmorPartSnapshot createSnapshot(){
        return new ArmorPartSnapshot(this);
    }

    @Override
    default Set<Slot> getSlots(){
        return new HashSet<>(Arrays.asList(getHelmetSlot(), getArmorSlot(), getLeggingsSlot(), getShoesSlot()));
    }
}
