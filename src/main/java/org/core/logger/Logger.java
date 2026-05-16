package org.core.logger;

import org.jetbrains.annotations.NotNull;

public interface Logger {

    void log(@NotNull String log);

    void warning(@NotNull String log);

    void error(@NotNull String log);

}
