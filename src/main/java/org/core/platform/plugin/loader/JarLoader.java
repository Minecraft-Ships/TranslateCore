package org.core.platform.plugin.loader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.Objects;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class JarLoader {

    private final File file;

    public JarLoader(File file) {
        this.file = file;
    }

    public Collection<Class<?>> load(ClassLoader loader) throws IOException {
        URLClassLoader classLoader = new URLClassLoader(new URL[]{this.file.toURI().toURL()}, loader);
        JarFile jar = new JarFile(this.file);
        return jar
                .stream()
                .filter(entry -> !entry.isDirectory())
                .filter(entry -> entry.getName().endsWith(".class"))
                .map(entry -> {
                    String name = entry.getName();
                    name = name.substring(0, name.length() - 6);
                    name = name.replaceAll("/", ".");
                    try {
                        return classLoader.loadClass(name);
                    } catch (ClassNotFoundException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

    }
}
