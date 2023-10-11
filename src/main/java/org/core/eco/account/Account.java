package org.core.eco.account;

import org.core.TranslateCore;
import org.core.eco.Currency;
import org.core.eco.transaction.*;
import org.core.eco.transaction.pending.PendingTransaction;
import org.core.source.Source;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public interface Account extends Source {

    @NotNull String getName();

    @NotNull PendingTransaction transact(@NotNull Transaction transaction);

    default @NotNull CompletableFuture<PendingTransaction> transact(@NotNull Account other,
                                                                   BiFunction<Account, Account, Collection<PendingTransaction>> transactions) {
        return new SecureTransaction(this, other, transactions).run();
    }

    @NotNull BigDecimal getBalance(@NotNull Currency currency);

    default @NotNull BigDecimal getBalance() {
        return this.getBalance(TranslateCore.getCurrencyManager().getDefaultCurrency());
    }

    default PendingTransaction transact(@NotNull TransactionType type,
                                        @NotNull Currency currency,
                                        @NotNull Number amount) {
        return this.transact(new TransactionImpl(currency,
                                                 amount instanceof BigDecimal ? (BigDecimal) amount : BigDecimal.valueOf(
                                                         amount.doubleValue()), type));
    }

    default PendingTransaction deposit(@NotNull Currency currency, @NotNull Number amount) {
        return this.transact(TransactionType.DEPOSIT, currency, amount);
    }

    default PendingTransaction withdraw(@NotNull Currency currency, @NotNull Number amount) {
        return this.transact(TransactionType.WITHDRAW, currency, amount);
    }

    default PendingTransaction setBalance(@NotNull Currency currency, @NotNull Number amount) {
        return this.transact(TransactionType.SET, currency, amount);
    }
}
