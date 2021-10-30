package org.core.event.events.connection;

import org.core.adventureText.AText;
import org.core.entity.living.human.player.LivePlayer;
import org.core.event.events.entity.EntityEvent;

public interface ClientConnectionEvent extends EntityEvent<LivePlayer> {

    interface Incoming extends ClientConnectionEvent {

        interface Joined extends Incoming {

        }

    }

    interface Leave extends ClientConnectionEvent {

        AText getLeavingMessage();

        Leave setLeavingMessage(AText message);

        interface Quit extends Leave {

        }

        interface Kick extends Leave {

        }
    }
}
