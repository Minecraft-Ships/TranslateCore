package org.core.world.boss;

import net.kyori.adventure.bossbar.BossBar;
import org.core.TranslateCore;
import org.core.adventureText.AText;
import org.core.adventureText.adventure.AdventureText;
import org.core.entity.living.human.player.LivePlayer;
import org.core.world.boss.colour.BossColour;
import org.core.world.boss.colour.BossColours;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Deprecated(forRemoval = true)
public interface ServerBossBar {

    BossBar bossBar();

    default AText getTitle() {
        return new AdventureText(bossBar().name());
    }

    default ServerBossBar setTitle(AText text) {
        bossBar().name(text);
        return this;
    }

    default BossColour getColour() {
        switch (bossBar().color()) {
            case PINK:
                return BossColours.PINK.get();
            case BLUE:
                return BossColours.BLUE.get();
            case RED:
                return BossColours.RED.get();
            case GREEN:
                return BossColours.GREEN.get();
            case YELLOW:
                return BossColours.YELLOW.get();
            case PURPLE:
                return BossColours.PURPLE.get();
            case WHITE:
                return BossColours.WHITE.get();
        }
        throw new RuntimeException("legacy colour not accepted");
    }

    default ServerBossBar setColour(BossColour colour) {
        BossBar.Color.valueOf(colour.getName().toUpperCase());
        return this;
    }

    default int getValue() {
        return (int) (this.bossBar().progress() * 100);
    }

    default ServerBossBar setValue(int value) {
        this.bossBar().progress((float) (value / 100.0));
        return this;
    }

    default Set<LivePlayer> getPlayers() {
        return TranslateCore
                .getServer()
                .getOnlinePlayers()
                .stream()
                .filter(player -> StreamSupport
                        .stream(player.bossBars().spliterator(), true)
                        .anyMatch(boss -> boss.equals(this.bossBar())))
                .collect(Collectors.toSet());
    }

    default ServerBossBar register(LivePlayer... players) {
        for (LivePlayer player : players) {
            player.showBossBar(bossBar());
        }
        return this;
    }

    default ServerBossBar deregister(LivePlayer... players) {
        for (LivePlayer player : players) {
            player.hideBossBar(bossBar());
        }
        return this;
    }

    default ServerBossBar setValue(int min, int value, int max) {
        return this.setValue(value - min, value - max);
    }

    default ServerBossBar setValue(int value, int max) {
        int percent = (int) ((value * 100.0f) / max);
        return this.setValue(percent);
    }

    default ServerBossBar deregisterPlayers() {
        return this.deregister(this.getPlayers().toArray(new LivePlayer[0]));
    }
}
