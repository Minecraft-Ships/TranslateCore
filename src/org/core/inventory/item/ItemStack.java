package org.core.inventory.item;

public interface ItemStack {

    ItemType getType();
    int getQuantity();
    ItemStack copy();
    ItemStack copyWithQuantity(int quantity);
}
