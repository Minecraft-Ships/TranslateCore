package org.core.command;

import org.core.platform.plugin.Plugin;

public interface CommandLauncher extends BaseCommandLauncher {

    Plugin getPlugin();
}
