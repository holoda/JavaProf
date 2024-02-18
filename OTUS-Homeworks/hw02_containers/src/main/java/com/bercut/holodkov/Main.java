package com.bercut.holodkov;

import com.bercut.holodkov.fruits.Fruit;
import com.bercut.holodkov.fruits.Orange;
import com.bercut.holodkov.fruits.Apple;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Box<Orange> bo = new Box<>();
        bo.addFruit(new Orange(1));
        bo.addFruit(new Orange(2));
        bo.addFruit(new Orange(3));
        bo.addFruit(new Orange(4));
        bo.addFruit(new Orange(5));
        bo.addFruit(new Orange(6));
        System.out.println("Box with oranges weight = " + bo.weight());

        Box<Apple> ba = new Box<>();
        ba.addFruit(new Apple(1));
        ba.addFruit(new Apple(2));
        ba.addFruit(new Apple(3));
        ba.addFruit(new Apple(4));
        ba.addFruit(new Apple(5));
        //  ba.addFruit(new Apple(6));
        System.out.println("Box with apples weight = " + ba.weight());

        System.out.println("Compare boxes = " + bo.compare(ba));

        Box<Orange> bo2 = new Box<>();
        bo2.addFruit(new Orange(1));
        bo2.addFruit(new Orange(2));
        bo2.addFruit(new Orange(3));
        System.out.println("Second box with apples weight = " + bo2.weight());

        bo.moveFruits(bo2);
        System.out.println("First box with oranges weight = " + bo.weight());
        System.out.println("Second box with oranges weight = " + bo2.weight());

        Box<Fruit> bf = new Box<>();
        bf.addFruit(new Orange(1));
        bf.addFruit(new Apple(2));
        bf.addFruit(new Apple(3));
        bf.addFruit(new Orange(4));
        bf.addFruit(new Orange(5));

        System.out.println("Box with fruits weight = " + bf.weight());

        System.out.println("Compare boxes = " + bf.compare(ba));
    }
}