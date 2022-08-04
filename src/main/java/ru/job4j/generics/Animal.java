package ru.job4j.generics;

import java.util.Objects;

public class Animal {
    private int age;
    private int weight;

    public Animal(int age, int weight) {
        this.age = age;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Animal animal = (Animal) o;
        return weight == animal.weight && Objects.equals(age, animal.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, weight);
    }
}
