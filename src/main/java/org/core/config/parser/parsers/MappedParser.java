package org.core.config.parser.parsers;

import org.core.config.parser.Parser;

import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;

public class MappedParser<K, V> implements Parser<K, V> {

    private final Map<K, V> map;
    private final BiPredicate<? super V, ? super V> equals;

    public MappedParser(Map<K, V> map) {
        this(map, (Object::equals));
    }

    public MappedParser(Map<K, V> map, BiPredicate<? super V, ? super V> equals) {
        this.map = map;
        this.equals = equals;
    }

    @Override
    public Optional<V> parse(K original) {
        return Optional.ofNullable(this.map.get(original));
    }

    @Override
    public K unparse(V value) {
        Optional<Map.Entry<K, V>> opValue = this
                .map
                .entrySet()
                .parallelStream()
                .filter(k -> this.equals.test(k.getValue(), value))
                .findFirst();
        return opValue.map(Map.Entry::getKey).orElse(null);
    }
}
