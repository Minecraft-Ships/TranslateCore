package org.core.entity;

import org.core.CorePlugin;
import org.core.entity.living.hostile.undead.classic.ClassicZombie;
import org.core.entity.living.hostile.undead.classic.ClassicZombieSnapshot;
import org.core.entity.living.human.Human;
import org.core.entity.living.human.HumanSnapshot;
import org.core.entity.living.human.player.Player;
import org.core.entity.living.human.player.PlayerSnapshot;
import org.core.utils.Guaranteed;

public class EntityTypes <T extends Entity, S extends EntitySnapshot<T>> implements Guaranteed<EntityType<T, S>> {

    public static final EntityType<ClassicZombie, ClassicZombieSnapshot> ZOMBIE = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:zombie"));
    public static final EntityType<Human, HumanSnapshot> HUMAN = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:human"));
    public static final EntityType<Player, PlayerSnapshot> PLAYER = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:player"));

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
