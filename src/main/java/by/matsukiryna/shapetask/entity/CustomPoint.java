package by.matsukiryna.shapetask.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class CustomPoint {
    private double x;
    private double y;
    private double z;
    private double v;
    private double v1;

    public CustomPoint() {}

    public CustomPoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public CustomPoint(double v, double v1) {
        this.v = v;
        this.v1 = v1;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getV() { return v; }

    public void setV(double v) { this.v = v; }

    public double getV1() { return v1; }

    public void setV1(double v1) { this.v1 = v1; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomPoint point = (CustomPoint) o;
        return Double.compare(point.x, x) == 0
                && Double.compare(point.y, y) == 0
                && Double.compare(point.z, z) == 0;
    }

    @Override
    //TODO without object methods
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomPoint.class.getSimpleName() + "[", "]")
                .add("x=" + x)
                .add("y=" + y)
                .add("z=" + z)
                .toString();
    }
}
