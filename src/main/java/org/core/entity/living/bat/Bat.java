package org.core.entity.living.bat;

import org.core.entity.Entity;
import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.vector.types.Vector3Double;
import org.core.world.position.BlockPosition;
import org.core.world.position.block.BlockTypes;

import java.util.Optional;

@SuppressWarnings("unchecked")
public interface Bat<E extends Entity> extends Entity<E> {

    boolean isAwake();
    Bat<E> setAwake(boolean state);

    @Override
    default EntityType<LiveBat, BatSnapshot> getType(){
        return EntityTypes.BAT;
    }

    @Override
    default Optional<BlockPosition> getAttachedTo(){
        BlockPosition block = getPosition().getRelative(new Vector3Double(0, 0.1, 0)).toBlockPosition();
        if(block.getBlockType().equals(BlockTypes.AIR)){
            return Optional.empty();
        }
        return Optional.of(block);
    }
}
