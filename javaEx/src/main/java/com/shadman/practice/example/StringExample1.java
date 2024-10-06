package com.shadman.practice.example;

public class StringExample1 {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println(str1 == str2); // 1
        System.out.println(str1.equals(str2)); // 2
        System.out.println(str1 == str3); // 3
        System.out.println(str1.equals(str3)); // 4
        System.out.println(str1 == str3.toString()); // 5

    }
}
