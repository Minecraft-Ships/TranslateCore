package org.core.eco.transaction.result;

import org.core.eco.transaction.Transaction;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Optional;

public interface TransactionResult {

    @NotNull Transaction getTransaction();

    boolean wasSuccessful();

    @NotNull BigDecimal getOriginalAmount();

    @NotNull BigDecimal getAfterAmount();

    Optional<String> getFailedReason();

}
