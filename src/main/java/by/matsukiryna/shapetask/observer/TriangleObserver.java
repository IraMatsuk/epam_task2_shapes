package by.matsukiryna.shapetask.observer;

import by.matsukiryna.shapetask.exception.ShapeException;

public interface TriangleObserver {
    void updateParameters(TriangleEvent event) throws ShapeException;
}
