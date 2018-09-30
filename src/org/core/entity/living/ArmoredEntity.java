package org.core.entity.living;

import org.core.inventory.parts.ArmorPart;

public interface ArmoredEntity extends ItemHoldingEntity {

    public ArmorPart getArmorSlots();
}
