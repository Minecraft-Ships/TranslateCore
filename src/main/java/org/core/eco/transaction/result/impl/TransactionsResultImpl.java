package org.core.eco.transaction.result.impl;

import org.core.eco.transaction.result.TransactionResult;
import org.core.eco.transaction.result.TransactionsResult;

import java.util.List;

public class TransactionsResultImpl implements TransactionsResult {

    private final List<TransactionResult> results;

    public TransactionsResultImpl(List<TransactionResult> results) {
        this.results = results;
    }

    @Override
    public List<TransactionResult> getTransactions() {
        return this.results;
    }
}
