package org.core.terminal;

import org.core.platform.plugin.CorePlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@SuppressWarnings({"HardCodedStringLiteral", "UseOfSystemOutOrSystemErr", "CallToSystemExit", "ResultOfMethodCallIgnored"})
public final class Terminal {

    private static File PATH_TO_CORE;
    private static String PATH_TO_MAIN;
    private static File OUTPUT;
    private static final String TEMP = "Temporary";

    private Terminal() {
        throw new RuntimeException("Should not be init");
    }

    public static void main(String[] args) {
        for (int A = 0; A < args.length; A++) {
            String arg = args[A];
            switch (arg.toLowerCase()) {
                case "jar":
                case "plugin":
                case "core":
                    PATH_TO_CORE = new File(args[A + 1]);
                    if (OUTPUT==null) {
                        String[] folders = args[A + 1].split("/");
                        String fileName = folders[folders.length - 1];
                        //noinspection NonThreadSafeLazyInitialization
                        OUTPUT = new File("Standalone - " + fileName);
                    }
                    A = A + 1;
                    break;
                case "main":
                case "boot":
                    PATH_TO_MAIN = args[A + 1];
                    A = A + 1;
                    break;
                default:
                    System.err.println("Unknown argument of " + arg);
            }
        }

        if (PATH_TO_MAIN==null) {
            System.err.println("Main needs to be stated");
            System.exit(1);
            return;
        }
        if (PATH_TO_CORE==null) {
            System.err.println("Jar needs to be stated");
            System.exit(1);
            return;
        }
        if (!PATH_TO_CORE.exists()) {
            System.err.println("Cannot find jar file: " + PATH_TO_CORE.getAbsolutePath());
            System.exit(1);
            return;
        }

        if (OUTPUT==null) {
            System.err.println("Cannot find specified output");
            System.exit(1);
            return;
        }

        JarFile core;
        try {
            core = new JarFile(PATH_TO_CORE);
        } catch (IOException e) {
            System.err.println("Jar file is not a valid jar");
            e.printStackTrace();
            System.exit(1);
            return;
        }

        JarFile thisJar;
        try {
            File file = new File(Terminal.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            thisJar = new JarFile(file);
        } catch (IOException | URISyntaxException e) {
            System.err.println("Could not get the jar file running, is a wrapped launcher?");
            e.printStackTrace();
            System.exit(1);
            return;
        }

        File temp = new File(TEMP);

        try {
            Files.createDirectories(temp.toPath());
        } catch (IOException e) {
            System.err.println("Cannot create folder");
            e.printStackTrace();
            System.exit(1);
            return;
        }

        copyToTemp(temp, thisJar);
        copyToTemp(temp, core);

        CorePlugin plugin;
        try {
            URLClassLoader classLoader = new URLClassLoader(new URL[]{Terminal.class.getProtectionDomain().getCodeSource().getLocation().toURI().toURL(), PATH_TO_CORE.toURI().toURL()});
            Class<?> clazz = classLoader.loadClass(PATH_TO_MAIN);
            plugin = (CorePlugin) clazz.getConstructor().newInstance();
        } catch (IOException | ClassNotFoundException | URISyntaxException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            System.err.println("Could not load");
            e.printStackTrace();
            return;
        }

        if (OUTPUT.getParentFile()!=null) {
            OUTPUT.getParentFile().mkdirs();
        }
        try {
            OUTPUT.createNewFile();
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(OUTPUT));
            Files.walk(temp.toPath()).forEach(path -> {
                String pathStr = path.toString().substring(9);
                if (pathStr.startsWith("\\")) {
                    pathStr = pathStr.substring("\\".length());
                }
                System.out.println("Path: " + pathStr);
                ZipEntry zipEntry = new ZipEntry(pathStr);
                try {
                    if (Files.isDirectory(path)) {
                        return;
                    }
                    if (pathStr.endsWith("plugin.yml")) {
                        String lines = Files.lines(path).collect(Collectors.joining("\n"));
                        lines = lines.replaceAll("name: TranslateCore", "name: " + plugin.getPluginName());
                        lines = lines.replaceAll("version: 1.0.0", "version: " + plugin.getPluginVersion().asString());
                        out.putNextEntry(zipEntry);
                        out.write(lines.getBytes());
                        out.closeEntry();
                        return;
                    }
                    byte[] bytes = Files.readAllBytes(path);
                    out.putNextEntry(zipEntry);
                    out.write(bytes);
                    out.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            ZipEntry entry = new ZipEntry("META-INF" + File.pathSeparatorChar + "translate-core.properties");
            out.putNextEntry(entry);
            out.write(("stand-alone=" + PATH_TO_MAIN).getBytes());
            out.closeEntry();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    private static void copyToTemp(File temp, JarFile thisJar) {
        thisJar.stream()
                .forEach(entry -> {
                    File tempFolder = temp;
                    if (entry.getName().startsWith(tempFolder.getName() + File.separatorChar)) {
                        tempFolder = temp.getParentFile();
                    }
                    if (entry.isDirectory()) {
                        try {
                            new File(tempFolder, entry.getName()).mkdirs();
                        } catch (Exception e) {
                            System.err.println("Failed to create folder: " + e.getMessage());
                            System.err.println("Path: " + temp.getAbsolutePath());
                            System.err.println("Entry: " + entry.getName());
                        }
                        return;
                    }
                    try {
                        InputStream stream = thisJar.getInputStream(entry);
                        File tempFile = new File(tempFolder, entry.getName());
                        if (tempFile.exists()) {
                            return;
                        }
                        Files.copy(stream, tempFile.toPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
