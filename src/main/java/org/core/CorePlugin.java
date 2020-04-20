package org.core;

import org.core.configuration.ConfigurationFile;
import org.core.configuration.type.ConfigurationLoaderType;
import org.core.event.EventManager;
import org.core.platform.Platform;
import org.core.platform.PlatformServer;
import org.core.schedule.SchedulerBuilder;
import org.core.source.command.ConsoleSource;
import org.core.text.Text;
import org.core.world.boss.ServerBossBar;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public interface CorePlugin {

    Platform getRawPlatform();

    EventManager getRawEventManager();

    ConsoleSource getRawConsole();

    SchedulerBuilder createRawSchedulerBuilder();

    ConfigurationFile createRawConfigurationFile(File file, ConfigurationLoaderType type);

    PlatformServer getRawServer();

    Text textBuilder(String chars);

    ServerBossBar bossBuilder();

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

    static ServerBossBar createBossBar(){
        return CorePlugin.CoreImplementation.getImplementation().bossBuilder();
    }

    static <T, V extends T> List<V> arrayCast(Predicate<T> predicate, Collection<T> collection){
        return arrayCast(new ArrayList<>(), predicate, collection);
    }

    @SuppressWarnings("unchecked")
    static <T, V extends T, L extends Collection<V>> L arrayCast(L array, Predicate<T> predicate, Collection<T> original){
        original.stream().filter(predicate).forEach(v -> array.add((V)v));
        return array;
    }

    static String toString(String split, Iterable<String> array){
        return toString(split, t -> t, array);
    }

    static <T> String toString(String split, Function<T, String> function, Iterable<T> array){
        StringBuilder ret = null;
        for(T value : array){
            if(ret == null){
                ret = new StringBuilder(function.apply(value));
            }else{
                ret.append(split).append(function.apply(value));
            }
        }
        if(ret == null){
            return null;
        }
        return Objects.requireNonNull(ret).toString();
    }

    static String toString(String split, String... array){
        return toString(split, t -> t, array);
    }

    static <T> String toString(String split, Function<T, String> function, T... value){
        return toString(split, function, 0, value.length, value);
    }

    static <T> String toString(String split, Function<T, String> function, int start, T... value){
        return toString(split, function, start, value.length, value);
    }

    static String toString(String split, int... array){
        StringBuilder ret = null;
        for(int value : array){
            if(ret == null){
                ret = new StringBuilder(value + "");
            }else{
                ret.append(split).append(value);
            }
        }
        return Objects.requireNonNull(ret).toString();
    }

    static String toString(String split, double... array){
        StringBuilder ret = null;
        for(double value : array){
            if(ret == null){
                ret = new StringBuilder(value + "");
            }else{
                ret.append(split).append(value);
            }
        }
        return Objects.requireNonNull(ret).toString();
    }

    static String toString(String split, long... array){
        StringBuilder ret = null;
        for(long value : array){
            if(ret == null){
                ret = new StringBuilder(value + "");
            }else{
                ret.append(split).append(value);
            }
        }
        return Objects.requireNonNull(ret).toString();
    }

    static String toString(String split, short... array){
        StringBuilder ret = null;
        for(int value : array){
            if(ret == null){
                ret = new StringBuilder(value + "");
            }else{
                ret.append(split).append(value);
            }
        }
        return Objects.requireNonNull(ret).toString();
    }

    static String toString(String split, float... array){
        StringBuilder ret = null;
        for(float value : array){
            if(ret == null){
                ret = new StringBuilder(value + "");
            }else{
                ret.append(split).append(value);
            }
        }
        return Objects.requireNonNull(ret).toString();
    }

    @SafeVarargs
    static <T> String toString(String split, Function<T, String> function, int start, int end, T... array){
        String ret = null;
        for(int A = start; A < end; A++){
            T value = array[A];
            if(ret == null){
                ret = function.apply(value);
            }else{
                ret = ret + split + function.apply(value);
            }
        }
        return ret;
    }

    @SafeVarargs
    static <T> T[] join(T[]... arrays){
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

    @SuppressWarnings("unchecked")
    static <T> T[] strip(Class<T> tClass, int min, int max, T... array){
        Object obj = Array.newInstance(tClass, max - min);
        T[] array1 = (T[])obj;
        for (int A = min; A < max; A++){
            T B = array[A];
            array1[A - min] = array[A];
        }
        return array1;
    }

    static <T> T[] stripIndexFrom(Class<T> tClass, T[] array, int... strip){
        Object obj = Array.newInstance(tClass, array.length - strip.length);
        T[] array1 = (T[])obj;
        int offset = 0;
        for(int A = 0; A < array.length; A++){
            boolean skip = false;
            for(int B = 0; B < strip.length; B++){
                if(B == A){
                    skip = true;
                    break;
                }
            }
            if(skip){
                offset++;
                continue;
            }
            array1[A - offset] = array[A];
        }
        return array1;
    }

    abstract class CoreImplementation implements CorePlugin {

        protected static CoreImplementation IMPLEMENTATION;

        public static CoreImplementation getImplementation(){
            return IMPLEMENTATION;
        }

    }
}