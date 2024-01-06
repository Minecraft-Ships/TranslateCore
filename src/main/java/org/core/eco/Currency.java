package org.core.eco;

import net.kyori.adventure.text.Component;
import org.core.utils.ComponentUtils;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public interface Currency {

    @NotNull Component getDisplayName();

    boolean isDefault();

    @NotNull Component getSymbol();

    default String getUnformattedSymbol() {
        return ComponentUtils.toPlain(this.getSymbol());
    }

    default Component asDisplay(@NotNull BigDecimal amount) {
        return this.getSymbol().append(Component.text(amount.toPlainString()));
    }

    default Component asDisplay(@NotNull Number amount) {
        return this.asDisplay(BigDecimal.valueOf(amount.doubleValue()));
    }

}
