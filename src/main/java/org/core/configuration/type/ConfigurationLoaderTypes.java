package org.core.configuration.type;

import org.core.CorePlugin;
import org.core.utils.Guaranteed;

public class ConfigurationLoaderTypes implements Guaranteed<ConfigurationLoaderType> {

    public static final ConfigurationLoaderType DEFAULT = CorePlugin.getPlatform().get(new ConfigurationLoaderTypes("Default"));
    public static final ConfigurationLoaderType YAML = CorePlugin.getPlatform().get(new ConfigurationLoaderTypes("YetAnotherMarkupLang"));

    private String name;

    private ConfigurationLoaderTypes(String name){
        this.name = name;
    }

    @Override
    public String getId() {
        return "core:" + getName().toLowerCase();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
