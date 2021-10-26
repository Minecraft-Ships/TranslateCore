package org.core;

import org.core.config.ConfigurationFormat;
import org.core.config.ConfigurationStream;
import org.core.event.EventManager;
import org.core.platform.Platform;
import org.core.platform.PlatformServer;
import org.core.platform.plugin.CorePlugin;
import org.core.schedule.SchedulerBuilder;
import org.core.source.command.ConsoleSource;
import org.core.text.Text;
import org.core.world.boss.ServerBossBar;

import java.io.*;
import java.util.Collections;
import java.util.Optional;

public interface TranslateCore {

    Platform getRawPlatform();

    EventManager getRawEventManager();

    ConsoleSource getRawConsole();

    SchedulerBuilder createRawSchedulerBuilder();

    ConfigurationStream.ConfigurationFile createRawConfigurationFile(File file, ConfigurationFormat type);

    PlatformServer getRawServer();

    @Deprecated
    Text textBuilder(String chars);

    ServerBossBar bossBuilder();

    static Platform getPlatform() {
        return TranslateCore.CoreImplementation.getImplementation().getRawPlatform();
    }

    static ConsoleSource getConsole() {
        return TranslateCore.CoreImplementation.getImplementation().getRawConsole();
    }

    @Deprecated
    static Text buildText(String text) {
        return TranslateCore.CoreImplementation.getImplementation().textBuilder(text);
    }

    static SchedulerBuilder createSchedulerBuilder() {
        return TranslateCore.CoreImplementation.getImplementation().createRawSchedulerBuilder();
    }

    static PlatformServer getServer() {
        return TranslateCore.CoreImplementation.getImplementation().getRawServer();
    }

    static EventManager getEventManager() {
        return TranslateCore.CoreImplementation.getImplementation().getRawEventManager();
    }

    static ConfigurationStream.ConfigurationFile createConfigurationFile(File file, ConfigurationFormat type) {
        return TranslateCore.CoreImplementation.getImplementation().createRawConfigurationFile(file, type);
    }

    static ServerBossBar createBossBar() {
        return TranslateCore.CoreImplementation.getImplementation().bossBuilder();
    }

    static Optional<Class<? extends CorePlugin>> getStandAloneLauncher() {
        try {

            Collections.list(TranslateCore.class.getClassLoader().getResources("/META-INF/")).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = TranslateCore.class.getResourceAsStream("/META-INF/translate-core.properties");
        if (is==null) {
            return Optional.empty();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        Optional<String> opPath = br.lines().filter(line -> line.startsWith("stand-alone=")).findFirst();
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!opPath.isPresent()) {
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

    abstract class CoreImplementation implements TranslateCore {

        protected static CoreImplementation IMPLEMENTATION;

        public static CoreImplementation getImplementation() {
            return IMPLEMENTATION;
        }

    }
}