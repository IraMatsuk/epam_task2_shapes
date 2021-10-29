package by.matsukiryna.shapetask.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Warehouse {
    private static Warehouse instance;
    private final Map<Integer, TriangleParameter> parameterMap = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void put(int id, TriangleParameter parameter) {
        instance.parameterMap.put(id, parameter);
    }

    public Optional<TriangleParameter> get(int id) {
        Optional<TriangleParameter> parameter = Optional.ofNullable(instance.parameterMap.get(id));
        return parameter;
    }

    public TriangleParameter remove(int id) {
        return parameterMap.remove(id);
    }

    public Map<Integer, TriangleParameter> getParameterMap() {
        return Map.copyOf(parameterMap);
    }
}
