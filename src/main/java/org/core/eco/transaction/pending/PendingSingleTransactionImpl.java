package org.core.eco.transaction.pending;

import org.core.eco.account.Account;
import org.core.eco.transaction.Transaction;
import org.core.eco.transaction.result.TransactionResult;
import org.core.eco.transaction.result.TransactionsResult;
import org.core.eco.transaction.result.impl.TransactionsResultImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PendingSingleTransactionImpl implements PendingSingleTransaction {

    private final Account account;
    private final Transaction transaction;
    private final List<TransactionResult> result = new ArrayList<>();
    private final CompletableFuture<TransactionResult> future;

    public PendingSingleTransactionImpl(Account account,
                                        Transaction transaction,
                                        CompletableFuture<TransactionResult> future) {
        this.future = future.thenApply(result -> {
            this.result.add(result);
            return result;
        });
        this.transaction = transaction;
        this.account = account;
    }


    @Override
    public @NotNull Transaction getTransaction() {
        return this.transaction;
    }

    @Override
    public @NotNull Account getTarget() {
        return this.account;
    }

    @Override
    public @NotNull TransactionsResult getCurrentResult() {
        return new TransactionsResultImpl(this.result);
    }

    @Override
    public @NotNull CompletableFuture<TransactionResult> awaitCurrentTransaction() {
        return this.future;
    }

    @Override
    public @NotNull CompletableFuture<TransactionsResult> awaitComplete() {
        return this.awaitCurrentTransaction().thenApply(t -> this.getCurrentResult());
    }

    @Override
    public boolean isComplete() {
        return !this.result.isEmpty();
    }
}
