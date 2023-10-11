package org.core.eco.transaction.pending;

import org.core.eco.transaction.Transaction;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public interface PendingSingleTransaction extends PendingTransaction {

    @NotNull Transaction getTransaction();

    @Override
    @Deprecated
    default @NotNull List<Transaction> getRemainingTransactions() {
        if (this.isComplete()) {
            return Collections.emptyList();
        }
        return Collections.singletonList(this.getTransaction());
    }
}
