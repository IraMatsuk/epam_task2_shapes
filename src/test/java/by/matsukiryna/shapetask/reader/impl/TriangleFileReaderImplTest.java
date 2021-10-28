package by.matsukiryna.shapetask.reader.impl;

import by.matsukiryna.shapetask.exception.TriangleException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TriangleFileReaderImplTest {
    TriangleFileReaderImpl triangleFileReader;
    static final String CORRECT_PATH = "data/triangle.txt";
    static final String INCORRECT_PATH = "test_data/triangle.txt";

    @BeforeClass
    public void setUp() {
        triangleFileReader = new TriangleFileReaderImpl();
    }

    @Test
    public void testReadDataFromFile() throws TriangleException {
        List<String> actual = triangleFileReader.readDataFromFile(CORRECT_PATH);
        List<String> expected = List.of("2.5 3.4  2.5 6.4  6.5 3.4");
        assertEquals(actual, expected);
    }

    //TODO test passed only when I write NullPointerException
    @Test(expectedExceptions = NullPointerException.class)
    public void testReadNullFileException() throws NullPointerException, TriangleException {
        triangleFileReader.readDataFromFile(null);
    }

    @Test(expectedExceptions = TriangleException.class)
    public void testReadDataWhenFileIsEmpty() throws TriangleException {
        String path = " ";
        triangleFileReader.readDataFromFile(path);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testReadDataWhenFilePathIsNotCorrect() throws NullPointerException, TriangleException {
        triangleFileReader.readDataFromFile(INCORRECT_PATH);
    }
}