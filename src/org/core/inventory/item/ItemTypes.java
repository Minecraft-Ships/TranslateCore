package org.core.inventory.item;

import org.core.CorePlugin;
import org.core.utils.Guaranteed;

public class ItemTypes implements Guaranteed<ItemType> {

    public static final ItemType AIR = CorePlugin.getPlatform().get(new ItemTypes("minecraft:air"));

    private String id;

    private ItemTypes(String name){
        this.id = name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        String nameLowercase = getId().split(":")[1];
        char first = Character.toUpperCase(nameLowercase.charAt(0));
        return first + nameLowercase.substring(1, nameLowercase.length());
    }
}
