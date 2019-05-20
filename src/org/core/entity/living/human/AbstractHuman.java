package org.core.entity.living.human;

import org.core.entity.EntityType;
import org.core.entity.InventoryHoldingEntity;
import org.core.entity.living.LivingEntity;
import org.core.entity.living.Tamer;
import org.core.source.projectile.EntityProjectileSource;

public interface AbstractHuman extends LivingEntity, InventoryHoldingEntity, Tamer, EntityProjectileSource {

    int getFoodLevel();
    double getExhaustionLevel();
    double getSaturationLevel();
    boolean isSneaking();

    AbstractHuman setFood(int value) throws IndexOutOfBoundsException;
    AbstractHuman setExhaustionLevel(double value) throws IndexOutOfBoundsException;
    AbstractHuman setSaturationLevel(double value) throws IndexOutOfBoundsException;
    AbstractHuman setSneaking(boolean sneaking);

    @Override
    public EntityType<? extends AbstractHuman, ? extends AbstractHumanSnapshot<? extends AbstractHuman>> getType();

    @Override
    public AbstractHumanSnapshot<? extends AbstractHuman> createSnapshot();
}
