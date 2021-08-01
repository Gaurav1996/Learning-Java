package com.gagrawal.practice.quick;

import java.util.Collections;
import java.util.List;

/**
 * @author Gaurav
 * 10/05/21
 */
public class NullSingletonList {
    public static void main(String[] args) {
        Employee emp = null;
        List<Employee> employees = Collections.singletonList(emp);
        System.out.println(employees.isEmpty());
    }
}
