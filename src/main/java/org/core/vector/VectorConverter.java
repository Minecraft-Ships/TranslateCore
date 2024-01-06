package org.core.vector;

import java.math.BigDecimal;
import java.util.function.Function;

public interface VectorConverter {

    interface Specific<N extends Number, V extends Vector<N, ?>> extends VectorConverter {

        class AbstractSpecificWrapper<N extends Number, V extends Vector<N, ?>> implements Specific<N, V> {

            private final VectorConverter converter;
            private final Function<BigDecimal, N> function;

            public AbstractSpecificWrapper(VectorConverter converter, Function<BigDecimal, N> function) {
                this.converter = converter;
                this.function = function;
            }

            @Override
            public Function<BigDecimal, N> getConverter() {
                return this.function;
            }

            @Override
            public int getSize() {
                return this.converter.getSize();
            }

            @Override
            public <Num extends Number> Vector<Num, ?> createInstance(Function<BigDecimal, Num> function,
                                                                      BigDecimal... decimals) {
                return this.converter.createInstance(function, decimals);
            }
        }

        Function<BigDecimal, N> getConverter();

        default V convert(Vector<?, ?> vector) {
            return (V) this.convert(this.getConverter(), vector);
        }

    }

    int getSize();

    <N extends Number> Vector<N, ?> createInstance(Function<BigDecimal, N> function, BigDecimal... decimals);

    default <N extends Number> Vector<N, ?> convert(Function<BigDecimal, N> convert, Vector<?, ?> vector) {
        BigDecimal[] array = new BigDecimal[this.getSize()];
        int loop = Math.min(vector.getPointCount(), this.getSize());
        for (int index = 0; index < loop; index++) {
            array[index] = BigDecimal.valueOf(convert.apply(vector.points[index]).doubleValue());
        }
        for (int index = loop; index < vector.getPointCount(); index++) {
            array[index] = this.createDefaultValue();
        }
        return this.createInstance(convert, array);
    }

    default BigDecimal createDefaultValue() {
        return new BigDecimal(0);
    }
}
