package by.matsukiryna.shapetask.comparator;

import by.matsukiryna.shapetask.entity.Triangle;

import java.util.Comparator;

public class TriangleIdComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        int result = Long.compare(o1.getTriangleId(), o2.getTriangleId());
        return result;
    }
}
