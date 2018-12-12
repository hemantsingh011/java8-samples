package com.github.samples.collection_sample;

public class Person {
    private final String name;
    private final Gender male;
    private final int age;

    public Person(String name, Gender male, int age) {

        this.name = name;
        this.male = male;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Gender getMale() {
        return male;
    }

    public int getAge() {
        return age;
    }
}
