package org.core.eco.account;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface PlayerAccount extends Account {

    @NotNull UUID getId();

    @Override
    @NotNull String getName();
}
