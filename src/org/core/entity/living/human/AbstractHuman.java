package org.core.entity.living.human;

import org.core.entity.InventoryHoldingEntity;
import org.core.entity.living.LivingEntity;
import org.core.entity.living.Tamer;
import org.core.source.projectile.EntityProjectileSource;

public interface AbstractHuman extends LivingEntity, InventoryHoldingEntity, Tamer, EntityProjectileSource {

    int getFoodLevel();
    double getExhaustionLevel();
    double getSaturationLevel();
    String getName();
    boolean isSneaking();

    AbstractHuman setFood(int value) throws IndexOutOfBoundsException;
    AbstractHuman setExhaustionLevel(double value) throws IndexOutOfBoundsException;
    AbstractHuman setSaturationLevel(double value) throws IndexOutOfBoundsException;
    AbstractHuman setSneaking(boolean sneaking);
}
