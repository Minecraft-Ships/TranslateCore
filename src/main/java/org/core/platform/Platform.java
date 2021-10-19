package org.core.platform;

import org.core.config.ConfigurationFormat;
import org.core.config.parser.unspecific.UnspecificParser;
import org.core.config.parser.unspecific.UnspecificParsers;
import org.core.entity.EntitySnapshot;
import org.core.entity.EntityType;
import org.core.entity.EntityTypes;
import org.core.entity.LiveEntity;
import org.core.entity.living.animal.parrot.ParrotType;
import org.core.entity.living.animal.parrot.ParrotTypes;
import org.core.event.CustomEvent;
import org.core.inventory.item.ItemType;
import org.core.inventory.item.data.dye.DyeType;
import org.core.inventory.item.data.dye.DyeTypes;
import org.core.inventory.item.type.ItemTypeCommon;
import org.core.permission.Permission;
import org.core.platform.plugin.Plugin;
import org.core.platform.plugin.details.CorePluginVersion;
import org.core.text.TextColour;
import org.core.text.TextColours;
import org.core.utils.Singleton;
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
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface Platform {

    @NotNull Singleton<BossColour> get(BossColours colours);

    @NotNull Singleton<ApplyPhysicsFlag> get(ApplyPhysicsFlags flags);

    @NotNull Singleton<ItemType> get(ItemTypeCommon itemId);

    @NotNull Singleton<ParrotType> get(ParrotTypes parrotID);

    @Deprecated
    <T> UnspecificParser<T> get(UnspecificParsers<T> itemStack);

    @Deprecated
    @NotNull TextColour get(TextColours id);

    @NotNull Singleton<DyeType> get(DyeTypes id);

    @NotNull Singleton<PatternLayerType> get(PatternLayerTypes id);

    @NotNull <E extends LiveEntity, S extends EntitySnapshot<E>> Singleton<EntityType<E, S>> get(EntityTypes<E, S> entityId);

    <E extends LiveEntity> Optional<EntityType<E, ? extends EntitySnapshot<E>>> getEntityType(String id);

    Optional<BlockType> getBlockType(String id);

    Optional<ItemType> getItemType(String id);

    @Deprecated
    Optional<TextColour> getTextColour(String id);

    Optional<DyeType> getDyeType(String id);

    Optional<PatternLayerType> getPatternLayerType(String id);

    Optional<BossColour> getBossColour(String id);

    Optional<ParrotType> getParrotType(String id);

    Optional<ApplyPhysicsFlag> getApplyPhysics(String id);

    @Deprecated
    Optional<UnspecificParser<?>> getUnspecifiedParser(String id);

    Collection<EntityType<? extends LiveEntity, ? extends EntitySnapshot<? extends LiveEntity>>> getEntityTypes();

    Collection<BlockType> getBlockTypes();

    Collection<ItemType> getItemTypes();

    @Deprecated
    Collection<TextColour> getTextColours();

    Collection<DyeType> getDyeTypes();

    Collection<PatternLayerType> getPatternLayerTypes();

    Collection<BlockGroup> getBlockGroups();

    Collection<BossColour> getBossColours();

    Collection<ParrotType> getParrotType();

    Collection<ApplyPhysicsFlag> getApplyPhysics();

    Collection<Permission> getPermissions();

    @NotNull Permission register(@NotNull String permissionNode);

    @Deprecated
    Collection<UnspecificParser<?>> getUnspecifiedParsers();

    Collection<TileEntitySnapshot<? extends TileEntity>> getDefaultTileEntities();

    CorePluginVersion getMinecraftVersion();

    @NotNull PlatformDetails getDetails();

    @NotNull ConfigurationFormat getConfigFormat();

    Set<Plugin> getPlugins();

    File getPlatformPluginsFolder();

    File getPlatformConfigFolder();

    default File getTranslatePluginsFolder() {
        return new File("Translate/Plugins");
    }

    default File getTranslateConfigFolder() {
        return new File("Translate/Config");
    }

    <E extends CustomEvent> E callEvent(E event);

    default Optional<BlockGroup> getBlockGroup(@NotNull String id) {
        return getBlockGroups().stream().filter(g -> g.getId().equals(id)).findFirst();
    }

    default Optional<Plugin> getPlugin(@NotNull String name) {
        return getPlugins().stream().filter(p -> p.getPluginName().equals(name)).findAny();
    }

    default Optional<TileEntitySnapshot<? extends TileEntity>> getDefaultTileEntity(@NotNull BlockType type) {
        return getDefaultTileEntities().stream().filter(t -> t.getSupportedBlocks().stream().anyMatch(ty -> ty.equals(type))).findFirst();
    }
}
