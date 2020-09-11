package org.core.config;

public class ConfigurationFormat {

    public static final String MEDIA_TYPE_STORAGE = "Markup Language";

    public static final ConfigurationFormat FORMAT_YAML = new ConfigurationFormat("Yet Another Markup Language", MEDIA_TYPE_STORAGE, "yml", "yaml");
    public static final ConfigurationFormat FORMAT_JSON = new ConfigurationFormat("JavaScript Object Notation", MEDIA_TYPE_STORAGE, "json");

    private String type;
    private String name;
    private String[] types;

    protected ConfigurationFormat(String name, String type, String... types){
        this.name = name;
        this.type = type;
        this.types = types;
    }

    public String getMediaType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public String[] getFileType(){
        return this.types;
    }
}
