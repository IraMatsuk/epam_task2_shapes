package by.matsukiryna.shapetask.parser.impl;

import by.matsukiryna.shapetask.parser.TriangleParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class TriangleParserImpl implements TriangleParser {
    static final Logger logger = LogManager.getLogger();
    private static final String REGEX_DELIMITER= "\\s+";

    @Override
    public double[] parseLine(String line) {
        String[] strDoubles = line.split(REGEX_DELIMITER);
        double[] result = Arrays.stream(strDoubles)
                                .mapToDouble(Double::parseDouble)
                                .toArray();
        logger.info("Result of parsing line: " + Arrays.toString(result));
        return result;
    }
}
