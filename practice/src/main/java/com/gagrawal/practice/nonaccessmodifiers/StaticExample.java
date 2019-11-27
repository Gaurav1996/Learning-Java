package com.gagrawal.practice.nonaccessmodifiers;

public class StaticExample {
    public static int staticInt = 0;
    public int normalInt = 0;
    static {
        System.out.println("Hello from static block 1");
    }
    public StaticExample() {
        staticInt++;
        normalInt++;
        System.out.println("Hello from constructor!");
    }
    static {
        System.out.println("Hello from static block 2");
    }
}
