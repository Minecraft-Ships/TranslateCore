package org.core.source.eco;

import org.core.source.Source;

import java.math.BigDecimal;

public interface EcoSource extends Source {

    BigDecimal getBalance();

    void setBalance(BigDecimal decimal);

    default void setBalance(double amount) {
        this.setBalance(new BigDecimal(amount));
    }

    default void addBalance(BigDecimal decimal) {
        this.setBalance(decimal.add(this.getBalance()));
    }

    default void addBalance(double amount) {
        this.addBalance(new BigDecimal(amount));
    }

    default void removeBalance(BigDecimal decimal) {
        BigDecimal bal = this.getBalance();
        if (bal.doubleValue() < decimal.doubleValue()) {
            throw new IllegalStateException("Costs " + decimal.doubleValue() + ", you don't have enough. You have " +
                    this.getBalance().doubleValue());
        }
        this.setBalance(bal.subtract(decimal));
    }

    default void removeBalance(double amount) {
        this.removeBalance(new BigDecimal(amount));
    }
}
