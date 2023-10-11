package org.core.eco.transaction;

import org.core.eco.account.Account;
import org.core.eco.account.AccountSnapshot;
import org.core.eco.transaction.pending.PendingTransaction;
import org.core.eco.transaction.pending.PendingTransactionsImpl;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class SecureTransaction {

    private final Account target;
    private final Account other;
    private final BiFunction<Account, Account, Collection<PendingTransaction>> transactions;

    public SecureTransaction(Account target,
                             Account other,
                             BiFunction<Account, Account, Collection<PendingTransaction>> transactions) {
        this.target = target;
        this.other = other;
        this.transactions = transactions;
    }

    public CompletableFuture<PendingTransaction> run() {
        Account targetSnapshot = new AccountSnapshot(this.target);
        Account otherSnapshot = new AccountSnapshot(this.other);

        Collection<PendingTransaction> pending = this.transactions.apply(targetSnapshot, otherSnapshot);
        PendingTransaction pendingSnapshot = new PendingTransactionsImpl(pending);
        return pendingSnapshot.awaitComplete().thenApply(result -> {
            if (result.wasSuccessful()) {
                Collection<PendingTransaction> pendingResult = this.transactions.apply(this.target, this.other);
                return new PendingTransactionsImpl(pendingResult);
            }
            return pendingSnapshot;
        });
    }
}
