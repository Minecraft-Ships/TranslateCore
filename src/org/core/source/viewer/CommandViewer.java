package org.core.source.viewer;

import org.core.source.command.CommandSource;
import org.core.text.Text;

public interface CommandViewer extends CommandSource {

    CommandViewer sendMessage(Text message);
    CommandViewer sendMessagePlain(String message);

}
