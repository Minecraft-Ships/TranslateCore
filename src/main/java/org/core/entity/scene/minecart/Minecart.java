package org.core.entity.scene.minecart;

import org.core.entity.Entity;

public interface Minecart<E extends Entity<?>> extends Entity<E> {

    boolean isSlowWhenEmpty();
    Minecart<E> setSlowWhenEmpty(boolean check);

}
