package org.core.source.viewer;

import org.core.source.command.CommandSource;

public interface CommandViewer extends CommandSource {

    CommandViewer sendMessage(String message);
    CommandViewer sendMessagePlain(String message);

}
