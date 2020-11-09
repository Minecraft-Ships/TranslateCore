package org.core.vector.type;

import org.core.vector.Vector;
import org.core.vector.VectorConverter;

import java.math.BigDecimal;
import java.util.function.Function;

public class Vector2 <N extends Number> extends Vector<N, Vector2<N>> {

    public static final VectorConverter GENERAL_CONVERTER = new VectorConverter() {

        @Override
        public int getSize() {
            return 2;
        }

        @Override
        public <Num extends Number> Vector<Num, ?> createInstance(Function<BigDecimal, Num> function, BigDecimal... decimals) {
            return new Vector2<>(function, decimals);
        }
    };

    public static final VectorConverter.Specific<Integer, Vector2<Integer>> INT_CONVERTER = new VectorConverter.Specific.AbstractSpecificWrapper<>(GENERAL_CONVERTER, BigDecimal::intValue);
    public static final VectorConverter.Specific<Double, Vector2<Double>> DOUBLE_CONVERTER = new VectorConverter.Specific.AbstractSpecificWrapper<>(GENERAL_CONVERTER, BigDecimal::doubleValue);

    private Vector2(Function<BigDecimal, N> function, BigDecimal... points) {
        super(function, points);
    }

    public Vector2(Function<BigDecimal, N> function, BigDecimal x, BigDecimal z){
        super(function, x, z);
    }

    @Override
    protected Vector2<N> createNew(BigDecimal... values) {
        return new Vector2<>(this.toNumber, values[0], values[1]);
    }

    @Override
    public <Num extends Number> Vector2<Num> toVector(Function<BigDecimal, Num> function) {
        return new Vector2<>(function, this.points);
    }

    public N getX(){
        return this.getPoint(0);
    }

    public N getZ(){
        return this.getPoint(1);
    }

    public BigDecimal getRawX(){
        return this.getRawPoint(0);
    }

    public BigDecimal getRawZ(){
        return this.getRawPoint(1);
    }

    public Vector2<N> plus(N x, N z){
        return this.plus(this.createNew(BigDecimal.valueOf(x.doubleValue()), BigDecimal.valueOf(z.doubleValue())));
    }

    public Vector2<N> plus(Vector2<Integer> vector){
        return this.plus(this.toNumber.apply(vector.getRawPoint(0)), this.toNumber.apply(vector.getRawPoint(1)));
    }

    public Vector2<N> minus(N x, N z){
        return this.minus(this.createNew(BigDecimal.valueOf(x.doubleValue()), BigDecimal.valueOf(z.doubleValue())));
    }

    public Vector2<N> minus(Vector2<Integer> vector){
        return this.minus(this.toNumber.apply(vector.getRawPoint(0)), this.toNumber.apply(vector.getRawPoint(1)));
    }

    @Override
    public String toString() {
        return "Vector3{X: " + this.getRawX().toPlainString() + ", Z: " + this.getRawZ().toPlainString() + "}";
    }

    public static Vector2<Double> valueOf(double x, double z){
        return new Vector2<>(BigDecimal::doubleValue, BigDecimal.valueOf(x), BigDecimal.valueOf(z));
    }

    public static Vector2<Integer> valueOf(int x, int z){
        return new Vector2<>(BigDecimal::intValue, BigDecimal.valueOf(x), BigDecimal.valueOf(z));
    }
}
