package org.core.vector.type;

import org.core.vector.Vector;
import org.core.vector.VectorConverter;

import java.math.BigDecimal;
import java.util.function.Function;

public class Vector3<N extends Number> extends Vector<N, Vector3<N>> {

    public static final VectorConverter GENERAL_CONVERTER = new VectorConverter() {

        @Override
        public int getSize() {
            return 3;
        }

        @Override
        public <Num extends Number> Vector<Num, ?> createInstance(Function<BigDecimal, Num> function, BigDecimal... decimals) {
            return new Vector3<>(function, decimals);
        }
    };

    public static final VectorConverter.Specific<Integer, Vector3<Integer>> INT_CONVERTER = new VectorConverter.Specific.AbstractSpecificWrapper<>(GENERAL_CONVERTER, BigDecimal::intValue);
    public static final VectorConverter.Specific<Double, Vector3<Double>> DOUBLE_CONVERTER = new VectorConverter.Specific.AbstractSpecificWrapper<>(GENERAL_CONVERTER, BigDecimal::doubleValue);


    private Vector3(Function<BigDecimal, N> function, BigDecimal... points) {
        super(function, points);
    }

    public Vector3(Function<BigDecimal, N> function, BigDecimal x, BigDecimal y, BigDecimal z){
        super(function, x, y, z);
    }

    @Override
    protected Vector3<N> createNew(BigDecimal... values) {
        return new Vector3<>(this.toNumber, values[0], values[1], values[2]);
    }

    @Override
    public <Num extends Number> Vector3<Num> toVector(Function<BigDecimal, Num> function) {
        return new Vector3<>(function, this.points);
    }

    public N getX(){
        return this.getPoint(0);
    }

    public N getY(){
        return this.getPoint(1);
    }

    public N getZ(){
        return this.getPoint(2);
    }

    public BigDecimal getRawX(){
        return this.getRawPoint(0);
    }

    public BigDecimal getRawY(){
        return this.getRawPoint(1);
    }

    public BigDecimal getRawZ(){
        return this.getRawPoint(2);
    }

    public Vector3<N> plus(Number x, Number y, Number z){
        return this.plus(this.createNew(BigDecimal.valueOf(x.doubleValue()), BigDecimal.valueOf(y.doubleValue()), BigDecimal.valueOf(z.doubleValue())));
    }

    public Vector3<N> minus(Number x, Number y, Number z){
        return this.minus(this.createNew(BigDecimal.valueOf(x.doubleValue()), BigDecimal.valueOf(y.doubleValue()), BigDecimal.valueOf(z.doubleValue())));
    }

    public double distanceSquared(Vector3<?> vector){
        final BigDecimal dx = this.getRawX().subtract(vector.getRawX());
        final BigDecimal dy = this.getRawY().subtract(vector.getRawY());
        final BigDecimal dz = this.getRawZ().subtract(vector.getRawZ());

        return dx.doubleValue() * dx.doubleValue() + dy.doubleValue() * dy.doubleValue() + dz.doubleValue() * dz.doubleValue();
    }

    public double distanceSquared(Number x, Number y, Number z){
        return distanceSquared(this.createNew(BigDecimal.valueOf(x.doubleValue()), BigDecimal.valueOf(y.doubleValue()), BigDecimal.valueOf(z.doubleValue())));
    }

    @Override
    public String toString() {
        return "Vector3{X: " + this.getRawX().toPlainString() + ", Y: " + this.getRawY().toPlainString() + ", Z: " + this.getRawZ().toPlainString() + "}";
    }

    public static Vector3<Double> valueOf(double x, double y, double z){
        return new Vector3<>(BigDecimal::doubleValue, BigDecimal.valueOf(x), BigDecimal.valueOf(y), BigDecimal.valueOf(z));
    }

    public static Vector3<Integer> valueOf(int x, int y, int z){
        return new Vector3<>(BigDecimal::intValue, BigDecimal.valueOf(x), BigDecimal.valueOf(y), BigDecimal.valueOf(z));
    }


}
