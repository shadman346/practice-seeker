package com.shadman.practice.example;

import java.util.Random;

public class SentenceGenerator {

    private static final String[] subjects = {
            "The cat", "A dog", "The programmer", "An artist", "A student"
    };

    private static final String[] verbs = {
            "jumps over", "writes code for", "paints", "studies", "dreams about"
    };

    private static final String[] objects = {
            "the fence.", "a new app.", "a masterpiece.", "math problems.", "the future."
    };

    private static final Random random = new Random();

    public static String generateRandomSentence() {
        String subject = subjects[random.nextInt(subjects.length)];
        String verb = verbs[random.nextInt(verbs.length)];
        String object = objects[random.nextInt(objects.length)];
        return String.format("%s %s %s", subject, verb, object);
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(generateRandomSentence());
    }
}
