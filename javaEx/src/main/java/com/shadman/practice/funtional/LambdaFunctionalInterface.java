package com.shadman.practice.funtional;

/**
 * Functional Interface only has one abstract method
 * FunctionalInterface annotation over Interface LambdaFunctionalInterface is optional,
 * but it can help us to catch issue in compile time if interface is not properly structured.
 * Functional interfaces can have default methods other than one abstract method
 */
@FunctionalInterface
public interface LambdaFunctionalInterface {

    String actionString(String prop);
}

