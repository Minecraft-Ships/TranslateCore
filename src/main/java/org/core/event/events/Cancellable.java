package org.core.event.events;

import org.core.event.Event;

public interface Cancellable extends Event {

    public boolean isCancelled();
    public void setCancelled(boolean value);
}
