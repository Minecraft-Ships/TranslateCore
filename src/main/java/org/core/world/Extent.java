package org.core.world;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.core.TranslateCore;
import org.core.entity.LiveEntity;
import org.core.platform.PlatformDetails;
import org.core.threadsafe.ThreadSafe;
import org.core.vector.type.Vector3;
import org.core.world.position.block.entity.LiveTileEntity;
import org.core.world.position.impl.async.ASyncBlockPosition;
import org.core.world.position.impl.async.ASyncExactPosition;
import org.core.world.position.impl.async.ASyncPosition;
import org.core.world.position.impl.sync.SyncBlockPosition;
import org.core.world.position.impl.sync.SyncExactPosition;
import org.core.world.position.impl.sync.SyncPosition;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Extent {

    SyncExactPosition getPosition(double x, double y, double z);

    @ThreadSafe(impl = PlatformDetails.BUKKIT_ID)
    @Deprecated(forRemoval = true)
    ASyncExactPosition getAsyncPosition(double x, double y, double z);

    SyncBlockPosition getPosition(int x, int y, int z);

    @ThreadSafe(impl = PlatformDetails.BUKKIT_ID)
    @Deprecated(forRemoval = true)
    ASyncBlockPosition getAsyncPosition(int x, int y, int z);

    boolean isLoaded();

    @Deprecated(forRemoval = true)
    default Set<LiveEntity> getEntities() {
        return this.getLiveEntities().collect(Collectors.toSet());
    }

    Stream<LiveEntity> getLiveEntities();

    @Deprecated(forRemoval = true)
    default Set<LiveTileEntity> getTileEntities() {
        return this.getLiveTileEntities().collect(Collectors.toSet());
    }

    Stream<LiveTileEntity> getLiveTileEntities();

    @NotNull
    default <N extends Number> SyncPosition<N> getPosition(@NotNull Vector3<N> vector) {
        if (vector.getX() instanceof Integer) {
            return (SyncPosition<N>) this.getPosition(vector.getX().intValue(), vector.getY().intValue(),
                                                      vector.getZ().intValue());
        }
        if (vector.getX() instanceof Double) {
            return (SyncPosition<N>) this.getPosition(vector.getX().doubleValue(), vector.getY().doubleValue(),
                                                      vector.getZ().doubleValue());
        }
        TranslateCore
                .getConsole()
                .sendMessage(Component
                                     .text("Extent.getPosition(Vector3<" + vector.getX().getClass().getSimpleName()
                                                   + ") is not supported. Defaulting to ExactPosition")
                                     .color(NamedTextColor.RED));
        return (SyncPosition<N>) this.getPosition(vector.getX().doubleValue(), vector.getY().doubleValue(),
                                                  vector.getZ().doubleValue());
    }

    @NotNull
    @Deprecated(forRemoval = true)
    default <N extends Number> ASyncPosition<N> getAsyncPosition(@NotNull Vector3<N> vector) {
        if (vector.getX() instanceof Integer) {
            return (ASyncPosition<N>) this.getAsyncPosition(vector.getX().intValue(), vector.getY().intValue(),
                                                            vector.getZ().intValue());
        }
        if (vector.getX() instanceof Double) {
            return (ASyncPosition<N>) this.getAsyncPosition(vector.getX().doubleValue(), vector.getY().doubleValue(),
                                                            vector.getZ().doubleValue());
        }

        TranslateCore
                .getConsole()
                .sendMessage(Component
                                     .text("Extent.getPosition(Vector3<" + vector.getX().getClass().getSimpleName()
                                                   + ") is not supported. Defaulting to ExactPosition")
                                     .color(NamedTextColor.RED));
        return (ASyncPosition<N>) this.getAsyncPosition(vector.getX().doubleValue(), vector.getY().doubleValue(),
                                                        vector.getZ().doubleValue());
    }
}
