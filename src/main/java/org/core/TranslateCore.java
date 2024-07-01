package org.core;

import net.kyori.adventure.bossbar.BossBar;
import org.core.config.ConfigManager;
import org.core.config.ConfigurationFormat;
import org.core.config.ConfigurationStream;
import org.core.eco.CurrencyManager;
import org.core.event.EventManager;
import org.core.platform.Platform;
import org.core.platform.PlatformServer;
import org.core.platform.plugin.CorePlugin;
import org.core.schedule.ScheduleManager;
import org.core.source.command.ConsoleSource;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Optional;

public interface TranslateCore {

    abstract class CoreImplementation implements TranslateCore {

        protected static CoreImplementation IMPLEMENTATION;

        public static CoreImplementation getImplementation() {
            if (!hasStarted()) {
                throw new RuntimeException("Has not started TranslateCore");
            }
            return IMPLEMENTATION;
        }

        public static boolean hasStarted() {
            return IMPLEMENTATION != null;
        }

    }

    Platform getRawPlatform();

    ScheduleManager getRawScheduleManager();

    EventManager getRawEventManager();

    ConsoleSource getRawConsole();

    PlatformServer getRawServer();

    ConfigManager getRawConfigManager();

    CurrencyManager getRawCurrencyManager();

    boolean isOnServerThreadRaw();

    static boolean isOnServerThread(){
        return TranslateCore.CoreImplementation.getImplementation().isOnServerThreadRaw();
    }

    static ScheduleManager getScheduleManager() {
        return TranslateCore.CoreImplementation.getImplementation().getRawScheduleManager();
    }

    static CurrencyManager getCurrencyManager() {
        return TranslateCore.CoreImplementation.getImplementation().getRawCurrencyManager();
    }

    static Platform getPlatform() {
        return TranslateCore.CoreImplementation.getImplementation().getRawPlatform();
    }

    static ConsoleSource getConsole() {
        return TranslateCore.CoreImplementation.getImplementation().getRawConsole();
    }

    static PlatformServer getServer() {
        return TranslateCore.CoreImplementation.getImplementation().getRawServer();
    }

    static EventManager getEventManager() {
        return TranslateCore.CoreImplementation.getImplementation().getRawEventManager();
    }

    static ConfigManager getConfigManager() {
        return TranslateCore.CoreImplementation.getImplementation().getRawConfigManager();
    }

    @Deprecated
    static ConfigurationStream.ConfigurationFile createConfigurationFile(File file, ConfigurationFormat type) {
        return getConfigManager().read(file, type);
    }

    static Optional<Class<? extends CorePlugin>> getStandAloneLauncher() {
        InputStream is = TranslateCore.class.getResourceAsStream("/META-INF/translate-core.properties");
        if (is == null) {
            return Optional.empty();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        Optional<String> opPath = br.lines().filter(line -> line.startsWith("stand-alone=")).findFirst();
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (opPath.isEmpty()) {
            return Optional.empty();
        }
        String path = opPath.get().substring(12);
        Class<?> clazz;
        try {
            clazz = Class.forName(path);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Could not find class of " + path, e);
        }
        if (CorePlugin.class.isAssignableFrom(clazz)) {
            return Optional.of((Class<? extends CorePlugin>) clazz);
        }
        return Optional.empty();

    }
}