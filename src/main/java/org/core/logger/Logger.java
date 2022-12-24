package org.core.logger;

import org.core.adventureText.AText;
import org.jetbrains.annotations.NotNull;

public interface Logger {

    void log(@NotNull String log);

    void log(@NotNull AText log);

    void warning(@NotNull String log);

    void error(@NotNull String log);

}
