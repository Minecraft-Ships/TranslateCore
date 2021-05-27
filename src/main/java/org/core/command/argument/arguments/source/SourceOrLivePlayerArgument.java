package org.core.command.argument.arguments.source;

import org.core.command.argument.arguments.operation.OptionalArgument;
import org.core.entity.living.human.player.LivePlayer;

import java.util.AbstractMap;

public class SourceOrLivePlayerArgument extends OptionalArgument<LivePlayer> {

    public SourceOrLivePlayerArgument(String id, LivePlayer def) {
        super(new LivePlayerArgument(id), (context, argument) -> {
            if (context.getSource() instanceof LivePlayer) {
                return new AbstractMap.SimpleImmutableEntry<>((LivePlayer) context.getSource(), 0);
            }
            return new AbstractMap.SimpleImmutableEntry<>(def, 0);
        });
    }
}
