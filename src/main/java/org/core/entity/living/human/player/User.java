package org.core.entity.living.human.player;

import org.core.TranslateCore;
import org.core.eco.account.PlayerAccount;

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
