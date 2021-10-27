package org.core.platform.plugin.details;

import org.core.platform.plugin.details.depends.DependsType;
import org.core.platform.plugin.details.depends.LoadType;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used for specifying dependencies with other plugins
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface LoadOnlyOnPlatform {

    /**
     * The platform/plugin id to load before
     *
     * @return The plugin id to load before
     */
    @NotNull String platform();

    /**
     * Gets if the plugin should fail to load if not present
     * This is ignored if depending on is a platform
     *
     * @return The type of depending on
     */
    @NotNull DependsType getDependsType();

    /**
     * Gets if the plugin should load before or after this plugin
     * This is ignored if the depending upon is a platform
     *
     * @return The loading type
     */
    @NotNull LoadType getLoadType();

    /**
     * Gets the minimum version of the platform that this plugin is compatible with.
     * <p>
     * If the plugin uses a version standard other then major.minor.patch then the numbers
     * within the version will be used
     *
     * @return The minimum version, use empty array if not specified
     */
    int[] minVersion();

    /**
     * Gets the maximum version of the platform that this plugin is compatible with.
     * <p>
     * If the plugin uses a version standard other then major.minor.patch then the numbers
     * within the version will be used
     *
     * @return The maximum version, use empty array if not specified
     */
    int[] maxVersion();

    /**
     * Gets the minimum version of minecraft that this plugin/depending plugin is compatible with.
     *
     * @return The minimum version of MC
     */
    int[] minMCVersion();

    /**
     * Gets the maximum version of minecraft that this plugin/depending plugin is compatible with.
     * <p>
     * if not specified, then use empty array
     *
     * @return The minimum version of MC
     */
    int[] maxMCVersion();
}
