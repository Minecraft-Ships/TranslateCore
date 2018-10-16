package org.core;

import org.core.platform.Platform;
import org.core.schedule.SchedulerBuilder;

public interface CorePlugin {

    public Platform getRawPlatform();

    public SchedulerBuilder createRawSchedulerBuilder();

    public static Platform getPlatform(){
        return CorePlugin.CoreImplementation.getImplementation().getRawPlatform();
    }

    public static SchedulerBuilder createSchedulerBuilder(){
        return CorePlugin.CoreImplementation.getImplementation().createRawSchedulerBuilder();
    }

    public abstract class CoreImplementation implements CorePlugin {

        protected static CoreImplementation IMPLEMENTATION;

        public static CoreImplementation getImplementation(){
            return IMPLEMENTATION;
        }

    }

}