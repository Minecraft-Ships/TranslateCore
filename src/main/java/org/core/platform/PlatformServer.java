package org.core.platform;

import org.core.entity.living.human.player.LivePlayer;
import org.core.entity.living.human.player.User;
import org.core.platform.plugin.Plugin;
import org.core.world.WorldExtent;
import org.core.world.position.block.details.BlockSnapshot;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface PlatformServer {

    @NotNull Set<WorldExtent> getWorlds();

    @NotNull Optional<WorldExtent> getWorldByPlatformSpecific(String name);

    @NotNull Collection<LivePlayer> getOnlinePlayers();

    void applyBlockSnapshots(@NotNull Collection<? extends BlockSnapshot.AsyncBlockSnapshot> collection,
                             @NotNull Plugin plugin,
                             @NotNull Runnable onComplete);

    default void applyBlockSnapshots(@NotNull Collection<? extends BlockSnapshot.SyncBlockSnapshot> collection) {
        collection.forEach(bs -> bs.getPosition().setBlock(bs));
    }

    @NotNull CompletableFuture<Optional<User>> getOfflineUser(@NotNull UUID uuid);

    @NotNull CompletableFuture<Optional<User>> getOfflineUser(@NotNull String lastName);

    @NotNull Collection<CompletableFuture<User>> getOfflineUsers();

    default @NotNull Optional<WorldExtent> getWorld(@NotNull String name, boolean justName) {
        if (justName) {
            return this.getWorlds().stream().filter(w -> w.getName().equals(name)).findAny();
        }
        return this.getWorldByPlatformSpecific(name);
    }

    default @NotNull Optional<WorldExtent> getWorld(@NotNull UUID uuid) {
        return this.getWorlds().stream().filter(w -> w.getUniqueId().equals(uuid)).findAny();
    }
}
