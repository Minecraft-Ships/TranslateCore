package org.core.event.events;

import org.core.event.Event;

public interface Cancellable extends Event {

    boolean isCancelled();

    void setCancelled(boolean value);
}
