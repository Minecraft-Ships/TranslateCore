package org.core.eco.transaction;

import org.core.eco.Currency;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class TransactionImpl implements Transaction {

    private final Currency currency;
    private final BigDecimal amount;
    private final TransactionType type;

    public TransactionImpl(Currency currency, BigDecimal amount, TransactionType type) {
        this.amount = amount;
        this.currency = currency;
        this.type = type;
    }

    @Override
    public @NotNull Currency getCurrency() {
        return this.currency;
    }

    @Override
    public @NotNull BigDecimal getAmount() {
        return this.amount;
    }

    @Override
    public @NotNull TransactionType getType() {
        return this.type;
    }
}
