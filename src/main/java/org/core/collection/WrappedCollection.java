package org.core.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;

public interface WrappedCollection<E> extends Collection<E> {

    Collection<E> getWrappedCollection();

    @Deprecated
    default boolean addAll() {
        throw new RuntimeException("addAll requires at least one result");
    }

    default boolean addAll(E... values) {
        return this.getWrappedCollection().addAll(Arrays.asList(values));
    }

    @Deprecated
    default boolean removeAll() {
        throw new RuntimeException("removeAll requires at least one result");
    }

    default boolean removeAll(Object... values) {
        return this.getWrappedCollection().removeAll(Arrays.asList(values));
    }

    default boolean contains(boolean parallel, Predicate<E> equals) {
        Stream<E> stream = parallel ? this.parallelStream() : this.stream();
        return stream.anyMatch(equals);
    }

    default <T, A, C extends Collection<T>, R extends Collector<? super T, A, C>> C map(boolean parallel, Function<E, T> function, R collector) {
        Stream<E> stream = parallel ? this.parallelStream() : this.stream();
        return stream.map(function).collect(collector);
    }

    default <T, A, C extends Collection<T>, R extends Collector<? super T, A, C>> C cast(boolean parallel, Class<T> clazz, R collector) {
        Stream<E> stream = parallel ? this.parallelStream() : this.stream();
        return stream.filter(clazz::isInstance).map(r -> (T) r).collect(collector);
    }

    //OVERRIDES


    @Override
    default int size() {
        return this.getWrappedCollection().size();
    }

    @Override
    default boolean isEmpty() {
        return this.getWrappedCollection().isEmpty();
    }

    @Override
    default boolean contains(Object o) {
        return this.getWrappedCollection().contains(o);
    }

    @NotNull
    @Override
    default Iterator<E> iterator() {
        return this.getWrappedCollection().iterator();
    }

    @NotNull
    @Override
    default Object[] toArray() {
        return this.getWrappedCollection().toArray();
    }

    @NotNull
    @Override
    default <T> T[] toArray(@NotNull T[] a) {
        return this.getWrappedCollection().toArray(a);
    }

    @Override
    default boolean add(E e) {
        return this.getWrappedCollection().add(e);
    }

    @Override
    default boolean remove(Object o) {
        return this.getWrappedCollection().remove(o);
    }

    @Override
    default boolean containsAll(@NotNull Collection<?> c) {
        return this.getWrappedCollection().containsAll(c);
    }

    @Override
    default boolean addAll(@NotNull Collection<? extends E> c) {
        return this.getWrappedCollection().addAll(c);
    }

    @Override
    default boolean removeAll(@NotNull Collection<?> c) {
        return this.getWrappedCollection().removeAll(c);
    }

    @Override
    default boolean retainAll(@NotNull Collection<?> c) {
        return this.getWrappedCollection().retainAll(c);
    }

    @Override
    default void clear() {
        this.getWrappedCollection().clear();
    }

    @Override
    default boolean removeIf(Predicate<? super E> filter) {
        return this.getWrappedCollection().removeIf(filter);
    }

    @Override
    default Spliterator<E> spliterator() {
        return this.getWrappedCollection().spliterator();
    }

    @Override
    default Stream<E> stream() {
        return this.getWrappedCollection().stream();
    }

    @Override
    default Stream<E> parallelStream() {
        return this.getWrappedCollection().parallelStream();
    }

    @Override
    default void forEach(Consumer<? super E> action) {
        this.getWrappedCollection().forEach(action);
    }
}
