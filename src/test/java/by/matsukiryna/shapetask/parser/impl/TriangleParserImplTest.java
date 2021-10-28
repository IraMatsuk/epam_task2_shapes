package by.matsukiryna.shapetask.parser.impl;

import by.matsukiryna.shapetask.exception.TriangleException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TriangleParserImplTest {
    TriangleParserImpl triangleParser;

    @BeforeClass
    public void setUp() {
        triangleParser = new TriangleParserImpl();
    }

    @Test
    public void testParseLineToArray() throws TriangleException {
        TriangleParserImpl triangleParser = new TriangleParserImpl();
        List<String> data = List.of("2.5 3.4  2.5 6.4  6.5 3.4");
        double[] actual = triangleParser.parseLine(data);
        double[] expected = {2.5, 3.4, 2.5, 6.4, 6.5, 3.4};
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = TriangleException.class)
    public void testParseEmptyListToArray() throws TriangleException {
        List<String> data = new ArrayList<>();
        triangleParser.parseLine(data);
    }
}