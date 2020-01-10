package org.core.inventory.inventories.live.entity;

import org.core.entity.living.human.player.LivePlayer;
import org.core.inventory.inventories.general.entity.PlayerInventory;
import org.core.world.position.ExactPosition;

public interface LivePlayerInventory extends PlayerInventory, LiveEntityInventory<LivePlayer> {

    @Override
    default ExactPosition getPosition(){
        return LiveEntityInventory.super.getPosition();
    }
}
