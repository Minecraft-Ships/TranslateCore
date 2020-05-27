package org.core.inventory.inventories.live.entity;

import org.core.entity.living.human.player.LivePlayer;
import org.core.inventory.inventories.general.entity.PlayerInventory;
import org.core.world.position.impl.sync.SyncExactPosition;

public interface LivePlayerInventory extends PlayerInventory, LiveEntityInventory<LivePlayer> {

    @Override
    default SyncExactPosition getPosition(){
        return LiveEntityInventory.super.getPosition();
    }
}
