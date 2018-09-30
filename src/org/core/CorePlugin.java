package org.core;

import org.core.platform.Platform;

public interface CorePlugin {

    CorePlugin imp = null;

    public Platform getRawPlatform();

    public static Platform getPlatform(){
        return imp.getRawPlatform();
    }

}