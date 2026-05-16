package org.core.inventory.item.stack;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.core.inventory.item.ItemType;
import org.core.inventory.item.stack.data.ItemStackData;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    List<Component> getLore();

    /**
     * Sets the lore of the item
     */
    ItemStack setLore(Collection<? extends Component> lore);

    default ItemStack setLore(Component... lines) {
        return this.setLore(Arrays.asList(lines));
    }

    default ItemStack setLore(ComponentLike... lines) {
        return this.setLore(Arrays.stream(lines).map(ComponentLike::asComponent).collect(Collectors.toList()));
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
