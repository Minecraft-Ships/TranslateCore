package org.core.eco.transaction;

import org.core.eco.account.Account;
import org.core.eco.transaction.pending.PendingTransaction;

import java.util.Collection;
import java.util.function.BiFunction;

public class SecureTransaction {

    private Account target;
    private Account other;
    private BiFunction<Account, Account, Collection<PendingTransaction>> transactions;

    public SecureTransaction(Account target,
                             Account other,
                             BiFunction<Account, Account, Collection<PendingTransaction>> transactions) {
        this.target = target;
        this.other = other;
        this.transactions = transactions;
    }

    public PendingTransaction run() {

    }
}
