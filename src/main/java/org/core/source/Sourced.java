package org.core.source;

import java.util.Optional;

public interface Sourced <S extends Source> {

    Optional<S> getSource();
}
