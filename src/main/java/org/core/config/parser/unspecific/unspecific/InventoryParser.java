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
        for(int A = 0; A < slotCount; A++){
            final int B = A;
            Slot slot = slots.stream().filter(s -> s.getPosition().isPresent()).filter(s -> s.getPosition().get() == B).findAny().get();
            slot.getItem().ifPresent(i -> {
                String[] path = new String[node.getPath().length + 1];
                for(int C = 0; C < node.getPath().length; C++){
                    path[C] = node.getPath()[C];
                }
                path[node.getPath().length] = B + "";
                UnspecificParsers.ITEM_STACK.set(file, i, path);
            });
        }
    }

    @Override
    public Optional<InventorySnapshot> parse(ConfigurationStream file, ConfigurationNode node) {
        UnknownInventorySnapshot inv = new UnknownInventorySnapshot();
        file.getChildren(node).forEach(i -> {
            String[] totalPath = i.getPath();
            try{
                int slotIndex = Integer.parseInt(totalPath[totalPath.length - 1]);
                Optional<ItemStack> opStack = UnspecificParsers.ITEM_STACK.parse(file, i);
                if(!opStack.isPresent()){
                    return;
                }
                SlotSnapshot snapshot = new SlotSnapshot(slotIndex, opStack.get());
                inv.getSlots().add(snapshot);
            }catch (NumberFormatException ignore){
            }
        });
        if(inv.getSlots().isEmpty()){
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
