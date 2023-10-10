package org.core.source.eco;

import org.core.entity.living.human.player.User;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface PlayerAccount extends Account {

    @NotNull UUID getId();

    @Override
    @NotNull String getName();
}
