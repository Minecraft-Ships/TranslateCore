package org.core.platform;

import org.core.configuration.type.ConfigurationLoaderType;
import org.core.configuration.type.ConfigurationLoaderTypes;
import org.core.entity.*;
import org.core.entity.living.animal.parrot.ParrotType;
import org.core.entity.living.animal.parrot.ParrotTypes;
import org.core.event.CustomEvent;
import org.core.inventory.item.ItemType;
import org.core.inventory.item.data.dye.DyeType;
import org.core.inventory.item.data.dye.DyeTypes;
import org.core.inventory.item.type.ItemTypeCommon;
import org.core.text.TextColour;
import org.core.text.TextColours;
import org.core.world.boss.colour.BossColour;
import org.core.world.boss.colour.BossColours;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.entity.TileEntity;
import org.core.world.position.block.entity.TileEntitySnapshot;
import org.core.world.position.block.entity.banner.pattern.PatternLayerType;
import org.core.world.position.block.entity.banner.pattern.PatternLayerTypes;
import org.core.world.position.block.grouptype.BlockGroup;
import org.core.world.position.flags.physics.ApplyPhysicsFlag;
import org.core.world.position.flags.physics.ApplyPhysicsFlags;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface Platform {

    BossColour get(BossColours colours);
    ApplyPhysicsFlag get(ApplyPhysicsFlags flags);
    ItemType get(ItemTypeCommon itemId);
    ParrotType get(ParrotTypes parrotID);
    TextColour get(TextColours id);
    DyeType get(DyeTypes id);
    PatternLayerType get(PatternLayerTypes id);
    ConfigurationLoaderType get(ConfigurationLoaderTypes id);
    <E extends LiveEntity, S extends EntitySnapshot<E>> EntityType<E, S> get(EntityTypes<E, S> entityId);

    Optional<EntityType<? extends Entity, ? extends EntitySnapshot<? extends Entity>>> getEntityType(String id);
    Optional<BlockType> getBlockType(String id);
    Optional<ItemType> getItemType(String id);
    Optional<TextColour> getTextColour(String id);
    Optional<DyeType> getDyeType(String id);
    Optional<PatternLayerType> getPatternLayerType(String id);
    Optional<ConfigurationLoaderType> getConfigurationLoaderType(String id);
    Optional<BossColour> getBossColour(String id);
    Optional<ParrotType> getParrotType(String id);
    Optional<ApplyPhysicsFlag> getApplyPhysics(String id);

    Collection<EntityType<? extends Entity, ? extends EntitySnapshot<? extends Entity>>> getEntityTypes();
    Collection<BlockType> getBlockTypes();
    Collection<ItemType> getItemTypes();
    Collection<TextColour> getTextColours();
    Collection<DyeType> getDyeTypes();
    Collection<PatternLayerType> getPatternLayerTypes();
    Collection<ConfigurationLoaderType> getConfigurationLoaderTypes();
    Collection<BlockGroup> getBlockGroups();
    Collection<BossColour> getBossColours();
    Collection<ParrotType> getParrotType();
    Collection<ApplyPhysicsFlag> getApplyPhysics();

    Collection<TileEntitySnapshot<? extends TileEntity>> getDefaultTileEntities();
    int[] getMinecraftVersion();
    Set<Plugin> getPlugins();
    <E extends CustomEvent> E callEvent(E event);

    default Optional<BlockGroup> getBlockGroup(String id){
        return getBlockGroups().stream().filter(g -> g.getId().equals(id)).findFirst();
    }

    default Optional<Plugin> getPlugin(String name){
        return getPlugins().stream().filter(p -> p.getPluginName().equals(name)).findAny();
    }

    default Optional<TileEntitySnapshot<? extends TileEntity>> getDefaultTileEntity(BlockType type){
        return getDefaultTileEntities().stream().filter(t -> t.getSupportedBlocks().stream().anyMatch(ty -> ty.equals(type))).findFirst();
    }

}
