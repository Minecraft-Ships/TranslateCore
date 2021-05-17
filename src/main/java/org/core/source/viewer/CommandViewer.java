package org.core.source.viewer;

import org.core.adventureText.AText;
import org.core.source.command.CommandSource;
import org.core.text.Text;

import java.util.UUID;

public interface CommandViewer extends CommandSource {

    @Deprecated
    CommandViewer sendMessage(Text message, UUID uuid);

    @Deprecated
    CommandViewer sendMessage(Text message);

    @Deprecated
    CommandViewer sendMessagePlain(String message);

    CommandViewer sendMessage(AText message, UUID uuid);

    CommandViewer sendMessage(AText message);

}
