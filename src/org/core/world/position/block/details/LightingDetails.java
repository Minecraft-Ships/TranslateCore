package org.core.world.position.block.details;

public interface LightingDetails extends BlockDetails {

    boolean isLit();
    LightingDetails setLit(boolean lit);
}
