package by.matsukiryna.shapetask.repository.impl;

import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.repository.TriangleRepository;
import by.matsukiryna.shapetask.repository.TriangleSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepositoryImpl implements TriangleRepository {
    static final Logger logger = LogManager.getLogger();
    private static TriangleRepositoryImpl instance;
    private List<Triangle> triangles;

    public TriangleRepositoryImpl() {
        triangles = new ArrayList<>();
    }

    public List<Triangle> getTriangles() {
        return List.copyOf(triangles);
    }

    public Triangle get(int index) {
        return triangles.get(index);
    }

    public int size() {
        return triangles.size();
    }

    public int indexOf(Triangle triangle) {
        return triangles.indexOf(triangle);
    }

    public static TriangleRepository getInstance() {
        if (instance == null) {
            instance = new TriangleRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void add(Triangle triangle) {
        triangles.add(triangle);
    }

    @Override
    public boolean addAll(List<Triangle> triangleList) {
        return triangles.addAll(triangleList);
    }

    @Override
    public Triangle remove(int index) {
        return triangles.remove(index);
    }

    @Override
    public List<Triangle> query(TriangleSpecification specification) {
        List<Triangle> result = triangles.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
        logger.info("Query by specification " + specification + ": " + result);
        return result;
    }

    @Override
    public List<Triangle> sort(Comparator<? super Triangle> comparator) {
        List<Triangle> result = triangles.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        logger.info("Sorted with comparator " + comparator + ": " + result);
        return result;
    }
}
