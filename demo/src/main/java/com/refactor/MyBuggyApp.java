package com.refactor;

/**
 * Hello world!
 *
 */
public class MyBuggyApp {
    public static void main(String[] args) {
        System.out.println("Hello Jfokus, exceptional crowd today!");
        if (args.length > 0 && args[0].equals("")) {
            new IllegalArgumentException();
        }
        System.out.println("First Argument: " + args[0]);

    }

    private static void doNothing() {
    }
}
