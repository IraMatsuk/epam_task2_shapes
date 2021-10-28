package by.matsukiryna.shapetask.observer;

import by.matsukiryna.shapetask.exception.TriangleException;

public interface TriangleObservable {
    void attach(TriangleObserver observer);

    void detach(TriangleObserver observer);

    void notifyObservers() throws TriangleException;
}
