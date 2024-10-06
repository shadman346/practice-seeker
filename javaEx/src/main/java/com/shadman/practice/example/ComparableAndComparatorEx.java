package com.shadman.practice.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableAndComparatorEx {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("shadman", 24, 22));
        personList.add(new Person("faizan", 25,24));
        personList.add(new Person("Aaditya", 22,21));
        personList.add(new Person("ley", 30,26));

        personList.forEach(System.out::println);
        System.out.println("=========");
        Collections.sort(personList, (o1, o2) -> {
            return o1.joinAge - o2.joinAge;
        });
        personList.forEach(System.out::println);

    }

    public static class Person implements Comparable<Person>{
        String name;
        int age;
        int joinAge;
        Person(String name, int age, int joinAge){
            this.name = name;
            this.age = age;
            this.joinAge = joinAge;
        }

        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", joinAge=" + joinAge +
                    '}';
        }
    }

    public static class PersonComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.joinAge - o2.joinAge;
        }
    }
}
