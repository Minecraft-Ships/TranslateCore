package org.core.entity.living;

import org.core.inventory.parts.Slot;

public interface ItemHoldingEntity extends LivingEntity {

    public Slot getHoldingItem();
}
