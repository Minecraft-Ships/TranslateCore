package org.core.eco.account;

import org.core.TranslateCore;
import org.core.eco.Currency;
import org.core.eco.transaction.*;
import org.core.eco.transaction.pending.PendingTransaction;
import org.core.source.Source;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;

public interface Account extends Source {

    @NotNull String getName();

    @NotNull PendingTransaction transact(@NotNull Transaction transaction);

    default @NotNull PendingTransaction transact(@NotNull Account other,
                                                 BiFunction<AccountSnapshot, AccountSnapshot, List<Transaction>> transactions) {
        return new SecureTransaction(this, other, transactions).run();
    }

    @NotNull BigDecimal getBalance(@NotNull Currency currency);

    default @NotNull BigDecimal getBalance() {
        return this.getBalance(TranslateCore.getCurrencyManager().getDefaultCurrency());
    }

    default PendingTransaction deposit(@NotNull Currency currency, @NotNull Number amount) {
        return this.transact(new DepositTransaction(this, currency,
                                                    amount instanceof BigDecimal ? (BigDecimal) amount : BigDecimal.valueOf(
                                                            amount.doubleValue())));
    }

    default PendingTransaction withdraw(@NotNull Currency currency, @NotNull Number amount) {
        return this.transact(new WithdrawTransaction(this, currency,
                                                     amount instanceof BigDecimal ? (BigDecimal) amount : BigDecimal.valueOf(
                                                             amount.doubleValue())));
    }

    default PendingTransaction setBalance(@NotNull Currency currency, @NotNull Number amount) {
        return this.transact(new SetTransaction(this, currency,
                                                amount instanceof BigDecimal ? (BigDecimal) amount : BigDecimal.valueOf(
                                                        amount.doubleValue())));
    }
}
