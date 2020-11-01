package org.core.entity.living;

import org.core.entity.Entity;
import org.core.entity.living.human.AbstractHuman;

import java.util.Optional;

public interface Merchant<E extends Entity<?>> extends Entity<E> {

    Optional<AbstractHuman> getCustomer();
    Merchant<E> setCustomer();

}
