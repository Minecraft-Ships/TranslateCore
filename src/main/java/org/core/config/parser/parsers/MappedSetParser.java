package org.core.config.parser.parsers;

import org.core.config.parser.Parser;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.function.Function;

public class MappedSetParser<T, V> implements Parser<T, V> {

    private final Collection<V> values = new HashSet<>();
    private final Function<? super V, ? extends T> toKey;

    public MappedSetParser(Function<? super V, ? extends T> function, Collection<V> values) {
        this.values.addAll(values);
        this.toKey = function;
    }

    @Override
    public Optional<V> parse(T original) {
        return this.values.stream().filter(v -> this.toKey.apply(v).equals(original)).findFirst();
    }

    @Override
    public T unparse(V value) {
        return this.toKey.apply(value);
    }
}
