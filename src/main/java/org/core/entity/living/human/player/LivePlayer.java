package org.core.entity.living.human.player;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import org.core.entity.EntityType;
import org.core.entity.LiveEntity;
import org.core.permission.Permission;
import org.core.source.viewer.CommandViewer;
import org.core.world.position.impl.BlockPosition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface LivePlayer extends Player<LiveEntity>, LiveEntity, Audience, CommandViewer {

    Optional<BlockPosition> getBlockLookingAt(int scanLength);

    default Optional<BlockPosition> getBlockLookingAt() {
        return this.getBlockLookingAt(7);
    }

    @Override
    default EntityType<LivePlayer, PlayerSnapshot> getType() {
        return Player.super.getType();
    }

    boolean hasPermission(Permission permission);

    @NotNull @UnmodifiableView Iterable<? extends BossBar> bossBars();

    default Stream<? extends BossBar> bossBarsStream() {
        return StreamSupport.stream(this.bossBars().spliterator(), false);
    }

    @Override
    void sendMessage(@NotNull Component message);
}
