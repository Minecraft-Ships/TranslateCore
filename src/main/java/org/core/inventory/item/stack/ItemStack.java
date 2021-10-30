package org.core.inventory.item.stack;

import org.core.adventureText.AText;
import org.core.inventory.item.ItemType;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public interface ItemStack {

    ItemType getType();

    int getQuantity();

    List<AText> getLoreText();

    ItemStack setLoreText(Collection<? extends AText> lore);

    ItemStack copy();

    ItemStack copyWithQuantity(int quantity);

    ItemStackSnapshot createSnapshot();

    default ItemStack setLoreText(AText... text) {
        return this.setLoreText(Arrays.asList(text));
    }
}
