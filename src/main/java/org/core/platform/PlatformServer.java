package org.core.platform;

import org.core.entity.living.human.player.LivePlayer;
import org.core.entity.living.human.player.User;
import org.core.platform.plugin.Plugin;
import org.core.world.WorldExtent;
import org.core.world.position.block.details.BlockSnapshot;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface PlatformServer {

    Set<WorldExtent> getWorlds();

    Optional<WorldExtent> getWorldByPlatformSpecific(String name);

    Collection<LivePlayer> getOnlinePlayers();

    void applyBlockSnapshots(Collection<BlockSnapshot.AsyncBlockSnapshot> collection, Plugin plugin, Runnable onComplete);

    default void applyBlockSnapshots(Collection<BlockSnapshot.SyncBlockSnapshot> collection) {
        collection.forEach(bs -> bs.getPosition().setBlock(bs));
    }

    CompletableFuture<Optional<User>> getOfflineUser(UUID uuid);

    CompletableFuture<Optional<User>> getOfflineUser(String lastName);

    Collection<CompletableFuture<User>> getOfflineUsers();

    default Optional<WorldExtent> getWorld(String name, boolean justName) {
        if (justName) {
            return getWorlds().stream().filter(w -> w.getName().equals(name)).findAny();
        }
        return getWorldByPlatformSpecific(name);
    }

    default Optional<WorldExtent> getWorld(UUID uuid) {
        return getWorlds().stream().filter(w -> w.getUniqueId().equals(uuid)).findAny();
    }
}
