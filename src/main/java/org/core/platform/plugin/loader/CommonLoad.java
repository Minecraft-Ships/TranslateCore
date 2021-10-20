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
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface CommonLoad {

    static List<CorePlugin> loadPlugin(ClassLoader loader, File... files) {
        @NotNull PlatformDetails details = TranslateCore.getPlatform().getDetails();
        CorePluginVersion mcVersion = TranslateCore.getPlatform().getMinecraftVersion();
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
                .filter(CorePlugin.class::isAssignableFrom)
                .filter(clazz -> !clazz.isInterface())
                .filter(clazz -> {
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
                })
                .map(clazz -> {
                    try {
                        Constructor<?> constr = clazz.getConstructor();
                        constr.setAccessible(true);
                        return (CorePlugin) constr.newInstance();
                    } catch (NoSuchMethodException e) {
                        System.err.println("Cannot find 0 parameter constructor in " + clazz.getName());
                        e.printStackTrace();
                        return null;
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.toList());

    }
}
