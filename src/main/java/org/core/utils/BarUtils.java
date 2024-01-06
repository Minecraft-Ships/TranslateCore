package org.core.utils;

import net.kyori.adventure.bossbar.BossBar;
import org.core.TranslateCore;
import org.core.entity.living.human.player.LivePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public final class BarUtils {

    public BarUtils() {
        throw new RuntimeException("Do not execute");
    }

    public static Stream<LivePlayer> getPlayers(@NotNull BossBar bar) {
        return TranslateCore
                .getServer()
                .getOnlinePlayers()
                .stream()
                .filter(player -> player.bossBarsStream().anyMatch(boss -> boss.equals(bar)));
    }

}
