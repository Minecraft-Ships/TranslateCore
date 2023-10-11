package org.core.eco.account;

import org.core.eco.Currency;
import org.core.eco.transaction.Transaction;
import org.core.eco.transaction.pending.PendingSingleTransactionImpl;
import org.core.eco.transaction.pending.PendingTransaction;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class AccountSnapshot implements Account {

    private final Account account;
    private Map<Currency, BigDecimal> cachedAmount = new HashMap<>();

    public AccountSnapshot(Account account) {
        this.account = account;
    }

    @Override
    public @NotNull String getName() {
        return this.account.getName();
    }

    @Override
    public @NotNull PendingTransaction transact(@NotNull Transaction transaction) {
        switch (transaction.getType()) {
            case DEPOSIT -> {
                BigDecimal current = cachedAmount.get(transaction.getCurrency());
                if(current == null){
                    current = account.getBalance(transaction.getCurrency());
                }
                cachedAmount.put(transaction.getCurrency(), current.add(transaction.getAmount()));
                return new PendingSingleTransactionImpl(this, transaction, CompletableFuture.completedFuture());
            }
            case WITHDRAW -> {
            }
            case SET -> {
            }
        }
        return null;
    }

    @Override
    public @NotNull BigDecimal getBalance(@NotNull Currency currency) {
        BigDecimal amount = this.cachedAmount.get(currency);
        if (amount != null) {
            return amount;
        }
        amount = this.account.getBalance(currency);
        this.cachedAmount.put(currency, amount);
        return amount;
    }
}
