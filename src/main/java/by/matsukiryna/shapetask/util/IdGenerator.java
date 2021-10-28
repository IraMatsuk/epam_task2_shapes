package by.matsukiryna.shapetask.util;

public class IdGenerator {
    private static int idCounter;

    private IdGenerator() {
    }

    public static int generateId() {
        return ++idCounter;
    }
}
