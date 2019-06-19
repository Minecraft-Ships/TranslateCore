package org.core.inventory.inventories.snapshots.entity;

import org.core.entity.living.human.player.Player;
import org.core.entity.living.human.player.PlayerSnapshot;
import org.core.inventory.inventories.general.entity.PlayerInventory;
import org.core.inventory.parts.*;
import org.core.inventory.parts.snapshot.*;
import org.core.world.position.ExactPosition;


public abstract class PlayerInventorySnapshot implements PlayerInventory<Player>, EntityInventorySnapshot<Player> {

    protected SlotSnapshot offHand;
    protected ArmorPartSnapshot armor;
    protected HotbarSnapshot hotbar;
    protected Grid2x2Snapshot craftGridSnapshot;
    protected MainPlayerInventorySnapshot inventory;
    protected PlayerSnapshot player;

    public PlayerInventorySnapshot(PlayerInventory inventory){
        this.offHand = inventory.getOffHoldingItem().createSnapshot();
        this.armor = inventory.getArmor().createSnapshot();
        this.hotbar = inventory.getHotbar().createSnapshot();
        this.craftGridSnapshot = inventory.getCraftingGrid().createSnapshot();
        this.inventory = inventory.getMainInventory().createSnapshot();
    }

    @Override
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
    public PlayerSnapshot getAttachedEntity() {
        return this.player;
    }

    @Override
    public ExactPosition getPosition() {
        return getAttachedEntity().getPosition();
    }

}