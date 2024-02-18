package com.bercut.holodkov;

import com.bercut.holodkov.fruits.Fruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> box;

    public Box() {
        this.box = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        box.add(fruit);
    }

    public int weight() {
        int result = 0;
        for (int i = 0; i < box.size(); i++) {
            result += box.get(i).getWeight();
        }
        return result;
    }

    public boolean compare(Box<? extends Fruit> anotherBox) {
        if (anotherBox == null)
            return false;
        return weight() == anotherBox.weight();
    }

    public void moveFruits(Box<T> dest) {
        if (dest != null) {
            for (int i = 0; i < box.size(); i++) {
                dest.addFruit(box.get(i));
            }
            box.clear();
        }
    }

}
