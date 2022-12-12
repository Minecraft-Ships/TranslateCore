package org.core.platform.update;

import org.core.platform.update.result.UpdateResult;
import org.jetbrains.annotations.NotNull;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

public interface PlatformUpdate<O extends UpdateOption> {

    URI getUpdateSite();

    String getIdName();

    CompletableFuture<UpdateResult> checkForUpdate(@NotNull O option);
}
