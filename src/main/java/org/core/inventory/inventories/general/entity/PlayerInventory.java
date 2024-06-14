package org.core.inventory.inventories.general.entity;

import org.core.entity.living.human.player.LivePlayer;
import org.core.inventory.inventories.BasicEntityInventory;
import org.core.inventory.inventories.snapshots.entity.PlayerInventorySnapshot;
import org.core.inventory.parts.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public interface PlayerInventory extends BasicEntityInventory<LivePlayer> {

    Hotbar getHotbar();

    Grid2x2 getCraftingGrid();

    MainPlayerInventory getMainInventory();

    @Override
    default Stream<Slot> getItemSlots() {
        Stream<Slot> stream = this.getHotbar().getItemSlots();
        stream = Stream.concat(stream, this.getMainInventory().getItemSlots());
        stream = Stream.concat(stream, this.getArmor().getItemSlots());
        stream = Stream.concat(stream, Stream.of(this.getOffHoldingItem()));
        stream = Stream.concat(stream, this.getCraftingGrid().getItemSlots());
        return stream;
    }

    @Override
    PlayerInventorySnapshot createSnapshot();

    @Override
    default Slot getMainHoldingItem() {
        return this.getHotbar().getSelectedSlot();
    }

    @Override
    default Stream<InventoryPart> getParts() {
        return Stream.of(this.getArmor(), this.getOffHoldingItem(), this.getCraftingGrid(),
                                           this.getMainInventory(), this.getHotbar());
    }
}
