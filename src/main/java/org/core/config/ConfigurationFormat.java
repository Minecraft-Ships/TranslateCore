package org.core.config;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class ConfigurationFormat {

    public static final String MEDIA_TYPE_STORAGE = "Markup Language";

    public static final ConfigurationFormat FORMAT_YAML = new ConfigurationFormat("Yet Another Markup Language",
                                                                                  MEDIA_TYPE_STORAGE, "yml", "yaml");
    public static final ConfigurationFormat FORMAT_JSON = new ConfigurationFormat("JavaScript Object Notation",
                                                                                  MEDIA_TYPE_STORAGE, "json");

    private final String type;
    private final String name;
    private final String[] types;

    protected ConfigurationFormat(String name, String type, String... types) {
        this.name = name;
        this.type = type;
        this.types = types;
    }

    public String getMediaType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String[] getFileType() {
        return this.types;
    }

    public static Stream<ConfigurationFormat> values() {
        return Arrays
                .stream(ConfigurationFormat.class.getDeclaredFields())
                .filter(field -> Modifier.isFinal(field.getModifiers()))
                .filter(field -> Modifier.isPublic(field.getModifiers()))
                .filter(field -> Modifier.isStatic(field.getModifiers()))
                .filter(field -> field.getType().isAssignableFrom(ConfigurationFormat.class))
                .map(field -> {
                    try {
                        return (ConfigurationFormat) field.get(null);
                    } catch (Throwable e) {
                        //should never hit
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(Objects::nonNull);
    }

    public static Optional<ConfigurationFormat> forFile(String fileName) {
        return values()
                .filter(v -> Stream.of(v.getFileType()).anyMatch(t -> fileName.toLowerCase().endsWith(t.toLowerCase())))
                .findFirst();
    }
}
