package org.core.entity.living.animal.parrot;

import org.core.entity.EntitySnapshot;
import org.core.entity.LiveEntity;

public interface ParrotSnapshot extends Parrot<EntitySnapshot<? extends LiveEntity>>, EntitySnapshot<LiveParrot> {
}
