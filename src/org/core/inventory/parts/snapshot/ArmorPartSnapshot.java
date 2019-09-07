package org.core.inventory.parts.snapshot;

import org.core.inventory.parts.ArmorPart;
import org.core.inventory.parts.Slot;

public class ArmorPartSnapshot implements ArmorPart, InventoryPartSnapshot {

    protected SlotSnapshot helmet;
    protected SlotSnapshot armor;
    protected SlotSnapshot leggings;
    protected SlotSnapshot shoes;

    public ArmorPartSnapshot(ArmorPart part){
        this(part.getHelmetSlot(), part.getArmorSlot(), part.getLeggingsSlot(), part.getShoesSlot());

    }

    public ArmorPartSnapshot(Slot helmet, Slot armor, Slot leggings, Slot shoes){
        this.helmet = helmet.createSnapshot();
        this.armor = armor.createSnapshot();
        this.leggings = leggings.createSnapshot();
        this.shoes = shoes.createSnapshot();
    }

    @Override
    public Slot getHelmetSlot() {
        return this.helmet;
    }

    @Override
    public Slot getArmorSlot() {
        return this.armor;
    }

    @Override
    public Slot getLeggingsSlot() {
        return this.leggings;
    }

    @Override
    public Slot getShoesSlot() {
        return this.shoes;
    }

    @Override
    public ArmorPartSnapshot createSnapshot() {
        return new ArmorPartSnapshot(this);
    }
}
