package org.core.world;

import java.util.UUID;

public interface WorldExtent extends Extent {

    public String getName();
    public UUID getUniquieId();
    public String getPlatformUniquieId();
}
