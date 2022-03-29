package com.gagrawal.practice.quick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Gaurav
 * 24/09/21
 */
public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        Collection<Integer> list = new CopyOnWriteArrayList<>(Collections.unmodifiableList(Arrays.asList(1, 2, 3, 4)));
        list.removeIf(i -> list.remove(3));
        System.out.println("List " + list);

        /**
         * On Java 8 that would be [2, 3, 4].
         *
         * But more recent versions of the JDK improved their checks for ConcurrentModificationException.
         *
         * Btw, ArrayList<>() throws CME in Java 8 itself
         */
    }
}
