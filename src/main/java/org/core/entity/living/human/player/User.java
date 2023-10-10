package org.core.entity.living.human.player;

import org.core.TranslateCore;
import org.core.eco.Currency;
import org.core.source.eco.EcoSource;
import org.core.source.eco.PlayerAccount;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface User {

    String getName();

    UUID getUniqueId();

    default CompletableFuture<Optional<PlayerAccount>> getAccount() {
        return TranslateCore.getCurrencyManager().getSourceFor(this);
    }
}
