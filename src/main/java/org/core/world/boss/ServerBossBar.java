package org.core.world.boss;

import org.core.adventureText.AText;
import org.core.entity.living.human.player.LivePlayer;
import org.core.world.boss.colour.BossColour;

import java.util.Set;

@Deprecated(forRemoval = true)
public interface ServerBossBar {

    AText getTitle();

    ServerBossBar setTitle(AText text);

    BossColour getColour();

    ServerBossBar setColour(BossColour colour);

    int getValue();

    ServerBossBar setValue(int value);

    Set<LivePlayer> getPlayers();

    ServerBossBar register(LivePlayer... players);

    ServerBossBar deregister(LivePlayer... players);

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
