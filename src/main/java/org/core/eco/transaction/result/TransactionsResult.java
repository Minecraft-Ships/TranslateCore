package org.core.eco.transaction.result;

import java.util.List;

public interface TransactionsResult {

    default boolean wasSuccessful() {
        return getTransactions().stream().allMatch(TransactionResult::wasSuccessful);
    }

    List<TransactionResult> getTransactions();

}
