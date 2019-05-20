package org.core.entity;

import org.core.entity.living.LivingEntity;
import org.core.inventory.parts.Slot;

public interface ItemHoldingEntity extends LivingEntity {

    public Slot getHoldingItem();
}
