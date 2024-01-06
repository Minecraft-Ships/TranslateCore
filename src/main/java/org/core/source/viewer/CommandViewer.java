package org.core.source.viewer;

import org.core.adventureText.AText;
import org.core.source.command.CommandSource;

import java.util.UUID;

/**
 * @deprecated Removing due to all command sources now allowing text to be displayed
 */
@Deprecated(forRemoval = true)
public interface CommandViewer extends CommandSource {

    @Override
    CommandViewer sendMessage(AText message, UUID uuid);

    @Override
    CommandViewer sendMessage(AText message);

}
