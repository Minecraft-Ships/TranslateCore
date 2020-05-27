package org.core.entity.scene;

import org.core.entity.Entity;
import org.core.exceptions.DirectionNotSupported;
import org.core.world.direction.Direction;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.block.BlockTypes;

import java.util.Optional;

public interface AttachableEntity<E extends Entity> extends Entity<E> {

    Direction[] getDirections();
    Direction getDirection();
    AttachableEntity<E> setDirection(Direction direction) throws DirectionNotSupported;

    @Override
    default Optional<SyncBlockPosition> getAttachedTo(){
        SyncBlockPosition block = getPosition().toBlockPosition().getRelative(getDirection());
        if(block.getBlockType().equals(BlockTypes.AIR)){
            return Optional.empty();
        }
        return Optional.of(block);
    }
}
