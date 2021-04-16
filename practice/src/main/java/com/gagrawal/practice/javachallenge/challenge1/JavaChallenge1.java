package com.gagrawal.practice.javachallenge.challenge1;

/**
 * Refer - https://medium.com/wolfie-javachallenge/java-challenge-1-7f4663939712
 * @author Gaurav
 * 14/04/21
 */
public class JavaChallenge1 {
    public static void main(String[] args) {
        Child child=new Child("Govinda",25);
        System.out.println("Name: "+child.name+", Age: "+child.age);
    }

    static abstract class Parent {
        String name;
        int age=24;
        static {
            System.out.println("Static Block - Parent");
        }
        {
            System.out.println("Non Static(Instance) Block1 - Parent");
        }
        {
            System.out.println("Non Static(Instance) Block2 - Parent");
        }
        Parent(String name, int age) {
            this.name = "Manvi";
            this.age = this.age;
            System.out.println("Parent");
        }
    }
    static class Child extends Parent{
        static {
            System.out.println("Static Block - Child");
        }

        {
            System.out.println("Non Static(Instance) Block - Child");
        }
        Child(String name, int age) {
            super(name,age);
            System.out.println("Name: "+name+", Age: "+age);
            System.out.println("Child");
        }
    }

    static  {
        System.out.println("Static Block - Main");
    }
    {
        System.out.println("Non Static(Instance) Block - Main");
    }
}
