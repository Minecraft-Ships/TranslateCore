package org.core.eco.account;

import org.core.eco.Currency;
import org.core.eco.transaction.Transaction;
import org.core.eco.transaction.pending.PendingSingleTransactionImpl;
import org.core.eco.transaction.pending.PendingTransaction;
import org.core.eco.transaction.result.TransactionResult;
import org.core.eco.transaction.result.impl.TransactionResultImpl;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

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
            case DEPOSIT:
                return this.transaction(transaction, BigDecimal::add);
            case WITHDRAW:
                return this.transaction(transaction, BigDecimal::subtract);
            case SET:
                return this.transaction(transaction, (current, newValue) -> newValue);
            default:
                throw new IllegalArgumentException(
                        "Unknown transaction type of '" + transaction.getType().name() + "'");
        }
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

    private PendingTransaction transaction(@NotNull Transaction transaction,
                                           BiFunction<BigDecimal, BigDecimal, BigDecimal> action) {
        BigDecimal current = cachedAmount.get(transaction.getCurrency());
        if (current == null) {
            current = account.getBalance(transaction.getCurrency());
        }
        BigDecimal newValue = action.apply(current, transaction.getAmount());
        if (newValue.compareTo(BigDecimal.ZERO) < 0) {
            String errorMessage = "Account balance cannot be less then 0";
            TransactionResult transactionResult = new TransactionResultImpl(transaction, current, errorMessage);
            return new PendingSingleTransactionImpl(this, transaction,
                                                    CompletableFuture.completedFuture(transactionResult));
        }
        cachedAmount.put(transaction.getCurrency(), newValue);
        TransactionResult transactionResult = new TransactionResultImpl(transaction, current, newValue);
        return new PendingSingleTransactionImpl(this, transaction,
                                                CompletableFuture.completedFuture(transactionResult));
    }
}
