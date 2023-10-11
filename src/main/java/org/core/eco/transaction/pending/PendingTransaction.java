package org.core.eco.transaction.pending;

import org.core.eco.account.Account;
import org.core.eco.transaction.Transaction;
import org.core.eco.transaction.result.TransactionResult;
import org.core.eco.transaction.result.TransactionsResult;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface PendingTransaction {

    @NotNull List<Transaction> getRemainingTransactions();

    @NotNull Account getTarget();

    @NotNull TransactionsResult getCurrentResult();

    @NotNull CompletableFuture<TransactionResult> awaitCurrentTransaction();

    @NotNull CompletableFuture<TransactionsResult> awaitComplete();

    boolean isComplete();

    default Optional<Transaction> getCurrentTransaction() {
        List<Transaction> remaining = this.getRemainingTransactions();
        if (remaining.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(remaining.get(0));
    }

    ;

}
