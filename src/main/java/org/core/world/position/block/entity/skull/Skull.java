package org.core.world.position.block.entity.skull;

import org.core.entity.living.human.player.User;
import org.core.world.position.block.entity.TileEntity;

import java.util.Optional;

public interface Skull extends TileEntity {

    Optional<User> getOwner();
    Skull setOwner(User user);
}
