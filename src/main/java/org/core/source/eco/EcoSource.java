package org.core.source.eco;

import net.kyori.adventure.text.serializer.plain.PlainComponentSerializer;
import org.core.TranslateCore;
import org.core.eco.Currency;
import org.core.source.Source;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public interface EcoSource extends Source {

    BigDecimal getBalance(@NotNull Currency currency);

    default BigDecimal getBalance() {
        return this.getBalance(TranslateCore.getCurrencyManager().getDefaultCurrency());
    }

    default void setBalance(@NotNull BigDecimal decimal) {
        this.setBalance(TranslateCore.getCurrencyManager().getDefaultCurrency(), decimal);
    }

    default void setBalance(@NotNull Number amount) {
        this.setBalance(TranslateCore.getCurrencyManager().getDefaultCurrency(), amount);
    }

    void setBalance(@NotNull Currency currency, @NotNull BigDecimal decimal);

    default void setBalance(@NotNull Currency currency, Number amount) {
        this.setBalance(currency, BigDecimal.valueOf(amount.doubleValue()));

    }

    default void addBalance(@NotNull BigDecimal decimal) {
        this.addBalance(TranslateCore.getCurrencyManager().getDefaultCurrency(), decimal);
    }

    default void addBalance(@NotNull Currency currency, @NotNull BigDecimal decimal) {
        this.setBalance(currency, decimal.add(this.getBalance(currency)));
    }

    default void addBalance(@NotNull Currency currency, @NotNull Number amount) {
        this.addBalance(currency, BigDecimal.valueOf(amount.doubleValue()));
    }

    default void addBalance(@NotNull Number amount) {
        this.addBalance(TranslateCore.getCurrencyManager().getDefaultCurrency(), amount);
    }

    default void removeBalance(@NotNull Currency currency, @NotNull BigDecimal decimal) {
        BigDecimal bal = this.getBalance(currency);
        if (bal.compareTo(decimal) < 0) {
            throw new IllegalStateException(
                    "Costs " + PlainComponentSerializer.plain().serialize(currency.asDisplay(decimal))
                            + ", you don't have enough. You have " + PlainComponentSerializer
                            .plain()
                            .serialize(currency.asDisplay(this.getBalance())));
        }
        this.setBalance(bal.subtract(decimal));
    }

    default void removeBalance(@NotNull BigDecimal decimal) {
        this.removeBalance(TranslateCore.getCurrencyManager().getDefaultCurrency(), decimal);
    }

    default void removeBalance(@NotNull Currency currency, @NotNull Number amount) {
        this.removeBalance(currency, BigDecimal.valueOf(amount.doubleValue()));
    }

    default void removeBalance(@NotNull Number amount) {
        this.removeBalance(BigDecimal.valueOf(amount.doubleValue()));
    }
}
