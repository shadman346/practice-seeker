package com.shadman.practice.example;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetExample1 {

    // What change should we make in Person class to make hashset consider
    // the Person object is same if the name and age is same, regardless of person hobby;
    public static void main(String[] args) {

        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person("Anupam", 23, "cricket"));
        personSet.add(new Person("Alice", 22, "singing"));
        personSet.add(new Person("Thomas", 25, "baseball"));
        personSet.add(new Person("Anupam", 23, "gaming"));

        personSet.forEach(System.out::println);
    }

    public static class Person{
        String name;
        int age;
        String hobby;

        Person(String name, int age, String hobby){
            this.name = name;
            this.age = age;
            this.hobby= hobby;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", hobby='" + hobby + '\'' +
                    '}';
        }
    }
}
