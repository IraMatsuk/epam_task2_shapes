package by.matsukiryna.shapetask.reader.impl;

import by.matsukiryna.shapetask.exception.ShapeException;
import by.matsukiryna.shapetask.reader.TriangleFileReader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriangleFileReaderImpl implements TriangleFileReader {
    static final Logger logger = LogManager.getLogger();

    public TriangleFileReaderImpl() {
    }

    @Override
    public List<String> readDataFromFile(String filePath) throws ShapeException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(filePath);
        String strPath = new File(resource.getFile()).getPath();
        Path path = Paths.get(strPath);
        List<String> lines;

        if (filePath == null || filePath.isBlank()) {
            throw new ShapeException("File name is null or empty " + filePath);
        }

        try (Stream<String> streamLines = Files.lines(path)) {
            lines = streamLines.peek(line -> logger.info(line))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Error while reading file " + filePath, e.getMessage());
            throw new ShapeException("Error while reading file " + filePath);
        }
        return lines;
    }
}
