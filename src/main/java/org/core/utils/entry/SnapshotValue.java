package org.core.utils.entry;

import org.core.utils.Identifiable;

public interface SnapshotValue <O, V> {

    interface IdentifySnapshotValue<O, V> extends SnapshotValue<O, V>, Identifiable {

    }

    boolean canApplyTo(Object obj);
    V getValue();
    V storeValue(O obj);
    SnapshotValue<O, V> setValue(V value);
    void applyValue(O obj);
    SnapshotValue<O, V> clone();
}
