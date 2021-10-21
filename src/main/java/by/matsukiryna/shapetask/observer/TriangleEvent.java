package by.matsukiryna.shapetask.observer;

import by.matsukiryna.shapetask.entity.Triangle;

import java.util.EventObject;

public class TriangleEvent extends EventObject {
    /**
     * Construct a prototypical Event
     *
     * @param source the object on which the Event initially occured
     * @throws IllegalArgumentException if source is null
     */
    public TriangleEvent(Triangle source) {
        super(source);
    }

    @Override
    public Triangle getSource() {
        return (Triangle) super.getSource();
    }
}
