package org.core.platform.update.result;

import org.jetbrains.annotations.NotNull;

public class FailedResult implements UpdateResult {

    private final @NotNull String reason;

    public FailedResult(@NotNull String reason) {
        this.reason = reason;
    }

    public @NotNull String getReason() {
        return this.reason;
    }

}
