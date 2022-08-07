package org.core.inventory.item.stack;

import org.core.adventureText.AText;
import org.core.inventory.item.ItemType;
import org.core.inventory.item.stack.data.ItemStackData;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ItemStack {

    /**
     * Gets the type of item of this itemStack
     *
     * @return The itemType of this itemStack
     */
    @NotNull ItemType getType();

    /**
     * Gets the amount of items within this stack
     *
     * @return The amount of items in this itemstack
     */
    int getQuantity();

    /**
     * Gets the lore of the item
     *
     * @return The lore of the item
     */
    List<AText> getLoreText();

    /**
     * Sets the lore of the item
     *
     * @param lore The new lore to be
     * @return itself for chaining
     */
    ItemStack setLoreText(Collection<? extends AText> lore);

    /**
     * Sets the lore of the item via varargs
     *
     * @param text The text to set
     * @return itself for chaining
     */
    default ItemStack setLoreText(AText... text) {
        return this.setLoreText(Arrays.asList(text));
    }

    /**
     * Copies this ItemStack
     *
     * @return The copied itemstack
     */
    ItemStack copy();

    /**
     * Copies this ItemStack with a specified quantity
     *
     * @param quantity The new size
     * @return The copied itemstack
     */
    ItemStack copyWithQuantity(int quantity);

    /**
     * Gets the ItemStackData of this item.
     *
     * @return The ItemStackData if there is one
     */
    Optional<ItemStackData> getStackData();

    /**
     * Sets the itemStackData of this item
     *
     * @param data The new ItemStackData
     * @throws IllegalArgumentException When the
     */
    void setStackData(ItemStackData data);

    /**
     * Creates a snapshot of this item
     *
     * @return The created ItemStack Snapshot
     */
    ItemStackSnapshot createSnapshot();
}
