package org.core.inventory.item.type;

import org.core.inventory.item.ItemType;
import org.core.utils.Guaranteed;

public class ItemTypeCommon implements Guaranteed<ItemType> {

    private String id;

    public ItemTypeCommon(String name){
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
        return first + nameLowercase.substring(1);
    }
}
