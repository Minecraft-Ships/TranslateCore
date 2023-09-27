package org.core.eco;

import org.core.entity.living.human.player.Player;
import org.core.source.eco.EcoSource;
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

    CompletableFuture<Optional<EcoSource>> getSourceFor(@NotNull UUID uuid);

    default CompletableFuture<Optional<EcoSource>> getSourceFor(Player<?> player) {
        return this.getSourceFor(player.getUniqueId());
    }

}
