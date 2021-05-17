package org.core.inventory.item.stack;

import org.core.adventureText.AText;
import org.core.inventory.item.ItemType;
import org.core.text.Text;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public interface ItemStack {

    ItemType getType();

    int getQuantity();

    @Deprecated
    List<Text> getLore();

    List<AText> getLoreText();

    @Deprecated
    ItemStack setLore(Collection<Text> lore);

    ItemStack setLoreText(Collection<AText> lore);

    ItemStack copy();

    ItemStack copyWithQuantity(int quantity);

    ItemStackSnapshot createSnapshot();

    @Deprecated
    default ItemStack setLore(Text... text) {
        return this.setLore(Arrays.asList(text));
    }

    default ItemStack setLoreText(AText... text) {
        return this.setLoreText(Arrays.asList(text));
    }
}
