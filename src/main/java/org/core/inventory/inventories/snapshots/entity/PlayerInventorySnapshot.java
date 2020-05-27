package org.core.inventory.inventories.snapshots.entity;

import org.core.entity.living.human.player.LivePlayer;
import org.core.inventory.inventories.general.entity.PlayerInventory;
import org.core.inventory.parts.*;
import org.core.inventory.parts.snapshot.*;
import org.core.world.position.impl.sync.SyncExactPosition;

import java.util.Optional;


public abstract class PlayerInventorySnapshot implements PlayerInventory, EntityInventorySnapshot<LivePlayer> {

    protected SlotSnapshot offHand;
    protected ArmorPartSnapshot armor;
    protected HotbarSnapshot hotbar;
    protected Grid2x2Snapshot craftGridSnapshot;
    protected MainPlayerInventorySnapshot inventory;
    protected LivePlayer player;

    public PlayerInventorySnapshot(PlayerInventory inventory){
        this.armor = inventory.getArmor().createSnapshot();
        this.offHand = inventory.getOffHoldingItem().createSnapshot();
        this.hotbar = inventory.getHotbar().createSnapshot();
        this.craftGridSnapshot = inventory.getCraftingGrid().createSnapshot();
        this.inventory = inventory.getMainInventory().createSnapshot();
        this.player = inventory.getAttachedEntity().get();
    }

    @Override
    public void apply(){
        this.apply(this.player);
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
    public Optional<LivePlayer> getAttachedEntity() {
        return Optional.of(this.player);
    }

    @Override
    public SyncExactPosition getPosition() {
        return this.player.getPosition();
    }

}
