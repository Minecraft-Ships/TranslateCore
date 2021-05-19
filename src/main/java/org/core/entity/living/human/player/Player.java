package org.core.entity.living.human.player;

import org.core.entity.Entity;
import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.living.human.AbstractHuman;
import org.core.inventory.inventories.general.entity.PlayerInventory;

public interface Player<E extends Entity<?>> extends AbstractHuman<E>, User {

    boolean isViewingInventory();

    @Override
    default EntityType<LivePlayer, PlayerSnapshot> getType() {
        return EntityTypes.PLAYER.get();
    }

    @Override
    PlayerInventory getInventory();

    @Override
    PlayerSnapshot createSnapshot();

}
