package com.shadman.practice.example;

//Tell output of the following code
public class StaticBlockEx1 {
    static {
        System.out.println(1/0);
    }
    public static void main(String[] args) {
        System.out.println("hi i am main");
    }
}
