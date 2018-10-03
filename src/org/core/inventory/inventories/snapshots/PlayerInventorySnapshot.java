package org.core.inventory.inventories.snapshots;

import org.core.entity.living.human.player.Player;
import org.core.inventory.inventories.PlayerInventory;
import org.core.inventory.parts.*;
import org.core.inventory.parts.snapshot.*;


public abstract class PlayerInventorySnapshot implements PlayerInventory, EntityInventorySnapshot<Player> {

    protected SlotSnapshot offHand;
    protected ArmorPartSnapshot armor;
    protected HotbarSnapshot hotbar;
    protected Grid2x2Snapshot craftGridSnapshot;
    protected MainPlayerInventorySnapshot inventory;
    protected Player player;

    public PlayerInventorySnapshot(PlayerInventory inventory){
        this.offHand = inventory.getOffHoldingItem().createSnapshot();
        this.armor = inventory.getArmor().createSnapshot();
        this.hotbar = inventory.getHotbar().createSnapshot();
        this.craftGridSnapshot = inventory.getCraftingGrid().createSnapshot();
        this.inventory = inventory.getMainInventory().createSnapshot();
    }

    public void apply(){
        this.apply(getAttachedEntity());
    }

    @Override
    public Slot getOffHoldingItem() {
        return offHand;
    }

    @Override
    public ArmorPart getArmor() {
        return this.armor;
    }

    @Override
    public Hotbar getHotbar() {
        return this.hotbar;
    }

    @Override
    public Grid2x2 getCraftingGrid() {
        return this.craftGridSnapshot;
    }

    @Override
    public MainPlayerInventory getMainInventory() {
        return this.inventory;
    }

    @Override
    public Player getAttachedEntity() {
        return this.player;
    }

}
