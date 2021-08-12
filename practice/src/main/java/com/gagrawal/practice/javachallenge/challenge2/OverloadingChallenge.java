package com.gagrawal.practice.javachallenge.challenge2;

/**
 * @author Gaurav
 * 10/08/21
 */
public class OverloadingChallenge {
    public static void main(String[] args) {
        method(null);
    }
    private static void method(Object o) {
        System.out.println("From Object method");
    }
    private static void method(String s) {
        System.out.println("From String method");
    }
}
