package org.core.inventory.inventories;

import org.core.entity.LiveEntity;
import org.core.inventory.Inventory;
import org.core.inventory.parts.ArmorPart;
import org.core.inventory.parts.InventoryPart;
import org.core.inventory.parts.Slot;
import org.core.world.position.impl.sync.SyncExactPosition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public interface BasicEntityInventory<E extends LiveEntity> extends Inventory.Parent {

    ArmorPart getArmor();

    Slot getMainHoldingItem();

    Slot getOffHoldingItem();

    SyncExactPosition getPosition();

    Optional<E> getAttachedEntity();

    @Override
    default Stream<InventoryPart> getParts() {
        return Stream.of(this.getArmor(), this.getMainHoldingItem(), this.getOffHoldingItem());
    }
}
