package org.core.source.viewer;

import org.core.adventureText.AText;
import org.core.source.command.CommandSource;

import java.util.UUID;

public interface CommandViewer extends CommandSource {

    CommandViewer sendMessage(AText message, UUID uuid);

    CommandViewer sendMessage(AText message);

}
