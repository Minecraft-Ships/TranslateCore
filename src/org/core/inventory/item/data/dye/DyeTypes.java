package org.core.inventory.item.data.dye;

import org.core.utils.Guaranteed;

public class DyeTypes implements Guaranteed<DyeType> {



    private String id;

    public DyeTypes(String id){
        this.id = id;
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
