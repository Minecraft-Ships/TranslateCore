package org.core.entity.living.human.player;

import org.core.eco.Currency;
import org.core.source.eco.EcoSource;
import org.core.source.eco.PlayerAccount;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public interface User extends EcoSource {

    String getName();

    UUID getUniqueId();

    Optional<PlayerAccount> getAccount();

    @Override
    default void setBalance(@NotNull Currency currency, @NotNull BigDecimal decimal) {
        this.getAccount().ifPresent(account -> account.setBalance(currency, decimal));
    }

    @Override
    default BigDecimal getBalance(@NotNull Currency currency) {
        return this.getAccount().map(account -> account.getBalance(currency)).orElse(BigDecimal.ZERO);
    }
}
