package org.core.utils.entry;

import org.core.utils.Identifable;

public interface SnapshotValue <O, V> {

    interface IdentifySnapshotValue<O, V> extends SnapshotValue<O, V>, Identifable {

    }

    boolean canApplyTo(Object obj);
    V getValue();
    V storeValue(O obj);
    SnapshotValue<O, V> setValue(V value);
    void applyValue(O obj);
    SnapshotValue<O, V> clone();
}
