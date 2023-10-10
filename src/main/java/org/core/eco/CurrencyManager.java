package org.core.eco;

import org.core.TranslateCore;
import org.core.entity.living.human.player.User;
import org.core.source.eco.Account;
import org.core.source.eco.NamedAccount;
import org.core.source.eco.PlayerAccount;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface CurrencyManager {

    boolean areCurrenciesSupported();

    boolean isEconomyEnabled();

    @NotNull Currency getDefaultCurrency();

    @NotNull Collection<Currency> getCurrencies();

    @NotNull CompletableFuture<Optional<NamedAccount>> getSourceFor(@NotNull String accountName);

    @NotNull CompletableFuture<Optional<PlayerAccount>> getSourceFor(@NotNull UUID uuid);

    default @NotNull CompletableFuture<Optional<PlayerAccount>> getSourceFor(@NotNull User user) {
        return this.getSourceFor(user.getUniqueId());
    }

}
