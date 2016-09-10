package net.chandol.study.common;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Registrar {
    private static Registrar soleInstance = new Registrar();
    private Map<Class<?>, Map<String, EntryPoint>> entryPoints =
            new HashMap<Class<?>, Map<String, EntryPoint>>();

    public static void init() {
        soleInstance.entryPoints =
                new HashMap<Class<?>, Map<String, EntryPoint>>();
    }

    public static void add(Class<?> entryPointClass, EntryPoint newObject) {
        soleInstance.addObj(entryPointClass, newObject);
    }

    public static EntryPoint get(Class<?> entryPointClass, String objectName) {
        return soleInstance.getObj(entryPointClass, objectName);
    }

    public static Collection<? extends EntryPoint> getAll(
            Class<?> entryPointClass) {
        return soleInstance.getAllObjects(entryPointClass);
    }

    private void addObj(Class<?> entryPointClass, EntryPoint newObject) {
        Map<String, EntryPoint> theEntryPoint =
                entryPoints.get(entryPointClass);
        if (theEntryPoint == null) {
            theEntryPoint = new HashMap<String, EntryPoint>();
            entryPoints.put(entryPointClass, theEntryPoint);
        }

        theEntryPoint.put(newObject.getIdentity(), newObject);
    }

    private EntryPoint getObj(Class<?> entryPointClass, String objectName) {
        Map<String, EntryPoint> theEntryPoint =
                entryPoints.get(entryPointClass);
        return theEntryPoint.get(objectName);
    }

    @SuppressWarnings("unchecked")
    private Collection<? extends EntryPoint> getAllObjects(
            Class<?> entryPointClass) {
        Map<String, EntryPoint> foundEntryPoints =
                entryPoints.get(entryPointClass);

        return (Collection<? extends EntryPoint>)
                Collections.unmodifiableCollection(foundEntryPoints != null ?
                        entryPoints.get(entryPointClass).values() :
                        Collections.EMPTY_SET);
    }
}