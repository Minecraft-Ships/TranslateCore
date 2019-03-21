package org.core.platform;

import org.core.command.BaseCommandLauncher;
import org.core.world.WorldExtent;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface PlatformServer {

    Set<WorldExtent> getWorlds();
    Optional<WorldExtent> getWorldByPlatformSpecific(String name);

    Collection<BaseCommandLauncher> getCommands();
    void registerCommands(BaseCommandLauncher... commandLaunchers);

    default Optional<WorldExtent> getWorld(String name, boolean justName){
        if(justName){
            return getWorlds().stream().filter(w -> w.getName().equals(name)).findAny();
        }
        return getWorldByPlatformSpecific(name);
    }

    default Optional<WorldExtent> getWorld(UUID uuid){
        return getWorlds().stream().filter(w -> w.getUniquieId().equals(uuid)).findAny();
    }
}
