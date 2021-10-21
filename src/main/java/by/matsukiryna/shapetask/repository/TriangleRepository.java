package by.matsukiryna.shapetask.repository;

import by.matsukiryna.shapetask.entity.Triangle;

import java.util.Comparator;
import java.util.List;

public interface TriangleRepository {
    void add(Triangle triangle);

    Triangle remove(int index);

    List<Triangle> query(TriangleSpecification specification);

    List<Triangle> sort(Comparator<? super Triangle> comparator);
}
