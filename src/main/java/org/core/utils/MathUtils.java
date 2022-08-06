package org.core.utils;

import java.util.*;
import java.util.function.BiPredicate;

public interface MathUtils {

    static <N extends Number> N getMostCommonNumber(Collection<N> collection) {
        return getMostCommon((n, compare) -> n.doubleValue() == compare.doubleValue(), collection);
    }

    static <N> N getMostCommon(Collection<N> collection) {
        return getMostCommon(Object::equals, collection);
    }

    static <N> N getMostCommon(BiPredicate<N, N> compare, Collection<N> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Collection cannot be empty");
        }
        if (collection.size() == 1) {
            return collection.iterator().next();
        }
        TreeSet<Map.Entry<N, Integer>> counts = new TreeSet<>(Comparator.comparingInt(Map.Entry::getValue));
        for (N value : collection) {
            Optional<Map.Entry<N, Integer>> opEntry = counts.parallelStream().filter(entry -> compare.test(value, entry.getKey())).findAny();
            if (opEntry.isPresent()) {
                opEntry.get().setValue(opEntry.get().getValue() + 1);
                continue;
            }
            counts.add(new AbstractMap.SimpleEntry<>(value, 1));
        }

        return counts.first().getKey();
    }

    static double getAverage(Collection<? extends Number> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Collection cannot be empty");
        }
        double total = collection.parallelStream().mapToDouble(Number::doubleValue).sum();
        return total / collection.size();
    }
}
