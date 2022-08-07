package org.core.utils.entry;

import org.core.utils.Identifiable;

public interface SnapshotValue<O, V> {

    boolean canApplyTo(Object obj);

    V getValue();

    SnapshotValue<O, V> setValue(V value);

    V storeValue(O obj);

    void applyValue(O obj);

    SnapshotValue<O, V> clone();

    interface IdentifySnapshotValue<O, V> extends SnapshotValue<O, V>, Identifiable {

    }
}
