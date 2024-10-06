package com.shadman.practice.funtional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalLambda {
    public static void main(String[] args) {
        int opt = 5;
        
        switch (opt){
            case 1:
                fun1();
                break;
            case 2:
                fun2();
                break;
            case 3:
                fun3();
                break;
            case 4:
                fun4();
                break;
            case 5:
                fun5();
                break;
        }
    }

    private static void fun1() {
        LambdaFunctionalInterface customFunctionalInterface = prop -> "hi this is inputed prop: " + prop;
        System.out.println(customFunctionalInterface.actionString("I am lambda function prop"));
    }

    private static void fun2() {
        // Consumer
        Consumer<Integer> integerConsumer = num -> System.out.println("I am: " + num);
        integerConsumer.accept(99);
    }

    private static void fun3() {
        // Supplier
        Supplier<String> stringSupplier = () -> "I am returning some supplies";
        System.out.println(stringSupplier.get());
    }

    private static void fun4() {
        // Function
        Function<Integer, String> integerToStringFunction = Object::toString;

        System.out.println(integerToStringFunction.apply(101));
    }

    private static void fun5() {
        // Predicate
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isGreater = num -> num > 50;
        System.out.println(isEven.and(isGreater).test(52));
    }
}
