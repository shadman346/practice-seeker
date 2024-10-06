package com.shadman.practice.example;

public class GenericExample {
    //How can I make method giveMeClassObjString to take any generic type object as a parameter
    // and return that object class name;

    // how can you modify this method to support any object and return it's class name
    public static void main(String[] args) {
        System.out.println(giveMeClassObjString(new GenericExample()));
    }

    static <T> String giveMeClassObjString(T obj){
        return obj.getClass().getName();
    }
}
