package org.core;

import org.core.config.ConfigurationFormat;
import org.core.config.ConfigurationStream;
import org.core.event.EventManager;
import org.core.platform.Platform;
import org.core.platform.PlatformServer;
import org.core.schedule.SchedulerBuilder;
import org.core.source.command.ConsoleSource;
import org.core.text.Text;
import org.core.world.boss.ServerBossBar;

import java.io.File;

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

    abstract class CoreImplementation implements TranslateCore {

        protected static CoreImplementation IMPLEMENTATION;

        public static CoreImplementation getImplementation() {
            return IMPLEMENTATION;
        }

    }
}