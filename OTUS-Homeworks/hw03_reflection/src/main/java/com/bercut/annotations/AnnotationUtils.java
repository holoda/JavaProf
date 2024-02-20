package com.bercut.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnotationUtils {
    public static List<Method> getMethodByAnnotations(Class<?> cls, Class<?> type) {
        List<Method> result = new ArrayList<>();
        for (Method m : cls.getDeclaredMethods()) {
            for (Annotation a : m.getAnnotations()) {
                if (a.annotationType().equals(type)) {
                    result.add(m);
                }
            }
        }

        return result;

    }

    public static boolean checkTestClass(Class<?> cls) {
        for (Method m : cls.getDeclaredMethods()) {
            int annCnt = 0;
            for (Annotation a : m.getAnnotations()) {
                if (a.annotationType().equals(After.class) ||
                        a.annotationType().equals(Before.class) ||
                        a.annotationType().equals(Test.class))
                    annCnt++;
            }
            if (annCnt > 1) return false;
        }
        return true;
    }
}
