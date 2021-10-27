package by.matsukiryna.shapetask.exception;

public class ShapeException extends Exception {
    public ShapeException(){}

    public ShapeException(String message) {
        super(message);
    }

    public ShapeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShapeException(Throwable cause) {
        super(cause);
    }

//    public ShapeException(String s, double x, double y, double z, double height, double radius) {
//    }
}
