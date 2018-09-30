package org.core.entity;

import org.core.CorePlugin;
import org.core.entity.living.hostile.undead.Zombie;
import org.core.utils.Guaranteed;

public class EntityTypes <T extends Entity> implements Guaranteed<EntityType<T>> {

    public static final EntityType<Zombie> ZOMBIE = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:zombie"));

    private String id;

    private EntityTypes(String id){
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
        return first + nameLowercase.substring(1, nameLowercase.length());
    }
}
