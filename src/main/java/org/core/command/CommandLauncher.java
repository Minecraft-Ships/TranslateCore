package org.core.command;

import org.core.platform.Plugin;

public interface CommandLauncher extends BaseCommandLauncher {

    Plugin getPlugin();
}
