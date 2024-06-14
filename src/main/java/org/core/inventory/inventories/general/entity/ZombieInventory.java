package org.core.inventory.inventories.general.entity;

import org.core.entity.LiveEntity;
import org.core.entity.living.hostile.undead.Zombie;
import org.core.inventory.inventories.BasicEntityInventory;
import org.core.inventory.inventories.snapshots.entity.ZombieInventorySnapshot;
import org.core.inventory.parts.Slot;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public interface ZombieInventory<Z extends Zombie<LiveEntity> & LiveEntity> extends BasicEntityInventory<Z> {

    @Override
    ZombieInventorySnapshot<Z> createSnapshot();

    @Override
    default Stream<Slot> getItemSlots() {
        Stream<Slot> stream = this.getArmor().getItemSlots();
        return Stream.concat(stream, Stream.of(this.getMainHoldingItem(), this.getOffHoldingItem()));
    }
}
