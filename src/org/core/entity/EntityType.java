package org.core.entity;

import org.core.utils.Identifable;

public interface EntityType <T extends Entity> extends Identifable {

    public Class<T> getEntityClass();

}
