package org.core.world.position.block.details;

/**
 * <p>If the BlockDetails can be opened then this will be implemented.</p>
 */
public interface OpenableDetails extends BlockDetails {

    /**
     * <p>Checks if the BlockDetails is open</p>
     * @return If the BlockDetails is open
     */
    boolean isOpen();

    /**
     * <p>Sets if the BlockDetails is open</p>
     * @param check The value you wish to set
     * @return This instance, for chaining
     */
    OpenableDetails setOpen(boolean check);
}
