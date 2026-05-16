package org.core.event.events.connection;

import net.kyori.adventure.text.Component;
import org.core.entity.living.human.player.LivePlayer;
import org.core.event.events.entity.EntityEvent;
import org.core.utils.ComponentUtils;
import org.jetbrains.annotations.NotNull;

public interface ClientConnectionEvent extends EntityEvent<LivePlayer> {

    interface Incoming extends ClientConnectionEvent {

        interface Joined extends Incoming {

        }

    }

    interface Leave extends ClientConnectionEvent {

        interface Quit extends Leave {

        }

        interface Kick extends Leave {

        }

        @NotNull Component getLeaveMessage();

        Leave setLeaveMessage(@NotNull Component message);

        default void removeLeaveMessage() {
            this.setLeaveMessage(Component.empty());
        }
    }
}
