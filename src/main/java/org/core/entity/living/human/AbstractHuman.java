package org.core.entity.living.human;

import org.core.entity.Entity;
import org.core.entity.InventoryHoldingEntity;
import org.core.entity.living.LivingEntity;
import org.core.entity.living.Tamer;
import org.core.source.projectile.EntityProjectileSource;

public interface AbstractHuman<E extends Entity<?>>
        extends LivingEntity<E>, InventoryHoldingEntity<E>, Tamer<E>, EntityProjectileSource {

    int getFoodLevel();

    double getExhaustionLevel();

    AbstractHuman<E> setExhaustionLevel(double value) throws IndexOutOfBoundsException;

    double getSaturationLevel();

    AbstractHuman<E> setSaturationLevel(double value) throws IndexOutOfBoundsException;

    String getName();

    boolean isSneaking();

    AbstractHuman<E> setSneaking(boolean sneaking);

    AbstractHuman<E> setFood(int value) throws IndexOutOfBoundsException;
}
