package com.bercut;

import com.bercut.annotations.After;
import com.bercut.annotations.AnnotationUtils;
import com.bercut.annotations.Before;
import com.bercut.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.println("Start!");

        try {
            runAllTests("com.bercut.TestClassTests");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        System.out.println("End!");

    }

    public static void runAllTests(String className) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> cls = Class.forName(className);

        if (!AnnotationUtils.checkTestClass(cls)) {
            System.out.println("Error: more than one annotation per method!");
            return;
        }

        for (Method test : AnnotationUtils.getMethodByAnnotations(cls, Test.class)) {

            Object obj = cls.getConstructor().newInstance();

            for (Method before : AnnotationUtils.getMethodByAnnotations(cls, Before.class)) {
                try {
                    before.invoke(obj);
                } catch (Exception e) {
                    System.out.println("Error occurred on " + before.getName() + " : " + e.getMessage());
                }
            }

            try {
                test.invoke(obj);
            } catch (Exception e) {
                System.out.println("Error occurred on " + test.getName() + " : " + e.getMessage());
            }

            for (Method after : AnnotationUtils.getMethodByAnnotations(cls, After.class)) {
                try {
                    after.invoke(obj);
                } catch (Exception e) {
                    System.out.println("Error occurred on " + after.getName() + " : " + e.getMessage());
                }
            }

        }

    }
}