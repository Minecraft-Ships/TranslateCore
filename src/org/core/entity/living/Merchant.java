package org.core.entity.living;

import org.core.entity.living.human.AbstractHuman;

import java.util.Optional;

public interface Merchant {

    public Optional<AbstractHuman> getCustomer();
    public Merchant setCustomer();

}
