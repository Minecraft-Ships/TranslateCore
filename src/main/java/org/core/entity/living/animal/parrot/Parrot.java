package org.core.entity.living.animal.parrot;

import org.core.entity.Entity;
import org.core.entity.living.animal.AnimalEntity;

public interface Parrot<T extends Entity<?>> extends AnimalEntity<T> {

    ParrotType getVariant();
    Parrot<T> setVariant(ParrotType type);

}
