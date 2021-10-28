package by.matsukiryna.shapetask.reader.impl;

import by.matsukiryna.shapetask.exception.TriangleException;
import by.matsukiryna.shapetask.reader.TriangleFileReader;

import by.matsukiryna.shapetask.validator.FileValidator;
import by.matsukiryna.shapetask.validator.TriangleStringValidator;
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
    public List<String> readDataFromFile(String filePath) throws TriangleException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(filePath);
        String strPath = new File(resource.getFile()).getPath();
        Path path = Paths.get(strPath);

        if (!FileValidator.isFileValidate(strPath)) {
            logger.error("File name is null or empty " + filePath);
            throw new TriangleException("File name is null or empty " + filePath);
        }

        List<String> lines;
        try (Stream<String> streamLines = Files.lines(path)) {
            lines = streamLines.filter(TriangleStringValidator::isLineValidate)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Error while reading file " + filePath, e.getMessage());
            throw new TriangleException("Error while reading file " + filePath + e.getMessage());
        }
        logger.info("File was read. Result: " + lines);
        return lines;
    }
}
