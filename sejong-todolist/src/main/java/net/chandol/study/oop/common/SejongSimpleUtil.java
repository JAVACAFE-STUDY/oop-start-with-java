package net.chandol.study.oop.common;

import java.util.Collections;
import java.util.List;

public final class SejongSimpleUtil {

    public static boolean not(boolean expression) {
        return !expression;
    }

    public static <T> List<T> asNullSafeList(List<T> result) {
        if (result == null)
            return Collections.emptyList();
        else
            return result;
    }
}
