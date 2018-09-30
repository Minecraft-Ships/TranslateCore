package org.core.inventory.item;

import org.core.utils.Guaranteed;

public class ItemTypes implements Guaranteed<ItemType> {

    String id;

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
