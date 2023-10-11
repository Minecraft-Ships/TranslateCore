package org.core.eco.transaction;

import org.core.eco.Currency;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

class AbstractTransaction implements Transaction {

    private final Currency currency;
    private final BigDecimal amount;

    AbstractTransaction(Currency currency, BigDecimal amount) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public @NotNull Currency getCurrency() {
        return this.currency;
    }

    @Override
    public @NotNull BigDecimal getAmount() {
        return this.amount;
    }
}
