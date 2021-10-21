package by.matsukiryna.shapetask.entity;

import by.matsukiryna.shapetask.exception.ShapeException;
import by.matsukiryna.shapetask.observer.TriangleEvent;
import by.matsukiryna.shapetask.observer.TriangleObservable;
import by.matsukiryna.shapetask.observer.TriangleObserver;
import by.matsukiryna.shapetask.util.IdGenerator;
import by.matsukiryna.shapetask.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Triangle implements TriangleObservable {
    static final Logger logger = LogManager.getLogger();
    private int triangleId;
    private CustomPoint pointA;
    private CustomPoint pointB;
    private CustomPoint pointC;
    private TriangleObserver triangleObserver;
    private List<TriangleObserver> observers = new ArrayList<>();

    public Triangle(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC) throws ShapeException {
        if (!TriangleValidator.isTriangleValid(pointA, pointB, pointC)) {
            throw new ShapeException("Invalid points for triangle" + pointA + " " + pointB + " " + pointC);
        }
        this.triangleId = IdGenerator.generateId();
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public int getTriangleId() {
        return triangleId;
    }

    public CustomPoint getPointA() {
        return pointA;
    }

    public void setPointA(CustomPoint pointA) throws ShapeException {
        this.pointA = pointA;
        notifyObservers();
    }

    public CustomPoint getPointB() {
        return pointB;
    }

    public void setPointB(CustomPoint pointB) throws ShapeException {
        this.pointB = pointB;
        notifyObservers();
    }

    public CustomPoint getPointC() {
        return pointC;
    }

    public void setPointC(CustomPoint pointC) throws ShapeException {
        this.pointC = pointC;
        notifyObservers();
    }

    @Override
    public void attach(TriangleObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(TriangleObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() throws ShapeException {
        if (observers == null) {
            logger.info("TriangleObserver is null");
            return;
        }
        TriangleEvent triangleEvent = new TriangleEvent(this);
        triangleObserver.updateParameters(triangleEvent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return pointA.equals(triangle.pointA) && pointB.equals(triangle.pointB) && pointC.equals(triangle.pointC);
    }

    @Override
    public int hashCode() {
        int result = pointA != null ? pointA.hashCode() : 0;
        result = 31 * result + (pointB != null ? pointB.hashCode() : 0);
        result = 31 * result + (pointC != null ? pointC.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Triangle.class.getSimpleName() + "[", "]")
                .add("pointA=" + pointA)
                .add("pointB=" + pointB)
                .add("pointC=" + pointC)
                .toString();
    }
}
