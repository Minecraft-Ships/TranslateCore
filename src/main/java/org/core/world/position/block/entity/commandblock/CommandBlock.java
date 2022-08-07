package org.core.world.position.block.entity.commandblock;

import java.util.Optional;

public interface CommandBlock {

    Optional<String> getCommand();

    CommandBlock setCommand(String command);

    Optional<String> getName();

    CommandBlock setName(String name);
}
