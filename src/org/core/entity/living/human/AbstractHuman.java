package org.core.entity.living.human;

import org.core.entity.EntityType;
import org.core.entity.living.InventoryHoldingEntity;
import org.core.entity.living.LivingEntity;
import org.core.entity.living.Tamer;
import org.core.source.projectile.EntityProjectileSource;

public interface AbstractHuman extends LivingEntity, InventoryHoldingEntity, Tamer, EntityProjectileSource {

    public int getFoodLevel();
    public double getExhaustionLevel();
    public double getSaturationLevel();

    public AbstractHuman setFood(int value) throws IndexOutOfBoundsException;
    public AbstractHuman setExhaustionLevel(double value) throws IndexOutOfBoundsException;
    public AbstractHuman setSaturationLevel(double value) throws IndexOutOfBoundsException;

    @Override
    public EntityType<? extends AbstractHuman, ? extends AbstractHumanSnapshot<? extends AbstractHuman>> getType();

    @Override
    public AbstractHumanSnapshot<? extends AbstractHuman> createSnapshot();
}
