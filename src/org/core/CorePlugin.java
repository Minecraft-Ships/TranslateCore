package org.core;

import org.core.platform.Platform;
import org.core.schedule.SchedulerBuilder;

import java.lang.reflect.Array;

public interface CorePlugin {

    public Platform getRawPlatform();

    public SchedulerBuilder createRawSchedulerBuilder();

    public static Platform getPlatform(){
        return CorePlugin.CoreImplementation.getImplementation().getRawPlatform();
    }

    public static SchedulerBuilder createSchedulerBuilder(){
        return CorePlugin.CoreImplementation.getImplementation().createRawSchedulerBuilder();
    }

    public static <T extends Object> T[] join(T[]... arrays){
        int total = 0;
        for(T[] array : arrays){
            for(int A = 0; A < array.length; A++){
                total++;
            }
        }
        T[] arrayMash = (T[])Array.newInstance(arrays[0].getClass().getComponentType(), total);
        int current = 0;
        for(T[] array : arrays){
            for(T value : array){
                arrayMash[current] = value;
                current++;
            }
        }
        return arrayMash;
    }

    public abstract class CoreImplementation implements CorePlugin {

        protected static CoreImplementation IMPLEMENTATION;

        public static CoreImplementation getImplementation(){
            return IMPLEMENTATION;
        }

    }

}