package org.core.vector;

import org.core.vector.types.Vector3Int;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public interface Vector3<N extends Number>{

    public N getX();
    public N getY();
    public N getZ();
    public Vector3<N> add(Vector3<N> vector);
    public Vector3<N> add(Vector3Int vector);
    public Vector3<N> minus(Vector3<N> vector);
    public Vector3<N> devide(BigDecimal amount);
    public Vector3<N> multiply(BigDecimal amount);
    public BigDecimal getRawX();
    public BigDecimal getRawY();
    public BigDecimal getRawZ();

    default <E extends Number> Vector3<E> to(Class<? extends Vector3<E>> class1){
        try {
            return class1.getConstructor(BigDecimal.class, BigDecimal.class, BigDecimal.class).newInstance(getRawX(), getRawY(), getRawZ());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    default Vector3<N> multiply(double value){
        return this.multiply(new BigDecimal(value));
    }

    default Vector3<N> devide(double value){
        return this.devide(new BigDecimal(value));
    }
}
