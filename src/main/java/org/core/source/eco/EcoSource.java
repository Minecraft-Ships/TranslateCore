package org.core.source.eco;

import org.core.source.Source;

import java.math.BigDecimal;

public interface EcoSource extends Source {

    BigDecimal getBalance();
    void setBalance(BigDecimal decimal);

    default void setBalance(double amount){
        setBalance(new BigDecimal(amount));
    }

    default void addBalance(BigDecimal decimal){
        setBalance(decimal.add(getBalance()));
    }

    default void addBalance(double amount){
        addBalance(new BigDecimal(amount));
    }

    default boolean removeBalance(BigDecimal decimal){
        if(getBalance().doubleValue() < decimal.doubleValue()){
            return false;
        }
        setBalance(getBalance().subtract(decimal));
        return true;
    }

    default boolean removeBalance(double amount){
        return removeBalance(new BigDecimal(amount));
    }
}
