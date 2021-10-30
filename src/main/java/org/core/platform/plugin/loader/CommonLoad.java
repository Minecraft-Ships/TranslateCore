package org.core.platform.plugin.loader;

import org.core.TranslateCore;
import org.core.platform.PlatformDetails;
import org.core.platform.plugin.CorePlugin;
import org.core.platform.plugin.details.CorePluginVersion;
import org.core.platform.plugin.details.LoadOnlyOn;
import org.core.platform.plugin.details.LoadOnlyOnPlatform;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CommonLoad {

    private CommonLoad() {
        throw new RuntimeException("Should not init class");
    }

    private static boolean canLoad(Class<?> clazz) {
        @NotNull PlatformDetails details = TranslateCore.getPlatform().getDetails();
        CorePluginVersion mcVersion = TranslateCore.getPlatform().getMinecraftVersion();
        if (!CorePlugin.class.isAssignableFrom(clazz)) {
            return false;
        }
        if (clazz.isInterface()) {
            return false;
        }
        LoadOnlyOn load = clazz.getAnnotation(LoadOnlyOn.class);
        if (load==null) {
            return true;
        }
        LoadOnlyOnPlatform[] on = load.on();
        Optional<LoadOnlyOnPlatform> opPlatform = Stream.of(on).filter(loadOnlyOn -> details.getIdName().equals(loadOnlyOn.platform())).findAny();
        if (!opPlatform.isPresent()) {
            return false;
        }
        int[] maxMCVersion = opPlatform.get().maxMCVersion();
        int[] minMCVersion = opPlatform.get().minMCVersion();
        int[] maxVersion = opPlatform.get().maxVersion();
        int[] minVersion = opPlatform.get().minVersion();
        if ((maxMCVersion.length==3) || (minMCVersion.length==3)) {
            if (maxMCVersion.length==3) {
                if (maxMCVersion[0] > mcVersion.getMajor()) {
                    return false;
                }
                if (maxMCVersion[1] > mcVersion.getMinor()) {
                    return false;
                }
                if (maxMCVersion[2] > mcVersion.getPatch()) {
                    return false;
                }
            }
        }
        if ((maxVersion.length==3) || (minVersion.length==3)) {
            if (maxVersion.length==3) {
                if (maxVersion[0] < mcVersion.getMajor()) {
                    return false;
                }
                if (maxVersion[1] < mcVersion.getMinor()) {
                    return false;
                }
                return maxVersion[2] >= mcVersion.getPatch();
            }
        }
        return true;
    }

    private static CorePlugin newInstance(Class<?> clazz) {
        try {
            Constructor<?> constr = clazz.getConstructor();
            constr.setAccessible(true);
            return (CorePlugin) constr.newInstance();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Cannot find 0 parameter constructor in " + clazz.getName(), e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("constructor with 0 parameters requires to be public: " + clazz.getName(), e);
        } catch (InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static CorePlugin loadStandAlonePlugin(Class<?> clazz) {
        if (!canLoad(clazz)) {
            throw new RuntimeException("Failed to load");
        }
        return newInstance(clazz);
    }

    public static List<CorePlugin> loadPlugin(ClassLoader loader, File... files) {
        return Stream.of(files)
                .parallel()
                .filter(file -> file.getName().endsWith(".jar"))
                .flatMap(file -> {
                    try {
                        return new JarLoader(file).load(loader).stream();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return Stream.empty();
                    }
                })
                .filter(CommonLoad::canLoad)
                .map(CommonLoad::newInstance)
                .sorted()
                .collect(Collectors.toList());
    }
}
