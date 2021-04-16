package com.gagrawal.practice.quick;

/**
 * @author Gaurav
 * 24/03/21
 */
public class TestDeepCopy {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.setName("Gaurav");
        emp1.setEmpId(100L);
        System.out.println("Before copy Emp 1 - " + emp1.toString());
//        Employee emp2 = emp1;
//        emp2.setName("Gaurav Agrawal");
//        emp2.setEmpId(200L);
//        System.out.println("Shallow Copy done");
//        System.out.println("Emp 2 - " + emp2.toString());
//        System.out.println("Emp 1 - " + emp1.toString());

        Employee emp3 = new Employee(emp1);
        emp3.setName("Gaurav Agrawal");
        emp3.setEmpId(200L);
        System.out.println("Deep copy done");
        System.out.println("EMp 3 - " + emp3.toString());
        System.out.println("Emp 1 - " + emp1.toString());
    }
}
