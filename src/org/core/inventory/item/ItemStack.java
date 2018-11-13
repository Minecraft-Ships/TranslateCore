package org.core.inventory.item;

public interface ItemStack {

    public ItemType getType();
    public int getQuantity();
    public ItemStack copy();
}
