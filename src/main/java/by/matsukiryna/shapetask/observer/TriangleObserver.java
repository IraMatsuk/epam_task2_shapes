package by.matsukiryna.shapetask.observer;

import by.matsukiryna.shapetask.exception.TriangleException;

public interface TriangleObserver {
    void updateParameters(TriangleEvent event) throws TriangleException;
}
