package org.core.world.position.block.details;

public interface OpenableDetails extends BlockDetails {

    boolean isOpen();
    OpenableDetails setOpen(boolean check);
}
