package org.core.platform;

import org.core.TranslateCore;
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
import org.core.permission.CorePermission;
import org.core.permission.Permission;
import org.core.platform.plugin.Plugin;
import org.core.platform.plugin.details.CorePluginVersion;
import org.core.platform.update.PlatformUpdate;
import org.core.platform.update.UpdateOption;
import org.core.utils.Singleton;
import org.core.world.position.block.BlockType;
import org.core.world.position.block.entity.TileEntity;
import org.core.world.position.block.entity.TileEntitySnapshot;
import org.core.world.position.block.entity.banner.pattern.PatternLayerType;
import org.core.world.position.block.entity.banner.pattern.PatternLayerTypes;
import org.core.world.position.block.grouptype.BlockGroup;
import org.core.world.position.flags.physics.ApplyPhysicsFlag;
import org.core.world.position.flags.physics.ApplyPhysicsFlags;
import org.core.world.structure.Structure;
import org.core.world.structure.StructureBuilder;
import org.core.world.structure.StructureFileBuilder;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Info about the platform TranslateCore is running on
 */
public interface Platform {

    boolean areDeveloperCommandsEnabled();

    void setDeveloperCommandsEnabled(boolean enabled);

    @NotNull PlatformDetails getImplementationDetails();

    @NotNull Collection<PlatformUpdate<?>> getUpdateCheckers();

    @NotNull Singleton<ApplyPhysicsFlag> get(ApplyPhysicsFlags flags);

    @NotNull Singleton<ItemType> get(ItemTypeCommon itemId);

    @NotNull Singleton<ParrotType> get(ParrotTypes parrotID);

    @Deprecated
    <T> UnspecificParser<T> get(UnspecificParsers<T> itemStack);

    @NotNull Singleton<DyeType> get(DyeTypes id);

    @NotNull Singleton<PatternLayerType> get(PatternLayerTypes id);

    @NotNull <E extends LiveEntity, S extends EntitySnapshot<E>> Singleton<EntityType<E, S>> get(EntityTypes<E, S> entityId);

    <E extends LiveEntity> @NotNull Optional<EntityType<E, ? extends EntitySnapshot<E>>> getEntityType(String id);

    @NotNull Optional<BlockType> getBlockType(String id);

    @NotNull Optional<ItemType> getItemType(String id);

    @NotNull Optional<DyeType> getDyeType(String id);

    @NotNull Optional<PatternLayerType> getPatternLayerType(String id);

    @NotNull Optional<ParrotType> getParrotType(String id);

    @NotNull Optional<ApplyPhysicsFlag> getApplyPhysics(String id);

    @Deprecated
    @NotNull Optional<UnspecificParser<?>> getUnspecifiedParser(String id);

    @Deprecated(forRemoval = true)
    default @NotNull Collection<EntityType<? extends LiveEntity, ? extends EntitySnapshot<? extends LiveEntity>>> getEntityTypes() {
        return this.getAllEntityTypes().collect(Collectors.toSet());
    }

    Stream<EntityType<? extends LiveEntity, ? extends EntitySnapshot<? extends LiveEntity>>> getAllEntityTypes();

    @Deprecated(forRemoval = true)
    default @NotNull Collection<BlockType> getBlockTypes() {
        return this.getAllBlockTypes().collect(Collectors.toSet());
    }

    Stream<BlockType> getAllBlockTypes();

    @Deprecated(forRemoval = true)
    default @NotNull Collection<ItemType> getItemTypes() {
        return this.getAllItemTypes().collect(Collectors.toSet());
    }

    Stream<ItemType> getAllItemTypes();

    @NotNull Collection<DyeType> getDyeTypes();

    @NotNull Collection<PatternLayerType> getPatternLayerTypes();

    @Deprecated(forRemoval = true)
    default @NotNull Collection<BlockGroup> getBlockGroups() {
        return this.getAllBlockGroups().collect(Collectors.toSet());
    }

    Stream<BlockGroup> getAllBlockGroups();

    @NotNull Collection<ParrotType> getParrotType();

    @NotNull Collection<ApplyPhysicsFlag> getApplyPhysics();

    @Deprecated(forRemoval = true)
    default @NotNull Collection<Permission> getPermissions() {
        return this.getAllPermissions().collect(Collectors.toSet());
    }

    Stream<Permission> getAllPermissions();

    @NotNull Collection<Structure> getStructures();

    @NotNull Structure register(StructureBuilder builder);

    @NotNull Structure register(StructureFileBuilder builder) throws IOException;

    @Deprecated
    @NotNull Permission register(@NotNull String permissionNode);

    @NotNull CorePermission register(CorePermission permissionNode);

    @Deprecated
    @NotNull Collection<UnspecificParser<?>> getUnspecifiedParsers();

    @NotNull Collection<TileEntitySnapshot<? extends TileEntity>> getDefaultTileEntities();

    @NotNull CorePluginVersion getMinecraftVersion();

    @NotNull PlatformDetails getDetails();

    @NotNull ConfigurationFormat getConfigFormat();

    @Deprecated(forRemoval = true)
    default @NotNull Set<Plugin> getPlugins() {
        return this.getAllPlugins().collect(Collectors.toSet());
    }

    Stream<Plugin> getAllPlugins();

    @NotNull File getPlatformPluginsFolder();

    @NotNull File getPlatformConfigFolder();

    default @NotNull File getTranslatePluginsFolder() {
        if (TranslateCore.getStandAloneLauncher().isPresent()) {
            return this.getPlatformPluginsFolder();
        }
        return new File("translate/plugins");
    }

    default @NotNull File getTranslateConfigFolder() {
        if (TranslateCore.getStandAloneLauncher().isPresent()) {
            return this.getPlatformConfigFolder();
        }
        return new File("translate/configs");
    }

    @NotNull <E extends CustomEvent> E callEvent(E event);

    default @NotNull Optional<BlockGroup> getBlockGroup(@NotNull String id) {
        return this.getAllBlockGroups().filter(g -> g.getId().equals(id)).findFirst();
    }

    default @NotNull Optional<Plugin> getPlugin(@NotNull String name) {
        return this.getAllPlugins().filter(p -> p.getPluginName().equals(name)).findAny();
    }

    default @NotNull Optional<TileEntitySnapshot<? extends TileEntity>> getDefaultTileEntity(@NotNull BlockType type) {
        return this
                .getDefaultTileEntities()
                .stream()
                .filter(t -> t.getApplicableBlocks().anyMatch(ty -> ty.equals(type)))
                .findFirst();
    }

    default <O extends UpdateOption> @NotNull Optional<PlatformUpdate<O>> getUpdateChecker(@NotNull String idName) {
        return this
                .getUpdateCheckers()
                .parallelStream()
                .filter(u -> u.getIdName().equals(idName))
                .findAny()
                .map(v -> (PlatformUpdate<O>) v);
    }

    default @NotNull TranslateCorePlatformDetails getTranslateCoreDetails() {
        return new TranslateCorePlatformDetails();
    }
}
