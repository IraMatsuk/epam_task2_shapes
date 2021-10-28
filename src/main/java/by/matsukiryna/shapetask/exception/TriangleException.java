package by.matsukiryna.shapetask.exception;

public class TriangleException extends Exception {
    public TriangleException(){}

    public TriangleException(String message) {
        super(message);
    }

    public TriangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleException(Throwable cause) {
        super(cause);
    }

//    public ShapeException(String s, double x, double y, double z, double height, double radius) {
//    }
}
