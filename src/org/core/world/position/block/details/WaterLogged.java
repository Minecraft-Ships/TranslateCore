package org.core.world.position.block.details;

/**
 * <p>If the BlockDetails is Water Logged then it will implement this</p>
 */
public interface WaterLogged extends BlockDetails {

    WaterLogged setWaterlogged(boolean set);
    boolean isWaterLogged();

}
