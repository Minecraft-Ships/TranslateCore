package org.core.vector;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Vector<N extends Number, VSelf extends Vector<N, ?>> {

    protected final BigDecimal[] points;
    protected final Function<BigDecimal, N> toNumber;

    public Vector(Function<BigDecimal, N> function, BigDecimal... points) {
        this.points = points;
        this.toNumber = function;
    }

    protected abstract VSelf createNew(BigDecimal... values);

    public abstract <Num extends Number> Vector<Num, ?> toVector(Function<BigDecimal, Num> function);

    private VSelf action(VSelf vector,
                         BiFunction<? super BigDecimal, ? super BigDecimal, ? extends BigDecimal> function) {
        BigDecimal[] array = new BigDecimal[this.points.length];
        for (int index = 0; index < this.points.length; index++) {
            array[index] = function.apply(this.points[index], vector.getRawPoint(index));
        }
        return this.createNew(array);
    }

    public VSelf plus(VSelf vector) {
        return this.action(vector, BigDecimal::add);
    }

    public VSelf minus(VSelf vector) {
        return this.action(vector, BigDecimal::subtract);
    }

    public VSelf divide(VSelf vector, RoundingMode mode) {
        return this.action(vector, (b, v) -> b.divide(v, mode));
    }

    public VSelf divide(BigDecimal amount, RoundingMode mode) {
        BigDecimal[] array = new BigDecimal[this.points.length];
        for (int index = 0; index < this.points.length; index++) {
            array[index] = this.points[index].divide(amount, mode);
        }
        return this.createNew(array);
    }

    public VSelf multiply(VSelf vector) {
        return this.action(vector, BigDecimal::multiply);
    }

    public VSelf multiply(BigDecimal amount) {
        BigDecimal[] array = new BigDecimal[this.points.length];
        for (int index = 0; index < this.points.length; index++) {
            array[index] = this.points[index].multiply(amount);
        }
        return this.createNew(array);
    }

    public VSelf multiply(Number number) {
        return this.multiply(BigDecimal.valueOf(number.doubleValue()));
    }

    public <Num extends Number, C extends Vector<Num, ?>> C toVector(VectorConverter.Specific<Num, C> converter) {
        return converter.convert(this);
    }

    public <Num extends Number, C extends Vector<Num, ?>> C toVector(Function<BigDecimal, Num> function,
                                                                     VectorConverter converter) {
        return (C) converter.convert(function, this);
    }

    public N getPoint(int index) {
        return this.toNumber.apply(this.getRawPoint(index));
    }

    public BigDecimal getRawPoint(int index) {
        return this.points[index];
    }

    public int getPointCount() {
        return this.points.length;
    }

    @Override
    public int hashCode() {
        double check = 0;
        for (BigDecimal big : this.points) {
            check = check + big.doubleValue();
        }
        return Integer.parseInt(String.valueOf(check).replaceAll("\\.", ""));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector<?, ?>)) {
            return false;
        }
        Vector<?, ?> vector = (Vector<?, ?>) obj;
        if (vector.getPointCount() != this.getPointCount()) {
            return false;
        }
        for (int index = 0; index < this.getPointCount(); index++) {
            if (this.getRawPoint(index).doubleValue() != vector.getRawPoint(index).doubleValue()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + Arrays
                .stream(this.points)
                .map(BigDecimal::toPlainString)
                .collect(Collectors.joining(", ")) + "}";
    }
}
