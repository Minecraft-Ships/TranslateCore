package org.core.exceptions;

import org.core.utils.Identifiable;

import java.io.IOException;

public class BlockNotSupported extends IOException {

    public BlockNotSupported(Identifiable type, String what) {
        super(what + " is not supported with " + type.getId());
    }

}
