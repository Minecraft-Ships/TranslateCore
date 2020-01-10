package org.core.world.position.block.entity.commandblock;

import java.util.Optional;

public interface CommandBlock {

    Optional<String> getCommand();
    Optional<String> getName();
    CommandBlock setName(String name);
    CommandBlock setCommand(String command);
}
