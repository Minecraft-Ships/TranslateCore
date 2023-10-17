package org.core.inventory.item.stack;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.core.adventureText.AText;
import org.core.adventureText.adventure.AdventureText;
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
     * @deprecated use {@link ItemStack#getLore} instead
     */
    @Deprecated(forRemoval = true)
    default List<AText> getLoreText() {
        return this.getLore().stream().map(AdventureText::new).collect(Collectors.toList());
    }


    /**
     * Gets the lore of the item
     *
     * @return The lore of the item
     */
    List<Component> getLore();

    /**
     * Sets the lore of the item
     *
     * @param lore The new lore to be
     * @return itself for chaining
     * @deprecated use {@link ItemStack#setLore} instead
     */
    @Deprecated(forRemoval = true)
    default ItemStack setLoreText(Collection<? extends AText> lore) {
        return setLore(lore.stream().map(line -> line.asComponent()).collect(Collectors.toList()));
    }

    /**
     * Sets the lore of the item
     */
    ItemStack setLore(Collection<? extends Component> lore);

    /**
     * Sets the lore of the item via varargs
     *
     * @param text The text to set
     * @return itself for chaining
     * @deprecated use {@link ItemStack#setLore} instead
     */
    default ItemStack setLoreText(AText... text) {
        return this.setLoreText(Arrays.asList(text));
    }

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
