package by.matsukiryna.shapetask.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class CustomPoint {
    private double x;
    private double y;

    public CustomPoint() {}

    public CustomPoint(double x, double y) {
        this.x = x;
        this.y = y;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomPoint point = (CustomPoint) o;
        return Double.compare(point.x, x) == 0
                && Double.compare(point.y, y) == 0;
    }

    @Override
    //TODO without object methods
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomPoint.class.getSimpleName() + "[", "]")
                .add("x=" + x)
                .add("y=" + y)
                .toString();
    }
}
