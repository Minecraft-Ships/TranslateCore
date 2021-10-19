package org.core.event;

import org.core.platform.plugin.Plugin;

import java.util.Map;
import java.util.Set;

public interface EventManager {

    <E extends Event> E callEvent(E event);
    EventManager register(Plugin plugin, EventListener... listeners);
    Map<Plugin, Set<EventListener>> getEventListeners();
}
