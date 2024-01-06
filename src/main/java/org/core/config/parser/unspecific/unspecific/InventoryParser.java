package org.core.config.parser.unspecific.unspecific;

import org.core.TranslateCore;
import org.core.config.ConfigurationNode;
import org.core.config.ConfigurationStream;
import org.core.config.parser.unspecific.UnspecificParser;
import org.core.config.parser.unspecific.UnspecificParsers;
import org.core.inventory.InventorySnapshot;
import org.core.inventory.inventories.snapshots.UnknownInventorySnapshot;
import org.core.inventory.item.stack.ItemStack;
import org.core.inventory.parts.Slot;
import org.core.inventory.parts.snapshot.SlotSnapshot;

import java.util.Optional;
import java.util.Set;

@Deprecated
public class InventoryParser implements UnspecificParser<InventorySnapshot> {

    @Override
    public void set(ConfigurationStream file, InventorySnapshot value, ConfigurationNode node) {
        int slotCount = value.getSlotCount();
        Set<Slot> slots = value.getSlots();
        for (int index = 0; index < slotCount; index++) {
            final int finalIndex = index;
            Slot slot = slots
                    .stream()
                    .filter(s -> s.getPosition().isPresent())
                    .filter(s -> s.getPosition().orElseThrow(() -> new IllegalStateException("You broke logic"))
                            == finalIndex)
                    .findAny()
                    .orElseThrow(() -> new IllegalStateException("Cannot find slot with index of " + finalIndex));
            slot.getItem().ifPresent(i -> {
                String[] path = new String[node.getPath().length + 1];
                for (int pathIndex = 0; pathIndex < node.getPath().length; pathIndex++) {
                    path[pathIndex] = node.getPath()[pathIndex];
                }
                path[node.getPath().length] = finalIndex + "";
                UnspecificParsers.ITEM_STACK.set(file, i, path);
            });
        }
    }

    @Override
    public Optional<InventorySnapshot> parse(ConfigurationStream file, ConfigurationNode node) {
        InventorySnapshot inv = new UnknownInventorySnapshot();
        file.getChildren(node).forEach(i -> {
            String[] totalPath = i.getPath();
            try {
                int slotIndex = Integer.parseInt(totalPath[totalPath.length - 1]);
                Optional<ItemStack> opStack = UnspecificParsers.ITEM_STACK.parse(file, i);
                if (opStack.isEmpty()) {
                    return;
                }
                Slot snapshot = new SlotSnapshot(slotIndex, opStack.get());
                inv.getSlots().add(snapshot);
            } catch (NumberFormatException ignore) {
            }
        });
        if (inv.getSlots().isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(inv);
    }

    @Override
    public String getId() {
        return "coreto" + TranslateCore.getPlatform().getDetails().getIdName() + ":inventory";
    }

    @Override
    public String getName() {
        return "Inventory";
    }
}
