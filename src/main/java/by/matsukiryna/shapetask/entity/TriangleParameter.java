package by.matsukiryna.shapetask.entity;

import java.util.StringJoiner;

public class TriangleParameter {
    private double perimeter;
    private double area;

    public TriangleParameter() {}

    public TriangleParameter(double perimeter, double square) {
        this.perimeter = perimeter;
        this.area = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return area;
    }

    public void setSquare(double square) {
        this.area = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriangleParameter that = (TriangleParameter) o;
        return Double.compare(that.perimeter, perimeter) == 0 && Double.compare(that.area, area) == 0;
    }

    @Override
    public int hashCode() {
        int result = 11;
        long longBits = Double.doubleToLongBits(this.area);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        longBits = Double.doubleToLongBits(this.perimeter);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TriangleParameter.class.getSimpleName() + "[", "]")
                .add("perimeter=" + perimeter)
                .add("square=" + area)
                .toString();
    }
}
