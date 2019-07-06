package org.core.world.expload;

import org.core.entity.Entity;
import org.core.world.position.BlockPosition;
import org.core.world.position.ExactPosition;
import org.core.world.position.Positionable;

import java.util.Collection;

public interface Explosion extends Positionable {

    interface EntityExplosion extends Explosion {

        @Override
        Entity getSource();

        @Override
        default ExactPosition getPosition(){
            return getSource().getPosition();
        }

    }

    Collection<BlockPosition> getAffectedPositions();
    Object getSource();
}
