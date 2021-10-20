package org.core.platform.plugin.details;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface LoadOnlyOnPlatform {

    @NotNull String platform();

    int[] minVersion();

    int[] maxVersion();

    int[] minMCVersion();

    int[] maxMCVersion();
}
