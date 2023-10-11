package org.core.eco.transaction;

import org.core.eco.Currency;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public interface Transaction {

    @NotNull Currency getCurrency();

    @NotNull BigDecimal getAmount();

    @NotNull TransactionType getType();

}
