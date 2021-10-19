package org.core.entity;

import org.core.TranslateCore;
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
import org.core.entity.living.hostile.creeper.CreeperEntitySnapshot;
import org.core.entity.living.hostile.creeper.LiveCreeperEntity;
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
import org.core.utils.Singleton;

/**
 * All default Entity types found within Minecraft (The lowest version of minecraft Core supports)
 *
 * @param <T> The LiveEntity of the EntityType
 * @param <S> The EntitySnapshot of the EntityType
 */
public class EntityTypes<T extends LiveEntity, S extends EntitySnapshot<T>> implements Guaranteed<EntityType<T, S>> {

    public static final Singleton<EntityType<LiveClassicZombie, ClassicZombieSnapshot>> ZOMBIE = TranslateCore.getPlatform().get(new EntityTypes<>("minecraft:zombie"));
    public static final Singleton<EntityType<LiveHuman, HumanSnapshot>> HUMAN = TranslateCore.getPlatform().get(new EntityTypes<>("minecraft:human"));
    public static final Singleton<EntityType<LivePlayer, PlayerSnapshot>> PLAYER = TranslateCore.getPlatform().get(new EntityTypes<>("minecraft:player"));
    public static final Singleton<EntityType<LiveChicken, ChickenSnapshot>> CHICKEN = TranslateCore.getPlatform().get(new EntityTypes<>("minecraft:chicken"));
    public static final Singleton<EntityType<LiveCow, CowSnapshot>> COW = TranslateCore.getPlatform().get(new EntityTypes<>("minecraft:cow"));
    public static final Singleton<EntityType<LiveItemFrame, ItemFrameSnapshot>> ITEM_FRAME = TranslateCore.getPlatform().get(new EntityTypes<>("minecraft:itemframe"));
    public static final Singleton<EntityType<LiveDroppedItem, DroppedItemSnapshot>> DROPPED_ITEM = TranslateCore.getPlatform().get(new EntityTypes<>("minecraft:droppeditem"));
    public static final Singleton<EntityType<LiveCod, CodSnapshot>> COD = TranslateCore.getPlatform().get(new EntityTypes<>("minecraft:cod"));
    public static final Singleton<EntityType<LiveBat, BatSnapshot>> BAT = TranslateCore.getPlatform().get(new EntityTypes<>("minecraft:bat"));
    public static final Singleton<EntityType<LiveSnowballEntity, SnowballEntitySnapshot>> SNOWBALL = TranslateCore.getPlatform().get(new EntityTypes<>("minecraft:snowball"));
    public static final Singleton<EntityType<LiveParrot, ParrotSnapshot>> PARROT = TranslateCore.getPlatform().get(new EntityTypes<>("minecraft:parrot"));
    public static final Singleton<EntityType<LiveCreeperEntity, CreeperEntitySnapshot>> CREEPER = TranslateCore.getPlatform().get(new EntityTypes<>("minecraft:creeper"));

    private final String id;

    private EntityTypes(String id) {
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
