package org.core;

import org.core.configuration.ConfigurationFile;
import org.core.configuration.type.ConfigurationLoaderType;
import org.core.event.EventManager;
import org.core.platform.Platform;
import org.core.platform.PlatformServer;
import org.core.schedule.SchedulerBuilder;
import org.core.source.command.ConsoleSource;
import org.core.text.Text;

import java.io.File;
import java.lang.reflect.Array;
import java.util.function.Function;

public interface CorePlugin {

    Platform getRawPlatform();

    EventManager getRawEventManager();

    ConsoleSource getRawConsole();

    SchedulerBuilder createRawSchedulerBuilder();

    ConfigurationFile createRawConfigurationFile(File file, ConfigurationLoaderType type);

    PlatformServer getRawServer();

    Text textBuilder(String chars);

    static Platform getPlatform(){
        return CorePlugin.CoreImplementation.getImplementation().getRawPlatform();
    }

    static ConsoleSource getConsole(){
        return CorePlugin.CoreImplementation.getImplementation().getRawConsole();
    }

    static Text buildText(String text){
        return CorePlugin.CoreImplementation.getImplementation().textBuilder(text);
    }

    static SchedulerBuilder createSchedulerBuilder(){
        return CorePlugin.CoreImplementation.getImplementation().createRawSchedulerBuilder();
    }

    static PlatformServer getServer(){
        return CorePlugin.CoreImplementation.getImplementation().getRawServer();
    }

    static EventManager getEventManager(){
        return CorePlugin.CoreImplementation.getImplementation().getRawEventManager();
    }

    static ConfigurationFile createConfigurationFile(File file, ConfigurationLoaderType type){
        return CorePlugin.CoreImplementation.getImplementation().createRawConfigurationFile(file, type);
    }

    static <T extends Object> String toString(String split, Function<T, String> function, Iterable<T> array){
        String ret = null;
        for(T value : array){
            if(ret == null){
                ret = function.apply(value);
            }else{
                ret = ret + split + function.apply(value);
            }
        }
        return ret;
    }

    static <T extends Object> String toString(String split, Function<T, String> function, T... array){
        String ret = null;
        for(T value : array){
            if(ret == null){
                ret = function.apply(value);
            }else{
                ret = ret + split + function.apply(value);
            }
        }
        return ret;
    }

    static <T extends Object> T[] join(T[]... arrays){
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

    abstract class CoreImplementation implements CorePlugin {

        protected static CoreImplementation IMPLEMENTATION;

        public static CoreImplementation getImplementation(){
            return IMPLEMENTATION;
        }

    }

}