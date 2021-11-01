package org.core.entity.living.villager;

import org.core.entity.Entity;
import org.core.entity.living.AgeableEntity;
import org.core.entity.living.LivingEntity;
import org.core.entity.living.Merchant;

public interface BasicVillagerEntity<E extends Entity<?>> extends LivingEntity<E>, AgeableEntity<E>, Merchant<E> {


}
