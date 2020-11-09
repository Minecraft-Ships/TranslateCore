package org.core.config.parser.parsers;

import org.core.config.parser.Parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class MappedParser<K, V> implements Parser<K, V> {



    private Map<K, V> map;
    private BiPredicate<V, V> equals;

    public MappedParser(Map<K, V> map){
        this(map, (Object::equals));
    }

    public MappedParser(Map<K, V> map, BiPredicate<V, V> equals) {
        this.map = map;
        this.equals = equals;
    }
    @Override
    public Optional<V> parse(K original) {
        return Optional.ofNullable(map.get(original));
    }

    @Override
    public K unparse(V value) {
        Optional<Map.Entry<K, V>> opValue = this.map.entrySet().parallelStream().filter(k -> this.equals.test(k.getValue(), value)).findFirst();
        return opValue.map(Map.Entry::getKey).orElse(null);
    }
}
