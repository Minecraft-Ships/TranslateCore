package org.core.platform.update.result;

import org.core.platform.update.PluginUpdate;
import org.jetbrains.annotations.NotNull;

public class SuccessfulResult implements UpdateResult {

    private final @NotNull PluginUpdate update;

    public SuccessfulResult(@NotNull PluginUpdate update) {
        this.update = update;
    }

    public @NotNull PluginUpdate getUpdate() {
        return this.update;
    }
}
