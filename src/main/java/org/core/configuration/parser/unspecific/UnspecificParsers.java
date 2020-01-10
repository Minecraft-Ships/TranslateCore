package org.core.configuration.parser.unspecific;

import org.core.CorePlugin;
import org.core.inventory.Inventory;
import org.core.inventory.item.stack.ItemStack;
import org.core.utils.Guaranteed;

@Deprecated
public class UnspecificParsers<T> implements Guaranteed<UnspecificParser<T>> {

    public static final UnspecificParser<ItemStack> ITEM_STACK = CorePlugin.getPlatform().get(new UnspecificParsers<>("coreto" + CorePlugin.getPlatform().getDetails().getIdName() + ":itemstack", "ItemStack"));
    public static final UnspecificParser<Inventory> INVENTORY = CorePlugin.getPlatform().get(new UnspecificParsers<>("coreto" + CorePlugin.getPlatform().getDetails().getIdName() + ":inventory", "Inventory"));

    private String name;
    private String idName;

    private UnspecificParsers(String idName, String name){
        this.name = name;
        this.idName = idName;
    }

    @Override
    public String getId() {
        return this.idName;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
