package org.core.vector;

import org.core.vector.types.Vector3Int;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public interface Vector3<N extends Number>{

    N getX();
    N getY();
    N getZ();
    Vector3<N> add(Vector3<N> vector);
    Vector3<N> add(Vector3Int vector);
    Vector3<N> minus(Vector3<N> vector);
    Vector3<N> devide(BigDecimal amount);
    Vector3<N> multiply(BigDecimal amount);
    BigDecimal getRawX();
    BigDecimal getRawY();
    BigDecimal getRawZ();

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

    default double distanceSquared(Vector3<? extends Number> vector3){
        double x = this.getRawX().doubleValue() - vector3.getRawX().doubleValue();
        double y = this.getRawY().doubleValue() - vector3.getRawY().doubleValue();
        double z = this.getRawZ().doubleValue() - vector3.getRawZ().doubleValue();
        return x * x + y * y + z * z;
    }

    default double distance(Vector3<? extends Number> vector3){
        return Math.sqrt(distanceSquared(vector3));
    }

    default Vector3<N> multiply(double value){
        return this.multiply(new BigDecimal(value));
    }

    default Vector3<N> devide(double value){
        return this.devide(new BigDecimal(value));
    }
}
