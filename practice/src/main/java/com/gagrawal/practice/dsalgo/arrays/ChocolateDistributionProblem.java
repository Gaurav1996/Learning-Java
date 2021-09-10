package com.gagrawal.practice.dsalgo.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Ref - https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
 * @author Gaurav
 * 10/09/21
 */
public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        List<Long> packets = Arrays.asList(3L, 4L, 1L, 9L, 56L, 7L, 9L, 12L);
        int m = 5;
        printOutput(packets, m);
        printOutput(Arrays.asList(7L, 3L, 2L, 4L, 9L, 12L, 56L), 3);
    }

    private static void printOutput(List<Long> packets, int m) {
        System.out.println("For the array " + packets +
                "\nThe minimum difference between maximum chocolates and minimum chocolates for size : "
                + m + " is : " + findMinDiff(packets, m));
    }

    private static long findMinDiff(List<Long> packets, int m) {
        int k = m;
        int len = packets.size();
        Collections.sort(packets);
        long diff = packets.get(k-1) - packets.get(0);
        for(int i = k; i < len; i++) {
            diff = Math.min(diff, packets.get(i) - packets.get(i-k+1));
        }
        return diff;
    }
}
