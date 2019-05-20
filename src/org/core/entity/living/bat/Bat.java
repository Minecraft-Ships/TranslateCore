package org.core.entity.living.bat;

import org.core.entity.Entity;

public interface Bat extends Entity {

    boolean isAwake();
    Bat setAwake(boolean state);
}
