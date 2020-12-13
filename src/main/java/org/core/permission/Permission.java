package org.core.permission;

import org.core.entity.living.human.player.LivePlayer;

public interface Permission {

    String getPermissionValue();

    default boolean hasPermission(LivePlayer player){
        return player.hasPermission(this.getPermissionValue());
    }
}
