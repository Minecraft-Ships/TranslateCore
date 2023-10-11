package org.core.eco.transaction.pending;

import org.core.eco.account.Account;
import org.core.eco.transaction.Transaction;
import org.core.eco.transaction.result.TransactionResult;
import org.core.eco.transaction.result.TransactionsResult;
import org.core.eco.transaction.result.impl.TransactionsResultImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class PendingTransactionsImpl implements PendingTransaction {

    private final List<PendingTransaction> transactions;

    public PendingTransactionsImpl(PendingTransaction... array) {
        this(Arrays.asList(array));
    }

    public PendingTransactionsImpl(Collection<PendingTransaction> collection) {
        this.transactions = new ArrayList<>(collection);
    }

    @Override
    public @NotNull List<Transaction> getRemainingTransactions() {
        return this.transactions
                .stream()
                .filter(transaction -> !transaction.isComplete())
                .map(transaction -> transaction
                        .getCurrentTransaction()
                        .orElseThrow(() -> new RuntimeException("not completed transaction but no remaining?")))
                .collect(Collectors.toList());
    }

    @Override
    public @NotNull Account getTarget() {
        return this.transactions
                .stream()
                .map(PendingTransaction::getTarget)
                .findAny()
                .orElseThrow(() -> new RuntimeException("No transactions found"));
    }

    @Override
    public @NotNull TransactionsResult getCurrentResult() {
        return new TransactionsResultImpl(this.transactions
                                                  .stream()
                                                  .flatMap(pending -> pending
                                                          .getCurrentResult()
                                                          .getTransactions()
                                                          .stream())
                                                  .toList());
    }

    @Override
    public @NotNull CompletableFuture<TransactionResult> awaitCurrentTransaction() {
        return this.transactions
                .stream()
                .filter(pending -> !pending.isComplete())
                .findFirst()
                .map(PendingTransaction::awaitCurrentTransaction)
                .orElseGet(() -> this.transactions.get(this.transactions.size() - 1).awaitCurrentTransaction());
    }

    @Override
    public @NotNull CompletableFuture<TransactionsResult> awaitComplete() {
        return this.transactions
                .stream()
                .filter(pending -> !pending.isComplete())
                .findFirst()
                .map(PendingTransaction::awaitComplete)
                .orElseGet(() -> this.transactions.get(this.transactions.size() - 1).awaitComplete());
    }

    @Override
    public boolean isComplete() {
        return this.transactions.stream().allMatch(PendingTransaction::isComplete);
    }
}
