package org.core.eco.transaction.result.impl;

import org.core.eco.transaction.Transaction;
import org.core.eco.transaction.result.TransactionResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.util.Optional;

public class TransactionResultImpl implements TransactionResult {

    private final Transaction transaction;
    private final BigDecimal originalAmount;
    private final BigDecimal afterAmount;
    private @Nullable String errorMessage;

    public TransactionResultImpl(@NotNull Transaction transaction,
                                 @NotNull BigDecimal original,
                                 @NotNull String errorMessage) {
        this.transaction = transaction;
        this.originalAmount = original;
        this.errorMessage = errorMessage;
        this.afterAmount = original;
    }

    public TransactionResultImpl(@NotNull Transaction transaction, BigDecimal original, @NotNull BigDecimal after) {
        this.transaction = transaction;
        this.originalAmount = original;
        this.afterAmount = after;
    }

    @Override
    public @NotNull Transaction getTransaction() {
        return this.transaction;
    }

    @Override
    public boolean wasSuccessful() {
        return this.errorMessage == null;
    }

    @Override
    public @NotNull BigDecimal getOriginalAmount() {
        return this.originalAmount;
    }

    @Override
    public @NotNull BigDecimal getAfterAmount() {
        return this.afterAmount;
    }

    @Override
    public Optional<String> getFailedReason() {
        return Optional.ofNullable(this.errorMessage);
    }
}
