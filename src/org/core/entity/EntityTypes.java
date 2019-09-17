package org.core.entity;

import org.core.CorePlugin;
import org.core.entity.living.animal.chicken.ChickenSnapshot;
import org.core.entity.living.animal.chicken.LiveChicken;
import org.core.entity.living.animal.cow.CowSnapshot;
import org.core.entity.living.animal.cow.LiveCow;
import org.core.entity.living.animal.parrot.LiveParrot;
import org.core.entity.living.animal.parrot.ParrotSnapshot;
import org.core.entity.living.bat.BatSnapshot;
import org.core.entity.living.bat.LiveBat;
import org.core.entity.living.fish.cod.CodSnapshot;
import org.core.entity.living.fish.cod.LiveCod;
import org.core.entity.living.hostile.undead.classic.ClassicZombieSnapshot;
import org.core.entity.living.hostile.undead.classic.LiveClassicZombie;
import org.core.entity.living.human.HumanSnapshot;
import org.core.entity.living.human.LiveHuman;
import org.core.entity.living.human.player.LivePlayer;
import org.core.entity.living.human.player.PlayerSnapshot;
import org.core.entity.projectile.item.snowball.LiveSnowballEntity;
import org.core.entity.projectile.item.snowball.SnowballEntitySnapshot;
import org.core.entity.scene.droppeditem.DroppedItemSnapshot;
import org.core.entity.scene.droppeditem.LiveDroppedItem;
import org.core.entity.scene.itemframe.ItemFrameSnapshot;
import org.core.entity.scene.itemframe.LiveItemFrame;
import org.core.utils.Guaranteed;

public class EntityTypes <T extends LiveEntity, S extends EntitySnapshot<T>> implements Guaranteed<EntityType<T, S>> {

    public static final EntityType<LiveClassicZombie, ClassicZombieSnapshot> ZOMBIE = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:zombie"));
    public static final EntityType<LiveHuman, HumanSnapshot> HUMAN = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:human"));
    public static final EntityType<LivePlayer, PlayerSnapshot> PLAYER = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:player"));
    public static final EntityType<LiveChicken, ChickenSnapshot> CHICKEN = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:chicken"));
    public static final EntityType<LiveCow, CowSnapshot> COW = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:cow"));
    public static final EntityType<LiveItemFrame, ItemFrameSnapshot> ITEM_FRAME = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:itemframe"));
    public static final EntityType<LiveDroppedItem, DroppedItemSnapshot> DROPPED_ITEM = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:droppeditem"));
    public static final EntityType<LiveCod, CodSnapshot> COD = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:cod"));
    public static final EntityType<LiveBat, BatSnapshot> BAT = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:bat"));
    public static final EntityType<LiveSnowballEntity, SnowballEntitySnapshot> SNOWBALL = CorePlugin.getPlatform().get(new EntityTypes<>("minecraft:snowball"));
    public static final EntityType<LiveParrot, ParrotSnapshot> PARROT = CorePlugin.getPlatform().get(new EntityTypes("minecraft:parrot"));

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
