package org.core.entity;

import org.core.CorePlugin;
import org.core.entity.living.animal.chicken.Chicken;
import org.core.entity.living.animal.chicken.ChickenSnapshot;
import org.core.entity.living.animal.cow.Cow;
import org.core.entity.living.animal.cow.CowSnapshot;
import org.core.entity.living.bat.Bat;
import org.core.entity.living.bat.BatSnapshot;
import org.core.entity.living.fish.cod.Cod;
import org.core.entity.living.fish.cod.CodSnapshot;
import org.core.entity.living.hostile.undead.classic.ClassicZombie;
import org.core.entity.living.hostile.undead.classic.ClassicZombieSnapshot;
import org.core.entity.living.human.Human;
import org.core.entity.living.human.HumanSnapshot;
import org.core.entity.living.human.player.Player;
import org.core.entity.living.human.player.PlayerSnapshot;
import org.core.entity.projectile.item.snowball.SnowballEntity;
import org.core.entity.projectile.item.snowball.SnowballEntitySnapshot;
import org.core.entity.scene.droppeditem.DroppedItem;
import org.core.entity.scene.droppeditem.DroppedItemSnapshot;
import org.core.entity.scene.itemframe.ItemFrame;
import org.core.entity.scene.itemframe.ItemFrameSnapshot;
import org.core.utils.Guaranteed;

public class EntityTypes <T extends Entity, S extends EntitySnapshot<T>> implements Guaranteed<EntityType<T, S>> {

    public static final EntityType<ClassicZombie, ClassicZombieSnapshot> ZOMBIE = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:zombie"));
    public static final EntityType<Human, HumanSnapshot> HUMAN = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:human"));
    public static final EntityType<Player, PlayerSnapshot> PLAYER = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:player"));
    public static final EntityType<Chicken, ChickenSnapshot> CHICKEN = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:chicken"));
    public static final EntityType<Cow, CowSnapshot> COW = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:cow"));
    public static final EntityType<ItemFrame, ItemFrameSnapshot> ITEM_FRAME = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:itemframe"));
    public static final EntityType<DroppedItem, DroppedItemSnapshot> DROPPED_ITEM = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:droppeditem"));
    public static final EntityType<Cod, CodSnapshot> COD = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:cod"));
    public static final EntityType<Bat, BatSnapshot> BAT = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:bat"));
    public static final EntityType<SnowballEntity, SnowballEntitySnapshot> SNOWBALL = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:snowball"));

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
        return first + nameLowercase.substring(1);
    }
}
