package org.core.entity.living.human;

import org.core.entity.EntitySnapshot;

public interface AbstractHumanSnapshot<T extends AbstractHuman> extends EntitySnapshot<T> {

    public String getName();

}
