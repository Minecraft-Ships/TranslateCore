package org.core.entity.living.human.player;

import org.core.source.eco.EcoSource;

import java.util.UUID;

public interface User extends EcoSource {

    String getName();
    UUID getUniqueId();
}
