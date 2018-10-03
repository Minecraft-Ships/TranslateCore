package org.core.entity.living.human.player;

import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.living.human.AbstractHuman;
import org.core.inventory.inventories.PlayerInventory;

public interface Player extends AbstractHuman, User {

    public boolean isViewingInventory();

    @Override
    default EntityType<Player, PlayerSnapshot> getType(){
        return EntityTypes.PLAYER;
    }

    @Override
    public PlayerInventory getInventory();

    @Override
    public PlayerSnapshot createSnapshot();

}
