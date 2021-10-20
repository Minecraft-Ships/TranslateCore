package org.core.terminal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Terminal {

    private static File PATH_TO_CORE;
    private static String PATH_TO_MAIN;
    private static File OUTPUT;
    private static String TEMP = "Temporary";

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
                        OUTPUT = new File(fileName);
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

        Path temp;

        try {
            temp = Files.createTempDirectory(TEMP);
        } catch (IOException e) {
            System.err.println("Cannot create folder");
            e.printStackTrace();
            System.exit(1);
            return;
        }

        copyToTemp(temp, thisJar);
        copyToTemp(temp, core);

        OUTPUT.getParentFile().mkdirs();
        try {
            OUTPUT.createNewFile();
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(OUTPUT));
            Files.walk(temp).forEach(path -> {
                ZipEntry zipEntry = new ZipEntry(path.toString());
                try {
                    byte[] bytes = Files.readAllBytes(path);
                    out.putNextEntry(zipEntry);
                    out.write(bytes);
                    out.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
            return;
        }

    }

    private static void copyToTemp(Path temp, JarFile thisJar) {
        thisJar.stream()
                .forEach(entry -> {
                    if (entry.isDirectory()) {
                        try {
                            Files.createTempDirectory(temp, entry.getName());
                        } catch (IOException e) {
                            System.err.println("Failed to create folder: " + e.getMessage());
                        }
                        return;
                    }
                    try {
                        InputStream stream = thisJar.getInputStream(entry);
                        Path tempFile = Files.createTempFile(TEMP, entry.getName());
                        Files.copy(stream, tempFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                });
    }
}
