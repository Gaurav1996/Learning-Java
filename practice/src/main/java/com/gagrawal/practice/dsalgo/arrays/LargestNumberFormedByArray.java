package com.gagrawal.practice.dsalgo.arrays;

import java.util.Arrays;

/**
 * Ref - https://leetcode.com/problems/largest-number/
 * @author Gaurav
 * 12/08/21
 */
public class LargestNumberFormedByArray {
    public static void main(String[] args) {
        int[] arr = {10,2};
        System.out.println("Largest number formed by the array is : " + largestNumber(arr));
    }

    private static String largestNumber(int[] arr) {
        String result = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .sorted((a,b) -> (b + a).compareTo(a + b))
                .reduce((a, b) -> a + b)
                .get();
        return result.startsWith("0") ? "0" : result;
    }
}
