package org.core.platform.plugin.details;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specified on {@link org.core.platform.plugin.CorePlugin} to state dependencies
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoadOnlyOn {

    /**
     * All the platforms/plugin to depend upon
     *
     * @return The platforms/plugins to depend upon
     */
    LoadOnlyOnPlatform[] on();
}
