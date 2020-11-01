package org.core.vector;

import java.math.BigDecimal;
import java.util.function.Function;

public interface VectorConverter {

    interface Specific <N extends Number, V extends Vector<N, ?>> extends VectorConverter {

        class AbstractSpecificWrapper<N extends Number, V extends Vector<N, ?>> implements Specific<N, V> {

            private VectorConverter converter;
            private Function<BigDecimal, N> function;

            public AbstractSpecificWrapper(VectorConverter converter, Function<BigDecimal, N> function){
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
            public <N extends Number> Vector<N, ?> createInstance(Function<BigDecimal, N> function, BigDecimal... decimals) {
                return this.converter.createInstance(function, decimals);
            }
        }

        Function<BigDecimal, N> getConverter();

        default V convert(Vector<?, ?> vector){
            return (V)convert(this.getConverter(), vector);
        }

    }

    int getSize();
    <N extends Number> Vector<N, ?> createInstance(Function<BigDecimal, N> function, BigDecimal... decimals);

    default <N extends Number> Vector<N, ?> convert(Function<BigDecimal, N> convert, Vector<?, ?> vector){
        BigDecimal[] array = new BigDecimal[this.getSize()];
        int loop = Math.min(vector.getPointCount(), this.getSize());
        for(int A = 0; A < loop; A++){
            array[A] = BigDecimal.valueOf(convert.apply(vector.points[A]).doubleValue());
        }
        for(int A = loop; A < vector.getPointCount(); A++){
            array[A] = this.createDefaultValue();
        }
        return this.createInstance(convert, array);
    }

    default BigDecimal createDefaultValue(){
        return new BigDecimal(0);
    }
}
