package net.chandol.study.oop.infra;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class Registrar {
    private static final Map<Class<? extends EntryPoint>, Map<String, EntryPoint>> entryPoints;

    static {
        entryPoints = new HashMap<>();
    }

    public static <T extends EntryPoint> void add(EntryPoint newObject, Class<T> type) {
        if (!entryPoints.containsKey(type))
            entryPoints.put(type, new HashMap<>());

        entryPoints.get(type).put(newObject.getId(), newObject);
    }

    public static <T extends EntryPoint> T get(String identity, Class<T> type) {
        EntryPoint entryPoint = entryPoints.get(type).get(identity);

        return type.cast(entryPoint);
    }

    public static <T extends EntryPoint> Set<T> getAll(Class<T> type) {
        if (entryPoints.containsKey(type)) {
            Set<T> result = entryPoints.get(type).entrySet().stream()
                    .map(m -> type.cast(m.getValue()))
                    .collect(toSet());

            return Collections.unmodifiableSet(result);
        } else {
            return Collections.unmodifiableSet(new HashSet<T>());
        }
    }

}
