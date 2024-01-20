package org.core.platform.update.bukkit;

import org.core.platform.update.UpdateOption;

public class DevBukkitUpdateOption implements UpdateOption {

    private final int numberId;

    public DevBukkitUpdateOption(int numberId) {
        this.numberId = numberId;
    }

    public int numberId() {
        return this.numberId;
    }

}
