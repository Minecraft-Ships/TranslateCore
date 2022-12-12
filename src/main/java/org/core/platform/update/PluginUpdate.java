package org.core.platform.update;

import java.net.URL;

public interface PluginUpdate {

    String getName();

    URL getDownloadURL();

    String getVersion();

}
