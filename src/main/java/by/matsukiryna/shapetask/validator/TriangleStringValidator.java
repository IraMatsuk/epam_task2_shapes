package by.matsukiryna.shapetask.validator;

public class TriangleStringValidator {
    private static final String VALID_TRIANGLE_DATA_REGEX = "^-?\\d+(\\.\\d+)?(\\s+-?\\d+(\\.\\d+)?){5}$";

    public static boolean isLineValidate(String line) {
        return line.matches(VALID_TRIANGLE_DATA_REGEX);
    }
}
